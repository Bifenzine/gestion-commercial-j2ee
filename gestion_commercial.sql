-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 17 juil. 2024 à 12:33
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_commercial`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `admin_email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`admin_id`, `username`, `admin_email`, `password`) VALUES
(1, 'mohamed', 'm@gmail.com', 'mmm');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `IDclient` int(11) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `adresse` varchar(25) DEFAULT NULL,
  `cp` int(25) DEFAULT NULL,
  `ville` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`IDclient`, `nom`, `adresse`, `cp`, `ville`) VALUES
(1, 'mohamed', 'casa', 213654, 'casablanca');

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE `commandes` (
  `NumCMD` int(11) NOT NULL,
  `IDclient` int(11) DEFAULT NULL,
  `dteCmd` date DEFAULT NULL,
  `commentairs` varchar(100) DEFAULT NULL,
  `etatCMD` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commandes`
--

INSERT INTO `commandes` (`NumCMD`, `IDclient`, `dteCmd`, `commentairs`, `etatCMD`) VALUES
(1, 0, '2024-03-03', 'pc portable', 'parfaite'),
(2, 1, '2024-03-13', 'voiture', 'parfaite');

-- --------------------------------------------------------

--
-- Structure de la table `detail commandes`
--

CREATE TABLE `detail commandes` (
  `IDligneCMD` int(11) NOT NULL,
  `IDProduit` int(11) NOT NULL,
  `QT` int(11) NOT NULL,
  `prixVT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `familes`
--

CREATE TABLE `familes` (
  `IDFAM` int(11) NOT NULL,
  `intitule` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `familes`
--

INSERT INTO `familes` (`IDFAM`, `intitule`) VALUES
(1, 'père'),
(2, 'mère'),
(3, 'tomato'),
(4, 'potato');

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `IDProduit` int(11) NOT NULL,
  `IDFAM` int(11) DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `stkinvent` int(11) DEFAULT NULL,
  `stkactual` int(11) DEFAULT NULL,
  `prixuht` float DEFAULT NULL,
  `photo` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`IDProduit`, `IDFAM`, `designation`, `stkinvent`, `stkactual`, `prixuht`, `photo`) VALUES
(11, 1, 'rema update', 122, 111111, 100111, NULL),
(12, 2, 'kitab00000', 3000000, 1000000, 10101000, NULL),
(13, 1, 'tablette', 50, 500, 1000, NULL),
(14, 2, 'iphone ', 30, 100, 15000, NULL),
(15, 3, 'maserati', 5, 10, 1000000, NULL),
(16, 4, 'mercedes gt 63 couplet', 1, 3, 1800000, NULL),
(17, 3, 'supra', 12, 100, 1000000, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`IDclient`);

--
-- Index pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD PRIMARY KEY (`NumCMD`),
  ADD KEY `IDclient` (`IDclient`);

--
-- Index pour la table `detail commandes`
--
ALTER TABLE `detail commandes`
  ADD PRIMARY KEY (`IDligneCMD`),
  ADD UNIQUE KEY `IDProduit` (`IDProduit`);

--
-- Index pour la table `familes`
--
ALTER TABLE `familes`
  ADD PRIMARY KEY (`IDFAM`);

--
-- Index pour la table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`IDProduit`),
  ADD KEY `IDFAM` (`IDFAM`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `IDclient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `commandes`
--
ALTER TABLE `commandes`
  MODIFY `NumCMD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `detail commandes`
--
ALTER TABLE `detail commandes`
  MODIFY `IDligneCMD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `familes`
--
ALTER TABLE `familes`
  MODIFY `IDFAM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `IDProduit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `commandes_ibfk_2` FOREIGN KEY (`IDclient`) REFERENCES `clients` (`IDclient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `detail commandes`
--
ALTER TABLE `detail commandes`
  ADD CONSTRAINT `detail commandes_ibfk_1` FOREIGN KEY (`IDProduit`) REFERENCES `produits` (`IDProduit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `produits_ibfk_1` FOREIGN KEY (`IDFAM`) REFERENCES `familes` (`IDFAM`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
