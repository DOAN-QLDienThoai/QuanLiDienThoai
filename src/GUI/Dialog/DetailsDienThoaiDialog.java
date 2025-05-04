/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.HeDieuHanhBUS;
import BUS.PhienBanDienThoaiBUS;
import BUS.ThuongHieuBUS;
import DTO.DienThoaiDTO;
import DTO.PhienBanDienThoaiDTO;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class DetailsDienThoaiDialog extends javax.swing.JDialog {
    DienThoaiDTO dt;
    Border border=BorderFactory.createEtchedBorder();
    PhienBanDienThoaiBUS pbBus=new PhienBanDienThoaiBUS();
    ThuongHieuBUS thBus=new ThuongHieuBUS();
    HeDieuHanhBUS hdhBus=new HeDieuHanhBUS();
    Func_class func=new Func_class();
    ArrayList<PhienBanDienThoaiDTO> listPBDTTemp=new ArrayList<>();
    ArrayList<PhienBanDienThoaiDTO> listPBDT;
    public DetailsDienThoaiDialog(java.awt.Frame parent, boolean modal,DienThoaiDTO dt) {
        super(parent, modal);
        initComponents();
        this.dt = dt;
        this.setTitle("Xem chi tiết điện thoại");
        this.setLocationRelativeTo(null);
        khoiTao();
    }
    public void khoiTao() {
        jtf_tenDT.setText(dt.getTenDT());
        jtf_tenDT.setEditable(false);
        String tenThuongHieu;
        if(dt.getThuongHieu()!=-1){
            tenThuongHieu=thBus.getTenByMaTH(dt.getThuongHieu());
            cbb_ThuongHieu.addItem(tenThuongHieu);
            cbb_ThuongHieu.setSelectedItem(tenThuongHieu);
        }
        String tenHDH;
        if(dt.getHeDieuHanh()!=-1){
            tenHDH=hdhBus.getTenByMaHDH(dt.getHeDieuHanh());
            cbb_HDH.addItem(tenHDH);
            cbb_HDH.setSelectedItem(tenHDH);
        }
        jtf_chip.setText(dt.getChipXuLy());
        jtf_chip.setEditable(false);
        jtf_dungLuongPin.setText(String.valueOf(dt.getDungLuongPin()));
        jtf_dungLuongPin.setEditable(false);
        jtf_kichThuocMan.setText(String.valueOf(dt.getKichThuocMan()));
        jtf_kichThuocMan.setEditable(false);
        func.disPlayImage(jlabel_hinhAnh.getWidth(), jlabel_hinhAnh.getHeight(), dt.getHinhAnh(), jlabel_hinhAnh);
        setUPcomBobox();
        jPanel3.setBorder(border);
        jPanel4.setBorder(border);
        func.setUpBtnTwo(btn_view_cauHinh, Color.CYAN, Color.CYAN,new Color(211,218,211),14);
    }
    public void setUPcomBobox(){
        func.setUpComBoBox(cbb_HDH);
        func.setUpComBoBox(cbb_ThuongHieu);
    }
      public int check_edit_sanPham(){
        if (jlabel_hinhAnh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hình ảnh trước khi thêm!", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if(jtf_tenDT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng tên sản phẩm!", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if(jtf_dungLuongPin.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập dung lượng pin!", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if(jtf_kichThuocMan.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập kích thước màn!", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if(jtf_chip.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập chip xử lý!", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlabel_hinhAnh = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtf_tenDT = new javax.swing.JTextField();
        jtf_chip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbb_ThuongHieu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_dungLuongPin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtf_kichThuocMan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbb_HDH = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btn_view_cauHinh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết điện thoại");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Chi Tiết Điện Thoại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_hinhAnh.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jlabel_hinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel_hinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Tên sản phẩm");

        jLabel4.setText("Thương hiệu");

        jLabel5.setText("Chip xử lý");

        jLabel6.setText("Dung lượng pin");

        jLabel7.setText("Kích thước màn");

        jLabel8.setText("Hệ điều hành");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtf_kichThuocMan, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_tenDT)
                        .addComponent(jtf_chip)
                        .addComponent(jLabel5))
                    .addComponent(jLabel7))
                .addGap(90, 90, 90)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbb_ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_dungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbb_HDH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_tenDT, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(cbb_ThuongHieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_chip, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_dungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_kichThuocMan, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(cbb_HDH))
                .addGap(15, 15, 15))
        );

        btn_view_cauHinh.setText("Xem Cấu Hình");
        btn_view_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_view_cauHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(btn_view_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_view_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_view_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_view_cauHinhMouseClicked
        int maDT=dt.getMaDT();
        if(!listPBDTTemp.isEmpty())
        listPBDTTemp.clear();
        listPBDT=pbBus.listPB();
        for(PhienBanDienThoaiDTO pb : listPBDT){
            if(pb.getMaDT()==maDT){
                listPBDTTemp.add(pb);
            }
        }
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsCauHinhDialog((Frame) parentWindow, true,maDT,listPBDTTemp).setVisible(true);
    }//GEN-LAST:event_btn_view_cauHinhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_view_cauHinh;
    private javax.swing.JComboBox<String> cbb_HDH;
    private javax.swing.JComboBox<String> cbb_ThuongHieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlabel_hinhAnh;
    private javax.swing.JTextField jtf_chip;
    private javax.swing.JTextField jtf_dungLuongPin;
    private javax.swing.JTextField jtf_kichThuocMan;
    private javax.swing.JTextField jtf_tenDT;
    // End of variables declaration//GEN-END:variables
}
