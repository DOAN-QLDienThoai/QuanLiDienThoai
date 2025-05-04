/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import DAO.HeDieuHanhDAO;
import DAO.ThuongHieuDAO;
import DTO.DienThoaiDTO;
import GUI.Panel.PanelDienThoai;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class AddDienThoaiDialog extends javax.swing.JDialog {
    Border border=BorderFactory.createEtchedBorder();
    private Func_class func=new Func_class();
    private DienThoaiDTO DTTemp;
    private String url_img;
    private PanelDienThoai dtPanel;
    public AddDienThoaiDialog(java.awt.Frame parent, boolean modal,PanelDienThoai dtPanel) {
        super(parent, modal);
        this.setTitle("Thêm điện thoại");
        initComponents();
        this.dtPanel=dtPanel;
        khoiTao();
        this.setLocationRelativeTo(null);
    }
    public void khoiTao(){
        fillCbbHDH();
        fillCbbThuongHieu();
        notAllowText();
        setUp();
    }
    public void notAllowText(){
        func.notAllowText(jtf_dungLuongPin);
        func.notAllowText(jtf_kichThuocMan);
    }
    public void setUp(){
        jpanel_image.setBorder(border);
        jpanel_info.setBorder(border);
        jpn_container.setBorder(border);
        jlabel_image_dt.setText("Không có hình ảnh");
        jlabel_image_dt.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa ngang
        jlabel_image_dt.setVerticalAlignment(SwingConstants.CENTER);
        func.setUpBtnTwo(btn_exit, Color.RED, Color.RED, new Color(211,218,211), 14);
        func.setUpBtnTwo(btn_tao_cauHinh ,Color.CYAN, Color.CYAN, new Color(211,218,211), 14);
    }
    public void fillCbbHDH(){
        HashMap<String,Integer> mapHDH=new HeDieuHanhDAO().listMapHDH();
        cbb_hdh.setBackground(Color.WHITE);
        for(String tenHDH:mapHDH.keySet()){
            cbb_hdh.addItem(tenHDH);
        }
    }
    public void fillCbbThuongHieu(){
        HashMap<String,Integer> mapThuongHieu=new ThuongHieuDAO().listMapThuongHieu();
        cbb_thuongHieu.setBackground(Color.WHITE);
        for(String th:mapThuongHieu.keySet()){
            cbb_thuongHieu.addItem(th);
        }
    }
    public int check_add_sanPham(){
        if (jlabel_image_dt.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hình ảnh trước khi thêm!", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if(jtf_tensp.getText().equals("")){
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

        jpn_container = new javax.swing.JPanel();
        jpanel_info = new javax.swing.JPanel();
        jtf_tensp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbb_hdh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbb_thuongHieu = new javax.swing.JComboBox<>();
        jtf_dungLuongPin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtf_chip = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtf_kichThuocMan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jpanel_image = new javax.swing.JPanel();
        jlabel_image_dt = new javax.swing.JLabel();
        btn_addImage = new javax.swing.JButton();
        btn_tao_cauHinh = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm điện thoại");

        jpn_container.setBackground(new java.awt.Color(255, 255, 255));

        jpanel_info.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Thương hiệu");

        jLabel6.setText("Hệ điều hành");

        jLabel7.setText("Dung lượng pin");

        jLabel8.setText("Chip xử lý");

        jLabel9.setText("Kích thước màn");

        javax.swing.GroupLayout jpanel_infoLayout = new javax.swing.GroupLayout(jpanel_info);
        jpanel_info.setLayout(jpanel_infoLayout);
        jpanel_infoLayout.setHorizontalGroup(
            jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_infoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanel_infoLayout.createSequentialGroup()
                        .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanel_infoLayout.createSequentialGroup()
                                .addComponent(jtf_kichThuocMan, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(108, 108, 108))
                            .addGroup(jpanel_infoLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanel_infoLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addComponent(cbb_hdh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpanel_infoLayout.createSequentialGroup()
                        .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtf_chip, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_tensp)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanel_infoLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanel_infoLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtf_dungLuongPin)))
                            .addGroup(jpanel_infoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbb_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(86, 86, 86))
        );
        jpanel_infoLayout.setVerticalGroup(
            jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpanel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_infoLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_chip, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_kichThuocMan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jpanel_infoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_dungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbb_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jpanel_image.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_image_dt.setBackground(new java.awt.Color(255, 255, 255));

        btn_addImage.setText("Hình minh họa");
        btn_addImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_imageLayout = new javax.swing.GroupLayout(jpanel_image);
        jpanel_image.setLayout(jpanel_imageLayout);
        jpanel_imageLayout.setHorizontalGroup(
            jpanel_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel_image_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpanel_imageLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btn_addImage, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jpanel_imageLayout.setVerticalGroup(
            jpanel_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_imageLayout.createSequentialGroup()
                .addComponent(btn_addImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_image_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_tao_cauHinh.setBackground(new java.awt.Color(102, 153, 255));
        btn_tao_cauHinh.setText("Tạo Cấu Hình");
        btn_tao_cauHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tao_cauHinhMouseClicked(evt);
            }
        });

        btn_exit.setBackground(new java.awt.Color(255, 51, 51));
        btn_exit.setText("Hủy bỏ");
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpn_containerLayout = new javax.swing.GroupLayout(jpn_container);
        jpn_container.setLayout(jpn_containerLayout);
        jpn_containerLayout.setHorizontalGroup(
            jpn_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_containerLayout.createSequentialGroup()
                .addGroup(jpn_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_containerLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jpanel_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanel_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpn_containerLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(btn_tao_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jpn_containerLayout.setVerticalGroup(
            jpn_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_containerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpn_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpn_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tao_cauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Thêm Điện Thoại");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(331, 331, 331))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpn_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpn_container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addImageMouseClicked
        JFileChooser jfilechoose=new JFileChooser();
        jfilechoose.setDialogTitle("Chọn ảnh");
        FileNameExtensionFilter fileFilter=new FileNameExtensionFilter("Hình ảnh","png","jpg","Hinhanh","dt");
        jfilechoose.setFileFilter(fileFilter);
        jfilechoose.setCurrentDirectory(new File("C://MyImage"));
        int resultF=jfilechoose.showOpenDialog(null);
        if(resultF==jfilechoose.APPROVE_OPTION){
            File selectFile=jfilechoose.getSelectedFile();
            url_img=selectFile.getPath();
            jlabel_image_dt.setText("");
            func.disPlayImage(jlabel_image_dt.getWidth(),jlabel_image_dt.getHeight(), url_img, jlabel_image_dt);
        }
    }//GEN-LAST:event_btn_addImageMouseClicked

    private void btn_tao_cauHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tao_cauHinhMouseClicked
        int result = check_add_sanPham();
        if (result == 1) {
            String tenDT = jtf_tensp.getText();
            HashMap<String, Integer> mapHeDieuHanh = new HeDieuHanhDAO().listMapHDH();
            int maHDH = mapHeDieuHanh.get(cbb_hdh.getSelectedItem().toString());
            HashMap<String, Integer> mapThuongHieu = new ThuongHieuDAO().listMapThuongHieu();
            int maThuongHieu = mapThuongHieu.get(cbb_thuongHieu.getSelectedItem().toString());
            String chip = jtf_chip.getText();
            int dungLuongPin = Integer.parseInt(jtf_dungLuongPin.getText());
            double kichThuocMan = Double.parseDouble(jtf_kichThuocMan.getText());
            String hinhanh = url_img;
            this.DTTemp = new DienThoaiDTO(tenDT, maHDH, maThuongHieu, chip, dungLuongPin, kichThuocMan, hinhanh);
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
            new AddCauHinhDialog((Frame) parentWindow, true, DTTemp, dtPanel, this).setVisible(true);
        }
    }//GEN-LAST:event_btn_tao_cauHinhMouseClicked

    private void btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMouseClicked
        this.dispose();
        AddCauHinhDialog.listPBDTTemp.clear();
    }//GEN-LAST:event_btn_exitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addImage;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_tao_cauHinh;
    private javax.swing.JComboBox<String> cbb_hdh;
    private javax.swing.JComboBox<String> cbb_thuongHieu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlabel_image_dt;
    private javax.swing.JPanel jpanel_image;
    private javax.swing.JPanel jpanel_info;
    private javax.swing.JPanel jpn_container;
    private javax.swing.JTextField jtf_chip;
    private javax.swing.JTextField jtf_dungLuongPin;
    private javax.swing.JTextField jtf_kichThuocMan;
    private javax.swing.JTextField jtf_tensp;
    // End of variables declaration//GEN-END:variables
}
