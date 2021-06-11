package com.example.datacollector.controller;

import com.example.datacollector.model.User;
import com.example.datacollector.swing.WebcamUI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String postIndex(@RequestBody User user) {
        System.out.println(user.toString());
        return "index";
    }
    @ResponseBody
    @GetMapping("/webcam")
    public void webcam(){
        WebcamUI dui = new WebcamUI();
        dui.showWebcamUI();
    }
}
