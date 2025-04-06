/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class RomDTO {
    private int maRom;
    private int dungLuongRom;
    public RomDTO(){};
    public RomDTO(int maRom,int dungLuongRom){
        this.maRom=maRom;
        this.dungLuongRom=dungLuongRom;
    }
    public RomDTO(int dungLuongRom){
        this.dungLuongRom=dungLuongRom;
    }
    public int getMaRom(){
        return this.maRom;
    }
    public void setMaRom(int maRom){
        this.maRom=maRom;
    }
    public int getDungLuongRom(){
        return this.dungLuongRom;
    }
    public void setDungLuongRom(int dungLuongRom){
        this.dungLuongRom=dungLuongRom;
    }
}
