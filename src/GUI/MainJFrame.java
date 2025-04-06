/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.DienThoaiDAO;
import DAO.HeDieuHanhDAO;
import DAO.KhachHangDAO;
import DAO.NhaCungCapDAO;
import DAO.NhanVienDAO;
import DAO.ThuongHieuDAO;
import DTO.DienThoaiDTO;
import DTO.KhachHangDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import util.DropShadowBorder;
import util.Func_class;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class MainJFrame extends javax.swing.JFrame {
    private DienThoaiDTO dt;
    JButton[] btns = new JButton[8];
    JPanel[] jpns = new JPanel[8];
    JButton currentActiveBtn = null;
    private Func_class func = new Func_class();
    private Border etchedBorder = BorderFactory.createEtchedBorder();
    private HashMap<String,Integer> mapHDH;
    private HashMap<String,Integer> mapThuongHieu;
    private ArrayList<DienThoaiDTO> listDT=new DienThoaiDAO().listDT();
    private ArrayList<NhaCungCapDTO> listNCC=new NhaCungCapDAO().listNCC();
    private ArrayList<NhanVienDTO> listNV=new NhanVienDAO().listNV();
    private ArrayList<DienThoaiDTO> listDTFilter=new ArrayList<>();
    private ArrayList<NhaCungCapDTO> listNCCFilter=new ArrayList<>();
    private ArrayList<NhanVienDTO> listNVFilter=new ArrayList<>();
    public MainJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        func.addDataTableDienThoai(listDT,table_dt);
        func.addDataTableNV(listNV, table_nv);
        func.addDataTableNCC(listNCC, table_ncc);
        khoitaoChooseFilterDT();
        khoitaoChooserFilterNCC();
        khoitaoChooseFilterNV();
        khoitaoJPanel();
        khoitaoButtonInMenu();
        actionJButtonMenu();
        styleAllButtonMenu(); // 👉 thêm dòng này để làm đẹp nút menu
        showPanel(jpn_dt);
        setBackgroundJButton(btn_dt);
        setShadowforJPN();
        setCusorPointer();
        setUpTable();
        setIconForJlabel();
        cbb_search_kh.removeAllItems();
        cbb_search_kh.addItem("Tất cả");
        cbb_search_kh.addItem("Mã khách hàng");
        cbb_search_kh.addItem("Tên khách hàng");
        cbb_search_kh.addItem("Địa chỉ");
        cbb_search_kh.addItem("Số điện thoại");
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
        txt_search_kh.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { searchKhachHang(); }
        public void removeUpdate(DocumentEvent e) { searchKhachHang(); }
         public void changedUpdate(DocumentEvent e) {}
        });
    }
    
    //Hàm khởi tạo lựa chọn cách lọc điện thoại
    public void khoitaoChooseFilterDT(){
        String[] filtersDT={"Tất cả","Tên điện thoại","Hệ điều hành","Thương hiệu","Chip xử lý"};
        combobox_find_dt.setBackground(Color.WHITE);
        for(String nameFilterDT : filtersDT )
            combobox_find_dt.addItem(nameFilterDT);
    }
    public void khoitaoChooserFilterNCC(){
        String[] filtersNCC={"Tất cả","Tên nhà cung cấp","Email","Số điện thoại","Địa chỉ"};
        combobox_find_ncc.setBackground(Color.WHITE);
        for(String nameFilterNCC : filtersNCC)
            combobox_find_ncc.addItem(nameFilterNCC);
    }
    public void khoitaoChooseFilterNV(){
        String[] filtersDT={"Tất cả","Tên nhân viên","Số điện thoại","Giới tính","Ngày sinh"};
        combobox_find_nv.setBackground(Color.WHITE);
        for(String nameFilterDT : filtersDT )
            combobox_find_nv.addItem(nameFilterDT);
    }
    //Hàm khởi tạo các đối tượng Jpanel
    public void khoitaoJPanel() {
        jpns[0] = jpn_nv;
        jpns[1] = jpn_ncc;
        jpns[2] = jpn_thuoctinh;
        jpns[3] = jpn_dt;
        jpns[4] = jpn_kh;
        jpns[5]=jpn_px;
        jpns[6]=jpn_tk;
        jpns[7]=jpn_pn;
    }
    //Hàm khởi tạo các button của Menu
    public void khoitaoButtonInMenu() {
        btns[0] = btn_nv;
        btns[1] = btn_thuoctinh;
        btns[2] = btn_dt;
        btns[3] = btn_ncc;
        btns[4] = btn_kh;
        btns[5] = btn_px;
        btns[6] = btn_tk;
        btns[7] = btn_pn;
    }
    
    //Hàm chỉnh border của chức năng, tìm kiếm
    public void setShadowforJPN() {
        jpanel_chucNang_nv.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_nv.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_dt.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_dt.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_filter.setBorder(new DropShadowBorder(1,Color.BLACK));
        jpanel_filter_ncc.setBorder(new DropShadowBorder(1,Color.BLACK));
        jpanel_filter_nv.setBorder(new DropShadowBorder(1,Color.BLACK));
    }
    //Hàm chỉnh sửa độ đẹp mắt của bảng
    public void setUpTable() {
        func.centerTable(table_nv);
        func.centerTable(table_ncc);
        func.centerTable(table_dt);
        func.setUpTable(table_nv);
        func.setUpTable(table_ncc);
        func.setUpTable(table_dt);
        func.setUpTable(table_kh);
    }
    //Hàm set ảnh cho các jlabel
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
        jlabel_look_nv.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        jlabel_look_ncc.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        jlabel_look_dt.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        btn_thuoctinh.setIcon(new FlatSVGIcon("./resources/icon/thuoctinh.svg", 0.6f));
        btn_hdh.setIcon(new FlatSVGIcon("./resources/icon/os.svg"));
        btn_mausac.setIcon(new FlatSVGIcon("./resources/icon/color.svg"));
        btn_ram.setIcon(new FlatSVGIcon("./resources/icon/ram.svg"));
        btn_rom.setIcon(new FlatSVGIcon("./resources/icon/rom.svg"));
        btn_thuongHieu.setIcon(new FlatSVGIcon("./resources/icon/thuonghieu.svg"));
        jlabel_refresh.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.35f));
        jlabel_refresh_ncc.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.35f));
        jlabel_refresh_nv.setIcon(new FlatSVGIcon("./resources/icon/refresh.svg",0.35f));
        jlabel_excel.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg",0.85f));
        jlabel_chiTiet_dt.setIcon(new FlatSVGIcon("./resources/icon/details.svg",0.45f));
        jlabel_chitiet_nv.setIcon(new FlatSVGIcon("./resources/icon/details.svg",0.45f));
        jlabel_xuat_excel_nv.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg",0.85f));
        jlabel_nhap_excel_nv.setIcon(new FlatSVGIcon("./resources/icon/excel.svg",0.55f));
        jlabel_add_px.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_px.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_px.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        btn_kh.setIcon(new FlatSVGIcon("./resources/icon/khachhang.svg", 0.035f));
        btn_px.setIcon(new FlatSVGIcon("./resources/icon/phieuxuat.svg", 0.035f));
        jlabel_add_kh.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_kh.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_kh.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_chiTiet_ncc.setIcon(new FlatSVGIcon("./resources/icon/details.svg",0.45f));
        jlabel_xuat_excel_ncc.setIcon(new FlatSVGIcon("./resources/icon/export_excel.svg",0.85f));
    }
    //Hàm thêm biểu tượng chuột vào cái jlabel
    public void setCusorPointer() {
        List<JLabel> jlabels =List.of(jlabel_add_nv,jlabel_update_nv,jlabel_delete_nv,jlabel_add_ncc
        ,jlabel_update_ncc,jlabel_delete_ncc,jlabel_add_dt,jlabel_update_dt,jlabel_delete_dt,jlabel_refresh
        ,jlabel_excel,jlabel_chiTiet_dt,jlabel_nhap_excel_nv,jlabel_chitiet_nv,jlabel_xuat_excel_nv,
        jlabel_chiTiet_ncc,jlabel_refresh_ncc,jlabel_refresh_nv);
        for(JLabel label : jlabels )
            func.cursorPointer(label);
    }
    //Chỉnh hiệu ứng các button Menu
    public void styleButtonMenu(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        btn.setBackground(Color.WHITE);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(10);
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(new java.awt.Color(230, 240, 255)); // hover
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (btn == currentActiveBtn) {
                    return; // đang active thì không reset
                }
                btn.setBackground(new Color(211, 218, 211)); // reset về màu gốc
            }
        });
    }
    //Chỉnh độ đẹp mắt cho các button menu
    public void setBackgroundJButton(JButton btn) {
        for (JButton menuitem : btns) {
            menuitem.setBackground(new Color(211, 218, 211));
            menuitem.setForeground(Color.BLACK);
        }
        btn.setBackground(new Color(173, 216, 230));
        btn.setForeground(Color.BLACK);
        currentActiveBtn = btn;
    }
    //Hàm showPanel
    public void showPanel(JPanel pn) {
        for (JPanel panel : jpns) {
            panel.setVisible(false);
        }
        pn.setVisible(true);
    }
    public void styleAllButtonMenu() {
        for (JButton btn : btns) {
            styleButtonMenu(btn);
        }
        styleButtonMenu(btn_kh); // nếu chưa có trong mảng
    }
    //Chuyển các JPanel
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
                                showPanel(jpn_px);
                                break;
                            }
                            case "Phiếu Nhập":{
                                showPanel(jpn_pn);
                                break;
                            }
                            case "Thống Kê":{
                                showPanel(jpn_tk);
                                break;
                            }
                        }
                    }
                });
            }
        }
    }
    //Check xem chọn đối tượng của bảng chưa
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
        btn_pn = new javax.swing.JButton();
        btn_tk = new javax.swing.JButton();
        jpn_nv = new javax.swing.JPanel();
        jpanel_chucNang_nv = new javax.swing.JPanel();
        jlabel_update_nv = new javax.swing.JLabel();
        jlabel_add_nv = new javax.swing.JLabel();
        jlabel_delete_nv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlabel_chitiet_nv = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlabel_nhap_excel_nv = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlabel_xuat_excel_nv = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_nv = new javax.swing.JTable();
        jpanel_timkiem_nv = new javax.swing.JPanel();
        jtf_find_nv = new javax.swing.JTextField();
        jlabel_look_nv = new javax.swing.JLabel();
        combobox_find_nv = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jpanel_filter_nv = new javax.swing.JPanel();
        jlabel_refresh_nv = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jpn_ncc = new javax.swing.JPanel();
        jpanel_chucNang_ncc = new javax.swing.JPanel();
        jlabel_update_ncc = new javax.swing.JLabel();
        jlabel_add_ncc = new javax.swing.JLabel();
        jlabel_delete_ncc = new javax.swing.JLabel();
        jlabel_chiTiet_ncc = new javax.swing.JLabel();
        jlabel_xuat_excel_ncc = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ncc = new javax.swing.JTable();
        jpanel_timkiem_ncc = new javax.swing.JPanel();
        jtf_find_ncc = new javax.swing.JTextField();
        jlabel_look_ncc = new javax.swing.JLabel();
        combobox_find_ncc = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jpanel_filter_ncc = new javax.swing.JPanel();
        jlabel_refresh_ncc = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
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
        jlabel_look_dt = new javax.swing.JLabel();
        combobox_find_dt = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jpanel_filter = new javax.swing.JPanel();
        jlabel_refresh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpn_px = new javax.swing.JPanel();
        jpn_px1 = new javax.swing.JPanel();
        jpanel_chucNang_px = new javax.swing.JPanel();
        jlabel_update_px = new javax.swing.JLabel();
        jlabel_add_px = new javax.swing.JLabel();
        jlabel_delete_px = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_px = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        reset_px = new javax.swing.JButton();
        txt_search_px = new javax.swing.JTextField();
        cbb_search_px = new javax.swing.JComboBox<>();
        jpn_kh = new javax.swing.JPanel();
        jpn_kh1 = new javax.swing.JPanel();
        jpanel_chucNang_kh = new javax.swing.JPanel();
        jlabel_update_kh = new javax.swing.JLabel();
        jlabel_add_kh = new javax.swing.JLabel();
        jlabel_delete_kh = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_kh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        reset_kh = new javax.swing.JButton();
        txt_search_kh = new javax.swing.JTextField();
        cbb_search_kh = new javax.swing.JComboBox<>();
        jpn_tk = new javax.swing.JPanel();
        jpn_pn = new javax.swing.JPanel();

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

        btn_pn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_pn.setText("Phiếu Nhập");
        btn_pn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btn_tk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_tk.setText("Thống Kê");
        btn_tk.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jpanel_menu_bottomLayout = new javax.swing.GroupLayout(jpanel_menu_bottom);
        jpanel_menu_bottom.setLayout(jpanel_menu_bottomLayout);
        jpanel_menu_bottomLayout.setHorizontalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_dt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(btn_px, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thuoctinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_tk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpanel_menu_bottomLayout.setVerticalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_menu_bottomLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_px, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
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
                .addGap(0, 71, Short.MAX_VALUE)
                .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_menuLayout.createSequentialGroup()
                    .addComponent(jpanel_menu_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 512, Short.MAX_VALUE)))
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

        jLabel1.setText("  Thêm");

        jLabel8.setText("    Sửa");

        jLabel9.setText("   Xóa");

        jlabel_chitiet_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chitiet_nvMouseClicked(evt);
            }
        });

        jLabel11.setText("Chi tiết");

        jLabel13.setText("Nhập Excel");

        jlabel_xuat_excel_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_xuat_excel_nvMouseClicked(evt);
            }
        });

        jLabel15.setText("Xuất Excel");

        javax.swing.GroupLayout jpanel_chucNang_nvLayout = new javax.swing.GroupLayout(jpanel_chucNang_nv);
        jpanel_chucNang_nv.setLayout(jpanel_chucNang_nvLayout);
        jpanel_chucNang_nvLayout.setHorizontalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_nvLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_chitiet_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_nhap_excel_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_xuat_excel_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpanel_chucNang_nvLayout.setVerticalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_xuat_excel_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_nhap_excel_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_chitiet_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addContainerGap())
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

        jpanel_timkiem_nv.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_look_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_look_nvMouseClicked(evt);
            }
        });

        jLabel24.setText("Tìm kiếm theo");

        javax.swing.GroupLayout jpanel_timkiem_nvLayout = new javax.swing.GroupLayout(jpanel_timkiem_nv);
        jpanel_timkiem_nv.setLayout(jpanel_timkiem_nvLayout);
        jpanel_timkiem_nvLayout.setHorizontalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(combobox_find_nv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jpanel_timkiem_nvLayout.setVerticalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_look_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_find_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jlabel_refresh_nv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_refresh_nvMouseClicked(evt);
            }
        });

        jLabel27.setText("Làm mới");

        javax.swing.GroupLayout jpanel_filter_nvLayout = new javax.swing.GroupLayout(jpanel_filter_nv);
        jpanel_filter_nv.setLayout(jpanel_filter_nvLayout);
        jpanel_filter_nvLayout.setHorizontalGroup(
            jpanel_filter_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_filter_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_refresh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpanel_filter_nvLayout.setVerticalGroup(
            jpanel_filter_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_refresh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpn_nvLayout = new javax.swing.GroupLayout(jpn_nv);
        jpn_nv.setLayout(jpn_nvLayout);
        jpn_nvLayout.setHorizontalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_filter_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpn_nvLayout.setVerticalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_filter_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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

        jlabel_chiTiet_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_chiTiet_nccMouseClicked(evt);
            }
        });

        jlabel_xuat_excel_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_xuat_excel_nccMouseClicked(evt);
            }
        });

        jLabel19.setText("  Thêm");

        jLabel20.setText("   Sửa");

        jLabel21.setText("   Xóa");

        jLabel22.setText(" Chi tiết");

        jLabel23.setText("Xuất Excel");

        javax.swing.GroupLayout jpanel_chucNang_nccLayout = new javax.swing.GroupLayout(jpanel_chucNang_ncc);
        jpanel_chucNang_ncc.setLayout(jpanel_chucNang_nccLayout);
        jpanel_chucNang_nccLayout.setHorizontalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jlabel_chiTiet_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_xuat_excel_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpanel_chucNang_nccLayout.setVerticalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_xuat_excel_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlabel_chiTiet_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addContainerGap(10, Short.MAX_VALUE))
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

        jLabel18.setText("Tìm kiếm theo");

        javax.swing.GroupLayout jpanel_timkiem_nccLayout = new javax.swing.GroupLayout(jpanel_timkiem_ncc);
        jpanel_timkiem_ncc.setLayout(jpanel_timkiem_nccLayout);
        jpanel_timkiem_nccLayout.setHorizontalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(combobox_find_ncc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jpanel_timkiem_nccLayout.setVerticalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jlabel_refresh_ncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_refresh_nccMouseClicked(evt);
            }
        });

        jLabel25.setText("Làm mới");

        javax.swing.GroupLayout jpanel_filter_nccLayout = new javax.swing.GroupLayout(jpanel_filter_ncc);
        jpanel_filter_ncc.setLayout(jpanel_filter_nccLayout);
        jpanel_filter_nccLayout.setHorizontalGroup(
            jpanel_filter_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_filter_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_refresh_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpanel_filter_nccLayout.setVerticalGroup(
            jpanel_filter_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filter_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabel_refresh_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpn_nccLayout = new javax.swing.GroupLayout(jpn_ncc);
        jpn_ncc.setLayout(jpn_nccLayout);
        jpn_nccLayout.setHorizontalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_filter_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jpn_nccLayout.setVerticalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jpanel_filter_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(171, Short.MAX_VALUE))
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
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jpn_dt.setBackground(new java.awt.Color(245, 245, 245));

        jpanel_chucNang_dt.setBackground(new java.awt.Color(255, 255, 255));

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

        jpanel_timkiem_dt.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_look_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_look_dtMouseClicked(evt);
            }
        });

        jLabel17.setText("Tìm kiếm theo");

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
                .addComponent(jlabel_look_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpanel_timkiem_dtLayout.setVerticalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_dtLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_look_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        jlabel_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_refreshMouseClicked(evt);
            }
        });

        jLabel5.setText("Làm mới");

        javax.swing.GroupLayout jpanel_filterLayout = new javax.swing.GroupLayout(jpanel_filter);
        jpanel_filter.setLayout(jpanel_filterLayout);
        jpanel_filterLayout.setHorizontalGroup(
            jpanel_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_filterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_filterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpanel_filterLayout.setVerticalGroup(
            jpanel_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanel_filterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabel_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

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
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanel_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jpn_dtLayout.setVerticalGroup(
            jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_dtLayout.createSequentialGroup()
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_dtLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_dtLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpanel_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
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
        jScrollPane4.setViewportView(table_px);

        jLabel10.setText("Khách hàng");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Nhân viên xuất");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Từ số tiền (VND)");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Đến số tiền (VND)");

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
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox9, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpn_pxLayout = new javax.swing.GroupLayout(jpn_px);
        jpn_px.setLayout(jpn_pxLayout);
        jpn_pxLayout.setHorizontalGroup(
            jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_pxLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpn_px1, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpn_pxLayout.setVerticalGroup(
            jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
            .addGroup(jpn_pxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_px1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpanel_chucNang_khLayout.setVerticalGroup(
            jpanel_chucNang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_khLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_chucNang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        jScrollPane6.setViewportView(table_kh);

        javax.swing.GroupLayout jpn_kh1Layout = new javax.swing.GroupLayout(jpn_kh1);
        jpn_kh1.setLayout(jpn_kh1Layout);
        jpn_kh1Layout.setHorizontalGroup(
            jpn_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_kh1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpn_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_kh1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpanel_chucNang_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jpn_kh1Layout.setVerticalGroup(
            jpn_kh1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_kh1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jpanel_chucNang_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        reset_kh.setText("Làm mới");
        reset_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_khActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reset_kh)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset_kh)
                    .addComponent(txt_search_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(526, Short.MAX_VALUE))
            .addGroup(jpn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_khLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpn_kh1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jpn_tkLayout = new javax.swing.GroupLayout(jpn_tk);
        jpn_tk.setLayout(jpn_tkLayout);
        jpn_tkLayout.setHorizontalGroup(
            jpn_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        jpn_tkLayout.setVerticalGroup(
            jpn_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpn_pnLayout = new javax.swing.GroupLayout(jpn_pn);
        jpn_pn.setLayout(jpn_pnLayout);
        jpn_pnLayout.setHorizontalGroup(
            jpn_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        jpn_pnLayout.setVerticalGroup(
            jpn_pnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1237, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1023, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 201, Short.MAX_VALUE)
                    .addComponent(jpn_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 197, Short.MAX_VALUE)
                    .addComponent(jpn_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 205, Short.MAX_VALUE)
                    .addComponent(jpn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 207, Short.MAX_VALUE)
                    .addComponent(jpn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 207, Short.MAX_VALUE)
                    .addComponent(jpn_px, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 206, Short.MAX_VALUE)
                    .addComponent(jpn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 207, Short.MAX_VALUE)
                    .addComponent(jpn_tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 207, Short.MAX_VALUE)
                    .addComponent(jpn_pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_thuoctinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jpn_px, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jpn_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_tk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_pn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        int maNV =Integer.parseInt(table_nv.getValueAt(vitriRow, 0).toString());
        String hoTen = table_nv.getValueAt(vitriRow, 1).toString();
        Date ngaySinh = (Date) table_nv.getValueAt(vitriRow, 2);
        String gioiTinh = table_nv.getValueAt(vitriRow, 3).toString();
        String sdt = table_nv.getValueAt(vitriRow, 4).toString();
        NhanVienDTO nv=new NhanVienDTO(maNV,hoTen,ngaySinh,gioiTinh,sdt);
        EditNhanVienJFrame editNVJFrame = new EditNhanVienJFrame(nv, this);
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
        int confirm=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa không","Xóa nhân viên",
                JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION)
            new NhanVienDAO().deleteNhanVien(maNV);
        listNV=new NhanVienDAO().listNV();
        func.addDataTableNV(listNV, table_nv);
        func.centerTable(table_nv);
    }//GEN-LAST:event_jlabel_delete_nvMouseClicked

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
    //Hàm xử lý khi nhấn vào jlabel_delete của đối tượng nhà cung cấp
    private void jlabel_delete_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_nccMouseClicked
        int vitriRow = table_ncc.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp để xóa", "Error", 0);
            return;
        }
        int maNCC =Integer.parseInt(table_ncc.getValueAt(vitriRow, 0).toString());
        int confirm=JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa không","Xác nhận xóa",
                JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            new NhaCungCapDAO().deleteNhaCungCap(maNCC);
        }
        listNCC=new NhaCungCapDAO().listNCC();
        func.addDataTableNCC(listNCC,table_ncc);
        func.centerTable(table_ncc);
    }//GEN-LAST:event_jlabel_delete_nccMouseClicked
    //Hàm xử lý khi nhấn vào jlabel_add của đối tượng nhà cung cấp
    private void jlabel_add_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_nccMouseClicked
        AddNhaCungCapFrame addNCCJFrame = new AddNhaCungCapFrame(this);
        addNCCJFrame.setVisible(true);
        addNCCJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_nccMouseClicked
    //Hàm xử lý khi nhấn vào jlabel_update của đối tượng nhà cung cấp
    private void jlabel_update_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_nccMouseClicked
        int vitriRow = table_ncc.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà cung cấp để update", "Error", 0);
            return;
        }
        int maNCC =Integer.parseInt(table_ncc.getValueAt(vitriRow, 0).toString());
        String tenNCC = table_ncc.getValueAt(vitriRow, 1).toString();
        String address = table_ncc.getValueAt(vitriRow, 2).toString();
        String sdt = table_ncc.getValueAt(vitriRow, 3).toString();
        String email = table_ncc.getValueAt(vitriRow, 4).toString();
        NhaCungCapDTO ncc=new NhaCungCapDTO(maNCC, tenNCC, address, sdt, email);
        EditNhaCungCapJFrame editNCCJFrame = new EditNhaCungCapJFrame( ncc,this);
        editNCCJFrame.setVisible(true);
        editNCCJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_nccMouseClicked

   
    //Hàm tìm kiếm nhà cung cấp
    private void jlabel_look_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_nccMouseClicked
        String choose_combobox=combobox_find_ncc.getSelectedItem().toString();
        String find_text=jtf_find_ncc.getText().toLowerCase();
        listNCC=new NhaCungCapDAO().listNCC();
        if(choose_combobox.equals("Tất cả")){
            listNCCFilter.clear();
            for(NhaCungCapDTO ncc : listNCC){
                String tenNCC=ncc.getName().toLowerCase();
                String sdt=ncc.getSDT().toLowerCase();
                String email=ncc.getEmail().toLowerCase();
                String address=ncc.getAddress().toLowerCase();
                if(tenNCC.contains(find_text)||email.contains(find_text)||sdt.contains(find_text)||address.contains(find_text))
                    listNCCFilter.add(ncc);
            }
        }
        else if(choose_combobox.equals("Tên nhà cung cấp")){
            listNCCFilter.clear();
            for(NhaCungCapDTO ncc :listNCC){
                String tenNCC=ncc.getName().toLowerCase();
                if(tenNCC.contains(find_text))
                    listNCCFilter.add(ncc);
            }
        }
        else if(choose_combobox.equals("Số điện thoại")){
            listNCCFilter.clear();
            for(NhaCungCapDTO ncc :listNCC){
                String sdt=ncc.getSDT().toLowerCase();
                if(sdt.contains(find_text))
                    listNCCFilter.add(ncc);
            }
        }
        else if(choose_combobox.equals("Email")){
            listNCCFilter.clear();
            for(NhaCungCapDTO ncc :listNCC){
                String email=ncc.getEmail().toLowerCase();
                if(email.contains(find_text))
                    listNCCFilter.add(ncc);
            }
        }
        else{
            listNCCFilter.clear();
            for(NhaCungCapDTO ncc :listNCC){
                String address=ncc.getAddress().toLowerCase();
                if(address.contains(find_text))
                    listNCCFilter.add(ncc);
            }
        }
        func.addDataTableNCC(listNCCFilter, table_ncc);
        func.centerTable(table_ncc);
    }//GEN-LAST:event_jlabel_look_nccMouseClicked
    //Hàm tìm kiếm điện thoại
    private void jlabel_look_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_dtMouseClicked
        String choose_combobox = combobox_find_dt.getSelectedItem().toString();
        String find_text = jtf_find_dt.getText().toLowerCase();
        listDT = new DienThoaiDAO().listDT();
        if (choose_combobox.equals("Tất cả")) {
            listDTFilter.clear();
            mapHDH = new HeDieuHanhDAO().listMapHDH();
            mapThuongHieu = new ThuongHieuDAO().listMapThuongHieu();
            for (DienThoaiDTO dt : listDT) {
                String tenDT = dt.getTenDT().toLowerCase();
                String tenHDH = func.getKey(mapHDH, dt.getHeDieuHanh()).toLowerCase();
                String tenThuongHieu = func.getKey(mapThuongHieu, dt.getThuongHieu()).toLowerCase();
                String chipXuLy = dt.getChipXuLy().toLowerCase();
                String dungLuongPin = String.valueOf(dt.getDungLuongPin()).toLowerCase();
                String kichThuocMan = String.valueOf(dt.getKichThuocMan()).toLowerCase();
                String maDT = String.valueOf(dt.getMaDT()).toLowerCase();
                if (tenDT.contains(find_text)|| tenHDH.contains(find_text)|| tenThuongHieu.contains(find_text)|| chipXuLy.contains(find_text)|| dungLuongPin.contains(find_text)|| kichThuocMan.contains(find_text)|| maDT.contains(find_text)) 
                    listDTFilter.add(dt);
            }
        }
        else if (choose_combobox.equals("Hệ điều hành")) {
            listDTFilter.clear();
            mapHDH = new HeDieuHanhDAO().listMapHDH();
            for (DienThoaiDTO dt : listDT) {
                String tenHDH = func.getKey(mapHDH, dt.getHeDieuHanh());
                if (tenHDH.toLowerCase().contains(find_text)) {
                    listDTFilter.add(dt);
                }
            }
        }
        else if(choose_combobox.equals("Thương hiệu")){
            listDTFilter.clear();
            mapThuongHieu = new ThuongHieuDAO().listMapThuongHieu();
            for (DienThoaiDTO dt : listDT) {
                String tenThuongHieu = func.getKey(mapThuongHieu, dt.getThuongHieu());
                if (tenThuongHieu.toLowerCase().contains(find_text)) {
                    listDTFilter.add(dt);
                }
            }
        }
        else if(choose_combobox.equals("Tên điện thoại")){
            listDTFilter.clear();
            for (DienThoaiDTO dt : listDT) {
                if (dt.getTenDT().toLowerCase().contains(find_text)) {
                    listDTFilter.add(dt);
                }
            }
        }
        else if(choose_combobox.equals("Chip xử lý")){
            listDTFilter.clear();
            for (DienThoaiDTO dt : listDT) {
                if (dt.getChipXuLy().toLowerCase().contains(find_text)) {
                    listDTFilter.add(dt);
                }
            }
        }
        func.addDataTableDienThoai(listDTFilter, table_dt);
        func.centerTable(table_dt);
    }//GEN-LAST:event_jlabel_look_dtMouseClicked
    
    //Hàm xử lí khi nhấn vào jlabel_update của đối tượng Điện Thoại
    private void jlabel_update_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_dtMouseClicked
        int vitriRow=table_dt.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn điện thoại để cập nhật","Error",0);
            return;
        }
        int maDT=Integer.parseInt(table_dt.getValueAt(vitriRow,0).toString());
        String tenDT=table_dt.getValueAt(vitriRow,1).toString();
        HashMap<String,Integer> mapHDH=new HeDieuHanhDAO().listMapHDH();
        int maHDH=mapHDH.get(table_dt.getValueAt(vitriRow,2).toString());
        HashMap<String,Integer> mapThuongHieu=new ThuongHieuDAO().listMapThuongHieu();
        int maThuongHieu=mapThuongHieu.get(table_dt.getValueAt(vitriRow,3).toString());
        String tenThuongHieu=table_dt.getValueAt(vitriRow,3).toString();
        String tenChip=table_dt.getValueAt(vitriRow,4).toString();
        int dungLuongPin=Integer.parseInt(table_dt.getValueAt(vitriRow,5).toString().replaceAll("mAh",""));
        double kichThuocMan=Double.parseDouble(table_dt.getValueAt(vitriRow, 6).toString().replaceAll("inch",""));
        String hinhAnh=new DienThoaiDAO().getHinhAnh(maDT);
        dt=new DienThoaiDTO(maDT,tenDT,maHDH,maThuongHieu,tenChip, dungLuongPin, kichThuocMan,hinhAnh);
        EditDienThoaiJFrame editDT=new EditDienThoaiJFrame(dt, this);
        editDT.setVisible(true);
        editDT.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_dtMouseClicked

    private void jlabel_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_refreshMouseClicked
        listDT=new DienThoaiDAO().listDT();
        func.addDataTableDienThoai(listDT, table_dt);
        func.centerTable(table_dt);
    }//GEN-LAST:event_jlabel_refreshMouseClicked

    private void jlabel_chiTiet_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTiet_dtMouseClicked
        int vitriRow=table_dt.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn đối tượng để xem chi tiết","Error",0);
            return;
        }
        int maDT=Integer.parseInt(table_dt.getValueAt(vitriRow,0).toString());
        String tenDT=table_dt.getValueAt(vitriRow,1).toString();
        HashMap<String,Integer> mapHDH=new HeDieuHanhDAO().listMapHDH();
        int maHDH=mapHDH.get(table_dt.getValueAt(vitriRow,2).toString());
        HashMap<String,Integer> mapThuongHieu=new ThuongHieuDAO().listMapThuongHieu();
        int maThuongHieu=mapThuongHieu.get(table_dt.getValueAt(vitriRow,3).toString());
        String tenThuongHieu=table_dt.getValueAt(vitriRow,3).toString();
        String tenChip=table_dt.getValueAt(vitriRow,4).toString();
        int dungLuongPin=Integer.parseInt(table_dt.getValueAt(vitriRow,5).toString().replaceAll("mAh",""));
        double kichThuocMan=Double.parseDouble(table_dt.getValueAt(vitriRow, 6).toString().replaceAll("inch",""));
        String hinhAnh=new DienThoaiDAO().getHinhAnh(maDT);
        dt=new DienThoaiDTO(maDT,tenDT,maHDH,maThuongHieu,tenChip, dungLuongPin, kichThuocMan,hinhAnh);
        DetailsDienThoaiJFrame detailsDT=new DetailsDienThoaiJFrame(dt);
        detailsDT.setVisible(true);
        detailsDT.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_chiTiet_dtMouseClicked

    private void jlabel_delete_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_dtMouseClicked
        int vitriRow=table_dt.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn điện thoại để xóa","Error",0);
            return;
        }
        int maDT=Integer.parseInt(table_dt.getValueAt(vitriRow,0).toString());
        int confirm=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa phiên bản này không","Xác nhận xóa",
                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(confirm==JOptionPane.YES_OPTION){
            new DienThoaiDAO().deleteDienThoai(maDT);
            func.addDataTableDienThoai(new DienThoaiDAO().listDT(), table_dt);
            func.centerTable(table_dt);
        }
    }//GEN-LAST:event_jlabel_delete_dtMouseClicked

    private void jlabel_update_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_pxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlabel_update_pxMouseClicked

    private void jlabel_add_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_pxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlabel_add_pxMouseClicked

    private void jlabel_delete_pxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_pxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlabel_delete_pxMouseClicked

    private void reset_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_pxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_pxActionPerformed

    private void txt_search_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_pxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_pxActionPerformed

    private void btn_nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nvActionPerformed

    private void btn_thuoctinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thuoctinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_thuoctinhActionPerformed

    private void btn_pxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pxActionPerformed

    private void reset_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_khActionPerformed
        // TODO add your handling code here:
        txt_search_kh.setText("");
        cbb_search_kh.setSelectedIndex(0);
        addDataTableKhachHang();
        table_kh.setRowSorter(null);
    }//GEN-LAST:event_reset_khActionPerformed
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

    private void jlabel_add_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_khMouseClicked
        // TODO add your handling code herea
        AddKhachHang addKH = new AddKhachHang(this);
        addKH.setVisible(true);
        addKH.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_khMouseClicked

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
        EditKhachHang editKh = new EditKhachHang(maKh,tenKh,sdtKh,diachiKh, this);
        editKh.setVisible(true);
        editKh.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_khMouseClicked
    //Hàm xem chi tiết nhân viên
    private void jlabel_chitiet_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chitiet_nvMouseClicked
        int vitriRow=table_nv.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhân viên","Error",0);
            return;
        }
        String hoTen=table_nv.getValueAt(vitriRow,1).toString();
        Date ngaySinh=(Date) table_nv.getValueAt(vitriRow,2);
        String gioiTinh=table_nv.getValueAt(vitriRow,3).toString();
        String sdt = table_nv.getValueAt(vitriRow, 4).toString();
        NhanVienDTO nv=new NhanVienDTO(hoTen,ngaySinh,gioiTinh,sdt);
        DetailsNhanVienJFrame detailsNV=new DetailsNhanVienJFrame(nv);
        detailsNV.setVisible(true);
    }//GEN-LAST:event_jlabel_chitiet_nvMouseClicked

    private void jlabel_excelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_excelMouseClicked
        try {
            func.exportJTableToExcel(table_dt);
        } catch (IOException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlabel_excelMouseClicked

    private void jlabel_xuat_excel_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_xuat_excel_nvMouseClicked
        try {
            Func_class.exportJTableToExcel(table_dt);
        } catch (IOException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlabel_xuat_excel_nvMouseClicked
    //Hàm tìm kiếm nhân viên
    private void jlabel_look_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_look_nvMouseClicked
        String choose_combobox = combobox_find_nv.getSelectedItem().toString();
        String find_text = jtf_find_nv.getText().toLowerCase();
        listNV = new NhanVienDAO().listNV();
        if (choose_combobox.equals("Tất cả")) {
            listNVFilter.clear();
            for (NhanVienDTO nv : listNV) {
                String hoTen = nv.getHoTen().toLowerCase();
                String sdt = nv.getSDT().toLowerCase();
                String gioiTinh = nv.getGioiTinh().toLowerCase();
                String ngaySinh = String.valueOf(nv.getNgaySinh()).toLowerCase();
                if (hoTen.contains(find_text) || sdt.contains(find_text) || gioiTinh.contains(find_text) || ngaySinh.contains(find_text)) {
                    listNVFilter.add(nv);
                }
            }
        } else if (choose_combobox.equals("Tên nhân viên")) {
            listNVFilter.clear();
            for (NhanVienDTO nv : listNV) {
                String hoTen = nv.getHoTen().toLowerCase();
                if (hoTen.contains(find_text)) {
                    listNVFilter.add(nv);
                }
            }
        } else if (choose_combobox.equals("Số điện thoại")) {
            listNVFilter.clear();
            for (NhanVienDTO nv : listNV) {
                String sdt = nv.getSDT().toLowerCase();
                if (sdt.contains(find_text)) {
                    listNVFilter.add(nv);
                }
            }
        } else if (choose_combobox.equals("Email")) {
            listNVFilter.clear();
            for (NhanVienDTO nv : listNV) {
                String gioiTinh = nv.getGioiTinh().toLowerCase();
                if (gioiTinh.contains(find_text)) {
                    listNVFilter.add(nv);
                }
            }
        } else {
            listNVFilter.clear();
            for (NhanVienDTO nv : listNV) {
                String ngaySinh = String.valueOf(nv.getNgaySinh()).toLowerCase();
                if (ngaySinh.contains(find_text)) {
                    listNVFilter.add(nv);
                }
            }
        }
        func.addDataTableNV(listNVFilter, table_nv);
        func.centerTable(table_nv);
    }//GEN-LAST:event_jlabel_look_nvMouseClicked

    private void jlabel_chiTiet_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_chiTiet_nccMouseClicked
        int vitriRow=table_ncc.getSelectedRow();
        if(vitriRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhà cung cấp","Error",0);
            return;
        }
        String tenNCC=table_ncc.getValueAt(vitriRow,1).toString();
        String address=table_ncc.getValueAt(vitriRow,2).toString();
        String sdt=table_ncc.getValueAt(vitriRow,3).toString();
        String email=table_ncc.getValueAt(vitriRow,4).toString();
        NhaCungCapDTO ncc=new NhaCungCapDTO(tenNCC, address, sdt, email);
        DetailsNhaCungCap detailsNCC=new DetailsNhaCungCap(ncc);
        detailsNCC.setVisible(true);
    }//GEN-LAST:event_jlabel_chiTiet_nccMouseClicked

    private void jlabel_xuat_excel_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_xuat_excel_nccMouseClicked
        try {
            Func_class.exportJTableToExcel(table_ncc);
        } catch (IOException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jlabel_xuat_excel_nccMouseClicked

    private void jlabel_refresh_nccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_refresh_nccMouseClicked
        listNCC=new NhaCungCapDAO().listNCC();
        func.addDataTableNCC(listNCC, table_ncc);
        func.centerTable(table_ncc);
    }//GEN-LAST:event_jlabel_refresh_nccMouseClicked

    private void jlabel_refresh_nvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_refresh_nvMouseClicked
        listNV=new NhanVienDAO().listNV();
        func.addDataTableNV(listNV, table_nv);
        func.centerTable(table_nv);
    }//GEN-LAST:event_jlabel_refresh_nvMouseClicked
    //Hàm lấy bảng nhân viên
    public JTable getTableNhanVien() {
        return table_nv;
    }
    //Hàm lấy bảng nhà cung cấp
    public JTable getTableNhaCungCap() {
        return table_ncc;
    }
    //Hàm lấy bảng điện thoại
    public JTable getTableDienThoai() {
        return table_dt;
    }
    public JTable getTableKhachHang(){
        return table_kh;
    }
    
    //Hàm thêm dữ liệu vào bảng khách hàng
    public void addDataTableKhachHang() {
        KhachHangDAO dao = new KhachHangDAO();
        ArrayList<KhachHangDTO> dsKH = dao.listKh();
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (KhachHangDTO kh : dsKH) {
            model.addRow(new Object[]{
                kh.getID(), kh.getName(), kh.getAddress(), kh.getSDT()
            });
        }
        table_kh.setModel(model);
        System.out.println("Đã cập nhật model table_kh với " + dsKH.size() + " dòng.");
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
    private javax.swing.JButton btn_pn;
    private javax.swing.JButton btn_px;
    private javax.swing.JButton btn_ram;
    private javax.swing.JButton btn_rom;
    private javax.swing.JButton btn_thuoctinh;
    private javax.swing.JButton btn_thuongHieu;
    private javax.swing.JButton btn_tk;
    private javax.swing.JComboBox<String> cbb_search_kh;
    private javax.swing.JComboBox<String> cbb_search_px;
    private javax.swing.JComboBox<String> combobox_find_dt;
    private javax.swing.JComboBox<String> combobox_find_ncc;
    private javax.swing.JComboBox<String> combobox_find_nv;
    private javax.swing.JLabel img_store;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jlabel_add_dt;
    private javax.swing.JLabel jlabel_add_kh;
    private javax.swing.JLabel jlabel_add_ncc;
    private javax.swing.JLabel jlabel_add_nv;
    private javax.swing.JLabel jlabel_add_px;
    private javax.swing.JLabel jlabel_chiTiet_dt;
    private javax.swing.JLabel jlabel_chiTiet_ncc;
    private javax.swing.JLabel jlabel_chitiet_nv;
    private javax.swing.JLabel jlabel_delete_dt;
    private javax.swing.JLabel jlabel_delete_kh;
    private javax.swing.JLabel jlabel_delete_ncc;
    private javax.swing.JLabel jlabel_delete_nv;
    private javax.swing.JLabel jlabel_delete_px;
    private javax.swing.JLabel jlabel_excel;
    private javax.swing.JLabel jlabel_look_dt;
    private javax.swing.JLabel jlabel_look_ncc;
    private javax.swing.JLabel jlabel_look_nv;
    private javax.swing.JLabel jlabel_nhap_excel_nv;
    private javax.swing.JLabel jlabel_refresh;
    private javax.swing.JLabel jlabel_refresh_ncc;
    private javax.swing.JLabel jlabel_refresh_nv;
    private javax.swing.JLabel jlabel_update_dt;
    private javax.swing.JLabel jlabel_update_kh;
    private javax.swing.JLabel jlabel_update_ncc;
    private javax.swing.JLabel jlabel_update_nv;
    private javax.swing.JLabel jlabel_update_px;
    private javax.swing.JLabel jlabel_xuat_excel_ncc;
    private javax.swing.JLabel jlabel_xuat_excel_nv;
    private javax.swing.JPanel jpanel_chucNang_dt;
    private javax.swing.JPanel jpanel_chucNang_kh;
    private javax.swing.JPanel jpanel_chucNang_ncc;
    private javax.swing.JPanel jpanel_chucNang_nv;
    private javax.swing.JPanel jpanel_chucNang_px;
    private javax.swing.JPanel jpanel_filter;
    private javax.swing.JPanel jpanel_filter_ncc;
    private javax.swing.JPanel jpanel_filter_nv;
    private javax.swing.JPanel jpanel_menu;
    private javax.swing.JPanel jpanel_menu_bottom;
    private javax.swing.JPanel jpanel_menu_top;
    private javax.swing.JPanel jpanel_timkiem_dt;
    private javax.swing.JPanel jpanel_timkiem_ncc;
    private javax.swing.JPanel jpanel_timkiem_nv;
    private javax.swing.JPanel jpn_dt;
    private javax.swing.JPanel jpn_kh;
    private javax.swing.JPanel jpn_kh1;
    private javax.swing.JPanel jpn_ncc;
    private javax.swing.JPanel jpn_nv;
    private javax.swing.JPanel jpn_pn;
    private javax.swing.JPanel jpn_px;
    private javax.swing.JPanel jpn_px1;
    private javax.swing.JPanel jpn_thuoctinh;
    private javax.swing.JPanel jpn_tk;
    private javax.swing.JTextField jtf_find_dt;
    private javax.swing.JTextField jtf_find_ncc;
    private javax.swing.JTextField jtf_find_nv;
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
