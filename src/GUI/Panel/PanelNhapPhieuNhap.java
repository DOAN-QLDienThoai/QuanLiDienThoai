/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.DienThoaiBUS;
import BUS.MauSacBUS;
import BUS.NhaCungCapBUS;
import BUS.PhienBanDienThoaiBUS;
import BUS.RamBUS;
import BUS.RomBUS;
import DAO.DienThoaiDAO;
import DAO.PhienBanDienThoaiDAO;
import DTO.DienThoaiDTO;
import DTO.NhaCungCapDTO;
import GUI.GUIFrame.Main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelNhapPhieuNhap extends javax.swing.JPanel {
    Func_class func=new Func_class();
    Main main;
    DienThoaiBUS dtBus=new DienThoaiBUS();
    PhienBanDienThoaiBUS pbBus=new PhienBanDienThoaiBUS();
    NhaCungCapBUS nccBus=new NhaCungCapBUS();
    RamBUS ramBus=new RamBUS();
    RomBUS romBus=new RomBUS();
    MauSacBUS msBus=new MauSacBUS();
    ActionListener eventAct;
    public PanelNhapPhieuNhap(Main main) {
        initComponents();
        this.main=main;
        System.out.println("GUI.Panel.PanelNhapPhieuNhap.<init>()");
        PanelPhieuNhap pn=new PanelPhieuNhap(main);
        khoiTao();
    }
    public void khoiTao(){
        setUpTable();
        fillComboboxNhaCungCap();
        changeComboboxCauHinh();
    }
    public void loadDataDienThoai(ArrayList<DienThoaiDTO> listDT){
        String[] colNames={"Mã điện thoại","Tên điện thoại","Số lượng tồn"};
        Object[][] rows=new Object[listDT.size()][colNames.length];
        for(int i=0;i<listDT.size();i++){
            rows[i][0]=listDT.get(i).getMaDT();
            rows[i][1]=listDT.get(i).getTenDT();
            rows[i][2]=listDT.get(i).getSoLuongTon();
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table_dt.setModel(model);
    }
    public void fillComboboxNhaCungCap(){
        combobox_ncc.setBackground(Color.WHITE);
        for(NhaCungCapDTO ncc : nccBus.listNCC()){
            combobox_ncc.addItem(ncc.getName());
        }
    }
    public void setUpTable(){
        loadDataDienThoai(dtBus.listDT());
        func.setUpTable(table_dt);
        func.setUpTable(table_thongTin_cauHinh);
        func.centerTable(table_dt);
        func.centerTable(table_thongTin_cauHinh);
    }
    public String[] getCauHinh(String str){
        String[] parts=str.split("-");
        return parts;
    }
    public int getSelectRow(){
        int vitriRow=table_dt.getSelectedRow();
        return vitriRow;
    }
    public void changeComboboxCauHinh() {
        if (eventAct != null) {
            combobox_cauHinh.removeActionListener(eventAct); // Gỡ bỏ listener cũ nếu có
        }
        eventAct = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vitriRow = getSelectRow();
                if (vitriRow != -1) {
                    if (combobox_cauHinh.getSelectedItem() != null) {
                        String selectCauHinh = combobox_cauHinh.getSelectedItem().toString();
                        String[] parts = selectCauHinh.split("-");
                        int maDT = dtBus.getIDbyIndex(vitriRow);
                        int maRam = ramBus.getIDByDungLuongRam(Integer.parseInt(parts[0]));
                        int maRom = romBus.getIDByDungLuongRom(Integer.parseInt(parts[1]));
                        int maMau = msBus.getIDByTenMau(parts[2]);
                        double giaNhap = new PhienBanDienThoaiDAO().getGiaNhapByCauHinh(maDT, maRam, maRom, maMau);
                        jtf_giaNhap.setText(String.valueOf(giaNhap));
                    }
                }
            }
        };
        combobox_cauHinh.addActionListener(eventAct);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_dt = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_thongTin_cauHinh = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_maSp = new javax.swing.JTextField();
        jtf_tenSP = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtf_maPN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtf_nv_nhap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        combobox_ncc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combobox_cauHinh = new javax.swing.JComboBox<>();
        jtf_giaNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtf_soLuong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        table_dt.setModel(new javax.swing.table.DefaultTableModel(
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
        table_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_dt);

        jTextField1.setText("Tìm tên sp");

        table_thongTin_cauHinh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_thongTin_cauHinh);

        jLabel1.setText("ID");

        jLabel2.setText("Tên sản phẩm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Mã phiếu nhập");

        jLabel7.setText("Nhân viên nhập");

        jLabel8.setText("Nhà cung cấp");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("TỔNG TIỀN:");

        jLabel10.setText("jLabel10");

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Nhập hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtf_maPN, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtf_nv_nhap, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(combobox_ncc, javax.swing.GroupLayout.Alignment.LEADING, 0, 187, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_maPN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_nv_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jLabel3.setText("Cấu hình");

        jLabel4.setText("Giá nhập");

        jLabel5.setText("Số lượng");

        jButton1.setText("Sửa sản phẩm");

        jButton2.setText("Xóa sản phẩm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combobox_cauHinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtf_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtf_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtf_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void table_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dtMouseClicked
        int vitriRow = table_dt.getSelectedRow();
        int maDT = Integer.parseInt(table_dt.getValueAt(vitriRow, 0).toString());
        jtf_maSp.setText(String.valueOf(maDT));
        jtf_maSp.setEditable(false);
        jtf_tenSP.setText(table_dt.getValueAt(vitriRow, 1).toString());
        jtf_tenSP.setEditable(false);
        combobox_cauHinh.setBackground(Color.WHITE);
        combobox_cauHinh.removeAllItems();
        ArrayList<String> cauHinhs = pbBus.getCauHinhByMaDT(maDT);
        for (String pb : cauHinhs) {
            combobox_cauHinh.addItem(pb);
        }
        // Chọn dòng đầu tiên của combobox
        combobox_cauHinh.setSelectedIndex(0); // Set item đầu tiên
        // Lấy thông tin và hiển thị giá luôn
        String selectCauHinh = cauHinhs.get(0); // lấy luôn cấu hình đầu tiên
        String[] parts = selectCauHinh.split("-");
        if (parts.length == 3) {
            int maRam = ramBus.getIDByDungLuongRam(Integer.parseInt(parts[0]));
            int maRom = romBus.getIDByDungLuongRom(Integer.parseInt(parts[1]));
            int maMau = msBus.getIDByTenMau(parts[2]);
            double giaNhap = new PhienBanDienThoaiDAO().getGiaNhapByCauHinh(maDT, maRam, maRom, maMau);
            jtf_giaNhap.setText(String.valueOf(giaNhap));
        }
    }//GEN-LAST:event_table_dtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobox_cauHinh;
    private javax.swing.JComboBox<String> combobox_ncc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtf_giaNhap;
    private javax.swing.JTextField jtf_maPN;
    private javax.swing.JTextField jtf_maSp;
    private javax.swing.JTextField jtf_nv_nhap;
    private javax.swing.JTextField jtf_soLuong;
    private javax.swing.JTextField jtf_tenSP;
    private javax.swing.JTable table_dt;
    private javax.swing.JTable table_thongTin_cauHinh;
    // End of variables declaration//GEN-END:variables
}
