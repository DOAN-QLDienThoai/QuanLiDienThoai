/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import Data.Func_class;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author kiman
 */
public class EditNhanVienJFrame extends javax.swing.JFrame {
    private MainJFrame mainJFrame;
    String maNV;
    Func_class func=new Func_class();
    public EditNhanVienJFrame(String maNV,String hoTen,Date ngaySinh,String gioiTinh,String sdt,MainJFrame mainJFrame){
        initComponents();
        this.maNV=maNV;
        jtf_name_nv.setText(hoTen);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y");
        jtf_date_nv.setText(sdf.format(ngaySinh));
        jtf_gioitinh_nv.setText(gioiTinh);
        jtf_sdt_nv.setText(sdt);
        this.mainJFrame=mainJFrame;
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_name_nv = new javax.swing.JTextField();
        jtf_date_nv = new javax.swing.JTextField();
        jtf_gioitinh_nv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_sdt_nv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_update_nv = new javax.swing.JButton();
        btn_exit_nv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Chỉnh Sửa Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel1)
                .addContainerGap(344, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ tên ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        btn_update_nv.setText("Cập nhật");
        btn_update_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_update_nvMouseClicked(evt);
            }
        });

        btn_exit_nv.setText("Hủy bỏ");
        btn_exit_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exit_nvMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jtf_name_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(jtf_date_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(370, 370, 370)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jtf_sdt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(jtf_gioitinh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(btn_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btn_exit_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_name_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_date_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_sdt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_gioitinh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_update_nv)
                    .addComponent(btn_exit_nv))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exit_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exit_nvMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exit_nvMouseClicked

    private void btn_update_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_nvMouseClicked
        if (jtf_name_nv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên", "erorr", 0);
            return;
        } else if (jtf_date_nv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày sinh", "erorr", 0);
            return;
        } else if (jtf_gioitinh_nv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giới tính", "erorr", 0);
            return;
        } else if (jtf_sdt_nv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại", "erorr", 0);
            return;
        }
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNV(this.maNV);
        nv.setHoTen(jtf_name_nv.getText());
        try {
            SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
            spd.setLenient(false);//Cho phép nhận biết ngày có nhạp sai định dạng hoặc trong lịch ko có ngày đó hay ko
            Date ngaySinh = spd.parse(jtf_date_nv.getText());
            java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
            nv.setNgaySinh(sqlDate);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng (dd/MM/yyyy)", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nv.setGioiTinh(jtf_gioitinh_nv.getText());
        String sdt = jtf_sdt_nv.getText();
        if (sdt.length() != 10 || sdt.charAt(0) != '0') {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ", "Erorr", 0);
            return;
        } else {
            nv.setSDT(sdt);
        }
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.updateNhanVien(nv);
        mainJFrame.addDataTableNhanVien();
        func.centerTable(mainJFrame.getTableNhanVien());
    }//GEN-LAST:event_btn_update_nvMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EditNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditNhanVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditNhanVienJFrame("","",new Date(),"","",new MainJFrame()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit_nv;
    private javax.swing.JButton btn_update_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtf_date_nv;
    private javax.swing.JTextField jtf_gioitinh_nv;
    private javax.swing.JTextField jtf_name_nv;
    private javax.swing.JTextField jtf_sdt_nv;
    // End of variables declaration//GEN-END:variables
}
