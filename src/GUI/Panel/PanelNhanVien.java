/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
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
import util.DropShadowBorder;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelNhanVien extends javax.swing.JPanel {
    Func_class func=new Func_class();
    NhanVienBUS nhanvienBUS=new NhanVienBUS();
    TaiKhoanBUS tkBus=new TaiKhoanBUS();
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
        setUpBtn();
        setBorderPanel();
        setUpCBB();
        setUpJTF();
    }
    public JTable getTableNhanVien(){
        return this.table_nv;
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find_nv);
        PromptSupport.setForeground(Color.GRAY, jtf_find_nv);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find_nv);
    }
    public void setUpBtn(){
        func.setUpBtn(btn_refresh_nv, Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_look_nv, Color.WHITE,new Color(220,220,220));
    }
    public void setCusorPointer() {
        List<JLabel> jlabels =List.of(jlabel_add_nv,jlabel_update_nv,jlabel_delete_nv
        ,jlabel_nhap_excel_nv,jlabel_chitiet_nv,jlabel_xuat_excel_nv);
        for(JLabel label : jlabels )
            func.cursorPointer(label);
    }
    public void setBorderPanel(){
        jpanel_chucNang_nv.setBorder(new DropShadowBorder(1,Color.BLACK));
        jpanel_timkiem_nv.setBorder(new DropShadowBorder(1,Color.BLACK));
    }
    public void setUpCBB(){
        func.setUpComBoBox(combobox_find_nv);
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_find_nv);
    }
    public void setIconForJLabel() {
        jlabel_add_nv.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_nv.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_nv.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        btn_look_nv.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.7f));
        btn_refresh_nv.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.3f));
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
        combobox_find_nv = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        btn_refresh_nv = new javax.swing.JButton();
        btn_look_nv = new javax.swing.JButton();

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

        jLabel8.setText("     Sửa");

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
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jlabel_xuat_excel_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpanel_chucNang_nvLayout.setVerticalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_nhap_excel_nv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_xuat_excel_nv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_chitiet_nv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        jScrollPane1.setName(""); // NOI18N

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

        jLabel24.setText("Tìm kiếm theo");

        btn_refresh_nv.setText("Làm mới");
        btn_refresh_nv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh_nvActionPerformed(evt);
            }
        });

        btn_look_nv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_look_nvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_timkiem_nvLayout = new javax.swing.GroupLayout(jpanel_timkiem_nv);
        jpanel_timkiem_nv.setLayout(jpanel_timkiem_nvLayout);
        jpanel_timkiem_nvLayout.setHorizontalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                        .addComponent(combobox_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_look_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_refresh_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );
        jpanel_timkiem_nvLayout.setVerticalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(4, 4, 4)
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_look_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refresh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
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
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int maNV = Integer.parseInt(table_nv.getValueAt(vitriRow, 0).toString());
        TaiKhoanDTO tk = tkBus.getTKIsLogin();
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Xóa nhân viên", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (confirm == JOptionPane.YES_OPTION) {
            if (maNV == tk.getMaNV()) {
                JOptionPane.showMessageDialog(null, "Không thể xóa tài khoản đang đăng nhập", "Error", 0);
                return;
            }
            int result = nhanvienBUS.deleteCheckNhanVien(maNV);
            if (result == 1) {
                func.addDataTableNV(nhanvienBUS.listNV(), table_nv);
                func.centerTable(table_nv);
            }
        }
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

    private void btn_refresh_nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh_nvActionPerformed
        jtf_find_nv.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_refresh_nvActionPerformed

    private void btn_look_nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_look_nvActionPerformed
        String choose_combobox = combobox_find_nv.getSelectedItem().toString();
        String text = jtf_find_nv.getText();
        func.addDataTableNV(nhanvienBUS.timKiem(text,choose_combobox), table_nv);
        func.centerTable(table_nv);
    }//GEN-LAST:event_btn_look_nvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_look_nv;
    private javax.swing.JButton btn_refresh_nv;
    private javax.swing.JComboBox<String> combobox_find_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add_nv;
    private javax.swing.JLabel jlabel_chitiet_nv;
    private javax.swing.JLabel jlabel_delete_nv;
    private javax.swing.JLabel jlabel_nhap_excel_nv;
    private javax.swing.JLabel jlabel_update_nv;
    private javax.swing.JLabel jlabel_xuat_excel_nv;
    private javax.swing.JPanel jpanel_chucNang_nv;
    private javax.swing.JPanel jpanel_timkiem_nv;
    private javax.swing.JTextField jtf_find_nv;
    private javax.swing.JTable table_nv;
    // End of variables declaration//GEN-END:variables
}
