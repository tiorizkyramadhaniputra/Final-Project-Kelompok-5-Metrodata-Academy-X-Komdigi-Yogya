package com.example.perpusonline.controller;

import com.example.perpusonline.model.Buku;
import com.example.perpusonline.model.Peminjaman;
import com.example.perpusonline.repository.BukuRepository;
import com.example.perpusonline.repository.PeminjamanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/peminjaman")
@CrossOrigin(origins = "*")
public class PeminjamanController {

    private final PeminjamanRepository peminjamanRepository;
    private final BukuRepository bukuRepository;

    public PeminjamanController(PeminjamanRepository peminjamanRepository, BukuRepository bukuRepository) {
        this.peminjamanRepository = peminjamanRepository;
        this.bukuRepository = bukuRepository;
    }

    // 🔹 Ambil semua data peminjaman
    @GetMapping
    public ResponseEntity<List<Peminjaman>> getAll() {
        List<Peminjaman> data = peminjamanRepository.findAll();
        return ResponseEntity.ok(data);
    }

    // 🔹 Tambah peminjaman baru
    @PostMapping
    public ResponseEntity<?> tambahPeminjaman(@RequestBody Peminjaman peminjaman) {
        try {
            if (peminjaman.getBuku() == null || peminjaman.getBuku().getId() == null) {
                return ResponseEntity.badRequest().body("ID buku harus disertakan");
            }

            Buku buku = bukuRepository.findById(peminjaman.getBuku().getId())
                    .orElseThrow(() -> new RuntimeException("Buku tidak ditemukan"));

            // Kurangi stok buku kalau masih tersedia
            if (buku.getStok() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stok buku habis");
            }
            buku.setStok(buku.getStok() - 1);
            bukuRepository.save(buku);

            peminjaman.setBuku(buku);
            peminjaman.setTanggalPinjam(LocalDate.now());
            peminjaman.setTanggalKembali(LocalDate.now().plusDays(7)); // default 7 hari
            peminjaman.setStatus("Dipinjam");

            Peminjaman saved = peminjamanRepository.save(peminjaman);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Gagal menambah peminjaman: " + e.getMessage());
        }
    }

    // 🔹 Kembalikan buku
    @PutMapping("/{id}/kembali")
    public ResponseEntity<?> kembalikanBuku(@PathVariable Long id) {
        try {
            Peminjaman p = peminjamanRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Peminjaman tidak ditemukan"));

            if (!"Dipinjam".equals(p.getStatus())) {
                return ResponseEntity.badRequest().body("Buku ini sudah dikembalikan sebelumnya");
            }

            p.setStatus("Dikembalikan");

            // Tambahkan stok kembali ke buku
            Buku buku = p.getBuku();
            buku.setStok(buku.getStok() + 1);
            bukuRepository.save(buku);

            Peminjaman updated = peminjamanRepository.save(p);
            return ResponseEntity.ok(updated);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Gagal mengembalikan buku: " + e.getMessage());
        }
    }
}
