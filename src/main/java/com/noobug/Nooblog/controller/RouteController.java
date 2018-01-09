package com.noobug.Nooblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin() {
        return "admin_login";
    }
}
