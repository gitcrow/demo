package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Droid;

@RestController
@RequestMapping("/droid")
public class DroidController {
    private final Droid droid;
    
    public DroidController(Droid droid){
        this.droid = droid;
    }

    @GetMapping
    Droid getDroid(){
        return this.droid;
    }
}
