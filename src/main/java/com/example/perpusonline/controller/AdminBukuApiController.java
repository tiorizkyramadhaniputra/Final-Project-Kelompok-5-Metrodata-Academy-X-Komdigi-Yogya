package com.example.perpusonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.perpusonline.model.Buku; 
import com.example.perpusonline.repository.BukuRepository; 

import java.util.Optional;

@RestController 
@RequestMapping("/api/admin/buku") // Jalur dasar API: /api/admin/buku
public class AdminBukuApiController {

    @Autowired
    private BukuRepository bukuRepository;

    // ===============================================
    // 1. GET (READ) - Dipanggil oleh DataTables
    // URL: /api/admin/buku/data
    // ===============================================
    @GetMapping("/data") 
    public Iterable<Buku> getDataBuku() {
        // Mengembalikan daftar buku dalam format JSON
        return bukuRepository.findAll();
    }

    // ===============================================
    // 2. POST (CREATE) - Dipanggil saat Tambah Buku
    // URL: /api/admin/buku/save
    // ===============================================
    @PostMapping("/save")
    public Buku saveBuku(@RequestBody Buku buku) {
        // Catatan: Asumsi field ID diabaikan atau diset null oleh frontend
        return bukuRepository.save(buku);
    }
    
    // ===============================================
    // 3. PUT (UPDATE) - Dipanggil saat Edit Buku
    // URL: /api/admin/buku/update/{id}
    // ===============================================
    @PutMapping("/update/{id}")
    public Buku updateBuku(@PathVariable Long id, @RequestBody Buku updatedBuku) {
        Optional<Buku> existingBuku = bukuRepository.findById(id);
        
        if (existingBuku.isPresent()) {
            Buku buku = existingBuku.get();
            
            // Perbarui properti buku yang diterima dari frontend
            buku.setJudul(updatedBuku.getJudul());
            buku.setPenulis(updatedBuku.getPenulis());
            buku.setPenerbit(updatedBuku.getPenerbit());
            buku.setTahun(updatedBuku.getTahun());
            buku.setKategori(updatedBuku.getKategori());
            buku.setStok(updatedBuku.getStok());
            buku.setDeskripsi(updatedBuku.getDeskripsi());
            
            // Simpan perubahan (operasi UPDATE)
            return bukuRepository.save(buku);
        } else {
            // Jika ID tidak ditemukan, kembalikan HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku dengan ID " + id + " tidak ditemukan.");
        }
    }

    // ===============================================
    // 4. DELETE (DELETE) - Dipanggil saat Hapus Buku
    // URL: /api/admin/buku/delete/{id}
    // ===============================================
    @DeleteMapping("/delete/{id}")
    public void deleteBuku(@PathVariable Long id) {
        if (!bukuRepository.existsById(id)) {
             // Jika ID tidak ditemukan, kembalikan HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku dengan ID " + id + " tidak ditemukan.");
        }
        bukuRepository.deleteById(id);
    }
}