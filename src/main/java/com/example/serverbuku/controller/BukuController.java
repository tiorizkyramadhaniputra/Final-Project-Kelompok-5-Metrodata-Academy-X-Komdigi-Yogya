package com.example.serverbuku.controller;

import com.example.serverbuku.model.Buku;
import com.example.serverbuku.repository.BukuRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
@CrossOrigin(origins = "*")
public class BukuController {

    private final BukuRepository repo;

    public BukuController(BukuRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Buku> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Buku create(@RequestBody Buku buku) {
        return repo.save(buku);
    }

    @GetMapping("/{id}")
    public Buku getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Buku update(@PathVariable Long id, @RequestBody Buku buku) {
        buku.setId(id);
        return repo.save(buku);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
