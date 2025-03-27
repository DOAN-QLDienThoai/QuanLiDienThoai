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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SwingConstants;


public class MainJFrame extends javax.swing.JFrame {

    JButton[] btns = new JButton[5];
    JPanel[] jpns = new JPanel[5];
     JButton currentActiveBtn = null;
    Func_class func = new Func_class();
    NhanVienDAO nvDAO = new NhanVienDAO();
    Border etchedBorder = BorderFactory.createEtchedBorder();

    public MainJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        khoitaoJPanel();
        khoitaoButtonInMenu();
        actionJButtonMenu();
        setBtnMenu();
        setBtnMenu(); // reset style trước
        styleAllButtonMenu(); // 👉 thêm dòng này để làm đẹp nút menu
        setBackgroundJButton(btn_nv);
        showPanel(jpn_nv);
        addDataTableNhanVien();
        addDataTableDienThoai();
        addDataTableNhaCungCap();
        setBorderForJPanelTitle();
        setCusorPointer();
        setUpTable();
        setIconForJlabel();
    }

    public void khoitaoJPanel() {
        jpns[0] = jpn_nv;
        jpns[1] = jpn_ncc;
        jpns[2] = jpn_thuoctinh;
        jpns[3] = jpn_dt;
        jpns[4] = jpn_kh;
    }

    public void khoitaoButtonInMenu() {
        btns[0] = btn_nv;
        btns[1] = btn_thuoctinh;
        btns[2] = btn_dt;
        btns[3] = btn_ncc;
        btns[4] = btn_kh;
    }

    public void setBtnMenu() {
        for (JButton btn : btns) {
            btn.setFocusPainted(false);
            btn.setBorder(null);
            btn.setBackground(new Color(211, 218, 211));
        }
    }



    public void setUpTable() {
        func.centerTable(table_nv);
        func.centerTable(table_ncc);
        func.centerTable(table_dt);
        func.setUpTable(table_nv);
        func.setUpTable(table_ncc);
        func.setUpTable(table_dt);
        func.setUpTable(table_kh);
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
        btn_ncc.setIcon(new FlatSVGIcon("./resources/icon/ncc.svg",0.6f));
        btn_dt.setIcon(new FlatSVGIcon("./resources/icon/phone.svg",0.6f));
        btn_thuoctinh.setIcon(new FlatSVGIcon("./resources/icon/thuoctinh.svg",0.6f));
        btn_hdh.setIcon(new FlatSVGIcon("./resources/icon/os.svg"));
        btn_mausac.setIcon(new FlatSVGIcon("./resources/icon/color.svg"));
        btn_ram.setIcon(new FlatSVGIcon("./resources/icon/ram.svg"));
        btn_rom.setIcon(new FlatSVGIcon("./resources/icon/rom.svg"));
        btn_thuongHieu.setIcon(new FlatSVGIcon("./resources/icon/thuonghieu.svg"));
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
    }


    public void setBorderForJPanelTitle() {
     jpanel_menu_top.setBorder(etchedBorder);
    }
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
             if (btn == currentActiveBtn) return; // đang active thì không reset
             btn.setBackground(new Color(211,218,211)); // reset về màu gốc
        }
    });
}
    public void styleAllButtonMenu() {
    for (JButton btn : btns) {
        styleButtonMenu(btn);
    }
    styleButtonMenu(btn_kh); // nếu chưa có trong mảng
}

    public void search() {
        DefaultTableModel model = (DefaultTableModel) this.table_nv.getModel(); //Lấy dữ liệu defaultTableModel của bảng
        TableRowSorter<DefaultTableModel> sort = new TableRowSorter<>(model); //tạo đối tượng sort thuộc kiểu TableRowSorter để lọc model từ bảng(TableRowSorter giúp có thể lọc dữ liệu từ bảng)
        table_nv.setRowSorter(sort); //Kích hoạt sắp xếp cho bảng và lọc
        String textFind = jtf_find.getText().toLowerCase().trim();// chuyển text về chữ thường
        if (textFind.equals("")) {
            sort.setRowFilter(null);
        } else {
            sort.setRowFilter(RowFilter.regexFilter("(?i)" + textFind));
        }
    }

    public void search_KQ() {
        this.jtf_find.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }

        });
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
                            case "Khách Hàng":{
                                showPanel(jpn_kh);
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
            menuitem.setBackground(new Color(211,218,211));
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
        jpn_nv = new javax.swing.JPanel();
        jpanel_chucNang_nv = new javax.swing.JPanel();
        jlabel_update_nv = new javax.swing.JLabel();
        jlabel_add_nv = new javax.swing.JLabel();
        jlabel_delete_nv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_nv = new javax.swing.JTable();
        jpanel_timkiem_nv = new javax.swing.JPanel();
        jtf_find = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jpn_ncc = new javax.swing.JPanel();
        jpanel_chucNang_ncc = new javax.swing.JPanel();
        jlabel_update_ncc = new javax.swing.JLabel();
        jlabel_add_ncc = new javax.swing.JLabel();
        jlabel_delete_ncc = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ncc = new javax.swing.JTable();
        jpanel_timkiem_ncc = new javax.swing.JPanel();
        jtf_find_ncc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
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
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jpn_kh = new javax.swing.JPanel();
        jpn_chucnang_kh = new javax.swing.JPanel();
        btn_add_kh = new javax.swing.JButton();
        btn_sua_kh = new javax.swing.JButton();
        btn_xoa_kh = new javax.swing.JButton();
        btn_xuatexcel_kh = new javax.swing.JButton();
        btn_ct_kh = new javax.swing.JButton();
        btn_nhapexcel_kh = new javax.swing.JButton();
        ccb_kh = new javax.swing.JComboBox<>();
        txtTimkiemKh = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();
        jpn_table_kh = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_kh = new javax.swing.JTable();

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

        javax.swing.GroupLayout jpanel_menu_bottomLayout = new javax.swing.GroupLayout(jpanel_menu_bottom);
        jpanel_menu_bottom.setLayout(jpanel_menu_bottomLayout);
        jpanel_menu_bottomLayout.setHorizontalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_menu_bottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ncc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btn_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thuoctinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(262, Short.MAX_VALUE))
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
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_menuLayout.createSequentialGroup()
                    .addComponent(jpanel_menu_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 512, Short.MAX_VALUE)))
        );

        jpn_nv.setBackground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap()
                .addComponent(jlabel_add_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jpanel_chucNang_nvLayout.setVerticalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
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

        jButton1.setText("Làm mới");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpanel_timkiem_nvLayout = new javax.swing.GroupLayout(jpanel_timkiem_nv);
        jpanel_timkiem_nv.setLayout(jpanel_timkiem_nvLayout);
        jpanel_timkiem_nvLayout.setHorizontalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jpanel_timkiem_nvLayout.setVerticalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                        .addComponent(jtf_find)
                        .addGap(1, 1, 1))
                    .addComponent(jComboBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpn_nvLayout = new javax.swing.GroupLayout(jpn_nv);
        jpn_nv.setLayout(jpn_nvLayout);
        jpn_nvLayout.setHorizontalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
        );
        jpn_nvLayout.setVerticalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(559, Short.MAX_VALUE))
            .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_nvLayout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jpn_ncc.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGap(12, 12, 12)
                .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jpanel_chucNang_nccLayout.setVerticalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        table_ncc.setBackground(new java.awt.Color(255, 255, 255));
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

        jButton2.setText("Làm mới");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpanel_timkiem_nccLayout = new javax.swing.GroupLayout(jpanel_timkiem_ncc);
        jpanel_timkiem_ncc.setLayout(jpanel_timkiem_nccLayout);
        jpanel_timkiem_nccLayout.setHorizontalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(16, 16, 16))
        );
        jpanel_timkiem_nccLayout.setVerticalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jpn_nccLayout = new javax.swing.GroupLayout(jpn_ncc);
        jpn_ncc.setLayout(jpn_nccLayout);
        jpn_nccLayout.setHorizontalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                        .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jpn_nccLayout.setVerticalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
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
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jpn_dt.setBackground(new java.awt.Color(255, 255, 255));

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
                .addGap(17, 17, 17)
                .addComponent(jlabel_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jpanel_chucNang_dtLayout.setVerticalGroup(
            jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        table_dt.setBackground(new java.awt.Color(255, 255, 255));
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

        jButton3.setText("Làm mới");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpanel_timkiem_dtLayout = new javax.swing.GroupLayout(jpanel_timkiem_dt);
        jpanel_timkiem_dt.setLayout(jpanel_timkiem_dtLayout);
        jpanel_timkiem_dtLayout.setHorizontalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_dtLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jpanel_timkiem_dtLayout.setVerticalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_dtLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpn_dtLayout = new javax.swing.GroupLayout(jpn_dt);
        jpn_dt.setLayout(jpn_dtLayout);
        jpn_dtLayout.setHorizontalGroup(
            jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_dtLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_dtLayout.createSequentialGroup()
                        .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jpn_dtLayout.setVerticalGroup(
            jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_dtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_add_kh.setText("Thêm");

        btn_sua_kh.setText("Sửa");

        btn_xoa_kh.setText("Xóa");
        btn_xoa_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_khActionPerformed(evt);
            }
        });

        btn_xuatexcel_kh.setText("Xuất Excel");
        btn_xuatexcel_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatexcel_khActionPerformed(evt);
            }
        });

        btn_ct_kh.setText("Chi tiết");
        btn_ct_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ct_khActionPerformed(evt);
            }
        });

        btn_nhapexcel_kh.setText("Nhập Excel");
        btn_nhapexcel_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhapexcel_khActionPerformed(evt);
            }
        });

        ccb_kh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_reset.setText("Làm mới");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpn_chucnang_khLayout = new javax.swing.GroupLayout(jpn_chucnang_kh);
        jpn_chucnang_kh.setLayout(jpn_chucnang_khLayout);
        jpn_chucnang_khLayout.setHorizontalGroup(
            jpn_chucnang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_chucnang_khLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_add_kh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sua_kh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xoa_kh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ct_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhapexcel_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xuatexcel_kh)
                .addGap(260, 260, 260)
                .addComponent(ccb_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimkiemKh, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reset)
                .addContainerGap())
        );
        jpn_chucnang_khLayout.setVerticalGroup(
            jpn_chucnang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_chucnang_khLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_chucnang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_xuatexcel_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ct_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sua_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xoa_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nhapexcel_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpn_chucnang_khLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jpn_chucnang_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reset)
                    .addComponent(txtTimkiemKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccb_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        table_kh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table_kh);
        if (table_kh.getColumnModel().getColumnCount() > 0) {
            table_kh.getColumnModel().getColumn(0).setResizable(false);
            table_kh.getColumnModel().getColumn(1).setResizable(false);
            table_kh.getColumnModel().getColumn(2).setResizable(false);
            table_kh.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jpn_table_khLayout = new javax.swing.GroupLayout(jpn_table_kh);
        jpn_table_kh.setLayout(jpn_table_khLayout);
        jpn_table_khLayout.setHorizontalGroup(
            jpn_table_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jpn_table_khLayout.setVerticalGroup(
            jpn_table_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpn_khLayout = new javax.swing.GroupLayout(jpn_kh);
        jpn_kh.setLayout(jpn_khLayout);
        jpn_khLayout.setHorizontalGroup(
            jpn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_khLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_chucnang_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jpn_table_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpn_khLayout.setVerticalGroup(
            jpn_khLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_khLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_chucnang_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpn_table_kh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1237, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1025, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 199, Short.MAX_VALUE)
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
                    .addGap(0, 199, Short.MAX_VALUE)
                    .addComponent(jpn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 212, Short.MAX_VALUE)
                    .addComponent(jpn_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_thuoctinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_kh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        RAMJFrame ram=new RAMJFrame();
        ram.setVisible(true);
        ram.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_ramMouseClicked

    private void btn_romMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_romMouseClicked
        ROMJFrame rom=new ROMJFrame();
        rom.setVisible(true);
        rom.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_romMouseClicked

    private void btn_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mausacMouseClicked
        MauSacJFrame ms=new MauSacJFrame();
        ms.setVisible(true);
        ms.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_mausacMouseClicked

    private void btn_hdhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hdhMouseClicked
        HeDieuHanhJFrame hdh=new HeDieuHanhJFrame();
        hdh.setVisible(true);
        hdh.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_hdhMouseClicked

    private void btn_thuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thuongHieuMouseClicked
        ThuongHieuJFrame th=new ThuongHieuJFrame();
        th.setVisible(true);
        th.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_thuongHieuMouseClicked

    private void jlabel_add_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_dtMouseClicked
        AddDienThoaiJFrame dt=new AddDienThoaiJFrame(this);
        dt.setVisible(true);
        dt.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_dtMouseClicked

    private void btn_nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nvActionPerformed

    private void btn_xoa_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_khActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoa_khActionPerformed

    private void btn_xuatexcel_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatexcel_khActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xuatexcel_khActionPerformed

    private void btn_ct_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ct_khActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ct_khActionPerformed

    private void btn_nhapexcel_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhapexcel_khActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nhapexcel_khActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_resetActionPerformed

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

    public JTable getTableNhanVien() {
        return table_nv;
    }

    public JTable getTableNhaCungCap() {
        return table_ncc;
    }
    public JTable getTableDienThoai(){
        return table_dt;
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
    
    public void addDataTableDienThoai() {
        HashMap<String,Integer> mapHDH=new HeDieuHanhDAO().listMapHDH();
        HashMap<String,Integer> mapThuongHieu=new ThuongHieuDAO().listMapThuongHieu();
        DienThoaiDAO dtDAO = new DienThoaiDAO();
        String[] colNames = {"Mã ĐT", "Tên Điện Thoại", "Hệ điều hành", "Thương hiệu", "Chip xử lý", "Dung lượng pin", "Kích thước màn"};
        ArrayList<DienThoaiDTO> listDT = dtDAO.listDT();
        Object[][] rows = new Object[listDT.size()][colNames.length];
        for (int i = 0; i < listDT.size(); i++) {
            rows[i][0] = listDT.get(i).getMaDT();
            rows[i][1] = listDT.get(i).getTenDT();
            int maHDH=listDT.get(i).getHeDieuHanh();
            String tenHDH=null;
            for(Map.Entry<String,Integer> entry : mapHDH.entrySet() ){
                if(maHDH==(entry.getValue()))
                    tenHDH=entry.getKey();
            }
            rows[i][2]=tenHDH;
            int maThuongHieu=listDT.get(i).getThuongHieu();
            String tenThuongHieu=null;
            for(Map.Entry<String,Integer> entry : mapThuongHieu.entrySet() ){
                if(maThuongHieu==(entry.getValue()))
                    tenThuongHieu=entry.getKey();
            }
            rows[i][3] = tenThuongHieu;
            rows[i][4] = listDT.get(i).getChipXuLy();
            rows[i][5] = listDT.get(i).getDungLuongPin()+"mAh";
            rows[i][6] = listDT.get(i).getKichThuocMan()+" inch";
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
    private javax.swing.JButton btn_add_kh;
    private javax.swing.JButton btn_ct_kh;
    private javax.swing.JButton btn_dt;
    private javax.swing.JButton btn_hdh;
    private javax.swing.JButton btn_kh;
    private javax.swing.JButton btn_mausac;
    private javax.swing.JButton btn_ncc;
    private javax.swing.JButton btn_nhapexcel_kh;
    private javax.swing.JButton btn_nv;
    private javax.swing.JButton btn_ram;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_rom;
    private javax.swing.JButton btn_sua_kh;
    private javax.swing.JButton btn_thuoctinh;
    private javax.swing.JButton btn_thuongHieu;
    private javax.swing.JButton btn_xoa_kh;
    private javax.swing.JButton btn_xuatexcel_kh;
    private javax.swing.JComboBox<String> ccb_kh;
    private javax.swing.JLabel img_store;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlabel_add_dt;
    private javax.swing.JLabel jlabel_add_ncc;
    private javax.swing.JLabel jlabel_add_nv;
    private javax.swing.JLabel jlabel_delete_dt;
    private javax.swing.JLabel jlabel_delete_ncc;
    private javax.swing.JLabel jlabel_delete_nv;
    private javax.swing.JLabel jlabel_update_dt;
    private javax.swing.JLabel jlabel_update_ncc;
    private javax.swing.JLabel jlabel_update_nv;
    private javax.swing.JPanel jpanel_chucNang_dt;
    private javax.swing.JPanel jpanel_chucNang_ncc;
    private javax.swing.JPanel jpanel_chucNang_nv;
    private javax.swing.JPanel jpanel_menu;
    private javax.swing.JPanel jpanel_menu_bottom;
    private javax.swing.JPanel jpanel_menu_top;
    private javax.swing.JPanel jpanel_timkiem_dt;
    private javax.swing.JPanel jpanel_timkiem_ncc;
    private javax.swing.JPanel jpanel_timkiem_nv;
    private javax.swing.JPanel jpn_chucnang_kh;
    private javax.swing.JPanel jpn_dt;
    private javax.swing.JPanel jpn_kh;
    private javax.swing.JPanel jpn_ncc;
    private javax.swing.JPanel jpn_nv;
    private javax.swing.JPanel jpn_table_kh;
    private javax.swing.JPanel jpn_thuoctinh;
    private javax.swing.JTextField jtf_find;
    private javax.swing.JTextField jtf_find_dt;
    private javax.swing.JTextField jtf_find_ncc;
    private javax.swing.JTable table_dt;
    private javax.swing.JTable table_kh;
    private javax.swing.JTable table_ncc;
    private javax.swing.JTable table_nv;
    private javax.swing.JTextField txtTimkiemKh;
    // End of variables declaration//GEN-END:variables
}
