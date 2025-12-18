package com.example.perpusonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; // <--- PASTIKAN INI ADA

import com.example.perpusonline.model.Buku;
import com.example.perpusonline.repository.BukuRepository;

@RestController // <--- PASTIKAN INI ADA
@RequestMapping("/api/katalog") // <--- PASTIKAN INI ADA
public class KatalogApiController {

    @Autowired
    private BukuRepository bukuRepository;

    @GetMapping("/buku") // <--- PASTIKAN INI ADA
    public Iterable<Buku> getKatalogBuku() {
        return bukuRepository.findAll();
    }
}