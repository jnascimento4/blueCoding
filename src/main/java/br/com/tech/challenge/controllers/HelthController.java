package br.com.tech.challenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelthController {

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("Service working!");
    }
}
