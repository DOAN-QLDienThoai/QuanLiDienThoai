/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author kiman
 */
public class NhaCungCapDTO {
    private String id;
    private String name;
    private String address;
    private String sdt;
    private String email;
    public NhaCungCapDTO(){}
    public NhaCungCapDTO(String id,String name,String address,String sdt,String email){
        this.id=id;
        this.name=name;
        this.address=address;
        this.sdt=sdt;
        this.email=email;
    }
    public String getID(){
        return this.id;
    }
    public void setID(String id){
        this.id=id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getSDT(){
        return this.sdt;
    }
    public void setSDT(String sdt){
        this.sdt=sdt;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
