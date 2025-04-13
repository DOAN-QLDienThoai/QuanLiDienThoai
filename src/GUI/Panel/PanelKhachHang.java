/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import GUI.Dialog.AddKhachHangDialog;
import GUI.Dialog.DetailsKhachHangDialog;
import GUI.Dialog.DetailsNhaCungCapDialog;
import GUI.Dialog.EditKhachHangDialog;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Func_class;

/**
 *
 * @author kiman
 */
public class PanelKhachHang extends javax.swing.JPanel {
    private Func_class func = new Func_class();
    public PanelKhachHang() {
        initComponents();
        setUpTable();
        setIconForJLabel();
        setCursorPointer();
        cbb_search_kh.removeAllItems();
        cbb_search_kh.addItem("Tất cả");
        cbb_search_kh.addItem("Mã khách hàng");
        cbb_search_kh.addItem("Tên khách hàng");
        cbb_search_kh.addItem("Địa chỉ");
        cbb_search_kh.addItem("Số điện thoại");
        // Thiết lập giao diện hiện đại cho ComboBox
        cbb_search_kh.setBackground(Color.WHITE); // nền trắng
        cbb_search_kh.setForeground(Color.BLACK); // chữ đen
        cbb_search_kh.setFocusable(false); // bỏ viền focus xanh 
        cbb_search_kh.setPreferredSize(new Dimension(130, 35)); // kích thước chuẩn theo ảnh
        cbb_search_kh.setOpaque(true);
        cbb_search_kh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txt_search_kh.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        txt_search_kh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txt_search_kh.setPreferredSize(new Dimension(170, 30)); // chỉnh đẹp
        txt_search_kh.setPreferredSize(new Dimension(300, 100)); // chiều rộng
        txt_search_kh.setBackground(Color.WHITE); // nền trắng
        txt_search_kh.setForeground(Color.BLACK); // màu chữ
        txt_search_kh.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // viền xám nhạt
        txt_search_kh.setToolTipText("Nhập nội dung tìm kiếm..."); // như placeholder
        reset_kh.setText("Làm mới");
        reset_kh.setFocusPainted(false);
        reset_kh.setContentAreaFilled(false); // Nền trong suốt
        reset_kh.setOpaque(true);
        reset_kh.setBackground(Color.WHITE);
        reset_kh.setForeground(Color.BLACK);
        reset_kh.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true)); // Bo góc + viền xám nhẹ
        reset_kh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reset_kh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        reset_kh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg", 0.4f));
        reset_kh.setIconTextGap(10); // khoảng cách icon và chữ

        txt_search_kh.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchKhachHang();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchKhachHang();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchKhachHang();
            }
        });
    }

    public JTable getTableKhachHang(){
        return table_kh;
    }
    public void addDataTableKhachHang() {
        KhachHangDAO dao = new KhachHangDAO();
        ArrayList<KhachHangDTO> dsKH = dao.listKh();
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Ngày tham gia"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (KhachHangDTO kh : dsKH) {
            model.addRow(new Object[]{
                kh.getID(), kh.getName(), kh.getAddress(), kh.getSDT(), kh.getNgayThamGia()
            });
        }
        table_kh.setModel(model);
        JScrollBar verticalBar = jScrollPane4.getVerticalScrollBar();
        verticalBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE)); // chiều ngang thanh cuộn
        verticalBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(180, 180, 180); // màu thanh kéo
                this.trackColor = new Color(245, 245, 245); // màu nền thanh cuộn
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });

        // Thiết lập style cho tiêu đề bảng
        JTableHeader header = table_kh.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = new JLabel(value.toString());
                label.setFont(label.getFont().deriveFont(Font.BOLD)); // chữ đậm
                label.setHorizontalAlignment(SwingConstants.CENTER); // căn giữa
                label.setOpaque(true);
                label.setBackground(new Color(245, 245, 245)); // nền xám nhạt
                label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5)); // padding

                return label;
            }
        });
        func.centerTable(table_kh);
        // Định dạng hiển thị kiểu "phẳng đẹp" như ảnh bạn gửi:
        table_kh.getTableHeader().setReorderingAllowed(false);
        table_kh.getTableHeader().setResizingAllowed(false);

        table_kh.setShowGrid(true); // bật lưới
        table_kh.setGridColor(new Color(240, 240, 240)); // màu lưới nhạt (xám sáng)
        table_kh.setIntercellSpacing(new Dimension(0, 1)); // chỉ có đường ngang
        table_kh.setBorder(null); // không viền table
        jScrollPane4.setBorder(null); // không viền khung cuộn
        System.out.println("Đã cập nhật model table_kh với " + dsKH.size() + " dòng.");
    }
    public void setIconForJLabel() {
        jlabel_add_kh1.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_kh1.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_kh1.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_detail_kh1.setIcon(new FlatSVGIcon("./resources/icon/details.svg", 0.5f));
        jlabel_excel_kh1.setIcon(new FlatSVGIcon("./resources/icon/excel.svg", 0.5f));
    }
    public void setUpTable(){
        addDataTableKhachHang();
        func.centerTable(table_kh);
        func.setUpTable(table_kh);
    }
    public void setCursorPointer() {
        func.cursorPointer(jlabel_add_kh1);
        func.cursorPointer(jlabel_update_kh1);
        func.cursorPointer(jlabel_delete_kh1);
        func.cursorPointer(jlabel_excel_kh1);
        func.cursorPointer(jlabel_detail_kh1);
    }
    private void searchKhachHang() {
        String keyword = txt_search_kh.getText().trim().toLowerCase();
        String selectedFilter = (String) cbb_search_kh.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) table_kh.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_kh.setRowSorter(sorter);

        if (keyword.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }

        // Nếu chọn "Tất cả" thì tìm trong tất cả cột
        if ("Tất cả".equalsIgnoreCase(selectedFilter)) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
            return;
        }

        // Còn lại thì lọc theo cột cụ thể
        int columnIndex = switch (selectedFilter) {
            case "Mã khách hàng" ->
                0;
            case "Tên khách hàng" ->
                1;
            case "Địa chỉ" ->
                2;
            case "Số điện thoại" ->
                3;
            default ->
                -1;
        };

        if (columnIndex >= 0) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword, columnIndex));
        } else {
            sorter.setRowFilter(null);
        }
    }
    private void exportKhachHangToExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
        fileChooser.setSelectedFile(new File("DanhSachKhachHang.xlsx"));

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File fileToSave = fileChooser.getSelectedFile();
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.endsWith(".xlsx")) {
            fileToSave = new File(filePath + ".xlsx");
        }
        System.out.println("Đường dẫn lưu file: " + fileToSave.getAbsolutePath());
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("KhachHang");

            // Header
            Row header = sheet.createRow(0);
            for (int i = 0; i < table_kh.getColumnCount(); i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(table_kh.getColumnName(i));
            }

            // Data
            for (int row = 0; row < table_kh.getRowCount(); row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < table_kh.getColumnCount(); col++) {
                    Object value = table_kh.getValueAt(row, col);
                    Cell cell = excelRow.createCell(col);
                    cell.setCellValue(value != null ? value.toString() : "");
                }
            }

            // Auto resize
            for (int i = 0; i < table_kh.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            FileOutputStream fos = new FileOutputStream(fileToSave);
            workbook.write(fos);
            fos.close();

            JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_chucNang_kh1 = new javax.swing.JPanel();
        jlabel_update_kh1 = new javax.swing.JLabel();
        jlabel_add_kh1 = new javax.swing.JLabel();
        jlabel_delete_kh1 = new javax.swing.JLabel();
        jlabel_detail_kh1 = new javax.swing.JLabel();
        jlabel_excel_kh1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        reset_kh = new javax.swing.JButton();
        txt_search_kh = new javax.swing.JTextField();
        cbb_search_kh = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_kh = new javax.swing.JTable();

        jpanel_chucNang_kh1.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_update_kh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_kh1MouseClicked(evt);
            }
        });

        jlabel_add_kh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_kh1MouseClicked(evt);
            }
        });

        jlabel_delete_kh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_kh1MouseClicked(evt);
            }
        });

        jlabel_detail_kh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_detail_kh1MouseClicked(evt);
            }
        });

        jlabel_excel_kh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_excel_kh1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_kh1Layout = new javax.swing.GroupLayout(jpanel_chucNang_kh1);
        jpanel_chucNang_kh1.setLayout(jpanel_chucNang_kh1Layout);
        jpanel_chucNang_kh1Layout.setHorizontalGroup(
            jpanel_chucNang_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_kh1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_add_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_update_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_delete_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_detail_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_excel_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jpanel_chucNang_kh1Layout.setVerticalGroup(
            jpanel_chucNang_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_kh1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpanel_chucNang_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_excel_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_detail_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        reset_kh.setText("Làm mới");
        reset_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_khActionPerformed(evt);
            }
        });

        txt_search_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_khActionPerformed(evt);
            }
        });

        cbb_search_kh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbb_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        table_kh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"
            }
        ));
        jScrollPane4.setViewportView(table_kh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel_chucNang_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_update_kh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_kh1MouseClicked
        int vitriRow = table_kh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để sửa", "Error", 0);
            return;
        }
        String maKh = table_kh.getValueAt(vitriRow, 0).toString();
        String tenKh = table_kh.getValueAt(vitriRow, 1).toString();
        String diachiKh = table_kh.getValueAt(vitriRow, 2).toString();
        String  sdtKh= table_kh.getValueAt(vitriRow, 3).toString();
        String ngayThamGia = table_kh.getValueAt(vitriRow, 4).toString();
        java.sql.Date ngaySQL = java.sql.Date.valueOf(ngayThamGia);
        KhachHangDTO kh =new KhachHangDTO(maKh, tenKh, diachiKh, sdtKh, ngaySQL);
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new EditKhachHangDialog((Frame) parentWindow,true,kh,this).setVisible(true);
    }//GEN-LAST:event_jlabel_update_kh1MouseClicked

    private void jlabel_add_kh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_kh1MouseClicked
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new AddKhachHangDialog((Frame) parentWindow, true,this).setVisible(true);
    }//GEN-LAST:event_jlabel_add_kh1MouseClicked

    private void jlabel_delete_kh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_kh1MouseClicked
        int vitriRow = table_kh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng để xóa", "Error", 0);
            return;
        }
        String maKh = table_kh.getValueAt(vitriRow, 0).toString();
        new KhachHangDAO().deleteKhachHang(maKh);
        addDataTableKhachHang();
        func.centerTable(table_kh);
    }//GEN-LAST:event_jlabel_delete_kh1MouseClicked

    private void jlabel_detail_kh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_detail_kh1MouseClicked
        System.out.println(">> Clicked xem chi tiết");
        int viewIndex = table_kh.getSelectedRow();
        System.out.println("Selected Row (view): " + viewIndex);
        if (viewIndex == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng để xem chi tiết.");
            return;
        }
        int modelIndex = table_kh.convertRowIndexToModel(viewIndex);
        String id = table_kh.getModel().getValueAt(modelIndex, 0).toString();
        String name = table_kh.getModel().getValueAt(modelIndex, 1).toString();
        String address = table_kh.getModel().getValueAt(modelIndex, 2).toString();
        String sdt = table_kh.getModel().getValueAt(modelIndex, 3).toString();
        try {
            modelIndex = table_kh.convertRowIndexToModel(viewIndex);
            id = table_kh.getModel().getValueAt(modelIndex, 0).toString();
            name = table_kh.getModel().getValueAt(modelIndex, 1).toString();
            address = table_kh.getModel().getValueAt(modelIndex, 2).toString();
            sdt = table_kh.getModel().getValueAt(modelIndex, 3).toString();
            String ngayStr = table_kh.getModel().getValueAt(modelIndex, 4).toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(ngayStr);
            java.sql.Date ngayThamGia = new java.sql.Date(utilDate.getTime()); // ✅ Convert here
            KhachHangDTO kh = new KhachHangDTO(id, name, address, sdt, ngayThamGia);
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
        new DetailsKhachHangDialog((Frame) parentWindow, true,kh).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi mở chi tiết: " + e.getMessage());}
    }//GEN-LAST:event_jlabel_detail_kh1MouseClicked

    private void jlabel_excel_kh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_excel_kh1MouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
        fileChooser.setSelectedFile(new File("DanhSachKhachHang.xlsx"));
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File fileToSave = fileChooser.getSelectedFile();
        String filePath = fileToSave.getAbsolutePath();
        if (!filePath.endsWith(".xlsx")) {
            fileToSave = new File(filePath + ".xlsx");
        }
        System.out.println("Đường dẫn lưu file: " + fileToSave.getAbsolutePath());
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("KhachHang");
            Row header = sheet.createRow(0);
            for (int i = 0; i < table_kh.getColumnCount(); i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(table_kh.getColumnName(i));
            }
            for (int row = 0; row < table_kh.getRowCount(); row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < table_kh.getColumnCount(); col++) {
                    Object value = table_kh.getValueAt(row, col);
                    Cell cell = excelRow.createCell(col);
                    cell.setCellValue(value != null ? value.toString() : "");
                }
            }
            for (int i = 0; i < table_kh.getColumnCount(); i++) {
                sheet.autoSizeColumn(i);
            }

            FileOutputStream fos = new FileOutputStream(fileToSave);
            workbook.write(fos);
            fos.close();
            JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel: " + e.getMessage());
        }
    }//GEN-LAST:event_jlabel_excel_kh1MouseClicked

    private void reset_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_khActionPerformed
        txt_search_kh.setText("");
        cbb_search_kh.setSelectedIndex(0);
        addDataTableKhachHang();
        table_kh.setRowSorter(null);
    }//GEN-LAST:event_reset_khActionPerformed

    private void txt_search_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_khActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_khActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbb_search_kh;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlabel_add_kh1;
    private javax.swing.JLabel jlabel_delete_kh1;
    private javax.swing.JLabel jlabel_detail_kh1;
    private javax.swing.JLabel jlabel_excel_kh1;
    private javax.swing.JLabel jlabel_update_kh1;
    private javax.swing.JPanel jpanel_chucNang_kh1;
    private javax.swing.JButton reset_kh;
    private javax.swing.JTable table_kh;
    private javax.swing.JTextField txt_search_kh;
    // End of variables declaration//GEN-END:variables
}
