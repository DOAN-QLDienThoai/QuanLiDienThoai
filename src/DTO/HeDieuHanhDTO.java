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
    private int maHDH;
    private String tenHDH;
    public HeDieuHanhDTO(){};
    public HeDieuHanhDTO(int maHDH,String tenHDH){
        this.maHDH=maHDH;
        this.tenHDH=tenHDH;
    }
    public int getMaHDH(){
        return this.maHDH;
    }
    public void setMaHDH(int maHDH){
        this.maHDH=maHDH;
    }
    public String getTenHDH(){
        return this.tenHDH;
    }
    public void setTenHDH(String tenHDH){
        this.tenHDH=tenHDH;
    }
}
