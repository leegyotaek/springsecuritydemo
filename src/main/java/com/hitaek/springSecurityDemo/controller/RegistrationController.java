package com.hitaek.springSecurityDemo.controller;

import com.hitaek.springSecurityDemo.entity.User;
import com.hitaek.springSecurityDemo.service.UserService;
import com.hitaek.springSecurityDemo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("crmUser", new CrmUser());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult theBindingResult,
            Model theModel) {

    // form validation
    if (theBindingResult.hasErrors()) {
        return "registration-form";
    }

    // check the database if user already exists
    User existing = userService.findByUserName(theCrmUser.getUserName());

    if(existing!=null) {
        theModel.addAttribute("crmUser", new CrmUser());

        theModel.addAttribute("registrationError" , "User name already exists.");

        return "registration-form";
    }

    // save user in the database
    userService.save(theCrmUser);

    return "registration-confirmation";

    }

}
