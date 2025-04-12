/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author kiman
 */
public class NhaCungCapBUS {
    private NhaCungCapDAO NhaCungCapDAO;
    public NhaCungCapBUS(){
        this.NhaCungCapDAO=new NhaCungCapDAO();
    }
    public int insertNhaCungCap(NhaCungCapDTO ncc){
        return NhaCungCapDAO.insertNhaCungCap(ncc);
    }
    public int updateNhaCungCap(NhaCungCapDTO ncc){
        return NhaCungCapDAO.updateNhaCungCap(ncc);
    }
    public int deleteNhaCungCap(int maNCC){
        return NhaCungCapDAO.deleteNhaCungCap(maNCC);
    }
    public ArrayList<NhaCungCapDTO> listNCC(){
        return NhaCungCapDAO.listNCC();
    }
    public ArrayList<NhaCungCapDTO> timKiem(String text,String type){
        ArrayList<NhaCungCapDTO> listNCC=NhaCungCapDAO.listNCC();
        ArrayList<NhaCungCapDTO> listNCCFilter=new ArrayList<>();
        String find_text=text.toLowerCase();
        for(NhaCungCapDTO ncc : listNCC){
            String maNCC=String.valueOf(ncc.getmaNCC()).toLowerCase();
            switch(type){
                case "Tất cả":
                    if(ncc.getName().toLowerCase().contains(find_text)||ncc.getEmail().toLowerCase().contains(find_text)
                        ||ncc.getAddress().toLowerCase().contains(find_text)||ncc.getSDT().toLowerCase().contains(find_text)
                        ||maNCC.contains(find_text))
                        listNCCFilter.add(ncc);
                    break;
                case "Tên nhà cung cấp":
                    if(ncc.getName().toLowerCase().contains(find_text))
                        listNCCFilter.add(ncc);
                    break;
                case "Email":
                    if(ncc.getEmail().toLowerCase().contains(find_text))
                        listNCCFilter.add(ncc);
                    break;
                case "Số điện thoại":
                    if(ncc.getSDT().toLowerCase().contains(find_text))
                        listNCCFilter.add(ncc);
                    break;
                case "Địa chỉ":
                    if(ncc.getAddress().toLowerCase().contains(find_text))
                        listNCCFilter.add(ncc);
                    break;
            }
        }
        return listNCCFilter;
    }
}
