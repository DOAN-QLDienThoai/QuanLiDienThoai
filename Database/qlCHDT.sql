-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2025 at 02:04 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlidienthoai`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maPN` int(11) DEFAULT NULL,
  `maPhienBan` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` int(11) DEFAULT NULL,
  `hinhthucnhap` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `maPX` varchar(10) DEFAULT NULL,
  `maPhienBan` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `dongia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`maPX`, `maPhienBan`, `soluong`, `dongia`) VALUES
('PX1', 29, 1, 18000000),
('PX1', 50, 1, 16500000),
('PX1', 49, 1, 15500000),
('PX1', 40, 1, 13000000),
('PX2', 3, 1, 20000000),
('PX4', 29, 1, 18000000),
('PX5', 50, 1, 16500000),
('PX6', 49, 1, 15500000),
('PX7', 40, 1, 13000000),
('PX8', 3, 1, 20000000),
('PX9', 29, 1, 18000000),
('PX10', 50, 1, 16500000),
('PX11', 49, 1, 15500000),
('PX12', 40, 1, 13000000),
('PX13', 3, 1, 20000000),
('PX14', 29, 1, 18000000),
('PX15', 50, 1, 16500000),
('PX16', 49, 1, 15500000),
('PX17', 40, 1, 13000000),
('PX18', 3, 1, 20000000),
('PX19', 29, 1, 18000000),
('PX20', 3, 1, 20000000),
('PX21', 3, 1, 20000000),
('PX22', 29, 1, 18000000),
('PX23', 50, 1, 16500000),
('PX24', 49, 1, 15500000),
('PX25', 50, 1, 16500000),
('PX26', 40, 1, 13000000),
('PX27', 3, 1, 20000000),
('PX28', 29, 1, 18000000),
('PX29', 49, 1, 15500000),
('PX30', 50, 1, 16500000),
('PX31', 3, 1, 20000000),
('PX32', 40, 1, 13000000),
('PX33', 29, 1, 18000000),
('PX34', 40, 2, 13000000),
('PX34', 33, 2, 14000000),
('PX34', 30, 2, 15000000),
('PX35', 29, 4, 18000000),
('PX35', 32, 1, 12000000),
('PX35', 33, 1, 14000000),
('PX35', 26, 1, 16000000),
('PX35', 30, 1, 15000000),
('PX35', 24, 1, 18000000),
('PX35', 3, 1, 20000000),
('PX36', 28, 1, 16500000),
('PX37', 21, 1, 21000000),
('PX37', 24, 1, 18000000);

-- --------------------------------------------------------

--
-- Table structure for table `dienthoai`
--

CREATE TABLE `dienthoai` (
  `maDT` int(11) NOT NULL,
  `tenDT` varchar(50) DEFAULT NULL,
  `maHDH` int(11) DEFAULT NULL,
  `maThuongHieu` int(11) DEFAULT NULL,
  `chipXuLy` varchar(60) DEFAULT NULL,
  `dungLuongPin` int(11) DEFAULT NULL,
  `kichThuocMan` float DEFAULT NULL,
  `hinhanh` varchar(70) DEFAULT NULL,
  `soLuongTon` int(11) DEFAULT 0,
  `trangThai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dienthoai`
--

INSERT INTO `dienthoai` (`maDT`, `tenDT`, `maHDH`, `maThuongHieu`, `chipXuLy`, `dungLuongPin`, `kichThuocMan`, `hinhanh`, `soLuongTon`, `trangThai`) VALUES
(1, 'iPhone 13', 2, 1, 'A15 Bionic', 3095, 6.1, 'iphone13.jpg', 100, 1),
(2, 'i phỏn', 2, 1, 'ioss', 123, 123, 'C:\\Users\\LE MINH HUY\\OneDrive\\Desktop\\java.jpg', 0, 1),
(3, 'iPhone 12', 2, 1, 'A14 Bionic', 2815, 6.1, 'iphone12.jpg', 80, 1),
(4, 'Samsung Galaxy S21', 1, 2, 'Exynos 2100', 4000, 6.2, 's21.jpg', 100, 1),
(5, 'Xiaomi Mi 11', 1, 3, 'Snapdragon 888', 4600, 6.81, 'mi11.jpg', 60, 1),
(6, 'Oppo Reno6', 1, 4, 'Dimensity 900', 4300, 6.43, 'reno6.jpg', 50, 1),
(7, 'Vivo V23', 1, 5, 'Dimensity 920', 4200, 6.44, 'vivov23.jpg', 45, 1),
(8, 'iPhone SE 2022', 2, 1, 'A15 Bionic', 2018, 4.7, 'iphonese2022.jpg', 30, 1),
(9, 'Samsung A52', 1, 2, 'Snapdragon 720G', 4500, 6.5, 'a52.jpg', 70, 1),
(10, 'Xiaomi Redmi Note 10', 1, 3, 'Snapdragon 678', 5000, 6.43, 'note10.jpg', 90, 1),
(11, 'Realme GT Neo', 1, 6, 'Dimensity 1200', 4500, 6.43, 'gtneo.jpg', 65, 1),
(12, 'iPhone 11', 2, 1, 'A13 Bionic', 3110, 6.1, 'iphone11.jpg', 85, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hedieuhanh`
--

CREATE TABLE `hedieuhanh` (
  `maHDH` int(11) NOT NULL,
  `tenHDH` varchar(30) DEFAULT NULL,
  `trangThai` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hedieuhanh`
--

INSERT INTO `hedieuhanh` (`maHDH`, `tenHDH`, `trangThai`) VALUES
(1, 'Android', 1),
(2, 'iOS', 1),
(3, 'HarmonyOS', 1),
(4, 'KaiOS', 1);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `maKh` varchar(20) NOT NULL,
  `tenKh` varchar(100) DEFAULT NULL,
  `sdtKh` varchar(15) DEFAULT NULL,
  `diachiKh` varchar(255) DEFAULT NULL,
  `ngayThamGia` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`maKh`, `tenKh`, `sdtKh`, `diachiKh`, `ngayThamGia`) VALUES
('KH001', 'Nguyễn Văn A', '0912345678', '123 Lê Lợi, Quận 1, TP.HCM', '2023-01-15'),
('KH002', 'Trần Thị B', '0938765432', '456 Trần Hưng Đạo, Quận 5, TP.HCM', '2023-03-22'),
('KH004', 'Phạm Thị D', '0905123123', '12 Nguyễn Huệ, Quận 1, TP.HCM', '2022-11-30'),
('KH005', 'Hồ Văn E', '0909090909', '99 Lý Thường Kiệt, Quận Tân Bình, TP.HCM', '2024-08-01'),
('KH006', 'Nguyễn Thị F', '0900000006', '12 Nguyễn Văn Linh, TP.HCM', '2023-06-01'),
('KH007', 'Lê Văn G', '0900000007', '34 Cộng Hòa, Tân Bình', '2023-06-02'),
('KH008', 'Trần Thị H', '0900000008', '56 Nguyễn Oanh, Gò Vấp', '2023-06-03'),
('KH009', 'Phạm Văn I', '0900000009', '78 Nguyễn Kiệm, Phú Nhuận', '2023-06-04'),
('KH010', 'Vũ Thị K', '0900000010', '90 Trường Chinh, Tân Phú', '2023-06-05'),
('KH011', 'Hoàng Văn L', '0900000011', '12 Lê Lai, Quận 1', '2023-06-06'),
('KH012', 'Nguyễn Văn M', '0900000012', '45 Lý Tự Trọng, Quận 1', '2023-06-07'),
('KH013', 'Trần Văn N', '0900000013', '89 Pasteur, Quận 3', '2023-06-08'),
('KH014', 'Lê Thị O', '0900000014', '100 Lê Thánh Tôn, Quận 1', '2023-06-09'),
('KH015', 'Ngô Văn P', '0900000015', '11 Phạm Hùng, Bình Chánh', '2023-06-10'),
('KH016', 'Bùi Thị Q', '0900000016', '88 Hùng Vương, Quận 5', '2023-06-11'),
('KH017', 'Đặng Văn R', '0900000017', '21 Lý Thường Kiệt, Tân Bình', '2023-06-12'),
('KH018', 'Dương Thị S', '0900000018', '33 Trần Hưng Đạo, Quận 5', '2023-06-13'),
('KH019', 'Võ Văn T', '0900000019', '72 Điện Biên Phủ, Bình Thạnh', '2023-06-14'),
('KH020', 'Lý Thị U', '0900000020', '64 Nguyễn Văn Đậu, Bình Thạnh', '2023-06-15'),
('KH021', 'Đỗ Văn V', '0900000021', '18 Võ Văn Ngân, Thủ Đức', '2023-06-16'),
('KH022', 'Phạm Thị X', '0900000022', '56 Lê Đức Thọ, Gò Vấp', '2023-06-17'),
('KH023', 'Trịnh Văn Y', '0900000023', '19 Nguyễn Trãi, Quận 1', '2023-06-18'),
('KH024', 'Lâm Thị Z', '0900000024', '83 Xô Viết Nghệ Tĩnh, Bình Thạnh', '2023-06-19'),
('KH025', 'Nguyễn Văn A1', '0900000025', '20 Phan Văn Trị, Gò Vấp', '2023-06-20'),
('KH026', 'Trần Thị B1', '0900000026', '43 Cách Mạng Tháng 8, Q10', '2023-06-21'),
('KH027', 'Lê Văn C1', '0900000027', '55 Nguyễn Du, Quận 1', '2023-06-22'),
('KH028', 'Phạm Thị D1', '0900000028', '67 Tôn Đức Thắng, Q1', '2023-06-23'),
('KH029', 'Hồ Văn E1', '0900000029', '98 Nam Kỳ Khởi Nghĩa, Q3', '2023-06-24'),
('KH030', 'Ngô Thị F1', '0900000030', '74 Nguyễn Huệ, Quận 1', '2023-06-25'),
('KH031', 'Đoàn Văn G1', '0900000031', '38 Trần Phú, Q5', '2023-06-26'),
('KH032', 'Bùi Thị H1', '0900000032', '62 Nguyễn Thiện Thuật, Q3', '2023-06-27'),
('KH033', 'Đặng Văn I1', '0900000033', '50 Phan Xích Long, Phú Nhuận', '2023-06-28'),
('KH034', 'Dương Thị K1', '0900000034', '37 Hoàng Diệu, Q4', '2023-06-29'),
('KH035', 'Võ Văn L1', '0900000035', '14 Nguyễn Đình Chiểu, Q1', '2023-06-30');

-- --------------------------------------------------------

--
-- Table structure for table `mausac`
--

CREATE TABLE `mausac` (
  `maMau` int(11) NOT NULL,
  `tenMau` varchar(30) DEFAULT NULL,
  `trangThai` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mausac`
--

INSERT INTO `mausac` (`maMau`, `tenMau`, `trangThai`) VALUES
(1, 'Đen', 1),
(2, 'Trắng', 1),
(3, 'Xanh dương', 1),
(4, 'Đỏ', 1),
(5, 'Vàng', 1),
(6, 'Xanh lá', 1),
(7, 'Tím', 1),
(8, 'Hồng', 1),
(9, 'Bạc', 1),
(10, 'Xám', 1),
(11, 'Cam', 1),
(12, 'Nâu', 1),
(13, 'Xanh ngọc', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNCC` int(11) NOT NULL,
  `tenNCC` varchar(70) DEFAULT NULL,
  `diaChi` varchar(100) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `trangThai` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNCC`, `tenNCC`, `diaChi`, `sdt`, `email`, `trangThai`) VALUES
(1, 'Công Ty TNHH Samsung Việt Nam', 'KCN Yên Phong, Bắc Ninh', '0222222333', 'contact@samsung.com', 1),
(2, 'Công Ty TNHH Apple Việt Nam', 'Quận 1, TP Hồ Chí Minh', '02812345678', 'info@apple.com', 1),
(3, 'Công Ty TNHH Xiaomi Việt Nam', 'Cầu Giấy, Hà Nội', '02456781234', 'support@xiaomi.com', 1),
(4, 'Công Ty TNHH Oppo Việt Nam', 'Thanh Xuân, Hà Nội', '02499887766', 'hotro@oppo.com', 1),
(5, 'Công Ty TNHH Vivo Việt Nam', 'Quận 7, TP Hồ Chí Minh', '02866778899', 'contact@vivo.com', 1),
(6, 'Công Ty TNHH Realme Việt Nam', 'Tân Bình, TP Hồ Chí Minh', '02812349876', 'realmevn@realme.com', 1),
(7, 'Công Ty TNHH Nokia Việt Nam', 'Hoàng Mai, Hà Nội', '02411223344', 'nokia@hmd.com', 1),
(8, 'Công Ty TNHH Sony Việt Nam', 'Quận 3, TP Hồ Chí Minh', '02855443322', 'sonyvn@sony.com', 1),
(9, 'Công Ty TNHH Asus Việt Nam', 'Đống Đa, Hà Nội', '02433221100', 'asusvn@asus.com', 1),
(10, 'Công Ty TNHH Lenovo Việt Nam', 'Bình Thạnh, TP Hồ Chí Minh', '02887654321', 'lenovovn@lenovo.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNV` varchar(10) NOT NULL,
  `hoTen` varchar(50) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `gioiTinh` varchar(11) DEFAULT NULL,
  `sdt` varchar(10) DEFAULT NULL,
  `trangThai` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`maNV`, `hoTen`, `ngaySinh`, `gioiTinh`, `sdt`, `trangThai`) VALUES
('1', 'Nguyễn Văn An', '1995-05-20', 'Nam', '0912345678', 1),
('10', 'Ngô Thị Mai', '1991-04-29', 'Nữ', '0921345678', 1),
('11', 'Tạ Văn Nam', '2001-02-14', 'Nam', '0911122233', 1),
('12', 'Đặng Thị Oanh', '1990-10-07', 'Nữ', '0933456789', 1),
('13', 'Trịnh Văn Phong', '1995-07-22', 'Nam', '0977777777', 1),
('14', 'Phan Thị Quỳnh', '1998-12-01', 'Nữ', '0944444444', 1),
('15', 'Tô Minh Sơn', '1996-06-17', 'Nam', '0988888888', 1),
('16', 'Châu Thị Thanh', '2002-08-09', 'Nữ', '0909090909', 1),
('17', 'Lý Văn Trí', '1997-03-05', 'Nam', '0959595959', 1),
('18', 'Đinh Thị Uyên', '1993-09-30', 'Nữ', '0939393939', 1),
('19', 'Kiều Văn Vinh', '2000-05-11', 'Nam', '0919191919', 1),
('2', 'Trần Thị Bảo', '1998-08-15', 'Nữ', '0987654321', 1),
('20', 'Hồ Thị Yến', '1994-11-22', 'Nữ', '0929292929', 1),
('3', 'Lê Hoàng Châu', '1992-12-10', 'Nam', '0909123456', 1),
('4', 'Phạm Thị Dung', '2000-03-25', 'Nữ', '0911222333', 1),
('5', 'Đỗ Minh Đức', '1997-07-30', 'Nam', '0977123456', 1),
('6', 'Bùi Thị Hoa', '1996-01-05', 'Nữ', '0934567890', 1),
('7', 'Huỳnh Minh Khang', '1999-06-18', 'Nam', '0967891234', 1),
('8', 'Vũ Thị Lan', '1994-09-21', 'Nữ', '0954321987', 1),
('9', 'Hoàng Văn Long', '1993-11-12', 'Nam', '0943219876', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phienbandienthoai`
--

CREATE TABLE `phienbandienthoai` (
  `maPhienBan` int(11) NOT NULL,
  `maDT` int(11) DEFAULT NULL,
  `maRam` int(11) DEFAULT NULL,
  `maRom` int(11) DEFAULT NULL,
  `maMau` int(11) DEFAULT NULL,
  `giaNhap` decimal(18,2) DEFAULT NULL,
  `giaXuat` decimal(18,2) DEFAULT NULL,
  `soLuongTon` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phienbandienthoai`
--

INSERT INTO `phienbandienthoai` (`maPhienBan`, `maDT`, `maRam`, `maRom`, `maMau`, `giaNhap`, `giaXuat`, `soLuongTon`) VALUES
(3, 1, 4, 3, 1, 17000000.00, 20000000.00, 52),
(4, 1, 5, 4, 2, 19000000.00, 22000000.00, 31),
(5, 2, 6, 13, 5, 1000000.00, 2000000.00, 0),
(20, 3, 1, 4, 1, 18000000.00, 20000000.00, 31),
(21, 3, 2, 2, 2, 19000000.00, 21000000.00, 20),
(22, 4, 2, 4, 3, 20000000.00, 23000000.00, 41),
(23, 4, 3, 5, 4, 22000000.00, 25000000.00, 30),
(24, 5, 3, 5, 2, 16000000.00, 18000000.00, 38),
(25, 5, 4, 2, 1, 17000000.00, 19000000.00, 20),
(26, 6, 2, 4, 1, 13000000.00, 16000000.00, 26),
(27, 6, 2, 5, 4, 14000000.00, 17000000.00, 25),
(28, 7, 3, 4, 2, 13500000.00, 16500000.00, 32),
(29, 8, 1, 3, 5, 14500000.00, 18000000.00, 22),
(30, 9, 2, 4, 3, 12000000.00, 15000000.00, 41),
(31, 9, 3, 5, 4, 12500000.00, 16000000.00, 30),
(32, 10, 2, 4, 2, 9500000.00, 12000000.00, 61),
(33, 11, 3, 4, 1, 11500000.00, 14000000.00, 44),
(34, 3, 1, 4, 1, 18000000.00, 20000000.00, 30),
(35, 3, 2, 2, 2, 19000000.00, 21000000.00, 25),
(36, 3, 3, 3, 3, 20000000.00, 22000000.00, 20),
(37, 4, 2, 2, 4, 15000000.00, 18000000.00, 41),
(38, 4, 2, 5, 5, 16000000.00, 19000000.00, 35),
(39, 4, 3, 6, 1, 17000000.00, 20000000.00, 30),
(40, 5, 2, 2, 2, 11000000.00, 13000000.00, 30),
(41, 5, 2, 5, 3, 12000000.00, 14000000.00, 25),
(42, 5, 3, 6, 4, 13000000.00, 15000000.00, 20),
(43, 6, 1, 1, 5, 10000000.00, 12000000.00, 30),
(44, 6, 2, 2, 1, 11000000.00, 13000000.00, 25),
(45, 6, 2, 5, 2, 12000000.00, 14000000.00, 20),
(46, 7, 2, 2, 3, 10500000.00, 12500000.00, 20),
(47, 7, 2, 5, 4, 11500000.00, 13500000.00, 20),
(48, 7, 3, 6, 5, 12500000.00, 14500000.00, 15),
(49, 8, 2, 2, 1, 14000000.00, 15500000.00, 31),
(50, 8, 2, 5, 2, 15000000.00, 16500000.00, 25),
(51, 8, 3, 6, 3, 16000000.00, 17500000.00, 20),
(52, 9, 2, 2, 2, 9000000.00, 10500000.00, 40),
(53, 9, 2, 5, 3, 9500000.00, 11000000.00, 35),
(54, 9, 3, 6, 4, 10000000.00, 11500000.00, 30),
(55, 10, 2, 2, 5, 8500000.00, 10000000.00, 50),
(56, 10, 3, 5, 1, 9000000.00, 10500000.00, 40),
(57, 10, 3, 6, 2, 9500000.00, 11000000.00, 30),
(58, 11, 2, 2, 3, 9500000.00, 11000000.00, 30),
(59, 11, 3, 5, 4, 10000000.00, 11500000.00, 25),
(60, 11, 3, 6, 5, 10500000.00, 12000000.00, 20),
(61, 12, 2, 2, 1, 14000000.00, 15500000.00, 80),
(62, 12, 2, 5, 2, 15000000.00, 16500000.00, 30),
(63, 12, 3, 6, 3, 16000000.00, 17500000.00, 20);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPN` int(11) NOT NULL,
  `thoigian` datetime DEFAULT NULL,
  `maNCC` int(11) DEFAULT NULL,
  `maNV` varchar(10) DEFAULT NULL,
  `tongtien` bigint(20) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maPX` varchar(10) NOT NULL,
  `thoigian` datetime DEFAULT NULL,
  `maNV` varchar(10) DEFAULT NULL,
  `maKh` varchar(20) DEFAULT NULL,
  `tongtien` bigint(20) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`maPX`, `thoigian`, `maNV`, `maKh`, `tongtien`, `trangthai`) VALUES
('PX1', '2025-04-18 16:58:06', 'NV001', 'KH003', 63000000, 1),
('PX2', '2025-04-18 16:58:15', 'NV001', 'KH002', 20000000, 1),
('PX3', '2025-04-18 16:58:24', 'NV001', 'KH001', 23000000, 0),
('PX4', '2025-04-18 17:00:00', 'NV001', 'KH001', 30000000, 1),
('PX5', '2025-04-18 17:02:00', 'NV001', 'KH002', 18000000, 1),
('PX6', '2025-04-18 17:03:00', 'NV001', 'KH003', 24500000, 1),
('PX7', '2025-04-18 17:04:00', 'NV001', 'KH001', 11000000, 1),
('PX8', '2025-04-18 17:05:00', 'NV001', 'KH002', 36000000, 1),
('PX9', '2025-04-18 17:06:00', 'NV001', 'KH003', 19800000, 1),
('PX10', '2025-04-18 17:07:00', 'NV001', 'KH001', 44000000, 1),
('PX11', '2025-04-18 17:08:00', 'NV001', 'KH002', 21500000, 1),
('PX12', '2025-04-18 17:09:00', 'NV001', 'KH003', 33000000, 1),
('PX13', '2025-04-18 17:10:00', 'NV001', 'KH001', 27500000, 1),
('PX14', '2025-04-18 17:11:00', 'NV001', 'KH002', 31000000, 1),
('PX15', '2025-04-18 17:12:00', 'NV001', 'KH003', 19500000, 1),
('PX16', '2025-04-18 17:13:00', 'NV001', 'KH001', 16000000, 1),
('PX17', '2025-04-18 17:14:00', 'NV001', 'KH002', 43000000, 1),
('PX18', '2025-04-18 17:15:00', 'NV001', 'KH003', 22500000, 1),
('PX19', '2025-04-18 17:35:00', 'NV002', 'KH002', 18000000, 1),
('PX20', '2025-04-18 17:36:00', 'NV002', 'KH002', 20000000, 1),
('PX21', '2025-04-18 17:37:00', 'NV001', 'KH001', 20000000, 1),
('PX22', '2025-04-18 17:38:00', 'NV002', 'KH001', 18000000, 1),
('PX23', '2025-04-18 17:39:00', 'NV001', 'KH003', 16500000, 1),
('PX24', '2025-04-18 17:40:00', 'NV002', 'KH002', 15500000, 1),
('PX25', '2025-04-18 17:41:00', 'NV001', 'KH001', 16500000, 1),
('PX26', '2025-04-18 17:42:00', 'NV002', 'KH003', 13000000, 1),
('PX27', '2025-04-18 17:43:00', 'NV001', 'KH001', 20000000, 1),
('PX28', '2025-04-18 17:44:00', 'NV002', 'KH003', 18000000, 1),
('PX29', '2025-04-18 17:45:00', 'NV001', 'KH002', 15500000, 1),
('PX30', '2025-04-18 17:46:00', 'NV002', 'KH001', 16500000, 1),
('PX31', '2025-04-18 17:47:00', 'NV001', 'KH003', 20000000, 1),
('PX32', '2025-04-18 17:48:00', 'NV002', 'KH001', 13000000, 1),
('PX33', '2025-04-18 17:49:00', 'NV001', 'KH002', 18000000, 1),
('PX34', '2025-04-19 14:42:48', 'NV001', 'KH021', 84000000, 1),
('PX35', '2025-04-19 18:21:31', 'NV001', 'KH022', 167000000, 1),
('PX36', '2025-04-19 18:29:16', 'NV001', 'KH009', 16500000, 1),
('PX37', '2025-04-19 18:52:52', 'NV001', 'KH009', 39000000, 1),
('PX38', '2025-04-19 19:00:03', 'NV001', 'KH004', 1048500000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ram`
--

CREATE TABLE `ram` (
  `maRam` int(11) NOT NULL,
  `dungLuongRam` int(11) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ram`
--

INSERT INTO `ram` (`maRam`, `dungLuongRam`, `trangThai`) VALUES
(1, 2, 1),
(2, 4, 1),
(3, 6, 1),
(4, 8, 1),
(5, 12, 1),
(6, 16, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rom`
--

CREATE TABLE `rom` (
  `maRom` int(11) NOT NULL,
  `dungLuongRom` int(11) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rom`
--

INSERT INTO `rom` (`maRom`, `dungLuongRom`, `trangThai`) VALUES
(1, 32, 1),
(2, 64, 1),
(3, 128, 1),
(4, 256, 1),
(5, 512, 1),
(6, 1024, 1),
(7, 32, 1),
(8, 64, 1),
(9, 128, 1),
(10, 256, 1),
(11, 512, 1),
(12, 1024, 1),
(13, 32, 1),
(14, 64, 1),
(15, 128, 1),
(16, 256, 1),
(17, 512, 1),
(18, 1024, 1);

-- --------------------------------------------------------

--
-- Table structure for table `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `maThuongHieu` int(11) NOT NULL,
  `tenThuongHieu` varchar(30) DEFAULT NULL,
  `trangThai` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thuonghieu`
--

INSERT INTO `thuonghieu` (`maThuongHieu`, `tenThuongHieu`, `trangThai`) VALUES
(1, 'Apple', 1),
(2, 'Samsung', 1),
(3, 'Xiaomi', 1),
(4, 'Oppo', 1),
(5, 'Realme', 1),
(6, 'Vivo', 1),
(7, 'Nokia', 1),
(8, 'Asus', 1),
(9, 'Lenovo', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `maPN` (`maPN`),
  ADD KEY `maPhienBan` (`maPhienBan`);

--
-- Indexes for table `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD KEY `maPhienBan` (`maPhienBan`),
  ADD KEY `chitietphieuxuat_ibfk_1` (`maPX`);

--
-- Indexes for table `dienthoai`
--
ALTER TABLE `dienthoai`
  ADD PRIMARY KEY (`maDT`),
  ADD KEY `maHDH` (`maHDH`),
  ADD KEY `maThuongHieu` (`maThuongHieu`);

--
-- Indexes for table `hedieuhanh`
--
ALTER TABLE `hedieuhanh`
  ADD PRIMARY KEY (`maHDH`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`maKh`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
