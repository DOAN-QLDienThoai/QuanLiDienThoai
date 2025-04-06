/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import util.Func_class;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author kiman
 */
public class EditNhanVienJFrame extends javax.swing.JFrame {
    private MainJFrame mainJFrame;
    private NhanVienDTO nv;
    private Func_class func=new Func_class();
    public EditNhanVienJFrame(NhanVienDTO nv,MainJFrame mainJFrame){
        initComponents();
        this.mainJFrame=mainJFrame;
        this.nv=nv;
        khoiTaoButtonGroupGioiTinh();
        jtf_name_nv.setText(nv.getHoTen());
        jdatechooser_ngaySinh.setDate(nv.getNgaySinh());
        if(nv.getGioiTinh().equals(jradio_nam.getText()))
            jradio_nam.setSelected(true);
        else
            jradio_nu.setSelected(true);
        jtf_sdt_nv.setText(nv.getSDT());
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_name_nv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_sdt_nv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_update_nv = new javax.swing.JButton();
        btn_exit_nv = new javax.swing.JButton();
        jradio_nam = new javax.swing.JRadioButton();
        jradio_nu = new javax.swing.JRadioButton();
        jdatechooser_ngaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Chỉnh Sửa Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addContainerGap(80, Short.MAX_VALUE))
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

        btn_update_nv.setBackground(new java.awt.Color(153, 255, 102));
        btn_update_nv.setText("Cập nhật");
        btn_update_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_update_nvMouseClicked(evt);
            }
        });

        btn_exit_nv.setBackground(new java.awt.Color(255, 0, 0));
        btn_exit_nv.setText("Hủy bỏ");
        btn_exit_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exit_nvMouseClicked(evt);
            }
        });

        jradio_nam.setText("Nam");

        jradio_nu.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtf_name_nv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                        .addComponent(jtf_sdt_nv, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jradio_nam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addComponent(jradio_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_exit_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jdatechooser_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_name_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_sdt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jradio_nam)
                    .addComponent(jradio_nu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdatechooser_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void khoiTaoButtonGroupGioiTinh(){
        ButtonGroup grpButton=new ButtonGroup();
        grpButton.add(jradio_nam);
        grpButton.add(jradio_nu);
    }
    private void btn_exit_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exit_nvMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_exit_nvMouseClicked
    public int check_edit_NhanVien(){
        if (jtf_name_nv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên", "erorr", 0);
            return 0;
        } else if (jdatechooser_ngaySinh==null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh", "erorr", 0);
            return 0;
        } else if (!jradio_nam.isSelected()&&!jradio_nu.isSelected()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính", "erorr", 0);
            return 0;
        } else if (jtf_sdt_nv.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại", "erorr", 0);
            return 0;
        }
        return 1;
    }
    private void btn_update_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_nvMouseClicked
        if (check_edit_NhanVien() == 1) {
            int maNV=nv.getMaNV();
            String hoTen=jtf_name_nv.getText();
            String sdt=jtf_sdt_nv.getText();
            if(sdt.charAt(0)!='0'||sdt.length()!=10){
                JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ","Error",0);
                return;
            }
            String gioiTinh=null;
            if(jradio_nam.isSelected())
                gioiTinh=jradio_nam.getText();
            else
                gioiTinh=jradio_nu.getText();
            Date ngaySinh=jdatechooser_ngaySinh.getDate();
            java.sql.Date ngaySinhSQL=new java.sql.Date(ngaySinh.getTime());
            nv=new NhanVienDTO(maNV,hoTen, ngaySinhSQL, gioiTinh, sdt);
            new NhanVienDAO().updateNhanVien(nv);
            ArrayList<NhanVienDTO> listNV=new NhanVienDAO().listNV();
            func.addDataTableNV(listNV,mainJFrame.getTableNhanVien());
            func.centerTable(mainJFrame.getTableNhanVien());
            this.dispose();
        }
    }//GEN-LAST:event_btn_update_nvMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit_nv;
    private javax.swing.JButton btn_update_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdatechooser_ngaySinh;
    private javax.swing.JRadioButton jradio_nam;
    private javax.swing.JRadioButton jradio_nu;
    private javax.swing.JTextField jtf_name_nv;
    private javax.swing.JTextField jtf_sdt_nv;
    // End of variables declaration//GEN-END:variables
}
