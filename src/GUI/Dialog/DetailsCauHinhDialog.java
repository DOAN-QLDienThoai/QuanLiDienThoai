/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import DAO.MauSacDAO;
import DAO.RamDAO;
import DAO.RomDAO;
import DTO.DienThoaiDTO;
import DTO.PhienBanDienThoaiDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class DetailsCauHinhDialog extends javax.swing.JDialog {
    DienThoaiDTO dt=new DienThoaiDTO();
    Func_class func = new Func_class();
    ArrayList<PhienBanDienThoaiDTO> listPBDTTemp;
    public DetailsCauHinhDialog(java.awt.Frame parent, boolean modal,int maDT,ArrayList<PhienBanDienThoaiDTO> listPBDTTemp) {
        super(parent, modal);
        initComponents();
        this.setTitle("Xem chi tiết cấu hình");
        this.setLocationRelativeTo(null);
        dt.setMaDT(maDT);
        this.listPBDTTemp=listPBDTTemp;
        khoiTao();
    }
    public void khoiTao(){
        setIcon();
        setUpTable();
    }
    public void setIcon(){
        btn_return.setIcon(new FlatSVGIcon("./resources/icon/left.svg",0.34f));
    }
    public void setUpTable() {
        this.addDatatable();
        func.setUpTable(table_cauHinh);
        func.centerTable(table_cauHinh);
    }
    //Thêm dữ liệu vào bảng cấu hình
    public void addDatatable() {
        String[] colNames = {"STT","Ram", "Rom", "Màu Sắc", "Giá nhập", "Giá xuất"};
        Object[][] rows = new Object[listPBDTTemp.size()][colNames.length];
        int index = 0;
        for (PhienBanDienThoaiDTO pb : listPBDTTemp) {
            // Lấy thông tin Ram
            int maRam = pb.getmaRam();
            int dungLuongRam = -1;
            HashMap<Integer, Integer> mapRam = new RamDAO().listMapRam();
            for (Map.Entry<Integer, Integer> entry : mapRam.entrySet()) {
                if (maRam == entry.getValue()) {
                    dungLuongRam = entry.getKey();
                    break;
                }
            }
            // Lấy thông tin Rom
            int maRom = pb.getmaRom();
            int dungLuongRom = -1;
            HashMap<Integer, Integer> mapRom = new RomDAO().listMapRom();
            for (Map.Entry<Integer, Integer> entry : mapRom.entrySet()) {
                if (maRom == entry.getValue()) {
                    dungLuongRom = entry.getKey();
                    break;
                }
            }
            // Lấy thông tin Màu sắc
            int maMau = pb.getmaMau();
            String tenMau = null;
            HashMap<String, Integer> mapMS = new MauSacDAO().listMapMS();
            for (Map.Entry<String, Integer> entry : mapMS.entrySet()) {
                if (maMau == entry.getValue()) {
                    tenMau = entry.getKey();
                    break;
                }
            }
            // Cập nhật giá trị vào bảng
            rows[index][0]=index;
            rows[index][1] = String.valueOf(dungLuongRam);
            rows[index][2] = String.valueOf(dungLuongRom);
            rows[index][3] = tenMau;
            rows[index][4] = String.format("%,.0f", pb.getGiaNhap());
            rows[index][5] = String.format("%,.0f", pb.getGiaXuat());
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_cauHinh.setModel(model);
        func.centerTable(table_cauHinh);  
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_cauHinh = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table_cauHinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cauHinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_cauHinh);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Danh sách các phiên bản ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(247, 247, 247))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        btn_return.setText("Quay lại");
        btn_return.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cauHinhMouseClicked
        
    }//GEN-LAST:event_table_cauHinhMouseClicked

    private void btn_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_returnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_cauHinh;
    // End of variables declaration//GEN-END:variables
}
