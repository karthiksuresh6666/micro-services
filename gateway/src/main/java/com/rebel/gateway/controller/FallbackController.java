package com.rebel.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/vaccineServiceFallBack")
    public ResponseEntity<String> vaccineServiceFallBack() {
        return ResponseEntity.ok("Vaccine service is currently unavailable!. Please try again later.");
    }

    @GetMapping("/citizenServiceFallBack")
    public ResponseEntity<String> citizenServiceFallBack() {
        return ResponseEntity.ok("Citizen service is currently unavailable!. Please try again later.");
    }

    @PostMapping("/vaccineServiceFallBack")
    public ResponseEntity<String> vaccineServiceFallBackP() {
        return ResponseEntity.ok("Vaccine service is currently unavailable!. Please try again later.");
    }

    @PostMapping("/citizenServiceFallBack")
    public ResponseEntity<String> citizenServiceFallBackP() {
        return ResponseEntity.ok("Citizen service is currently unavailable!. Please try again later.");
    }
}
