/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.DienThoaiBUS;
import BUS.HeDieuHanhBUS;
import BUS.ThuongHieuBUS;
import DAO.DienThoaiDAO;
import DTO.DienThoaiDTO;
import GUI.Dialog.AddDienThoaiDialog;
import GUI.Dialog.DetailsDienThoaiDialog;
import GUI.Dialog.EditDienThoaiDialog;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.DropShadowBorder;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelDienThoai extends javax.swing.JPanel {
    Func_class func=new Func_class();
    DienThoaiBUS dtBus=new DienThoaiBUS();
    HeDieuHanhBUS hdhBus=new HeDieuHanhBUS();
    ThuongHieuBUS thBus=new ThuongHieuBUS();
    public PanelDienThoai() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        setUpTable();
        setIconForJlabel();
        setCusorPointer();
        setShadowforJPN();
        khoitaoChooseFilterDT();
        setTextHidden();
        setUpJTF();
        setUpBtn();
        setUpCombobox();
    }
    public JTable getTableDienThoai(){
        return this.table_dt;
    }
    public void setUpBtn(){
        func.setUpBtn(btn_refresh_dt, Color.WHITE, new Color(220,220,220));
        func.setUpBtn(btn_look_dt, Color.WHITE, new Color(220,220,220));
    }
    public void setUpCombobox(){
        func.setUpComBoBox(combobox_find_dt);
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_find_dt);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_find_dt);
        PromptSupport.setForeground(Color.GRAY, jtf_find_dt);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_find_dt);
    }
    //Hàm khởi tạo lựa chọn cách lọc điện thoại
    public void khoitaoChooseFilterDT() {
        String[] filtersDT = {"Tất cả", "Tên điện thoại", "Hệ điều hành", "Thương hiệu", "Chip xử lý"};
        combobox_find_dt.setBackground(Color.WHITE);
        for (String nameFilterDT : filtersDT) {
            combobox_find_dt.addItem(nameFilterDT);
        }
    }
    //Hàm chỉnh sửa độ đẹp mắt của bảng
    public void setUpTable() {
        addDataTableDienThoai(dtBus.listDT());
        func.centerTable(table_dt);
        func.setUpTable(table_dt);
    }
    //Hàm chỉnh border của chức năng, tìm kiếm
    public void setShadowforJPN() {
        jpanel_chucNang_dt.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_dt.setBorder(new DropShadowBorder(2, Color.BLACK));
    }
    //Chỉnh icon cho các jlabel
    public void setIconForJlabel() {
        btn_look_dt.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.6f));
        jlabel_chiTiet_dt.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        btn_refresh_dt.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.25f));
        jlabel_excel.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg", 0.85f));
        jlabel_add_dt.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_dt.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_dt.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
    }
    public void setCusorPointer() {
        List<JLabel> jlabels =List.of(jlabel_add_dt,jlabel_update_dt,jlabel_delete_dt
        ,jlabel_excel,jlabel_chiTiet_dt);
        for(JLabel label : jlabels )
            func.cursorPointer(label);
    }
    //Hàm thêm dữ liệu vào bảng điện thoại
    public void addDataTableDienThoai(ArrayList<DienThoaiDTO> listDT) {
        String[] colNames = {"Mã ĐT", "Tên Điện Thoại", "Hệ điều hành", "Thương hiệu", "Chip xử lý", "Dung lượng pin", "Kích thước màn"};
        Object[][] rows = new Object[listDT.size()][colNames.length];
        for (int i = 0; i < listDT.size(); i++) {
            rows[i][0] = listDT.get(i).getMaDT();
            rows[i][1] = listDT.get(i).getTenDT();
            int maHDH = listDT.get(i).getHeDieuHanh();
            rows[i][2] = hdhBus.getTenByMaHDH(maHDH);
            int maThuongHieu = listDT.get(i).getThuongHieu();
            rows[i][3] = thBus.getTenByMaTH(maThuongHieu);
            rows[i][4] = listDT.get(i).getChipXuLy();
            rows[i][5] = listDT.get(i).getDungLuongPin() + "mAh";
            rows[i][6] = listDT.get(i).getKichThuocMan() + " inch";
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_dt.setModel(model);
        table_dt.getColumnModel().getColumn(0).setPreferredWidth(30);
        table_dt.getColumnModel().getColumn(1).setPreferredWidth(165);
        table_dt.getColumnModel().getColumn(4).setPreferredWidth(165);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_chucNang_dt = new javax.swing.JPanel();
        jlabel_delete_dt = new javax.swing.JLabel();
        jlabel_update_dt = new javax.swing.JLabel();
        jlabel_add_dt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlabel_excel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlabel_chiTiet_dt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_dt = new javax.swing.JTable();
        jpanel_timkiem_dt = new javax.swing.JPanel();
        jtf_find_dt = new javax.swing.JTextField();
        combobox_find_dt = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        btn_refresh_dt = new javax.swing.JButton();
        btn_look_dt = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 609));

        jlabel_delete_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_dtMouseClicked(evt);
            }
        });

        jlabel_update_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_dtMouseClicked(evt);
            }
        });

        jlabel_add_dt.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlabel_add_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_dtMouseClicked(evt);
            }
        });

        jLabel2.setText("  Thêm");
        jLabel2.setToolTipText("");

        jLabel3.setText("      Sửa");

        jLabel4.setText("    Xóa");

        jlabel_excel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_excelMouseClicked(evt);
            }
        });

        jLabel6.setText("Xuất Excel");

        jlabel_chiTiet_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTiet_dtMouseClicked(evt);
            }
        });

        jLabel7.setText(" Chi tiết");

        javax.swing.GroupLayout jpanel_chucNang_dtLayout = new javax.swing.GroupLayout(jpanel_chucNang_dt);
        jpanel_chucNang_dt.setLayout(jpanel_chucNang_dtLayout);
        jpanel_chucNang_dtLayout.setHorizontalGroup(
            jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jlabel_add_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_dtLayout.createSequentialGroup()
                        .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_chiTiet_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jpanel_chucNang_dtLayout.setVerticalGroup(
            jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                        .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel_chiTiet_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(13, Short.MAX_VALUE))
        );

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
        jScrollPane5.setViewportView(table_dt);

        jLabel17.setText("Tìm kiếm theo");

        btn_refresh_dt.setText("Làm mới");
        btn_refresh_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh_dtActionPerformed(evt);
            }
        });

        btn_look_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_look_dtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_timkiem_dtLayout = new javax.swing.GroupLayout(jpanel_timkiem_dt);
        jpanel_timkiem_dt.setLayout(jpanel_timkiem_dtLayout);
        jpanel_timkiem_dtLayout.setHorizontalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_dtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(combobox_find_dt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_look_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_refresh_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jpanel_timkiem_dtLayout.setVerticalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_dtLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_look_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refresh_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_delete_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_dtMouseClicked
        int vitriRow=table_dt.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn điện thoại để xóa","Error",0);
            return;
        }
        int maDT=Integer.parseInt(table_dt.getValueAt(vitriRow,0).toString());
        int confirm=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa điện thoại này không","Xác nhận xóa",
            JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            dtBus.deleteDienThoai(maDT);
            setUpTable();
        }
    }//GEN-LAST:event_jlabel_delete_dtMouseClicked

    private void jlabel_update_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_dtMouseClicked
        int vitriRow=table_dt.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn điện thoại để cập nhật","Error",0);
            return;
        }
        int maDT=Integer.parseInt(table_dt.getValueAt(vitriRow,0).toString());
        String tenDT=table_dt.getValueAt(vitriRow,1).toString();
        String tenHDH=table_dt.getValueAt(vitriRow,2).toString();
        int maHDH=hdhBus.getIDByTenHDH(tenHDH);
        String tenTH=table_dt.getValueAt(vitriRow,3).toString();
        int maThuongHieu=thBus.getIDByTenTH(tenTH);
        String tenChip=table_dt.getValueAt(vitriRow,4).toString();
        int dungLuongPin=Integer.parseInt(table_dt.getValueAt(vitriRow,5).toString().replaceAll("mAh",""));
        double kichThuocMan=Double.parseDouble(table_dt.getValueAt(vitriRow, 6).toString().replaceAll("inch",""));
        String hinhAnh=new DienThoaiDAO().getHinhAnh(maDT);
        DienThoaiDTO dt=new DienThoaiDTO(maDT,tenDT,maHDH,maThuongHieu,tenChip, dungLuongPin, kichThuocMan,hinhAnh,0);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditDienThoaiDialog((Frame) parentWindow, true,dt,this).setVisible(true);
    }//GEN-LAST:event_jlabel_update_dtMouseClicked

    private void jlabel_add_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_dtMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddDienThoaiDialog((Frame) parentWindow, true,this).setVisible(true);
    }//GEN-LAST:event_jlabel_add_dtMouseClicked

    private void jlabel_excelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_excelMouseClicked
        try {
            func.exportJTableToExcel(table_dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jlabel_excelMouseClicked

    private void jlabel_chiTiet_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTiet_dtMouseClicked
        int vitriRow = table_dt.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng để xem chi tiết", "Error", 0);
            return;
        }
        int maDT = Integer.parseInt(table_dt.getValueAt(vitriRow, 0).toString());
        String tenDT = table_dt.getValueAt(vitriRow, 1).toString();
        Object tenHDH= table_dt.getValueAt(vitriRow,2);
        int maHDH;
        if(tenHDH!=null){
            maHDH=hdhBus.getIDByTenHDH(tenHDH.toString());
        }
        else{
            maHDH=-1;
        }
        Object tenTH= table_dt.getValueAt(vitriRow,3);
        int maTH;
        if(tenTH!=null){
            maTH=thBus.getIDByTenTH(tenTH.toString());
        }
        else{
            maTH=-1;
        }
        String tenChip = table_dt.getValueAt(vitriRow, 4).toString();
        int dungLuongPin = Integer.parseInt(table_dt.getValueAt(vitriRow, 5).toString().replaceAll("mAh", ""));
        double kichThuocMan = Double.parseDouble(table_dt.getValueAt(vitriRow, 6).toString().replaceAll("inch", ""));
        String hinhAnh = new DienThoaiDAO().getHinhAnh(maDT);
        DienThoaiDTO dt = new DienThoaiDTO(maDT, tenDT, maHDH, maTH, tenChip, dungLuongPin, kichThuocMan, hinhAnh,0);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsDienThoaiDialog((Frame) parentWindow, true, dt).setVisible(true);
    }//GEN-LAST:event_jlabel_chiTiet_dtMouseClicked
           
    private void btn_refresh_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh_dtActionPerformed
        jtf_find_dt.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_refresh_dtActionPerformed

    private void btn_look_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_look_dtActionPerformed
        String type = combobox_find_dt.getSelectedItem().toString();
        String find_text = jtf_find_dt.getText().toLowerCase();
        addDataTableDienThoai(dtBus.timKiem(find_text, type));
        func.centerTable(table_dt);
    }//GEN-LAST:event_btn_look_dtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_look_dt;
    private javax.swing.JButton btn_refresh_dt;
    private javax.swing.JComboBox<String> combobox_find_dt;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlabel_add_dt;
    private javax.swing.JLabel jlabel_chiTiet_dt;
    private javax.swing.JLabel jlabel_delete_dt;
    private javax.swing.JLabel jlabel_excel;
    private javax.swing.JLabel jlabel_update_dt;
    private javax.swing.JPanel jpanel_chucNang_dt;
    private javax.swing.JPanel jpanel_timkiem_dt;
    private javax.swing.JTextField jtf_find_dt;
    private javax.swing.JTable table_dt;
    // End of variables declaration//GEN-END:variables
}
