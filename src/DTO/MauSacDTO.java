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
    private String maMau;
    private String tenMau;
    public MauSacDTO(){};
    public MauSacDTO(String maMau,String tenMau){
        this.maMau=maMau;
        this.tenMau=tenMau;
    }
    public String getMaMau(){
        return this.maMau;
    }
    public void setMaMau(String maMau){
        this.maMau=maMau;
    }
    public String getTenMau(){
        return this.tenMau;
    }
    public void setTenMau(String tenMau){
        this.tenMau=tenMau;
    }
}
