/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import DAO.DienThoaiDAO;
import DAO.HeDieuHanhDAO;
import DAO.ThuongHieuDAO;
import DTO.DienThoaiDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author kiman
 */
public class Func_class {
    private HashMap<String,Integer> mapHDH;
    private HashMap<String,Integer> mapThuongHieu;
    public void disPlayImage(int width,int height,String linkImage,JLabel jlabel){
        ImageIcon imgIcon=new ImageIcon(linkImage);
        Image image=imgIcon.getImage().getScaledInstance(width, height,Image.SCALE_SMOOTH);
        jlabel.setIcon(new ImageIcon(image));
    }
    public void centerTable(JTable table){
        DefaultTableCellRenderer center=new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        //lấy renderer mặc định của jtableHeader(jtableHeader có một renderer mặc định là DefaultTableCellRenderer)
        DefaultTableCellRenderer centerHeader=(DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        //Gán center cho các jlabel của header table
        centerHeader.setHorizontalAlignment(JLabel.CENTER);
    }
    public void setUpTable(JTable table){
        table.setRowHeight(25);
        table.setBackground(Color.white);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);
        table.setFillsViewportHeight(true);
        Font font_hearderTable=new Font("Arial",Font.BOLD,15);
        table.getTableHeader().setFont(font_hearderTable);
    }
    public void cursorPointer(JLabel label){
        label.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }
    public void notAllowText(JTextField jtf){
        jtf.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e){
               char c=e.getKeyChar();
               if(!Character.isDigit(c) && c!='.'){
                   e.consume(); 
               }
           }
        });
    }
    public void notAllowNumber(JTextField jtf){
        jtf.addKeyListener(new KeyAdapter(){
           public void keyTyped(KeyEvent e){
               char c=e.getKeyChar();
               if(Character.isDigit(c)){
                   e.consume(); 
               }
           }
        });
    }
    //Hàm lấy Key trong HashMap
    public String getKey(HashMap<String,Integer> map,int value){
        String name = null;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(value)){
                name=entry.getKey();
            }
        }
        return name;
    }
    //Hàm thêm dữ liệu vào bảng điện thoại
    public void addDataTableDienThoai(ArrayList<DienThoaiDTO> listDT,JTable table) {
        mapHDH = new HeDieuHanhDAO().listMapHDH();
        mapThuongHieu = new ThuongHieuDAO().listMapThuongHieu();
        String[] colNames = {"Mã ĐT", "Tên Điện Thoại", "Hệ điều hành", "Thương hiệu", "Chip xử lý", "Dung lượng pin", "Kích thước màn"};
        Object[][] rows = new Object[listDT.size()][colNames.length];
        for (int i = 0; i < listDT.size(); i++) {
            rows[i][0] = listDT.get(i).getMaDT();
            rows[i][1] = listDT.get(i).getTenDT();
            int maHDH = listDT.get(i).getHeDieuHanh();
            String tenHDH = getKey(mapHDH,maHDH);
            rows[i][2] = tenHDH;
            int maThuongHieu = listDT.get(i).getThuongHieu();
            String tenThuongHieu = getKey(mapThuongHieu,maThuongHieu);
            rows[i][3] = tenThuongHieu;
            rows[i][4] = listDT.get(i).getChipXuLy();
            rows[i][5] = listDT.get(i).getDungLuongPin() + "mAh";
            rows[i][6] = listDT.get(i).getKichThuocMan() + " inch";
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table.setModel(model);
    }
    public void findText(JTextField jtf_find,JTable table){
        String text = jtf_find.getText().trim();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        if (text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
}
