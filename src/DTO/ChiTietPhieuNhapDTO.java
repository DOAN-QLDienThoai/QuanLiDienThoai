/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author phant
 */
public class ChiTietPhieuNhapDTO {
    private String maPN;
    private int maPhienBan;
    private int soluong;
    private double dongia;
    public ChiTietPhieuNhapDTO(){
    }
    public ChiTietPhieuNhapDTO(String maPN,int maPhienBan, int soluong, double dongia) {
        this.maPN = maPN;
        this.maPhienBan = maPhienBan;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    public String getMaPhieuNhap() {
        return maPN;
    }

    public void setMaPhieuNhap(String maPN) {
        this.maPN = maPN;
    }

    public int getMaPB() {
        return maPhienBan;
    }

    public void setMaPB(int maPhienBan) {
        this.maPhienBan = maPhienBan;
    }
    
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
}
