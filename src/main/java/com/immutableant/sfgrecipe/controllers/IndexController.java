package com.immutableant.sfgrecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"","/","/index"})
    public String getindexPage() {
        System.out.println("Some Message to say... ");
        return "index";
    }
}
