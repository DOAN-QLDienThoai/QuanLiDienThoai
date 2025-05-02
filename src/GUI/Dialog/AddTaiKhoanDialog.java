/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import GUI.Panel.PanelTaiKhoan;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.DropShadowBorder;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class AddTaiKhoanDialog extends javax.swing.JDialog {
    Func_class func=new Func_class();
    NhanVienBUS nvBus=new NhanVienBUS();
    PanelTaiKhoan tkPanel;
    TaiKhoanBUS userBus=new TaiKhoanBUS();
    public AddTaiKhoanDialog(java.awt.Frame parent, boolean modal,PanelTaiKhoan tkPanel) {
        super(parent, modal);
        initComponents();
        this.tkPanel=tkPanel;
        this.setLocationRelativeTo(null);
        this.setTitle("Cung cấp tài khoản cho nhân viên");
        khoiTao();
    }
    public void khoiTao(){
        setUpTable();
        setUpBtn();
        setTextHidden();
        setIcon();
        setBorderJPanel();
        setUpComBoBOx();
        fillComBoBox(); 
    }
    public void setUpTable(){
        func.addDataTableNV(nvBus.listNV(), table_NV);
        func.centerTable(table_NV);
        func.setUpTable(table_NV);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_search);
        PromptSupport.setForeground(Color.GRAY, jtf_search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_search);
    }
    public void setIcon(){
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.25f));
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/look.svg",0.55f));
        btn_capTaiKhoan.setIcon(new FlatSVGIcon("./resources/icon/add_1.svg",0.2f));
    }
    public void setBorderJPanel(){
        jPanel1.setBorder(new DropShadowBorder(1, Color.black));
    }
    public void setUpBtn(){
        func.setUpBtn(btn_refresh, Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_look, Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_capTaiKhoan, Color.WHITE, Color.CYAN);
    }
    public void setUpComBoBOx(){
        func.setUpComBoBox(cbb_item);
    }
    public void fillComBoBox(){
        String[] items={"Tất cả","Mã NV","Tên nhân viên","Số điện thoại","Giới tính","Ngày sinh"};
        for(String item : items){
            cbb_item.addItem(item);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_NV = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtf_search = new javax.swing.JTextField();
        btn_look = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        cbb_item = new javax.swing.JComboBox<>();
        btn_capTaiKhoan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table_NV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_NV);

        btn_look.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lookMouseClicked(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(cbb_item, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_search)
                    .addComponent(btn_look, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(cbb_item))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btn_capTaiKhoan.setText("Cấp tài khoản");
        btn_capTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capTaiKhoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_capTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_capTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capTaiKhoanActionPerformed
        int vitriRow = table_NV.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên", "Error", 0);
            return;
        }
        int maNV = Integer.parseInt(table_NV.getValueAt(vitriRow, 0).toString());
        for (TaiKhoanDTO u : userBus.listTaiKhoan()) {
            if (u.getMaNV() == maNV) {
                JOptionPane.showMessageDialog(null, "Nhân viên đã có tài khoản", "Error", 0);
                return;
            }
        }
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new CreateTKDialog((Frame) parentWindow, true,maNV,tkPanel).setVisible(true);
    }//GEN-LAST:event_btn_capTaiKhoanActionPerformed

    private void btn_lookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lookMouseClicked
        String choose_combobox=cbb_item.getSelectedItem().toString();
        String text = jtf_search.getText();
        func.addDataTableNV(nvBus.timKiem(text,choose_combobox), table_NV);
        func.centerTable(table_NV);
    }//GEN-LAST:event_btn_lookMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        jtf_search.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capTaiKhoan;
    private javax.swing.JButton btn_look;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<String> cbb_item;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtf_search;
    private javax.swing.JTable table_NV;
    // End of variables declaration//GEN-END:variables
}
