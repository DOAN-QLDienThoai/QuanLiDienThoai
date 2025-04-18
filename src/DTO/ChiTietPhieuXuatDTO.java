package DTO;

public class ChiTietPhieuXuatDTO {
    private int maPhienBan;
    private String tenSanPham;
    private int soLuong;
    private double donGia;
    

    // Constructor đầy đủ
    public ChiTietPhieuXuatDTO(int maPhienBan, String tenSanPham, int soLuong, double donGia) {
        this.maPhienBan = maPhienBan;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Constructor rỗng nếu cần dùng Bean hoặc set sau
    public ChiTietPhieuXuatDTO() {}

    public int getMaPhienBan() {
        return maPhienBan;
    }

    public void setMaPhienBan(int maPhienBan) {
        this.maPhienBan = maPhienBan;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
