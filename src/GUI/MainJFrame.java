/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.DienThoaiDAO;
import DAO.HeDieuHanhDAO;
import DAO.NhaCungCapDAO;
import DAO.NhanVienDAO;
import DAO.ThuongHieuDAO;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import DTO.DienThoaiDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import Data.DropShadowBorder;
import Data.Func_class;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JScrollBar;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.File;
import javax.swing.JFileChooser;


public class MainJFrame extends javax.swing.JFrame {
    JPanel[] pxPanels;
    JButton[] btns = new JButton[6];
    JPanel[] jpns = new JPanel[6];
    JButton currentActiveBtn = null;
    Func_class func = new Func_class();
    NhanVienDAO nvDAO = new NhanVienDAO();
    Border etchedBorder = BorderFactory.createEtchedBorder();

    public MainJFrame() {
        initComponents();
        pxPanels = new JPanel[] {
        jpn_px1,  // panel mặc định hiển thị khi vào "Phiếu Xuất"
        jPanel4   // panel hiển thị khi ấn "Thêm"
        };

        this.setLocationRelativeTo(null);
        khoitaoJPanel();
        khoitaoButtonInMenu();
        actionJButtonMenu();
        setBtnMenu();
        styleAllButtonMenu();
        setBackgroundJButton(btn_nv);
        setShadowforJPN();
        showPanel(jpn_nv);
        addDataTableNhanVien();
        addDataTableDienThoai();
        addDataTableNhaCungCap();
        addDataTableKhachHang();
        setCusorPointer();
        setUpTable();
        setIconForJlabel();
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
    public void showPXPanel(JPanel panel) {
    for (JPanel pn : pxPanels) {
        pn.setVisible(false);
    }
    panel.setVisible(true);
}

    public void khoitaoJPanel() {
        jpns[0] = jpn_nv;
        jpns[1] = jpn_ncc;
        jpns[2] = jpn_thuoctinh;
        jpns[3] = jpn_dt;
        jpns[4] = jpn_kh;
        jpns[5] = jpn_px;
    }
    
    public void khoitaoButtonInMenu() {
        btns[0] = btn_nv;
        btns[1] = btn_thuoctinh;
        btns[2] = btn_dt;
        btns[3] = btn_ncc;
        btns[4] = btn_kh;
        btns[5] = btn_px;
    }
    public void setBtnMenu() {
        for (JButton btn : btns) {
            btn.setFocusPainted(false);
            btn.setBorder(null);
            btn.setBackground(new Color(211, 218, 211));
        }
        jpanel_menu.setBorder(etchedBorder);
    }

    public void setShadowforJPN() {
        jpanel_chucNang_nv.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_dt.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_dt.setBorder(new DropShadowBorder(2, Color.BLACK));

    }

    public void setUpTable() {
        func.centerTable(table_nv);
        func.centerTable(table_ncc);
        func.centerTable(table_dt);
        func.centerTable(table_kh);
        func.centerTable(table_px);
        func.setUpTable(table_nv);
        func.setUpTable(table_ncc);
        func.setUpTable(table_dt);
        func.setUpTable(table_kh);
        func.setUpTable(table_px);
    }

    public void setIconForJlabel() {
        jlabel_add_ncc.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_ncc.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_ncc.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_add_nv.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_nv.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_nv.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_add_dt.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_dt.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_dt.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        btn_nv.setIcon(new FlatSVGIcon("./resources/icon/nhanvien.svg", 0.6f));
        btn_ncc.setIcon(new FlatSVGIcon("./resources/icon/ncc.svg", 0.6f));
        btn_dt.setIcon(new FlatSVGIcon("./resources/icon/phone.svg", 0.6f));
        jlabel_look_ncc.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        jlabel_look_dt.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        btn_thuoctinh.setIcon(new FlatSVGIcon("./resources/icon/thuoctinh.svg", 0.6f));
        btn_hdh.setIcon(new FlatSVGIcon("./resources/icon/os.svg"));
        btn_mausac.setIcon(new FlatSVGIcon("./resources/icon/color.svg"));
        btn_ram.setIcon(new FlatSVGIcon("./resources/icon/ram.svg"));
        btn_rom.setIcon(new FlatSVGIcon("./resources/icon/rom.svg"));
        btn_thuongHieu.setIcon(new FlatSVGIcon("./resources/icon/thuonghieu.svg"));
        jlabel_add_px.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_px.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_px.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        btn_px.setIcon(new FlatSVGIcon("./resources/icon/phieuxuat.svg", 0.035f));
        jlabel_add_kh.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_kh.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_kh.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_detail_kh.setIcon(new FlatSVGIcon("./resources/icon/detail.svg", 2.25f));
        jlabel_excel_kh.setIcon(new FlatSVGIcon("./resources/icon/excel.svg", 0.075f));
        btn_kh.setIcon(new FlatSVGIcon("./resources/icon/khachhang.svg", 0.035f));
    }

    public void setCusorPointer() {
        func.cursorPointer(jlabel_add_nv);
        func.cursorPointer(jlabel_update_nv);
        func.cursorPointer(jlabel_delete_nv);
        func.cursorPointer(jlabel_add_ncc);
        func.cursorPointer(jlabel_update_ncc);
        func.cursorPointer(jlabel_delete_ncc);
        func.cursorPointer(jlabel_add_dt);
        func.cursorPointer(jlabel_update_dt);
        func.cursorPointer(jlabel_delete_dt);
        func.cursorPointer(jlabel_add_kh);
        func.cursorPointer(jlabel_update_kh);
        func.cursorPointer(jlabel_delete_kh);
        func.cursorPointer(jlabel_add_px);
        func.cursorPointer(jlabel_update_px);
        func.cursorPointer(jlabel_delete_px);
    }

    public void styleButtonMenu(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        btn.setBackground(Color.WHITE);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(10);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(new java.awt.Color(230, 240, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (btn == currentActiveBtn) {
                    return;
                }
                btn.setBackground(new Color(211, 218, 211)); 
            }
        });
        
    }

    public void styleAllButtonMenu() {
        for (JButton btn : btns) {
            styleButtonMenu(btn);
        }
        styleButtonMenu(btn_kh);
    }
    public void actionJButtonMenu() {
        Component[] cpns = jpanel_menu_bottom.getComponents();
        for (Component cpn : cpns) {
            if (cpn instanceof JButton) {
                JButton button = (JButton) cpn;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setBackgroundJButton(button);
                        switch (button.getText()) {
                            case "Nhà Cung Cấp": {
                                showPanel(jpn_ncc);
                                break;
                            }
                            case "Nhân Viên": {
                                showPanel(jpn_nv);
                                break;
                            }
                            case "Điện Thoại": {
                                showPanel(jpn_dt);
                                break;
                            }
                            case "Thuộc Tính": {
                                showPanel(jpn_thuoctinh);
                                break;
                            }
                            case "Khách Hàng": {
                                showPanel(jpn_kh);
                                break;
                            }
                            case "Phiếu Xuất":{
                                showPanel(jpn_px);       // hiển thị panel chính "Phiếu Xuất"
                                showPXPanel(jpn_px1);    // hiển thị bảng phiếu xuất mặc định                           
                                break;
                            }
                        }
                    }

//                    @Override
//                    public void mouseEntered(MouseEvent e) {
//                        Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
//                        button.setBorder(border);
//                    }
//
//                    @Override
//                    public void mouseExited(MouseEvent e) {
//                        button.setBorder(new EmptyBorder(0, 0, 0, 0));
//                    }
                });
            }
        }
    }

    public void setBackgroundJButton(JButton btn) {
        for (JButton menuitem : btns) {
            menuitem.setBackground(new Color(211, 218, 211));
            menuitem.setForeground(Color.BLACK);
        }
        btn.setBackground(new Color(173, 216, 230));
        btn.setForeground(Color.BLACK);
        currentActiveBtn = btn;
    }

    public void showPanel(JPanel pn) {
        for (JPanel panel : jpns) {
            panel.setVisible(false);
        }
        pn.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_menu = new javax.swing.JPanel();
        jpanel_menu_top = new javax.swing.JPanel();
        img_store = new javax.swing.JLabel();
        jpanel_menu_bottom = new javax.swing.JPanel();
        btn_thuoctinh = new javax.swing.JButton();
        btn_nv = new javax.swing.JButton();
        btn_ncc = new javax.swing.JButton();
        btn_dt = new javax.swing.JButton();
        btn_kh = new javax.swing.JButton();
        btn_px = new javax.swing.JButton();
        jpn_nv = new javax.swing.JPanel();
        jpanel_chucNang_nv = new javax.swing.JPanel();
        jlabel_update_nv = new javax.swing.JLabel();
        jlabel_add_nv = new javax.swing.JLabel();
        jlabel_delete_nv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_nv = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jpn_ncc = new javax.swing.JPanel();
        jpanel_chucNang_ncc = new javax.swing.JPanel();
        jlabel_update_ncc = new javax.swing.JLabel();
        jlabel_add_ncc = new javax.swing.JLabel();
        jlabel_delete_ncc = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ncc = new javax.swing.JTable();
        jpanel_timkiem_ncc = new javax.swing.JPanel();
        jtf_find_ncc = new javax.swing.JTextField();
        jlabel_look_ncc = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jpn_thuoctinh = new javax.swing.JPanel();
        btn_mausac = new javax.swing.JButton();
        btn_ram = new javax.swing.JButton();
        btn_hdh = new javax.swing.JButton();
        btn_rom = new javax.swing.JButton();
        btn_thuongHieu = new javax.swing.JButton();
        jpn_dt = new javax.swing.JPanel();
        jpanel_chucNang_dt = new javax.swing.JPanel();
        jlabel_delete_dt = new javax.swing.JLabel();
        jlabel_update_dt = new javax.swing.JLabel();
        jlabel_add_dt = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_dt = new javax.swing.JTable();
        jpanel_timkiem_dt = new javax.swing.JPanel();
        jtf_find_dt = new javax.swing.JTextField();
        jlabel_look_dt = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jpn_kh = new javax.swing.JPanel();
        jpn_kh1 = new javax.swing.JPanel();
        jpanel_chucNang_kh = new javax.swing.JPanel();
        jlabel_update_kh = new javax.swing.JLabel();
        jlabel_add_kh = new javax.swing.JLabel();
        jlabel_delete_kh = new javax.swing.JLabel();
        jlabel_detail_kh = new javax.swing.JLabel();
        jlabel_excel_kh = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_kh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        reset_kh = new javax.swing.JButton();
        txt_search_kh = new javax.swing.JTextField();
        cbb_search_kh = new javax.swing.JComboBox<>();
        jpn_px = new javax.swing.JPanel();
        jpn_px1 = new javax.swing.JPanel();
        jpanel_chucNang_px = new javax.swing.JPanel();
        jlabel_update_px = new javax.swing.JLabel();
        jlabel_add_px = new javax.swing.JLabel();
        jlabel_delete_px = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_px = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        reset_px = new javax.swing.JButton();
        txt_search_px = new javax.swing.JTextField();
        cbb_search_px = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ thống quản lý điện thoại");
        setBackground(new java.awt.Color(153, 204, 255));

        jpanel_menu_top.setBackground(new java.awt.Color(255, 255, 255));

        img_store.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpanel_menu_topLayout = new javax.swing.GroupLayout(jpanel_menu_top);
        jpanel_menu_top.setLayout(jpanel_menu_topLayout);
        jpanel_menu_topLayout.setHorizontalGroup(
            jpanel_menu_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jpanel_menu_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_menu_topLayout.createSequentialGroup()
                    .addComponent(img_store, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 100, Short.MAX_VALUE)))
        );
        jpanel_menu_topLayout.setVerticalGroup(
            jpanel_menu_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
            .addGroup(jpanel_menu_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(img_store, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        );

        jpanel_menu_bottom.setBackground(new java.awt.Color(255, 255, 255));

        btn_thuoctinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_thuoctinh.setText("Thuộc Tính");
        btn_thuoctinh.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_thuoctinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thuoctinhActionPerformed(evt);
            }
        });

        btn_nv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_nv.setText("Nhân Viên");
        btn_nv.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_nv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nvActionPerformed(evt);
            }
        });

        btn_ncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_ncc.setText("Nhà Cung Cấp");
        btn_ncc.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btn_dt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_dt.setText("Điện Thoại");
        btn_dt.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btn_kh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_kh.setText("Khách Hàng");
        btn_kh.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btn_px.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_px.setText("Phiếu Xuất");
        btn_px.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_px.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel_menu_bottomLayout = new javax.swing.GroupLayout(jpanel_menu_bottom);
        jpanel_menu_bottom.setLayout(jpanel_menu_bottomLayout);
        jpanel_menu_bottomLayout.setHorizontalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btn_dt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thuoctinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_px, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpanel_menu_bottomLayout.setVerticalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_px, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanel_menuLayout = new javax.swing.GroupLayout(jpanel_menu);
        jpanel_menu.setLayout(jpanel_menuLayout);
        jpanel_menuLayout.setHorizontalGroup(
            jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanel_menuLayout.setVerticalGroup(
            jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_menuLayout.createSequentialGroup()
                .addGap(0, 129, Short.MAX_VALUE)
                .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_menuLayout.createSequentialGroup()
                    .addComponent(jpanel_menu_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 528, Short.MAX_VALUE)))
        );

        jpn_nv.setBackground(new java.awt.Color(245, 240, 245));
        jpn_nv.setPreferredSize(new java.awt.Dimension(1030, 625));

        jpanel_chucNang_nv.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_update_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_nvMouseClicked(evt);
            }
        });

        jlabel_add_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_nvMouseClicked(evt);
            }
        });

        jlabel_delete_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_nvMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_nvLayout = new javax.swing.GroupLayout(jpanel_chucNang_nv);
        jpanel_chucNang_nv.setLayout(jpanel_chucNang_nvLayout);
        jpanel_chucNang_nvLayout.setHorizontalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_nvLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_add_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpanel_chucNang_nvLayout.setVerticalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        table_nv.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_nv);

        jButton1.setText("Làm mới");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpn_nvLayout = new javax.swing.GroupLayout(jpn_nv);
        jpn_nv.setLayout(jpn_nvLayout);
        jpn_nvLayout.setHorizontalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jpn_nvLayout.setVerticalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jpn_ncc.setBackground(new java.awt.Color(245, 245, 245));
        jpn_ncc.setPreferredSize(new java.awt.Dimension(1030, 625));

        jpanel_chucNang_ncc.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_chucNang_ncc.setPreferredSize(new java.awt.Dimension(320, 96));

        jlabel_update_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_nccMouseClicked(evt);
            }
        });

        jlabel_add_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_nccMouseClicked(evt);
            }
        });

        jlabel_delete_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_nccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_nccLayout = new javax.swing.GroupLayout(jpanel_chucNang_ncc);
        jpanel_chucNang_ncc.setLayout(jpanel_chucNang_nccLayout);
        jpanel_chucNang_nccLayout.setHorizontalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpanel_chucNang_nccLayout.setVerticalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        table_ncc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_ncc);

        jpanel_timkiem_ncc.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_look_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_look_nccMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_timkiem_nccLayout = new javax.swing.GroupLayout(jpanel_timkiem_ncc);
        jpanel_timkiem_ncc.setLayout(jpanel_timkiem_nccLayout);
        jpanel_timkiem_nccLayout.setHorizontalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nccLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jpanel_timkiem_nccLayout.setVerticalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Làm mới");

        javax.swing.GroupLayout jpn_nccLayout = new javax.swing.GroupLayout(jpn_ncc);
        jpn_ncc.setLayout(jpn_nccLayout);
        jpn_nccLayout.setHorizontalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jpn_nccLayout.setVerticalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_mausac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_mausac.setText("MÀU SẮC");
        btn_mausac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_mausacMouseClicked(evt);
            }
        });
        btn_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mausacActionPerformed(evt);
            }
        });

        btn_ram.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ram.setText("RAM");
        btn_ram.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_ram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ramMouseClicked(evt);
            }
        });

        btn_hdh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_hdh.setText("HỆ ĐIỀU HÀNH");
        btn_hdh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_hdh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hdhMouseClicked(evt);
            }
        });

        btn_rom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_rom.setText("ROM");
        btn_rom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_rom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_romMouseClicked(evt);
            }
        });

        btn_thuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_thuongHieu.setText("THƯƠNG HIỆU");
        btn_thuongHieu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_thuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thuongHieuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpn_thuoctinhLayout = new javax.swing.GroupLayout(jpn_thuoctinh);
        jpn_thuoctinh.setLayout(jpn_thuoctinhLayout);
        jpn_thuoctinhLayout.setHorizontalGroup(
            jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_thuoctinhLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_thuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hdh, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                .addGap(118, 118, 118)
                .addGroup(jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jpn_thuoctinhLayout.setVerticalGroup(
            jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_thuoctinhLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ram, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btn_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jpn_dt.setBackground(new java.awt.Color(245, 245, 245));

        jpanel_chucNang_dt.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_add_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_dtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_dtLayout = new javax.swing.GroupLayout(jpanel_chucNang_dt);
        jpanel_chucNang_dt.setLayout(jpanel_chucNang_dtLayout);
        jpanel_chucNang_dtLayout.setHorizontalGroup(
            jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlabel_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpanel_chucNang_dtLayout.setVerticalGroup(
            jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
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

        jpanel_timkiem_dt.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_look_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_look_dtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_timkiem_dtLayout = new javax.swing.GroupLayout(jpanel_timkiem_dt);
        jpanel_timkiem_dt.setLayout(jpanel_timkiem_dtLayout);
        jpanel_timkiem_dtLayout.setHorizontalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_dtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jpanel_timkiem_dtLayout.setVerticalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_dtLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_look_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Làm mới");

        javax.swing.GroupLayout jpn_dtLayout = new javax.swing.GroupLayout(jpn_dt);
        jpn_dt.setLayout(jpn_dtLayout);
        jpn_dtLayout.setHorizontalGroup(
            jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_dtLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_dtLayout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jpn_dtLayout.setVerticalGroup(
            jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_dtLayout.createSequentialGroup()
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_dtLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpn_dtLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jpn_kh1.setPreferredSize(new java.awt.Dimension(1030, 625));

        jlabel_update_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_khMouseClicked(evt);
            }
        });

        jlabel_add_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_khMouseClicked(evt);
            }
        });

        jlabel_delete_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_khMouseClicked(evt);
            }
        });

        jlabel_detail_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_detail_khMouseClicked(evt);
            }
        });

        jlabel_excel_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_excel_khMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_khLayout = new javax.swing.GroupLayout(jpanel_chucNang_kh);
        jpanel_chucNang_kh.setLayout(jpanel_chucNang_khLayout);
        jpanel_chucNang_khLayout.setHorizontalGroup(
            jpanel_chucNang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_khLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_add_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_update_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_delete_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_detail_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_excel_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jpanel_chucNang_khLayout.setVerticalGroup(
            jpanel_chucNang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_khLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_excel_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_detail_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jpn_kh1Layout = new javax.swing.GroupLayout(jpn_kh1);
        jpn_kh1.setLayout(jpn_kh1Layout);
        jpn_kh1Layout.setHorizontalGroup(
            jpn_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_kh1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanel_chucNang_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jpn_kh1Layout.setVerticalGroup(
            jpn_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_kh1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jpanel_chucNang_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

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
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(cbb_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpn_khLayout = new javax.swing.GroupLayout(jpn_kh);
        jpn_kh.setLayout(jpn_khLayout);
        jpn_khLayout.setHorizontalGroup(
            jpn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_khLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jpn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_khLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpn_kh1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jpn_khLayout.setVerticalGroup(
            jpn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_khLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(537, Short.MAX_VALUE))
            .addGroup(jpn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_khLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpn_kh1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jpn_px1.setPreferredSize(new java.awt.Dimension(1030, 625));

        jlabel_update_px.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_pxMouseClicked(evt);
            }
        });

        jlabel_add_px.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_pxMouseClicked(evt);
            }
        });

        jlabel_delete_px.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_pxMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_pxLayout = new javax.swing.GroupLayout(jpanel_chucNang_px);
        jpanel_chucNang_px.setLayout(jpanel_chucNang_pxLayout);
        jpanel_chucNang_pxLayout.setHorizontalGroup(
            jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_pxLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlabel_add_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_update_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlabel_delete_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpanel_chucNang_pxLayout.setVerticalGroup(
            jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_pxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_add_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_px, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        table_px.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu xuất", "Khách hàng", "Nhân viên nhập", "Tổng tiền"
            }
        ));
        jScrollPane3.setViewportView(table_px);

        jLabel1.setText("Khách hàng");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Nhân viên xuất");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Từ số tiền (VND)");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Đến số tiền (VND)");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox9, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reset_px.setText("Làm mới");
        reset_px.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_pxActionPerformed(evt);
            }
        });

        txt_search_px.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_pxActionPerformed(evt);
            }
        });

        cbb_search_px.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(cbb_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reset_px)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_px)
                    .addComponent(txt_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_search_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jpn_px1Layout = new javax.swing.GroupLayout(jpn_px1);
        jpn_px1.setLayout(jpn_px1Layout);
        jpn_px1Layout.setHorizontalGroup(
            jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_px1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang_px, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jpn_px1Layout.setVerticalGroup(
            jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_px1Layout.createSequentialGroup()
                .addGroup(jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_px1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jpanel_chucNang_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn_px1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTextField2.setText("Tên sản phẩm, mã sản phẩm...");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        jButton5.setText("Thêm sản phẩm");

        jButton6.setText("Nhập Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel5.setText("Mã SP");

        jLabel6.setText("Tên sản phẩm");

        jLabel9.setText("Cấu hình");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Giá xuất");

        jLabel11.setText("Số lượng tồn");

        jTextField7.setMinimumSize(new java.awt.Dimension(64, 30));

        jLabel7.setText("Mã Imei");

        jButton7.setText("Chọn mã Imei");
        jButton7.setMinimumSize(new java.awt.Dimension(104, 30));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton8.setText("Xóa sản phẩm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Sửa sản phẩm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jTextField5)
                                .addGap(23, 23, 23))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jTextField5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "RAM", "ROM", "Màu sắc", "Đơn giá", "Số lượng"
            }
        ));
        jScrollPane7.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setText("Mã phiếu xuất");

        jLabel12.setText("Nhân viên xuất");

        jLabel13.setText("Khách hàng");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jButton4.setText("...");

        jButton10.setText("XUẤT HÀNG");

        jLabel14.setText("TỔNG TIỀN:");

        jLabel15.setText("...");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField8)
                                .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpn_pxLayout = new javax.swing.GroupLayout(jpn_px);
        jpn_px.setLayout(jpn_pxLayout);
        jpn_pxLayout.setHorizontalGroup(
            jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1047, Short.MAX_VALUE)
            .addGroup(jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_pxLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpn_px1, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_pxLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpn_pxLayout.setVerticalGroup(
            jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
            .addGroup(jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_px1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
            .addGroup(jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1267, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1055, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 221, Short.MAX_VALUE)
                    .addComponent(jpn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 220, Short.MAX_VALUE)
                    .addComponent(jpn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 221, Short.MAX_VALUE)
                    .addComponent(jpn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 222, Short.MAX_VALUE)
                    .addComponent(jpn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(227, Short.MAX_VALUE)
                    .addComponent(jpn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 220, Short.MAX_VALUE)
                    .addComponent(jpn_px, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_thuoctinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_px, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlabel_add_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_nvMouseClicked
        AddNhanVienJFrame addNVJFrame = new AddNhanVienJFrame(this);
        addNVJFrame.setVisible(true);
        addNVJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_nvMouseClicked

    private void jlabel_update_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_nvMouseClicked
        int vitriRow = table_nv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để update", "Error", 0);
            return;
        }
        String maNV = table_nv.getValueAt(vitriRow, 0).toString();
        String hoTen = table_nv.getValueAt(vitriRow, 1).toString();
        Date ngaySinh = (Date) table_nv.getValueAt(vitriRow, 2);
        String gioiTinh = table_nv.getValueAt(vitriRow, 3).toString();
        String sdt = table_nv.getValueAt(vitriRow, 4).toString();
        EditNhanVienJFrame editNVJFrame = new EditNhanVienJFrame(maNV, hoTen, ngaySinh, gioiTinh, sdt, this);
        editNVJFrame.setVisible(true);
        editNVJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_nvMouseClicked

    private void jlabel_delete_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_nvMouseClicked
        int vitriRow = table_nv.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để xóa", "Error", 0);
            return;
        }
        String maNV = table_nv.getValueAt(vitriRow, 0).toString();
        new NhanVienDAO().deleteNhanVien(maNV);
        addDataTableNhanVien();
        func.centerTable(table_nv);
    }//GEN-LAST:event_jlabel_delete_nvMouseClicked

    private void btn_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mausacActionPerformed

    private void btn_ramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ramMouseClicked
        RAMJFrame ram = new RAMJFrame();
        ram.setVisible(true);
        ram.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_ramMouseClicked

    private void btn_romMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_romMouseClicked
        ROMJFrame rom = new ROMJFrame();
        rom.setVisible(true);
        rom.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_romMouseClicked

    private void btn_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mausacMouseClicked
        MauSacJFrame ms = new MauSacJFrame();
        ms.setVisible(true);
        ms.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_mausacMouseClicked

    private void btn_hdhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hdhMouseClicked
        HeDieuHanhJFrame hdh = new HeDieuHanhJFrame();
        hdh.setVisible(true);
        hdh.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_hdhMouseClicked

    private void btn_thuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thuongHieuMouseClicked
        ThuongHieuJFrame th = new ThuongHieuJFrame();
        th.setVisible(true);
        th.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_thuongHieuMouseClicked

    private void jlabel_add_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_dtMouseClicked
        AddDienThoaiJFrame dt = new AddDienThoaiJFrame(this);
        dt.setVisible(true);
        dt.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_dtMouseClicked

    private void btn_nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nvActionPerformed

    private void btn_thuoctinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thuoctinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_thuoctinhActionPerformed

    private void jlabel_delete_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_nccMouseClicked
        int vitriRow = table_ncc.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp để xóa", "Error", 0);
            return;
        }
        String maNCC = table_ncc.getValueAt(vitriRow, 0).toString();
        new NhaCungCapDAO().deleteNhaCungCap(maNCC);
        addDataTableNhaCungCap();
        func.centerTable(table_ncc);
    }//GEN-LAST:event_jlabel_delete_nccMouseClicked

    private void jlabel_add_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_nccMouseClicked
        AddNhaCungCapFrame addNCCJFrame = new AddNhaCungCapFrame(this);
        addNCCJFrame.setVisible(true);
        addNCCJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_nccMouseClicked

    private void jlabel_update_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_nccMouseClicked
        int vitriRow = table_ncc.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp để update", "Error", 0);
            return;
        }
        String maNCC = table_ncc.getValueAt(vitriRow, 0).toString();
        String tenNCC = table_ncc.getValueAt(vitriRow, 1).toString();
        String address = table_ncc.getValueAt(vitriRow, 2).toString();
        String sdt = table_ncc.getValueAt(vitriRow, 3).toString();
        String email = table_ncc.getValueAt(vitriRow, 4).toString();
        EditNhaCungCapJFrame editNCCJFrame = new EditNhaCungCapJFrame(maNCC, tenNCC, address, sdt, email, this);
        editNCCJFrame.setVisible(true);
        editNCCJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_nccMouseClicked

    private void jlabel_look_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_dtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlabel_look_dtMouseClicked

    private void btn_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pxActionPerformed

    private void jlabel_update_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_khMouseClicked
        // TODO add your handling code here:
        int vitriRow = table_kh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để sửa", "Error", 0);
            return;
        }
        String maKh = table_kh.getValueAt(vitriRow, 0).toString();
        String tenKh = table_kh.getValueAt(vitriRow, 1).toString();
        String  sdtKh= table_kh.getValueAt(vitriRow, 3).toString();
        String diachiKh = table_kh.getValueAt(vitriRow, 2).toString();
        String ngayThamGia = table_kh.getValueAt(vitriRow, 4).toString();
        EditKhachHang editKh = new EditKhachHang(maKh,tenKh,sdtKh,diachiKh, this);
        editKh.setVisible(true);
        editKh.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_khMouseClicked

    private void jlabel_add_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_khMouseClicked
        // TODO add your handling code herea
        AddKhachHang addKH = new AddKhachHang(this);
        addKH.setVisible(true);
        addKH.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_khMouseClicked

    private void jlabel_delete_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_khMouseClicked
        // TODO add your handling code here:
        int vitriRow = table_kh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng để xóa", "Error", 0);
            return;
        }
        String maKh = table_kh.getValueAt(vitriRow, 0).toString();
        new KhachHangDAO().deleteKhachHang(maKh);
        addDataTableKhachHang();
        func.centerTable(table_kh);
    }//GEN-LAST:event_jlabel_delete_khMouseClicked


    private void jlabel_update_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_pxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlabel_update_pxMouseClicked

    private void jlabel_add_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_pxMouseClicked
        // TODO add your handling code here:
       showPXPanel(jPanel4); 
    }//GEN-LAST:event_jlabel_add_pxMouseClicked

    private void jlabel_delete_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_pxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlabel_delete_pxMouseClicked

    private void jlabel_look_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_nccMouseClicked
        String text = jtf_find_ncc.getText().trim();
        DefaultTableModel model = (DefaultTableModel) table_ncc.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_ncc.setRowSorter(sorter);

        if (text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_jlabel_look_nccMouseClicked

    private void reset_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_khActionPerformed
        // TODO add your handling code here:
        txt_search_kh.setText("");
        cbb_search_kh.setSelectedIndex(0);
        addDataTableKhachHang();
        table_kh.setRowSorter(null);
    }//GEN-LAST:event_reset_khActionPerformed

    private void txt_search_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_pxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_pxActionPerformed

    private void reset_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_pxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_pxActionPerformed

    private void txt_search_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_khActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_khActionPerformed

    private void jlabel_detail_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_detail_khMouseClicked
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
    DetailKhachHang detail = new DetailKhachHang(kh);
    detail.setLocationRelativeTo(null);
    detail.setVisible(true);
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Lỗi khi mở chi tiết: " + e.getMessage());
}


    }//GEN-LAST:event_jlabel_detail_khMouseClicked
    private void exportKhachHangToExcel() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
    fileChooser.setSelectedFile(new File("DanhSachKhachHang.xlsx"));

    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection != JFileChooser.APPROVE_OPTION) return;

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
    private void jlabel_excel_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_excel_khMouseClicked
        // TODO add your handling code here:
         exportKhachHangToExcel();
    }//GEN-LAST:event_jlabel_excel_khMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed
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
        case "Mã khách hàng" -> 0;
        case "Tên khách hàng" -> 1;
        case "Địa chỉ" -> 2;
        case "Số điện thoại" -> 3;
        default -> -1;
    };

    if (columnIndex >= 0) {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword, columnIndex));
    } else {
        sorter.setRowFilter(null);
    }
    }

    public JTable getTableNhanVien() {
        return table_nv;
    }

    public JTable getTableNhaCungCap() {
        return table_ncc;
    }

    public JTable getTableDienThoai() {
        return table_dt;
    }
    public JTable getTableKhachHang(){
        return table_kh;
    }
    public void addDataTableNhaCungCap() {
        ArrayList<NhaCungCapDTO> listNCC = new NhaCungCapDAO().listNCC();
        String[] colNames = {"Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Email"};
        Object[][] rows = new Object[listNCC.size()][colNames.length];
        for (int i = 0; i < listNCC.size(); i++) {
            rows[i][0] = listNCC.get(i).getID();
            rows[i][1] = listNCC.get(i).getName();
            rows[i][2] = listNCC.get(i).getAddress();
            rows[i][3] = listNCC.get(i).getSDT();
            rows[i][4] = listNCC.get(i).getEmail();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_ncc.setModel(model);
    }

    public void addDataTableNhanVien() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        String[] colNames = {"Mã NV", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại"};
        ArrayList<NhanVienDTO> listNV = nvDAO.listNV();
        Object[][] rows = new Object[listNV.size()][colNames.length];
        for (int i = 0; i < listNV.size(); i++) {
            rows[i][0] = listNV.get(i).getMaNV();
            rows[i][1] = listNV.get(i).getHoTen();
            rows[i][2] = listNV.get(i).getNgaySinh();
            rows[i][3] = listNV.get(i).getGioiTinh();
            rows[i][4] = listNV.get(i).getSDT();
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_nv.setModel(model);
    }
    public void addDataTableKhachHang() {
    KhachHangDAO dao = new KhachHangDAO();
    ArrayList<KhachHangDTO> dsKH = dao.listKh(); 
    DefaultTableModel model = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại","Ngày tham gia"}
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
    
    public void addDataTableDienThoai() {
        HashMap<String, Integer> mapHDH = new HeDieuHanhDAO().listMapHDH();
        HashMap<String, Integer> mapThuongHieu = new ThuongHieuDAO().listMapThuongHieu();
        DienThoaiDAO dtDAO = new DienThoaiDAO();
        String[] colNames = {"Mã ĐT", "Tên Điện Thoại", "Hệ điều hành", "Thương hiệu", "Chip xử lý", "Dung lượng pin", "Kích thước màn"};
        ArrayList<DienThoaiDTO> listDT = dtDAO.listDT();
        Object[][] rows = new Object[listDT.size()][colNames.length];
        for (int i = 0; i < listDT.size(); i++) {
            rows[i][0] = listDT.get(i).getMaDT();
            rows[i][1] = listDT.get(i).getTenDT();
            int maHDH = listDT.get(i).getHeDieuHanh();
            String tenHDH = null;
            for (Map.Entry<String, Integer> entry : mapHDH.entrySet()) {
                if (maHDH == (entry.getValue())) {
                    tenHDH = entry.getKey();
                }
            }
            rows[i][2] = tenHDH;
            int maThuongHieu = listDT.get(i).getThuongHieu();
            String tenThuongHieu = null;
            for (Map.Entry<String, Integer> entry : mapThuongHieu.entrySet()) {
                if (maThuongHieu == (entry.getValue())) {
                    tenThuongHieu = entry.getKey();
                }
            }
            rows[i][3] = tenThuongHieu;
            rows[i][4] = listDT.get(i).getChipXuLy();
            rows[i][5] = listDT.get(i).getDungLuongPin() + "mAh";
            rows[i][6] = listDT.get(i).getKichThuocMan() + " inch";
        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_dt.setModel(model);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dt;
    private javax.swing.JButton btn_hdh;
    private javax.swing.JButton btn_kh;
    private javax.swing.JButton btn_mausac;
    private javax.swing.JButton btn_ncc;
    private javax.swing.JButton btn_nv;
    private javax.swing.JButton btn_px;
    private javax.swing.JButton btn_ram;
    private javax.swing.JButton btn_rom;
    private javax.swing.JButton btn_thuoctinh;
    private javax.swing.JButton btn_thuongHieu;
    private javax.swing.JComboBox<String> cbb_search_kh;
    private javax.swing.JComboBox<String> cbb_search_px;
    private javax.swing.JLabel img_store;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel jlabel_add_dt;
    private javax.swing.JLabel jlabel_add_kh;
    private javax.swing.JLabel jlabel_add_ncc;
    private javax.swing.JLabel jlabel_add_nv;
    private javax.swing.JLabel jlabel_add_px;
    private javax.swing.JLabel jlabel_add_px1;
    private javax.swing.JLabel jlabel_delete_dt;
    private javax.swing.JLabel jlabel_delete_kh;
    private javax.swing.JLabel jlabel_delete_ncc;
    private javax.swing.JLabel jlabel_delete_nv;
    private javax.swing.JLabel jlabel_delete_px;
    private javax.swing.JLabel jlabel_delete_px1;
    private javax.swing.JLabel jlabel_detail_kh;
    private javax.swing.JLabel jlabel_excel_kh;
    private javax.swing.JLabel jlabel_look_dt;
    private javax.swing.JLabel jlabel_look_ncc;
    private javax.swing.JLabel jlabel_update_dt;
    private javax.swing.JLabel jlabel_update_kh;
    private javax.swing.JLabel jlabel_update_ncc;
    private javax.swing.JLabel jlabel_update_nv;
    private javax.swing.JLabel jlabel_update_px;
    private javax.swing.JLabel jlabel_update_px1;
    private javax.swing.JPanel jpanel_chucNang_dt;
    private javax.swing.JPanel jpanel_chucNang_kh;
    private javax.swing.JPanel jpanel_chucNang_ncc;
    private javax.swing.JPanel jpanel_chucNang_nv;
    private javax.swing.JPanel jpanel_chucNang_px;
    private javax.swing.JPanel jpanel_chucNang_px1;
    private javax.swing.JPanel jpanel_menu;
    private javax.swing.JPanel jpanel_menu_bottom;
    private javax.swing.JPanel jpanel_menu_top;
    private javax.swing.JPanel jpanel_timkiem_dt;
    private javax.swing.JPanel jpanel_timkiem_ncc;
    private javax.swing.JPanel jpn_dt;
    private javax.swing.JPanel jpn_kh;
    private javax.swing.JPanel jpn_kh1;
    private javax.swing.JPanel jpn_ncc;
    private javax.swing.JPanel jpn_nv;
    private javax.swing.JPanel jpn_px;
    private javax.swing.JPanel jpn_px1;
    private javax.swing.JPanel jpn_px2;
    private javax.swing.JPanel jpn_thuoctinh;
    private javax.swing.JTextField jtf_find_dt;
    private javax.swing.JTextField jtf_find_ncc;
    private javax.swing.JButton reset_kh;
    private javax.swing.JButton reset_px;
    private javax.swing.JTable table_dt;
    private javax.swing.JTable table_kh;
    private javax.swing.JTable table_ncc;
    private javax.swing.JTable table_nv;
    private javax.swing.JTable table_px;
    private javax.swing.JTextField txt_search_kh;
    private javax.swing.JTextField txt_search_px;
    // End of variables declaration//GEN-END:variables
}
