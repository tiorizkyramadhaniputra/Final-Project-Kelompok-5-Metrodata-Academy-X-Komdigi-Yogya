package com.example.perpusonline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.perpusonline.model.Buku;
import com.example.perpusonline.repository.BukuRepository;

@Service
public class BukuService {
    private final BukuRepository repo;
    public BukuService(BukuRepository repo){ this.repo = repo; }

    public List<Buku> findAll(){ return repo.findAll(); }
    public Optional<Buku> findById(Long id){ return repo.findById(id); }
    public Buku save(Buku buku){ return repo.save(buku); }
    public void deleteById(Long id){ repo.deleteById(id); }
    public List<Buku> search(String q){ return repo.findByJudulContainingIgnoreCaseOrPenulisContainingIgnoreCaseOrKategoriContainingIgnoreCase(q,q,q); }
}
