-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2015 at 07:10 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_pet`
--

-- --------------------------------------------------------

--
-- Table structure for table `breed`
--

CREATE TABLE IF NOT EXISTS `breed` (
  `breedId` int(11) NOT NULL AUTO_INCREMENT,
  `breedName` varchar(255) DEFAULT NULL,
  `petTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`breedId`),
  KEY `FK96262k7sq6765nwrgl4tqqb96` (`petTypeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `breed`
--

INSERT INTO `breed` (`breedId`, `breedName`, `petTypeId`) VALUES
(1, 'German Shepherd Dog', 1),
(2, 'Poodle', 1),
(3, 'English Mastiff', 1),
(4, 'Pug', 1),
(5, 'American Curl', 2),
(6, 'Bengal', 2);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `commentDate` datetime DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  `petId` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `FK132v0j82ck549xmb4hyshgg2l` (`ownerId`),
  KEY `FKkxd517kasb7bb1wul4lnu4c5p` (`petId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE IF NOT EXISTS `owner` (
  `ownerId` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `ownerName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ownerId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`ownerId`, `city`, `ownerName`, `password`, `userName`) VALUES
(1, 'Fairfield', 'Pradip Kharbuja', 'kharbuja', 'pradip'),
(2, 'Des Monies', 'Sanip Shrestha', 'shrestha', 'sanip');

-- --------------------------------------------------------

--
-- Table structure for table `pet`
--

CREATE TABLE IF NOT EXISTS `pet` (
  `petId` int(11) NOT NULL AUTO_INCREMENT,
  `petName` varchar(255) DEFAULT NULL,
  `petPhoto` tinyblob,
  `breedId` int(11) DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`petId`),
  KEY `FKfmco4cx4oc11gt4p1wd20r11j` (`breedId`),
  KEY `FKa6nbmu39v9jowkd7jqo1e1lyw` (`ownerId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `pet`
--

INSERT INTO `pet` (`petId`, `petName`, `petPhoto`, `breedId`, `ownerId`) VALUES
(1, 'Tommy', NULL, 1, 1),
(2, 'Doggy', NULL, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `pettype`
--

CREATE TABLE IF NOT EXISTS `pettype` (
  `petTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `petType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`petTypeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `pettype`
--

INSERT INTO `pettype` (`petTypeId`, `petType`) VALUES
(1, 'Dog'),
(2, 'Cat');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `breed`
--
ALTER TABLE `breed`
  ADD CONSTRAINT `FK96262k7sq6765nwrgl4tqqb96` FOREIGN KEY (`petTypeId`) REFERENCES `pettype` (`petTypeId`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK132v0j82ck549xmb4hyshgg2l` FOREIGN KEY (`ownerId`) REFERENCES `owner` (`ownerId`),
  ADD CONSTRAINT `FKkxd517kasb7bb1wul4lnu4c5p` FOREIGN KEY (`petId`) REFERENCES `pet` (`petId`);

--
-- Constraints for table `pet`
--
ALTER TABLE `pet`
  ADD CONSTRAINT `FKa6nbmu39v9jowkd7jqo1e1lyw` FOREIGN KEY (`ownerId`) REFERENCES `owner` (`ownerId`),
  ADD CONSTRAINT `FKfmco4cx4oc11gt4p1wd20r11j` FOREIGN KEY (`breedId`) REFERENCES `breed` (`breedId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
