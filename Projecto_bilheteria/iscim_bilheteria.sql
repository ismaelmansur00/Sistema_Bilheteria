-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2023 at 02:45 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iscim_bilheteria`
--

-- --------------------------------------------------------

--
-- Table structure for table `bilhete`
--

CREATE TABLE `bilhete` (
  `codigo` int(11) NOT NULL,
  `categoria` varchar(20) DEFAULT NULL,
  `data_compra` datetime DEFAULT NULL,
  `tipo_bilhete` varchar(50) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `espectador_id` int(11) DEFAULT NULL,
  `evento_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `espectador`
--

CREATE TABLE `espectador` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  `espectador_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `evento`
--

CREATE TABLE `evento` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `hora_fim` time DEFAULT NULL,
  `data_evento` date DEFAULT NULL,
  `numero_bilhete` int(100) DEFAULT NULL,
  `local_evento` varchar(200) DEFAULT NULL,
  `valor_evento` double DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `descricao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `utilizador`
--

CREATE TABLE `utilizador` (
  `codigo` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bilhete`
--
ALTER TABLE `bilhete`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `evento_id` (`evento_id`),
  ADD KEY `bilhete_ibfk_2` (`espectador_id`);

--
-- Indexes for table `espectador`
--
ALTER TABLE `espectador`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `espectador_id` (`espectador_id`);

--
-- Indexes for table `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `admin_id` (`admin_id`);

--
-- Indexes for table `utilizador`
--
ALTER TABLE `utilizador`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bilhete`
--
ALTER TABLE `bilhete`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `espectador`
--
ALTER TABLE `espectador`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `evento`
--
ALTER TABLE `evento`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `utilizador`
--
ALTER TABLE `utilizador`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bilhete`
--
ALTER TABLE `bilhete`
  ADD CONSTRAINT `bilhete_ibfk_1` FOREIGN KEY (`evento_id`) REFERENCES `evento` (`codigo`),
  ADD CONSTRAINT `bilhete_ibfk_2` FOREIGN KEY (`espectador_id`) REFERENCES `utilizador` (`codigo`);

--
-- Constraints for table `espectador`
--
ALTER TABLE `espectador`
  ADD CONSTRAINT `espectador_ibfk_1` FOREIGN KEY (`espectador_id`) REFERENCES `utilizador` (`codigo`);

--
-- Constraints for table `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `evento_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `utilizador` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
