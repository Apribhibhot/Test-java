-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2019 at 05:44 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `latihankrs`
--

-- --------------------------------------------------------

--
-- Table structure for table `table_krs`
--

CREATE TABLE `table_krs` (
  `id` int(10) NOT NULL,
  `nim` int(10) NOT NULL,
  `id_matakuliah` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `table_mahasiswa`
--

CREATE TABLE `table_mahasiswa` (
  `nim` int(5) NOT NULL,
  `mahasiswa` varchar(100) NOT NULL,
  `maks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_mahasiswa`
--

INSERT INTO `table_mahasiswa` (`nim`, `mahasiswa`, `maks`) VALUES
(1, 'abcd', 12),
(2, 'ratna', 12);

-- --------------------------------------------------------

--
-- Table structure for table `table_matakuliah`
--

CREATE TABLE `table_matakuliah` (
  `id` int(5) NOT NULL,
  `mata_kuliah` varchar(100) NOT NULL,
  `sks` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_matakuliah`
--

INSERT INTO `table_matakuliah` (`id`, `mata_kuliah`, `sks`) VALUES
(1, 'sejarah', 2);

-- --------------------------------------------------------

--
-- Table structure for table `table_user`
--

CREATE TABLE `table_user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_user`
--

INSERT INTO `table_user` (`id`, `username`, `password`) VALUES
(18, 'achmad', '827ccb0eea8a706c4c34a16891f84e7b');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_krs`
--
ALTER TABLE `table_krs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_mahasiswa`
--
ALTER TABLE `table_mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `table_matakuliah`
--
ALTER TABLE `table_matakuliah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_user`
--
ALTER TABLE `table_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_krs`
--
ALTER TABLE `table_krs`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `table_mahasiswa`
--
ALTER TABLE `table_mahasiswa`
  MODIFY `nim` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `table_matakuliah`
--
ALTER TABLE `table_matakuliah`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `table_user`
--
ALTER TABLE `table_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
