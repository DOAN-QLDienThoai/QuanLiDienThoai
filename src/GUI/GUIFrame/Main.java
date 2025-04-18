/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.GUIFrame;

import GUI.Panel.PanelDienThoai;
import GUI.Panel.PanelKhachHang;
import GUI.Panel.PanelNhanVien;
import GUI.Panel.PanelNhaCungCap;
import GUI.Panel.PanelNhapPhieuNhap;
import GUI.Panel.PanelNhapPhieuXuat;
import GUI.Panel.PanelPhieuNhap;
import GUI.Panel.PanelPhieuXuat;
import GUI.Panel.PanelThongKe;
import GUI.Panel.PanelThuocTinh;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;



/**
 *
 * @author kiman
 */
public class Main extends javax.swing.JFrame {
    private String maNhanVien;
    PanelNhanVien nv=new PanelNhanVien();
    PanelNhaCungCap ncc=new PanelNhaCungCap();
    PanelDienThoai dt=new PanelDienThoai();
    PanelThuocTinh thuoctinh=new PanelThuocTinh();
    PanelKhachHang khachhang=new PanelKhachHang();
    PanelThongKe tk=new PanelThongKe();
    PanelPhieuNhap pn=new PanelPhieuNhap(this);
    PanelNhapPhieuNhap nhapphieunhap=new PanelNhapPhieuNhap(this);
    PanelPhieuXuat phieuxuat=new PanelPhieuXuat(this);
    PanelNhapPhieuXuat nhapphieuxuat=new PanelNhapPhieuXuat(this);
    JButton[] btns = new JButton[8];
    JButton currentActiveBtn = null;
    Border etchedBorder = BorderFactory.createEtchedBorder();
    public Main() {
        initComponents();
        khoiTao();
        main.add(dt);
        main.add(thuoctinh);
        main.add(nv);
        main.add(ncc);
        main.add(khachhang);
        main.add(phieuxuat);
        main.add(nhapphieuxuat);
        main.add(tk);
        main.add(pn);
        main.add(nhapphieunhap);
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }
    public void khoiTao(){
        actionJButtonMenu();
        khoitaoButtonInMenu();
        styleAllButtonMenu();
        setIconForJButton();
    }
    public void khoitaoButtonInMenu() {
        btns[0] = btn_nv;
        btns[1] = btn_thuoctinh;
        btns[2] = btn_dt;
        btns[3] = btn_ncc;
        btns[4] = btn_kh;
        btns[5] = btn_px;
        btns[6]=btn_pn;
        btns[7]=btn_tk;
    }
    public void setIconForJButton(){
        btn_dt.setIcon(new FlatSVGIcon("./resources/icon/phone.svg", 0.55f));
        btn_ncc.setIcon(new FlatSVGIcon("./resources/icon/ncc.svg", 0.55f));
        btn_thuoctinh.setIcon(new FlatSVGIcon("./resources/icon/thuoctinh.svg", 0.6f));
        btn_nv.setIcon(new FlatSVGIcon("./resources/icon/nhanvien.svg", 0.5f));
        btn_kh.setIcon(new FlatSVGIcon("./resources/icon/khachhang.svg", 0.035f));
        btn_px.setIcon(new FlatSVGIcon("./resources/icon/phieuxuat.svg", 0.035f));
    }
    public PanelNhapPhieuNhap getPanelNhapPN(){
        return this.nhapphieunhap;
    }
    public PanelPhieuNhap getPanelPhieuNhap(){
        return this.pn;
    }
    public PanelNhapPhieuXuat getPanelNhapPX(){
        return this.nhapphieuxuat;
    }
    public PanelPhieuXuat getPanelPhieuXuat(){
        return this.phieuxuat;
    }
    public PanelNhaCungCap getPanelNhaCungCap(){
        return this.ncc;
    }
    public PanelNhanVien getPanelNhanVien(){
        return this.nv;
    }
    public PanelDienThoai getPanelDT(){
        return this.dt;
    }
    public void setMaNhanVien(String maNV) {
    this.maNhanVien = maNV;
    }
    public String getMaNhanVien() {
        return this.maNhanVien;
    }
    public void setBackgroundJButton(JButton btn) {
        for (JButton menuitem : btns) {
            menuitem.setBackground(new Color(211, 218, 211));
            menuitem.setForeground(Color.BLACK);
        }
        btn.setBackground(new Color(173, 216, 230));
        btn.setForeground(Color.BLACK);
        currentActiveBtn = btn;
    }
    public void styleButtonMenu(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        btn.setBackground(Color.WHITE);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(10);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(new java.awt.Color(230, 240, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (btn == currentActiveBtn) {
                    return;
                }
                btn.setBackground(new Color(211, 218, 211)); 
            }
        });
        
    }
    public void setBtnMenu() {
        for (JButton btn : btns) {
            btn.setFocusPainted(false);
            btn.setBorder(null);
            btn.setBackground(new Color(211, 218, 211));
        }
        jpanel_menu_bottom.setBorder(etchedBorder);
    }
    public void styleAllButtonMenu() {
        for (JButton btn : btns) {
            styleButtonMenu(btn);
        }
        styleButtonMenu(btn_kh);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_menu_bottom = new javax.swing.JPanel();
        btn_thuoctinh = new javax.swing.JButton();
        btn_nv = new javax.swing.JButton();
        btn_ncc = new javax.swing.JButton();
        btn_dt = new javax.swing.JButton();
        btn_kh = new javax.swing.JButton();
        btn_px = new javax.swing.JButton();
        btn_tc = new javax.swing.JButton();
        btn_pn = new javax.swing.JButton();
        btn_tk = new javax.swing.JButton();
        jpanel_menu_top1 = new javax.swing.JPanel();
        img_store1 = new javax.swing.JLabel();
        main = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanel_menu_bottom.setBackground(new java.awt.Color(255, 255, 255));

        btn_thuoctinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_thuoctinh.setText("Thuộc Tính");
        btn_thuoctinh.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_thuoctinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thuoctinhActionPerformed(evt);
            }
        });

        btn_nv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_nv.setText("Nhân Viên");
        btn_nv.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_nv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nvActionPerformed(evt);
            }
        });

        btn_ncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_ncc.setText("Nhà Cung Cấp");
        btn_ncc.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_ncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nccActionPerformed(evt);
            }
        });

        btn_dt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_dt.setText("Điện Thoại");
        btn_dt.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dtActionPerformed(evt);
            }
        });

        btn_kh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_kh.setText("Khách Hàng");
        btn_kh.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khActionPerformed(evt);
            }
        });

        btn_px.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_px.setText("Phiếu Xuất");
        btn_px.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_px.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pxActionPerformed(evt);
            }
        });

        btn_tc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_tc.setText("Trang chủ");
        btn_tc.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_tc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tcActionPerformed(evt);
            }
        });

        btn_pn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_pn.setText("Phiếu Nhập");
        btn_pn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pnActionPerformed(evt);
            }
        });

        btn_tk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_tk.setText("Thống Kê");
        btn_tk.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_tk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tkActionPerformed(evt);
            }
        });

        jpanel_menu_top1.setBackground(new java.awt.Color(255, 255, 255));

        img_store1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpanel_menu_top1Layout = new javax.swing.GroupLayout(jpanel_menu_top1);
        jpanel_menu_top1.setLayout(jpanel_menu_top1Layout);
        jpanel_menu_top1Layout.setHorizontalGroup(
            jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
            .addGroup(jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_menu_top1Layout.createSequentialGroup()
                    .addComponent(img_store1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 108, Short.MAX_VALUE)))
        );
        jpanel_menu_top1Layout.setVerticalGroup(
            jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
            .addGroup(jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(img_store1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanel_menu_bottomLayout = new javax.swing.GroupLayout(jpanel_menu_bottom);
        jpanel_menu_bottom.setLayout(jpanel_menu_bottomLayout);
        jpanel_menu_bottomLayout.setHorizontalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanel_menu_top1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_px, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanel_menu_bottomLayout.setVerticalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addComponent(jpanel_menu_top1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_px, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main.setPreferredSize(new java.awt.Dimension(1030, 630));
        main.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thuoctinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thuoctinhActionPerformed
        dt.setVisible(false);
        thuoctinh.setVisible(true);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_thuoctinhActionPerformed
    public void actionJButtonMenu() {
        Component[] cpns = jpanel_menu_bottom.getComponents();
        for (Component cpn : cpns) {
            if (cpn instanceof JButton) {
                JButton button = (JButton) cpn;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setBackgroundJButton(button);
                    }
                });
            }
        }
    }
    private void btn_nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nvActionPerformed
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(true);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_nvActionPerformed

    private void btn_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pxActionPerformed
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(true);
        nhapphieuxuat.loadTableSanPham(); // ✅ Gọi lại để load dữ liệu mới
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_pxActionPerformed

    private void btn_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dtActionPerformed
        dt.setVisible(true);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        nhapphieunhap.setVisible(false);
        pn.setVisible(false);
    }//GEN-LAST:event_btn_dtActionPerformed

    private void btn_nccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nccActionPerformed
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(true);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_nccActionPerformed

    private void btn_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khActionPerformed
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(true);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_khActionPerformed

    private void btn_pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pnActionPerformed
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(true);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_pnActionPerformed

    private void btn_tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tkActionPerformed
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(true);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_tkActionPerformed

    private void btn_tcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tcActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dt;
    private javax.swing.JButton btn_kh;
    private javax.swing.JButton btn_ncc;
    private javax.swing.JButton btn_nv;
    private javax.swing.JButton btn_pn;
    private javax.swing.JButton btn_px;
    private javax.swing.JButton btn_tc;
    private javax.swing.JButton btn_thuoctinh;
    private javax.swing.JButton btn_tk;
    private javax.swing.JLabel img_store1;
    private javax.swing.JPanel jpanel_menu_bottom;
    private javax.swing.JPanel jpanel_menu_top1;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
