package com.example.datacollector.controller;

import com.example.datacollector.domain.User;
import com.example.datacollector.swing.WebcamUI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@RequestParam(value = "profileImage") Optional<String> profileImg, Model model){
        model.addAttribute("user",new User());
        model.addAttribute("profileImg", profileImg);
        return "index";
    }

    @ResponseBody
    @PostMapping("/")
    public void postIndex(@ModelAttribute(value="user") User user) {
        System.out.println(user.toString());
    }
    @ResponseBody
    @GetMapping("/webcam")
    public ModelAndView webcam(ModelMap attr){
        WebcamUI dui = new WebcamUI();
        dui.showWebcamUI();
        String profileImage =  dui.getImageName().replace(":","-");
        attr.addAttribute("profileImage",profileImage);
        return new ModelAndView ("redirect:/", attr);
    }
}
