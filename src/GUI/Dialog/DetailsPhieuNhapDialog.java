/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.DienThoaiBUS;
import BUS.MauSacBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.RamBUS;
import BUS.RomBUS;
import DAO.PhienBanDienThoaiDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class DetailsPhieuNhapDialog extends javax.swing.JDialog {
    NhanVienBUS nvBus=new NhanVienBUS();
    NhaCungCapBUS nccBus=new NhaCungCapBUS();
    RamBUS ramBus=new RamBUS();
    RomBUS romBus=new RomBUS();
    MauSacBUS msBus=new MauSacBUS();
    DienThoaiBUS dtBus=new DienThoaiBUS();
    PhienBanDienThoaiDAO pbDao=new PhienBanDienThoaiDAO();
    ArrayList<ChiTietPhieuNhapDTO> listCTPN=new ArrayList<>();
    Func_class func=new Func_class();
    public DetailsPhieuNhapDialog(java.awt.Frame parent, boolean modal,ArrayList<ChiTietPhieuNhapDTO> listCTPN,PhieuNhapDTO pn) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Thông tin chi tiết phiếu nhập");
        this.listCTPN=listCTPN;
        jtf_maPN.setText(pn.getMaPhieuNhap());
        jtf_maPN.setEditable(false);
        jtf_nguoiNhap.setText(nvBus.getTenNVByID(pn.getNhanVien()));
        jtf_nguoiNhap.setEditable(false);
        jtf_nhacungcap.setText(nccBus.getTenNCCByID(pn.getNhaCungCap()));
        jtf_nhacungcap.setEditable(false);
        jtf_thoigian.setText(String.valueOf(pn.getNgayNhap()));
        jtf_thoigian.setEditable(false);
        setUpTable();
        setIcon();
    }
    public void setUpTable(){
        loadChiTietPhieuNhap(listCTPN);
        func.setUpTable(table_view_ctpn);
        func.centerTable(table_view_ctpn);
    }
    public void setIcon(){
        btn_return.setIcon(new FlatSVGIcon("./resources/icon/left.svg",0.35f));
    }
    public void loadChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
        String[] colNames = {"Mã SP", "Tên SP", "Ram", "Rom", "Màu sắc", "Đơn giá", "Số lượng"};
        Object[][] rows = new Object[listCTPN.size()][colNames.length];
        for (int i = 0; i < listCTPN.size(); i++) {
            rows[i][0]=pbDao.getMaDTByMaPhienBan(listCTPN.get(i).getMaPB());
            int maDT=Integer.parseInt(rows[i][0].toString());
            rows[i][1]=dtBus.getTenDTByID(maDT);
            int maRam=pbDao.getMaRamByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][2]=ramBus.getDungLuongRambyID(maRam);
            int maRom=pbDao.getMaRomByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][3]=romBus.getDungLuongRombyID(maRom);
            int maMau=pbDao.getMaMauByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][4]=msBus.getTenMauByID(maMau);
            rows[i][5]=String.format("%,.0f", listCTPN.get(i).getDongia());
            rows[i][6]=listCTPN.get(i).getSoluong();
        }
        DefaultTableModel model =new DefaultTableModel(rows,colNames);
        table_view_ctpn.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtf_maPN = new javax.swing.JTextField();
        jtf_nguoiNhap = new javax.swing.JTextField();
        jtf_nhacungcap = new javax.swing.JTextField();
        jtf_thoigian = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_view_ctpn = new javax.swing.JTable();
        btn_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mã phiếu nhập");

        jLabel3.setText("Thời gian tạo");

        jLabel4.setText("Người nhập");

        jLabel5.setText("Nhà cung cấp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_maPN, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtf_nguoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtf_nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_thoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_maPN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nhacungcap)
                    .addComponent(jtf_thoigian)
                    .addComponent(jtf_nguoiNhap, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
        );

        table_view_ctpn.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_view_ctpn);

        btn_return.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_return.setText("Quay lại");
        btn_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_return, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_returnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtf_maPN;
    private javax.swing.JTextField jtf_nguoiNhap;
    private javax.swing.JTextField jtf_nhacungcap;
    private javax.swing.JTextField jtf_thoigian;
    private javax.swing.JTable table_view_ctpn;
    // End of variables declaration//GEN-END:variables
}
