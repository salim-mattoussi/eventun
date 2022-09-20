-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 16 sep. 2022 à 22:44
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `eventun`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(15) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `nom`, `login`, `pwd`) VALUES
(1, 'admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `idE` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `dateevent` date NOT NULL,
  `description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`idE`, `nom`, `lieu`, `dateevent`, `description`) VALUES
(1, 'test', 'test', '0000-00-00', 'test1');

-- --------------------------------------------------------

--
-- Structure de la table `publicite`
--

CREATE TABLE `publicite` (
  `id` int(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `publicite`
--

INSERT INTO `publicite` (`id`, `type`, `description`, `image`) VALUES
(4, 'test', 'test', 'test'),
(7, 'aaa', 'nullaa', 'nullaa'),
(9, '55test', 'test2333', 'test'),
(10, 'chayma', 'test', 'test'),
(11, 'chayma', 'test', 'test'),
(12, 'chaymazzzz', 'test', 'test'),
(13, 'xxx', 'test', 'test'),
(14, 'aqqqqqq', 'test', 'test'),
(15, 'test10', 'test10', 'test10');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `tickets`
--

CREATE TABLE `tickets` (
  `idT` int(100) NOT NULL,
  `idE` int(11) NOT NULL,
  `numero` int(100) NOT NULL,
  `prix` float NOT NULL,
  `promotion` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tickets`
--

INSERT INTO `tickets` (`idT`, `idE`, `numero`, `prix`, `promotion`) VALUES
(41114, 1, 6785, 865.2, 98645);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(100) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `telephone` int(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `image` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `Nom`, `Prenom`, `login`, `pwd`, `telephone`, `email`, `role`, `image`) VALUES
(3, 'chayma', 'chayma', 'chayma', 'chayma', 12345678, 'chaymaneffati1@gmail.com', 'User', ''),
(10, 'test', 'test', 'zz', 'a', 22554477, 'zzzzzzzz', 'event Manager', ''),
(18, 'wwcxvxv', 'xhxjbh', 'vvm', 'a', 88996633, 'aa', 'event Manager', NULL),
(19, 'sssxxx', 'ss', 'vv', 'x', 45678912, 'c', 'event Manager', NULL),
(20, 'testttttt', 'testtt', 'y', 'y', 12345678, 'y', 'advertising manager', NULL),
(21, 'exemple', 'exemple', 'vv', 'y', 12345678, 'v', 'advertising manager', NULL),
(22, 'azert', 'azerty', 'vv', 'a', 12345678, 'f', 'User', NULL),
(24, 'ùsumiblyu', ',!klj:khb;j', 'q', '1', 12345678, 'm', 'event Manager', NULL),
(26, 'ihuh', 'salima', 'vvfghj', 'bb', 12345678, '1', 'User', NULL),
(29, 'bbb', 'cccc', 'g', 'r', 15975365, 'e', 'advertising manager', NULL),
(30, 'wwsss', 'wwddddrrrrrrrrrrrrrrrrrrrr', 'hh', 'hh', 23258741, 'e', 'event Manager', NULL),
(33, 'exemple1', 'exemple1', 'exmp', 'exmp', 12345678, 'eee@gmail.com', 'responsable Publicité', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`idE`);

--
-- Index pour la table `publicite`
--
ALTER TABLE `publicite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`idT`),
  ADD KEY `Fk` (`idE`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `idE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `publicite`
--
ALTER TABLE `publicite`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tickets`
--
ALTER TABLE `tickets`
  MODIFY `idT` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41115;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `Fk` FOREIGN KEY (`idE`) REFERENCES `evenement` (`idE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
