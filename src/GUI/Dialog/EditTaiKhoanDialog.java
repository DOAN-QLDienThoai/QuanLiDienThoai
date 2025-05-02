/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import GUI.Panel.PanelTaiKhoan;
import java.awt.Color;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class EditTaiKhoanDialog extends javax.swing.JDialog {
    Func_class func=new Func_class();
    PanelTaiKhoan tkPanel;
    TaiKhoanBUS userBus=new TaiKhoanBUS();
    TaiKhoanDTO user;
    public EditTaiKhoanDialog(java.awt.Frame parent, boolean modal,PanelTaiKhoan tkPanel,TaiKhoanDTO user) {
        super(parent, modal);
        initComponents();
        this.tkPanel=tkPanel;
        this.user=user;
        khoiTao();
        this.setTitle("Cập nhật tài khoản");
        this.setLocationRelativeTo(null);
    }
    public void fillAll() {
        jtf_taiKhoan.setEnabled(false);
        jtf_taiKhoan.setText(user.getTenDangNhap());
        jtf_matKhau.setText(user.getMatKhau());
        if(user.getTrangThai().equals("1")){
            jCheckBox1.setSelected(true);
        }
    }
    public void khoiTao(){
        fillAll();
        setUpBtn();
        setUpJTF();
    }
    public void setUpBtn(){
        func.setUpBtnTwo(btn_save, Color.BLUE, Color.BLUE, Color.WHITE,14);
        func.setUpBtnTwo(btn_huy, Color.RED, Color.RED, Color.WHITE,14);
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_taiKhoan);
        func.setUpJTF(jtf_matKhau);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtf_taiKhoan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtf_matKhau = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        btn_save = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tài khoản");

        jLabel2.setText("Mật khẩu");

        jCheckBox1.setText("Hoạt động");

        btn_save.setText("Lưu");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtf_taiKhoan)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtf_matKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_taiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        int maNV=user.getMaNV();
        String tk = jtf_taiKhoan.getText();
        String mk = new String(jtf_matKhau.getPassword());
        String trangThai = "1";
        if(!jCheckBox1.isSelected()){
            trangThai="0";
        }
        user=new TaiKhoanDTO(maNV,tk,mk,trangThai);
        userBus.updateTaiKhoan(user);
        tkPanel.setUpTable();
        this.dispose();
    }//GEN-LAST:event_btn_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_save;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jtf_matKhau;
    private javax.swing.JTextField jtf_taiKhoan;
    // End of variables declaration//GEN-END:variables
}
