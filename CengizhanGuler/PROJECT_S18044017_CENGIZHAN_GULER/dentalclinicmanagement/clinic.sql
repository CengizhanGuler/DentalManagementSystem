-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.5.8-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- clinic için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `clinic` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `clinic`;

-- tablo yapısı dökülüyor clinic.appointment
CREATE TABLE IF NOT EXISTS `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dentist_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- clinic.appointment: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
REPLACE INTO `appointment` (`id`, `dentist_id`, `patient_id`, `date`) VALUES
	(36, 13, 1, '10 Oca 2021'),
	(37, 16, 1, '17 Oca 2021'),
	(38, 21, 2, '14 Oca 2021'),
	(39, 19, 3, '27 Oca 2021'),
	(40, 20, 10, '6 Oca 2021'),
	(41, 4, 11, '8 Oca 2021'),
	(42, 13, 12, '15 Oca 2021'),
	(43, 4, 9, '13 Oca 2021'),
	(44, 21, 1, '16 Oca 2021'),
	(45, 16, 8, '6 Oca 2021'),
	(46, 21, 8, '17 Oca 2021');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;

-- tablo yapısı dökülüyor clinic.availabledate
CREATE TABLE IF NOT EXISTS `availabledate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dentist_id` int(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8;

-- clinic.availabledate: ~152 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `availabledate` DISABLE KEYS */;
REPLACE INTO `availabledate` (`id`, `dentist_id`, `date`, `status`) VALUES
	(40, 32, '8 Oca 2021', 'active'),
	(42, 32, '9 Oca 2021', 'passive'),
	(43, 32, '12 Oca 2021', 'active'),
	(44, 32, '20 Oca 2021', 'passive'),
	(45, 32, '22 Oca 2021', 'active'),
	(46, 32, '5 Oca 2021', 'passive'),
	(47, 33, '4 Oca 2021', 'active'),
	(48, 33, '5 Oca 2021', 'active'),
	(49, 33, '7 Oca 2021', 'active'),
	(50, 33, '12 Oca 2021', 'passive'),
	(51, 33, '14 Oca 2021', 'active'),
	(52, 33, '15 Oca 2021', 'active'),
	(54, 33, '19 Oca 2021', 'active'),
	(55, 34, '5 Oca 2021', 'active'),
	(56, 34, '7 Oca 2021', 'active'),
	(57, 34, '9 Oca 2021', 'active'),
	(58, 34, '12 Oca 2021', 'active'),
	(59, 34, '18 Oca 2021', 'passive'),
	(60, 34, '6 Oca 2021', 'passive'),
	(61, 34, '20 Oca 2021', 'active'),
	(62, 34, '15 Oca 2021', 'active'),
	(63, 35, '5 Oca 2021', 'active'),
	(64, 35, '6 Oca 2021', 'active'),
	(65, 35, '7 Oca 2021', 'active'),
	(66, 35, '8 Oca 2021', 'passive'),
	(67, 35, '10 Oca 2021', 'active'),
	(68, 35, '12 Oca 2021', 'active'),
	(69, 35, '14 Oca 2021', 'active'),
	(70, 35, '17 Oca 2021', 'active'),
	(71, 35, '19 Oca 2021', 'active'),
	(72, 35, '21 Oca 2021', 'active'),
	(73, 36, '5 Oca 2021', 'active'),
	(74, 36, '7 Oca 2021', 'active'),
	(75, 36, '9 Oca 2021', 'passive'),
	(76, 36, '12 Oca 2021', 'active'),
	(77, 36, '14 Oca 2021', 'passive'),
	(78, 36, '16 Oca 2021', 'active'),
	(79, 36, '19 Oca 2021', 'passive'),
	(80, 36, '21 Oca 2021', 'active'),
	(82, 36, '24 Oca 2021', 'passive'),
	(83, 37, '6 Oca 2021', 'active'),
	(84, 37, '8 Oca 2021', 'active'),
	(85, 37, '10 Oca 2021', 'active'),
	(86, 37, '11 Oca 2021', 'active'),
	(87, 37, '13 Oca 2021', 'active'),
	(88, 37, '15 Oca 2021', 'active'),
	(89, 37, '20 Oca 2021', 'passive'),
	(90, 38, '4 Oca 2021', 'active'),
	(91, 38, '5 Oca 2021', 'active'),
	(92, 38, '6 Oca 2021', 'active'),
	(93, 38, '9 Oca 2021', 'passive'),
	(94, 38, '11 Oca 2021', 'active'),
	(95, 38, '13 Oca 2021', 'active'),
	(96, 38, '16 Oca 2021', 'active'),
	(97, 38, '18 Oca 2021', 'active'),
	(98, 38, '22 Oca 2021', 'active'),
	(99, 39, '6 Oca 2021', 'active'),
	(100, 39, '7 Oca 2021', 'active'),
	(101, 39, '10 Oca 2021', 'passive'),
	(102, 39, '17 Oca 2021', 'active'),
	(103, 39, '13 Oca 2021', 'passive'),
	(104, 39, '18 Oca 2021', 'active'),
	(105, 39, '20 Oca 2021', 'active'),
	(106, 39, '23 Oca 2021', 'active'),
	(107, 39, '26 Oca 2021', 'active'),
	(108, 39, '29 Oca 2021', 'active'),
	(109, 40, '4 Oca 2021', 'active'),
	(110, 40, '6 Oca 2021', 'active'),
	(111, 40, '9 Oca 2021', 'active'),
	(112, 40, '12 Oca 2021', 'active'),
	(113, 40, '14 Oca 2021', 'active'),
	(114, 40, '17 Oca 2021', 'active'),
	(115, 40, '20 Oca 2021', 'active'),
	(116, 40, '26 Oca 2021', 'active'),
	(117, 40, '30 Oca 2021', 'active'),
	(118, 40, '31 Oca 2021', 'active'),
	(119, 40, '2 Oca 2021', 'passive'),
	(120, 4, '5 Oca 2021', 'active'),
	(121, 4, '8 Oca 2021', 'passive'),
	(122, 4, '10 Oca 2021', 'active'),
	(123, 4, '13 Oca 2021', 'passive'),
	(124, 4, '17 Oca 2021', 'passive'),
	(125, 13, '4 Oca 2021', 'active'),
	(126, 13, '6 Oca 2021', 'active'),
	(127, 13, '8 Oca 2021', 'active'),
	(128, 13, '10 Oca 2021', 'passive'),
	(129, 13, '11 Oca 2021', 'active'),
	(130, 13, '13 Oca 2021', 'active'),
	(131, 13, '15 Oca 2021', 'passive'),
	(132, 13, '17 Oca 2021', 'active'),
	(133, 13, '18 Oca 2021', 'active'),
	(135, 14, '5 Oca 2021', 'active'),
	(136, 14, '7 Oca 2021', 'active'),
	(137, 14, '8 Oca 2021', 'active'),
	(138, 14, '11 Oca 2021', 'active'),
	(139, 14, '12 Oca 2021', 'active'),
	(140, 14, '14 Oca 2021', 'active'),
	(141, 14, '15 Oca 2021', 'active'),
	(142, 14, '17 Oca 2021', 'active'),
	(143, 14, '20 Oca 2021', 'active'),
	(144, 15, '5 Oca 2021', 'active'),
	(145, 15, '7 Oca 2021', 'active'),
	(146, 15, '9 Oca 2021', 'active'),
	(147, 15, '10 Oca 2021', 'active'),
	(148, 15, '12 Oca 2021', 'active'),
	(149, 15, '13 Oca 2021', 'active'),
	(150, 15, '16 Oca 2021', 'active'),
	(151, 15, '19 Oca 2021', 'active'),
	(152, 15, '21 Oca 2021', 'active'),
	(153, 16, '6 Oca 2021', 'active'),
	(154, 16, '7 Oca 2021', 'active'),
	(155, 16, '11 Oca 2021', 'active'),
	(156, 16, '12 Oca 2021', 'active'),
	(157, 16, '16 Oca 2021', 'active'),
	(158, 16, '17 Oca 2021', 'passive'),
	(159, 17, '5 Oca 2021', 'active'),
	(160, 17, '9 Oca 2021', 'active'),
	(161, 17, '10 Oca 2021', 'active'),
	(162, 17, '12 Oca 2021', 'active'),
	(163, 17, '14 Oca 2021', 'active'),
	(164, 17, '17 Oca 2021', 'active'),
	(165, 18, '5 Oca 2021', 'active'),
	(166, 18, '6 Oca 2021', 'active'),
	(167, 18, '8 Oca 2021', 'active'),
	(168, 18, '9 Oca 2021', 'active'),
	(169, 18, '15 Oca 2021', 'active'),
	(170, 18, '13 Oca 2021', 'active'),
	(171, 18, '23 Oca 2021', 'active'),
	(172, 19, '7 Oca 2021', 'active'),
	(173, 19, '9 Oca 2021', 'active'),
	(174, 19, '10 Oca 2021', 'active'),
	(175, 19, '18 Oca 2021', 'active'),
	(176, 19, '20 Oca 2021', 'active'),
	(177, 19, '22 Oca 2021', 'active'),
	(178, 19, '27 Oca 2021', 'passive'),
	(179, 20, '6 Oca 2021', 'passive'),
	(180, 20, '14 Oca 2021', 'active'),
	(181, 20, '16 Oca 2021', 'active'),
	(182, 20, '17 Oca 2021', 'active'),
	(183, 20, '18 Oca 2021', 'active'),
	(184, 20, '19 Oca 2021', 'active'),
	(185, 20, '21 Oca 2021', 'active'),
	(186, 21, '5 Oca 2021', 'active'),
	(187, 21, '7 Oca 2021', 'active'),
	(188, 21, '8 Oca 2021', 'active'),
	(189, 21, '12 Oca 2021', 'active'),
	(190, 21, '14 Oca 2021', 'passive'),
	(191, 21, '16 Oca 2021', 'active'),
	(192, 21, '17 Oca 2021', 'active'),
	(193, 7, '24 Oca 2021', 'active'),
	(194, 7, '27 Oca 2021', 'active'),
	(195, 13, '31 Oca 2021', 'active');
/*!40000 ALTER TABLE `availabledate` ENABLE KEYS */;

-- tablo yapısı dökülüyor clinic.clinics
CREATE TABLE IF NOT EXISTS `clinics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `adress` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- clinic.clinics: ~16 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `clinics` DISABLE KEYS */;
REPLACE INTO `clinics` (`id`, `name`, `adress`, `phone`) VALUES
	(1, 'DentGroup Hastanesi', 'Çayyolu', '0312 440 66 07'),
	(2, 'Ankara Diş Hastanesi', 'Sıhhiye', '0312 107 99 88'),
	(3, 'Özel Ankara Mavi Ağız', 'Çankaya', '0312 183 01 54'),
	(4, 'Gazi Mustafa Kemal Diş Hastanesi', 'Yenimahalle', '0312 215 19 30'),
	(5, 'Başkent Hastanesi', 'Beşevler', '0312 321 90 13'),
	(6, 'Minedent Ağız Ve Diş Sağlığı Polikliniği', 'Çankaya', '0312 396 57 25'),
	(7, 'Aydınlıkevler Ağız Ve Diş Sağlığı Polikliniği', 'Altındağ', '0312 316 00 36'),
	(8, 'Tepebaşı Hastanesi', 'Altındağ', '0312 378 34 75'),
	(9, 'Balgat Ağız ve Diş Sağlığı Merkezi', 'Balgat', '0312 915 11 22'),
	(10, 'Ankara Mavi Ağız Diş Hastanesi', 'Çankaya', '0312 231 00 12'),
	(11, 'Denthol Ağız ve Diş Hastanesi', 'Çankaya', '0312 186 44 21'),
	(12, 'Dentalis Diş Hastanesi', 'Çukurambar', '0312 286 31 32'),
	(13, 'Özel Keçiören Ağız Ve Diş Sağlığı Polikliniği', 'Keçiören', '0312 381 20 02'),
	(14, 'Deva Diş Merkezi', 'Sincan', '0312 180 63 57'),
	(15, 'Hacettepe Diş Hastanesi', 'Sihhiye', '0312 816 30 87'),
	(16, 'Gazi Diş Hastanesi', 'Beşevler', '0312 510 20 42');
/*!40000 ALTER TABLE `clinics` ENABLE KEYS */;

-- tablo yapısı dökülüyor clinic.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clinic_id` int(11) DEFAULT NULL,
  `dentist_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8;

-- clinic.employee: ~56 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
REPLACE INTO `employee` (`id`, `clinic_id`, `dentist_id`) VALUES
	(1, 1, 7),
	(2, 5, 7),
	(3, 7, 7),
	(4, 9, 7),
	(6, 10, 7),
	(8, 3, 7),
	(9, 1, 4),
	(10, 2, 4),
	(11, 3, 4),
	(12, 5, 4),
	(13, 7, 4),
	(31, 1, 13),
	(32, 3, 13),
	(33, 4, 13),
	(34, 7, 13),
	(35, 9, 13),
	(36, 10, 13),
	(114, 1, 14),
	(115, 3, 14),
	(116, 5, 14),
	(117, 7, 14),
	(118, 9, 14),
	(119, 11, 14),
	(121, 15, 14),
	(122, 2, 15),
	(123, 3, 15),
	(124, 5, 15),
	(125, 9, 15),
	(126, 11, 15),
	(127, 12, 15),
	(128, 13, 15),
	(129, 3, 16),
	(130, 4, 16),
	(131, 10, 16),
	(132, 14, 16),
	(133, 16, 16),
	(134, 4, 17),
	(135, 5, 17),
	(136, 8, 17),
	(137, 9, 17),
	(138, 4, 18),
	(139, 6, 18),
	(140, 10, 18),
	(141, 16, 18),
	(142, 4, 19),
	(143, 12, 19),
	(144, 16, 19),
	(145, 6, 20),
	(146, 12, 20),
	(147, 13, 20),
	(148, 15, 20),
	(149, 7, 21),
	(150, 8, 21),
	(151, 9, 21),
	(152, 15, 21),
	(154, 12, 42);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- tablo yapısı dökülüyor clinic.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- clinic.user: ~22 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `username`, `name`, `password`, `type`) VALUES
	(1, 'samet', 'Samet FALAY', '1234', 'patient'),
	(2, 'zafer', 'Zafer Akdemir', '12345', 'patient'),
	(3, 'şamil', 'Şamil Canbolat', '1111', 'patient'),
	(4, 'dm', 'Esra Bilir', 'esra', 'dentist'),
	(5, 'root', 'Veli Büyük', 'root', 'admin'),
	(6, 'admin', 'Ali Koç', 'admin', 'admin'),
	(7, 'aa', 'Asya Al', 'aa', 'dentist'),
	(8, 'ahmet', 'Ahmet Türk', 'türk', 'patient'),
	(9, 'Berat', 'Berat Büyük', 'berat', 'patient'),
	(10, 'zeki', 'Zeki Küçük', 'asd', 'patient'),
	(11, 'merve', 'Merve Güzel', 'merve', 'patient'),
	(12, 'nalan', 'Nalan Sak', 'aaa', 'patient'),
	(13, 'tolga', 'Tolga Sarıtaş', 'tolga', 'dentist'),
	(14, 'betül', 'Betül Sayan', '789', 'dentist'),
	(15, 'flz', 'Filiz Aker', '123', 'dentist'),
	(16, 'emre', 'Emre Şans', '333', 'dentist'),
	(17, 'brn', 'Berna Tan', '444', 'dentist'),
	(18, 'nzn', 'Nazan Duru', '555', 'dentist'),
	(19, 'derya', 'Derya Aldemir', '999', 'dentist'),
	(20, 'rz', 'Rıza Konak', '123', 'dentist'),
	(21, 'mine', 'Mine Yıldız', '555', 'dentist'),
	(42, 'çetin', 'Çetin Emek', '123', 'dentist');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- yöntem yapısı dökülüyor clinic.userinfo
DELIMITER //
CREATE PROCEDURE `userinfo`(
	IN `Param1` INT
)
    COMMENT 'for testing'
BEGIN
SELECT * FROM user WHERE user.password = Param1;
END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
