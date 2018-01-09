package com.noobug.Nooblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminRouteController {
    @RequestMapping("/{path}")
    public String route(@PathVariable String path) {
        return "admin/" + path;
    }
}
