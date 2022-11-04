-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 11, 2022 at 05:12 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mamaskitchen`
--

-- --------------------------------------------------------

--
-- Table structure for table `cafes`
--

DROP TABLE IF EXISTS `cafes`;
CREATE TABLE IF NOT EXISTS `cafes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `type` varchar(25) NOT NULL,
  `address` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cafes`
--

INSERT INTO `cafes` (`id`, `name`, `phone`, `type`, `address`, `username`, `password`) VALUES
(1, 'sara', '0000', 'motherbet', '5kilo', 'saricho', '1581');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `fullname`, `phone`, `username`, `password`) VALUES
(1, 'betsi', '1111', 'betsy', '1234'),
(2, 'yosef', '123456', 'yosi', '1111'),
(3, '', '', '', ''),
(4, 'Betselot Kidane', '0949........', 'user', '0000');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
CREATE TABLE IF NOT EXISTS `delivery` (
  `deliveryid` int(11) NOT NULL AUTO_INCREMENT,
  `cafeid` int(11) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `customerid` int(11) NOT NULL,
  `food` varchar(25) NOT NULL,
  `address` varchar(30) NOT NULL,
  PRIMARY KEY (`deliveryid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`deliveryid`, `cafeid`, `phone`, `customerid`, `food`, `address`) VALUES
(1, 1, '0949........', 4, 'firfir', 'addis');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
CREATE TABLE IF NOT EXISTS `food` (
  `cafeid` int(11) NOT NULL,
  `foodid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`foodid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`cafeid`, `foodid`, `name`, `price`, `type`) VALUES
(1, 1, 'firfir', 54, 'keyy'),
(1, 2, 'pasta', 55, 'batklt');

-- --------------------------------------------------------

--
-- Table structure for table `orderlist`
--

DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE IF NOT EXISTS `orderlist` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(30) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `customerid` int(11) NOT NULL,
  `food` varchar(20) NOT NULL,
  `cafeid` int(11) NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderlist`
--

INSERT INTO `orderlist` (`orderid`, `fullname`, `phone`, `customerid`, `food`, `cafeid`) VALUES
(3, 'Betselot Kidane', '0949........', 4, 'firfir', 1),
(2, 'Betselot Kidane', '0949........', 4, 'firfir', 1),
(4, 'Betselot Kidane', '0949........', 4, 'pasta', 1),
(5, 'Betselot Kidane', '0949........', 4, 'firfir', 1),
(6, 'betsi', '1111', 1, 'firfir', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
