package com.ucm.thesis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthCheckController {

    @GetMapping("health/check")
    public ResponseEntity<String> checkAppStatus() {
        return new ResponseEntity<>("Healthy from App .", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }


}