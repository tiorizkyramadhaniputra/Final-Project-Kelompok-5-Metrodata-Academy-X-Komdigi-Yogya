package com.example.perpusonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserViewController {

    // 🔹 Halaman utama user
    @GetMapping({"", "/", "/index"})
    public String index() {
        return "user/index"; // templates/user/index.html
    }

    // 🔹 Halaman daftar buku
    @GetMapping("/buku")
    public String daftarBuku() {
        return "user/buku-list"; // templates/user/buku-list.html
    }

    // 🔹 Halaman detail buku
    @GetMapping("/buku/detail")
    public String detailBuku() {
        return "user/detail"; // templates/user/detail.html
    }

    // 🔹 Halaman login user
    @GetMapping("/login")
    public String login() {
        return "user/login"; // templates/user/login.html
    }

    // 🔹 Redirect root ke /user/index
    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/user/index";
    }
}
