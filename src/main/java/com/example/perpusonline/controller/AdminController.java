package com.example.perpusonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/buku")
    public String dashboard(){ return "admin/dashboard"; }
}
