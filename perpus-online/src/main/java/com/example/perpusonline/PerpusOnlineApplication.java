package com.example.perpusonline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.perpusonline.model.Buku;
import com.example.perpusonline.repository.BukuRepository;

@SpringBootApplication
public class PerpusOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerpusOnlineApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BukuRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                Buku b1 = new Buku();
                b1.setJudul("Pemrograman Java");
                b1.setPenulis("Budi");
                b1.setPenerbit("Erlangga");
                b1.setTahun(2020);
                b1.setKategori("Pemrograman");
                b1.setStok(5);
                b1.setDeskripsi("Buku belajar Java dasar hingga lanjut.");
                repo.save(b1);

                Buku b2 = new Buku();
                b2.setJudul("Basis Data");
                b2.setPenulis("Siti");
                b2.setPenerbit("Andi");
                b2.setTahun(2019);
                b2.setKategori("Database");
                b2.setStok(3);
                b2.setDeskripsi("Materi DBMS dan praktek SQL.");
                repo.save(b2);
            }
        };
    }
}
