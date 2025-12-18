package com.example.perpusonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.perpusonline.model.Buku;
import com.example.perpusonline.repository.BukuRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/buku")
public class AdminBukuApiController {

    @Autowired
    private BukuRepository bukuRepository;

    // ===============================================
    // 1. GET (READ)
    // URL: /api/admin/buku/data
    // ===============================================
    @GetMapping("/data")
    public Iterable<Buku> getDataBuku() {
        return bukuRepository.findAll();
    }

    // ===============================================
    // 2. POST (CREATE)
    // URL: /api/admin/buku/save
    // ===============================================
    @PostMapping("/save")
    public Buku saveBuku(@RequestBody Buku buku) {
        return bukuRepository.save(buku);
    }

    // ===============================================
    // 2B. POST (CREATE MANY)
    // URL: /api/admin/buku/saveAll
    // ===============================================
    @PostMapping("/saveAll")
    public Iterable<Buku> saveAll(@RequestBody Iterable<Buku> bukuList) {
        // Validasi ringan
        for (Buku buku : bukuList) {
            if (buku.getJudul() == null || buku.getJudul().trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Judul buku tidak boleh kosong");
            }
        }
        return bukuRepository.saveAll(bukuList);
    }

    // ===============================================
    // 3. PUT (UPDATE)
    // URL: /api/admin/buku/update/{id}
    // ===============================================
    @PutMapping("/update/{id}")
    public Buku updateBuku(@PathVariable Long id, @RequestBody Buku updatedBuku) {
        Optional<Buku> existingBuku = bukuRepository.findById(id);

        if (existingBuku.isPresent()) {
            Buku buku = existingBuku.get();
            buku.setJudul(updatedBuku.getJudul());
            buku.setPenulis(updatedBuku.getPenulis());
            buku.setPenerbit(updatedBuku.getPenerbit());
            buku.setTahun(updatedBuku.getTahun());
            buku.setKategori(updatedBuku.getKategori());
            buku.setStok(updatedBuku.getStok());
            buku.setDeskripsi(updatedBuku.getDeskripsi());
            return bukuRepository.save(buku);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku dengan ID " + id + " tidak ditemukan.");
        }
    }

    // ===============================================
    // 4. DELETE
    // URL: /api/admin/buku/delete/{id}
    // ===============================================
    @DeleteMapping("/delete/{id}")
    public void deleteBuku(@PathVariable Long id) {
        if (!bukuRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku dengan ID " + id + " tidak ditemukan.");
        }
        bukuRepository.deleteById(id);
    }
}
