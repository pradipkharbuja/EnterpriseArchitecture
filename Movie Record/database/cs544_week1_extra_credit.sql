-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2015 at 07:32 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cs544_week1_extra_credit`
--

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE IF NOT EXISTS `artist` (
  `artistId` int(11) NOT NULL AUTO_INCREMENT,
  `biography` varchar(255) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture` tinyblob,
  `placeOfBirth` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`artistId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`artistId`, `biography`, `dateOfBirth`, `name`, `picture`, `placeOfBirth`) VALUES
(1, NULL, '1981-07-10', 'James Bond', NULL, 'USA'),
(2, NULL, '1988-03-01', 'Julia Roberts', NULL, 'UK'),
(3, NULL, '1986-05-04', 'Will Smith', NULL, 'Australia');

-- --------------------------------------------------------

--
-- Table structure for table `director`
--

CREATE TABLE IF NOT EXISTS `director` (
  `directorId` int(11) NOT NULL AUTO_INCREMENT,
  `directorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`directorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `director`
--

INSERT INTO `director` (`directorId`, `directorName`) VALUES
(1, 'J.J. Abrams'),
(2, 'Barry Levinson');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `movieId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `poster` tinyblob,
  `rating` double NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`movieId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movieId`, `name`, `poster`, `rating`, `summary`, `year`) VALUES
(1, 'Casino Royal 007', NULL, 4, NULL, 2007),
(2, 'The Bourne Legacy', NULL, 5, NULL, 2012);

-- --------------------------------------------------------

--
-- Table structure for table `moviecharacter`
--

CREATE TABLE IF NOT EXISTS `moviecharacter` (
  `movieCharacterId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movieCharacterId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `moviecharacter`
--

INSERT INTO `moviecharacter` (`movieCharacterId`, `name`) VALUES
(1, 'Captain Sparrow'),
(2, 'Salsa');

-- --------------------------------------------------------

--
-- Table structure for table `movie_artist`
--

CREATE TABLE IF NOT EXISTS `movie_artist` (
  `movie_id` int(11) NOT NULL,
  `artist_id` int(11) NOT NULL,
  KEY `FK2tef3muges8ryybsdpguvknux` (`artist_id`),
  KEY `FKj1vjj9fqr150l9h1uo4do0sn2` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie_artist`
--

INSERT INTO `movie_artist` (`movie_id`, `artist_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `movie_comments`
--

CREATE TABLE IF NOT EXISTS `movie_comments` (
  `movie_id` int(11) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  KEY `FKtggk4sfhrax6khydo289fgw9d` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `movie_director`
--

CREATE TABLE IF NOT EXISTS `movie_director` (
  `movie_id` int(11) NOT NULL,
  `director_id` int(11) NOT NULL,
  KEY `FKfvj0imcv2raipqtnugf5tdg5c` (`director_id`),
  KEY `FK77h3dupfybpl9rptmuunbpciv` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie_director`
--

INSERT INTO `movie_director` (`movie_id`, `director_id`) VALUES
(1, 1),
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `movie_genres`
--

CREATE TABLE IF NOT EXISTS `movie_genres` (
  `movie_id` int(11) NOT NULL,
  `genres` varchar(255) DEFAULT NULL,
  KEY `FKrc1pcbg6umlafxv01a3cb1jwf` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie_genres`
--

INSERT INTO `movie_genres` (`movie_id`, `genres`) VALUES
(1, 'ACTION'),
(1, 'SCFI'),
(2, 'ACTION');

-- --------------------------------------------------------

--
-- Table structure for table `movie_moviecharacter`
--

CREATE TABLE IF NOT EXISTS `movie_moviecharacter` (
  `movie_id` int(11) NOT NULL,
  `moviecharacter_id` int(11) NOT NULL,
  KEY `FK7yxe0ke66f7qfn7n9xwn0eosl` (`moviecharacter_id`),
  KEY `FK1sqesgk5rjjlad1qfy1pulbe2` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie_moviecharacter`
--

INSERT INTO `movie_moviecharacter` (`movie_id`, `moviecharacter_id`) VALUES
(1, 1),
(2, 1),
(2, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `movie_artist`
--
ALTER TABLE `movie_artist`
  ADD CONSTRAINT `FKj1vjj9fqr150l9h1uo4do0sn2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movieId`),
  ADD CONSTRAINT `FK2tef3muges8ryybsdpguvknux` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`artistId`);

--
-- Constraints for table `movie_comments`
--
ALTER TABLE `movie_comments`
  ADD CONSTRAINT `FKtggk4sfhrax6khydo289fgw9d` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movieId`);

--
-- Constraints for table `movie_director`
--
ALTER TABLE `movie_director`
  ADD CONSTRAINT `FK77h3dupfybpl9rptmuunbpciv` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movieId`),
  ADD CONSTRAINT `FKfvj0imcv2raipqtnugf5tdg5c` FOREIGN KEY (`director_id`) REFERENCES `director` (`directorId`);

--
-- Constraints for table `movie_genres`
--
ALTER TABLE `movie_genres`
  ADD CONSTRAINT `FKrc1pcbg6umlafxv01a3cb1jwf` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movieId`);

--
-- Constraints for table `movie_moviecharacter`
--
ALTER TABLE `movie_moviecharacter`
  ADD CONSTRAINT `FK1sqesgk5rjjlad1qfy1pulbe2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movieId`),
  ADD CONSTRAINT `FK7yxe0ke66f7qfn7n9xwn0eosl` FOREIGN KEY (`moviecharacter_id`) REFERENCES `moviecharacter` (`movieCharacterId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
