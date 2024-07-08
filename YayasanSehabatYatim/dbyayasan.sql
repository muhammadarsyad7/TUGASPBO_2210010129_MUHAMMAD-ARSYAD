-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 20, 2024 at 05:24 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbyayasan`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `Id_Bank` int NOT NULL,
  `Nama_Bank` varchar(50) NOT NULL,
  `No_Rekening` int NOT NULL,
  `Nama` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`Id_Bank`, `Nama_Bank`, `No_Rekening`, `Nama`) VALUES
(212, 'SIT', 76543, 'Sito'),
(454, 'BRI', 919, 'Aisyah');

-- --------------------------------------------------------

--
-- Table structure for table `donatur`
--

CREATE TABLE `donatur` (
  `Kd_Donatur` varchar(25) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Alamat` varchar(100) NOT NULL,
  `Telpon` varchar(15) NOT NULL,
  `Nominal` varchar(50) NOT NULL,
  `Status` varchar(25) NOT NULL,
  `Barang` int NOT NULL,
  `TransaksiTotal` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `donatur`
--

INSERT INTO `donatur` (`Kd_Donatur`, `Nama`, `Alamat`, `Telpon`, `Nominal`, `Status`, `Barang`, `TransaksiTotal`) VALUES
('100', 'Farhan', 'Sahurai', '086485953094', 'III', 'Terkirim', 70, 100000000),
('11', 'Amat', 'gampa', '081289764567', 'II', 'Terkirim', 50, 100000),
('900', 'Muna', 'Sahurai', '086485953094', 'I', 'Terkirim', 70, 100000000),
('999', 'Arsayd', 'Sahurai', '081350170761', 'II', 'Terkirim', 30, 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `konfirmasi_donasi`
--

CREATE TABLE `konfirmasi_donasi` (
  `Id_Konfirmasi` int NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `No_Rekening` int NOT NULL,
  `Nama_Bank` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `konfirmasi_donasi`
--

INSERT INTO `konfirmasi_donasi` (`Id_Konfirmasi`, `Nama`, `No_Rekening`, `Nama_Bank`) VALUES
(678, 'Naruto', 876, 'KONOHA');

-- --------------------------------------------------------

--
-- Table structure for table `trans_donasi`
--

CREATE TABLE `trans_donasi` (
  `Kd_Transaksi` int NOT NULL,
  `Nominal` varchar(25) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Barang` int NOT NULL,
  `TransaksiTotal` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `trans_donasi`
--

INSERT INTO `trans_donasi` (`Kd_Transaksi`, `Nominal`, `Status`, `Barang`, `TransaksiTotal`) VALUES
(33, 'II', 'Belum Terkirim', 30, 30000),
(88, 'II', 'Terkirim', 50, 800000),
(98, 'I', 'Terkirim', 60, 900000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`Id_Bank`);

--
-- Indexes for table `donatur`
--
ALTER TABLE `donatur`
  ADD PRIMARY KEY (`Kd_Donatur`);

--
-- Indexes for table `konfirmasi_donasi`
--
ALTER TABLE `konfirmasi_donasi`
  ADD PRIMARY KEY (`Id_Konfirmasi`);

--
-- Indexes for table `trans_donasi`
--
ALTER TABLE `trans_donasi`
  ADD PRIMARY KEY (`Kd_Transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `Id_Bank` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=455;

--
-- AUTO_INCREMENT for table `konfirmasi_donasi`
--
ALTER TABLE `konfirmasi_donasi`
  MODIFY `Id_Konfirmasi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=679;

--
-- AUTO_INCREMENT for table `trans_donasi`
--
ALTER TABLE `trans_donasi`
  MODIFY `Kd_Transaksi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=191;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
