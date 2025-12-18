package com.example.perpusonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    // 🔹 Halaman Dashboard
    @GetMapping({"", "/", "/dashboard"})
    public String dashboard() {
        return "admin/dashboard"; // templates/admin/dashboard.html
    }

    // 🔹 Halaman Peminjaman (daftar buku dipinjam, kelola status, dsb)
    @GetMapping("/peminjaman")
    public String peminjaman() {
        return "admin/peminjaman"; // templates/admin/peminjaman.html
    }

    // 🔹 Halaman Riwayat Peminjaman
    @GetMapping("/riwayat")
    public String riwayat() {
        return "admin/riwayat"; // templates/admin/riwayat.html
    }
}
