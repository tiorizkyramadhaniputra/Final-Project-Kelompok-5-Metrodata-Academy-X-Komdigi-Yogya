package com.example.perpusonline.repository;

import com.example.perpusonline.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Long> {

    // 🔍 Method custom pencarian 3 kolom sekaligus
    List<Buku> findByJudulContainingIgnoreCaseOrPenulisContainingIgnoreCaseOrKategoriContainingIgnoreCase(
        String judul,
        String penulis,
        String kategori
    );
}
