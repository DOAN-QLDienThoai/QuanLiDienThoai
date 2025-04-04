/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import Data.Func_class;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiman
 */
public class EditNhaCungCapJFrame extends javax.swing.JFrame {
    private MainJFrame mainJFrame;
    int id;
    Func_class func=new Func_class();
    public EditNhaCungCapJFrame(int id,String name,String address,String sdt,String email,MainJFrame mainJFrame) {
        initComponents();
        this.mainJFrame=mainJFrame;
        this.id=id;
        this.jtf_name_ncc.setText(name);
        this.jtf_address_ncc.setText(address);
        this.jtf_sdt_ncc.setText(sdt);
        this.jtf_email_ncc.setText(email);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlabel_title_edit_ncc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtf_name_ncc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtf_sdt_ncc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_address_ncc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_email_ncc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_edit_ncc = new javax.swing.JButton();
        btn_close_ncc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jlabel_title_edit_ncc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlabel_title_edit_ncc.setText("Sửa Nhà Cung Cấp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jlabel_title_edit_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel_title_edit_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel1.setText("Tên nhà cung cấp");

        jLabel2.setText("Số điện thoại");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Email");

        btn_edit_ncc.setText("Cập nhật");
        btn_edit_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit_nccMouseClicked(evt);
            }
        });

        btn_close_ncc.setText("Hủy bỏ");
        btn_close_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_close_nccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_edit_ncc)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_address_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(jtf_name_ncc)
                            .addComponent(jLabel1))
                        .addComponent(jLabel3)))
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jtf_sdt_ncc)
                        .addComponent(jtf_email_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .addComponent(btn_close_ncc))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_sdt_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jtf_name_ncc))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_email_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_address_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_edit_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btn_close_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_close_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_close_nccMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_close_nccMouseClicked

    private void btn_edit_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_nccMouseClicked
        if(this.jtf_name_ncc.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập tên nhà cung cấp");
            return;
        }
        else if(this.jtf_address_ncc.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập địa chỉ nhà cung cấp");
            return;
        }
        else if(this.jtf_sdt_ncc.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại nhà cung cấp");
            return;
        }
        else if(this.jtf_email_ncc.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập email nhà cung cấp");
            return;
        }
        NhaCungCapDTO ncc=new NhaCungCapDTO();
        ncc.setID(this.id);
        ncc.setName(this.jtf_name_ncc.getText());
        ncc.setAddress(this.jtf_address_ncc.getText());
        String sdt=jtf_sdt_ncc.getText();
        if(sdt.length()!=10&&sdt.charAt(0)!='0'){
            JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ","Erorr",0);
            return;
        }
        else
            ncc.setSDT(sdt);
        ncc.setEmail(this.jtf_email_ncc.getText());
        NhaCungCapDAO nccDAO=new NhaCungCapDAO();
        try {
            nccDAO.updateNhaCungCap(ncc);
            this.mainJFrame.addDataTableNhaCungCap();
            func.centerTable(mainJFrame.getTableNhaCungCap());
        } catch (SQLException ex) {
            Logger.getLogger(EditNhaCungCapJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_edit_nccMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditNhaCungCapJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditNhaCungCapJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditNhaCungCapJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditNhaCungCapJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditNhaCungCapJFrame(0,"","","","",new MainJFrame()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close_ncc;
    private javax.swing.JButton btn_edit_ncc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlabel_title_edit_ncc;
    private javax.swing.JTextField jtf_address_ncc;
    private javax.swing.JTextField jtf_email_ncc;
    private javax.swing.JTextField jtf_name_ncc;
    private javax.swing.JTextField jtf_sdt_ncc;
    // End of variables declaration//GEN-END:variables
}
