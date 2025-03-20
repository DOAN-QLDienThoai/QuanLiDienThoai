/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author kiman
 */
public class NhanVienDTO {
    private String maNV;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String sdt;
    public NhanVienDTO(){}
    public NhanVienDTO(String maNV,String hoTen,Date ngaySinh,String gioiTinh,String sdt){
        this.maNV=maNV;
        this.hoTen=hoTen;
        this.ngaySinh=ngaySinh;
        this.gioiTinh=gioiTinh;
        this.sdt=sdt;
    }
    public String getMaNV(){
        return this.maNV;
    }
    public void setMaNV(String maNV){
        this.maNV=maNV;
    }
    public String getHoTen(){
        return this.hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen=hoTen;
    }
    public Date getNgaySinh(){
        return this.ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh){
        this.ngaySinh=ngaySinh;
    }
    public String getGioiTinh(){
        return this.gioiTinh;
    }
    public void setGioiTinh(String gioiTinh){
        this.gioiTinh=gioiTinh;
    }
    public String getSDT(){
        return this.sdt;
    }
    public void setSDT(String sdt){
        this.sdt=sdt;
    }
}
