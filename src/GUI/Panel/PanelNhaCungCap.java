/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import GUI.Dialog.AddNhaCungCapDialog;
import GUI.Dialog.DetailsNhaCungCapDialog;
import GUI.Dialog.EditNhaCungCapDialog;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
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
public class PanelNhaCungCap extends javax.swing.JPanel {
    Func_class func=new Func_class();
    NhaCungCapBUS nccBus=new NhaCungCapBUS();
    public PanelNhaCungCap() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        setCusorPointer();
        setUpTable();
        khoitaoChooserFilterNCC();
        setShadowforJPN();
        setIconForJlabel();
        setTextHidden();
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find_ncc);
        PromptSupport.setForeground(Color.GRAY, jtf_find_ncc);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find_ncc);
    }
    public void setIconForJlabel() {
        jlabel_add_ncc.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_ncc.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_ncc.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_look_ncc.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        jlabel_chiTiet_ncc.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        jlabel_xuat_excel_ncc.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg", 0.85f));
        jlabel_refresh_ncc.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.35f));
    }
    public void khoitaoChooserFilterNCC() {
        String[] filtersNCC = {"Tất cả", "Tên nhà cung cấp", "Email", "Số điện thoại", "Địa chỉ"};
        combobox_find_ncc.setBackground(Color.WHITE);
        for (String nameFilterNCC : filtersNCC) {
            combobox_find_ncc.addItem(nameFilterNCC);
        }
    }
    public void setShadowforJPN() {
        jpanel_timkiem_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
    }
    public JTable getTableNhaCungCap(){
        return this.table_ncc;
    }
    public void setUpTable() {
        func.addDataTableNCC(nccBus.listNCC(), table_ncc);
        func.centerTable(table_ncc);
        func.setUpTable(table_ncc);
    }
    //Hàm thêm biểu tượng chuột vào cái jlabel
    public void setCusorPointer() {
        List<JLabel> jlabels =List.of(jlabel_add_ncc
        ,jlabel_update_ncc,jlabel_delete_ncc,jlabel_chiTiet_ncc,jlabel_refresh_ncc,jlabel_look_ncc);
        for(JLabel label : jlabels )
            func.cursorPointer(label);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_chucNang_ncc = new javax.swing.JPanel();
        jlabel_update_ncc = new javax.swing.JLabel();
        jlabel_add_ncc = new javax.swing.JLabel();
        jlabel_delete_ncc = new javax.swing.JLabel();
        jlabel_chiTiet_ncc = new javax.swing.JLabel();
        jlabel_xuat_excel_ncc = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ncc = new javax.swing.JTable();
        jpanel_timkiem_ncc = new javax.swing.JPanel();
        jtf_find_ncc = new javax.swing.JTextField();
        jlabel_look_ncc = new javax.swing.JLabel();
        combobox_find_ncc = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jpanel_filter_ncc = new javax.swing.JPanel();
        jlabel_refresh_ncc = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 630));

        jpanel_chucNang_ncc.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_chucNang_ncc.setPreferredSize(new java.awt.Dimension(320, 96));

        jlabel_update_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_nccMouseClicked(evt);
            }
        });

        jlabel_add_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_nccMouseClicked(evt);
            }
        });

        jlabel_delete_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_nccMouseClicked(evt);
            }
        });

        jlabel_chiTiet_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTiet_nccMouseClicked(evt);
            }
        });

        jlabel_xuat_excel_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_xuat_excel_nccMouseClicked(evt);
            }
        });

        jLabel19.setText("  Thêm");

        jLabel20.setText("   Sửa");

        jLabel21.setText("   Xóa");

        jLabel22.setText(" Chi tiết");

        jLabel23.setText("Xuất Excel");

        javax.swing.GroupLayout jpanel_chucNang_nccLayout = new javax.swing.GroupLayout(jpanel_chucNang_ncc);
        jpanel_chucNang_ncc.setLayout(jpanel_chucNang_nccLayout);
        jpanel_chucNang_nccLayout.setHorizontalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jlabel_chiTiet_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_xuat_excel_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpanel_chucNang_nccLayout.setVerticalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_xuat_excel_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_chiTiet_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        table_ncc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_ncc);

        jpanel_timkiem_ncc.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_look_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_look_nccMouseClicked(evt);
            }
        });

        jLabel18.setText("Tìm kiếm theo");

        javax.swing.GroupLayout jpanel_timkiem_nccLayout = new javax.swing.GroupLayout(jpanel_timkiem_ncc);
        jpanel_timkiem_ncc.setLayout(jpanel_timkiem_nccLayout);
        jpanel_timkiem_nccLayout.setHorizontalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(combobox_find_ncc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jpanel_timkiem_nccLayout.setVerticalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jlabel_refresh_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_refresh_nccMouseClicked(evt);
            }
        });

        jLabel25.setText("Làm mới");

        javax.swing.GroupLayout jpanel_filter_nccLayout = new javax.swing.GroupLayout(jpanel_filter_ncc);
        jpanel_filter_ncc.setLayout(jpanel_filter_nccLayout);
        jpanel_filter_nccLayout.setHorizontalGroup(
            jpanel_filter_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_filter_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_refresh_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpanel_filter_nccLayout.setVerticalGroup(
            jpanel_filter_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabel_refresh_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_filter_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jpanel_filter_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_update_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_nccMouseClicked
        int vitriRow = table_ncc.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp để update", "Error", 0);
            return;
        }
        int maNCC =Integer.parseInt(table_ncc.getValueAt(vitriRow, 0).toString());
        String tenNCC = table_ncc.getValueAt(vitriRow, 1).toString();
        String address = table_ncc.getValueAt(vitriRow, 2).toString();
        String sdt = table_ncc.getValueAt(vitriRow, 3).toString();
        String email = table_ncc.getValueAt(vitriRow, 4).toString();
        NhaCungCapDTO ncc=new NhaCungCapDTO(maNCC, tenNCC, address, sdt, email);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditNhaCungCapDialog((Frame) parentWindow, true,ncc,this).setVisible(true);
    }//GEN-LAST:event_jlabel_update_nccMouseClicked

    private void jlabel_add_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_nccMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddNhaCungCapDialog((Frame) parentWindow, true,this).setVisible(true);
    }//GEN-LAST:event_jlabel_add_nccMouseClicked

    private void jlabel_delete_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_nccMouseClicked
        int vitriRow = table_ncc.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp để xóa", "Error", 0);
            return;
        }
        int maNCC =Integer.parseInt(table_ncc.getValueAt(vitriRow, 0).toString());
        int confirm=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa không","Xác nhận xóa",
            JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            nccBus.deleteNhaCungCap(maNCC);
        }
        func.addDataTableNCC(nccBus.listNCC(),table_ncc);
        func.centerTable(table_ncc);
    }//GEN-LAST:event_jlabel_delete_nccMouseClicked

    private void jlabel_chiTiet_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTiet_nccMouseClicked
        int vitriRow=table_ncc.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhà cung cấp","Error",0);
            return;
        }
        String tenNCC=table_ncc.getValueAt(vitriRow,1).toString();
        String address=table_ncc.getValueAt(vitriRow,2).toString();
        String sdt=table_ncc.getValueAt(vitriRow,3).toString();
        String email=table_ncc.getValueAt(vitriRow,4).toString();
        NhaCungCapDTO ncc=new NhaCungCapDTO(tenNCC, address, sdt, email);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsNhaCungCapDialog((Frame) parentWindow, true,ncc).setVisible(true);
    }//GEN-LAST:event_jlabel_chiTiet_nccMouseClicked

    private void jlabel_xuat_excel_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_xuat_excel_nccMouseClicked
        try {
            Func_class.exportJTableToExcel(table_ncc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jlabel_xuat_excel_nccMouseClicked

    private void jlabel_look_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_nccMouseClicked
        String type=combobox_find_ncc.getSelectedItem().toString();
        String find_text=jtf_find_ncc.getText().toLowerCase();
        func.addDataTableNCC(nccBus.timKiem(find_text,type), table_ncc);
        func.centerTable(table_ncc);
    }//GEN-LAST:event_jlabel_look_nccMouseClicked

    private void jlabel_refresh_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_refresh_nccMouseClicked
        jtf_find_ncc.setText("");
        func.addDataTableNCC(nccBus.listNCC(), table_ncc);
        func.centerTable(table_ncc);
    }//GEN-LAST:event_jlabel_refresh_nccMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobox_find_ncc;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel_add_ncc;
    private javax.swing.JLabel jlabel_chiTiet_ncc;
    private javax.swing.JLabel jlabel_delete_ncc;
    private javax.swing.JLabel jlabel_look_ncc;
    private javax.swing.JLabel jlabel_refresh_ncc;
    private javax.swing.JLabel jlabel_update_ncc;
    private javax.swing.JLabel jlabel_xuat_excel_ncc;
    private javax.swing.JPanel jpanel_chucNang_ncc;
    private javax.swing.JPanel jpanel_filter_ncc;
    private javax.swing.JPanel jpanel_timkiem_ncc;
    private javax.swing.JTextField jtf_find_ncc;
    private javax.swing.JTable table_ncc;
    // End of variables declaration//GEN-END:variables
}
