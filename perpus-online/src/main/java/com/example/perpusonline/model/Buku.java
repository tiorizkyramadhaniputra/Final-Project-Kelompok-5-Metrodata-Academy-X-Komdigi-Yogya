package com.example.perpusonline.model;

import jakarta.persistence.*;

@Entity
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String judul;
    private String penulis;
    private String penerbit;
    private Integer tahun;
    private String kategori;
    private Integer stok;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    private String gambar;

    public Buku() {}

    // ✅ Constructor tambahan buat DataSeeder
    public Buku(Long id, String judul, String penulis, String penerbit, Integer tahun,
                String kategori, Integer stok, String deskripsi, String gambar) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.kategori = kategori;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) { this.penulis = penulis; }

    public String getPenerbit() { return penerbit; }
    public void setPenerbit(String penerbit) { this.penerbit = penerbit; }

    public Integer getTahun() { return tahun; }
    public void setTahun(Integer tahun) { this.tahun = tahun; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public Integer getStok() { return stok; }
    public void setStok(Integer stok) { this.stok = stok; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getGambar() { return gambar; }
    public void setGambar(String gambar) { this.gambar = gambar; }
}
