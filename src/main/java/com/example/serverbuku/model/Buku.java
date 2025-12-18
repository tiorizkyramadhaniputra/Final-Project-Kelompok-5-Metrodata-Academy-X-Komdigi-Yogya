package com.example.serverbuku.model;

import jakarta.persistence.*;

@Entity
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String judul;
    private String penulis;
    private String penerbit;
    private String tahun;
    private String kategori;
    private int stok;
    private String deskripsi;

    public Buku() {
    }

    public Buku(String judul, String penulis, String penerbit, String tahun, String kategori, int stok, String deskripsi) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.kategori = kategori;
        this.stok = stok;
        this.deskripsi = deskripsi;
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

    public String getTahun() { return tahun; }
    public void setTahun(String tahun) { this.tahun = tahun; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
}
