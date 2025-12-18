package com.example.perpusonline.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaPeminjam;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private String status;

    @ManyToOne
    @JoinColumn(name = "buku_id")
    private Buku buku;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaPeminjam() { return namaPeminjam; }
    public void setNamaPeminjam(String namaPeminjam) { this.namaPeminjam = namaPeminjam; }

    public LocalDate getTanggalPinjam() { return tanggalPinjam; }
    public void setTanggalPinjam(LocalDate tanggalPinjam) { this.tanggalPinjam = tanggalPinjam; }

    public LocalDate getTanggalKembali() { return tanggalKembali; }
    public void setTanggalKembali(LocalDate tanggalKembali) { this.tanggalKembali = tanggalKembali; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Buku getBuku() { return buku; }
    public void setBuku(Buku buku) { this.buku = buku; }
}
