/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class MauSacDTO {
    private int maMau;
    private String tenMau;
    public MauSacDTO(){};
    public MauSacDTO(int maMau,String tenMau){
        this.maMau=maMau;
        this.tenMau=tenMau;
    }
    public int getMaMau(){
        return this.maMau;
    }
    public void setMaMau(int maMau){
        this.maMau=maMau;
    }
    public String getTenMau(){
        return this.tenMau;
    }
    public void setTenMau(String tenMau){
        this.tenMau=tenMau;
    }
}
