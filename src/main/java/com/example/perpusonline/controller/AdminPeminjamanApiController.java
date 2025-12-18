package com.example.perpusonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.perpusonline.model.Peminjaman; 
import com.example.perpusonline.repository.PeminjamanRepository; 

import java.util.Optional;
import java.time.LocalDate; // Diperlukan untuk set Tanggal Kembali

@RestController
@RequestMapping("/api/admin/peminjaman")
public class AdminPeminjamanApiController {

    @Autowired 
    private PeminjamanRepository peminjamanRepository; 

    // ===============================================
    // 1. GET (READ) - URL: /api/admin/peminjaman/data
    // ===============================================
    @GetMapping("/data") 
    public Iterable<Peminjaman> getDataPeminjaman() {
        return peminjamanRepository.findAll();
    }
    
    // ===============================================
    // 2. PUT (UPDATE) - Mengubah Status Menjadi "Dikembalikan"
    // URL: /api/admin/peminjaman/return/{id}
    // ===============================================
    @PutMapping("/return/{id}")
    public Peminjaman returnBuku(@PathVariable Long id) {
        // Logika untuk mengubah status peminjaman menjadi Dikembalikan
        
        Optional<Peminjaman> peminjamanOptional = peminjamanRepository.findById(id);
        
        if (peminjamanOptional.isPresent()) {
            Peminjaman peminjaman = peminjamanOptional.get();
            
            // Logika Bisnis: Hanya proses jika status saat ini masih "Dipinjam"
            if (!"Dikembalikan".equals(peminjaman.getStatus())) {
                peminjaman.setStatus("Dikembalikan");
                // Set tanggal kembali ke tanggal saat ini
                peminjaman.setTanggalKembali(LocalDate.now()); 
                
                // Catatan: Jika Anda memiliki logika penambahan stok buku, 
                // ini adalah tempat yang tepat untuk memanggil service/repository Buku.
                
                return peminjamanRepository.save(peminjaman);
            }
            
            // Jika sudah dikembalikan, kembalikan objek tanpa update
            return peminjaman; 
        }
        
        // Jika ID tidak ditemukan, kembalikan HTTP 404 (Not Found)
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Peminjaman tidak ditemukan.");
    }

    // ===============================================
    // 3. DELETE - URL: /api/admin/peminjaman/delete/{id}
    // ===============================================
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Mengembalikan 204 No Content jika sukses
    public void deletePeminjaman(@PathVariable Long id) {
        if (!peminjamanRepository.existsById(id)) {
            // Jika ID tidak ditemukan, kembalikan HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Peminjaman tidak ditemukan.");
        }
        peminjamanRepository.deleteById(id);
    }
}