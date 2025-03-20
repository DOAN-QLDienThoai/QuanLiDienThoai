/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Data.ConnectedDatabase;
import com.microsoft.sqlserver.jdbc.SQLServerStatementColumnEncryptionSetting;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import java.sql.ResultSet;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author kiman
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        this.setTitle("Login Form");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlabel_loginForm = new javax.swing.JLabel();
        btn_exitLogin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlabel_username = new javax.swing.JLabel();
        jtextField_UNlogin = new javax.swing.JTextField();
        jlabel_password = new javax.swing.JLabel();
        jTextField_PWlogin = new javax.swing.JTextField();
        btn_cancel = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        jlabel_createAccount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jlabel_loginForm.setBackground(new java.awt.Color(255, 255, 255));
        jlabel_loginForm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlabel_loginForm.setText("Login Form");

        btn_exitLogin.setText("X");
        btn_exitLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitLoginMouseClicked(evt);
            }
        });
        btn_exitLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jlabel_loginForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exitLogin)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jlabel_loginForm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_exitLogin)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jlabel_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlabel_username.setText("Username :");

        jlabel_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlabel_password.setText("Password :");

        btn_cancel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
        });

        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jlabel_createAccount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlabel_createAccount.setText("click here to create new account ");
        jlabel_createAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_createAccountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(btn_cancel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                            .addComponent(btn_login))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlabel_username)
                                .addComponent(jlabel_password))
                            .addGap(23, 23, 23)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtextField_UNlogin)
                                .addComponent(jTextField_PWlogin, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jlabel_createAccount)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_username)
                    .addComponent(jtextField_UNlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_password)
                    .addComponent(jTextField_PWlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_login)
                    .addComponent(btn_cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jlabel_createAccount)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitLoginActionPerformed

    }//GEN-LAST:event_btn_exitLoginActionPerformed

    private void btn_exitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitLoginMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_exitLoginMouseClicked

    private void jlabel_createAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_createAccountMouseClicked
        RegisterForm rgt = new RegisterForm();
        rgt.setTitle("Register Form");
        rgt.setVisible(true);
        rgt.pack();
        rgt.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jlabel_createAccountMouseClicked

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String userName=this.jtextField_UNlogin.getText();
        String passWord=this.jTextField_PWlogin.getText();
        String sql="SELECT * FROM TaiKhoan "+
                   "WHERE userName=? and passW=?";
        PreparedStatement st;
        ResultSet rs;
        try {
            st=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            st.setString(1,userName);
            st.setString(2,passWord);
            rs = (ResultSet) st.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Đăng nhập thành công");
                DashboardForm dbForm=new DashboardForm();
                dbForm.setVisible(true);
                dbForm.pack();
                dbForm.setLocationRelativeTo(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_exitLogin;
    private javax.swing.JButton btn_login;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_PWlogin;
    private javax.swing.JLabel jlabel_createAccount;
    private javax.swing.JLabel jlabel_loginForm;
    private javax.swing.JLabel jlabel_password;
    private javax.swing.JLabel jlabel_username;
    private javax.swing.JTextField jtextField_UNlogin;
    // End of variables declaration//GEN-END:variables
}
