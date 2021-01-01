package com.hitaek.springSecurityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/usersettings")
    public String showUserSettings(){

        return "usersettings";
    }

    @GetMapping("/systemsettings")
    public String showSystemSettings(){

        return "systemsettings";
    }
}
