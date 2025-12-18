package com.example.serverbuku.repository;

import com.example.serverbuku.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<Buku, Long> {
}
