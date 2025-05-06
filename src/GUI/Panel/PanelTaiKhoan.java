/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import GUI.Dialog.AddTaiKhoanDialog;
import GUI.Dialog.DetailsTaiKhoan;
import GUI.Dialog.EditTaiKhoanDialog;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.DropShadowBorder;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelTaiKhoan extends javax.swing.JPanel {
    Func_class func=new Func_class();
    TaiKhoanBUS tkBus=new TaiKhoanBUS();
    TaiKhoanDAO tkDao=new TaiKhoanDAO();
    public PanelTaiKhoan() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        setUpTable();
        setTextHidden();
        setUpBtn();
        setIconForJLabel();
        setUpJTF();
        setBorderJPANEL();
        setCursorPointer();
        setUpCbb();
        fillCBB();
    }
    public void fillCBB(){
        String[] items={"Tất cả","Mã NV","Tên tài khoản","Trạng thái TK"};
        for(String item : items){
            cbb_items.addItem(item);
        }
    }
    public void setUpTable(){
        loadData(tkBus.listTaiKhoan());
        func.centerTable(table_taiKhoan);
        func.setUpTable(table_taiKhoan);
    }
    public void setCursorPointer(){
        func.cursorPointer(jlabel_add);
        func.cursorPointer(jlabel_chiTiet);
        func.cursorPointer(jlabel_delete);
        func.cursorPointer(jlabel_update);
    }
    public void setIconForJLabel() {
        jlabel_add.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));  
        jlabel_chiTiet.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.45f));
        btn_look.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.65f));
        btn_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.25f));
    }
    public void setUpCbb(){
        func.setUpComBoBox(cbb_items);
    }
    public void setBorderJPANEL(){
        jPanel1.setBorder(new DropShadowBorder(1, Color.black));
        jPanel2.setBorder(new DropShadowBorder(1, Color.black));
    }
    public void setUpJTF(){
        func.setUpJTF(jtf_search);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_search);
        PromptSupport.setForeground(Color.GRAY, jtf_search);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_search);
    }
    public void setUpBtn(){
        func.setUpBtn(btn_refresh, Color.WHITE,new Color(220,220,220));
        func.setUpBtn(btn_look, Color.WHITE,new Color(220,220,220));
    }
    public void loadData(ArrayList<TaiKhoanDTO> listTK) {
        String[] colNames = {"Mã NV", "Tài khoản","Trạng thái"};
        Object[][] rows = new Object[listTK.size()][colNames.length];
        for (int i = 0; i < listTK.size(); i++) {
            rows[i][0]=listTK.get(i).getMaNV();
            rows[i][1]=listTK.get(i).getTenDangNhap();
            if(listTK.get(i).getTrangThai().equals("1")){
                rows[i][2]="Hoạt động";
            }
            if(listTK.get(i).getTrangThai().equals("0")){
                rows[i][2]="Ngưng hoạt động";
            }
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chỉnh sửa toàn bộ
            }
        };
        table_taiKhoan.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlabel_add = new javax.swing.JLabel();
        jlabel_update = new javax.swing.JLabel();
        jlabel_delete = new javax.swing.JLabel();
        jlabel_chiTiet = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtf_search = new javax.swing.JTextField();
        btn_look = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        cbb_items = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_taiKhoan = new javax.swing.JTable();

        jlabel_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_addMouseClicked(evt);
            }
        });

        jlabel_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_updateMouseClicked(evt);
            }
        });

        jlabel_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_deleteMouseClicked(evt);
            }
        });

        jlabel_chiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTietMouseClicked(evt);
            }
        });

        jLabel5.setText("  Thêm");

        jLabel6.setText("    Sửa");

        jLabel7.setText("    Xóa");

        jLabel8.setText(" Chi tiết");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_chiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_add, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_chiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btn_look.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lookActionPerformed(evt);
            }
        });

        btn_refresh.setText("Làm mới");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm kiếm theo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbb_items, 0, 137, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_look, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_search)
                    .addComponent(btn_look, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(cbb_items))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        table_taiKhoan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_taiKhoan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_addMouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddTaiKhoanDialog((Frame) parentWindow, true,this).setVisible(true);
    }//GEN-LAST:event_jlabel_addMouseClicked

    private void jlabel_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_updateMouseClicked
        int vitriRow=table_taiKhoan.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn tài khoản","Error",0);
            return;
        }
        int maNV=Integer.parseInt(table_taiKhoan.getValueAt(vitriRow,0).toString());
        TaiKhoanDTO tk=tkBus.getUserByMaNV(maNV);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditTaiKhoanDialog((Frame) parentWindow, true,this,tk).setVisible(true);
    }//GEN-LAST:event_jlabel_updateMouseClicked

    private void btn_lookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lookActionPerformed
        String textfind=jtf_search.getText();
        String type=cbb_items.getSelectedItem().toString();
        ArrayList<TaiKhoanDTO> listTKTemp =tkBus.timKiem(textfind, type);
        loadData(listTKTemp);
        func.centerTable(table_taiKhoan);
        func.setUpTable(table_taiKhoan);
    }//GEN-LAST:event_btn_lookActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        jtf_search.setText("");
        setUpTable();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void jlabel_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_deleteMouseClicked
        int vitriRow = table_taiKhoan.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản", "Error", 0);
            return;
        }
        int maNV = Integer.parseInt(table_taiKhoan.getValueAt(vitriRow, 0).toString());
        TaiKhoanDTO tk = tkBus.getTKIsLogin();
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa", "Xác nhận xóa", JOptionPane.YES_NO_OPTION,
                 JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            if (maNV == tk.getMaNV()) {
                JOptionPane.showMessageDialog(null, "Không thể xóa tài khoản đang đăng nhập", "Error", 0);
                return;
            }
            tkBus.deleteTaiKhoan(maNV);
            loadData(tkDao.listTaiKhoan());
            func.centerTable(table_taiKhoan);
        }
    }//GEN-LAST:event_jlabel_deleteMouseClicked

    private void jlabel_chiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTietMouseClicked
        int vitriRow=table_taiKhoan.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn tài khoản","Error",0);
            return;
        }
        int maNV=Integer.parseInt(table_taiKhoan.getValueAt(vitriRow,0).toString());
        TaiKhoanDTO tk=tkBus.getUserByMaNV(maNV);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsTaiKhoan((Frame) parentWindow, true,tk).setVisible(true);
    }//GEN-LAST:event_jlabel_chiTietMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_look;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<String> cbb_items;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_add;
    private javax.swing.JLabel jlabel_chiTiet;
    private javax.swing.JLabel jlabel_delete;
    private javax.swing.JLabel jlabel_update;
    private javax.swing.JTextField jtf_search;
    private javax.swing.JTable table_taiKhoan;
    // End of variables declaration//GEN-END:variables
}
