-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2020 at 03:41 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `guest_house_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `AccuntID` int(100) NOT NULL,
  `username` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `personID` int(100) DEFAULT NULL,
  `privilege` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`AccuntID`, `username`, `password`, `personID`, `privilege`) VALUES
(1, 'root', '12345678', 0, 1),
(2, 'fluke18261', '12345678', 15, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bookedhouse`
--

CREATE TABLE `bookedhouse` (
  `BookedHouseID` int(100) NOT NULL,
  `customerID` int(100) DEFAULT NULL,
  `houseID` int(100) DEFAULT NULL,
  `checkInDate` timestamp(6) NULL DEFAULT NULL,
  `checkOutDate` timestamp(6) NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(100) NOT NULL,
  `firstName` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastName` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(3) NOT NULL,
  `phone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `house`
--

CREATE TABLE `house` (
  `HouseID` int(100) NOT NULL,
  `nameOfHourse` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `typeOfHourse` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(65,2) DEFAULT NULL,
  `houseStatus` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `house`
--

INSERT INTO `house` (`HouseID`, `nameOfHourse`, `typeOfHourse`, `price`, `houseStatus`) VALUES
(1, 'บ้านฟ้าใส', 'บังกะโล', '1500.00', 'AVALIABLE'),
(2, 'บ้านรุ้งสว่าง', 'บ้านเดี่ยว', '2500.00', 'AVALIABLE'),
(3, 'บ้านดาวเรือว', 'บ้านริมทะเล', '7500.00', 'AVALIABLE'),
(4, 'บ้านฟ้าสว่าง', 'บ้านหลัง', '2500.00', 'AVALIABLE'),
(5, 'บ้านริมน้ำ', 'บ้านพัก', '4500.00', 'AVALIABLE'),
(6, 'บ้านสองชั้น', 'บ้านพัก', '4500.00', 'AVALIABLE'),
(7, 'บ้านของโปรเจค', 'บ้านหลัง', '7000.00', 'AVALIABLE'),
(8, 'เทสบนโปรดัก', 'บ้านริมทะเล', '4500.00', 'AVALIABLE');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `PersonID` int(100) NOT NULL,
  `firstName` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastName` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rank` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`PersonID`, `firstName`, `lastName`, `phone`, `rank`) VALUES
(15, 'pxnxs', 'khjrs', '0948219901', 'STAFF');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`AccuntID`);

--
-- Indexes for table `bookedhouse`
--
ALTER TABLE `bookedhouse`
  ADD PRIMARY KEY (`BookedHouseID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`HouseID`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`PersonID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `AccuntID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `bookedhouse`
--
ALTER TABLE `bookedhouse`
  MODIFY `BookedHouseID` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `house`
--
ALTER TABLE `house`
  MODIFY `HouseID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `PersonID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
