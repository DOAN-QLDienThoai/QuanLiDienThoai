/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.ChiTietPhieuNhapBUS;
import BUS.DienThoaiBUS;
import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import GUI.Dialog.DetailsPhieuNhapDialog;
import GUI.GUIFrame.Main;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.prompt.PromptSupport;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelPhieuNhap extends javax.swing.JPanel {
    Func_class func=new Func_class();
    NhaCungCapBUS nccBus=new NhaCungCapBUS();
    NhanVienBUS nvBus=new NhanVienBUS();
    PhieuNhapBUS pnBus=new PhieuNhapBUS();
    DienThoaiBUS dtBus=new DienThoaiBUS();
    ChiTietPhieuNhapBUS ctpnBus=new ChiTietPhieuNhapBUS();
    Main main;
    public PanelPhieuNhap(Main main) {
        initComponents();
        System.out.println("GUI.Panel.PanelPhieuNhap.<init>()");
        khoiTao();
        this.main=main;
    }
    public void khoiTao(){
        setUpTable();
        locPrice();
        setIconForJLabel();
        setCursorPointer();
        fillComboboxTimKiem();
        setTextHidden();
    }
    public void setUpTable(){
        loadDataPhieuNhap(pnBus.listPN());
        func.setUpTable(table_pn);
        func.centerTable(table_pn);
    }
    public void setTextHidden(){
        PromptSupport.setPrompt("Tìm kiếm nhanh", jtf_search_dt);
        PromptSupport.setForeground(Color.GRAY, jtf_search_dt);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_search_dt);
        PromptSupport.setPrompt("Giá từ", jtf_giaTu);
        PromptSupport.setForeground(Color.GRAY, jtf_giaTu);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_giaTu);
        PromptSupport.setPrompt("Giá đến", jtf_giaDen);
        PromptSupport.setForeground(Color.GRAY, jtf_giaDen);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jtf_giaDen);
    }
    public void setIconForJLabel(){
        jlabel_add_pn.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.05f));
        jlabel_delete_pn.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.7f));
        jlabel_chiTiet_pn.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.4f));
        jlabel_excel_pn.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg", 0.8f));
        jlabel_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.25f));
    }
    public void setCursorPointer(){
        func.cursorPointer(jlabel_add_pn);
        func.cursorPointer(jlabel_delete_pn);
        func.cursorPointer(jlabel_chiTiet_pn);
        func.cursorPointer(jlabel_excel_pn);
    }
    public void fillComboboxTimKiem(){
        String[] strs={"Tất cả","Mã phiếu nhập","Nhà cung cấp","Nhân viên","Thời gian","Tổng tiền"};
        combobox_searchDT.setBackground(Color.WHITE);
        for(String str:strs){
            combobox_searchDT.addItem(str);
        }
    }
    public void loadDataPhieuNhap(ArrayList<PhieuNhapDTO> listPN){
        String[] colNames={"Mã phiếu nhập","Tên nhà cung cấp","Nhân viên nhập","Ngày nhập","Tổng tiền"};
        Object[][] rows=new Object[listPN.size()][colNames.length];
        for(int i=0;i<listPN.size();i++){
            rows[i][0]=listPN.get(i).getMaPhieuNhap();
            int maNCC=listPN.get(i).getNhaCungCap();
            rows[i][1]=nccBus.getTenNCCByID(maNCC);
            int maNV=listPN.get(i).getNhanVien();
            rows[i][2]=nvBus.getTenNVByID(maNV);
            rows[i][3]=listPN.get(i).getNgayNhap();
            rows[i][4]=String.format("%,.0f", listPN.get(i).getTongTien());
        }
        DefaultTableModel model=new DefaultTableModel(rows,colNames);
        table_pn.setModel(model);
    }
    public String createIDPhieuNhapTuDong(){
        String newID=null;
        int maxID=0;
        for(PhieuNhapDTO pn : pnBus.listPNFull()){
            try {
                String maxNumberStr=pn.getMaPhieuNhap().replaceAll("PN","");
                int maxNumber=Integer.parseInt(maxNumberStr);
                if (maxNumber > maxID) {
                        maxID = maxNumber;
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        newID = String.format("PN%03d", maxID + 1);
        return newID;
    }
    public void locPrice() {
        DocumentListener listener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {
            locTheoGia();
        }

        public void removeUpdate(DocumentEvent e) {
            locTheoGia();
        }

        public void changedUpdate(DocumentEvent e) {
            locTheoGia();
        }
    };

    jtf_giaTu.getDocument().addDocumentListener(listener);
    jtf_giaDen.getDocument().addDocumentListener(listener);
    jtf_search_dt.getDocument().addDocumentListener(listener);
    }
    private void locTheoGia() {
        String keyword = jtf_search_dt.getText().trim().toLowerCase();
        String selectedFilter = (String) combobox_searchDT.getSelectedItem();

        String textTu = jtf_giaTu.getText().trim();
        String textDen = jtf_giaDen.getText().trim();

        double min = 0;
        double max = Double.MAX_VALUE;

        try {
            if (!textTu.isEmpty()) {
                min = Double.parseDouble(textTu);
            }
            if (!textDen.isEmpty()) {
                max = Double.parseDouble(textDen);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá nhập không hợp lệ!");
            return;
        }

        final double giaTu = min;
        final double giaDen = max;

        DefaultTableModel model = (DefaultTableModel) table_pn.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_pn.setRowSorter(sorter);

        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        // --- Lọc theo từ khóa ---
        if (!keyword.isEmpty()) {
            if ("Tất cả".equalsIgnoreCase(selectedFilter)) {
                filters.add(RowFilter.regexFilter("(?i)" + keyword)); // tất cả cột
            } else {
                int columnIndex = switch (selectedFilter) {
                    case "Mã phiếu nhập" ->
                        0;
                    case "Nhà cung cấp" ->
                        1;
                    case "Nhân viên" ->
                        2;
                    case "Thời gian" ->
                        3;
                    default ->
                        -1;
                };
                if (columnIndex >= 0) {
                    filters.add(RowFilter.regexFilter("(?i)" + keyword, columnIndex));
                }
            }
        }

        // --- Lọc theo giá ---
        int columnGia = 4; // cột chứa giá trị giá
        filters.add(new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends Object, ? extends Object> entry) {
                try {
                    String giaStr = entry.getValue(columnGia).toString().replaceAll("[^\\d]", "");
                    if (giaStr.isEmpty()) {
                        return false;
                    }
                    double gia = Double.parseDouble(giaStr);
                    return gia >= giaTu && gia <= giaDen;
                } catch (Exception e) {
                    return false;
                }
            }
        });

        sorter.setRowFilter(RowFilter.andFilter(filters));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jlabel_excel_pn = new javax.swing.JLabel();
        jlabel_chiTiet_pn = new javax.swing.JLabel();
        jlabel_delete_pn = new javax.swing.JLabel();
        jlabel_add_pn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        combobox_searchDT = new javax.swing.JComboBox<>();
        jtf_search_dt = new javax.swing.JTextField();
        jlabel_refresh = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jtf_giaTu = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jtf_giaDen = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_pn = new javax.swing.JTable();

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));

        jLabel26.setText("Xóa phiếu");

        jLabel29.setText(" Chi tiết");

        jLabel30.setText("Xuất Excel");

        jlabel_excel_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_excel_pnMouseClicked(evt);
            }
        });

        jlabel_chiTiet_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTiet_pnMouseClicked(evt);
            }
        });

        jlabel_delete_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_pnMouseClicked(evt);
            }
        });

        jlabel_add_pn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_pnMouseClicked(evt);
            }
        });

        jLabel6.setText("  Thêm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_add_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlabel_chiTiet_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_excel_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel30)))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_excel_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_chiTiet_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel30)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jlabel_refresh.setText("Làm mới");
        jlabel_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlabel_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combobox_searchDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_search_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobox_searchDT, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_search_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Theo giá"));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Từ");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Đến");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jtf_giaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jtf_giaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        table_pn.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table_pn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlabel_refreshActionPerformed
        jtf_giaDen.setText("");
        jtf_giaTu.setText("");
        jtf_search_dt.setText("");
        loadDataPhieuNhap(pnBus.listPN());
        func.setUpTable(table_pn);
        func.centerTable(table_pn);
    }//GEN-LAST:event_jlabel_refreshActionPerformed
    
    private void jlabel_add_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_pnMouseClicked
        System.out.println("hahahah");
        main.getPanelPhieuNhap().setVisible(false);
        main.getPanelNhapPN().setVisible(true);
        main.getPanelNhapPN().setUpTable();
        main.getPanelNhapPN().resetAll();
        String idNew=createIDPhieuNhapTuDong();
        main.getPanelNhapPN().setJTextFile(idNew);
        main.getPanelNhapPN().setUpEnableSuaXoa();
    }//GEN-LAST:event_jlabel_add_pnMouseClicked
    //Xem chi tiết phiếu nhập
    private void jlabel_chiTiet_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTiet_pnMouseClicked
        int vitriRow=table_pn.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn phiếu nhập để xem chi tiết","Error",0);
            return;
        }
        String maPN=table_pn.getValueAt(vitriRow,0).toString();
        ArrayList<ChiTietPhieuNhapDTO> listCTPN=ctpnBus.getArrListCTPNByMaPN(maPN);
        PhieuNhapDTO pn=pnBus.getPhieuNhapByID(maPN);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsPhieuNhapDialog((Frame) parentWindow, true,listCTPN,pn).setVisible(true);
        
    }//GEN-LAST:event_jlabel_chiTiet_pnMouseClicked

    private void jlabel_excel_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_excel_pnMouseClicked
        try {
            Func_class.exportJTableToExcel(table_pn);
        } catch (IOException ex) {
            Logger.getLogger(PanelPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlabel_excel_pnMouseClicked

    private void jlabel_delete_pnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_pnMouseClicked
        int vitriRow=table_pn.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn phiếu nhập để xóa","Error",0);
            return;
        }
        String maPN=table_pn.getValueAt(vitriRow,0).toString();
        int confirm=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn hủy phiếu nhập này","Xác nhận hủy"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            pnBus.deletePhieuNhap(maPN);
            loadDataPhieuNhap(pnBus.listPN());
            func.centerTable(table_pn);
            //main.getPanelNhapPN().loadDataDienThoai(dtBus.listDT());
        }
    }//GEN-LAST:event_jlabel_delete_pnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobox_searchDT;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlabel_add_pn;
    private javax.swing.JLabel jlabel_chiTiet_pn;
    private javax.swing.JLabel jlabel_delete_pn;
    private javax.swing.JLabel jlabel_excel_pn;
    private javax.swing.JButton jlabel_refresh;
    private javax.swing.JTextField jtf_giaDen;
    private javax.swing.JTextField jtf_giaTu;
    private javax.swing.JTextField jtf_search_dt;
    private javax.swing.JTable table_pn;
    // End of variables declaration//GEN-END:variables
}
