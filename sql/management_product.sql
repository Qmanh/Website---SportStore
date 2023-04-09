-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2023 at 08:42 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `management_product`
--

-- --------------------------------------------------------

--
-- Table structure for table `billaccept`
--

CREATE TABLE `billaccept` (
  `id` int(11) NOT NULL,
  `name_customer` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `id_product` int(11) NOT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `billaccept`
--

INSERT INTO `billaccept` (`id`, `name_customer`, `status`, `address`, `brand`, `color`, `id_product`, `order_date`, `price`, `product_name`, `quantity`, `size`) VALUES
(12, 'Manh', 'Accept', '96 Nguyen Son street', 'nike', 'green', 8, '08/04/2023 00:48:56', 2500000, 'NIKE TIEMPO LEGEND 8 PRO TF SPECTRUM', 1, 43),
(13, 'Nhax', 'Accept', '96 Nguyen Son street', 'mizuno', 'black', 18, '08/04/2023 00:50:32', 3000000, 'Mizuno Alpha Limited Edition', 1, 43),
(14, 'Manh', 'Accept', '96 Nguyen Son street', 'mizuno', 'white', 5, '08/04/2023 00:54:59', 3000000, 'MIZUNO WAVE CUP LEGEND AS TF LIMITED EDITION', 1, 43),
(15, 'Nhax', 'Deny', '96 Nguyen Son street', 'nike', 'pink', 4, '08/04/2023 00:55:09', 5600000, 'NIKE AIR ZOOM MERCURIAL SUPERFLY ACADEMY 9 TF DREAM SPEED 6', 2, 44),
(16, 'Nhax', 'Accept', '96 Nguyen Son street', 'nike', 'blue', 1, '08/04/2023 01:02:46', 2800000, 'NIKE AIR ZOOM MERCURIAL SUPERFLY 9 TF CR7', 1, 43);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `name_customer` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `id_product` int(11) NOT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `brand`, `color`, `image`, `name`, `price`) VALUES
(1, 'nike', 'blue', 'nikeCr7.png', 'NIKE AIR ZOOM MERCURIAL SUPERFLY 9 TF CR7', '2800000'),
(2, 'adidas', 'orange', 'messi_orange.png', 'ADIDAS X SPEEDPORTAL .3 TF L10NEL M35SI', '2200000'),
(3, 'nike', 'blue', 'nike_phantom.png', 'NIKE PHANTOM GT 2 PRO TF RENEW', '1800000'),
(4, 'nike', 'pink', 'nike_pink.png', 'NIKE AIR ZOOM MERCURIAL SUPERFLY ACADEMY 9 TF DREAM SPEED 6', '2800000'),
(5, 'mizuno', 'white', 'MIZUNO_WAVE_CUP_LEGEND.png', 'MIZUNO WAVE CUP LEGEND AS TF LIMITED EDITION', '3000000'),
(6, 'mizuno', 'blue', 'mizuno_mogela.png', 'MIZUNO MORELIA II CLUB AS TF AZURE BLUE', '2800000'),
(7, 'nike', 'black', 'phantom_black.png', 'NIKE PHANTOM GT 2 PRO TF RECHARGE', '1800000'),
(8, 'nike', 'green', 'tempo8.png', 'NIKE TIEMPO LEGEND 8 PRO TF SPECTRUM', '2500000'),
(9, 'nike', 'white', 'tempo9_legend.png', 'NIKE TIEMPO LEGEND 9 PRO TF BLAST', '2800000'),
(10, 'nike', 'white', 'tempo9_white.png', 'NIKE TIEMPO LEGEND 9 PRO TF ', '2500000'),
(11, 'adidas', 'white', 'ADIDAS_X_SPEEDFLOW.png', 'ADIDAS X SPEEDFLOW .1 TF WHITESPARK', '2000000'),
(12, 'adidas', 'yellow', 'adidas_messi.png', 'ADIDAS X SPEEDFLOW MESSI .1 TF MI HISTORIA', '2000000'),
(13, 'adidas', 'black', 'adidas_black.png', 'ADIDAS PREDATOR EDGE .1 TF GAME DATA', '1800000'),
(14, 'puma', 'blue', 'puma_futurez.png', 'PUMA FUTURE Z 1.4 CREATIVITY PRO CAGE TF', '2800000'),
(15, 'puma', 'orange', 'puma_ograne.png', 'PUMA ULTRA MATCH TT SUPERCHARGE', '3000000'),
(16, 'adidas', 'orange', 'adidas_pre.png', 'ADIDAS PREDATOR ACCURACY .3 TF NIGHTSTRIKE', '2000000'),
(17, 'puma', 'red', 'puma_red.png', 'PUMA FUTURE 1.4 PRO CAGE TT FEARLESS', '2500000'),
(19, 'mizuno', 'black', 'mizuno_alpha.png', 'Mizuno Alpha Limited Edition', '3000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billaccept`
--
ALTER TABLE `billaccept`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billaccept`
--
ALTER TABLE `billaccept`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
