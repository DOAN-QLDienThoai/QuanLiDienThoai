
package GUI.Panel;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class PanelTrangChu extends javax.swing.JPanel {
    public PanelTrangChu() {
        initComponents();
        khoiTao();
    }
    public void khoiTao(){
        createPanel1();
        createPanel2();
        createPanel3();
        setIcon();
        setTimer();
    }
    public void createPanel1(){
        jlabel_TinhChinhXac.setText("<html>"
                + "<div style='width:180px; height:100px; display:flex; align-items:center; justify-content:center; text-align:center;'>"
                + "Quản lý từng phiên bản điện thoại theo cấu hình (RAM, ROM, màu sắc), đảm bảo dữ liệu luôn được cập nhật chính xác."
                + "</div></html>");
        jlabel_TinhChinhXac.setPreferredSize(new Dimension(190, 100));
        jlabel_title_tinhchinhxac.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel_TinhChinhXac.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        jlabel_anh1.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void createPanel2(){
        jlabel_deDang.setText("<html>"
                + "<div style='width:180px; height:100px; display:flex; align-items:center; justify-content:center; text-align:center;'>"
                + "Giao diện thân thiện, thao tác nhanh chóng giúp người dùng dễ dàng thêm, sửa, xóa và tìm kiếm sản phẩm trong kho."
                + "</div></html>");
        jlabel_deDang.setPreferredSize(new Dimension(190, 100));
        jlabel_title_deSuDung.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel_deDang.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        jlabel_anh2.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void createPanel3(){
        jlabel_hieuqua.setText("<html>"
                + "<div style='width:180px; height:100px; display:flex; align-items:center; justify-content:center; text-align:center;'>"
                + "Theo dõi số lượng tồn kho, nhập – xuất hàng và cập nhật giá bán dễ dàng, giúp quản lý hàng hóa hiệu quả và tiết kiệm thời gian."
                + "</div></html>");
        jlabel_hieuqua.setPreferredSize(new Dimension(190, 100));
        jlabel_title_hieuqua.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel_hieuqua.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        jlabel_anh3.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void setIcon(){
        jlabel_anh1.setIcon(new FlatSVGIcon("./resources/icon/chinhxac.svg",0.95f));
        jlabel_anh2.setIcon(new FlatSVGIcon("./resources/icon/dedang.svg",0.95f));
        jlabel_anh3.setIcon(new FlatSVGIcon("./resources/icon/hieuqua.svg",0.92f));
    }
    public void setTimer() {
        String fullText = jlabel_hello.getText(); // lấy nội dung gốc
        jlabel_hello.setText(""); // bắt đầu với chuỗi rỗng

        final int[] index = {0};

        Timer timer = new Timer(200, e -> {
            if (index[0] < fullText.length()) {
                jlabel_hello.setText(jlabel_hello.getText() + fullText.charAt(index[0]));
                index[0]++;
            } else {
                // Khi gõ xong thì reset lại sau một khoảng nhỏ
                index[0] = 0;
                jlabel_hello.setText(""); // xóa để bắt đầu lại
            }
        });

        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jlabel_hello = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlabel_anh1 = new javax.swing.JLabel();
        jlabel_title_tinhchinhxac = new javax.swing.JLabel();
        jlabel_TinhChinhXac = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlabel_anh2 = new javax.swing.JLabel();
        jlabel_title_deSuDung = new javax.swing.JLabel();
        jlabel_deDang = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlabel_anh3 = new javax.swing.JLabel();
        jlabel_title_hieuqua = new javax.swing.JLabel();
        jlabel_hieuqua = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1030, 630));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 153, 255));
        jLabel19.setText("HỆ THỐNG QUẢN LÝ KHO ĐIỆN THOẠI");

        jlabel_hello.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        jlabel_hello.setText("Xin Chào");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(jlabel_hello)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_hello, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1030, 110);

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_title_tinhchinhxac.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlabel_title_tinhchinhxac.setText("TÍNH CHÍNH XÁC");
        jlabel_title_tinhchinhxac.setFocusCycleRoot(true);
        jlabel_title_tinhchinhxac.setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_anh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_title_tinhchinhxac, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jlabel_TinhChinhXac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_anh1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_title_tinhchinhxac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_TinhChinhXac, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_title_deSuDung.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlabel_title_deSuDung.setText("DỄ SỬ DỤNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_title_deSuDung, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jlabel_deDang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_anh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_anh2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_title_deSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_deDang, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_title_hieuqua.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlabel_title_hieuqua.setText("TÍNH HIỆU QUẢ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_title_hieuqua, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(jlabel_anh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_hieuqua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlabel_anh3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_title_hieuqua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_hieuqua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel8);
        jPanel8.setBounds(0, 110, 1030, 520);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jlabel_TinhChinhXac;
    private javax.swing.JLabel jlabel_anh1;
    private javax.swing.JLabel jlabel_anh2;
    private javax.swing.JLabel jlabel_anh3;
    private javax.swing.JLabel jlabel_deDang;
    private javax.swing.JLabel jlabel_hello;
    private javax.swing.JLabel jlabel_hieuqua;
    private javax.swing.JLabel jlabel_title_deSuDung;
    private javax.swing.JLabel jlabel_title_hieuqua;
    private javax.swing.JLabel jlabel_title_tinhchinhxac;
    // End of variables declaration//GEN-END:variables
}
