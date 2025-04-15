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
    private NhaCungCapDAO nccDao=new NhaCungCapDAO();
    private ArrayList<NhaCungCapDTO> listNCC=new ArrayList<>();
    public NhaCungCapBUS(){
        this.listNCC=nccDao.listNCC();
    }
    public int insertNhaCungCap(NhaCungCapDTO ncc){
        int check=nccDao.insertNhaCungCap(ncc);
        if(check==1){
            listNCC=nccDao.listNCC();
        }
        return check;
    }
    public int updateNhaCungCap(NhaCungCapDTO ncc){
        int check=nccDao.updateNhaCungCap(ncc);
        if(check==1){
            listNCC=nccDao.listNCC();
        }
        return check;
    }
    public int deleteNhaCungCap(int maNCC){
        int check=nccDao.deleteNhaCungCap(maNCC);
        if(check==1){
            listNCC=nccDao.listNCC();
        }
        return check;
    }
    public int getIndexByID(int maNCC){
        int i=0;
        int vitri=-1;
        while(i<listNCC.size()&&vitri==-1){
            if(listNCC().get(i).getmaNCC()==maNCC){
                vitri=i;
            }else{
                i++;
            }
        }
        return vitri;
    }
    public String getTenNCCByID(int maNCC){
        return listNCC.get(getIndexByID(maNCC)).getName();
    }
    public ArrayList<NhaCungCapDTO> listNCC(){
        return listNCC;
    }
    public ArrayList<NhaCungCapDTO> timKiem(String text,String type){
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
