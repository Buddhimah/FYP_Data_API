-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2018 at 03:21 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fyp`
--

-- --------------------------------------------------------

--
-- Table structure for table `meter_data`
--

CREATE TABLE `meter_data` (
  `id` int(11) NOT NULL,
  `data` varchar(255) DEFAULT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meter_data`
--

INSERT INTO `meter_data` (`id`, `data`, `time`) VALUES
(1004, '1346', '2018-12-24 22:46:49'),
(1005, '1246', '2018-12-24 22:46:49'),
(1008, '13846', '2018-12-24 22:46:49'),
(1009, '12846', '2018-12-24 22:46:49'),
(1002, '4243', '2018-12-24 22:56:10'),
(1012, '4245', '2018-12-25 04:56:50');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `meter_data`
--
ALTER TABLE `meter_data`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
