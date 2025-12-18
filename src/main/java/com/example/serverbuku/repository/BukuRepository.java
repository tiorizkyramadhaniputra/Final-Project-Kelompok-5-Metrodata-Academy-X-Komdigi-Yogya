package com.example.serverbuku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.serverbuku.model.Buku;

public interface BukuRepository extends JpaRepository<Buku, Long> {
}
