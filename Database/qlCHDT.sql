use QuanLiDienThoai;
create database QuanLiDienThoai;
create table NhaCungCap(
 maNCC int identity(1,1) primary key,
 tenNCC nvarchar(70),
 diaChi nvarchar(100),
 sdt varchar(50),
 email varchar(100),
 trangThai tinyint
);
create table ChiTietDienThoai(
  maIMEI varchar(15) primary key,
  maPhienBan int,
  maPN varchar(20),
  maPX varchar(10),
  tinhtrang int,
  foreign key (maPX) references phieuxuat(maPX),
  foreign key (maPN) references PhieuNhap(maPN),
  foreign key (maPhienBan) references PhienBanDienThoai(maPhienBan)
);
create table PhienBanDienThoai(
 maPhienBan int identity(1,1) primary key,
 maDT int,
 maRam int,
 maRom int,
 maMau int,
 giaNhap DECIMAL(18,2),
 giaXuat DECIMAL(18,2),
 soLuongTon int default 0,
 foreign key (maDT) references DienThoai(maDT),
 foreign key (maRam) references Ram(maRam),
 foreign key (maRom) references Rom(maRom),
 foreign key (maMau) references MauSac(maMau),
);
CREATE TABLE PhieuNhap (
 maPN varchar(20) primary key,
 thoigian datetime,
 maNCC int,
 maNV int,
 tongtien bigint,
 trangthai int
 foreign key (maNCC) references NhaCungCap(maNCC),
 foreign key (maNV) references NhanVien(maNV),
);
CREATE TABLE phieuxuat (
  maPX varchar(10) primary key,
  thoigian DATETIME2(7),
  maNV int,
  maKh varchar(20) ,
  tongtien bigint ,
  trangthai int
  foreign key (maNV) references NhanVien(maNV),
  foreign key (maKh) references KhachHang(maKh)
);
CREATE TABLE chitietphieuxuat (
  maPX varchar(10) ,
  maPhienBan int,
  soluong int,
  dongia int
  foreign key (maPX) references phieuxuat(maPX),
  foreign key (maPhienBan) references PhienBanDienThoai(maPhienBan)
) ;
create table ChiTietPhieuNhap(
 maPN varchar(20),
 maPhienBan int,
 soluong int,
 dongia int,
 foreign key (maPN) references PhieuNhap(maPN),
 foreign key (maPhienBan) references PhienBanDienThoai(maPhienBan)	
);
create table DienThoai(
 maDT int identity(1,1) primary key,
 tenDT varchar(50),
 maHDH int,
 maThuongHieu int,
 chipXuLy varchar(60),
 dungLuongPin int,
 kichThuocMan float,
 hinhanh varchar(70),
 soLuongTon int default 0,
 trangThai int,
 foreign key (maHDH) references HeDieuHanh(maHDH),
 foreign key (maThuongHieu) references ThuongHieu(maThuongHieu)
);
create table ThuongHieu(
 maThuongHieu int identity(1,1) primary key,
 tenThuongHieu nvarchar(30),
 trangThai tinyint
);
create table MauSac(
 maMau int identity(1,1) primary key,
 tenMau nvarchar(30),
 trangThai tinyint
);
create table Ram(
 maRam int identity(1,1) primary key,
 dungLuongRam int,
 trangThai int,
);
create table Rom(
 maRom int identity(1,1) primary key,
 dungLuongRom int,
 trangThai int,
);
create table HeDieuHanh(
 maHDH int identity(1,1) primary key,
 tenHDH nvarchar(30),
 trangThai tinyint
);
create table NhanVien(
 maNV int identity(1,1) primary key,
 hoTen nvarchar(50),
 ngaySinh date,
 gioiTinh nvarchar(11),
 sdt varchar(10),
 trangThai tinyint
);
CREATE TABLE KhachHang (
    maKh VARCHAR(20) PRIMARY KEY,
    tenKh NVARCHAR(100),
    sdtKh VARCHAR(15),
    diachiKh NVARCHAR(255),
	ngayThamGia date,
	trangthai int
);
CREATE TABLE TaiKhoan (
  manv INT,
  tendangnhap VARCHAR(50),
  matkhau VARCHAR(255),
  trangthai VARCHAR(25),
  isLogin INT DEFAULT 0,
  FOREIGN KEY (manv) REFERENCES NhanVien(manv)
);
INSERT INTO KhachHang (maKh, tenKh, sdtKh, diachiKh, ngayThamGia)
VALUES 
('KH001', N'Nguyễn Văn A', '0912345678', N'123 Lê Lợi, Quận 1, TP.HCM', '2023-01-15'),
('KH002', N'Trần Thị B', '0938765432', N'456 Trần Hưng Đạo, Quận 5, TP.HCM', '2023-03-22'),
('KH003', N'Lê Văn C', '0987123456', N'789 Nguyễn Trãi, Quận 10, TP.HCM', '2024-05-09'),
('KH004', N'Phạm Thị D', '0905123123', N'12 Nguyễn Huệ, Quận 1, TP.HCM', '2022-11-30'),
('KH005', N'Hồ Văn E', '0909090909', N'99 Lý Thường Kiệt, Quận Tân Bình, TP.HCM', '2024-08-01');
INSERT INTO NhanVien (hoTen, ngaySinh, gioiTinh, sdt, trangThai) VALUES
(N'Nguyễn Văn An', '1995-05-20', N'Nam', '0912345678', 1),
(N'Trần Thị Bảo', '1998-08-15', N'Nữ', '0987654321', 1),
(N'Lê Hoàng Châu', '1992-12-10', N'Nam', '0909123456', 1),
(N'Phạm Thị Dung', '2000-03-25', N'Nữ', '0911222333', 1),
(N'Đỗ Minh Đức', '1997-07-30', N'Nam', '0977123456', 1),
(N'Bùi Thị Hoa', '1996-01-05', N'Nữ', '0934567890', 1),
(N'Huỳnh Minh Khang', '1999-06-18', N'Nam', '0967891234', 1),
(N'Vũ Thị Lan', '1994-09-21', N'Nữ', '0954321987', 1),
(N'Hoàng Văn Long', '1993-11-12', N'Nam', '0943219876', 1),
(N'Ngô Thị Mai', '1991-04-29', N'Nữ', '0921345678', 1),
(N'Tạ Văn Nam', '2001-02-14', N'Nam', '0911122233', 1),
(N'Đặng Thị Oanh', '1990-10-07', N'Nữ', '0933456789', 1),
(N'Trịnh Văn Phong', '1995-07-22', N'Nam', '0977777777', 1),
(N'Phan Thị Quỳnh', '1998-12-01', N'Nữ', '0944444444', 1),
(N'Tô Minh Sơn', '1996-06-17', N'Nam', '0988888888', 1),
(N'Châu Thị Thanh', '2002-08-09', N'Nữ', '0909090909', 1),
(N'Lý Văn Trí', '1997-03-05', N'Nam', '0959595959', 1),
(N'Đinh Thị Uyên', '1993-09-30', N'Nữ', '0939393939', 1),
(N'Kiều Văn Vinh', '2000-05-11', N'Nam', '0919191919', 1),
(N'Hồ Thị Yến', '1994-11-22', N'Nữ', '0929292929', 1);

INSERT INTO NhaCungCap (tenNCC, diaChi, sdt, email, trangThai) VALUES
(N'Công Ty TNHH Samsung Việt Nam', N'KCN Yên Phong, Bắc Ninh', '0222222333', 'contact@samsung.com', 1),
(N'Công Ty TNHH Apple Việt Nam', N'Quận 1, TP Hồ Chí Minh', '02812345678', 'info@apple.com', 1),
(N'Công Ty TNHH Xiaomi Việt Nam', N'Cầu Giấy, Hà Nội', '02456781234', 'support@xiaomi.com', 1),
(N'Công Ty TNHH Oppo Việt Nam', N'Thanh Xuân, Hà Nội', '02499887766', 'hotro@oppo.com', 1),
(N'Công Ty TNHH Vivo Việt Nam', N'Quận 7, TP Hồ Chí Minh', '02866778899', 'contact@vivo.com', 1),
(N'Công Ty TNHH Realme Việt Nam', N'Tân Bình, TP Hồ Chí Minh', '02812349876', 'realmevn@realme.com', 1),
(N'Công Ty TNHH Nokia Việt Nam', N'Hoàng Mai, Hà Nội', '02411223344', 'nokia@hmd.com', 1),
(N'Công Ty TNHH Sony Việt Nam', N'Quận 3, TP Hồ Chí Minh', '02855443322', 'sonyvn@sony.com', 1),
(N'Công Ty TNHH Asus Việt Nam', N'Đống Đa, Hà Nội', '02433221100', 'asusvn@asus.com', 1),
(N'Công Ty TNHH Lenovo Việt Nam', N'Bình Thạnh, TP Hồ Chí Minh', '02887654321', 'lenovovn@lenovo.com', 1);


INSERT INTO TaiKhoan (manv, tendangnhap, matkhau, trangthai, isLogin) VALUES
(1, 'admin', 'admin', 1, 0);      -- Admin



INSERT INTO NhaCungCap (tenNCC, diaChi, sdt, email, trangThai)
VALUES 
(N'NCC 1', N'123 Lê Lợi, Q1, TP.HCM', '0900123451', 'ncc1@example.com', 1),
(N'NCC 2', N'456 Trần Hưng Đạo, Q5, TP.HCM', '0900123452', 'ncc2@example.com', 1),
(N'NCC 3', N'789 Nguyễn Trãi, Q10, TP.HCM', '0900123453', 'ncc3@example.com', 1),
(N'NCC 4', N'321 Cách Mạng, Q3, TP.HCM', '0900123454', 'ncc4@example.com', 1),
(N'NCC 5', N'654 Hoàng Văn Thụ, Tân Bình, TP.HCM', '0900123455', 'ncc5@example.com', 1),
(N'NCC 6', N'98 Phạm Văn Đồng, Thủ Đức, TP.HCM', '0900123456', 'ncc6@example.com', 1),
(N'NCC 7', N'45 Nguyễn Văn Cừ, Q5, TP.HCM', '0900123457', 'ncc7@example.com', 1),
(N'NCC 8', N'12 Đinh Tiên Hoàng, Q1, TP.HCM', '0900123458', 'ncc8@example.com', 1),
(N'NCC 9', N'89 Tô Hiến Thành, Q10, TP.HCM', '0900123459', 'ncc9@example.com', 1),
(N'NCC 10', N'33 Lý Thường Kiệt, Q11, TP.HCM', '0900123460', 'ncc10@example.com', 1),
(N'NCC 11', N'234 Cộng Hòa, Tân Bình, TP.HCM', '0900123461', 'ncc11@example.com', 1),
(N'NCC 12', N'78 Đường 3/2, Q10, TP.HCM', '0900123462', 'ncc12@example.com', 1),
(N'NCC 13', N'67 Lê Văn Sỹ, Phú Nhuận, TP.HCM', '0900123463', 'ncc13@example.com', 1),
(N'NCC 14', N'22 Bạch Đằng, Bình Thạnh, TP.HCM', '0900123464', 'ncc14@example.com', 1),
(N'NCC 15', N'134 Hai Bà Trưng, Q1, TP.HCM', '0900123465', 'ncc15@example.com', 1),
(N'NCC 16', N'11 Nguyễn Huệ, Q1, TP.HCM', '0900123466', 'ncc16@example.com', 1),
(N'NCC 17', N'99 Điện Biên Phủ, Q3, TP.HCM', '0900123467', 'ncc17@example.com', 1),
(N'NCC 18', N'56 Lý Chính Thắng, Q3, TP.HCM', '0900123468', 'ncc18@example.com', 1),
(N'NCC 19', N'88 Lê Quang Định, Bình Thạnh, TP.HCM', '0900123469', 'ncc19@example.com', 1),
(N'NCC 20', N'101 Nguyễn Thị Minh Khai, Q1, TP.HCM', '0900123470', 'ncc20@example.com', 1),
(N'NCC 21', N'15 Trường Chinh, Tân Bình, TP.HCM', '0900123471', 'ncc21@example.com', 1),
(N'NCC 22', N'73 Nguyễn Ảnh Thủ, Hóc Môn, TP.HCM', '0900123472', 'ncc22@example.com', 1),
(N'NCC 23', N'62 Kha Vạn Cân, Thủ Đức, TP.HCM', '0900123473', 'ncc23@example.com', 1),
(N'NCC 24', N'93 Lê Lai, Q1, TP.HCM', '0900123474', 'ncc24@example.com', 1),
(N'NCC 25', N'44 Nguyễn Kiệm, Gò Vấp, TP.HCM', '0900123475', 'ncc25@example.com', 1),
(N'NCC 26', N'37 Nguyễn Hữu Thọ, Q7, TP.HCM', '0900123476', 'ncc26@example.com', 1),
(N'NCC 27', N'28 Dương Bá Trạc, Q8, TP.HCM', '0900123477', 'ncc27@example.com', 1),
(N'NCC 28', N'14 Lê Văn Lương, Nhà Bè, TP.HCM', '0900123478', 'ncc28@example.com', 1),
(N'NCC 29', N'31 Tôn Đức Thắng, Q1, TP.HCM', '0900123479', 'ncc29@example.com', 1),
(N'NCC 30', N'26 Ung Văn Khiêm, Bình Thạnh, TP.HCM', '0900123480', 'ncc30@example.com', 1),
(N'NCC 31', N'59 Tạ Quang Bửu, Q8, TP.HCM', '0900123481', 'ncc31@example.com', 1),
(N'NCC 32', N'17 Lý Tự Trọng, Q1, TP.HCM', '0900123482', 'ncc32@example.com', 1),
(N'NCC 33', N'60 Phạm Hùng, Bình Chánh, TP.HCM', '0900123483', 'ncc33@example.com', 1),
(N'NCC 34', N'19 Nguyễn Văn Linh, Q7, TP.HCM', '0900123484', 'ncc34@example.com', 1),
(N'NCC 35', N'83 Võ Văn Ngân, Thủ Đức, TP.HCM', '0900123485', 'ncc35@example.com', 1),
(N'NCC 36', N'42 Trần Não, TP. Thủ Đức, TP.HCM', '0900123486', 'ncc36@example.com', 1),
(N'NCC 37', N'38 Bùi Hữu Nghĩa, Bình Thạnh, TP.HCM', '0900123487', 'ncc37@example.com', 1),
(N'NCC 38', N'21 Lê Duẩn, Q1, TP.HCM', '0900123488', 'ncc38@example.com', 1),
(N'NCC 39', N'74 Nguyễn Đình Chiểu, Q3, TP.HCM', '0900123489', 'ncc39@example.com', 1),
(N'NCC 40', N'35 Nam Kỳ Khởi Nghĩa, Q1, TP.HCM', '0900123490', 'ncc40@example.com', 1);
