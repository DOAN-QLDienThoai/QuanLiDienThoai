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
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    public DetailsPhieuNhapDialog(java.awt.Frame parent, boolean modal, ArrayList<ChiTietPhieuNhapDTO> listCTPN, PhieuNhapDTO pn) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Thông tin chi tiết phiếu nhập");
        this.listCTPN = listCTPN;
        jtf_maPN.setText(pn.getMaPhieuNhap());
        jtf_maPN.setEditable(false);
        jtf_nguoiNhap.setText(nvBus.getTenNVByID(pn.getNhanVien()));
        jtf_nguoiNhap.setEditable(false);
        jtf_nhacungcap.setText(nccBus.getTenNCCByID(pn.getNhaCungCap()));
        jtf_nhacungcap.setEditable(false);
        jtf_thoigian.setText(String.valueOf(pn.getNgayNhap()));
        jtf_thoigian.setEditable(false);
        khoiTao();
    }
    public void khoiTao(){
        setUpTable();
        setIcon();
        setUpBtn();
    }
    public void setUpTable() {
        loadChiTietPhieuNhap(listCTPN);
        func.setUpTable(table_view_ctpn);
        func.centerTable(table_view_ctpn);
    }
    
    public void setUpBtn(){
        func.setUpBtnTwo(btn_return, Color.ORANGE, Color.ORANGE,new Color(211,218,211),15);
        func.setUpBtnTwo(btn_xuatPDF, Color.RED, Color.RED, new Color(211,218,211),15);
    }
    public void setIcon() {
        btn_return.setIcon(new FlatSVGIcon("./resources/icon/left.svg", 0.35f));
        btn_xuatPDF.setIcon(new FlatSVGIcon("./resources/icon/PDF.svg", 0.03f));
    }

    public void loadChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
        String[] colNames = {"Mã SP", "Tên SP", "Ram", "Rom", "Màu sắc", "Đơn giá", "Số lượng"};
        Object[][] rows = new Object[listCTPN.size()][colNames.length];
        for (int i = 0; i < listCTPN.size(); i++) {
            rows[i][0] = pbDao.getMaDTByMaPhienBan(listCTPN.get(i).getMaPB());
            int maDT = Integer.parseInt(rows[i][0].toString());
            System.out.println(maDT);
            rows[i][1] = dtBus.getTenDTByID(maDT);
            int maRam = pbDao.getMaRamByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][2] = ramBus.getDungLuongRambyID(maRam);
            int maRom = pbDao.getMaRomByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][3] = romBus.getDungLuongRombyID(maRom);
            int maMau = pbDao.getMaMauByMaPhienBan(listCTPN.get(i).getMaPB());
            rows[i][4] = msBus.getTenMauByID(maMau);
            rows[i][5] = String.format("%,.0f", listCTPN.get(i).getDongia());
            rows[i][6] = listCTPN.get(i).getSoluong();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tắt chỉnh sửa toàn bộ
            }
        };
        table_view_ctpn.setModel(model);
        table_view_ctpn.getColumnModel().getColumn(0).setPreferredWidth(30);
        table_view_ctpn.getColumnModel().getColumn(1).setPreferredWidth(180);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_view_ctpn = new javax.swing.JTable();
        btn_return = new javax.swing.JButton();
        btn_xuatPDF = new javax.swing.JButton();
        jtf_nguoiNhap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_maPN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtf_thoigian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_nhacungcap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        btn_xuatPDF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xuatPDF.setText("Xuất PDF");
        btn_xuatPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatPDFActionPerformed(evt);
            }
        });

        jLabel4.setText("Người nhập");

        jLabel1.setText("Mã phiếu nhập");

        jLabel3.setText("Thời gian tạo");

        jtf_nhacungcap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nhacungcapActionPerformed(evt);
            }
        });

        jLabel5.setText("Nhà cung cấp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(btn_xuatPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_maPN, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_nguoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_thoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_maPN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nguoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_thoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xuatPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_returnMouseClicked

    private void btn_xuatPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatPDFActionPerformed

        // TODO add your handling code here:
        try {
            File defaultDir = new File("C:\\pdfPhieuNhap");

            int nextNum = getNextPDFNumber(defaultDir);
            JFileChooser fileChooser = new JFileChooser(defaultDir);
            fileChooser.setDialogTitle("Chọn nơi lưu file PDF");
            fileChooser.setSelectedFile(new File("phieuxuat_" + nextNum + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            BaseFont bf = BaseFont.createFont("resources/fonts/times.ttf", BaseFont.IDENTITY_H, true);
            Font fontHeader = new Font(bf, 25, Font.BOLD);
            Font fontTitle = new Font(bf, 14, Font.BOLD);
            Font fontNormal = new Font(bf, 12);
            Font fontBoldItalic = new Font(bf, 12, Font.BOLDITALIC);

            // Header
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

            // Tiêu đề
            Paragraph title = new Paragraph("THÔNG TIN PHIẾU NHẬP", fontHeader);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(15);
            document.add(title);

            // Thông tin chung
            String maPN = jtf_maPN.getText().trim();
            String tenNCC = jtf_nhacungcap.getText().trim();
            String tenNV = jtf_nguoiNhap.getText().trim();
            String tgNhap = jtf_thoigian.getText().trim();

            Paragraph thongtin = new Paragraph(String.format(
                    "Mã phiếu: %s\nNhà cung cấp: %s\nNgười thực hiện: %s\nThời gian nhập: %s\n\n",
                    maPN, tenNCC, tenNV, tgNhap
            ), fontNormal);
            thongtin.setSpacingAfter(10);
            document.add(thongtin);

            // Bảng sản phẩm
            PdfPTable table = new PdfPTable(6);
            table.setWidths(new int[]{3, 4, 4, 2, 2, 3});
            table.setWidthPercentage(100);
            String[] headers = {"Tên sản phẩm","Dung lượng Ram","Dung lượng Rom","Màu sắc","Số lượng","Đơn giá"};
            for (String col : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(col, fontTitle));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            double tong = 0;
            for (int i = 0; i < table_view_ctpn.getRowCount(); i++) {
                try {
                    String tenSP = table_view_ctpn.getValueAt(i, 1).toString();
                    //String phienban = table_view_ctpn.getValueAt(i, 2).toString() + " - " + table_view_ctpn.getValueAt(i, 4).toString();
                    int dungLuongRam =Integer.parseInt(table_view_ctpn.getValueAt(i, 2).toString());
                    int dungLuongRom =Integer.parseInt( table_view_ctpn.getValueAt(i, 3).toString());
                    String mausac = table_view_ctpn.getValueAt(i, 4).toString();
                    int sl = Integer.parseInt(table_view_ctpn.getValueAt(i, 6).toString());
                    double donGia=Double.parseDouble(table_view_ctpn.getValueAt(i, 5).toString().replaceAll(",",""));
                    tong += donGia;

                    table.addCell(new Phrase(tenSP, fontNormal));
                    table.addCell(new Phrase(String.valueOf(dungLuongRam), fontNormal));
                    table.addCell(new Phrase(String.valueOf(dungLuongRom), fontNormal));
                    table.addCell(new Phrase(mausac, fontNormal));
                    table.addCell(new Phrase(String.valueOf(sl), fontNormal));
                    table.addCell(new Phrase(String.format("%,.0f",donGia), fontNormal));
                } catch (Exception rowEx) {
                    rowEx.printStackTrace();
                }
            }

            document.add(table);

            // Tổng cộng
            Paragraph total = new Paragraph("\nTổng thành tiền: " + formatCurrency(tong), fontTitle);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);
            document.add(new Paragraph("\n\n\n", fontNormal));

            // Chữ ký
            PdfPTable tableKy = new PdfPTable(3);
            tableKy.setWidthPercentage(100f);
            String[] labels = {"Người lập phiếu", "Người giao", "Khách hàng"};
            String[] subs = {"(Ký và ghi rõ họ tên)", "(Ký và ghi rõ họ tên)", "(Ký và ghi rõ họ tên)"};

            for (String label : labels) {
                PdfPCell cell = new PdfPCell(new Phrase(label, fontBoldItalic));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableKy.addCell(cell);
            }
            for (String sub : subs) {
                PdfPCell cell = new PdfPCell(new Phrase(sub, fontNormal));
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


    }//GEN-LAST:event_btn_xuatPDFActionPerformed

    private void jtf_nhacungcapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nhacungcapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nhacungcapActionPerformed
    private String formatCurrency(double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(amount) + "đ";
    }

    private int getNextPDFNumber(File folder) {
        int max = 0;
        File[] files = folder.listFiles((dir, name) -> name.matches("phieuxuat_\\d+\\.pdf"));
        if (files != null) {
            for (File f : files) {
                Matcher matcher = Pattern.compile("phieuxuat_(\\d+)\\.pdf").matcher(f.getName());
                if (matcher.matches()) {
                    try {
                        int num = Integer.parseInt(matcher.group(1));
                        if (num > max) {
                            max = num;
                        }
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
        return max + 1;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_xuatPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtf_maPN;
    private javax.swing.JTextField jtf_nguoiNhap;
    private javax.swing.JTextField jtf_nhacungcap;
    private javax.swing.JTextField jtf_thoigian;
    private javax.swing.JTable table_view_ctpn;
    // End of variables declaration//GEN-END:variables
}
