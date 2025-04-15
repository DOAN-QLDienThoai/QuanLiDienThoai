/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.DienThoaiBUS;
import BUS.PhienBanDienThoaiBUS;
import DAO.DienThoaiDAO;
import DAO.MauSacDAO;
import DAO.PhienBanDienThoaiDAO;
import DAO.RamDAO;
import DAO.RomDAO;
import DTO.DienThoaiDTO;
import DTO.PhienBanDienThoaiDTO;
import GUI.Panel.PanelDienThoai;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class AddCauHinhDialog extends javax.swing.JDialog {

    private static ArrayList<PhienBanDienThoaiDTO> listPBDTTemp = new ArrayList<>();
    private DienThoaiDTO dt;
    private Func_class func = new Func_class();
    private PanelDienThoai dtPanel;
    private AddDienThoaiDialog dtDialog;
    DienThoaiBUS dtBus = new DienThoaiBUS();
    PhienBanDienThoaiBUS pbBus = new PhienBanDienThoaiBUS();

    public AddCauHinhDialog(java.awt.Frame parent, boolean modal, DienThoaiDTO dt, PanelDienThoai dtPanel, AddDienThoaiDialog dtDialog) {
        super(parent, modal);
        initComponents();
        this.dt = dt;
        this.dtPanel = dtPanel;
        this.dtDialog = dtDialog;
        fillCbbRam();
        fillCbbRom();
        fillCbbMauSac();
        setUpTable();
        this.setLocationRelativeTo(null);
    }

    public void addDatatable() {
        String[] colNames = {"STT", "Ram", "Rom", "Màu Sắc", "Giá nhập", "Giá xuất"};
        Object[][] rows = new Object[listPBDTTemp.size()][colNames.length];
        int index = 0;
        for (PhienBanDienThoaiDTO pb : listPBDTTemp) {
            // Lấy thông tin Ram
            int maRam = pb.getmaRam();
            int dungLuongRam = -1;
            HashMap<Integer, Integer> mapRam = new RamDAO().listMapRam();
            for (Map.Entry<Integer, Integer> entry : mapRam.entrySet()) {
                if (maRam == entry.getValue()) {
                    dungLuongRam = entry.getKey();
                    break;
                }
            }
            // Lấy thông tin Rom
            int maRom = pb.getmaRom();
            int dungLuongRom = -1;
            HashMap<Integer, Integer> mapRom = new RomDAO().listMapRom();
            for (Map.Entry<Integer, Integer> entry : mapRom.entrySet()) {
                if (maRom == entry.getValue()) {
                    dungLuongRom = entry.getKey();
                    break;
                }
            }
            // Lấy thông tin Màu sắc
            int maMau = pb.getmaMau();
            String tenMau = null;
            HashMap<String, Integer> mapMS = new MauSacDAO().listMapMS();
            for (Map.Entry<String, Integer> entry : mapMS.entrySet()) {
                if (maMau == entry.getValue()) {
                    tenMau = entry.getKey();
                    break;
                }
            }
            // Cập nhật giá trị vào bảng
            rows[index][0] = index;
            rows[index][1] = String.valueOf(dungLuongRam);
            rows[index][2] = String.valueOf(dungLuongRom);
            rows[index][3] = tenMau;
            rows[index][4] = pb.getGiaNhap();
            rows[index][5] = pb.getGiaXuat();
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_cauHinh.setModel(model);
        func.centerTable(table_cauHinh);
    }

    public void setUpTable() {
        this.addDatatable();
        func.setUpTable(table_cauHinh);
        func.centerTable(table_cauHinh);
    }

    public void fillCbbMauSac() {
        HashMap<String, Integer> mapMS = new MauSacDAO().listMapMS();
        cbb_ms.setBackground(Color.WHITE);
        for (String ms : mapMS.keySet()) {
            cbb_ms.addItem(ms);
        }
    }

    public void fillCbbRam() {
        HashMap<Integer, Integer> mapRam = new RamDAO().listMapRam();
        cbb_ram.setBackground(Color.WHITE);
        for (int ram : mapRam.keySet()) {
            cbb_ram.addItem(String.valueOf(ram));
        }
    }

    public void fillCbbRom() {
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

    public void resetGia() {
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
        jPanel2 = new javax.swing.JPanel();
        btn_add_cauHinh = new javax.swing.JButton();
        btn_update_cauHinh = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_make_new = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_add_dien_thoai = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_ram, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbb_ms, 0, 140, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_gia_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_gia_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_add_cauHinh.setBackground(new java.awt.Color(153, 255, 153));
        btn_add_cauHinh.setText("Thêm Cấu Hình");
        btn_add_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_cauHinhMouseClicked(evt);
            }
        });

        btn_update_cauHinh.setBackground(new java.awt.Color(51, 255, 204));
        btn_update_cauHinh.setText("Sửa Cấu Hình");
        btn_update_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_update_cauHinhMouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Xóa Cấu Hình");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        btn_make_new.setBackground(new java.awt.Color(0, 51, 255));
        btn_make_new.setText("Làm mới");
        btn_make_new.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_make_newMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_add_cauHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_update_cauHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_make_new, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_add_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_update_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_make_new, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        btn_add_dien_thoai.setBackground(new java.awt.Color(102, 255, 102));
        btn_add_dien_thoai.setText("Thêm Điện Thoại");
        btn_add_dien_thoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_dien_thoaiMouseClicked(evt);
            }
        });

        btn_return.setBackground(new java.awt.Color(255, 204, 0));
        btn_return.setText("Quay lại");
        btn_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_add_dien_thoai)
                .addGap(18, 18, 18)
                .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_add_dien_thoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_return, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cauHinhMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        int dungLuongRam = Integer.parseInt(table_cauHinh.getValueAt(vitriRow, 1).toString());
        int dungLuongRom = Integer.parseInt(table_cauHinh.getValueAt(vitriRow, 2).toString());
        String tenMau = table_cauHinh.getValueAt(vitriRow, 3).toString();
        double giaNhap = Double.parseDouble(table_cauHinh.getValueAt(vitriRow, 4).toString());
        double giaXuat = Double.parseDouble(table_cauHinh.getValueAt(vitriRow, 5).toString());
        cbb_ram.setSelectedItem(String.valueOf(dungLuongRam));
        cbb_rom.setSelectedItem(String.valueOf(dungLuongRom));
        cbb_ms.setSelectedItem(tenMau);
        jtf_gia_nhap.setText(String.valueOf(giaNhap));
        jtf_gia_xuat.setText(String.valueOf(giaXuat));
    }//GEN-LAST:event_table_cauHinhMouseClicked

    private void btn_add_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_cauHinhMouseClicked
        int result = checkCauHinh();
        if (result == 1) {
            HashMap<Integer, Integer> mapRam = new RamDAO().listMapRam();
            int selectedRam = Integer.parseInt(cbb_ram.getSelectedItem().toString()); // Chuyển String -> Integer
            int maRam = mapRam.getOrDefault(selectedRam, -1);
            HashMap<Integer, Integer> mapRom = new RomDAO().listMapRom();
            int selectedRom = Integer.parseInt(cbb_rom.getSelectedItem().toString()); // Chuyển String -> Integer
            int maRom = mapRom.getOrDefault(selectedRom, -1);
            HashMap<String, Integer> mapMS = new MauSacDAO().listMapMS();
            int maMau = mapMS.get(cbb_ms.getSelectedItem().toString());
            double giaNhap = Double.parseDouble(jtf_gia_nhap.getText());
            double giaXuat = Double.parseDouble(jtf_gia_xuat.getText());
            PhienBanDienThoaiDTO pb = new PhienBanDienThoaiDTO(0, 0, maRam, maRom, maMau, giaNhap, giaXuat);
            listPBDTTemp.add(pb);
            resetGia();
            this.addDatatable();
            func.centerTable(table_cauHinh);
        }
    }//GEN-LAST:event_btn_add_cauHinhMouseClicked

    private void btn_update_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_cauHinhMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng để thêm", "Error", 0);
            return;
        }
        PhienBanDienThoaiDTO phienBanUpdate = listPBDTTemp.get(vitriRow);
        HashMap<Integer, Integer> mapRam = new RamDAO().listMapRam();
        int selectedRam = Integer.parseInt(cbb_ram.getSelectedItem().toString()); // Chuyển String -> Integer
        int maRam = mapRam.getOrDefault(selectedRam, -1);
        System.out.println(maRam);
        HashMap<Integer, Integer> mapRom = new RomDAO().listMapRom();
        int selectedRom = Integer.parseInt(cbb_rom.getSelectedItem().toString()); // Chuyển String -> Integer
        int maRom = mapRom.getOrDefault(selectedRom, -1);
        System.out.println(maRom);
        HashMap<String, Integer> mapMS = new MauSacDAO().listMapMS();
        int maMau = mapMS.get(cbb_ms.getSelectedItem().toString());
        double giaNhap = Double.parseDouble(jtf_gia_nhap.getText());
        double giaXuat = Double.parseDouble(jtf_gia_xuat.getText());
        phienBanUpdate.setRam(maRam);
        phienBanUpdate.setRom(maRom);
        phienBanUpdate.setMausac(maMau);
        phienBanUpdate.setGiaNhap(giaNhap);
        phienBanUpdate.setGiaXuat(giaXuat);
        addDatatable();
        func.centerTable(table_cauHinh);
        resetGia();
    }//GEN-LAST:event_btn_update_cauHinhMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chọn phiên bản để xóa", "Error", 0);
            return;
        }
        int index = Integer.parseInt(table_cauHinh.getValueAt(vitriRow, 0).toString());
        for (PhienBanDienThoaiDTO pb : listPBDTTemp) {
            if (index == vitriRow) {
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phiên bản này không?",
                        "Xác nhận xóa",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    listPBDTTemp.remove(pb);
                    addDatatable();
                    func.centerTable(table_cauHinh);
                }
            }
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void btn_make_newMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_make_newMouseClicked
        resetGia();
        fillCbbRam();
        fillCbbRom();
        fillCbbMauSac();
    }//GEN-LAST:event_btn_make_newMouseClicked

    private void btn_add_dien_thoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_dien_thoaiMouseClicked
        if (listPBDTTemp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa thêm cấu hình!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            dtBus.insertDienThoai(dt);
            func.addDataTableDienThoai(dtBus.listDT(), dtPanel.getTableDienThoai());
            func.centerTable(dtPanel.getTableDienThoai());
            int maDT = new DienThoaiDAO().getID();
            for (PhienBanDienThoaiDTO pb : listPBDTTemp) {
                pb.setMaDT(maDT);
                try {
                    pbBus.insertPhienBanDienThoai(pb);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(this, "Thêm điện thoại thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
            listPBDTTemp.clear();
            this.dispose();
            dtDialog.dispose();
        }
    }//GEN-LAST:event_btn_add_dien_thoaiMouseClicked

    private void btn_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_returnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_cauHinh;
    private javax.swing.JButton btn_add_dien_thoai;
    private javax.swing.JButton btn_make_new;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_update_cauHinh;
    private javax.swing.JComboBox<String> cbb_ms;
    private javax.swing.JComboBox<String> cbb_ram;
    private javax.swing.JComboBox<String> cbb_rom;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtf_gia_nhap;
    private javax.swing.JTextField jtf_gia_xuat;
    private javax.swing.JTable table_cauHinh;
    // End of variables declaration//GEN-END:variables
}
