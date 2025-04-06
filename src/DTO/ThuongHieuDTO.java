/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class ThuongHieuDTO {
    private int maThuongHieu;
    private String tenThuongHieu;
    public ThuongHieuDTO(){};
    public ThuongHieuDTO(int maThuongHieu,String tenThuongHieu){
        this.maThuongHieu=maThuongHieu;
        this.tenThuongHieu=tenThuongHieu;
    }
    public ThuongHieuDTO(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }
    public int getMaThuongHieu(){
        return this.maThuongHieu;
    }
    public void setMaRom(int maThuongHieu){
        this.maThuongHieu=maThuongHieu;
    }
    public String getTenThuongHieu(){
        return this.tenThuongHieu;
    }
    public void setTenThuongHieu(String tenThuongHieu){
        this.tenThuongHieu=tenThuongHieu;
    }
}
