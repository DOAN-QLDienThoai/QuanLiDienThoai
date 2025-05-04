/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.DienThoaiBUS;
import BUS.MauSacBUS;
import BUS.PhienBanDienThoaiBUS;
import BUS.RamBUS;
import BUS.RomBUS;
import DAO.DienThoaiDAO;
import DTO.DienThoaiDTO;
import DTO.MauSacDTO;
import DTO.PhienBanDienThoaiDTO;
import DTO.RamDTO;
import DTO.RomDTO;
import GUI.Panel.PanelDienThoai;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class AddCauHinhDialog extends javax.swing.JDialog {
    public static ArrayList<PhienBanDienThoaiDTO> listPBDTTemp = new ArrayList<>();
    DienThoaiDTO dt;
    Func_class func = new Func_class();
    PanelDienThoai dtPanel;
    AddDienThoaiDialog dtDialog;
    DienThoaiBUS dtBus = new DienThoaiBUS();
    PhienBanDienThoaiBUS pbBus = new PhienBanDienThoaiBUS();
    RamBUS ramBus=new RamBUS();
    RomBUS romBUS=new RomBUS();
    MauSacBUS msBus=new MauSacBUS();
    public AddCauHinhDialog(java.awt.Frame parent, boolean modal, DienThoaiDTO dt, PanelDienThoai dtPanel, AddDienThoaiDialog dtDialog) {
        super(parent, modal);
        this.setTitle("Thêm cấu hình");
        initComponents();
        this.dt = dt;
        this.dtPanel = dtPanel;
        this.dtDialog = dtDialog;
        khoiTao();
        this.setLocationRelativeTo(null);
    }
    public void khoiTao(){
        fillCbbRam();
        fillCbbRom();
        fillCbbMauSac();
        setUpTable();
        notAllowText();
        setUpBtn();
    }
    public void notAllowText(){
        func.notAllowText(jtf_gia_nhap);
        func.notAllowText(jtf_gia_xuat);
    }
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
            String tenMau=msBus.getTenMauByID(maMau);
            // Cập nhật giá trị vào bảng
            rows[index][0] = index;
            rows[index][1] = String.valueOf(dungLuongRam);
            rows[index][2] = String.valueOf(dungLuongRom);
            rows[index][3] = tenMau;
            rows[index][4] = String.format("%,.0f", pb.getGiaNhap());
            rows[index][5] = String.format("%,.0f", pb.getGiaXuat());
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
    public void setUpBtn(){
        func.setUpBtnTwo(btn_add_dien_thoai, Color.GREEN, Color.GREEN,new Color(211,218,211),14);
        func.setUpBtnTwo(btn_return, Color.ORANGE, Color.ORANGE,new Color(211,218,211),14);
        func.setUpBtnTwo(btn_add_cauHinh, Color.YELLOW, Color.YELLOW,new Color(211,218,211),14);
        func.setUpBtnTwo(btn_update_cauHinh, Color.CYAN, Color.CYAN,new Color(211,218,211),14);
        func.setUpBtnTwo(btn_make_new, Color.BLUE, Color.BLUE,new Color(211,218,211),14);
        func.setUpBtnTwo(btn_delete, Color.RED, Color.RED,new Color(211,218,211),14);
    }
    public void fillCbbMauSac() {
        func.setUpComBoBox(cbb_ms);
        for (MauSacDTO ms : msBus.listMS()) {
            cbb_ms.addItem(ms.getTenMau());
        }
    }

    public void fillCbbRam() {
        func.setUpComBoBox(cbb_ram);
        for (RamDTO ram : ramBus.listRAM()) {
            cbb_ram.addItem(String.valueOf(ram.getDungLuongRam()));
        }
    }

    public void fillCbbRom() {
        func.setUpComBoBox(cbb_rom);
        for (RomDTO rom : romBUS.listROM()) {
            cbb_rom.addItem(String.valueOf(rom.getDungLuongRom()));
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
    public boolean checkGiaNhapGiaXuat(double giaNhap,double giaXuat){
        boolean check=true;
        if(giaNhap>giaXuat){
            JOptionPane.showMessageDialog(null,"Giá xuất phải lớn hơn giá nhập","Error",0);
            check=false;
        }
        if(giaNhap<0){
            JOptionPane.showMessageDialog(null,"Giá nhập không được âm","Error",0);
            check=false;
        }
        if(giaXuat<0){
            JOptionPane.showMessageDialog(null,"Giá xuất không được âm","Error",0);
            check=false;
        }
        return check;
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
        btn_return = new javax.swing.JButton();
        btn_add_dien_thoai = new javax.swing.JButton();
        btn_add_cauHinh = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_make_new = new javax.swing.JButton();
        btn_update_cauHinh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm cấu hình điện thoại");
        setBackground(new java.awt.Color(255, 255, 255));

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

        btn_return.setBackground(new java.awt.Color(255, 204, 0));
        btn_return.setText("Quay lại");
        btn_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }
        });

        btn_add_dien_thoai.setBackground(new java.awt.Color(102, 255, 102));
        btn_add_dien_thoai.setText("Thêm Điện Thoại");
        btn_add_dien_thoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_dien_thoaiMouseClicked(evt);
            }
        });

        btn_add_cauHinh.setBackground(new java.awt.Color(153, 255, 153));
        btn_add_cauHinh.setText("Thêm Cấu Hình");
        btn_add_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_cauHinhMouseClicked(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 0, 0));
        btn_delete.setText("Xóa Cấu Hình");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        btn_make_new.setBackground(new java.awt.Color(0, 51, 255));
        btn_make_new.setText("Làm mới");
        btn_make_new.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_make_newMouseClicked(evt);
            }
        });

        btn_update_cauHinh.setBackground(new java.awt.Color(51, 255, 204));
        btn_update_cauHinh.setText("Sửa Cấu Hình");
        btn_update_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_update_cauHinhMouseClicked(evt);
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
                        .addGap(214, 214, 214)
                        .addComponent(btn_add_dien_thoai)
                        .addGap(80, 80, 80)
                        .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_ram, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_ms, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_gia_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 54, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_gia_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_update_cauHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_add_cauHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_make_new, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_add_dien_thoai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_add_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_make_new, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_cauHinhMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        if(vitriRow==-1){
            return;
        }
        int dungLuongRam = Integer.parseInt(table_cauHinh.getValueAt(vitriRow, 1).toString());
        int dungLuongRom = Integer.parseInt(table_cauHinh.getValueAt(vitriRow, 2).toString());
        String tenMau = table_cauHinh.getValueAt(vitriRow, 3).toString();
        double giaNhap = Double.parseDouble(table_cauHinh.getValueAt(vitriRow, 4).toString().replaceAll(",",""));
        double giaXuat = Double.parseDouble(table_cauHinh.getValueAt(vitriRow, 5).toString().replaceAll(",",""));
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
            int maRam=ramBus.getIDByDungLuongRam(dungLuongRam);
            int dungLuongRom = Integer.parseInt(cbb_rom.getSelectedItem().toString()); // Chuyển String -> Integer
            int maRom = romBUS.getIDByDungLuongRom(dungLuongRom);
            int maMau = msBus.getIDByTenMau(cbb_ms.getSelectedItem().toString());
            double giaNhap = Double.parseDouble(jtf_gia_nhap.getText().replaceAll(",", ""));
            double giaXuat = Double.parseDouble(jtf_gia_xuat.getText().replaceAll(",", ""));
            if (checkGiaNhapGiaXuat(giaNhap, giaXuat)) {
                PhienBanDienThoaiDTO pb = new PhienBanDienThoaiDTO(0, dt.getMaDT(), maRam, maRom, maMau, giaNhap, giaXuat);
                if (pbBus.checkDupAdd(listPBDTTemp, pb)) {
                    listPBDTTemp.add(pb);
                    resetGia();
                    setUpTable();
                    return;
                }
                JOptionPane.showMessageDialog(null, "Cấu hình đã tồn tại", "Error", 0);
            }
        }
    }//GEN-LAST:event_btn_add_cauHinhMouseClicked

    private void btn_update_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_update_cauHinhMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn cấu hình để update", "Error", 0);
            return;
        }
        PhienBanDienThoaiDTO phienBanUpdate = listPBDTTemp.get(vitriRow);
        int selectedRam = Integer.parseInt(cbb_ram.getSelectedItem().toString()); 
        int maRam = ramBus.getIDByDungLuongRam(selectedRam);
        int selectedRom = Integer.parseInt(cbb_rom.getSelectedItem().toString()); 
        int maRom = romBUS.getIDByDungLuongRom(selectedRom);
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
                setUpTable();
                resetGia();
                return;
            }
            JOptionPane.showMessageDialog(null, "Cấu hình đã tồn tại", "Error", 0);
        }
    }//GEN-LAST:event_btn_update_cauHinhMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        int vitriRow = table_cauHinh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chọn phiên bản để xóa", "Error", 0);
            return;
        }
        PhienBanDienThoaiDTO pb = listPBDTTemp.get(vitriRow);
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phiên bản này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            listPBDTTemp.remove(pb);
            addDatatable();
            func.centerTable(table_cauHinh);
        }
    }//GEN-LAST:event_btn_deleteMouseClicked

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
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thêm điện thoại này ? ", "Xác nhận thêm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                dtBus.insertDienThoai(dt);
                dtPanel.setUpTable();
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
        }
    }//GEN-LAST:event_btn_add_dien_thoaiMouseClicked

    private void btn_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_returnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_cauHinh;
    private javax.swing.JButton btn_add_dien_thoai;
    private javax.swing.JButton btn_delete;
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
