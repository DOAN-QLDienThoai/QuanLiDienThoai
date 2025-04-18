package DTO;

import java.sql.Date;

public class PhieuXuatDTO {
    private String maPX;
    private String thoiGian;
    private String maNV;
    private String maKH;
    private double tongTien;
    private int trangThai;

    public PhieuXuatDTO() {
    }

    public PhieuXuatDTO(String maPX, String thoiGian, String maNV, String maKH, double tongTien, int trangThai) {
        this.maPX = maPX;
        this.thoiGian = thoiGian;
        this.maNV = maNV;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaPX() {
        return maPX;
    }

    public void setMaPX(String maPX) {
        this.maPX = maPX;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
