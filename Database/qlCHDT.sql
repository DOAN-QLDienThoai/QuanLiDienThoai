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
create table PhienBanDienThoai(
 maPhienBan int identity(1,1) primary key,
 maDT int,
 maRam int,
 maRom int,
 maMau int,
 giaNhap DECIMAL(18,2),
 giaXuat DECIMAL(18,2),
 foreign key (maDT) references DienThoai(maDT),
 foreign key (maRam) references Ram(maRam),
 foreign key (maRom) references Rom(maRom),
 foreign key (maMau) references MauSac(maMau),
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