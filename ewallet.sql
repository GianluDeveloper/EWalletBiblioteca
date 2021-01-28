-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 28, 2021 alle 20:50
-- Versione del server: 10.4.17-MariaDB
-- Versione PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ewallet`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `contocorrente`
--

CREATE TABLE `contocorrente` (
  `iban` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `saldo` float NOT NULL,
  `dataCreazione` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `contocorrente`
--

INSERT INTO `contocorrente` (`iban`, `idCliente`, `saldo`, `dataCreazione`) VALUES
(4, 55, 234.2, '2020-12-30'),
(5, 55, 234.2, '2021-01-02'),
(6, 55, 234.2, '2020-12-30'),
(7, 4, 2.2, '2020-10-10'),
(8, 4, 2.2, '2020-09-09'),
(9, 4, 2340.2, '2020-09-09'),
(10, 3423, 35235200, '2010-10-20');

-- --------------------------------------------------------

--
-- Struttura della tabella `movimenti`
--

CREATE TABLE `movimenti` (
  `id` int(11) NOT NULL,
  `iban` int(11) NOT NULL,
  `importo` float NOT NULL,
  `dataMovimento` date NOT NULL,
  `idTipoMovimento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `tipomovimento`
--

CREATE TABLE `tipomovimento` (
  `idTipoMovimento` int(11) NOT NULL,
  `descrizione` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `contocorrente`
--
ALTER TABLE `contocorrente`
  ADD PRIMARY KEY (`iban`);

--
-- Indici per le tabelle `movimenti`
--
ALTER TABLE `movimenti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idTipoMovimento` (`idTipoMovimento`),
  ADD KEY `fk_iban` (`iban`);

--
-- Indici per le tabelle `tipomovimento`
--
ALTER TABLE `tipomovimento`
  ADD PRIMARY KEY (`idTipoMovimento`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `contocorrente`
--
ALTER TABLE `contocorrente`
  MODIFY `iban` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `movimenti`
--
ALTER TABLE `movimenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `tipomovimento`
--
ALTER TABLE `tipomovimento`
  MODIFY `idTipoMovimento` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `movimenti`
--
ALTER TABLE `movimenti`
  ADD CONSTRAINT `fk_iban` FOREIGN KEY (`iban`) REFERENCES `contocorrente` (`iban`);

--
-- Limiti per la tabella `tipomovimento`
--
ALTER TABLE `tipomovimento`
  ADD CONSTRAINT `fk_idTipoMovimento` FOREIGN KEY (`idTipoMovimento`) REFERENCES `movimenti` (`idTipoMovimento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
