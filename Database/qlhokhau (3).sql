-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 17, 2024 lúc 05:13 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlhokhau`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dongtien`
--

CREATE TABLE `dongtien` (
  `maKhoanThu` varchar(20) NOT NULL,
  `maHoKhau` varchar(20) NOT NULL,
  `soTien` int(11) NOT NULL,
  `ngayDong` date NOT NULL,
  `trangThai` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `dongtien`
--

INSERT INTO `dongtien` (`maKhoanThu`, `maHoKhau`, `soTien`, `ngayDong`, `trangThai`) VALUES
('evn0524', '101', 523, '2024-05-29', 'Đã đóng'),
('evn0524', '102', 0, '2024-06-03', 'Đã đóng'),
('evnt7', '101', 523, '2024-06-04', 'Đã đóng'),
('evnt7', '102', 142, '2024-06-04', 'Đã đóng'),
('evnt7', '201', 632, '2024-06-04', 'Đã đóng'),
('evnt7', '205', 452, '2024-06-04', 'Đã đóng'),
('gx2407', '101', 80, '2024-06-04', 'Đã đóng'),
('gx2407', '102', 80, '2024-06-04', 'Đã đóng'),
('PGXT7', '101', 50, '2024-06-04', 'Đã đóng'),
('PGXT7', '102', 50, '2024-06-04', 'Đã đóng'),
('PGXT7', '128', 80, '2024-06-04', 'Đã đóng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hokhau`
--

CREATE TABLE `hokhau` (
  `soNha` varchar(10) NOT NULL,
  `IdChuHo` varchar(50) NOT NULL,
  `loaiSo` varchar(50) NOT NULL,
  `dienTich` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `hokhau`
--

INSERT INTO `hokhau` (`soNha`, `IdChuHo`, `loaiSo`, `dienTich`) VALUES
('101', '0261948763', 'Thường trú', 50),
('102', '0154978653', 'Thường trú', 60),
('128', '0164389525', 'Thường trú', 100),
('201', '0145484856', 'Thường trú', 120),
('205', '0154976532', 'Thường trú', 120);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoanthu`
--

CREATE TABLE `khoanthu` (
  `idKhoanThu` varchar(20) NOT NULL,
  `tenKhoanThu` varchar(100) NOT NULL,
  `loaiKhoanThu` varchar(50) NOT NULL,
  `ngayKhoiTao` date NOT NULL,
  `trangThai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khoanthu`
--

INSERT INTO `khoanthu` (`idKhoanThu`, `tenKhoanThu`, `loaiKhoanThu`, `ngayKhoiTao`, `trangThai`) VALUES
('evn0524', 'tiền điện EVN tháng 5', 'Phí thu hộ', '2024-06-01', 'Chưa hoàn thành'),
('evnt7', 'evnt7', 'Phí thu hộ', '2021-11-11', 'Chưa hoàn thành'),
('gx2407', 'phí gửi xe tháng 7', 'Phí gửi xe', '2024-07-01', 'Hoàn thành'),
('PGXT7', 'PGXT7', 'Phí gửi xe', '2024-12-12', 'Chưa hoàn thành');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhankhau`
--

CREATE TABLE `nhankhau` (
  `CCCD` varchar(50) NOT NULL,
  `hoTen` varchar(50) NOT NULL,
  `namSinh` date NOT NULL,
  `gioiTinh` varchar(50) NOT NULL,
  `nguyenQuan` varchar(50) NOT NULL,
  `danToc` varchar(50) NOT NULL,
  `quocTich` varchar(50) NOT NULL,
  `noiLamViec` varchar(50) NOT NULL,
  `ngheNghiep` varchar(50) NOT NULL,
  `tinhTrang` varchar(50) NOT NULL,
  `DiaChi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `nhankhau`
--

INSERT INTO `nhankhau` (`CCCD`, `hoTen`, `namSinh`, `gioiTinh`, `nguyenQuan`, `danToc`, `quocTich`, `noiLamViec`, `ngheNghiep`, `tinhTrang`, `DiaChi`) VALUES
('013467512', 'Trần Văn Long', '2002-06-18', 'Nam', 'Hải Dương', 'Kinh', 'Việt Nam', 'Hà Nội', 'sinh viên', 'Thường trú', 'BlueMoon'),
('0145484856', 'Nguyễn Văn Hưng', '2000-06-03', 'Nam', 'Bắc Giang', 'Kinh', 'Việt Nam', 'Hà Nội', 'Kinh doanh', 'Thường trú', 'BlueMoon'),
('0154976532', 'Hoàng Văn Hưng', '2000-03-09', 'Nam', 'Hà Nội', 'Kinh', 'Việt Nam', 'Hà Nội', 'kinh doanh', 'Thường trú', 'BlueMoon'),
('0154978653', 'Hoàng Văn Hồng', '1992-06-03', 'Nam', 'Hà Nội', 'Kinh', 'Việt Nam', 'Hà Nội', ' Bác sĩ', 'Thường trú', 'BlueMoon'),
('0164389525', 'Nguyễn Cường', '2003-12-08', 'Nam', 'Hà Nội', 'Kinh', 'Việt Nam', 'Hà Nội', 'SInh viên', 'Tạm vắng', 'BlueMoon'),
('0215541513', 'Nguyễn Thị Hồng', '2003-06-06', 'Nữ', 'Quảng Ninh', 'Kinh', 'Việt Nam', 'Hà Nội', 'sinh viên', 'Thường trú', 'BlueMoon'),
('0261948763', 'Nguyễn Văn Hùng', '1992-09-21', 'Nam', 'Hà Nội', 'Kinh', 'Việt Nam', 'Hà Nội', 'kinh doanh', 'Thường trú', 'BlueMoon');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phibatbuoc`
--

CREATE TABLE `phibatbuoc` (
  `maKhoanThu` varchar(20) NOT NULL,
  `donGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phidonggop`
--

CREATE TABLE `phidonggop` (
  `maKhoanThu` varchar(20) NOT NULL,
  `tongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phiguixe`
--

CREATE TABLE `phiguixe` (
  `maKhoanThu` varchar(20) NOT NULL,
  `oto` int(11) NOT NULL,
  `xemay` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phiguixe`
--

INSERT INTO `phiguixe` (`maKhoanThu`, `oto`, `xemay`) VALUES
('gx2407', 1200, 80),
('PGXT7', 50, 50);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phithuho`
--

CREATE TABLE `phithuho` (
  `maKhoanThu` varchar(20) NOT NULL,
  `tenCongTy` varchar(100) NOT NULL,
  `loaiDichVu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phithuho`
--

INSERT INTO `phithuho` (`maKhoanThu`, `tenCongTy`, `loaiDichVu`) VALUES
('evn0524', 'công ty EVN', 'Điện'),
('evnt7', 'EVN', 'Điện');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phuongtien`
--

CREATE TABLE `phuongtien` (
  `BienSo` varchar(20) NOT NULL,
  `LoaiXe` varchar(20) NOT NULL,
  `MaHK` varchar(20) NOT NULL,
  `MaNK` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phuongtien`
--

INSERT INTO `phuongtien` (`BienSo`, `LoaiXe`, `MaHK`, `MaNK`) VALUES
('14A52321', 'Ô tô', '128', '0164389525'),
('14ah58745', 'Xe máy', '128', '0164389525'),
('14az53221', 'Xe máy', '102', '0154978653');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phuongtien_hk`
--

CREATE TABLE `phuongtien_hk` (
  `mahk` varchar(20) NOT NULL,
  `soOTO` int(11) NOT NULL,
  `soXM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `phuongtien_hk`
--

INSERT INTO `phuongtien_hk` (`mahk`, `soOTO`, `soXM`) VALUES
('101', 0, 1),
('102', 0, 1),
('128', 1, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`username`, `password`, `role`) VALUES
('quanly', '1234', 'Quản lý');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tamtrutamvang`
--

CREATE TABLE `tamtrutamvang` (
  `CCCD` varchar(50) NOT NULL,
  `loaiDangKy` varchar(50) NOT NULL,
  `batDau` date NOT NULL,
  `ketThuc` date NOT NULL,
  `diaDiem` varchar(50) NOT NULL,
  `liDo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tamtrutamvang`
--

INSERT INTO `tamtrutamvang` (`CCCD`, `loaiDangKy`, `batDau`, `ketThuc`, `diaDiem`, `liDo`) VALUES
('0164389525', 'Tạm vắng', '2024-06-06', '2024-06-07', 'Hải Phòng', 'du lịch');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanhvien`
--

CREATE TABLE `thanhvien` (
  `manhankhau` varchar(20) NOT NULL,
  `mahokhau` varchar(11) NOT NULL,
  `quanHeChuHo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `thanhvien`
--

INSERT INTO `thanhvien` (`manhankhau`, `mahokhau`, `quanHeChuHo`) VALUES
('013467512', '102', 'con'),
('0145484856', '201', 'chủ hộ'),
('0154976532', '205', 'chủ hộ'),
('0154978653', '102', 'chủ hộ'),
('0164389525', '128', 'chủ hộ'),
('0215541513', '201', 'em gái'),
('0261948763', '101', 'chủ hộ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuho_hk`
--

CREATE TABLE `thuho_hk` (
  `mkhoanthu` varchar(20) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `maHK` varchar(10) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `soTien` int(11) NOT NULL,
  `suDung` varchar(20) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thuho_hk`
--

INSERT INTO `thuho_hk` (`mkhoanthu`, `maHK`, `soTien`, `suDung`) VALUES
('evn0524', '101', 523, '632kWh'),
('evn0524', '102', 142, '451kWh'),
('evnt7', '101', 523, '156kWh'),
('evnt7', '102', 142, '251kWh'),
('evnt7', '201', 632, '493kWh'),
('evnt7', '205', 452, '452kWh');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dongtien`
--
ALTER TABLE `dongtien`
  ADD PRIMARY KEY (`maKhoanThu`,`maHoKhau`),
  ADD KEY `fk_idHK` (`maHoKhau`);

--
-- Chỉ mục cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  ADD PRIMARY KEY (`soNha`),
  ADD UNIQUE KEY `soNha` (`soNha`),
  ADD KEY `fkChH` (`IdChuHo`);

--
-- Chỉ mục cho bảng `khoanthu`
--
ALTER TABLE `khoanthu`
  ADD PRIMARY KEY (`idKhoanThu`);

--
-- Chỉ mục cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD PRIMARY KEY (`CCCD`) USING BTREE,
  ADD UNIQUE KEY `CCCD` (`CCCD`);

--
-- Chỉ mục cho bảng `phibatbuoc`
--
ALTER TABLE `phibatbuoc`
  ADD PRIMARY KEY (`maKhoanThu`);

--
-- Chỉ mục cho bảng `phidonggop`
--
ALTER TABLE `phidonggop`
  ADD PRIMARY KEY (`maKhoanThu`);

--
-- Chỉ mục cho bảng `phiguixe`
--
ALTER TABLE `phiguixe`
  ADD PRIMARY KEY (`maKhoanThu`);

--
-- Chỉ mục cho bảng `phithuho`
--
ALTER TABLE `phithuho`
  ADD PRIMARY KEY (`maKhoanThu`);

--
-- Chỉ mục cho bảng `phuongtien`
--
ALTER TABLE `phuongtien`
  ADD PRIMARY KEY (`BienSo`),
  ADD KEY `fk_NK` (`MaNK`),
  ADD KEY `fk_HK` (`MaHK`);

--
-- Chỉ mục cho bảng `phuongtien_hk`
--
ALTER TABLE `phuongtien_hk`
  ADD PRIMARY KEY (`mahk`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `role` (`role`);

--
-- Chỉ mục cho bảng `tamtrutamvang`
--
ALTER TABLE `tamtrutamvang`
  ADD PRIMARY KEY (`CCCD`,`loaiDangKy`);

--
-- Chỉ mục cho bảng `thanhvien`
--
ALTER TABLE `thanhvien`
  ADD PRIMARY KEY (`manhankhau`,`mahokhau`),
  ADD KEY `fkHK` (`mahokhau`);

--
-- Chỉ mục cho bảng `thuho_hk`
--
ALTER TABLE `thuho_hk`
  ADD PRIMARY KEY (`mkhoanthu`,`maHK`),
  ADD KEY `fkHK2` (`maHK`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `dongtien`
--
ALTER TABLE `dongtien`
  ADD CONSTRAINT `fk_idHK` FOREIGN KEY (`maHoKhau`) REFERENCES `hokhau` (`soNha`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idKT` FOREIGN KEY (`maKhoanThu`) REFERENCES `khoanthu` (`idKhoanThu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  ADD CONSTRAINT `fkChH` FOREIGN KEY (`IdChuHo`) REFERENCES `nhankhau` (`CCCD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phibatbuoc`
--
ALTER TABLE `phibatbuoc`
  ADD CONSTRAINT `fk_id` FOREIGN KEY (`maKhoanThu`) REFERENCES `khoanthu` (`idKhoanThu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phidonggop`
--
ALTER TABLE `phidonggop`
  ADD CONSTRAINT `fkMaKT` FOREIGN KEY (`maKhoanThu`) REFERENCES `khoanthu` (`idKhoanThu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phiguixe`
--
ALTER TABLE `phiguixe`
  ADD CONSTRAINT `fk_id3` FOREIGN KEY (`maKhoanThu`) REFERENCES `khoanthu` (`idKhoanThu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phithuho`
--
ALTER TABLE `phithuho`
  ADD CONSTRAINT `fk_id2` FOREIGN KEY (`maKhoanThu`) REFERENCES `khoanthu` (`idKhoanThu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phuongtien`
--
ALTER TABLE `phuongtien`
  ADD CONSTRAINT `fk_HK` FOREIGN KEY (`MaHK`) REFERENCES `hokhau` (`soNha`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_NK` FOREIGN KEY (`MaNK`) REFERENCES `nhankhau` (`CCCD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phuongtien_hk`
--
ALTER TABLE `phuongtien_hk`
  ADD CONSTRAINT `fkHoKhau` FOREIGN KEY (`mahk`) REFERENCES `hokhau` (`soNha`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tamtrutamvang`
--
ALTER TABLE `tamtrutamvang`
  ADD CONSTRAINT `fkNhanKhau` FOREIGN KEY (`CCCD`) REFERENCES `nhankhau` (`CCCD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `thanhvien`
--
ALTER TABLE `thanhvien`
  ADD CONSTRAINT `fkHK` FOREIGN KEY (`mahokhau`) REFERENCES `hokhau` (`soNha`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkNK` FOREIGN KEY (`manhankhau`) REFERENCES `nhankhau` (`CCCD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `thuho_hk`
--
ALTER TABLE `thuho_hk`
  ADD CONSTRAINT `fkHK2` FOREIGN KEY (`maHK`) REFERENCES `hokhau` (`soNha`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkkt` FOREIGN KEY (`mkhoanthu`) REFERENCES `khoanthu` (`idKhoanThu`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
