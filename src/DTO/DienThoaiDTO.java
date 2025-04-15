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
    private int maDT;
    private String tenDT;
    private int maHDH;
    private int maThuongHieu;
    private String chipXuLy;
    private int dungLuongPin;
    private double kichThuocMan;
    private String hinhAnh;
    private int soLuongTon;
    private double giaXuat;
    private int ram;
    private int rom;
    private String mauSac;
    // Constructor không tham số
    public DienThoaiDTO() {
    }

    // Constructor đầy đủ tham số
    public DienThoaiDTO( String tenDT, int maHDH,int maThuongHieu, 
                        String chipXuLy, int dungLuongPin, double kichThuocMan, String hinhAnh) {
        this.tenDT = tenDT;
        this.maHDH = maHDH;
        this.maThuongHieu = maThuongHieu;
        this.chipXuLy = chipXuLy;
        this.dungLuongPin = dungLuongPin;
        this.kichThuocMan = kichThuocMan;
        this.hinhAnh = hinhAnh;
    }
    public DienThoaiDTO(int maDT,String tenDT, int maHDH,int maThuongHieu, 
                        String chipXuLy, int dungLuongPin, double kichThuocMan, String hinhAnh,
                        int soLuongTon) {
        this.maDT=maDT;
        this.tenDT = tenDT;
        this.maHDH = maHDH;
        this.maThuongHieu = maThuongHieu;
        this.chipXuLy = chipXuLy;
        this.dungLuongPin = dungLuongPin;
        this.kichThuocMan = kichThuocMan;
        this.hinhAnh = hinhAnh;
        this.soLuongTon=soLuongTon;
    }

    // Getter và Setter
    public double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(double giaXuat) {
        this.giaXuat = giaXuat;
    }
    public int getRam() { 
        return ram; 
    }
    public void setRam(int ram) { 
        this.ram = ram; 
    }

    public int getRom() { 
        return rom; 
    }
    public void setRom(int rom) { 
        this.rom = rom; 
    }

    public String getMauSac() { 
        return mauSac; 
    }
    public void setMauSac(String mauSac) { 
        this.mauSac = mauSac; 
    }
    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public int getHeDieuHanh() {
        return this.maHDH;
    }

    public void setHeDieuHanh(int maHDH) {
        this.maHDH = maHDH;
    }

    public int getThuongHieu() {
        return this.maThuongHieu;
    }

    public void setThuongHieu(int maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
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
