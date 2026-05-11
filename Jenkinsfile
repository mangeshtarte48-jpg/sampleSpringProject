pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    environment {
        IMAGE_NAME = "sample-spring-app"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/mangeshtarte48-jpg/sampleSpringProject.git'
            }
        }

        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                docker build -t ${IMAGE_NAME}:latest .
                """
            }
        }

        stage('Verify Image') {
            steps {
                sh 'docker images'
            }
        }

        stage('Deploy using Docker Compose') {
            steps {
                sh """
                docker-compose down || true
                docker-compose up -d --build
                """
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