package com.hitaek.springSecurityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/showMySigninPage")
    public String showMySigninPage(){

        return "bootstrap-login";

    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied(){

        return "access-denied";

    }
}
