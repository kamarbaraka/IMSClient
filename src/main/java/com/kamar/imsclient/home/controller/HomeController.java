package com.kamar.imsclient.home.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * the home page controller.
 * @author kamar baraka.*/


@Controller
@Log4j2
@RequestMapping(value = {"/", "/home"})
public class HomeController {


    @GetMapping
    public String home(OAuth2AuthenticationToken token, Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        /*add username attribute to the view*/
        String username = token.getName();
        model.addAttribute("username", username);
        log.info(authentication.getPrincipal());

        return "home";

    }
}
