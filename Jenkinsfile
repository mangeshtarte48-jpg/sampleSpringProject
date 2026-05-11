pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t sample-spring-app:latest .'
            }
        }

        stage('Deploy using Docker Compose') {
            steps {
                sh '''
                docker-compose down || true
                docker-compose up -d --build
                '''
            }
        }
    }

    post {
        success {
            echo "Pipeline SUCCESS 🚀"
        }
        failure {
            echo "Pipeline FAILED ❌"
        }
    }
}