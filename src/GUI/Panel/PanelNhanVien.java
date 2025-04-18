/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import GUI.Dialog.AddNhanVienDialog;
import GUI.Dialog.DetailsNhanVienDialog;
import GUI.Dialog.EditNhanVienDialog;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelNhanVien extends javax.swing.JPanel {
    private Func_class func=new Func_class();
    private NhanVienBUS nhanvienBUS=new NhanVienBUS();
    public PanelNhanVien() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        khoitaoChooseFilterNV();
        setIconForJLabel();
        setUpTable();
        setTextHidden();
        setCusorPointer();
    }
    public JTable getTableNhanVien(){
        return this.table_nv;
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find_nv);
        PromptSupport.setForeground(Color.GRAY, jtf_find_nv);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find_nv);
    }
    public void setCusorPointer() {
        List<JLabel> jlabels =List.of(jlabel_add_nv,jlabel_update_nv,jlabel_delete_nv
        ,jlabel_nhap_excel_nv,jlabel_chitiet_nv,jlabel_xuat_excel_nv,jlabel_refresh_nv,jlabel_look_nv);
        for(JLabel label : jlabels )
            func.cursorPointer(label);
    }
    public void setIconForJLabel() {
        jlabel_add_nv.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_nv.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_nv.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_look_nv.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        jlabel_refresh_nv.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.35f));
        jlabel_chitiet_nv.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        jlabel_xuat_excel_nv.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg", 0.85f));
        jlabel_nhap_excel_nv.setIcon(new FlatSVGIcon("./resources/icon/excel.svg", 0.55f));
    }
    public void setUpTable() {
        func.addDataTableNV(nhanvienBUS.listNV(), table_nv);
        func.centerTable(table_nv);
        func.setUpTable(table_nv);
    }
    public void khoitaoChooseFilterNV(){
        String[] filtersDT={"Tất cả","Tên nhân viên","Số điện thoại","Giới tính","Ngày sinh"};
        combobox_find_nv.setBackground(Color.WHITE);
        for(String nameFilterDT : filtersDT )
            combobox_find_nv.addItem(nameFilterDT);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_chucNang_nv = new javax.swing.JPanel();
        jlabel_update_nv = new javax.swing.JLabel();
        jlabel_add_nv = new javax.swing.JLabel();
        jlabel_delete_nv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlabel_chitiet_nv = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlabel_nhap_excel_nv = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlabel_xuat_excel_nv = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_nv = new javax.swing.JTable();
        jpanel_timkiem_nv = new javax.swing.JPanel();
        jtf_find_nv = new javax.swing.JTextField();
        jlabel_look_nv = new javax.swing.JLabel();
        combobox_find_nv = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jpanel_filter_nv = new javax.swing.JPanel();
        jlabel_refresh_nv = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        jpanel_chucNang_nv.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_update_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_nvMouseClicked(evt);
            }
        });

        jlabel_add_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_nvMouseClicked(evt);
            }
        });

        jlabel_delete_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_nvMouseClicked(evt);
            }
        });

        jLabel1.setText("  Thêm");

        jLabel8.setText("    Sửa");

        jLabel9.setText("   Xóa");

        jlabel_chitiet_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chitiet_nvMouseClicked(evt);
            }
        });

        jLabel11.setText("Chi tiết");

        jLabel13.setText("Nhập Excel");

        jlabel_xuat_excel_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_xuat_excel_nvMouseClicked(evt);
            }
        });

        jLabel15.setText("Xuất Excel");

        javax.swing.GroupLayout jpanel_chucNang_nvLayout = new javax.swing.GroupLayout(jpanel_chucNang_nv);
        jpanel_chucNang_nv.setLayout(jpanel_chucNang_nvLayout);
        jpanel_chucNang_nvLayout.setHorizontalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_nvLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_chitiet_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_nhap_excel_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_xuat_excel_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpanel_chucNang_nvLayout.setVerticalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_xuat_excel_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_nhap_excel_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_chitiet_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        table_nv.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_nv);

        jpanel_timkiem_nv.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_look_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_look_nvMouseClicked(evt);
            }
        });

        jLabel24.setText("Tìm kiếm theo");

        javax.swing.GroupLayout jpanel_timkiem_nvLayout = new javax.swing.GroupLayout(jpanel_timkiem_nv);
        jpanel_timkiem_nv.setLayout(jpanel_timkiem_nvLayout);
        jpanel_timkiem_nvLayout.setHorizontalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(combobox_find_nv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jpanel_timkiem_nvLayout.setVerticalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_look_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jlabel_refresh_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_refresh_nvMouseClicked(evt);
            }
        });

        jLabel27.setText("Làm mới");

        javax.swing.GroupLayout jpanel_filter_nvLayout = new javax.swing.GroupLayout(jpanel_filter_nv);
        jpanel_filter_nv.setLayout(jpanel_filter_nvLayout);
        jpanel_filter_nvLayout.setHorizontalGroup(
            jpanel_filter_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_filter_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_refresh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpanel_filter_nvLayout.setVerticalGroup(
            jpanel_filter_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_refresh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_filter_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_filter_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jlabel_update_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_nvMouseClicked
        int vitriRow = table_nv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để update", "Error", 0);
            return;
        }
        int maNV =Integer.parseInt(table_nv.getValueAt(vitriRow, 0).toString());
        String hoTen = table_nv.getValueAt(vitriRow, 1).toString();
        Date ngaySinh = (Date) table_nv.getValueAt(vitriRow, 2);
        String gioiTinh = table_nv.getValueAt(vitriRow, 3).toString();
        String sdt = table_nv.getValueAt(vitriRow, 4).toString();
        NhanVienDTO nv=new NhanVienDTO(maNV,hoTen,ngaySinh,gioiTinh,sdt);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditNhanVienDialog((Frame) parentWindow, true,nv,this).setVisible(true);
    }//GEN-LAST:event_jlabel_update_nvMouseClicked

    private void jlabel_add_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_nvMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddNhanVienDialog((Frame) parentWindow, true, this).setVisible(true);
    }//GEN-LAST:event_jlabel_add_nvMouseClicked

    private void jlabel_delete_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_nvMouseClicked
        int vitriRow = table_nv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để xóa", "Error", 0);
            return;
        }
        int maNV =Integer.parseInt(table_nv.getValueAt(vitriRow, 0).toString());
        int confirm=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa không","Xóa nhân viên",
            JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION)
        nhanvienBUS.deleteNhanVien(maNV);
        func.addDataTableNV(nhanvienBUS.listNV(), table_nv);
        func.centerTable(table_nv);
    }//GEN-LAST:event_jlabel_delete_nvMouseClicked

    private void jlabel_chitiet_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chitiet_nvMouseClicked
        int vitriRow=table_nv.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhân viên","Error",0);
            return;
        }
        String hoTen=table_nv.getValueAt(vitriRow,1).toString();
        Date ngaySinh=(Date) table_nv.getValueAt(vitriRow,2);
        String gioiTinh=table_nv.getValueAt(vitriRow,3).toString();
        String sdt = table_nv.getValueAt(vitriRow, 4).toString();
        NhanVienDTO nv=new NhanVienDTO(hoTen,ngaySinh,gioiTinh,sdt);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsNhanVienDialog((Frame) parentWindow, true, nv).setVisible(true);
    }//GEN-LAST:event_jlabel_chitiet_nvMouseClicked

    private void jlabel_xuat_excel_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_xuat_excel_nvMouseClicked
        try {
            Func_class.exportJTableToExcel(table_nv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jlabel_xuat_excel_nvMouseClicked

    private void jlabel_look_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_nvMouseClicked
        String choose_combobox = combobox_find_nv.getSelectedItem().toString();
        String text = jtf_find_nv.getText();
        func.addDataTableNV(nhanvienBUS.timKiem(text,choose_combobox), table_nv);
        func.centerTable(table_nv);
    }//GEN-LAST:event_jlabel_look_nvMouseClicked

    private void jlabel_refresh_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_refresh_nvMouseClicked
        jtf_find_nv.setText("");
        func.addDataTableNV(nhanvienBUS.listNV(), table_nv);
        func.centerTable(table_nv);
    }//GEN-LAST:event_jlabel_refresh_nvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobox_find_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add_nv;
    private javax.swing.JLabel jlabel_chitiet_nv;
    private javax.swing.JLabel jlabel_delete_nv;
    private javax.swing.JLabel jlabel_look_nv;
    private javax.swing.JLabel jlabel_nhap_excel_nv;
    private javax.swing.JLabel jlabel_refresh_nv;
    private javax.swing.JLabel jlabel_update_nv;
    private javax.swing.JLabel jlabel_xuat_excel_nv;
    private javax.swing.JPanel jpanel_chucNang_nv;
    private javax.swing.JPanel jpanel_filter_nv;
    private javax.swing.JPanel jpanel_timkiem_nv;
    private javax.swing.JTextField jtf_find_nv;
    private javax.swing.JTable table_nv;
    // End of variables declaration//GEN-END:variables
}
