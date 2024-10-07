package com.example.demolibrary.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope(scopeName = "prototype")
public class MainController {
    @GetMapping("/")
    public String getHome() {
        return "index";
    }
    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }
    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

}
