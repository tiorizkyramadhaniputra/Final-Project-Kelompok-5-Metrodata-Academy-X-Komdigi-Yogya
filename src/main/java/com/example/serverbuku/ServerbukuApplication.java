package com.example.serverbuku;

import com.example.serverbuku.model.Buku;
import com.example.serverbuku.repository.BukuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerbukuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerbukuApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(BukuRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Buku("Laskar Pelangi", "Andrea Hirata", "Bentang", "2005", "Novel", 10, "Novel inspiratif tentang anak-anak Belitung"));
                repo.save(new Buku("Bumi Manusia", "Pramoedya Ananta Toer", "Lentera Dipantara", "1980", "Sastra", 8, "Karya besar sastra Indonesia"));
                repo.save(new Buku("Dilan 1990", "Pidi Baiq", "Pastel Books", "2014", "Romansa", 12, "Kisah cinta anak SMA Bandung era 90an"));
            }
        };
    }
}
