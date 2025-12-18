package com.example.perpusonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.perpusonline.model.Peminjaman;
import com.example.perpusonline.model.Buku;
import com.example.perpusonline.repository.PeminjamanRepository;
import com.example.perpusonline.repository.BukuRepository;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/peminjaman") // Jalur API untuk form peminjaman user
public class UserPeminjamanApiController {

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private BukuRepository bukuRepository;

    // Inner class/DTO untuk menerima data sederhana dari form User
    public static class PeminjamanRequest {
        // Nama field harus sesuai dengan yang dikirim di JavaScript (bukuId, namaPeminjam)
        public Long bukuId;
        public String namaPeminjam;
    }

    @PostMapping("/save")
    public Peminjaman savePeminjaman(@RequestBody PeminjamanRequest request) {
        
        // 1. Cari buku berdasarkan ID
        Optional<Buku> bukuOptional = bukuRepository.findById(request.bukuId);
        
        if (bukuOptional.isPresent()) {
            Buku buku = bukuOptional.get();
            
            // 2. Cek Stok (Logika Bisnis)
            if (buku.getStok() <= 0) {
                // Lempar HTTP 400 Bad Request
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stok buku habis."); 
            }
            
            // 3. Kurangi Stok
            buku.setStok(buku.getStok() - 1);
            bukuRepository.save(buku); // Simpan perubahan stok

            // 4. Simpan Peminjaman
            Peminjaman peminjaman = new Peminjaman();
            peminjaman.setBuku(buku); // Relasi ke objek Buku
            peminjaman.setNamaPeminjam(request.namaPeminjam);
            peminjaman.setTanggalPinjam(LocalDate.now());
            peminjaman.setTanggalKembali(LocalDate.now().plusDays(7)); // 7 hari pinjam
            peminjaman.setStatus("Dipinjam");
            
            return peminjamanRepository.save(peminjaman);
            
        } else {
            // Lempar HTTP 404 Not Found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku tidak ditemukan.");
        }
    }
}