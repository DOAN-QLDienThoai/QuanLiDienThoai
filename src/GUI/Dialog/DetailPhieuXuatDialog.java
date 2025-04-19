/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Dialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import DTO.ChiTietPhieuXuatDTO;
import DTO.PhieuXuatDTO;
import DTO.KhachHangDTO;
import DAO.PhienBanDienThoaiDAO;
import DAO.KhachHangDAO;
import java.text.DecimalFormat;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;

/**
 *
 * @author LE MINH HUY
 */
public class DetailPhieuXuatDialog extends javax.swing.JPanel {

    /**
     * Creates new form DetailPhieuXuatDialog
     */
    public DetailPhieuXuatDialog() {
        initComponents();
        jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
    }
});


    }
    public void setMaPhieu(String ma) {
    jTextField1.setText(ma);
}

public void setNhanVien(String tenNV) {
    jTextField2.setText(tenNV);
}

public void setThoiGian(String tg) {
    jTextField3.setText(tg.replace("T", " "));
}

public void setKhachHang(String tenKH) {
    jTextField4.setText(tenKH);
}

public void loadChiTiet(ArrayList<ChiTietPhieuXuatDTO> ds) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    DecimalFormat formatter = new DecimalFormat("#,###");
    int stt = 1;
    for (ChiTietPhieuXuatDTO ct : ds) {
        String[] cauHinh = new PhienBanDienThoaiDAO().layCauHinhBangPhienBan(ct.getMaPhienBan());
        model.addRow(new Object[]{
            stt++,
            ct.getMaPhienBan(),
            ct.getTenSanPham(),
            cauHinh[1], // RAM
            cauHinh[0], // ROM
            cauHinh[2], // Màu
            ct.getSoLuong(),
            formatter.format(ct.getDonGia()) + "đ"
        });
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÔNG TIN PHIẾU XUẤT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(426, 426, 426))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Mã phiếu");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhân viên nhập");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Thời gian tạo");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Khách hàng");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "RAM", "ROM", "Màu sắc", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xuất file PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Hủy bỏ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
    // Mặc định mở thư mục Desktop
    File defaultDir = new File(System.getProperty("user.home"), "Desktop");

    // Tính số thứ tự tiếp theo trong thư mục
    int nextNum = getNextPDFNumber(defaultDir);

    // Mở cửa sổ chọn nơi lưu
    JFileChooser fileChooser = new JFileChooser(defaultDir);
    fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
    fileChooser.setSelectedFile(new File("phieuxuat_" + nextNum + ".pdf"));

    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection != JFileChooser.APPROVE_OPTION) return;

    File selectedFile = fileChooser.getSelectedFile();
    String filePath = selectedFile.getAbsolutePath();
    if (!filePath.toLowerCase().endsWith(".pdf")) {
        filePath += ".pdf";
    }

    // Tạo tài liệu PDF
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(filePath));
    document.open();

    BaseFont bf = BaseFont.createFont("resources/fonts/times.ttf", BaseFont.IDENTITY_H, true);
    Font fontHeader = new Font(bf, 25, Font.BOLD);             
    Font fontTitle = new Font(bf, 14, Font.BOLD);        
    Font fontNormal = new Font(bf, 12);
    Font fontItalic = new Font(bf, 12, Font.ITALIC);
    Font fontBoldItalic = new Font(bf, 12, Font.BOLDITALIC);

    // Tiêu đề trái - phải
    PdfPTable titleRow = new PdfPTable(2);
    titleRow.setWidthPercentage(100);
    titleRow.setWidths(new float[]{6f, 4f});

    PdfPCell leftTitle = new PdfPCell(new Phrase("HỆ THỐNG QUẢN LÝ ĐIỆN THOẠI NHÓM 4", fontTitle));
    leftTitle.setBorder(Rectangle.NO_BORDER);
    leftTitle.setHorizontalAlignment(Element.ALIGN_LEFT);

    String tgHienTai = java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    PdfPCell rightTime = new PdfPCell(new Phrase("Thời gian in phiếu: " + tgHienTai, fontNormal));
    rightTime.setBorder(Rectangle.NO_BORDER);
    rightTime.setHorizontalAlignment(Element.ALIGN_RIGHT);

    titleRow.addCell(leftTitle);
    titleRow.addCell(rightTime);
    document.add(titleRow);
    document.add(new Paragraph("\n", fontNormal));

    // Tiêu đề trung tâm
    Paragraph title = new Paragraph("THÔNG TIN PHIẾU XUẤT", fontHeader);
    title.setAlignment(Element.ALIGN_CENTER);
    title.setSpacingAfter(15);
    document.add(title);

    // Thông tin phiếu
    String maPX = jTextField1.getText();
    String tenKH = jTextField4.getText();
    String tenNV = jTextField2.getText();
    String tgNhap = jTextField3.getText();

    KhachHangDTO kh = new KhachHangDAO().layKhachHangTheoTen(tenKH);
    String diachi = kh != null ? kh.getAddress() : "Không rõ";
    String sdt = kh != null ? kh.getSDT() : "Không rõ";

    Paragraph thongtin = new Paragraph(String.format(
        "Mã phiếu: %s\nKhách hàng: %s   -   %s\nSĐT: %s\nNgười thực hiện: %s\nThời gian nhập: %s\n\n",
        maPX, tenKH, diachi, sdt, tenNV, tgNhap
    ), fontNormal);
    thongtin.setSpacingAfter(10);
    document.add(thongtin);

    // Bảng sản phẩm
    PdfPTable table = new PdfPTable(6);
    table.setWidths(new int[]{3, 3, 2, 2, 2, 3});
    table.setWidthPercentage(100);
    String[] headers = {"Tên sản phẩm", "Phiên bản", "Màu", "Giá", "Số lượng", "Tổng tiền"};
    for (String col : headers) {
        PdfPCell cell = new PdfPCell(new Phrase(col, fontTitle));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    double tong = 0;
    for (int i = 0; i < jTable1.getRowCount(); i++) {
        String tenSP = jTable1.getValueAt(i, 2).toString();
        String phienban = jTable1.getValueAt(i, 3) + " - " + jTable1.getValueAt(i, 4);
        String mausac = jTable1.getValueAt(i, 5).toString();
        int sl = Integer.parseInt(jTable1.getValueAt(i, 6).toString());
        String giaStr = jTable1.getValueAt(i, 7).toString().replace(",", "").replace("đ", "");
        double gia = Double.parseDouble(giaStr);
        double thanhtien = gia * sl;
        tong += thanhtien;

        table.addCell(new Phrase(tenSP, fontNormal));
        table.addCell(new Phrase(phienban, fontNormal));
        table.addCell(new Phrase(mausac, fontNormal));
        table.addCell(new Phrase(formatCurrency(gia), fontNormal));
        table.addCell(new Phrase(String.valueOf(sl), fontNormal));
        table.addCell(new Phrase(formatCurrency(thanhtien), fontNormal));
    }

    document.add(table);

    // Tổng tiền
    Paragraph total = new Paragraph("\nTổng thành tiền: " + formatCurrency(tong), fontTitle);
    total.setAlignment(Element.ALIGN_RIGHT);
    document.add(total);

    // Chữ ký
    document.add(new Paragraph("\n\n\n", fontNormal));
    PdfPTable tableKy = new PdfPTable(3);
    tableKy.setWidthPercentage(100f);
    PdfPCell[] cells = {
        new PdfPCell(new Phrase("Người lập phiếu", fontBoldItalic)),
        new PdfPCell(new Phrase("Người giao", fontBoldItalic)),
        new PdfPCell(new Phrase("Khách hàng", fontBoldItalic)),
        new PdfPCell(new Phrase("(Ký và ghi rõ họ tên)", fontNormal)),
        new PdfPCell(new Phrase("(Ký và ghi rõ họ tên)", fontNormal)),
        new PdfPCell(new Phrase("(Ký và ghi rõ họ tên)", fontNormal))
    };
    for (PdfPCell cell : cells) {
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        tableKy.addCell(cell);
    }
    document.add(tableKy);

    document.close();
    JOptionPane.showMessageDialog(this, "Xuất file PDF thành công!");

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Lỗi khi xuất PDF: " + e.getMessage());
}

    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.getWindowAncestor(this).dispose(); // đóng dialog
    }
    private String formatCurrency(double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(amount) + "đ";
    }
   private int getNextPDFNumber(File folder) {
        int max = 0;
        File[] files = folder.listFiles((dir, name) -> name.matches("phieuxuat_\\d+\\.pdf"));
        if (files != null) {
            for (File f : files) {
                String name = f.getName();
                String numberPart = name.replaceAll("[^\\d]", "");
                try {
                    int num = Integer.parseInt(numberPart);
                    if (num > max) max = num;
                } catch (NumberFormatException ignored) {}
            }
        }
        return max + 1;
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
