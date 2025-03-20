/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class HeDieuHanhDTO {
    private String maHDH;
    private String tenHDH;
    public HeDieuHanhDTO(){};
    public HeDieuHanhDTO(String maHDH,String tenHDH){
        this.maHDH=maHDH;
        this.tenHDH=tenHDH;
    }
    public String getMaHDH(){
        return this.maHDH;
    }
    public void setMaHDH(String maHDH){
        this.maHDH=maHDH;
    }
    public String getTenHDH(){
        return this.tenHDH;
    }
    public void setTenHDH(String tenHDH){
        this.tenHDH=tenHDH;
    }
}
