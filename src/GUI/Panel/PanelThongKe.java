/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.DienThoaiBUS;
import BUS.KhachHangBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DAO.ChiTietPhieuNhapDAO;
import DAO.ChiTietPhieuXuatDAO;
import DAO.PhieuXuatDAO;
import DTO.DienThoaiDTO;
import DTO.PhieuNhapDTO;
import DTO.PhieuXuatDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelThongKe extends javax.swing.JPanel {
    Func_class func=new Func_class();
    DienThoaiBUS dtBus=new DienThoaiBUS();
    NhanVienBUS nvBus=new NhanVienBUS();
    PhieuNhapBUS pnBus=new PhieuNhapBUS();
    KhachHangBUS khBus=new KhachHangBUS();
    NhaCungCapBUS nccBus=new NhaCungCapBUS();
    Font font1=new Font("Arial",Font.BOLD,30);
    double tongTienNhap=0;
    double tongTienXuat=0;
    public PanelThongKe() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        setIcon();
        setSoLuong();
        setUpTableDT();
       // setUpButton();
        actionBtn();
        highlightSelectedButton(btn_sp, btn_phieuNhap, btn_phieuXuat, btn_sp);
        jlabel_tongTien.setVisible(false);
        jlabel_tongPhieu.setVisible(false);
    }
    public JLabel getLabelTongPhieu(){
        return this.jlabel_tongPhieu;
    }
    public JLabel getLabelTongTien(){
        return this.jlabel_tongTien;
    }
    public JButton getBtnSp(){
        return this.btn_sp;
    }
    public JButton getBtnPn(){
        return this.btn_phieuNhap;
    }
    public JButton getBtnPx(){
        return this.btn_phieuXuat;
    }
    public void setUpTableDT(){
        loadDataSanPham(dtBus.listDT());
        func.centerTable(table);
        func.setUpTable(table);
    }
    public void setUpTablePN() {
        loadDataPhieuNhap(pnBus.listPN());
        func.centerTable(table);
        func.setUpTable(table);
    }

    public void setUpTablePX() {
        loadDataPhieuXuat(new PhieuXuatDAO().layTatCaPhieuXuat());
        func.centerTable(table);
        func.setUpTable(table);
    }
    public void setIcon(){
        jlabel_phone_static.setIcon(new FlatSVGIcon("./resources/icon/phone_static.svg",0.8f));
        jlabel_nv_static.setIcon(new FlatSVGIcon("./resources/icon/employee.svg",0.8f));
        jlabel_ncc_static.setIcon(new FlatSVGIcon("./resources/icon/nhacungcap.svg",0.7f));
    }
    public void setSoLuong(){
        jlabel_soLuong_DT.setFont(font1);
        jlabel_soLuong_DT.setText(String.valueOf(dtBus.listDT().size()));
        jlabel_soLuong_nv.setFont(font1);
        jlabel_soLuong_nv.setText(String.valueOf(nvBus.listNV().size()));
        jlabel_ncc_soLuong.setFont(font1);
        jlabel_ncc_soLuong.setText(String.valueOf(nccBus.listNCC().size()));
    }
//    public void setUpButton(){
//        func.setUpBtn(btn_sp, Color.WHITE,new Color(211,218,211));
//        func.setUpBtn(btn_phieuNhap, Color.WHITE,new Color(211,218,211));
//        func.setUpBtn(btn_phieuXuat, Color.WHITE,new Color(211,218,211));
//    }
    public void loadDataSanPham(ArrayList<DienThoaiDTO> listDT){
        String[] colNames={"Số thứ tự","Mã máy","Tên máy","Số lượng nhập","Số lượng xuất","Còn lại kho"};
        Object[][] rows=new Object[listDT.size()][colNames.length];
        HashMap<Integer, Integer> mapNhap = new ChiTietPhieuNhapDAO().thongKeSoLuongNhapTheoMaDT();
        HashMap<Integer, Integer> mapXuat = new ChiTietPhieuXuatDAO().thongKeSoLuongXuatTheoMaDT();
        for(int i=0;i<listDT.size();i++){
            rows[i][0]=i+1;
            rows[i][1]=listDT.get(i).getMaDT();
            rows[i][2]=listDT.get(i).getTenDT();
            rows[i][3] = mapNhap.getOrDefault(listDT.get(i).getMaDT(), 0); // Sửa tại đây
            rows[i][4]=mapXuat.getOrDefault(listDT.get(i).getMaDT(), 0);
            rows[i][5]=mapNhap.getOrDefault(listDT.get(i).getMaDT(), 0)-mapXuat.getOrDefault(listDT.get(i).getMaDT(), 0);
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chỉnh sửa toàn bộ
            }
        };
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(180);
    }
    public void loadDataPhieuNhap(ArrayList<PhieuNhapDTO> listPN){
        String[] colNames={"Số thứ tự","Mã PN","Nhà cung cấp","Nhân viên","Ngày nhập","Tổng tiền"};
        Object[][] rows=new Object[listPN.size()][colNames.length];
        for(int i=0;i<listPN.size();i++){
            rows[i][0]=i+1;
            rows[i][1]=listPN.get(i).getMaPhieuNhap();
            rows[i][2]=nccBus.getTenNCCByID(listPN.get(i).getNhaCungCap());
            rows[i][3]=nvBus.getTenNVByID(listPN.get(i).getNhanVien());
            rows[i][4]=listPN.get(i).getNgayNhap();
            rows[i][5]=String.format("%,.0f",listPN.get(i).getTongTien());
            tongTienNhap+=listPN.get(i).getTongTien();
        }
        jlabel_tongPhieu.setText("TỔNG PHIẾU : "+listPN.size());
        jlabel_tongTien.setText("TỔNG TIỀN : "+String.format("%,.0f",tongTienNhap)+ " VNĐ");
        DefaultTableModel model = new DefaultTableModel(rows, colNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chỉnh sửa toàn bộ
            }
        };
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
    }
    public void loadDataPhieuXuat(ArrayList<PhieuXuatDTO> listPX){
        String[] colNames={"Số thứ tự","Mã PX","Khách hàng","Nhân viên","Ngày nhập","Tổng tiền"};
        Object[][] rows=new Object[listPX.size()][colNames.length];
        for(int i=0;i<listPX.size();i++){
            rows[i][0]=i+1;
            rows[i][1]=listPX.get(i).getMaPX();
            rows[i][2]=khBus.getTenKHByID(listPX.get(i).getMaKH());
            rows[i][3]=nvBus.getTenNVByID(listPX.get(i).getMaNV());
            rows[i][4]=listPX.get(i).getThoiGian();
            rows[i][5]=String.format("%,.0f",listPX.get(i).getTongTien());
            tongTienXuat+=listPX.get(i).getTongTien();
        }
        jlabel_tongPhieu.setText("TỔNG PHIẾU : "+listPX.size());
        jlabel_tongTien.setText("TỔNG TIỀN : "+String.format("%,.0f",tongTienXuat)+ " VNĐ");
        DefaultTableModel model = new DefaultTableModel(rows, colNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chỉnh sửa toàn bộ
            }
        };
        table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
    }
    public void highlightSelectedButton(JButton btnSanPham, JButton btnPhieuNhap, JButton btnPhieuXuat, JButton selected) {
        Color selectedColor = new Color(100, 149, 237); // Màu xanh dương nhạt
        Color defaultColor = new Color(240, 240, 240);  // Màu nền mặc định

        // So sánh từng button với button đang được chọn
        if (selected == btnSanPham) {
            btnSanPham.setBackground(selectedColor);
            btnPhieuNhap.setBackground(defaultColor);
            btnPhieuXuat.setBackground(defaultColor);
        } else if (selected == btnPhieuNhap) {
            btnSanPham.setBackground(defaultColor);
            btnPhieuNhap.setBackground(selectedColor);
            btnPhieuXuat.setBackground(defaultColor);
        } else if (selected == btnPhieuXuat) {
            btnSanPham.setBackground(defaultColor);
            btnPhieuNhap.setBackground(defaultColor);
            btnPhieuXuat.setBackground(selectedColor);
        }
    }
    public void actionBtn() {
        btn_sp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUpTableDT();
                jlabel_tongTien.setVisible(false);
                jlabel_tongPhieu.setVisible(false);
                highlightSelectedButton(btn_sp, btn_phieuNhap, btn_phieuXuat, btn_sp);
            }
        });

        btn_phieuNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUpTablePN();
                jlabel_tongTien.setVisible(true);
                jlabel_tongPhieu.setVisible(true);
                tongTienNhap=0;
                highlightSelectedButton(btn_sp, btn_phieuNhap, btn_phieuXuat, btn_phieuNhap);
            }
        });

        btn_phieuXuat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUpTablePX();
                jlabel_tongTien.setVisible(true);
                jlabel_tongPhieu.setVisible(true);
                tongTienXuat=0;
                highlightSelectedButton(btn_sp, btn_phieuNhap, btn_phieuXuat, btn_phieuXuat);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlabel_ncc_static = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlabel_ncc_soLuong = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlabel_phone_static = new javax.swing.JLabel();
        jlabel_soLuong_DT = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jlabel_nv_static = new javax.swing.JLabel();
        jlabel_soLuong_nv = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btn_sp = new javax.swing.JButton();
        btn_phieuNhap = new javax.swing.JButton();
        btn_phieuXuat = new javax.swing.JButton();
        jlabel_tongTien = new javax.swing.JLabel();
        jlabel_tongPhieu = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nhà cung cấp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jlabel_ncc_static, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_ncc_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlabel_ncc_soLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(19, 19, 19))
                    .addComponent(jlabel_ncc_static, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Sản phẩm trong cửa hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlabel_phone_static, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jlabel_soLuong_DT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlabel_phone_static, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlabel_soLuong_DT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        jPanel5.setBackground(new java.awt.Color(51, 255, 51));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nhân viên hoạt động");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_nv_static, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_soLuong_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jlabel_soLuong_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlabel_nv_static, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        btn_sp.setText("Sản phẩm");

        btn_phieuNhap.setText("Phiếu Nhập");

        btn_phieuXuat.setText("Phiếu Xuất");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_sp)
                .addGap(18, 18, 18)
                .addComponent(btn_phieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_phieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_phieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btn_sp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_phieuXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlabel_tongTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlabel_tongTien.setText("TỔNG TIỀN :");

        jlabel_tongPhieu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlabel_tongPhieu.setText("TỔNG PHIẾU :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jlabel_tongPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_tongPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_phieuNhap;
    private javax.swing.JButton btn_phieuXuat;
    private javax.swing.JButton btn_sp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_ncc_soLuong;
    private javax.swing.JLabel jlabel_ncc_static;
    private javax.swing.JLabel jlabel_nv_static;
    private javax.swing.JLabel jlabel_phone_static;
    private javax.swing.JLabel jlabel_soLuong_DT;
    private javax.swing.JLabel jlabel_soLuong_nv;
    private javax.swing.JLabel jlabel_tongPhieu;
    private javax.swing.JLabel jlabel_tongTien;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
