package com.example.datacollector.controller;

import com.example.datacollector.swing.DialogUI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FPController {
    @GetMapping("/fp")
    public void fp(){
        new DialogUI();
    }
}
