-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 09, 2022 lúc 03:12 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Cơ sở dữ liệu: `aboutme`
--
CREATE DATABASE IF NOT EXISTS `aboutme` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `aboutme`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`Id`, `Name`) VALUES
(1, 'Công nghệ'),
(2, 'Lập trình'),
(3, 'Thư giản'),
(5, 'Phim Ảnh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chanduong`
--

DROP TABLE IF EXISTS `chanduong`;
CREATE TABLE `chanduong` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `Classify` varchar(255) NOT NULL,
  `Content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chanduong`
--

INSERT INTO `chanduong` (`Id`, `Name`, `Date`, `Classify`, `Content`) VALUES
(1, 'Đại học Huế- Sư phạm Vật lý 222', '2012-09-21', 'Học tập', 'Đại học Huế- Sư phạm Vật lý 222'),
(2, 'Trung Tâm đào tạo lập trình viên VinaENTER', '2017-02-15', 'Học tập', 'Học Lập trình PHP với Laravel FrameWork tại Trung Tâm đào tạo lập trình viên VinaENTER'),
(3, 'Trung Tâm đào tạo lập trình viên VinaENTER', '2017-06-23', 'Học tập', 'Trợ giảng PHP tại Trung Tâm đào tạo lập trình viên VinaENTER');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `Id` int(11) NOT NULL,
  `Id_N` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `comment`
--

INSERT INTO `comment` (`Id`, `Id_N`, `Name`, `Message`) VALUES
(1, 9, 'khanhly', 'mmm'),
(2, 4, 'trong', 'adsadsa'),
(5, 9, 'Phan Minh Chuẩn', '4546465'),
(6, 1, 'admindemo', 'test'),
(7, 3, 'Bé lên ba', 'Đỉnh đỉnh'),
(8, 7, 'truongui', 'tuyệt vời'),
(9, 5, 'Trần Quang Trường', 'hay'),
(10, 8, 'Bé lên ba', 'sfas'),
(13, 8, 'Trần Quang Trường', 'good'),
(18, 5, 'Trần Quang Trường', 'hay quas');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Phone` int(11) NOT NULL,
  `Content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `contact`
--

INSERT INTO `contact` (`Id`, `Name`, `Email`, `Address`, `Phone`, `Content`) VALUES
(1, 'ád', 'hbl160303@gmail.com', 'sđs', 364555018, 'fsfff'),
(2, 'ădsad', 'd@gamiul.com', 'ádsa', 324234, 'ádd'),
(4, 'Lê Dương Minh Lâm', 'minhlam1996vn@gmail.com', 'Phú Ninh - Quảng Nam', 364555018, 'kjhkjhjk'),
(5, 'Trần Quang Trường', 'tran74587@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'Trang web quá xịn xò'),
(7, 'Trần Quang Trường', 'qtruong29@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'hay quá'),
(8, 'Trần Quang Trường', 'ttruong2906@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'hay quá'),
(9, 'Trần Quang Trường', 'tran74587@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'dsadsadsadasdsa'),
(10, 'Trần Quang Trường', 'tran74587@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'sadasdas'),
(11, 'Trần Quang Trường', 'qtruong29@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'ưqewqewq'),
(12, 'Trần Quang Trường', 'tran74587@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'đâsdasdsadsa'),
(13, 'Trần Quang Trường', 'user01@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'ưqeqwewqewqe'),
(14, 'Trần Quang Trường', 'ttruong2906@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'ưqewqewqewq'),
(15, 'Trần Quang Trường', 'admin01@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'ewqewqewqewq'),
(16, 'Trần Quang Trường', 'admin01@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'sfsdfadsgfd'),
(17, 'Trần Quang Trường', 'qtruong29@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'rgd'),
(18, 'Trần Quang Trường', 'qtruong29@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'sadsadsa'),
(19, 'Trần Quang Trường', 'qtruong29@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'sadsadas'),
(20, 'Trần Quang Trường', 'qtruong29@gmail.com', 'Tam Hiep ,Nui Thanh , Quang Nam', 929380463, 'èdsgsdfshgf');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `information`
--

DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Date_Of_Birth` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Address` text NOT NULL,
  `Phone` int(11) NOT NULL,
  `Content` text NOT NULL,
  `Status` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `information`
--

INSERT INTO `information` (`Id`, `Name`, `Date_Of_Birth`, `Email`, `Address`, `Phone`, `Content`, `Status`) VALUES
(1, 'Hoàng Thanh Long', '08-06-1991', 'longht1.vinaenter@gmail.com', '81/52 Phạm Như Xương- Hòa Khánh- Đà Nẵng', 967006118, 'Tôi từng theo học ngành sư phạm tại Đại học sư phạm Huế. Cơ duyên đến với IT khi vô tình biết đến trung tâm đào tạo lập trình viên VinaENTER. Mong muốn trở thành một Web Developer.Hãy cùng tìm hiểu con đường đến với IT của tôi nhé!', 0),
(2, 'Hoàng Thanh Long', '08-06-1991', 'ymer8691@gmail.com', 'TDP2- Thị trấn Phú Lộc- Thừa Thiên Huế', 967006118, 'Tôi từng theo học ngành sư phạm tại Đại học sư phạm Huế. Cơ duyên đến với IT khi vô tình biết đến trung tâm đào tạo lập trình viên VinaENTER. Mong muốn trở thành một Web Developer.Hãy cùng tìm hiểu con đường đến với IT của tôi nhé!', 0),
(3, 'Trần Quang Trường', '2022-10-20', 'tran74587@gmail.com', 'Quảng Nam', 929380463, 'Siêu Cấp Vip Pro', 0),
(7, 'Trần Quang Trường', '2022-10-24', 'dsadasdasdas', 'dsadsadsadas', 929380463, 'sadsadsadsadsadas', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Id_Cat` int(11) NOT NULL,
  `Picture` text NOT NULL,
  `Status` int(11) NOT NULL DEFAULT 1,
  `MoTa` text NOT NULL,
  `ChiTiet` text NOT NULL,
  `View` int(11) NOT NULL DEFAULT 0,
  `Nguoiviet` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `news`
--

INSERT INTO `news` (`Id`, `Name`, `Id_Cat`, `Picture`, `Status`, `MoTa`, `ChiTiet`, `View`, `Nguoiviet`) VALUES
(1, 'Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 3, 'girl_xinh_2_800x400-45479094055600.jpg', 0, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 9, 'Admin'),
(2, 'Cai nghiện smartphone bằng mẹo đơn giản không ngờ từ cựu kỹ sư Google', 3, '1XoUAI7p7rmZJqpXd1i9RIkymmKEVA7nuIA7RqmP-12123366439000.jpeg', 1, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 2, 'Admin'),
(3, 'Huyền thoại Con đường tơ lụa trên đất nước Uzbekistan', 3, '6M753H4TLs1eRMva9ncXxTMjmsC81F9QlTGkM8IQ-12106730848900.png', 1, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 7, 'Nhân Viên'),
(4, 'Đánh giá tai nghe chơi game Logitech G433: Tai nghe 7.1 siêu nhẹ dành cho game thủ', 3, 'girl_xinh_2_800x400-45462920181900.jpg', 0, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 3, 'Admin'),
(5, 'LM002 - SUV đầu tiên của Lamborghini và những góc khuất ít ai biết', 2, 'meo-de-thuong-nghieng-dau-noi-o-136226602602900.webp', 1, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 4, 'Admin'),
(6, 'Não bộ không được ', 2, 'simple-45436803570800.png', 0, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 0, 'Nhân viên'),
(7, 'Xiaomi giới thiệu lõi khóa thông minh Vima Smart Lock Cylinder, giá 1,4 triệu đồng', 2, 'chu-136205484181000.png', 1, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 2, 'Admin'),
(8, 'Muốn lương 35 triệu/tháng tại Việt Nam - Hãy học Machine Learning, Big Data', 2, 'meo7-136153714905800.jpg', 1, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 3, 'Admin'),
(9, 'Với iPhone X, anh chàng lập trình viên này đã biến khuôn mặt của mình trở nên vô hình', 2, '245040965_132526062457765_8267775622535581677_n-45418579335500.jpg', 1, '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', '	Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 2, 'Nhân viên'),
(10, 'Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 2, 'chu-45355312413100.png', 1, 'Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 'Căn hộ 29m2 của chàng sinh viên với nội thất vô cùng tiện nghi', 5, 'Nhân viên'),
(11, 'Trần Quang Trường', 5, '245040965_132526062457765_8267775622535581677_n-136137688989900.jpg', 1, 'dsdasdasdasd', 'ádasdasda', 3, 'Nhân viên'),
(14, 'Trần Quang Trường', 2, '6M753H4TLs1eRMva9ncXxTMjmsC81F9QlTGkM8IQ-35538595007200.png', 1, 'ádsadasda', '<p>&aacute;dasdasdas</p>\r\n', 4, 'Nhân viên'),
(15, 'Vợt cầu lông Adidas Advantage Clean', 1, 'mMOWzhGLyjfBoQWrU6AU5U0Q3DnN5EmPX6zJrUdt-35766624488700.png', 0, 'MÔ Tả Vợt cầu lông Adidas Advantage Clean', '<p>Chi tiết&nbsp;Vợt cầu l&ocirc;ng Adidas Advantage Clean</p>\r\n', 0, 'Admin'),
(16, 'Vợt cầu lông Adidas Advantage Clean', 2, '678-101225199937200.jpeg', 0, 'hay', 'hay qua', 0, 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Link` varchar(255) NOT NULL,
  `Picture` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `project`
--

INSERT INTO `project` (`Id`, `Name`, `Link`, `Picture`) VALUES
(1, 'Website chia sẽ kiến thức công nghệ ShareIT', 'http://shareit1.vinaenter.net/', 'mMOWzhGLyjfBoQWrU6AU5U0Q3DnN5EmPX6zJrUdt-12213776427400.png'),
(2, 'Trang CV Long Hoàng', 'https://longhoangcv.000webhostapp.com/', 'ROI-12200795690400.png'),
(3, 'Website giới thiệu thư viện truyện Bstory', 'http://bstory.vinaenter.edu.vn/', 'anhso30-12187784318100.jpg'),
(4, 'Website giới thiệu bản thân- Aboutme', 'http://aboutme1.vinaenter.net', '6M753H4TLs1eRMva9ncXxTMjmsC81F9QlTGkM8IQ-12171789019800.png'),
(5, 'Dự án google', 'http:/google.com/', '678-35178570625499.jpeg'),
(9, 'Dự Án Hacker', 'http:/google.cods', 'chu-58384112499300.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `skill`
--

DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
  `Id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `skill`
--

INSERT INTO `skill` (`Id`, `Name`, `Value`) VALUES
(1, 'HTML', 85),
(2, 'CSS', 80),
(3, 'JAVASCRIPT', 75),
(4, 'PHP', 85),
(5, 'LARAVEL', 80),
(6, 'Phim Ảnh', 70),
(9, 'Bé lên ba', 90);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `FullName` varchar(255) NOT NULL,
  `Position` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`Id`, `UserName`, `Password`, `FullName`, `Position`) VALUES
(1, 'admin', '247830941fee58a10ac3bdeab054e552', 'Trần Quang Trường', 'Admin'),
(2, 'admindemo', 'zanzan29', 'Trần Quang Trường', 'Admin'),
(3, 'truong', 'zanzan29', 'truong', 'Nhân viên'),
(4, 'truongdeptrai', '247830941fee58a10ac3bdeab054e552', 'Quang Trường', 'Admin'),
(5, 'truongday', '247830941fee58a10ac3bdeab054e552', 'Trường', 'Nhân viên');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `chanduong`
--
ALTER TABLE `chanduong`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`Id`,`Id_N`),
  ADD KEY `Id_N` (`Id_N`);

--
-- Chỉ mục cho bảng `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`Id`,`Id_Cat`),
  ADD KEY `Id_Cat` (`Id_Cat`);

--
-- Chỉ mục cho bảng `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `chanduong`
--
ALTER TABLE `chanduong`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `comment`
--
ALTER TABLE `comment`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `contact`
--
ALTER TABLE `contact`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `information`
--
ALTER TABLE `information`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `news`
--
ALTER TABLE `news`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `project`
--
ALTER TABLE `project`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `skill`
--
ALTER TABLE `skill`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`Id_N`) REFERENCES `news` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `news_ibfk_1` FOREIGN KEY (`Id_Cat`) REFERENCES `categories` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
