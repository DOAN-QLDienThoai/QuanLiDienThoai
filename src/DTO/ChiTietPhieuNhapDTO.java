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
    private int maPN;
    private int maPhienBan;
    private int soluong;
    private int dongia;
    private String hinhthucnhap;
    public ChiTietPhieuNhapDTO(){
    }
    public ChiTietPhieuNhapDTO(int maPN,int maPhienBan, int soluong, int dongia,String hinhthucnhap) {
        this.maPN = maPN;
        this.maPhienBan = maPhienBan;
        this.soluong = soluong;
        this.dongia = dongia;
        this.hinhthucnhap = hinhthucnhap;
    }

    public String getHinhthucnhap() {
        return hinhthucnhap;
    }

    public void setHinhthucnhap(String hinhthucnhap) {
        this.hinhthucnhap = hinhthucnhap;
    }

    
    public int getMaPhieuNhap() {
        return maPN;
    }

    public void setMaPhieuNhap(int maPN) {
        this.maPN = maPN;
    }

    public int getMasp() {
        return maPhienBan;
    }

    public void setMasp(int maPhienBan) {
        this.maPhienBan = maPhienBan;
    }
    
    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}
