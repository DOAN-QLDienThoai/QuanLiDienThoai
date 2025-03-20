/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

public class PhieuNhapDTO {
    private String maPhieuNhap;
    private Date ngayNhap;
    private double tongTien;
    private String nhaCungCap_id;
    private String nhanVien_id;
    private int trangThai;
    public PhieuNhapDTO(){}
    public PhieuNhapDTO(String maPhieuNhap,Date ngayNhap,double tongTien,String nhaCungCap_id,int trangThai){
        this.maPhieuNhap=maPhieuNhap;
        this.ngayNhap=ngayNhap;
        this.tongTien=tongTien;
        this.nhaCungCap_id=nhaCungCap_id;
        this.trangThai=trangThai;
    }
    public String getMaPhieuNhap(){
        return this.maPhieuNhap;
    }
    public void setMaPhieuNhap(String maPhieuString){
        this.maPhieuNhap=maPhieuString;
    }
    public Date getNgayNhap(){
        return this.ngayNhap;
    }
    public void setNgayNhap(Date ngayNhap){
        this.ngayNhap=ngayNhap;
    }
    public double getTongTien(){
        return this.tongTien;
    }
    public void setTongTien(double tongTien){
        this.tongTien=tongTien;
    }
    public int getTrangThai(){
        return this.trangThai;
    }
    public void setTrangThai(int trangThai){
        this.trangThai=trangThai;
    }
    public String getNhaCungCap(){
        return this.nhaCungCap_id;
    }
    public void setNhaCungCap(String nhaCungCap_id){
        this.nhaCungCap_id=nhaCungCap_id;
    }
    public String getNhanVien(){
        return this.nhanVien_id;
    }
    public void setNhanVien(String nhanVien_id){
        this.nhanVien_id=nhanVien_id;
    }
}
