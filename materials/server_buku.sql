-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2025 at 04:51 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `server_buku`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` bigint(20) NOT NULL,
  `deskripsi` varchar(255) DEFAULT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  `penerbit` varchar(255) DEFAULT NULL,
  `penulis` varchar(255) DEFAULT NULL,
  `stok` int(11) NOT NULL,
  `tahun` int(11) DEFAULT NULL,
  `gambar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `deskripsi`, `judul`, `kategori`, `penerbit`, `penulis`, `stok`, `tahun`, `gambar`) VALUES
(1, 'Kisah inspiratif anak-anak Belitung.', 'Laskar Pelangi', 'Novel', 'Bentang', 'Andrea Hirata', 10, 2005, NULL),
(2, 'Perjuangan Minke di masa kolonial.', 'Bumi Manusia', 'Sastra', 'Lentera Dipantara', 'Pramoedya Ananta Toer', 6, 1980, NULL),
(3, 'Kisah cinta remaja Bandung era 90an.', 'Dilan 1990', 'Romansa', 'Pastel Books', 'Pidi Baiq', 12, 2014, NULL),
(4, 'Kisah legendaris penuh simbol dan makna.', 'Cantik Itu Luka', 'Sastra', 'Gramedia', 'Eka Kurniawan', 5, 2002, NULL),
(5, 'Semangat menuntut ilmu dari enam santri.', 'Negeri 5 Menara', 'Motivasi', 'Gramedia', 'Ahmad Fuadi', 9, 2009, NULL),
(6, 'Kumpulan cerita pendek penuh makna hidup.', 'Filosofi Kopi', 'Cerpen', 'Bentang', 'Dee Lestari', 7, 2006, NULL),
(7, 'Kisah cinta di tengah bencana dan kehilangan.', 'Hujan', 'Fiksi', 'Gramedia', 'Tere Liye', 11, 2016, NULL),
(8, 'Kehidupan Srintil di desa kecil Jawa.', 'Ronggeng Dukuh Paruk', 'Sastra', 'Gramedia', 'Ahmad Tohari', 6, 1982, NULL),
(9, 'Cinta dan iman di Mesir.', 'Ayat-Ayat Cinta', 'Religi', 'Republika', 'Habiburrahman El Shirazy', 10, 2004, NULL),
(10, 'Kisah perjuangan cinta dan keyakinan.', 'Ketika Cinta Bertasbih', 'Religi', 'Republika', 'Habiburrahman El Shirazy', 9, 2007, NULL),
(11, 'Cerita lucu dan reflektif tentang hubungan.', 'Koala Kumal', 'Komedi', 'GagasMedia', 'Raditya Dika', 15, 2015, NULL),
(12, 'Kisah cinta absurd masa SMA.', 'Marmut Merah Jambu', 'Komedi', 'GagasMedia', 'Raditya Dika', 13, 2010, NULL),
(13, 'Kisah cinta dalam bentuk prosa dan lagu.', 'Rectoverso', 'Fiksi', 'Bentang', 'Dee Lestari', 8, 2008, NULL),
(14, 'Kisah kejahatan unik dari orang biasa.', 'Orang-Orang Biasa', 'Fiksi', 'Bentang', 'Andrea Hirata', 10, 2019, NULL),
(15, 'Kisah mafia dan keluarga dalam perjalanan hidup.', 'Pulang', 'Thriller', 'Republika', 'Tere Liye', 7, 2015, NULL),
(16, 'Kelanjutan kisah Bujang setelah Pulang.', 'Pergi', 'Thriller', 'Republika', 'Tere Liye', 7, 2018, NULL),
(17, 'Tragedi aktivis di masa kelam Indonesia.', 'Laut Bercerita', 'Sejarah', 'KPG', 'Leila S. Chudori', 6, 2017, NULL),
(18, 'Cerita tentang roti, kenangan, dan cinta.', 'Madre', 'Cerpen', 'Bentang', 'Dee Lestari', 8, 2011, NULL),
(19, 'Kisah perjalanan cinta dan kehidupan.', 'Garis Waktu', 'Puisi', 'Mediakita', 'Fiersa Besari', 13, 2016, NULL),
(20, 'Kisah keluarga dan pesan seorang ayah.', 'Sabtu Bersama Bapak', 'Drama', 'GagasMedia', 'Adhitya Mulya', 8, 2014, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` bigint(20) NOT NULL,
  `nama_peminjam` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `buku_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKei7ilms0t9ck4xhmgvemlfqif` (`buku_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `FKei7ilms0t9ck4xhmgvemlfqif` FOREIGN KEY (`buku_id`) REFERENCES `buku` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
