/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

public class PhieuNhapDTO {
    private int maPN;
    private Date thoigian;
    private long tongtien;
    private int maNCC;
    private int maNV;
    public PhieuNhapDTO(){}
    public PhieuNhapDTO(int maPN,Date thoigian,long tongtien,int maNCC,int maNV){
        this.maPN=maPN;
        this.thoigian=thoigian;
        this.tongtien=tongtien;
        this.maNCC=maNCC;
        this.maNV=maNV;
    }    
    public int getMaPhieuNhap(){
        return this.maPN;
    }
    public void setMaPhieuNhap(int maPhieuint){
        this.maPN=maPhieuint;
    }
    public Date getNgayNhap(){
        return this.thoigian;
    }
    public void setNgayNhap(Date thoigian){
        this.thoigian=thoigian;
    }
    public long getTongTien(){
        return this.tongtien;
    }
    public void setTongTien(long tongtien){
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
