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
                repo.save(new Buku("Laskar Pelangi", "Andrea Hirata", "Bentang", "2005", "Novel", 10, "Kisah inspiratif anak-anak Belitung."));
                repo.save(new Buku("Bumi Manusia", "Pramoedya Ananta Toer", "Lentera Dipantara", "1980", "Sastra", 8, "Perjuangan Minke di masa kolonial."));
                repo.save(new Buku("Dilan 1990", "Pidi Baiq", "Pastel Books", "2014", "Romansa", 12, "Kisah cinta remaja Bandung era 90an."));
                repo.save(new Buku("Cantik Itu Luka", "Eka Kurniawan", "Gramedia", "2002", "Sastra", 5, "Kisah legendaris penuh simbol dan makna."));
                repo.save(new Buku("Negeri 5 Menara", "Ahmad Fuadi", "Gramedia", "2009", "Motivasi", 9, "Semangat menuntut ilmu dari enam santri."));
                repo.save(new Buku("Filosofi Kopi", "Dee Lestari", "Bentang", "2006", "Cerpen", 7, "Kumpulan cerita pendek penuh makna hidup."));
                repo.save(new Buku("Hujan", "Tere Liye", "Gramedia", "2016", "Fiksi", 11, "Kisah cinta di tengah bencana dan kehilangan."));
                repo.save(new Buku("Ronggeng Dukuh Paruk", "Ahmad Tohari", "Gramedia", "1982", "Sastra", 6, "Kehidupan Srintil di desa kecil Jawa."));
                repo.save(new Buku("Ayat-Ayat Cinta", "Habiburrahman El Shirazy", "Republika", "2004", "Religi", 10, "Cinta dan iman di Mesir."));
                repo.save(new Buku("Ketika Cinta Bertasbih", "Habiburrahman El Shirazy", "Republika", "2007", "Religi", 9, "Kisah perjuangan cinta dan keyakinan."));
                repo.save(new Buku("Koala Kumal", "Raditya Dika", "GagasMedia", "2015", "Komedi", 15, "Cerita lucu dan reflektif tentang hubungan."));
                repo.save(new Buku("Marmut Merah Jambu", "Raditya Dika", "GagasMedia", "2010", "Komedi", 14, "Kisah cinta absurd masa SMA."));
                repo.save(new Buku("Rectoverso", "Dee Lestari", "Bentang", "2008", "Fiksi", 8, "Kisah cinta dalam bentuk prosa dan lagu."));
                repo.save(new Buku("Orang-Orang Biasa", "Andrea Hirata", "Bentang", "2019", "Fiksi", 10, "Kisah kejahatan unik dari orang biasa."));
                repo.save(new Buku("Pulang", "Tere Liye", "Republika", "2015", "Thriller", 7, "Kisah mafia dan keluarga dalam perjalanan hidup."));
                repo.save(new Buku("Pergi", "Tere Liye", "Republika", "2018", "Thriller", 7, "Kelanjutan kisah Bujang setelah Pulang."));
                repo.save(new Buku("Laut Bercerita", "Leila S. Chudori", "KPG", "2017", "Sejarah", 6, "Tragedi aktivis di masa kelam Indonesia."));
                repo.save(new Buku("Madre", "Dee Lestari", "Bentang", "2011", "Cerpen", 8, "Cerita tentang roti, kenangan, dan cinta."));
                repo.save(new Buku("Garis Waktu", "Fiersa Besari", "Mediakita", "2016", "Puisi", 13, "Kisah perjalanan cinta dan kehidupan."));
                repo.save(new Buku("Sabtu Bersama Bapak", "Adhitya Mulya", "GagasMedia", "2014", "Drama", 9, "Kisah keluarga dan pesan seorang ayah."));
            }
        };
    }
}
