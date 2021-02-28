-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2021 at 07:40 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gudang`
--

-- --------------------------------------------------------

--
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `id_distributor` int(11) NOT NULL,
  `namaD` varchar(126) NOT NULL,
  `alamat` varchar(126) NOT NULL,
  `notelp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `distributor`
--

INSERT INTO `distributor` (`id_distributor`, `namaD`, `alamat`, `notelp`) VALUES
(1, 'Bapak Wahid', 'Jalan Minggu ke Rebo', '092123214543');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id_item` int(11) NOT NULL,
  `namaB` varchar(126) NOT NULL,
  `stock` varchar(30) NOT NULL,
  `supplier` varchar(126) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id_item`, `namaB`, `stock`, `supplier`, `tanggal`) VALUES
(332, 'Macbook Pro 16inch 2019', '48', '2', '2020-01-08'),
(432, 'Razer Blade 2018', '23', '1', '2020-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `item_keluar`
--

CREATE TABLE `item_keluar` (
  `ID` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  `namaB` varchar(126) NOT NULL,
  `stock` varchar(30) NOT NULL,
  `distributor` varchar(5) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_keluar`
--

INSERT INTO `item_keluar` (`ID`, `id_item`, `namaB`, `stock`, `distributor`, `tanggal`) VALUES
(1, 332, '332', '12', '1', '2020-01-01'),
(2, 332, '332', '12', '1', '2020-01-09'),
(3, 432, '432', '10', '1', '2020-01-09');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `namaP` varchar(126) NOT NULL,
  `alamat` varchar(126) NOT NULL,
  `notelp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `namaP`, `alamat`, `notelp`) VALUES
(1, 'PT.Terbuka Hijau', 'jalan Tmebok bolong', '081322465321'),
(2, 'PT mantap mantap', 'jalan mantap bet dah', '123456789101'),
(3, 'PT Kembang Desa Cihuy', 'Jalan Desa Gembong Kidung', '08922312876');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(126) NOT NULL,
  `password` varchar(126) NOT NULL,
  `email` varchar(126) NOT NULL,
  `notelp` varchar(12) NOT NULL,
  `namaL` varchar(156) NOT NULL,
  `kelamin` varchar(5) NOT NULL,
  `alamat` varchar(156) NOT NULL,
  `flag_active` int(1) NOT NULL DEFAULT 1,
  `status` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`, `notelp`, `namaL`, `kelamin`, `alamat`, `flag_active`, `status`) VALUES
(1, 'jak', '123', 'jak@gmail.com', '123456789123', 'jak kuncup', 'Men', 'jakart utara', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `IdAkun` int(5) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Sex` varchar(5) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Role` varchar(25) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  `flag_active` int(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`IdAkun`, `Username`, `Password`, `Sex`, `Phone`, `Email`, `Role`, `status`, `flag_active`) VALUES
(1, 'admin', 'admin', 'Men', '1111', 'admin@admin.com', 'petugas', 1, 1),
(2, 'hadits', '1234', 'Men', '081345441', 'hadits@gmail.com', 'owner', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`id_distributor`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id_item`);

--
-- Indexes for table `item_keluar`
--
ALTER TABLE `item_keluar`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`IdAkun`,`Username`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Username_2` (`Username`),
  ADD KEY `IdAkun` (`IdAkun`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `distributor`
--
ALTER TABLE `distributor`
  MODIFY `id_distributor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=433;

--
-- AUTO_INCREMENT for table `item_keluar`
--
ALTER TABLE `item_keluar`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `IdAkun` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
