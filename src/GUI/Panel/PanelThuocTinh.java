/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import GUI.Dialog.AddDienThoaiDialog;
import GUI.Dialog.HeDieuHanhDialog;
import GUI.Dialog.MauSacDialog;
import GUI.Dialog.RamDialog;
import GUI.Dialog.RomDialog;
import GUI.Dialog.ThuongHieuDialog;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.SwingUtilities;

/**
 *
 * @author kiman
 */
public class PanelThuocTinh extends javax.swing.JPanel {

    /**
     * Creates new form PanelThuocTinh
     */
    public PanelThuocTinh() {
        initComponents();
        setIconForJLabel();
    }
    public void setIconForJLabel(){
        btn_hdh.setIcon(new FlatSVGIcon("./resources/icon/os.svg"));
        btn_mausac.setIcon(new FlatSVGIcon("./resources/icon/color.svg"));
        btn_ram.setIcon(new FlatSVGIcon("./resources/icon/ram.svg"));
        btn_rom.setIcon(new FlatSVGIcon("./resources/icon/rom.svg"));
        btn_thuongHieu.setIcon(new FlatSVGIcon("./resources/icon/thuonghieu.svg"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ram = new javax.swing.JButton();
        btn_mausac = new javax.swing.JButton();
        btn_hdh = new javax.swing.JButton();
        btn_rom = new javax.swing.JButton();
        btn_thuongHieu = new javax.swing.JButton();

        btn_ram.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ram.setText("RAM");
        btn_ram.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_ram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ramMouseClicked(evt);
            }
        });

        btn_mausac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_mausac.setText("MÀU SẮC");
        btn_mausac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_mausacMouseClicked(evt);
            }
        });

        btn_hdh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_hdh.setText("HỆ ĐIỀU HÀNH");
        btn_hdh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_hdh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hdhMouseClicked(evt);
            }
        });

        btn_rom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_rom.setText("ROM");
        btn_rom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_rom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_romMouseClicked(evt);
            }
        });

        btn_thuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_thuongHieu.setText("THƯƠNG HIỆU");
        btn_thuongHieu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_thuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thuongHieuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_thuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hdh, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ram, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btn_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ramMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new RamDialog((Frame) parentWindow, true).setVisible(true);
    }//GEN-LAST:event_btn_ramMouseClicked

    private void btn_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mausacMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new MauSacDialog((Frame) parentWindow, true).setVisible(true);
    }//GEN-LAST:event_btn_mausacMouseClicked

    private void btn_hdhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hdhMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new HeDieuHanhDialog((Frame) parentWindow, true).setVisible(true);
    }//GEN-LAST:event_btn_hdhMouseClicked

    private void btn_romMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_romMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new RomDialog((Frame) parentWindow, true).setVisible(true);
    }//GEN-LAST:event_btn_romMouseClicked

    private void btn_thuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thuongHieuMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new ThuongHieuDialog((Frame) parentWindow, true).setVisible(true);
    }//GEN-LAST:event_btn_thuongHieuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hdh;
    private javax.swing.JButton btn_mausac;
    private javax.swing.JButton btn_ram;
    private javax.swing.JButton btn_rom;
    private javax.swing.JButton btn_thuongHieu;
    // End of variables declaration//GEN-END:variables
}
