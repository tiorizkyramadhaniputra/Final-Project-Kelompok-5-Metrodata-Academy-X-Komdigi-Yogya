package com.example.perpusonline.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/buku")
@CrossOrigin(origins = "*")
public class BukuUserProxyController {

    // ✅ ubah ke ${api.buku}, bukan ${server.api.buku}
    @Value("${api.buku}")
    private String bukuApiUrl; // contoh: http://localhost:9000/api/buku

    private final RestTemplate restTemplate = new RestTemplate();

    // 🔹 Ambil semua data buku (untuk user)
    @GetMapping
    public String getAll() {
        return restTemplate.getForObject(bukuApiUrl, String.class);
    }

    // 🔹 Ambil detail buku by ID
    @GetMapping("/{id}")
    public String getById(@PathVariable Long id) {
        return restTemplate.getForObject(bukuApiUrl + "/" + id, String.class);
    }

    // 🔹 Pencarian buku
    @GetMapping("/search")
    public String search(@RequestParam String q) {
        return restTemplate.getForObject(bukuApiUrl + "/search?q=" + q, String.class);
    }
}
