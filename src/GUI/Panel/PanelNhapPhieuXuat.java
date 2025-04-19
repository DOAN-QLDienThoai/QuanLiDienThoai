/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import DAO.PhienBanDienThoaiDAO;
import DAO.MauSacDAO;
import DTO.PhienBanDienThoaiDTO;
import DTO.DienThoaiDTO;
import BUS.DienThoaiBUS;
import GUI.GUIFrame.Main;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.Color;
import util.CustomScrollBarUI;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import javax.swing.border.Border;
import util.RoundedBorder;

/**
 *
 * @author kiman
 */
public class PanelNhapPhieuXuat extends javax.swing.JPanel {
        private Main main;
        private String maKhachHangDuocChon;  
        private int hoverIndex = -1;

    public PanelNhapPhieuXuat(Main main) {
        this.main = main;
        initComponents();
        customComboBoxUI(jComboBox5);
        Border inputBorder = new RoundedBorder(10);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);
        Color backgroundColor = Color.WHITE;
        Color textColor = Color.BLACK;
        JTextField[] fields = {
            jTextField1, jTextField2, jTextField3, jTextField5,
            jTextField6, jTextField7, jTextField11, jTextField12
        };
        for (JTextField field : fields) {
            field.setFont(inputFont);
            field.setBackground(backgroundColor);
            field.setForeground(textColor);
            field.setBorder(inputBorder);
        }
        jTextField11.setText(taoMaPhieuXuatMoi());
        String maNV = main.getMaNhanVien(); 
        jTextField1.setText(maNV);
        jComboBox5.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        jComboBox5.setMinimumSize(new Dimension(0, 30));
        jComboBox5.setPrototypeDisplayValue("XXXXXXXXXX");
        jComboBox5.setPreferredSize(new Dimension(200, 35));
        PanelPhieuXuat phieuXuat = new PanelPhieuXuat(main);
        loadTableSanPham();
        jTextField2.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
             public void insertUpdate(javax.swing.event.DocumentEvent e) {
                timKiemTuDong();
            }
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                timKiemTuDong();
            }
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                timKiemTuDong();
            }
        });
        jTextField2.setForeground(Color.GRAY);
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (jTextField2.getText().equals("Tên sản phẩm, mã sản phẩm...")) {
                 jTextField2.setText("");
                  jTextField2.setForeground(Color.BLACK); 
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jTextField2.getText().trim().equals("")) {
                    jTextField2.setForeground(Color.GRAY);
                    jTextField2.setText("Tên sản phẩm, mã sản phẩm...");
                }
            }
        });
            jTable1.getSelectionModel().addListSelectionListener(e -> {
         if (!e.getValueIsAdjusting()) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            String maSP = jTable1.getValueAt(selectedRow, 0).toString();
            String tenSP = jTable1.getValueAt(selectedRow, 1).toString();
            DienThoaiDTO dt = new DienThoaiBUS().layThongTinTheoMa(maSP);
            jTextField3.setText(maSP);               
            jTextField5.setText(tenSP);           
            PhienBanDienThoaiDAO pbDao = new PhienBanDienThoaiDAO();
            ArrayList<String> configs = pbDao.getArrayListCauHinhByMaDT(Integer.parseInt(maSP));
            jComboBox5.removeAllItems();
            for (String config : configs) {
                jComboBox5.addItem(config);
            }
            if (!configs.isEmpty()) {
                String firstConfig = configs.get(0);
                jComboBox5.setSelectedItem(firstConfig);
                PhienBanDienThoaiDAO dao = new PhienBanDienThoaiDAO();
                String[] parts = firstConfig.split(" - ");
                if (parts.length == 3) {
                    String rom = parts[0].replace("GB", "").trim();
                    String ram = parts[1].replace("GB", "").trim();
                    String color = parts[2].trim();
                    int maMau = new MauSacDAO().getMaMauByTen(color);
                    int maRam = dao.getMaRamTheoDungLuong(Integer.parseInt(ram));
                    int maRom = dao.getMaRomTheoDungLuong(Integer.parseInt(rom));
                    int maDT = Integer.parseInt(maSP); 
                    PhienBanDienThoaiDTO variant = dao.getTheoCauHinh(maDT, maRam, maRom, maMau);
                    if (variant != null) {
                        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                        symbols.setGroupingSeparator('.');
                        DecimalFormat formatter = new DecimalFormat("#,###", symbols);
                        jTextField6.setText(formatter.format(variant.getGiaXuat()) + " đ");
                        jTextField7.setText(String.valueOf(variant.getSoLuongTon()));
                    }
                }
            }
        }
        }
        });     
                jComboBox5.addItemListener(new java.awt.event.ItemListener() {
                    @Override
                    public void itemStateChanged(java.awt.event.ItemEvent e) {
                     if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                            String selected = (String) jComboBox5.getSelectedItem();
                    if (selected == null || selected.isEmpty()) return;
                    String[] parts = selected.split(" - ");
                    if (parts.length != 3) return;
                    String rom = parts[0].replace("GB", "").trim();
                    String ram = parts[1].replace("GB", "").trim();
                    String color = parts[2].trim();
                    String maDTStr = jTextField3.getText().trim();
                    if (maDTStr.isEmpty()) return;
                    int maDT = Integer.parseInt(maDTStr);
                    int maMau = new MauSacDAO().getMaMauByTen(color);
                    PhienBanDienThoaiDAO dao = new PhienBanDienThoaiDAO();
                    PhienBanDienThoaiDTO variant = dao.getTheoCauHinh(maDT, Integer.parseInt(ram), Integer.parseInt(rom), maMau);
                    if (variant != null) {
                        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                        symbols.setGroupingSeparator('.');
                        DecimalFormat formatter = new DecimalFormat("#,###", symbols);
                        jTextField6.setText(formatter.format(variant.getGiaXuat()) + " đ");
                        jTextField7.setText(String.valueOf(variant.getSoLuongTon()));
                    }
                }
            }
        });
        loadCauHinhVaoComboBox();
        jTextField11.setEditable(false);
        jTextField11.setFocusable(false);
        jTextField1.setEditable(false);  
        jTextField12.setEditable(false); 
        jTextField1.setFocusable(false);
        jTextField12.setFocusable(false);
        jTextField6.setFocusable(false);
        jTextField7.setFocusable(false);
        jTextField6.setEditable(false); 
        jTextField7.setEditable(false); 
//        jTextField2.setFocusable(false);
//        jTextField2.setEditable(false); 
        javax.swing.SwingUtilities.invokeLater(() -> {
            styleTable(jTable1);
            styleTable(jTable2);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(920, 626));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTextField2.setText("Tên sản phẩm, mã sản phẩm...");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Thêm sản phẩm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Mã SP");

        jLabel6.setText("Tên sản phẩm");

        jLabel9.setText("Cấu hình");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jLabel10.setText("Giá xuất");

        jLabel11.setText("Số lượng tồn");

        jTextField7.setMinimumSize(new java.awt.Dimension(64, 30));

        jButton8.setBackground(new java.awt.Color(204, 0, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setText("Xóa sản phẩm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField3)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField6))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "RAM", "ROM", "Màu sắc", "Đơn giá", "Số lượng"
            }
        ));
        jScrollPane7.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã phiếu xuất");

        jLabel2.setText("Nhân viên xuất");

        jLabel3.setText("Khách hàng");

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Xuất hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("TỔNG TIỀN:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("0đ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField11))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
           timKiemTuDong();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
          int selectedRow = jTable2.getSelectedRow();
    if (selectedRow < 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa ở bảng dưới!");
        return;
    }
    DefaultTableModel modelCT = (DefaultTableModel) jTable2.getModel();
    String maSP = modelCT.getValueAt(selectedRow, 1).toString(); 
    DefaultTableModel modelSP = (DefaultTableModel) jTable1.getModel();
    for (int i = 0; i < modelSP.getRowCount(); i++) {
        if (modelSP.getValueAt(i, 0).toString().equals(maSP)) {
            int soLuongTon = Integer.parseInt(modelSP.getValueAt(i, 2).toString());
            modelSP.setValueAt(soLuongTon + 1, i, 2);
            break;
        }
    }
    String maSPDangXem = jTextField3.getText().trim();
    if (maSPDangXem.equals(maSP)) {
        int sl = Integer.parseInt(jTextField7.getText().trim());
        jTextField7.setText(String.valueOf(sl + 1));
    }
    modelCT.removeRow(selectedRow);
    for (int i = 0; i < modelCT.getRowCount(); i++) {
        modelCT.setValueAt(i + 1, i, 0); 
    }
    try {
        double tong = 0;
        for (int i = 0; i < modelCT.getRowCount(); i++) {
            double gia = Double.parseDouble(modelCT.getValueAt(i, 6).toString());
            int sl = Integer.parseInt(modelCT.getValueAt(i, 7).toString());
            tong += gia * sl;
        }
        DecimalFormat df = new DecimalFormat("#,###");
        jLabel8.setText(df.format(tong) + "đ");
    } catch (Exception ex) {
        System.out.println("Lỗi khi tính lại tổng tiền: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          new GUI.Dialog.ChooseKhachHangPX(this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         int selectedRow = jTable1.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong bảng trên!");
        return;
    }
    String maSP = jTextField3.getText().trim();
    String tenSP = jTextField5.getText().trim();
    String cauHinh = (String) jComboBox5.getSelectedItem();
    if (cauHinh == null || cauHinh.equals("Chọn cấu hình...")) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn cấu hình trước khi thêm sản phẩm!");
        return;
    }
    String giaXuatText = jTextField6.getText().replace(".", "").replace(" đ", "").trim();
    int soLuongTon = Integer.parseInt(jTextField7.getText().trim());
    if (soLuongTon <= 0) {
        JOptionPane.showMessageDialog(this, "Sản phẩm này đã hết hàng!");
        return;
    }
    String[] parts = cauHinh.split(" - ");
    if (parts.length != 3) {
        JOptionPane.showMessageDialog(this, "Cấu hình không hợp lệ.");
        return;
    }
    String rom = parts[0].replace("GB", "").trim();
    String ram = parts[1].replace("GB", "").trim();
    String mauSac = parts[2].trim();
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    boolean daTonTai = false;
    for (int i = 0; i < model.getRowCount(); i++) {
        String maSP_T = model.getValueAt(i, 1).toString();
        String ram_T = model.getValueAt(i, 3).toString();
        String rom_T = model.getValueAt(i, 4).toString();
        String mau_T = model.getValueAt(i, 5).toString();
        if (maSP_T.equals(maSP) && ram_T.equals(ram) && rom_T.equals(rom) && mau_T.equals(mauSac)) {
            int slCu = Integer.parseInt(model.getValueAt(i, 7).toString());
            if (soLuongTon <= 0) {
                JOptionPane.showMessageDialog(this, "Không đủ tồn kho để thêm!");
                return;
            }
            model.setValueAt(slCu + 1, i, 7);
            daTonTai = true;
            break;
        }
    }
    if (!daTonTai) {
        int stt = model.getRowCount() + 1;
        model.addRow(new Object[]{
            stt,
            maSP,
            tenSP,
            ram,
            rom,
            mauSac,
            giaXuatText,
            1
        });
    }
    int newSLTon = soLuongTon - 1;
    jTextField7.setText(String.valueOf(newSLTon));
    DefaultTableModel modelSP = (DefaultTableModel) jTable1.getModel();
    jTextField7.setText(String.valueOf(newSLTon));
    for (int i = 0; i < modelSP.getRowCount(); i++) {
        if (modelSP.getValueAt(i, 0).toString().equals(maSP)) {
            int tongSL = Integer.parseInt(modelSP.getValueAt(i, 2).toString());
            modelSP.setValueAt(tongSL - 1, i, 2); 
            break;
        }
    }
    try {
        double tong = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            double gia = Double.parseDouble(model.getValueAt(i, 6).toString());
            int sl = Integer.parseInt(model.getValueAt(i, 7).toString());
            tong += gia * sl;
        }
        DecimalFormat df = new DecimalFormat("#,###");
        jLabel8.setText(df.format(tong) + "đ");
    } catch (Exception ex) {
        System.out.println("Lỗi tính tổng tiền: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String maPX = jTextField11.getText().trim();
        String nhanVien = "NV001"; 
        String tenKH = jTextField12.getText().trim();
        DefaultTableModel modelCT = (DefaultTableModel) jTable2.getModel();
        if (tenKH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng!");
            return;
        }
        if (modelCT.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào để xuất!");
            return;
        }
        String tongTienStr = jLabel8.getText().replace("đ", "").replace(".", "").replace(",", "").trim();
        double tongTien = Double.parseDouble(tongTienStr);
        String thoiGian = java.time.LocalDateTime.now().toString();
        DAO.PhieuXuatDAO pxDAO = new DAO.PhieuXuatDAO();
        DAO.ChiTietPhieuXuatDAO ctpxDAO = new DAO.ChiTietPhieuXuatDAO();
        PanelPhieuXuat phieuXuatPanel = main.getPanelPhieuXuat();
        DAO.PhieuXuatDAO pxDao = new DAO.PhieuXuatDAO();
        boolean themPhieu = pxDao.themPhieuXuat(maPX, nhanVien,maKhachHangDuocChon, thoiGian, tongTien);
        if (!themPhieu) {
            JOptionPane.showMessageDialog(this, "Không thể thêm phiếu xuất vào cơ sở dữ liệu!");
        return;
    }
        DAO.ChiTietPhieuXuatDAO ctpxDao = new DAO.ChiTietPhieuXuatDAO();
        for (int i = 0; i < modelCT.getRowCount(); i++) {
            String maSP = modelCT.getValueAt(i, 1).toString();
            String ram = modelCT.getValueAt(i, 3).toString();
            String rom = modelCT.getValueAt(i, 4).toString();
            String mau = modelCT.getValueAt(i, 5).toString();
            int soLuong = Integer.parseInt(modelCT.getValueAt(i, 7).toString());
            double donGia = Double.parseDouble(modelCT.getValueAt(i, 6).toString());
            DAO.PhienBanDienThoaiDAO dao = new DAO.PhienBanDienThoaiDAO();
            int dungLuongRam = Integer.parseInt(ram);
            int dungLuongRom = Integer.parseInt(rom);
            int maRam = dao.getMaRamTheoDungLuong(dungLuongRam);
            int maRom = dao.getMaRomTheoDungLuong(dungLuongRom);
            int maPhienBan = dao.getMaPhienBanTheoChiTiet(maSP, String.valueOf(maRam), String.valueOf(maRom), mau);
              System.out.println("DEBUG maPhienBan = " + maPhienBan 
        + " | maSP = " + maSP + ", ram = " + ram + ", rom = " + rom + ", màu = " + mau);
            boolean ok = ctpxDao.themChiTiet(maPX, maPhienBan, soLuong, donGia);
            if (!ok) {
                JOptionPane.showMessageDialog(this, "Thêm chi tiết phiếu xuất thất bại!");
                return;
            }
            }
            phieuXuatPanel.themPhieuXuatVaoBang(maPX, tenKH, nhanVien, thoiGian, tongTien);
            JOptionPane.showMessageDialog(this, "Xuất hàng thành công!");
            main.getPanelPhieuXuat().setVisible(true);
            this.setVisible(false);
        resetFormSauKhiXuat();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        String selected = (String) jComboBox5.getSelectedItem();
        if (selected == null || selected.trim().isEmpty()) return;
        String[] parts = selected.split(" - ");
        if (parts.length != 3) return;
        String rom = parts[0].replace("GB", "").trim();
        String ram = parts[1].replace("GB", "").trim();
        String color = parts[2].trim();
        String maDTStr = jTextField3.getText().trim();
        if (maDTStr.isEmpty()) return;
        int maDT = Integer.parseInt(maDTStr);
        MauSacDAO mauDAO = new MauSacDAO();
        PhienBanDienThoaiDAO dao = new PhienBanDienThoaiDAO();
        int maMau = mauDAO.getMaMauByTen(color);
        int maRam = dao.getMaRamTheoDungLuong(Integer.parseInt(ram));
        int maRom = dao.getMaRomTheoDungLuong(Integer.parseInt(rom));
        PhienBanDienThoaiDTO variant = dao.getTheoCauHinh(maDT, maRam, maRom, maMau);
        if (variant != null) {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator('.');
            DecimalFormat formatter = new DecimalFormat("#,###", symbols);
            jTextField6.setText(formatter.format(variant.getGiaXuat()) + " đ");
            jTextField7.setText(String.valueOf(variant.getSoLuongTon()));
        } else {
            jTextField6.setText("0 đ");
            jTextField7.setText("0");
        }
    }
    }//GEN-LAST:event_jComboBox5ItemStateChanged

        public void loadTableSanPham() {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            DienThoaiBUS dtBus = new DienThoaiBUS();
            PhienBanDienThoaiDAO pbDAO = new PhienBanDienThoaiDAO();
            for (DienThoaiDTO dt : dtBus.listDT()) {
                int tongSoLuong = pbDAO.getTongSoLuongTonCuaDienThoai(dt.getMaDT());
                model.addRow(new Object[]{
                     dt.getMaDT(),
                     dt.getTenDT(),
                     tongSoLuong
                });
             }
        }
    private void timKiemTuDong() {
        String keyword = jTextField2.getText().trim();
        if (keyword.equals("Tên sản phẩm, mã sản phẩm...")) return;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        DienThoaiBUS dtBus = new DienThoaiBUS();
        for (DienThoaiDTO dt : dtBus.listDT()) {
            if (dt.getTenDT().toLowerCase().contains(keyword.toLowerCase()) ||
                String.valueOf(dt.getMaDT()).toLowerCase().contains(keyword.toLowerCase())) {

                int tongSoLuong = new PhienBanDienThoaiDAO().getTongSoLuongTonCuaDienThoai(dt.getMaDT());
                model.addRow(new Object[]{
                    dt.getMaDT(),
                    dt.getTenDT(),
                    tongSoLuong
                });
            }
        }
    }

    private void loadCauHinhVaoComboBox() {
        jComboBox5.removeAllItems();
        DienThoaiBUS dtBus = new DienThoaiBUS();
        ArrayList<DienThoaiDTO> list = dtBus.listDT();
        HashSet<String> cauHinhs = new HashSet<>();
        for (DienThoaiDTO dt : list) {
            String config = dt.getRom() + "GB - " + dt.getRam() + "GB - " + dt.getMauSac();
            cauHinhs.add(config); 
        }
        for (String ch : cauHinhs) {
            jComboBox5.addItem(ch);
        }
    }
    private String taoMaPhieuXuatMoi() {
    int max = 0;
    ArrayList<String> dsMa = new DAO.PhieuXuatDAO().layDanhSachMaPhieuXuat();
    for (String ma : dsMa) {
        if (ma.startsWith("PX")) {
            try {
                int so = Integer.parseInt(ma.substring(2));
                if (so > max) max = so;
            } catch (NumberFormatException ex) {
            }
        }
    }
    return "PX" + (max + 1);
    }
    public void setTenKhachHang(String tenKH) {
    jTextField12.setText(tenKH);
    }
    public void setKhachHang(String maKH, String tenKH) {
        this.maKhachHangDuocChon = maKH;
        jTextField12.setText(tenKH); 
    }
    private void resetFormSauKhiXuat() {
    jTextField11.setText(taoMaPhieuXuatMoi());
    jTextField12.setText("");
    maKhachHangDuocChon = null;
    jTextField3.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
    jComboBox5.removeAllItems();
    DefaultTableModel modelCT = (DefaultTableModel) jTable2.getModel();
    modelCT.setRowCount(0);
    jLabel8.setText("0đ");
    loadTableSanPham();
}
    private void styleTable(javax.swing.JTable table) {
        table.setShowGrid(true);
        table.setGridColor(new java.awt.Color(240, 240, 240));
        table.setIntercellSpacing(new java.awt.Dimension(0, 1));
        table.setRowHeight(30);
        table.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
        table.setSelectionBackground(new java.awt.Color(192, 192, 192));
        table.setSelectionForeground(Color.WHITE);
        table.setDefaultEditor(Object.class, null);
        table.setFocusable(false);

        // Header
        javax.swing.table.JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                javax.swing.JLabel label = new javax.swing.JLabel(value.toString());
                label.setFont(label.getFont().deriveFont(java.awt.Font.BOLD));
                label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBackground(new java.awt.Color(245, 245, 245)); // nền xám nhạt
                label.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 10, 5));
                return label;
            }
        });
        header.setReorderingAllowed(false);

        // Cell renderer
        javax.swing.table.TableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                javax.swing.JLabel label = (javax.swing.JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
                if (isSelected) {
                    label.setBackground(new java.awt.Color(192, 192, 192));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(Color.WHITE);
                    label.setForeground(Color.BLACK);
                }
                return label;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        // Scroll styling
        if (table.getParent() instanceof javax.swing.JViewport) {
            javax.swing.JViewport viewport = (javax.swing.JViewport) table.getParent();
            if (viewport.getParent() instanceof javax.swing.JScrollPane scrollPane) {
                scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
                scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
                scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
            }
        }
    }
    private void customComboBoxUI(JComboBox<?> comboBox) {
    comboBox.setBackground(Color.WHITE);
    comboBox.setForeground(Color.BLACK);
    comboBox.setFocusable(false);
    comboBox.setOpaque(true);
    comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    comboBox.setBorder(new util.RoundedBorder(10));
    comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    comboBox.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, false, false);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            if (index == hoverIndex) {
                label.setBackground(new Color(192, 192, 192));
                label.setForeground(Color.WHITE);
            } else {
                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLACK);
            }
            return label;
        }
    });
    comboBox.setUI(new BasicComboBoxUI() {
        @Override
        protected JButton createArrowButton() {
            JButton arrow = new BasicArrowButton(SwingConstants.SOUTH,
                    Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE);
            arrow.setBorder(BorderFactory.createEmptyBorder());
            return arrow;
        }
    });
    comboBox.setEditable(true);

    if (comboBox.getEditor().getEditorComponent() instanceof JTextField editor) {
        editor.setBackground(Color.WHITE);
        editor.setForeground(Color.BLACK);
        editor.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    comboBox.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override public void mouseEntered(java.awt.event.MouseEvent evt) {
            comboBox.setBackground(new Color(250, 250, 250));
        }
        @Override public void mouseExited(java.awt.event.MouseEvent evt) {
            comboBox.setBackground(Color.WHITE);
        }
    });

    javax.swing.SwingUtilities.invokeLater(() -> {
        Object comp = comboBox.getUI().getAccessibleChild(comboBox, 0);
        if (comp instanceof javax.swing.plaf.basic.ComboPopup popup) {
            JScrollPane scrollPane = (JScrollPane) popup.getList().getParent().getParent();
            scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
            scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
        }
    });

    comboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
        @Override public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent e) {
            JList<?> list = getPopupList(comboBox);
            if (list != null) {
                list.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                    @Override public void mouseMoved(java.awt.event.MouseEvent e) {
                        int index = list.locationToIndex(e.getPoint());
                        if (index != hoverIndex) {
                            hoverIndex = index;
                            list.repaint();
                        }
                    }
                });
            }
        }
        @Override public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent e) {}
        @Override public void popupMenuCanceled(javax.swing.event.PopupMenuEvent e) {}
    });
}

private JList<?> getPopupList(JComboBox<?> comboBox) {
    Object comp = comboBox.getUI().getAccessibleChild(comboBox, 0);
    if (comp instanceof javax.swing.plaf.basic.ComboPopup popup) {
        return popup.getList();
    }
    return null;
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
