/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.DienThoaiBUS;
import DAO.HeDieuHanhDAO;
import DAO.PhienBanDienThoaiDAO;
import DAO.ThuongHieuDAO;
import DTO.DienThoaiDTO;
import DTO.PhienBanDienThoaiDTO;
import GUI.Panel.PanelDienThoai;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class EditDienThoaiDialog extends javax.swing.JDialog {
    private DienThoaiBUS dtBus=new DienThoaiBUS();
    private Func_class func = new Func_class();
    private DienThoaiDTO dt;
    private PanelDienThoai dtPanel;
    private HashMap<String, Integer> mapHDH;
    private HashMap<String, Integer> mapThuongHieu;
    private ArrayList<PhienBanDienThoaiDTO> listPBDTTemp = new ArrayList<>();
    private ArrayList<PhienBanDienThoaiDTO> listPBDT;
    private String url_img;
    public EditDienThoaiDialog(java.awt.Frame parent, boolean modal, DienThoaiDTO dt, PanelDienThoai dtPanel) {
        super(parent, modal);
        initComponents();
        this.dtPanel = dtPanel;
        this.dt = dt;
        this.setLocationRelativeTo(null);
        this.setTitle("Chỉnh sửa thông tin điện thoại");
        this.setLocationRelativeTo(null);
         jtf_tenDT.setText(dt.getTenDT());
        mapHDH = new HeDieuHanhDAO().listMapHDH();
        String tenHDH=func.getKey(mapHDH, dt.getHeDieuHanh());
        cbb_HDH.setSelectedItem(tenHDH);
        mapThuongHieu=new ThuongHieuDAO().listMapThuongHieu();
        String tenThuongHieu=func.getKey(mapThuongHieu,dt.getThuongHieu());
        cbb_ThuongHieu.setSelectedItem(tenThuongHieu);
        jtf_chip.setText(dt.getChipXuLy());
        jtf_dungLuongPin.setText(String.valueOf(dt.getDungLuongPin()));
        jtf_kichThuocMan.setText(String.valueOf(dt.getKichThuocMan()));
        func.disPlayImage(jlabel_hinhAnh.getWidth(),jlabel_hinhAnh.getHeight(),dt.getHinhAnh(), jlabel_hinhAnh);
        fillComboboxHDH();
        fillComboboxThuongHieu();
    }
    //Hàm khởi tạo giá trị vào combobox thương hiệu

    public void fillComboboxThuongHieu() {
        mapThuongHieu = new ThuongHieuDAO().listMapThuongHieu();
        cbb_ThuongHieu.setBackground(Color.WHITE);
        for (String th : mapThuongHieu.keySet()) {
            cbb_ThuongHieu.addItem(th);
        }
    }

    //Hàm khởi tạo giá trị vào combobox hệ điều hành
    public void fillComboboxHDH() {
        mapHDH = new HeDieuHanhDAO().listMapHDH();
        cbb_HDH.setBackground(Color.WHITE);
        for (String hdh : mapHDH.keySet()) {
            cbb_HDH.addItem(hdh);
        }
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
        btn_add_Image = new javax.swing.JButton();
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
        jPanel5 = new javax.swing.JPanel();
        btn_save_edit_dt = new javax.swing.JButton();
        btn_edit_cauHinh = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Chỉnh Sửa Điện Thoại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel1)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_hinhAnh.setBackground(new java.awt.Color(255, 255, 255));

        btn_add_Image.setText("Chỉnh sửa ảnh");
        btn_add_Image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_ImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel_hinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btn_add_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(btn_add_Image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_hinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(cbb_ThuongHieu, 0, 130, Short.MAX_VALUE)
                    .addComponent(jtf_dungLuongPin)
                    .addComponent(cbb_HDH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
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
                    .addComponent(cbb_ThuongHieu)
                    .addComponent(jtf_tenDT, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
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
                    .addComponent(cbb_HDH, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jtf_kichThuocMan))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_save_edit_dt.setBackground(new java.awt.Color(153, 255, 153));
        btn_save_edit_dt.setText("Lưu Thông Tin");
        btn_save_edit_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_save_edit_dtMouseClicked(evt);
            }
        });

        btn_edit_cauHinh.setBackground(new java.awt.Color(102, 102, 255));
        btn_edit_cauHinh.setText("Sửa Cấu Hình");
        btn_edit_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit_cauHinhMouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setText("Hủy Bỏ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_save_edit_dt)
                .addGap(18, 18, 18)
                .addComponent(btn_edit_cauHinh)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save_edit_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_ImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_ImageMouseClicked
        JFileChooser jfilechoose = new JFileChooser();
        jfilechoose.setDialogTitle("Chọn ảnh");
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Hình ảnh", "png", "jpg", "Hinhanh", "dt");
        jfilechoose.setFileFilter(fileFilter);
        jfilechoose.setCurrentDirectory(new File("C://MyImage"));
        int resultF = jfilechoose.showOpenDialog(null);
        if (resultF == jfilechoose.APPROVE_OPTION) {
            File selectFile = jfilechoose.getSelectedFile();
            url_img = selectFile.getPath();
            jlabel_hinhAnh.setText("");
            func.disPlayImage(jlabel_hinhAnh.getWidth(), jlabel_hinhAnh.getHeight(), url_img, jlabel_hinhAnh);
        }
    }//GEN-LAST:event_btn_add_ImageMouseClicked

    private void btn_save_edit_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_save_edit_dtMouseClicked
        int result = check_edit_sanPham();
        if (result == 1) {
            String tenDT = jtf_tenDT.getText();
            HashMap<String, Integer> mapHeDieuHanh = new HeDieuHanhDAO().listMapHDH();
            int maHDH = mapHeDieuHanh.get(cbb_HDH.getSelectedItem().toString());
            HashMap<String, Integer> mapThuongHieu = new ThuongHieuDAO().listMapThuongHieu();
            int maThuongHieu = mapThuongHieu.get(cbb_ThuongHieu.getSelectedItem().toString());
            String chip = jtf_chip.getText();
            int dungLuongPin = Integer.parseInt(jtf_dungLuongPin.getText());
            double kichThuocMan = Double.parseDouble(jtf_kichThuocMan.getText());
            String hinhAnh = null;
            if (url_img == null) {
                hinhAnh = dt.getHinhAnh();
            } else {
                hinhAnh = url_img;
            }
            DienThoaiDTO dienThoai = new DienThoaiDTO(tenDT, maHDH, maThuongHieu, chip, dungLuongPin, kichThuocMan, hinhAnh);
            dienThoai.setMaDT(dt.getMaDT());
            dtBus.updateDienThoai(dienThoai);
            func.addDataTableDienThoai(dtBus.listDT(),dtPanel.getTableDienThoai());
            func.centerTable(dtPanel.getTableDienThoai());
        }
    }//GEN-LAST:event_btn_save_edit_dtMouseClicked

    private void btn_edit_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_cauHinhMouseClicked
        int maDT = dt.getMaDT();
        if (!listPBDTTemp.isEmpty()) {
            listPBDTTemp.clear();
        }
        listPBDT = new PhienBanDienThoaiDAO().listPhienBan();
        for (PhienBanDienThoaiDTO pb : listPBDT) {
            if (pb.getMaDT() == maDT) {
                listPBDTTemp.add(pb);
            }
        }
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditCauHinhDialog((Frame) parentWindow, true, maDT, listPBDTTemp, dtPanel).setVisible(true);
    }//GEN-LAST:event_btn_edit_cauHinhMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_Image;
    private javax.swing.JButton btn_edit_cauHinh;
    private javax.swing.JButton btn_save_edit_dt;
    private javax.swing.JComboBox<String> cbb_HDH;
    private javax.swing.JComboBox<String> cbb_ThuongHieu;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jlabel_hinhAnh;
    private javax.swing.JTextField jtf_chip;
    private javax.swing.JTextField jtf_dungLuongPin;
    private javax.swing.JTextField jtf_kichThuocMan;
    private javax.swing.JTextField jtf_tenDT;
    // End of variables declaration//GEN-END:variables
}
