package com.example.sampleSpringProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DockerSampleProjectController {

    @GetMapping("/hello")
    public String getName() {
        return "this is project for CI/CD practise";
    }
}
