/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.NhanVienBUS;
import GUI.Frame.Main;
import DAO.PhieuXuatDAO;
import DAO.ChiTietPhieuXuatDAO;
import DAO.KhachHangDAO;
import DTO.PhieuXuatDTO;
import DTO.ChiTietPhieuXuatDTO;
import GUI.Dialog.DetailPhieuXuatDialog;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import util.Func_class;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFileChooser;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTextField;
import util.CustomScrollBarUI;
import javax.swing.JScrollPane;
import util.RoundedBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.DropShadowBorder;




/**
 *
 * @author kiman
 */
public class PanelPhieuXuat extends javax.swing.JPanel {
    private Func_class func=new Func_class();
    private Main main;
    private javax.swing.JTable jTablePhieuXuat;
    private int hoverIndex = -1;
    NhanVienBUS nvBus=new NhanVienBUS();

    public PanelPhieuXuat(Main main) {
        initComponents();
        setupUIComponents();
        Dimension inputSize = new Dimension(200, 35);
        jTextField1.setPreferredSize(inputSize);
        jTextField2.setPreferredSize(inputSize);
        jComboBox6.setPreferredSize(inputSize);
        jComboBox7.setPreferredSize(inputSize);
        jdatechooser_ngaytaopx1.setPreferredSize(inputSize);
        jdatechooser_ngaytaopx2.setPreferredSize(inputSize);
        txt_search_px.setPreferredSize(inputSize);
        cbb_search_px.setPreferredSize(new Dimension(130, 35));
        jdatechooser_ngaytaopx2.setMaxSelectableDate(new java.util.Date());
        this.main=main;
        this.jTablePhieuXuat = table_px;
        PromptSupport.setPrompt("Tìm kiếm nhanh", txt_search_px);
        PromptSupport.setForeground(Color.GRAY, txt_search_px);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, txt_search_px);
        setCursorPointer();
        setIconForJLabel();
        setUpTable();
        loadDanhSachPhieuXuat();
        loadComboBoxKhachHang();
        loadComboBoxNhanVien();
        jComboBox7.addActionListener(e -> filterPhieuXuat());
        jComboBox6.addActionListener(e -> filterPhieuXuat());
        jdatechooser_ngaytaopx1.addPropertyChangeListener("date", evt -> filterPhieuXuat());
        jdatechooser_ngaytaopx2.addPropertyChangeListener("date", evt -> filterPhieuXuat());
        jTextField2.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filterPhieuXuat(); }
            public void removeUpdate(DocumentEvent e) { filterPhieuXuat(); }
            public void changedUpdate(DocumentEvent e) { filterPhieuXuat(); }
        });
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filterPhieuXuat(); }
            public void removeUpdate(DocumentEvent e) { filterPhieuXuat(); }
            public void changedUpdate(DocumentEvent e) { filterPhieuXuat(); }
        });
        cbb_search_px.addActionListener(e -> filterPhieuXuat());
        txt_search_px.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filterPhieuXuat(); }
            public void removeUpdate(DocumentEvent e) { filterPhieuXuat(); }
            public void changedUpdate(DocumentEvent e) { filterPhieuXuat(); }
        });
    }
    public void setUpTable() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[] { "STT", "Mã PX", "Khách hàng", "Nhân viên xuất", "Thời gian", "Tổng tiền" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_px.setModel(model);
        func.centerTable(table_px);
        func.setUpTable(table_px);
        table_px.getColumnModel().getColumn(0).setPreferredWidth(30);
        table_px.getColumnModel().getColumn(1).setPreferredWidth(35);
        table_px.getColumnModel().getColumn(3).setPreferredWidth(150);
        table_px.getColumnModel().getColumn(4).setPreferredWidth(160);
    }
    public void setIconForJLabel(){
        jlabel_add_px.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_detail_px.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        jlabel_delete_px.setIcon(new FlatSVGIcon("./resources/icon/huyphieu.svg", 0.06f));
        jlabel_excel_px.setIcon(new FlatSVGIcon("./resources/icon/excel.svg", 0.5f));
        jpanel_chucNang_px.setBorder(new DropShadowBorder(1,Color.BLACK));
        jPanel3.setBorder(new DropShadowBorder(1,Color.BLACK));
    }
    public void setCursorPointer(){
        func.cursorPointer(jlabel_add_px);
        func.cursorPointer(jlabel_detail_px);
        func.cursorPointer(jlabel_delete_px);
        func.cursorPointer(jlabel_excel_px);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        reset_px = new javax.swing.JButton();
        txt_search_px = new javax.swing.JTextField();
        cbb_search_px = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdatechooser_ngaytaopx2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jdatechooser_ngaytaopx1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_px = new javax.swing.JTable();
        jpanel_chucNang_px = new javax.swing.JPanel();
        jlabel_detail_px = new javax.swing.JLabel();
        jlabel_add_px = new javax.swing.JLabel();
        jlabel_delete_px = new javax.swing.JLabel();
        jlabel_excel_px = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(907, 607));

        reset_px.setText("Làm mới");
        reset_px.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_pxActionPerformed(evt);
            }
        });

        txt_search_px.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_pxActionPerformed(evt);
            }
        });

        cbb_search_px.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã phiếu", "Khách hàng", "Nhân viên xuất" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cbb_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search_px, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset_px)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_px, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Khách hàng");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Nhân viên xuất");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Từ số tiền (VND)");

        jLabel4.setText("Đến số tiền (VND)");

        jLabel5.setText("Từ ngày");

        jLabel6.setText("Đến ngày");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdatechooser_ngaytaopx2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdatechooser_ngaytaopx1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addComponent(jTextField1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdatechooser_ngaytaopx1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jdatechooser_ngaytaopx2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        table_px.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu xuất", "Khách hàng", "Nhân viên xuất", "Thời gian", "Tổng tiền"
            }
        ));
        jScrollPane3.setViewportView(table_px);

        jlabel_detail_px.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_detail_pxjlabel_update_pxMouseClicked(evt);
            }
        });

        jlabel_add_px.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_pxjlabel_add_pxMouseClicked(evt);
            }
        });

        jlabel_delete_px.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_pxjlabel_delete_pxMouseClicked(evt);
            }
        });

        jlabel_excel_px.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_excel_pxjlabel_delete_pxMouseClicked(evt);
            }
        });

        jLabel7.setText("Thêm");

        jLabel8.setText("Chi tiết");

        jLabel9.setText("Hủy phiếu");

        jLabel10.setText("Xuất Excel");

        javax.swing.GroupLayout jpanel_chucNang_pxLayout = new javax.swing.GroupLayout(jpanel_chucNang_px);
        jpanel_chucNang_px.setLayout(jpanel_chucNang_pxLayout);
        jpanel_chucNang_pxLayout.setHorizontalGroup(
            jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_pxLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_add_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang_pxLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_detail_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang_pxLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_excel_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jpanel_chucNang_pxLayout.setVerticalGroup(
            jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_pxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_excel_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_detail_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpanel_chucNang_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpanel_chucNang_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_detail_pxjlabel_update_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_detail_pxjlabel_update_pxMouseClicked
        // TODO add your handling code here:
        int selectedRow = table_px.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu xuất để xem chi tiết!");
            return;
        }
        String maPX = table_px.getValueAt(selectedRow, 1).toString();
        DetailPhieuXuatDialog dialog = new DetailPhieuXuatDialog();
        PhieuXuatDTO px = new PhieuXuatDAO().layPhieuXuatTheoMa(maPX);
        if (px == null) return;
        dialog.setMaPhieu(px.getMaPX());
        String tenNV=nvBus.getTenNVByID(px.getMaNV());
        dialog.setNhanVien(tenNV);
        dialog.setThoiGian(px.getThoiGian());
        dialog.setKhachHang(new KhachHangDAO().layTenKhachHangTheoMa(px.getMaKH()));
        ArrayList<ChiTietPhieuXuatDTO> dsCT = new ChiTietPhieuXuatDAO().layChiTietTheoMaPhieu(px.getMaPX());
        dialog.loadChiTiet(dsCT);
        javax.swing.JDialog d = new javax.swing.JDialog();
        d.setTitle("Chi tiết phiếu xuất");
        d.setContentPane(dialog);
        d.pack();
        d.setLocationRelativeTo(null);
        d.setModal(true);
        d.setVisible(true);
    }//GEN-LAST:event_jlabel_detail_pxjlabel_update_pxMouseClicked

    private void jlabel_add_pxjlabel_add_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_pxjlabel_add_pxMouseClicked
        main.getPanelNhapPX().setVisible(true);
        main.getPanelPhieuXuat().setVisible(false);
        main.getPanelNhapPX().loadTableSanPham();
        main.getPanelNhapPX().resetAll();
    }//GEN-LAST:event_jlabel_add_pxjlabel_add_pxMouseClicked

    private void jlabel_delete_pxjlabel_delete_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_pxjlabel_delete_pxMouseClicked
        // TODO add your handling code here:
        int selectedRow = table_px.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn một phiếu xuất để xóa!");
            return;
        }
        String maPX = table_px.getValueAt(selectedRow, 1).toString(); 
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá phiếu xuất " + maPX + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new DAO.PhieuXuatDAO().xoaPhieuXuatVaCapNhatTonKho(maPX); 
            loadDanhSachPhieuXuat(); 
        }
    }//GEN-LAST:event_jlabel_delete_pxjlabel_delete_pxMouseClicked

    private void reset_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_pxActionPerformed
        // TODO add your handling code here:
        jComboBox6.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        jdatechooser_ngaytaopx1.setDate(null);
        jdatechooser_ngaytaopx2.setDate(null);
        jTextField1.setText("");
        jTextField2.setText("");
        cbb_search_px.setSelectedIndex(0);
        txt_search_px.setText("");
        filterPhieuXuat();
        filterPhieuXuat();
        
    }//GEN-LAST:event_reset_pxActionPerformed

    private void txt_search_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_pxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_pxActionPerformed

    private void jlabel_excel_pxjlabel_delete_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_excel_pxjlabel_delete_pxMouseClicked
        // TODO add your handling code here:
         exportToExcel();
    }//GEN-LAST:event_jlabel_excel_pxjlabel_delete_pxMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public void themPhieuXuatVaoBang(String maPX, String tenKH, String tenNV, String thoiGian, double tongTien) {
        DefaultTableModel model = (DefaultTableModel) jTablePhieuXuat.getModel();
        int stt = model.getRowCount() + 1;
        DecimalFormat df = new DecimalFormat("#,###");
        model.addRow(new Object[]{
            stt,
            maPX,
            tenKH,
            tenNV,
            thoiGian,
            df.format(tongTien) + "đ"
        });
    }
    public void loadDanhSachPhieuXuat() {
        ArrayList<DTO.PhieuXuatDTO> danhSach = new DAO.PhieuXuatDAO().layTatCaPhieuXuat();
        DefaultTableModel model = (DefaultTableModel) table_px.getModel();
        model.setRowCount(0);
        int stt = 1;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#,###");
        for (DTO.PhieuXuatDTO px : danhSach) {
            String tenNV = nvBus.getTenNVByID(px.getMaNV());
            model.addRow(new Object[]{
                stt++,
                px.getMaPX(),
                new DAO.KhachHangDAO().layTenKhachHangTheoMa(px.getMaKH()), tenNV, px.getThoiGian().toString().replace("T", " "), df.format(px.getTongTien()) + "đ"
            });

        }
    }
    private void filterPhieuXuat() {
        String tenKH = jComboBox7.getSelectedItem().toString();
        String tenNV = jComboBox6.getSelectedItem().toString();
        java.util.Date tuNgay = jdatechooser_ngaytaopx1.getDate();
        java.util.Date denNgay = jdatechooser_ngaytaopx2.getDate();
        String tuTienStr = jTextField2.getText().replace(",", "").replace("đ", "").trim();
        String denTienStr = jTextField1.getText().replace(",", "").replace("đ", "").trim();
        String searchType = cbb_search_px.getSelectedItem().toString();
        String keyword = txt_search_px.getText().trim().toLowerCase();

        ArrayList<PhieuXuatDTO> danhSach = new PhieuXuatDAO().layTatCaPhieuXuat();
        DefaultTableModel model = (DefaultTableModel) table_px.getModel();
        model.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,###");
        int stt = 1;

        java.util.Date now = new java.util.Date();
        if (denNgay != null && denNgay.after(now)) {
            denNgay = now;
        }

        for (PhieuXuatDTO px : danhSach) {
            boolean hopLe = true;

            String tenKHDB = new KhachHangDAO().layTenKhachHangTheoMa(px.getMaKH());
            String tenNVDB = nvBus.getTenNVByID(px.getMaNV());
            java.util.Date ngayPX = java.sql.Timestamp.valueOf(px.getThoiGian());
            double tongTien = px.getTongTien();

            // Lọc khách hàng
            if (!tenKH.equals("Tất cả") && !tenKHDB.equals(tenKH)) {
                hopLe = false;
            }

            // Lọc nhân viên
            if (!tenNV.equals("Tất cả") && !tenNVDB.equals(tenNV)) {
                hopLe = false;
            }

            // Lọc theo ngày
            if (tuNgay != null && ngayPX.before(tuNgay)) {
                hopLe = false;
            }
            if (denNgay != null && ngayPX.after(denNgay)) {
                hopLe = false;
            }

            // Lọc theo giá
            if (!tuTienStr.equals("Tất cả") && !tuTienStr.isEmpty()) {
                try {
                    double min = Double.parseDouble(tuTienStr);
                    if (tongTien < min) {
                        hopLe = false;
                    }
                } catch (NumberFormatException e) {
                    hopLe = false;
                }
            }

            if (!denTienStr.equals("Tất cả") && !denTienStr.isEmpty()) {
                try {
                    double max = Double.parseDouble(denTienStr);
                    if (tongTien > max) {
                        hopLe = false;
                    }
                } catch (NumberFormatException e) {
                    hopLe = false;
                }
            }

            // Lọc theo từ khóa
            if (!keyword.isEmpty()) {
                if (!searchType.equals("Tất cả")) {
                    if (searchType.equals("Mã phiếu") && !px.getMaPX().toLowerCase().contains(keyword)) {
                        hopLe = false;
                    } else if (searchType.equals("Khách hàng") && !tenKHDB.toLowerCase().contains(keyword)) {
                        hopLe = false;
                    } else if (searchType.equals("Nhân viên xuất") && !tenNVDB.toLowerCase().contains(keyword)) {
                        hopLe = false;
                    }
                } else {
                    String allFields = (px.getMaPX() + " " + tenKHDB + " " + tenNVDB + " " + px.getThoiGian() + " " + tongTien).toLowerCase();
                    if (!allFields.contains(keyword)) {
                        hopLe = false;
                    }
                }
            }

            // Thêm dòng nếu hợp lệ
            if (hopLe) {
                model.addRow(new Object[]{
                    stt++,
                    px.getMaPX(),
                    tenKHDB,
                    tenNVDB,
                    px.getThoiGian().toString().replace("T", " "),
                    df.format(tongTien) + "đ"
                });
            }
        }
    }
    private void loadComboBoxKhachHang() {
        jComboBox7.removeAllItems();
        jComboBox7.addItem("Tất cả");
        for (String tenKH : new KhachHangDAO().layTatCaTenKhachHang()) {
            jComboBox7.addItem(tenKH);
        }
    }
    private void loadComboBoxNhanVien() {
        jComboBox6.removeAllItems();
        jComboBox6.addItem("Tất cả");
        for (String tenNV : new DAO.NhanVienDAO().layTatCaTenNhanVien()) {
        jComboBox6.addItem(tenNV);
        }
    }
    private void exportToExcel() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
            fileChooser.setSelectedFile(new java.io.File("phieuxuat.xlsx"));
            int result = fileChooser.showSaveDialog(this);
            if (result != JFileChooser.APPROVE_OPTION) return;
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            org.apache.poi.ss.usermodel.Workbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Phiếu xuất");
            org.apache.poi.ss.usermodel.Row header = sheet.createRow(0);
            for (int i = 0; i < table_px.getColumnCount(); i++) {
                header.createCell(i).setCellValue(table_px.getColumnName(i));
            }
            for (int i = 0; i < table_px.getRowCount(); i++) {
                org.apache.poi.ss.usermodel.Row row = sheet.createRow(i + 1);
                for (int j = 0; j < table_px.getColumnCount(); j++) {
                    Object value = table_px.getValueAt(i, j);
                    row.createCell(j).setCellValue(value != null ? value.toString() : "");
                }
            }
            try (java.io.FileOutputStream out = new java.io.FileOutputStream(filePath)) {
                workbook.write(out);
            }
            workbook.close();

            JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất Excel!");
        }
    }
    private void customComboBoxUI(JComboBox<?> comboBox) {
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
        comboBox.setFocusable(false);
        comboBox.setOpaque(true);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
        comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, false, false); // không dùng isSelected
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
        if (comboBox.getEditor().getEditorComponent() instanceof JTextField) {
            JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
            editor.setBackground(Color.WHITE);
            editor.setForeground(Color.BLACK);
            editor.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }
        comboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboBox.setBackground(new Color(250, 250, 250));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
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
                        @Override
                        public void mouseMoved(java.awt.event.MouseEvent e) {
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
    private void setupUIComponents() {
        RoundedBorder roundedBorder = new RoundedBorder(10);
        JComboBox<?>[] comboBoxes = { jComboBox6, jComboBox7, cbb_search_px };
        for (JComboBox<?> comboBox : comboBoxes) {
            customComboBoxUI(comboBox); 
            comboBox.setBorder(roundedBorder);
        }
        JTextField[] textFields = { txt_search_px, jTextField1, jTextField2 };
        for (JTextField tf : textFields) {
            tf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            tf.setBackground(Color.WHITE);
            tf.setForeground(Color.BLACK);
            tf.setBorder(roundedBorder);
        }
        reset_px.setFocusPainted(false);
        reset_px.setContentAreaFilled(false);
        reset_px.setOpaque(true);
        reset_px.setBackground(Color.WHITE);
        reset_px.setForeground(Color.BLACK);
        reset_px.setBorder(roundedBorder);
        reset_px.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reset_px.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        reset_px.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.3f));
        reset_px.setIconTextGap(10);
        JTextField dateEditor1 = ((JTextField) jdatechooser_ngaytaopx1.getDateEditor().getUiComponent());
        dateEditor1.setBorder(new RoundedBorder(15));
        dateEditor1.setBackground(Color.WHITE);
        dateEditor1.setOpaque(true);
        dateEditor1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JTextField dateEditor2 = ((JTextField) jdatechooser_ngaytaopx2.getDateEditor().getUiComponent());
        dateEditor2.setBorder(new RoundedBorder(15));
        dateEditor2.setBackground(Color.WHITE);
        dateEditor2.setOpaque(true);
        dateEditor2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        for (Component c : jdatechooser_ngaytaopx1.getComponents()) {
            if (c instanceof JButton btn) {
                btn.setBackground(new Color(240, 240, 240));
                btn.setBorder(new RoundedBorder(15));
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setFocusable(false);
                btn.setContentAreaFilled(true);
                btn.setOpaque(true);
                btn.setIcon(new FlatSVGIcon("./resources/icon/calendar.svg", 0.03f));
            }
        }
        for (Component c : jdatechooser_ngaytaopx2.getComponents()) {
            if (c instanceof JButton btn) {
                btn.setBackground(new Color(240, 240, 240));
                btn.setBorder(new RoundedBorder(15));
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setFocusable(false);
                btn.setContentAreaFilled(true);
                btn.setOpaque(true);
                btn.setIcon(new FlatSVGIcon("./resources/icon/calendar.svg", 0.03f));
            }
        }
        jdatechooser_ngaytaopx1.setBorder(BorderFactory.createEmptyBorder());
        jdatechooser_ngaytaopx2.setBorder(BorderFactory.createEmptyBorder());
    }
    private JList<?> getPopupList(JComboBox<?> comboBox) {
        Object comp = comboBox.getUI().getAccessibleChild(comboBox, 0);
        if (comp instanceof javax.swing.plaf.basic.ComboPopup popup) {
            return popup.getList();
        }
        return null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbb_search_px;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JDateChooser jdatechooser_ngaytaopx1;
    private com.toedter.calendar.JDateChooser jdatechooser_ngaytaopx2;
    private javax.swing.JLabel jlabel_add_px;
    private javax.swing.JLabel jlabel_delete_px;
    private javax.swing.JLabel jlabel_detail_px;
    private javax.swing.JLabel jlabel_excel_px;
    private javax.swing.JPanel jpanel_chucNang_px;
    private javax.swing.JButton reset_px;
    private javax.swing.JTable table_px;
    private javax.swing.JTextField txt_search_px;
    // End of variables declaration//GEN-END:variables
}
