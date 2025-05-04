/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.MauSacBUS;
import BUS.PhienBanDienThoaiBUS;
import BUS.RamBUS;
import BUS.RomBUS;
import DAO.MauSacDAO;
import DAO.PhienBanDienThoaiDAO;
import DAO.RamDAO;
import DAO.RomDAO;
import DTO.DienThoaiDTO;
import DTO.PhienBanDienThoaiDTO;
import GUI.Panel.PanelDienThoai;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class EditCauHinhDialog extends javax.swing.JDialog {
    DienThoaiDTO dt=new DienThoaiDTO();
    Func_class func = new Func_class();
    PanelDienThoai dtPanel;
    ArrayList<PhienBanDienThoaiDTO> listPBDTTemp;
    PhienBanDienThoaiBUS pbBus=new PhienBanDienThoaiBUS();
    RamBUS ramBus =new RamBUS();
    RomBUS romBUS=new RomBUS();
    MauSacBUS msBus=new MauSacBUS();
    public EditCauHinhDialog(java.awt.Frame parent, boolean modal, int maDT, ArrayList<PhienBanDienThoaiDTO> listPBDTTemp, PanelDienThoai dtPanel) {
        super(parent, modal);
        initComponents();
        this.setTitle("Chỉnh sửa cấu hình");
        this.setLocationRelativeTo(null);
        this.dtPanel = dtPanel;
        this.listPBDTTemp = listPBDTTemp;
        dt.setMaDT(maDT);
        khoiTao();
    }
    public void khoiTao(){
        fillComboboxRam();
        fillComboboxRom();
        fillComboboxMauSac();
        setUpTable();
        setIcon();
        setUpCBB();
        setUpBtn();
    }
    public void setUpTable() {
        this.addDatatable();
        func.setUpTable(table_cauHinh);
        func.centerTable(table_cauHinh);
    }
    public void setUpBtn(){
        func.setUpBtnTwo(btn_return, Color.ORANGE, Color.ORANGE,new Color(211,218,211), 14);
        func.setUpBtnTwo(btn_add_cauHinh, Color.GREEN, Color.GREEN,new Color(211,218,211), 14);
        func.setUpBtnTwo(btn_update_cauHinh, Color.CYAN, Color.CYAN,new Color(211,218,211), 14);
        func.setUpBtnTwo(btn_delete_cauHinh, Color.RED, Color.RED,new Color(211,218,211), 14);
        func.setUpBtnTwo(btn_make_new, Color.BLUE, Color.BLUE,new Color(211,218,211), 14);
    }
    public void setUpCBB(){
        func.setUpComBoBox(cbb_rom);
        func.setUpComBoBox(cbb_ram);
        func.setUpComBoBox(cbb_ms);
    }
    public void fillComboboxMauSac() {
        HashMap<String, Integer> mapMS = new MauSacDAO().listMapMS();
        cbb_ms.setBackground(Color.WHITE);
        for (String ms : mapMS.keySet()) {
            cbb_ms.addItem(ms);
        }
    }
    public void setIcon(){
        btn_return.setIcon(new FlatSVGIcon("./resources/icon/left.svg",0.4f));
    }
    public void fillComboboxRam() {
        HashMap<Integer, Integer> mapRam = new RamDAO().listMapRam();
        cbb_ram.setBackground(Color.WHITE);
        for (int ram : mapRam.keySet()) {
            cbb_ram.addItem(String.valueOf(ram));
        }

    }

    public void fillComboboxRom() {
        HashMap<Integer, Integer> mapRom = new RomDAO().listMapRom();
        cbb_rom.setBackground(Color.WHITE);
        for (int rom : mapRom.keySet()) {
            cbb_rom.addItem(String.valueOf(rom));
        }
    }

    public int checkCauHinh() {
        if (jtf_gia_nhap.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá nhập", "Error", 0);
            return 0;
        }
        if (jtf_gia_xuat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập giá xuất", "Error", 0);
            return 0;
        }
        return 1;
    }

    //Thêm dữ liệu vào bảng cấu hình
    public void addDatatable() {
        String[] colNames = {"STT", "Ram", "Rom", "Màu Sắc", "Giá nhập", "Giá xuất"};
        Object[][] rows = new Object[listPBDTTemp.size()][colNames.length];
        int index = 0;
        for (PhienBanDienThoaiDTO pb : listPBDTTemp) {
            // Lấy thông tin Ram
            int maRam = pb.getmaRam();
            int dungLuongRam=ramBus.getDungLuongRambyID(maRam);
            // Lấy thông tin Rom
            int maRom = pb.getmaRom();
            int dungLuongRom=romBUS.getDungLuongRombyID(maRom);
            // Lấy thông tin Màu sắc
            int maMau = pb.getmaMau();
            String tenMau = msBus.getTenMauByID(maMau);
            // Cập nhật giá trị vào bảng
            rows[index][0] = index;
            rows[index][1] = dungLuongRam;
            rows[index][2] = dungLuongRom;
            rows[index][3] = tenMau;
            rows[index][4] = String.format("%,.0f",pb.getGiaNhap());
            rows[index][5] = String.format("%,.0f",pb.getGiaXuat());
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_cauHinh.setModel(model);
    }
    public void resetGia(){
        jtf_gia_nhap.setText("");
        jtf_gia_xuat.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbb_ram = new javax.swing.JComboBox<>();
        cbb_rom = new javax.swing.JComboBox<>();
        cbb_ms = new javax.swing.JComboBox<>();
        jtf_gia_nhap = new javax.swing.JTextField();
        jtf_gia_xuat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_cauHinh = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_update_cauHinh = new javax.swing.JButton();
        btn_add_cauHinh = new javax.swing.JButton();
        btn_delete_cauHinh = new javax.swing.JButton();
        btn_make_new = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chỉnh sửa cấu hình");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table_cauHinh.setModel(new javax.swing.table.DefaultTableModel(
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
        table_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_cauHinhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_cauHinh);

        jLabel1.setText("Ram");

        jLabel2.setText("Rom");

        jLabel3.setText("Màu sắc");

        jLabel4.setText("Giá nhập");

        jLabel5.setText("Giá xuất");

        btn_update_cauHinh.setBackground(new java.awt.Color(51, 255, 204));
        btn_update_cauHinh.setText("Sửa Cấu Hình");
        btn_update_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_update_cauHinhMouseClicked(evt);
            }
        });

        btn_add_cauHinh.setBackground(new java.awt.Color(153, 255, 153));
        btn_add_cauHinh.setText("Thêm Cấu Hình");
        btn_add_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_cauHinhMouseClicked(evt);
            }
        });

        btn_delete_cauHinh.setBackground(new java.awt.Color(255, 0, 0));
        btn_delete_cauHinh.setText("Xóa Cấu Hình");
        btn_delete_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_delete_cauHinhMouseClicked(evt);
            }
        });

        btn_make_new.setBackground(new java.awt.Color(0, 51, 255));
        btn_make_new.setText("Làm mới");
        btn_make_new.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_make_newMouseClicked(evt);
            }
        });

        btn_return.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_return.setText("Quay lại");
        btn_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_update_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_add_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_make_new, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_ram, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_ms, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_gia_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_gia_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_ram, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_ms, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_gia_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_gia_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_add_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_make_new, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_return, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cauHinhMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        int dungLuongRam=Integer.parseInt(table_cauHinh.getValueAt(vitriRow,1).toString());
        int dungLuongRom=Integer.parseInt(table_cauHinh.getValueAt(vitriRow,2).toString());
        String tenMau=table_cauHinh.getValueAt(vitriRow,3).toString();
        double giaNhap=Double.parseDouble(table_cauHinh.getValueAt(vitriRow, 4).toString().replaceAll(",",""));
        double giaXuat=Double.parseDouble(table_cauHinh.getValueAt(vitriRow, 5).toString().replaceAll(",",""));
        cbb_ram.setSelectedItem(String.valueOf(dungLuongRam));
        cbb_rom.setSelectedItem(String.valueOf(dungLuongRom));
        cbb_ms.setSelectedItem(tenMau);
        jtf_gia_nhap.setText(String.format("%,.0f",giaNhap));
        jtf_gia_xuat.setText(String.format("%,.0f",giaXuat));
    }//GEN-LAST:event_table_cauHinhMouseClicked

    private void btn_add_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_cauHinhMouseClicked
        int result = checkCauHinh();
        if (result == 1) {
            int dungLuongRam = Integer.parseInt(cbb_ram.getSelectedItem().toString()); // Chuyển String -> Integer
            int maRam = ramBus.getIDByDungLuongRam(dungLuongRam);
            int dungLuongRom = Integer.parseInt(cbb_rom.getSelectedItem().toString()); // Chuyển String -> Integer
            int maRom = romBUS.getIDByDungLuongRom(dungLuongRom);
            int maMau = msBus.getIDByTenMau(cbb_ms.getSelectedItem().toString());
            double giaNhap = Double.parseDouble(jtf_gia_nhap.getText().replaceAll(",", ""));
            double giaXuat = Double.parseDouble(jtf_gia_xuat.getText().replaceAll(",", ""));
            if (checkGiaNhapGiaXuat(giaNhap, giaXuat)) {
                PhienBanDienThoaiDTO pb = new PhienBanDienThoaiDTO(dt.getMaDT(), maRam, maRom, maMau, giaNhap, giaXuat);
                if (pbBus.checkDupAdd(listPBDTTemp, pb)) {
                    listPBDTTemp.add(pb);
                    new PhienBanDienThoaiDAO().insertPhienBan(pb);
                    resetGia();
                    setUpTable();
                    return;
                }
                JOptionPane.showMessageDialog(null, "Cấu hình đã tồn tại", "Error", 0);
            }
        }
    }//GEN-LAST:event_btn_add_cauHinhMouseClicked
    public boolean checkGiaNhapGiaXuat(double giaNhap, double giaXuat) {
        boolean check = true;
        if (giaNhap > giaXuat) {
            JOptionPane.showMessageDialog(null, "Giá nhập phải lớn hơn giá xuất", "Error", 0);
            check = false;
        }
        if (giaNhap < 0) {
            JOptionPane.showMessageDialog(null, "Giá nhập không được âm", "Error", 0);
            check = false;
        }
        if (giaXuat < 0) {
            JOptionPane.showMessageDialog(null, "Giá xuất không được âm", "Error", 0);
            check = false;
        }
        return check;
    }
    private void btn_update_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_cauHinhMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn phiên bản để sửa", "Error", 0);
            return;
        }
        PhienBanDienThoaiDTO phienBanUpdate = listPBDTTemp.get(vitriRow);
        int dungLuongRam = Integer.parseInt(cbb_ram.getSelectedItem().toString()); // Chuyển String -> Integer
        int maRam = ramBus.getIDByDungLuongRam(dungLuongRam);
        int dungLuongRom = Integer.parseInt(cbb_rom.getSelectedItem().toString()); // Chuyển String -> Integer
        int maRom = romBUS.getIDByDungLuongRom(dungLuongRom);
        int maMau = msBus.getIDByTenMau(cbb_ms.getSelectedItem().toString());
        double giaNhap = Double.parseDouble(jtf_gia_nhap.getText().replaceAll(",", ""));
        double giaXuat = Double.parseDouble(jtf_gia_xuat.getText().replaceAll(",", ""));
        if (checkGiaNhapGiaXuat(giaNhap, giaXuat)) {
            PhienBanDienThoaiDTO pbNew = new PhienBanDienThoaiDTO(0, phienBanUpdate.getMaDT(), maRam, maRom, maMau, giaNhap, giaXuat);
            if (pbBus.checkDupEdit(listPBDTTemp, pbNew,vitriRow)) {
                phienBanUpdate.setRam(maRam);
                phienBanUpdate.setRom(maRom);
                phienBanUpdate.setMausac(maMau);
                phienBanUpdate.setGiaNhap(giaNhap);
                phienBanUpdate.setGiaXuat(giaXuat);
                pbBus.updatePhienBanDienThoai(phienBanUpdate);
                setUpTable();
                resetGia();
                return;
            }
            JOptionPane.showMessageDialog(null, "Cấu hình đã tồn tại", "Error", 0);
        }
    }//GEN-LAST:event_btn_update_cauHinhMouseClicked

    private void btn_delete_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_delete_cauHinhMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chọn phiên bản để xóa", "Error", 0);
            return;
        }
        PhienBanDienThoaiDTO phienBanDelete = listPBDTTemp.get(vitriRow);
        if (pbBus.isPhienBanDaDuocNhap(phienBanDelete.getMaPhienBan()) && pbBus.isPhienBanDaDuocXuat(phienBanDelete.getMaPhienBan())) {
            listPBDTTemp.remove(phienBanDelete);
            pbBus.deletePhienBanDienThoai(phienBanDelete.getMaPhienBan());
            setUpTable();
        }
    }//GEN-LAST:event_btn_delete_cauHinhMouseClicked

    private void btn_make_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_make_newMouseClicked
        resetGia();
        fillComboboxRam();
        fillComboboxRom();
        fillComboboxMauSac();
    }//GEN-LAST:event_btn_make_newMouseClicked

    private void btn_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_returnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_cauHinh;
    private javax.swing.JButton btn_delete_cauHinh;
    private javax.swing.JButton btn_make_new;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_update_cauHinh;
    private javax.swing.JComboBox<String> cbb_ms;
    private javax.swing.JComboBox<String> cbb_ram;
    private javax.swing.JComboBox<String> cbb_rom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtf_gia_nhap;
    private javax.swing.JTextField jtf_gia_xuat;
    private javax.swing.JTable table_cauHinh;
    // End of variables declaration//GEN-END:variables
}
