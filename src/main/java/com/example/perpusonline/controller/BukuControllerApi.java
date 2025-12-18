package com.example.perpusonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BukuControllerApi {

    // 🔹 Menampilkan halaman daftar buku untuk user
    @GetMapping({"/", "/user"})
    public String index() {
        return "user/buku-list"; 
    }

    
    @GetMapping("/user/detail")
    public String detail() {
        return "user/buku-detail"; // misal buat tampilan detail buku
    }
}
