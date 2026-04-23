-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 23. Apr 2026 um 08:41
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `radiology`
--
CREATE DATABASE IF NOT EXISTS `radiology` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `radiology`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `m_modalities`
--

CREATE TABLE `m_modalities` (
  `m_id` int(11) NOT NULL,
  `m_location` varchar(255) DEFAULT NULL,
  `m_type` varchar(255) DEFAULT NULL,
  `m_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `m_modalities`
--

INSERT INTO `m_modalities` (`m_id`, `m_location`, `m_type`, `m_description`) VALUES
(2, '101', 'CT', 'Computed tomography for head and body examinations'),
(3, '102', 'MRI', 'Magnetic resonance imaging for soft tissues and joints'),
(4, '103', 'X-Ray', 'X-ray examination for chest and extremities'),
(5, '104', 'Ultrasound', 'Ultrasound examination of abdominal organs'),
(6, '105', 'PET', 'Positron emission tomography for metabolic processes'),
(7, '106', 'CT', 'CT for emergency and trauma patients'),
(8, '107', 'MRI', 'High-resolution MRI for brain and spine examinations'),
(9, '108', 'X-Ray', 'Digital X-ray imaging of bones and joints'),
(10, '109', 'Ultrasound', 'Doppler ultrasound for vascular diagnostics'),
(11, '110', 'PET', 'PET-CT for oncology examinations'),
(12, '111', 'CT', 'Spiral CT for thoracic and abdominal regions'),
(13, '112', 'MRI', 'Cardiac MRI for heart diagnostics'),
(14, '113', 'X-Ray', 'X-ray imaging for orthopedic diagnostics'),
(15, '114', 'Ultrasound', 'Prenatal ultrasound and gynecological examinations'),
(16, '115', 'PET', 'PET for neurological diseases');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `p_patients`
--

CREATE TABLE `p_patients` (
  `p_id` int(11) NOT NULL,
  `p_birth` date DEFAULT NULL,
  `p_firstname` varchar(255) DEFAULT NULL,
  `p_gender` varchar(255) DEFAULT NULL,
  `p_surname` varchar(255) DEFAULT NULL,
  `p_svnr` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `p_patients`
--

INSERT INTO `p_patients` (`p_id`, `p_birth`, `p_firstname`, `p_gender`, `p_surname`, `p_svnr`) VALUES
(10, '2026-04-22', 'Gabrijel', 'm', 'Stankovic', '1237010180'),
(11, '2009-04-12', 'Dragos', 'd', 'Anghel', '2441160586'),
(12, '2008-05-20', 'Lilia', 'f', 'Bovsunovska', '4702261270'),
(13, '2008-08-31', 'Mateja', 'm', 'Vozarevic', '8200251169');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `r_reservation_times`
--

CREATE TABLE `r_reservation_times` (
  `r_id` int(11) NOT NULL,
  `r_reservation_date` datetime(6) DEFAULT NULL,
  `r_m_id` int(11) DEFAULT NULL,
  `r_p_id` int(11) DEFAULT NULL,
  `r_comment` varchar(255) DEFAULT NULL,
  `r_body_region` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `r_reservation_times`
--

INSERT INTO `r_reservation_times` (`r_id`, `r_reservation_date`, `r_m_id`, `r_p_id`, `r_comment`, `r_body_region`) VALUES
(21, '2026-05-25 12:00:00.000000', 2, 10, 'Pain in the Upper right Limb.', 'Upper Limb'),
(23, '2026-05-25 14:00:00.000000', 6, 10, '', 'Neck'),
(24, '2026-05-25 10:00:00.000000', 2, 11, 'Pain in the Lower Limb.', 'Lower Limb');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `m_modalities`
--
ALTER TABLE `m_modalities`
  ADD PRIMARY KEY (`m_id`);

--
-- Indizes für die Tabelle `p_patients`
--
ALTER TABLE `p_patients`
  ADD PRIMARY KEY (`p_id`);

--
-- Indizes für die Tabelle `r_reservation_times`
--
ALTER TABLE `r_reservation_times`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `FKbdxnxshnl2t1wguadno0gtr2y` (`r_m_id`),
  ADD KEY `FK2o8qohean47knk7bsretbxvky` (`r_p_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `m_modalities`
--
ALTER TABLE `m_modalities`
  MODIFY `m_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT für Tabelle `p_patients`
--
ALTER TABLE `p_patients`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT für Tabelle `r_reservation_times`
--
ALTER TABLE `r_reservation_times`
  MODIFY `r_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `r_reservation_times`
--
ALTER TABLE `r_reservation_times`
  ADD CONSTRAINT `FK2o8qohean47knk7bsretbxvky` FOREIGN KEY (`r_p_id`) REFERENCES `p_patients` (`p_id`),
  ADD CONSTRAINT `FKbdxnxshnl2t1wguadno0gtr2y` FOREIGN KEY (`r_m_id`) REFERENCES `m_modalities` (`m_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
