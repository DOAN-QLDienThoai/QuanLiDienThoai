/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class DienThoaiDTO {
    private String maDT;
    private String tenDT;
    private int heDieuHanh;
    private int thuongHieu;
    private String chipXuLy;
    private int dungLuongPin;
    private double kichThuocMan;
    private String hinhAnh; // Thêm thuộc tính hình ảnh
    private int soLuongTon;

    // Constructor không tham số
    public DienThoaiDTO() {
    }

    // Constructor đầy đủ tham số
    public DienThoaiDTO(String maDT, String tenDT, int heDieuHanh,int thuongHieu, 
                        String chipXuLy, int dungLuongPin, double kichThuocMan, String hinhAnh,int soLuongTon) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.heDieuHanh = heDieuHanh;
        this.thuongHieu = thuongHieu;
        this.chipXuLy = chipXuLy;
        this.dungLuongPin = dungLuongPin;
        this.kichThuocMan = kichThuocMan;
        this.hinhAnh = hinhAnh;
        this.soLuongTon=soLuongTon;// Gán giá trị cho hình ảnh
    }

    // Getter và Setter
    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public int getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(int heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public int getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(int thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getChipXuLy() {
        return chipXuLy;
    }

    public void setChipXuLy(String chipXuLy) {
        this.chipXuLy = chipXuLy;
    }

    public int getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(int dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public double getKichThuocMan() {
        return kichThuocMan;
    }

    public void setKichThuocMan(double kichThuocMan) {
        this.kichThuocMan = kichThuocMan;
    }

    public String getHinhAnh() { // Getter cho hình ảnh
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) { // Setter cho hình ảnh
        this.hinhAnh = hinhAnh;
    }
    public int getSoLuongTon(){
        return this.soLuongTon;
    }
    public void setSoLuongTon(int soLuongTon){
        this.soLuongTon=soLuongTon;
    }
}
