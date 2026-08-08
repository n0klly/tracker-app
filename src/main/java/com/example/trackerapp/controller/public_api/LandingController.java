package com.example.trackerapp.controller.public_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LandingController {
    @GetMapping
    public void showLanding(){
        //
    }
}
