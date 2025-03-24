/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class RamDTO {
    private int maRam;
    private int dungLuongRam;
    public RamDTO(){};
    public RamDTO(int maRam,int dungLuongRam){
        this.maRam=maRam;
        this.dungLuongRam=dungLuongRam;
    }
    public int getMaRam(){
        return this.maRam;
    }
    public void setMaRam(int maRam){
        this.maRam=maRam;
    }
    public int getDungLuongRam(){
        return this.dungLuongRam;
    }
    public void setDungLuongRam(int dungLuongRam){
        this.dungLuongRam=dungLuongRam;
    }
}
