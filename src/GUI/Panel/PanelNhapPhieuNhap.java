/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.ChiTietPhieuNhapBUS;
import BUS.DienThoaiBUS;
import BUS.MauSacBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhienBanDienThoaiBUS;
import BUS.PhieuNhapBUS;
import BUS.RamBUS;
import BUS.RomBUS;
import DAO.PhienBanDienThoaiDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.DienThoaiDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import GUI.GUIFrame.Main;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelNhapPhieuNhap extends javax.swing.JPanel {
    Func_class func=new Func_class();
    PhienBanDienThoaiDAO pbDao=new PhienBanDienThoaiDAO();
    Main main;
    DienThoaiBUS dtBus=new DienThoaiBUS();
    PhienBanDienThoaiBUS pbBus=new PhienBanDienThoaiBUS();
    NhaCungCapBUS nccBus=new NhaCungCapBUS();
    RamBUS ramBus=new RamBUS();
    RomBUS romBus=new RomBUS();
    MauSacBUS msBus=new MauSacBUS();
    NhanVienBUS nvBus=new NhanVienBUS();
    PhieuNhapBUS pnBus=new PhieuNhapBUS();
    ChiTietPhieuNhapBUS ctpnBus=new ChiTietPhieuNhapBUS();
    ActionListener eventAct;
    ActionListener eventActionHinhThucNhap;
    double tongTien=0;
    ArrayList<ChiTietPhieuNhapDTO> listCTPNTemp=new ArrayList<>();
    public PanelNhapPhieuNhap(Main main) {
        initComponents();
        this.main=main;
        PanelPhieuNhap pn=new PanelPhieuNhap(main);
        khoiTao();
    }
    public void khoiTao(){
        setUpTable();
        setIcon();
        setSizeJTF();
        setUpComBobox();
        fillComboboxHinhThucNhap();
        fillComboboxNhaCungCap();
        jtf_nv_nhap.setText("Hoàng Anh Huy");
        changeComboboxCauHinh(); 
        changeComboboxHinhThucNhap();
        setUpEnableSuaXoa();
    }
    public void setUpEnableSuaXoa() {
        if (listCTPNTemp.isEmpty()) {
            btn_update.setEnabled(false);
            btn_delete.setEnabled(false);
        }
        else{
            btn_update.setEnabled(true);
            btn_delete.setEnabled(true);
        }
    }
    public void setIcon(){
        btn_return.setIcon(new FlatSVGIcon("./resources/icon/left.svg",0.4f));
    }
    public void setSizeJTF(){
        jtf_maSp.setPreferredSize(new Dimension(30,10));
        jtf_tenSP.setPreferredSize(new Dimension(65,22));
        jtf_soLuong.setPreferredSize(new Dimension(30,10));
        jtf_giaNhap.setPreferredSize(new Dimension(65,22));
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
    public void fillComboboxHinhThucNhap(){
        String[] hinhThucNhap={"Nhập theo lô","Nhập từng máy"};
        for(String htn : hinhThucNhap){
            combobox_phuongThucNhap.addItem(htn);
        }
    }
    public void fillComboboxNhaCungCap(){
        combobox_ncc.setBackground(Color.WHITE);
        for(NhaCungCapDTO ncc : nccBus.listNCC()){
            combobox_ncc.addItem(ncc.getmaNCC()+"-"+ncc.getName());
        }
    }
    public void setUpComBobox() {
        combobox_cauHinh.setBackground(Color.WHITE);
        combobox_phuongThucNhap.setBackground(Color.WHITE);
    }
    public void setUpTable(){
        loadDataDienThoai(dtBus.listDT());
        loadDataChiTietPhieuNhap(listCTPNTemp);
        func.setUpTable(table_dt);
        func.setUpTable(table_thongTin_cauHinh);
        func.centerTable(table_dt);
        func.centerTable(table_thongTin_cauHinh);
    }
    public void setJTextFile(String idPN){
        this.jtf_maPN.setText(idPN);
        this.jtf_maPN.setEditable(false);
    }
    public int getSelectRow(){
        int vitriRow=table_dt.getSelectedRow();
        return vitriRow;
    }
    public void changeComboboxHinhThucNhap() {
        eventActionHinhThucNhap = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vitriRow = getSelectRow();
                if (vitriRow != -1) {
                    if (combobox_phuongThucNhap.getSelectedItem() != null) {
                        String strChoose = combobox_phuongThucNhap.getSelectedItem().toString();
                        if (strChoose.equals("Nhập từng máy"));
                        {
                            jtf_soLuong.setEnabled(false);
                        }
                        if (strChoose.equals("Nhập theo lô")) {
                            jtf_soLuong.setEnabled(true);
                        }
                    }
                }
            }
        };
        combobox_phuongThucNhap.addActionListener(eventActionHinhThucNhap);
    }
    public void changeComboboxCauHinh() {
        eventAct = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vitriRow = getSelectRow();
                if (vitriRow != -1) {
                    if (combobox_cauHinh.getSelectedItem() != null) {
                        String selectCauHinh = combobox_cauHinh.getSelectedItem().toString();
                        String[] parts = selectCauHinh.split("-");
                        int maDT = dtBus.getIDbyIndex(vitriRow);
                        int maRam = ramBus.getIDByDungLuongRam(Integer.parseInt(parts[0].replaceAll("GB","")));
                        int maRom = romBus.getIDByDungLuongRom(Integer.parseInt(parts[1].replaceAll("GB","")));
                        int maMau = msBus.getIDByTenMau(parts[2]);
                        double giaNhap = new PhienBanDienThoaiDAO().getGiaNhapByCauHinh(maDT, maRam, maRom, maMau);
                        String formatted = String.format("%.0f", giaNhap); 
                        jtf_giaNhap.setText(formatted);
                    }
                }
            }
        };
        combobox_cauHinh.addActionListener(eventAct);
    }
    public String[] getCauHinh(String cauHinh){
        String[] parts=cauHinh.split("-");
        parts[0]=parts[0].replaceAll("GB","");
        parts[1]=parts[1].replaceAll("GB","");
        return parts;
    }
    public void loadDataChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> listCTPN){
        String[] colNames={"Mã SP","Tên SP","Ram","Rom","Màu sắc","Đơn giá","Số lượng"};
        Object[][] rows=new Object[listCTPN.size()][colNames.length];
        for(int i=0;i<listCTPN.size();i++){
            rows[i][0]=pbDao.getMaDTByMaPhienBan(listCTPN.get(i).getMaPB());
            int maDT=Integer.parseInt(rows[i][0].toString());
            rows[i][1]=dtBus.getTenDTByID(maDT);
            int maRam=pbDao.getMaRamByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][2]=ramBus.getDungLuongRambyID(maRam);
            int maRom=pbDao.getMaRomByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][3]=romBus.getDungLuongRombyID(maRom);
            int maMau=pbDao.getMaMauByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][4]=msBus.getTenMauByID(maMau);
            rows[i][5]=String.format("%,.0f",listCTPN.get(i).getDongia());
            rows[i][6]=listCTPN.get(i).getSoluong();
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table_thongTin_cauHinh.setModel(model);
    }
    public void resetAll() {
        jtf_giaNhap.setText("");
        jtf_maSp.setText("");
        jtf_tenSP.setText("");
        jtf_soLuong.setText("");
        combobox_cauHinh.removeAllItems();
        if(combobox_phuongThucNhap.getSelectedItem()!=null)
            combobox_phuongThucNhap.removeAllItems();
        fillComboboxHinhThucNhap();
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
        jlabel_tongTien = new javax.swing.JLabel();
        btn_nhapHang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combobox_cauHinh = new javax.swing.JComboBox<>();
        jtf_giaNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtf_soLuong = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        combobox_phuongThucNhap = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();

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

        btn_nhapHang.setBackground(new java.awt.Color(204, 204, 204));
        btn_nhapHang.setText("Nhập hàng");
        btn_nhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhapHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(btn_nhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabel_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combobox_ncc, 0, 246, Short.MAX_VALUE)
                    .addComponent(jtf_nv_nhap)
                    .addComponent(jtf_maPN))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_tongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jLabel3.setText("Cấu hình");

        jLabel4.setText("Giá nhập");

        jLabel5.setText("Số lượng");

        btn_update.setBackground(new java.awt.Color(255, 204, 0));
        btn_update.setText("Sửa sản phẩm");

        btn_delete.setBackground(new java.awt.Color(255, 51, 51));
        btn_delete.setText("Xóa sản phẩm");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel11.setText("Phương thức nhập");

        btn_add.setBackground(new java.awt.Color(153, 255, 102));
        btn_add.setText("Thêm sản phẩm");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_return.setText("Quay lại");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(304, 304, 304))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_return, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_delete))
                                .addComponent(jLabel11)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtf_maSp, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jtf_soLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtf_tenSP, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jtf_giaNhap))))
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(combobox_phuongThucNhap, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                                .addComponent(combobox_cauHinh, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_maSp, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(jtf_tenSP))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox_phuongThucNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(btn_return, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
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
            int maRam = ramBus.getIDByDungLuongRam(Integer.parseInt(parts[0].replaceAll("GB","")));
            int maRom = romBus.getIDByDungLuongRom(Integer.parseInt(parts[1].replaceAll("GB","")));
            int maMau = msBus.getIDByTenMau(parts[2]);
            double giaNhap = new PhienBanDienThoaiDAO().getGiaNhapByCauHinh(maDT, maRam, maRom, maMau);
            jtf_giaNhap.setText(String.format("%,.0f", giaNhap));
        }
    }//GEN-LAST:event_table_dtMouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        int vitriRow=getSelectRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa điện thoại","Error",0);
            return;
        }
        int soLuong=-1;
        String hinhThucNhap=combobox_phuongThucNhap.getSelectedItem().toString();
        if(hinhThucNhap.equals("Nhập theo lô")){
            if(jtf_soLuong.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Bạn chưa nhập số lượng","Error",0);
                return;
            }
            else
                soLuong=Integer.parseInt(jtf_soLuong.getText());
        }
        if(hinhThucNhap.equals("Nhập từng máy")){
            soLuong=1;
        }
        String maPN=jtf_maPN.getText();
        double giaNhap=Double.parseDouble(jtf_giaNhap.getText().replaceAll(",",""));
        int maDT=Integer.parseInt(jtf_maSp.getText());
        String cauHinh=combobox_cauHinh.getSelectedItem().toString();
        String[] parts=getCauHinh(cauHinh);
        int dungLuongRam=Integer.parseInt(parts[0]);
        int maRam=ramBus.getIDByDungLuongRam(dungLuongRam);
        int dungLuongRom=Integer.parseInt(parts[1]);
        int maRom=romBus.getIDByDungLuongRom(dungLuongRom);
        String tenMau=parts[2];
        int maMau=msBus.getIDByTenMau(tenMau);
        int maPhienBan=pbDao.getMaPhienBanByCauHinh(maDT,maRam, maRom, maMau);
        double donGia=soLuong*giaNhap;
        tongTien+=donGia;
        jlabel_tongTien.setText(String.format("%,.0f",tongTien)+" VNĐ");
        ChiTietPhieuNhapDTO ctpn=new ChiTietPhieuNhapDTO(maPN, maPhienBan, soLuong, donGia, hinhThucNhap);
        listCTPNTemp.add(ctpn);
        loadDataChiTietPhieuNhap(listCTPNTemp);
        func.centerTable(table_thongTin_cauHinh);
        setUpEnableSuaXoa();
        resetAll();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_nhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhapHangActionPerformed
        if (!listCTPNTemp.isEmpty()) {
            String maPN = jtf_maPN.getText();
            int maNV = 1;
            String ncc = combobox_ncc.getSelectedItem().toString();
            String[] parts = ncc.split("-");
            int maNCC = Integer.parseInt(parts[0]);
            LocalDate dateNow = LocalDate.now();
            java.sql.Date dateNowSQL = java.sql.Date.valueOf(dateNow);
            tongTien = Double.parseDouble(jlabel_tongTien.getText().replaceAll(",", "").replaceAll("VNĐ", ""));
            PhieuNhapDTO pn = new PhieuNhapDTO(maPN, maNV, maNCC, dateNowSQL, tongTien);
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn nhập hàng", "Xác nhận xóa",
                     JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                pnBus.insertPhieuNhap(pn);
                for (ChiTietPhieuNhapDTO ctpn : listCTPNTemp) {
                    ctpnBus.insertCTPN(ctpn);
                    pbBus.updateSoLuongTon(ctpn.getMaPB(), ctpn.getSoluong());
                    dtBus.updateSoLuongTon(ctpn.getMaPB(), ctpn.getSoluong());
                }
                listCTPNTemp.clear();
                tongTien = 0;
                jlabel_tongTien.setText(tongTien + " VNĐ");
                loadDataChiTietPhieuNhap(listCTPNTemp);
                loadDataDienThoai(dtBus.listDT());
                main.getPanelNhapPN().setVisible(false);
                main.getPanelPhieuNhap().setUpTable();
                main.getPanelPhieuNhap().setVisible(true);
            }
        }
    }//GEN-LAST:event_btn_nhapHangActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int vitriRow=table_thongTin_cauHinh.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn cấu hình để xóa","Error",0);
            return;
        }
        tongTien=tongTien-listCTPNTemp.get(vitriRow).getDongia();
        jlabel_tongTien.setText(String.format("%,.0f",tongTien)+" VNĐ");
        listCTPNTemp.remove(vitriRow);
        setUpEnableSuaXoa();
        loadDataChiTietPhieuNhap(listCTPNTemp);
        func.centerTable(table_thongTin_cauHinh);
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        int vitriRow = table_dt.getSelectedRow();
        if (vitriRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn rời khỏi đây", "Xác nhận rời",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                listCTPNTemp.clear();
                resetAll();
                tongTien = 0;
                jlabel_tongTien.setText(tongTien + " VNĐ");
                main.getPanelNhapPN().setVisible(false);
                main.getPanelPhieuNhap().setVisible(true);
                loadDataChiTietPhieuNhap(listCTPNTemp);
            }
        } else {
            main.getPanelNhapPN().setVisible(false);
            main.getPanelPhieuNhap().setVisible(true);
        }
    }//GEN-LAST:event_btn_returnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_nhapHang;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combobox_cauHinh;
    private javax.swing.JComboBox<String> combobox_ncc;
    private javax.swing.JComboBox<String> combobox_phuongThucNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jlabel_tongTien;
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
