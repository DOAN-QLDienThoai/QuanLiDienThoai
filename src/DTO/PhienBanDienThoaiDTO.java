/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class PhienBanDienThoaiDTO {
    private int maPhienBan;
    private int maDT;
    private int maRam;
    private int maRom;
    private int maMau;
    private double giaNhap;
    private double giaXuat;
    private int soLuongTon;
    // Constructor không tham số
    public PhienBanDienThoaiDTO() {}

    // Constructor đầy đủ tham số
    public PhienBanDienThoaiDTO(int maPhienBan,int maDT, int maRam, int maRom, int maMau, double giaNhap, double giaXuat) {
        this.maPhienBan=maPhienBan;
        this.maDT = maDT;
        this.maRam=maRam;
        this.maRom=maRom;
        this.maMau=maMau;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
    }
    //Constructor không chứa khóa chính(khóa chính tự động tăng)
    public PhienBanDienThoaiDTO( int maDT, int maRam, int maRom, int maMau, double giaNhap, double giaXuat) {
        this.maDT = maDT;
        this.maRam=maRam;
        this.maRom=maRom;
        this.maMau=maMau;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
    }

    // Getter và Setter
    public int getMaPhienBan() {
        return maPhienBan;
    }

    public void setMaPhienBan(int maPhienBan) {
        this.maPhienBan = maPhienBan;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public int getmaRam() {
        return this.maRam;
    }

    public void setRam(int maRam) {
        this.maRam = maRam;
    }

    public int getmaRom() {
        return this.maRom;
    }

    public void setRom(int maRom) {
        this.maRom=maRom;
    }

    public int getmaMau() {
        return this.maMau;
    }

    public void setMausac(int maMau) {
        this.maMau = maMau;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(double giaXuat) {
        this.giaXuat = giaXuat;
    }
<<<<<<< HEAD
    public boolean isSameConFig(PhienBanDienThoaiDTO other) {
        return maDT==other.maDT
                &&maRam == other.maRam
                && maRom == other.maRom
                && maMau == other.maMau;  // so sánh theo thuộc tính cần thiết
    }
    public boolean isSameFullConFig(PhienBanDienThoaiDTO other){
        return isSameConFig(other) && giaNhap==other.giaNhap&&giaXuat==other.giaXuat;
=======
    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
>>>>>>> 2dbd9b3cae783cccde1fa061b76c3545a61abeb4
    }
}
