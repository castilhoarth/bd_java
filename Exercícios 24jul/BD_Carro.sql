-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 27-Jul-2018 às 15:28
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_carro`
--
CREATE DATABASE IF NOT EXISTS `bd_carro` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bd_carro`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `carro`
--

CREATE TABLE `carro` (
  `idCarro` int(11) NOT NULL,
  `Fabricante` varchar(30) NOT NULL,
  `Modelo` varchar(20) NOT NULL,
  `Ano` varchar(4) NOT NULL,
  `Placa` varchar(7) NOT NULL,
  `Cor` varchar(10) NOT NULL,
  `Comentarios` varchar(60) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `carro`
--

INSERT INTO `carro` (`idCarro`, `Fabricante`, `Modelo`, `Ano`, `Placa`, `Cor`, `Comentarios`) VALUES
(1, 'Honda', 'Fit', '2012', 'AAA1234', 'Prata', 'Completo - todos acessórios estão em perfeito estado');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carro`
--
ALTER TABLE `carro`
  ADD PRIMARY KEY (`idCarro`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carro`
--
ALTER TABLE `carro`
  MODIFY `idCarro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
