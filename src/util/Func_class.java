/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

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
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JScrollPane;


/**
 *
 * @author kiman
 */
//Lớp khởi tạo các hàm sử dụng chung
public class Func_class {
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
    // Làm đẹp bảng: căn giữa, đường kẻ ngang mảnh, header bo sáng
    public void beautifyTable(JTable table, JScrollPane scrollPane) {
    // 🎯 Renderer căn giữa cho toàn bộ cell (trừ cột ảnh nếu có)
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    centerRenderer.setBackground(Color.WHITE);
    centerRenderer.setForeground(Color.BLACK);
    centerRenderer.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    for (int i = 0; i < table.getColumnCount(); i++) {
        if (table.getColumnClass(i) != ImageIcon.class) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // 🎯 Tùy chỉnh header
    table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            JLabel label = new JLabel(value.toString());
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setOpaque(true);
            label.setBackground(new Color(245, 245, 245)); // Màu xám sáng
            label.setForeground(Color.BLACK);
            label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
            return label;
        }
    });

    // 🧾 Thiết lập chung cho table
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(false); // ❌ Tắt đường kẻ dọc
    table.setGridColor(new Color(230, 230, 230)); // ✅ Màu nhẹ cho đường ngang
    table.setIntercellSpacing(new Dimension(0, 1)); // ✅ Khoảng cách 1px cho đường ngang
    table.setBackground(Color.WHITE);
    table.setSelectionBackground(new Color(230, 230, 230));
    table.setSelectionForeground(Color.BLACK);
    table.setRowHeight(28);
    table.getTableHeader().setReorderingAllowed(false);
    table.getTableHeader().setResizingAllowed(false);

    // 🎯 Tùy chỉnh ScrollPane
    if (scrollPane != null) {
        scrollPane.setBorder(null);
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        verticalBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
        verticalBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(180, 180, 180);  // Màu thanh kéo
                this.trackColor = new Color(245, 245, 245);  // Màu nền rãnh
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });
    }
}


}

