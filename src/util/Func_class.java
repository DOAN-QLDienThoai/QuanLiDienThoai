/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import DAO.HeDieuHanhDAO;
import DAO.ThuongHieuDAO;
import DTO.DienThoaiDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Sheet;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author kiman
 */
//Lớp khởi tạo các hàm sử dụng chung
public class Func_class {
    private HashMap<String,Integer> mapHDH;
    private HashMap<String,Integer> mapThuongHieu;
    //Hàm gán icon, ảnh cho jlabel,button
    public void disPlayImage(int width,int height,String linkImage,JLabel jlabel){
        ImageIcon imgIcon=new ImageIcon(linkImage);
        Image image=imgIcon.getImage().getScaledInstance(width, height,Image.SCALE_SMOOTH);
        jlabel.setIcon(new ImageIcon(image));
    }
    //Hàm căn giữa nội dung bảng
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
    //Hàm chỉnh sửa table
    public void setUpTable(JTable table){
        table.setRowHeight(25);
        table.setBackground(Color.white);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);
        table.setFillsViewportHeight(true);
        Font font_hearderTable=new Font("Arial",Font.BOLD,13);
        table.getTableHeader().setFont(font_hearderTable);
    }
    public void setUpJTF(JTextField jtf) {
        jtf.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // Set foreground and background color
        jtf.setForeground(Color.DARK_GRAY);
        jtf.setBackground(Color.WHITE); // Màu xanh nhạt

        // Set padding
        jtf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE), // viền xanh
                new EmptyBorder(5, 10, 5, 10) // padding
        ));
    }

    public void setUpBtn(JButton btn, Color colorExit, Color colorEntered) {
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Tạo bo góc
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        // Hiệu ứng hover
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btn.setBackground(colorEntered);
            }
            public void mouseExited(MouseEvent evt) {
                btn.setBackground(colorExit);
            }
        });
    }
    public void setUpBtnTwo(JButton btn,Color ColorStart,Color colorExit, Color colorEntered,int size) {
        btn.setFocusPainted(false);
        btn.setBackground(ColorStart);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Tahoma", Font.BOLD,size));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Tạo bo góc
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        // Hiệu ứng hover
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btn.setBackground(colorEntered);
            }
            public void mouseExited(MouseEvent evt) {
                btn.setBackground(colorExit);
            }
        });
    }

    public void setUpComBoBox(JComboBox<?> comboBox) {
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setPreferredSize(new Dimension(150, 30));
        comboBox.setBackground(new Color(240, 240, 240));
        comboBox.setForeground(Color.DARK_GRAY);
        // Renderer tùy chỉnh giao diện từng item
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                if (isSelected) {
                    label.setBackground(new Color(0, 120, 215));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(Color.WHITE);
                    label.setForeground(Color.DARK_GRAY);
                }
                return label;
            }
        });
    }
    public void cursorPointer(JLabel label){
        label.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
    }
    //Hàm ngăn chặn không cho nhập phím chữ
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
    //Hàm ngăn chặn không cho nhập phím số
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
    public void addDataTableNV(ArrayList<NhanVienDTO> listNV,JTable table){
        String[] colNames = {"Mã NV", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại"};
        Object[][] rows = new Object[listNV.size()][colNames.length];
        for (int i = 0; i < listNV.size(); i++) {
            rows[i][0] = listNV.get(i).getMaNV();
            rows[i][1] = listNV.get(i).getHoTen();
            rows[i][2] = listNV.get(i).getNgaySinh();
            rows[i][3] = listNV.get(i).getGioiTinh();
            rows[i][4] = listNV.get(i).getSDT();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table.setModel(model);
    }
    public void addDataTableNCC(ArrayList<NhaCungCapDTO> listNCC, JTable table){
        String[] colNames = {"Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Email"};
        Object[][] rows = new Object[listNCC.size()][colNames.length];
        for (int i = 0; i < listNCC.size(); i++) {
            rows[i][0] = listNCC.get(i).getmaNCC();
            rows[i][1] = listNCC.get(i).getName();
            rows[i][2] = listNCC.get(i).getAddress();
            rows[i][3] = listNCC.get(i).getSDT();
            rows[i][4] = listNCC.get(i).getEmail();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table.setModel(model);
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
    public static void exportJTableToExcel(JTable table) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn đường dẫn lưu file Excel");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XLSX files", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int userChoice = fileChooser.showSaveDialog(null);
        if (userChoice == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
            }

            TableModel model = table.getModel();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(model.getColumnName(i));
            }

            // Create data rows
            for (int i = 0; i < model.getRowCount(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Cell dataCell = dataRow.createCell(j);
                    Object value = model.getValueAt(i, j);
                    if (value != null) {
                        dataCell.setCellValue(value.toString());
                    }
                }
            }

            // Resize all columns to fit the content size
            for (int i = 0; i < model.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            workbook.close();
        }
    }
}

