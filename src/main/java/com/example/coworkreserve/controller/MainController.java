package com.example.coworkreserve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("El backend está funcionando correctamente");
    }
}
