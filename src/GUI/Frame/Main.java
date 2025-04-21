/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Frame;

import BUS.NhanVienBUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
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
import GUI.Panel.PanelTrangChu;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.UIManager;




/**
 *
 * @author kiman
 */
public class Main extends javax.swing.JFrame {
    String maNhanVien;
    PanelTrangChu tt=new PanelTrangChu();
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
    JButton[] btns = new JButton[9];
    JButton currentActiveBtn = null;
    Border etchedBorder = BorderFactory.createEtchedBorder();
    public Main(String tenNV) {
        initComponents();
        UIManager.put("Component.arc", 10);
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("ComboBox.arc", 10);
        UIManager.put("Button.arc", 10);
        jlabel_name.setFont(new Font("Arial",Font.BOLD,18));
        this.jlabel_name.setText(tenNV);
        khoiTao();
        main.add(tt);
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
        tt.setVisible(false);
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
    public JLabel getNameUser(){
        return this.jlabel_name;
    }
    public void khoitaoButtonInMenu() {
        btns[0]=btn_trangChu;
        btns[1] = btn_nv;
        btns[2] = btn_thuoctinh;
        btns[3] = btn_dt;
        btns[4] = btn_ncc;
        btns[5] = btn_kh;
        btns[6] = btn_px;
        btns[7]=btn_pn;
        btns[8]=btn_tk;
    }
    public void setIconForJButton(){
        btn_trangChu.setIcon(new FlatSVGIcon("./resources/icon/home.svg", 0.35f));
        btn_dt.setIcon(new FlatSVGIcon("./resources/icon/phone.svg", 0.55f));
        btn_ncc.setIcon(new FlatSVGIcon("./resources/icon/ncc.svg", 0.55f));
        btn_thuoctinh.setIcon(new FlatSVGIcon("./resources/icon/thuoctinh.svg", 0.6f));
        btn_nv.setIcon(new FlatSVGIcon("./resources/icon/nhanvien.svg", 0.5f));
        btn_kh.setIcon(new FlatSVGIcon("./resources/icon/khachhang.svg", 0.035f));
        btn_px.setIcon(new FlatSVGIcon("./resources/icon/phieuxuat.svg", 0.035f));
        btn_pn.setIcon(new FlatSVGIcon("./resources/icon/phieunhap.svg", 0.27f));
        btn_tk.setIcon(new FlatSVGIcon("./resources/icon/static.svg", 0.3f));
        btn_logout.setIcon(new FlatSVGIcon("./resources/icon/logout.svg", 0.3f));
    }
    public PanelTrangChu getPanelTrangChu(){
        return this.tt;
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
        jLabel1 = new javax.swing.JLabel();
        jlabel_name = new javax.swing.JLabel();
        btn_trangChu = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("HI !");

        javax.swing.GroupLayout jpanel_menu_top1Layout = new javax.swing.GroupLayout(jpanel_menu_top1);
        jpanel_menu_top1.setLayout(jpanel_menu_top1Layout);
        jpanel_menu_top1Layout.setHorizontalGroup(
            jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_top1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_menu_top1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_menu_top1Layout.createSequentialGroup()
                    .addComponent(img_store1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 108, Short.MAX_VALUE)))
        );
        jpanel_menu_top1Layout.setVerticalGroup(
            jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_top1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jpanel_menu_top1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(img_store1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        );

        btn_trangChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_trangChu.setText("Trang Chủ");
        btn_trangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_trangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trangChuActionPerformed(evt);
            }
        });

        btn_logout.setText("Đăng xuất");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_menu_bottomLayout = new javax.swing.GroupLayout(jpanel_menu_bottom);
        jpanel_menu_bottom.setLayout(jpanel_menu_bottomLayout);
        jpanel_menu_bottomLayout.setHorizontalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                        .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_px, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btn_trangChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_dt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jpanel_menu_top1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpanel_menu_bottomLayout.setVerticalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addComponent(jpanel_menu_top1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_px, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main.setPreferredSize(new java.awt.Dimension(1000, 630));
        main.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tk.setVisible(false);
        dt.setVisible(false);
        thuoctinh.setVisible(true);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieunhap.setVisible(false);
        pn.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tt.setVisible(false);
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
        tt.setVisible(false);
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
        tt.setVisible(false);
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(true);
        nhapphieuxuat.loadTableSanPham();
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_pxActionPerformed

    private void btn_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dtActionPerformed
        tt.setVisible(false);
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
        tt.setVisible(false);
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
        tt.setVisible(false);
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
        tt.setVisible(false);
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(true);
        pn.setUpTable();
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_pnActionPerformed

    private void btn_tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tkActionPerformed
        tt.setVisible(false);
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

//<<<<<<< HEAD:src/GUI/Frame/Main.java
    private void btn_trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trangChuActionPerformed
        tt.setVisible(true);
        dt.setVisible(false);
        thuoctinh.setVisible(false);
        nv.setVisible(false);
        ncc.setVisible(false);
        khachhang.setVisible(false);
        phieuxuat.setVisible(false);
        nhapphieuxuat.setVisible(false);
        tk.setVisible(false);
        pn.setVisible(false);
        nhapphieunhap.setVisible(false);
    }//GEN-LAST:event_btn_trangChuActionPerformed
// =======
//     private void btn_tcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tcActionPerformed
//         // TODO add your handling code here:
//     }//GEN-LAST:event_btn_tcActionPerformed

//     /**
//      * @param args the command line arguments
//      */
//     public static void main(String args[]) {
//         /* Set the Nimbus look and feel */
//         //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//         /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//          * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//          */
//         try {
//             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                 if ("Nimbus".equals(info.getName())) {
//                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                     break;
//                 }
//             }
//         } catch (ClassNotFoundException ex) {
//             java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (InstantiationException ex) {
//             java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (IllegalAccessException ex) {
//             java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//             java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         }
//         //</editor-fold>
//         //</editor-fold>
//         //</editor-fold>
//         //</editor-fold>
// >>>>>>> mhuy:src/GUI/GUIFrame/Main.java

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        this.dispose();
        TaiKhoanDTO tk=new TaiKhoanDAO().isLoginCheck();
        new TaiKhoanDAO().capNhatTrangThaiDangNhap(tk.getMaNV(),false);
        LoginFormGUI formLogin=new LoginFormGUI();
        formLogin.setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dt;
    private javax.swing.JButton btn_kh;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_ncc;
    private javax.swing.JButton btn_nv;
    private javax.swing.JButton btn_pn;
    private javax.swing.JButton btn_px;
    private javax.swing.JButton btn_tc;
    private javax.swing.JButton btn_thuoctinh;
    private javax.swing.JButton btn_tk;
    private javax.swing.JButton btn_trangChu;
    private javax.swing.JLabel img_store1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlabel_name;
    private javax.swing.JPanel jpanel_menu_bottom;
    private javax.swing.JPanel jpanel_menu_top1;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
