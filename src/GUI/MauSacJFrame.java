/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.MauSacDAO;
import DAO.RamDAO;
import DTO.MauSacDTO;
import DTO.RamDTO;
import Data.Func_class;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kiman
 */
public class MauSacJFrame extends javax.swing.JFrame {

    Func_class func = new Func_class();

    public MauSacJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        addDataTable();
        setUpTable();
        setIconClose();
    }

    public void addDataTable() {
        ArrayList<MauSacDTO> listMS = new MauSacDAO().listMS();
        String[] colNames = {"Mã Màu", "Tên màu"};
        Object[][] rows = new Object[listMS.size()][colNames.length];
        for (int i = 0; i < listMS.size(); i++) {
            rows[i][0] = listMS.get(i).getMaMau();
            rows[i][1] = listMS.get(i).getTenMau();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_mausac.setModel(model);
    }

    public void setUpTable() {
        func.setUpTable(table_mausac);
        func.centerTable(table_mausac);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlabel_close = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtf_tenmau = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_mausac = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Màu Sắc");

        jlabel_close.setText("                  ");
        jlabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139)
                .addComponent(jlabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Tên màu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_tenmau, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_tenmau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );

        table_mausac.setModel(new javax.swing.table.DefaultTableModel(
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
        table_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_mausacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_mausac);

        jPanel3.setBackground(new java.awt.Color(211, 218, 211));

        btn_add.setBackground(new java.awt.Color(102, 255, 102));
        btn_add.setText("THÊM");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(51, 153, 255));
        btn_update.setText("SỬA");
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 51, 51));
        btn_delete.setText("XÓA");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        if (jtf_tenmau.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên màu", "Error", 0);
            return;
        }
        String tenMau = jtf_tenmau.getText();
        MauSacDTO mau= new MauSacDTO(0, tenMau);
        new MauSacDAO().insertMauSac(mau);
        addDataTable();
        func.centerTable(table_mausac);
        jtf_tenmau.setText("");
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        int vitriRow = table_mausac.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn màu để cập nhật dung lượng", "Error", 0);
            return;
        }
        int maMau = (int) table_mausac.getValueAt(vitriRow, 0);
        String tenMau = jtf_tenmau.getText();
        new MauSacDAO().updateMS(new MauSacDTO(maMau, tenMau));
        addDataTable();
        func.centerTable(table_mausac);
        jtf_tenmau.setText("");
    }//GEN-LAST:event_btn_updateMouseClicked

    private void table_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_mausacMouseClicked
        int vitriRow = table_mausac.getSelectedRow();
        String tenMau = table_mausac.getValueAt(vitriRow, 1).toString();
        jtf_tenmau.setText(tenMau);
    }//GEN-LAST:event_table_mausacMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        int vitriRow = table_mausac.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn màu để xóa ", "Error", 0);
            return;
        }
        int maMau =(int) table_mausac.getValueAt(vitriRow, 0);
        int confirm = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa màu này không?", 
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            new MauSacDAO().deleteMS(maMau);
            addDataTable();
            func.centerTable(table_mausac);
        }
    }//GEN-LAST:event_btn_deleteMouseClicked
    public void setIconClose(){
        jlabel_close.setIcon(new FlatSVGIcon("./resources/icon/close.svg",0.4f));
        jlabel_close.setCursor(new Cursor(Cursor.HAND_CURSOR) {});
    }
    private void jlabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_jlabel_closeMouseClicked

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
            java.util.logging.Logger.getLogger(MauSacJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MauSacJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MauSacJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MauSacJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MauSacJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_close;
    private javax.swing.JTextField jtf_tenmau;
    private javax.swing.JTable table_mausac;
    // End of variables declaration//GEN-END:variables
}
