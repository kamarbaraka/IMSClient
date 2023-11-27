package com.kamar.imsclient.home.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * the home page controller.
 * @author kamar baraka.*/


@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {


    @GetMapping
    public String home(@AuthenticationPrincipal UserDetails authenticatedUser, Model model){

        /*add username attribute to the view*/
        String username = authenticatedUser.getUsername();
        model.addAttribute("username", username);

        return "home";

    }
}
