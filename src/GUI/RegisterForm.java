/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import util.ConnectedDatabase;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
public class RegisterForm extends javax.swing.JFrame {
    public RegisterForm() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlabel_userRegister = new javax.swing.JLabel();
        jlabel_pwRegister = new javax.swing.JLabel();
        jlabel_rePwRegister = new javax.swing.JLabel();
        jlabel_phone = new javax.swing.JLabel();
        jTextField_UN = new javax.swing.JTextField();
        jTextField_PW = new javax.swing.JTextField();
        jTextField_RPW = new javax.swing.JTextField();
        jTextField_PHONE = new javax.swing.JTextField();
        btn_canCelRegister = new javax.swing.JButton();
        btn_create = new javax.swing.JButton();
        jlabelRegister = new javax.swing.JLabel();
        jlabek_register = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jlabel_userRegister.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_userRegister.setText("Username:");

        jlabel_pwRegister.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_pwRegister.setText("Password:");

        jlabel_rePwRegister.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_rePwRegister.setText("Retype Pass :");

        jlabel_phone.setForeground(new java.awt.Color(255, 255, 255));
        jlabel_phone.setText("Phone:");

        btn_canCelRegister.setText("Cancel");
        btn_canCelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_canCelRegisterMouseClicked(evt);
            }
        });

        btn_create.setText("Create");
        btn_create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_createMouseClicked(evt);
            }
        });

        jlabelRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlabelRegister.setForeground(new java.awt.Color(255, 255, 255));
        jlabelRegister.setText("click here to login");
        jlabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabelRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_PW, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlabel_phone)
                                            .addComponent(jlabel_rePwRegister)
                                            .addComponent(jlabel_pwRegister))
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jlabel_userRegister)
                                        .addGap(40, 40, 40)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_UN, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_RPW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_PHONE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_canCelRegister)
                                .addGap(49, 49, 49)
                                .addComponent(btn_create)
                                .addGap(37, 37, 37))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jlabelRegister)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_userRegister)
                    .addComponent(jTextField_UN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_pwRegister)
                    .addComponent(jTextField_PW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_rePwRegister)
                    .addComponent(jTextField_RPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel_phone)
                    .addComponent(jTextField_PHONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_canCelRegister)
                    .addComponent(btn_create))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabelRegister)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlabek_register.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlabek_register.setText("Register Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jlabek_register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlabek_register)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelRegisterMouseClicked
        LoginForm login_form=new LoginForm();
        login_form.setVisible(true);
        login_form.pack();
        login_form.setLocationRelativeTo(null);
        login_form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jlabelRegisterMouseClicked

    private void btn_canCelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_canCelRegisterMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_canCelRegisterMouseClicked

    public boolean checkUser(String userName){
        boolean check=false;
        PreparedStatement st;
        ResultSet rs;
        String sql="SELECT * FROM TaiKhoan "+
                   "WHERE userName=?";
        try {
            st=ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            st.setString(1,userName);
            rs=st.executeQuery();
            if(rs.next()){
                check=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    private void btn_createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_createMouseClicked
        String userName=this.jTextField_UN.getText();   
        String password=this.jTextField_PW.getText();
        String retypePassword=this.jTextField_RPW.getText();
        String phone=this.jTextField_PHONE.getText();
        if(userName.equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập tên tài khoản");
            return;
        }
        if(checkUser(userName)){
            JOptionPane.showMessageDialog(null,"Tên tài khoản đã tồn tại");
            return;
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập mật khẩu");
            return;
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập lại mật khẩu");
            return;
        }
        if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập số điện thoại");
            return;
        }
        String sql= "INSERT INTO TaiKhoan (userName,passW,retypePassW,phone) " +
                         "VALUES (?,?,?,?)";
        PreparedStatement st;
        try {
            st = ConnectedDatabase.getConnectedDB().prepareStatement(sql);
            st.setString(1,userName);
            st.setString(2,password);
            st.setString(3,retypePassword);
            st.setString(4,phone);
            if(st.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Đăng ký thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_createMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_canCelRegister;
    private javax.swing.JButton btn_create;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_PHONE;
    private javax.swing.JTextField jTextField_PW;
    private javax.swing.JTextField jTextField_RPW;
    private javax.swing.JTextField jTextField_UN;
    private javax.swing.JLabel jlabek_register;
    private javax.swing.JLabel jlabelRegister;
    private javax.swing.JLabel jlabel_phone;
    private javax.swing.JLabel jlabel_pwRegister;
    private javax.swing.JLabel jlabel_rePwRegister;
    private javax.swing.JLabel jlabel_userRegister;
    // End of variables declaration//GEN-END:variables
}
