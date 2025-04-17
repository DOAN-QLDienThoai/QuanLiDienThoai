/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

public class PhieuNhapDTO {
    private String maPN;
    private int maNCC;
    private int maNV;
    private Date thoigian;
    private double tongtien;
    public PhieuNhapDTO(){}
    public PhieuNhapDTO(String maPN,int maNV,int maNCC,Date thoigian,double tongtien){
        this.maPN=maPN;
        this.maNV=maNV;
        this.maNCC=maNCC;
        this.thoigian=thoigian;
        this.tongtien=tongtien;
    }    
    public String getMaPhieuNhap(){
        return this.maPN;
    }
    public void setMaPhieuNhap(String maPhieuint){
        this.maPN=maPhieuint;
    }
    public Date getNgayNhap(){
        return this.thoigian;
    }
    public void setNgayNhap(Date thoigian){
        this.thoigian=thoigian;
    }
    public double getTongTien(){
        return this.tongtien;
    }
    public void setTongTien(double tongtien){
        this.tongtien=tongtien;
    }
    public int getNhaCungCap(){
        return this.maNCC;
    }
    public void setNhaCungCap(int maNCC){
        this.maNCC=maNCC;
    }
    public int getNhanVien(){
        return this.maNV;
    }
    public void setNhanVien(int maNV){
        this.maNV=maNV;
    }
}
