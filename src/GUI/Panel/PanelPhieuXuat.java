/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import GUI.GUIFrame.Main;
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
import javax.swing.BorderFactory;
import java.awt.Dimension;



/**
 *
 * @author kiman
 */
public class PanelPhieuXuat extends javax.swing.JPanel {
    private Func_class func=new Func_class();
    private Main main;
    private javax.swing.JTable jTablePhieuXuat;

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
    public void setUpTable(){
        func.centerTable(table_px);
        func.setUpTable(table_px);
        // Bật lưới với màu xám nhạt
        table_px.setShowGrid(true);
        table_px.setGridColor(new java.awt.Color(240, 240, 240));
        table_px.setIntercellSpacing(new java.awt.Dimension(0, 1)); // chỉ đường ngang
        table_px.setBorder(null);
        jScrollPane3.setBorder(null);

        // Căn giữa header bảng và định dạng đẹp
        javax.swing.table.JTableHeader header = table_px.getTableHeader();
        header.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                javax.swing.JLabel label = new javax.swing.JLabel(value.toString());
                label.setFont(label.getFont().deriveFont(java.awt.Font.BOLD));
                label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBackground(new java.awt.Color(245, 245, 245)); // nền xám nhạt
                label.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 10, 5)); // padding
                return label;
            }
        });

        header.setReorderingAllowed(false);
    }
    public void setIconForJLabel(){
        jlabel_add_px.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_detail_px.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        jlabel_delete_px.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_excel_px.setIcon(new FlatSVGIcon("./resources/icon/excel.svg", 0.5f));
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

        jpn_px1 = new javax.swing.JPanel();
        jpanel_chucNang_px = new javax.swing.JPanel();
        jlabel_detail_px = new javax.swing.JLabel();
        jlabel_add_px = new javax.swing.JLabel();
        jlabel_delete_px = new javax.swing.JLabel();
        jlabel_excel_px = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_px = new javax.swing.JTable();
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

        setPreferredSize(new java.awt.Dimension(907, 607));

        jpn_px1.setPreferredSize(new java.awt.Dimension(1030, 625));

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

        javax.swing.GroupLayout jpanel_chucNang_pxLayout = new javax.swing.GroupLayout(jpanel_chucNang_px);
        jpanel_chucNang_px.setLayout(jpanel_chucNang_pxLayout);
        jpanel_chucNang_pxLayout.setHorizontalGroup(
            jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_pxLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_add_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_detail_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_delete_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_excel_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
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
                .addContainerGap(24, Short.MAX_VALUE))
        );

        table_px.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu xuất", "Khách hàng", "Nhân viên nhập", "Thời gian", "Tổng tiền"
            }
        ));
        jScrollPane3.setViewportView(table_px);

        javax.swing.GroupLayout jpn_px1Layout = new javax.swing.GroupLayout(jpn_px1);
        jpn_px1.setLayout(jpn_px1Layout);
        jpn_px1Layout.setHorizontalGroup(
            jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_px1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel_chucNang_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_px1Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jpn_px1Layout.setVerticalGroup(
            jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_px1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jpanel_chucNang_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbb_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTextField1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addContainerGap()))
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
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(318, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(166, 166, 166)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(546, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpn_px1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpn_px1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
    dialog.setNhanVien(px.getMaNV());
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
        model.setRowCount(0); // Xoá dữ liệu cũ

        int stt = 1;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#,###");
        for (DTO.PhieuXuatDTO px : danhSach) {
            model.addRow(new Object[]{
                stt++,
                px.getMaPX(),
                new DAO.KhachHangDAO().layTenKhachHangTheoMa(px.getMaKH()),
                px.getMaNV(),
                px.getThoiGian().toString().replace("T", " "),
                df.format(px.getTongTien()) + "đ"
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
        ArrayList<PhieuXuatDTO> danhSach = new PhieuXuatDAO().layTatCaPhieuXuat();
        DefaultTableModel model = (DefaultTableModel) table_px.getModel();
        model.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,###");
        int stt = 1;
        for (PhieuXuatDTO px : danhSach) {
            String tenKHDB = new KhachHangDAO().layTenKhachHangTheoMa(px.getMaKH());
            boolean hopLe = true;
            if (!tenKH.equals("Tất cả") && !tenKHDB.equals(tenKH)) hopLe = false;
            if (!tenNV.equals("Tất cả") && !px.getMaNV().equals(tenNV)) hopLe = false;
            java.util.Date ngayPX = java.sql.Timestamp.valueOf(px.getThoiGian());
            java.util.Date now = new java.util.Date();
            if (denNgay != null && denNgay.after(now)) denNgay = now;
            if (tuNgay != null && ngayPX.before(tuNgay)) hopLe = false;
            if (denNgay != null && ngayPX.after(denNgay)) hopLe = false;
            double tongTien = px.getTongTien();
            String searchType = cbb_search_px.getSelectedItem().toString();
            String keyword = txt_search_px.getText().trim().toLowerCase();
            if (!searchType.equals("Tất cả") && !keyword.isEmpty()) {
                if (searchType.equals("Mã phiếu") && !px.getMaPX().toLowerCase().contains(keyword)) hopLe = false;
                if (searchType.equals("Khách hàng") && !tenKHDB.toLowerCase().contains(keyword)) hopLe = false;
                if (searchType.equals("Nhân viên xuất") && !px.getMaNV().toLowerCase().contains(keyword)) hopLe = false;
            }
            if (!tuTienStr.equals("Tất cả") && !tuTienStr.isEmpty() && tongTien < Double.parseDouble(tuTienStr)) hopLe = false;
            if (!denTienStr.equals("Tất cả") && !denTienStr.isEmpty() && tongTien > Double.parseDouble(denTienStr)) hopLe = false;
            if (hopLe) {
                model.addRow(new Object[]{
                    stt++,
                    px.getMaPX(),
                    tenKHDB,
                    px.getMaNV(),
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
        for (String maNV : new DAO.NhanVienDAO().layTatCaMaNhanVien()) {
            jComboBox6.addItem(maNV);
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

            // Tiêu đề
            org.apache.poi.ss.usermodel.Row header = sheet.createRow(0);
            for (int i = 0; i < table_px.getColumnCount(); i++) {
                header.createCell(i).setCellValue(table_px.getColumnName(i));
            }

            // Dữ liệu
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
    private void customComboBoxUI(javax.swing.JComboBox<?> comboBox) {
        comboBox.setBackground(java.awt.Color.WHITE);
        comboBox.setFocusable(false);
        comboBox.setOpaque(true);
        comboBox.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected javax.swing.JButton createArrowButton() {
                javax.swing.plaf.basic.BasicArrowButton arrow = new javax.swing.plaf.basic.BasicArrowButton(
                        javax.swing.plaf.basic.BasicArrowButton.SOUTH,
                        java.awt.Color.WHITE, // background
                        java.awt.Color.WHITE,  // shadow
                        java.awt.Color.BLACK, // darkShadow
                        java.awt.Color.WHITE // highlight
                );
                arrow.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                return arrow;
            }
        });        
    }
    private void setupUIComponents() {
        // ComboBox giao diện
        customComboBoxUI(jComboBox6);
        customComboBoxUI(jComboBox7);
        customComboBoxUI(cbb_search_px);

        // Giao diện TextField tìm kiếm
        txt_search_px.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        txt_search_px.setBackground(java.awt.Color.WHITE);
        txt_search_px.setForeground(java.awt.Color.BLACK);
        txt_search_px.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200)));
        txt_search_px.setToolTipText("Nhập nội dung tìm kiếm...");
        txt_search_px.setText(""); 

        // Giao diện Button "Làm mới"
        reset_px.setFocusPainted(false);
        reset_px.setContentAreaFilled(false);
        reset_px.setOpaque(true);
        reset_px.setBackground(java.awt.Color.WHITE);
        reset_px.setForeground(java.awt.Color.BLACK);
        reset_px.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 1, true));
        reset_px.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_px.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        reset_px.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.4f));
        reset_px.setIconTextGap(10);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbb_search_px;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel jpn_px1;
    private javax.swing.JButton reset_px;
    private javax.swing.JTable table_px;
    private javax.swing.JTextField txt_search_px;
    // End of variables declaration//GEN-END:variables
}
