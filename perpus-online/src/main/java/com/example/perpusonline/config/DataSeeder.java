package com.example.perpusonline.config;

import com.example.perpusonline.model.Buku;
import com.example.perpusonline.repository.BukuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BukuRepository bukuRepository;

    public DataSeeder(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @Override
    public void run(String... args) {
        if (bukuRepository.count() == 0) {
            List<Buku> bukuList = List.of(
                new Buku(null, "Laskar Pelangi", "Andrea Hirata", "Bentang Pustaka", 2005, "Novel", 10, "Perjalanan hidup anak-anak Belitung.", "laskar_pelangi.jpg"),
                new Buku(null, "Bumi Manusia", "Pramoedya Ananta Toer", "Hasta Mitra", 1980, "Sastra", 8, "Kisah Minke dan perjuangan melawan kolonialisme.", "bumi_manusia.jpg"),
                new Buku(null, "Filosofi Kopi", "Dee Lestari", "Bentang Pustaka", 2006, "Kumpulan Cerpen", 6, "Kumpulan cerita dengan makna filosofis di balik secangkir kopi.", "filosofi_kopi.jpg"),
                new Buku(null, "Negeri 5 Menara", "Ahmad Fuadi", "Gramedia", 2009, "Novel", 12, "Perjuangan enam santri dalam menggapai mimpi.", "negeri_5_menara.jpg"),
                new Buku(null, "Sapiens", "Yuval Noah Harari", "Harper", 2014, "Sejarah", 5, "Sejarah panjang umat manusia dari zaman purba.", "sapiens.jpg"),
                new Buku(null, "Atomic Habits", "James Clear", "Avery", 2018, "Motivasi", 7, "Panduan membangun kebiasaan kecil menuju perubahan besar.", "atomic_habits.jpg"),
                new Buku(null, "The Subtle Art of Not Giving a F*ck", "Mark Manson", "HarperOne", 2016, "Self Improvement", 9, "Pendekatan realistis terhadap kebahagiaan dan kesuksesan.", "subtle_art.jpg"),
                new Buku(null, "Rich Dad Poor Dad", "Robert T. Kiyosaki", "Warner Books", 1997, "Finansial", 10, "Pelajaran finansial dari dua figur ayah dengan filosofi berbeda.", "rich_dad_poor_dad.jpg"),
                new Buku(null, "Dilan 1990", "Pidi Baiq", "Pastel Books", 2014, "Romansa", 15, "Kisah cinta Dilan dan Milea di Bandung tahun 1990.", "dilan_1990.jpg"),
                new Buku(null, "Harry Potter and the Sorcerer’s Stone", "J.K. Rowling", "Bloomsbury", 1997, "Fantasi", 20, "Petualangan penyihir muda Harry Potter di Hogwarts.", "harry_potter1.jpg"),
                new Buku(null, "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", 1960, "Klasik", 8, "Kisah tentang keadilan sosial dan rasisme di Amerika.", "mockingbird.jpg"),
                new Buku(null, "The Alchemist", "Paulo Coelho", "HarperTorch", 1988, "Filosofi", 10, "Perjalanan spiritual menggali makna hidup dan takdir.", "alchemist.jpg"),
                new Buku(null, "1984", "George Orwell", "Secker & Warburg", 1949, "Dystopia", 9, "Kritik sosial tentang totalitarianisme dan kontrol pikiran.", "1984.jpg"),
                new Buku(null, "Animal Farm", "George Orwell", "Secker & Warburg", 1945, "Sastra", 11, "Satire politik dengan tokoh-tokoh hewan sebagai simbol kekuasaan.", "animal_farm.jpg"),
                new Buku(null, "The Psychology of Money", "Morgan Housel", "Harriman House", 2020, "Finansial", 7, "Pelajaran psikologis di balik perilaku finansial manusia.", "psych_money.jpg"),
                new Buku(null, "Thinking, Fast and Slow", "Daniel Kahneman", "Farrar, Straus and Giroux", 2011, "Psikologi", 6, "Penjelasan tentang dua sistem berpikir manusia.", "thinking_fast_slow.jpg"),
                new Buku(null, "The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", 1937, "Fantasi", 8, "Petualangan Bilbo Baggins menuju Lonely Mountain.", "hobbit.jpg"),
                new Buku(null, "Sherlock Holmes: The Complete Novels", "Arthur Conan Doyle", "Penguin Classics", 1892, "Detektif", 5, "Kumpulan kasus misteri detektif terkenal.", "sherlock.jpg"),
                new Buku(null, "Origin", "Dan Brown", "Doubleday", 2017, "Thriller", 10, "Robert Langdon menyelidiki asal-usul manusia modern.", "origin.jpg"),
                new Buku(null, "The 7 Habits of Highly Effective People", "Stephen Covey", "Free Press", 1989, "Motivasi", 12, "Panduan membangun karakter dan efektivitas pribadi.", "7habits.jpg")
            );

            bukuRepository.saveAll(bukuList);
            System.out.println("✅ 20 buku berhasil dimasukkan ke database!");
        } else {
            System.out.println("ℹ️ Data buku sudah ada, seeding dilewati.");
        }
    }
}
