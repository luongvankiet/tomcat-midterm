-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 13, 2018 lúc 06:40 PM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `estore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `categoryID` int(10) UNSIGNED NOT NULL,
  `categoryName` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`categoryID`, `categoryName`) VALUES
(1, 'Mobile Phone'),
(2, 'Tablet'),
(3, 'Laptop'),
(4, 'Desktop');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `orderID` int(11) UNSIGNED NOT NULL,
  `userID` int(10) UNSIGNED NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `detailID` int(10) UNSIGNED NOT NULL,
  `productID` int(10) UNSIGNED NOT NULL,
  `orderID` int(10) UNSIGNED NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `prodID` int(10) UNSIGNED NOT NULL,
  `prodName` varchar(255) COLLATE utf8_bin NOT NULL,
  `prodDetail` mediumtext COLLATE utf8_bin,
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` int(11) NOT NULL,
  `subCatID` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`prodID`, `prodName`, `prodDetail`, `image`, `price`, `subCatID`) VALUES
(5, 'Apple iPhone X 64GB Space Grey', '', 'assets/images/ipX.jpg', 1100, 7),
(6, 'Apple iPhone 7 Plus 128GB Jet Black', '', 'assets/images/ip7.jpg', 800, 7),
(7, 'Samsung Galaxy Note 8 64GB RAM 6GB 6.3 inch', '', 'assets/images/sg-note8.jpg', 900, 8),
(8, 'Samsung Galaxy S9 Plus 64GB RAM 6GB', '', 'assets/images/s9_1.jpg', 950, 8),
(9, 'Apple iPad 2018 Wi-Fi 32GB', 'Màn hình Retina 9.7inch\r\nBộ vi xử lí A10 cho hiệu năng hoạt động mạnh mẽ\r\nROM 32GB\r\nCamera 8 MP, FaceTime với độ phân giải HD\r\nTouch ID\r\nHỗ trợ bút Apple Pencil\r\n\r\n', 'assets/images/acmr7f2lla.jpg', 500, 9),
(10, 'Apple iPad Pro 10.5-inch Wi-Fi + Cellular 64GB Gold', 'Màn hình: IPS LCD, 10.5\"\r\nHệ điều hành: iOS 11\r\nCPU: Apple A10X 6 nhân 64-bit\r\nRAM: 4 GB\r\nBộ nhớ trong: 64 GB\r\nCamera sau: 12 MP\r\nCamera trước: 7 MP\r\nKết nối mạng: WiFi, 3G, 4G LTE\r\nHỗ trợ SIM\r\nNano Sim: HOTSIM VIETTEL DATA 7GB/tháng.\r\nĐàm thoại: FaceTime', 'assets/images/ipad-10.5inch.jpg', 850, 9),
(11, 'Samsung Galaxy Tab A 8.0 T385 (Gold)- 16Gb/ 8.0Inch/ 4G + Wifi', '', 'assets/images/samsung-galaxy-tab-a80.jpg', 450, 10),
(12, 'Máy tính xách tay/ Laptop Asus UX331UAL-EG020TS (i7-8550U) ', '- CPU: Intel Core i7-8550U (1.80 Ghz up to 4.00 Ghz, 8MB Cache)\r\n- RAM: 8GB LPDDR3 (Không nâng cấp)\r\n- Đồ họa: Intel UHD Graphics 620\r\n- Ổ cứng: SSD 512GB\r\n- Hỗ trợ khe cắm M.2: Không\r\n- Màn hình: 13\" (1920 x 1080), Webcam\r\n- Cổng giao tiếp: HDMI, USB Type-C, 2x USB 3.0\r\n- Wifi AC, Bluetooth 4.2, Finger print, Card reader, Led Keyboard\r\n- Khối lượng: 1.0 Kg, pin 3 cell\r\n- Hệ điều hành: Win 10 Home', 'assets/images/asus-zenbook-ux331ual-eg020ts-0.jpg', 1100, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sub_categories`
--

CREATE TABLE `sub_categories` (
  `subCatID` int(10) UNSIGNED NOT NULL,
  `subCatName` varchar(255) COLLATE utf8_bin NOT NULL,
  `categoryID` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `sub_categories`
--

INSERT INTO `sub_categories` (`subCatID`, `subCatName`, `categoryID`) VALUES
(1, 'Gaming Desktop', 4),
(2, 'All in one', 4),
(3, 'Asus', 3),
(4, 'HP', 3),
(5, 'Dell', 3),
(6, 'Acer', 3),
(7, 'Apple', 1),
(8, 'Samsung', 1),
(9, 'Apple', 2),
(10, 'Samsung', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `userID` int(10) UNSIGNED NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `phone` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`userID`, `email`, `username`, `password`, `phone`, `address`) VALUES
(1, 'user1@example.com', 'user1', '123', '0123456789', 'abcxyz'),
(2, 'user2@example.com', 'user2', '123', '01234561321', 'xyzabc');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categoryID`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `userID` (`userID`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`detailID`),
  ADD KEY `productID` (`productID`),
  ADD KEY `orderID` (`orderID`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`prodID`),
  ADD KEY `subCatID` (`subCatID`);

--
-- Chỉ mục cho bảng `sub_categories`
--
ALTER TABLE `sub_categories`
  ADD PRIMARY KEY (`subCatID`),
  ADD KEY `categoriesID` (`categoryID`),
  ADD KEY `categoriesID_2` (`categoryID`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `categoryID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `detailID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `prodID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `sub_categories`
--
ALTER TABLE `sub_categories`
  MODIFY `subCatID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `orderID` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productID` FOREIGN KEY (`productID`) REFERENCES `products` (`prodID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `subCatID` FOREIGN KEY (`subCatID`) REFERENCES `sub_categories` (`subCatID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sub_categories`
--
ALTER TABLE `sub_categories`
  ADD CONSTRAINT `categoryID` FOREIGN KEY (`categoryID`) REFERENCES `categories` (`categoryID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
