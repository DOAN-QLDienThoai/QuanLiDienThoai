/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.HeDieuHanhDAO;
import DAO.MauSacDAO;
import DAO.NhaCungCapDAO;
import DAO.NhanVienDAO;
import DTO.HeDieuHanhDTO;
import DTO.MauSacDTO;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
import Data.DropShadowBorder;
import Data.Func_class;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class MainJFrame extends javax.swing.JFrame {

    JButton[] btns = new JButton[4];
    JPanel[] jpns = new JPanel[6];
    Func_class func = new Func_class();
    NhanVienDAO nvDAO = new NhanVienDAO();
    ArrayList<NhanVienDTO> listNV = nvDAO.listNV();
    Border etchedBorder = BorderFactory.createEtchedBorder();

    public MainJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        khoitaoJPanel();
        khoitaoButtonInMenu();
        actionJButtonMenu();
        setBtnMenu();
        setShadowforJPN();
        setBackgroundJButton(btn_nv);
        showPanel(jpn_nv);
        addDataTableNhanVien();
        addDataTableNhaCungCap();
        addDataTableHeDieuHanh();
        addDataTableMauSac();
        setBorderForJPanelTitle();
        setBorderForJpanel();
        setCusorPointer();
        setUpTable();
        setIconForJlabel();
    }

    public void khoitaoJPanel() {
        jpns[0] = jpn_nv;
        jpns[1] = jpn_ncc;
        jpns[2] = jpn_thuoctinh;
        jpns[3] = jpn_hdh;
        jpns[4] = jpn_mausac;
        jpns[5] = jpn_dt;
    }

    public void khoitaoButtonInMenu() {
        btns[0] = btn_nv;
        btns[1] = btn_thuoctinh;
        btns[2] = btn_dt;
        btns[3] = btn_ncc;
    }

    public void setBtnMenu() {
        for (JButton btn : btns) {
            btn.setFocusPainted(false);
            btn.setBorder(null);
            btn.setBackground(new Color(211, 218, 211));
        }
    }

    public void setShadowforJPN() {
        jpanel_chucNang_nv.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_nv.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_dt.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_ncc.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_hdh.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_chucNang_mauSac.setBorder(new DropShadowBorder(2, Color.BLACK));
        jpanel_timkiem_dt.setBorder(new DropShadowBorder(2, Color.BLACK));
    }

    public void setUpTable() {
        func.centerTable(table_hdh);
        func.centerTable(table_nv);
        func.centerTable(table_ncc);
        func.centerTable(table_mausac);
        func.centerTable(table_dt);
        func.setUpTable(table_nv);
        func.setUpTable(table_ncc);
        func.setUpTable(table_hdh);
        func.setUpTable(table_mausac);
        func.setUpTable(table_dt);
    }

    public void setIconForJlabel() {
        jlabel_add_ncc.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_ncc.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_ncc.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_add_nv.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_nv.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_nv.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_add_hdh.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_hdh.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_hdh.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_add_mausac.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_mausac.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_mausac.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_add_dt.setIcon(new FlatSVGIcon("./resources/icon/add.svg", 0.06f));
        jlabel_update_dt.setIcon(new FlatSVGIcon("./resources/icon/update.svg", 0.85f));
        jlabel_delete_dt.setIcon(new FlatSVGIcon("./resources/icon/delete.svg", 0.75f));
        jlabel_look.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        jlabel_look_ncc.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        jlabel_look_dt.setIcon(new FlatSVGIcon("./resources/icon/look.svg", 0.9f));
        btn_nv.setIcon(new FlatSVGIcon("./resources/icon/nhanvien.svg", 0.6f));
        btn_ncc.setIcon(new FlatSVGIcon("./resources/icon/ncc.svg",0.6f));
        btn_dt.setIcon(new FlatSVGIcon("./resources/icon/phone.svg",0.6f));
        btn_thuoctinh.setIcon(new FlatSVGIcon("./resources/icon/thuoctinh.svg",0.6f));
    }

    public void setCusorPointer() {
        func.cursorPointer(jlabel_add_nv);
        func.cursorPointer(jlabel_update_nv);
        func.cursorPointer(jlabel_delete_nv);
        func.cursorPointer(jlabel_add_ncc);
        func.cursorPointer(jlabel_update_ncc);
        func.cursorPointer(jlabel_delete_ncc);
        func.cursorPointer(jlabel_add_hdh);
        func.cursorPointer(jlabel_update_hdh);
        func.cursorPointer(jlabel_delete_hdh);
        func.cursorPointer(jlabel_add_mausac);
        func.cursorPointer(jlabel_update_mausac);
        func.cursorPointer(jlabel_delete_mausac);
        func.cursorPointer(jlabel_add_dt);
        func.cursorPointer(jlabel_update_dt);
        func.cursorPointer(jlabel_delete_dt);
        func.cursorPointer(jlabel_look);
        func.cursorPointer(jlabel_look_ncc);
        func.cursorPointer(jlabel_look_dt);
    }

    public void setBorderForJpanel() {
        jpanel_menu.setBorder(etchedBorder);
        for (JPanel pn : jpns) {
            pn.setBorder(etchedBorder);
        }
    }

    public void setBorderForJPanelTitle() {
        jpanel_nv_title.setBorder(etchedBorder);
        jpanel_thuoctinh_title.setBorder(etchedBorder);
        jpanel_hdh_title.setBorder(etchedBorder);
        jpanel_mausac_title.setBorder(etchedBorder);
        jpanel_ncc_title.setBorder(etchedBorder);
        jpanel_menu_top.setBorder(etchedBorder);
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
                                for (MouseListener ml : btn_hdh.getMouseListeners()) {
                                    btn_hdh.removeMouseListener(ml);
                                }
                                btn_hdh.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        showPanel(jpn_hdh);
                                    }
                                });
                                for (MouseListener ml : btn_mausac.getMouseListeners()) {
                                    btn_mausac.removeMouseListener(ml);
                                }
                                btn_mausac.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        showPanel(jpn_mausac);
                                    }
                                });
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
        jpn_nv = new javax.swing.JPanel();
        jpanel_chucNang_nv = new javax.swing.JPanel();
        jlabel_update_nv = new javax.swing.JLabel();
        jlabel_add_nv = new javax.swing.JLabel();
        jlabel_delete_nv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_nv = new javax.swing.JTable();
        jpanel_nv_title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpanel_timkiem_nv = new javax.swing.JPanel();
        jtf_find = new javax.swing.JTextField();
        jlabel_look = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jpn_ncc = new javax.swing.JPanel();
        jpanel_chucNang_ncc = new javax.swing.JPanel();
        jlabel_update_ncc = new javax.swing.JLabel();
        jlabel_add_ncc = new javax.swing.JLabel();
        jlabel_delete_ncc = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ncc = new javax.swing.JTable();
        jpanel_ncc_title = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jpanel_timkiem_ncc = new javax.swing.JPanel();
        jlabel_look_ncc = new javax.swing.JLabel();
        jtf_find_ncc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jpn_hdh = new javax.swing.JPanel();
        jpanel_chucNang_hdh = new javax.swing.JPanel();
        jlabel_update_hdh = new javax.swing.JLabel();
        jlabel_add_hdh = new javax.swing.JLabel();
        jlabel_delete_hdh = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_hdh = new javax.swing.JTable();
        jpanel_hdh_title = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jpn_mausac = new javax.swing.JPanel();
        jpanel_chucNang_mauSac = new javax.swing.JPanel();
        jlabel_update_mausac = new javax.swing.JLabel();
        jlabel_add_mausac = new javax.swing.JLabel();
        jlabel_delete_mausac = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_mausac = new javax.swing.JTable();
        jpanel_mausac_title = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jpn_thuoctinh = new javax.swing.JPanel();
        btn_mausac = new javax.swing.JButton();
        btn_ram_rom = new javax.swing.JButton();
        btn_hdh = new javax.swing.JButton();
        jpanel_thuoctinh_title = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jpn_dt = new javax.swing.JPanel();
        jpanel_chucNang_dt = new javax.swing.JPanel();
        jlabel_add_dt = new javax.swing.JLabel();
        jlabel_delete_dt = new javax.swing.JLabel();
        jlabel_update_dt = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_dt = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jpanel_timkiem_dt = new javax.swing.JPanel();
        jtf_find_dt = new javax.swing.JTextField();
        jlabel_look_dt = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpanel_menu_topLayout = new javax.swing.GroupLayout(jpanel_menu_top);
        jpanel_menu_top.setLayout(jpanel_menu_topLayout);
        jpanel_menu_topLayout.setHorizontalGroup(
            jpanel_menu_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
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

        jpanel_menu_bottom.setBackground(new java.awt.Color(211, 218, 211));

        btn_thuoctinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_thuoctinh.setText("Thuộc Tính");
        btn_thuoctinh.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btn_nv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_nv.setText("Nhân Viên");
        btn_nv.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btn_ncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_ncc.setText("Nhà Cung Cấp");
        btn_ncc.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btn_dt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_dt.setText("Điện Thoại");
        btn_dt.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jpanel_menu_bottomLayout = new javax.swing.GroupLayout(jpanel_menu_bottom);
        jpanel_menu_bottom.setLayout(jpanel_menu_bottomLayout);
        jpanel_menu_bottomLayout.setHorizontalGroup(
            jpanel_menu_bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_thuoctinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_dt, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(btn_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
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
                .addContainerGap(312, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanel_menuLayout = new javax.swing.GroupLayout(jpanel_menu);
        jpanel_menu.setLayout(jpanel_menuLayout);
        jpanel_menuLayout.setHorizontalGroup(
            jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanel_menuLayout.setVerticalGroup(
            jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_menuLayout.createSequentialGroup()
                    .addComponent(jpanel_menu_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 512, Short.MAX_VALUE)))
            .addGroup(jpanel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_menuLayout.createSequentialGroup()
                    .addGap(0, 106, Short.MAX_VALUE)
                    .addComponent(jpanel_menu_bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jpn_nv.setPreferredSize(new java.awt.Dimension(1030, 625));

        jpanel_chucNang_nv.setBackground(new java.awt.Color(211, 218, 211));

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
                .addGap(28, 28, 28)
                .addComponent(jlabel_add_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jlabel_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jpanel_chucNang_nvLayout.setVerticalGroup(
            jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_nvLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_chucNang_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jpanel_nv_title.setBackground(new java.awt.Color(74, 144, 226));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("NHÂN VIÊN");

        javax.swing.GroupLayout jpanel_nv_titleLayout = new javax.swing.GroupLayout(jpanel_nv_title);
        jpanel_nv_title.setLayout(jpanel_nv_titleLayout);
        jpanel_nv_titleLayout.setHorizontalGroup(
            jpanel_nv_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_nv_titleLayout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(jLabel1)
                .addContainerGap(474, Short.MAX_VALUE))
        );
        jpanel_nv_titleLayout.setVerticalGroup(
            jpanel_nv_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_nv_titleLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jpanel_timkiem_nv.setBackground(new java.awt.Color(211, 218, 211));

        jlabel_look.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_lookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_timkiem_nvLayout = new javax.swing.GroupLayout(jpanel_timkiem_nv);
        jpanel_timkiem_nv.setLayout(jpanel_timkiem_nvLayout);
        jpanel_timkiem_nvLayout.setHorizontalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_look, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpanel_timkiem_nvLayout.setVerticalGroup(
            jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nvLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_look, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_find, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jLabel11.setText("Chức năng");

        jLabel6.setText("Tìm kiếm");

        javax.swing.GroupLayout jpn_nvLayout = new javax.swing.GroupLayout(jpn_nv);
        jpn_nv.setLayout(jpn_nvLayout);
        jpn_nvLayout.setHorizontalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(438, Short.MAX_VALUE))
            .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_nvLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(124, Short.MAX_VALUE)))
            .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpanel_nv_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpn_nvLayout.setVerticalGroup(
            jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nvLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanel_chucNang_nv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpn_nvLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanel_timkiem_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(392, Short.MAX_VALUE))
            .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_nvLayout.createSequentialGroup()
                    .addContainerGap(252, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
            .addGroup(jpn_nvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_nvLayout.createSequentialGroup()
                    .addComponent(jpanel_nv_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 545, Short.MAX_VALUE)))
        );

        jpn_ncc.setPreferredSize(new java.awt.Dimension(1030, 625));

        jpanel_chucNang_ncc.setBackground(new java.awt.Color(211, 218, 211));
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
                .addGap(29, 29, 29)
                .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jpanel_chucNang_nccLayout.setVerticalGroup(
            jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanel_chucNang_nccLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlabel_add_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanel_chucNang_nccLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpanel_chucNang_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabel_update_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel_delete_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
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

        jpanel_ncc_title.setBackground(new java.awt.Color(102, 255, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("NHÀ CUNG CẤP");

        javax.swing.GroupLayout jpanel_ncc_titleLayout = new javax.swing.GroupLayout(jpanel_ncc_title);
        jpanel_ncc_title.setLayout(jpanel_ncc_titleLayout);
        jpanel_ncc_titleLayout.setHorizontalGroup(
            jpanel_ncc_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_ncc_titleLayout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(jLabel3)
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jpanel_ncc_titleLayout.setVerticalGroup(
            jpanel_ncc_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_ncc_titleLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jpanel_timkiem_ncc.setBackground(new java.awt.Color(211, 218, 211));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpanel_timkiem_nccLayout.setVerticalGroup(
            jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_nccLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_look_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_find_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jLabel9.setText("Chức năng");

        jLabel8.setText("Tìm kiếm");

        javax.swing.GroupLayout jpn_nccLayout = new javax.swing.GroupLayout(jpn_ncc);
        jpn_ncc.setLayout(jpn_nccLayout);
        jpn_nccLayout.setHorizontalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_nccLayout.createSequentialGroup()
                        .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_nccLayout.createSequentialGroup()
                    .addComponent(jpanel_ncc_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jpn_nccLayout.setVerticalGroup(
            jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nccLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(jpanel_timkiem_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jpn_nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_nccLayout.createSequentialGroup()
                    .addComponent(jpanel_ncc_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 545, Short.MAX_VALUE)))
        );

        jpanel_chucNang_hdh.setBackground(new java.awt.Color(211, 218, 211));

        jlabel_update_hdh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_hdhMouseClicked(evt);
            }
        });

        jlabel_add_hdh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_hdhMouseClicked(evt);
            }
        });

        jlabel_delete_hdh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_hdhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_hdhLayout = new javax.swing.GroupLayout(jpanel_chucNang_hdh);
        jpanel_chucNang_hdh.setLayout(jpanel_chucNang_hdhLayout);
        jpanel_chucNang_hdhLayout.setHorizontalGroup(
            jpanel_chucNang_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_hdhLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlabel_add_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jlabel_update_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jlabel_delete_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jpanel_chucNang_hdhLayout.setVerticalGroup(
            jpanel_chucNang_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_hdhLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpanel_chucNang_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_update_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_delete_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        table_hdh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(table_hdh);

        jpanel_hdh_title.setBackground(new java.awt.Color(153, 255, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("HỆ ĐIỀU HÀNH");

        javax.swing.GroupLayout jpanel_hdh_titleLayout = new javax.swing.GroupLayout(jpanel_hdh_title);
        jpanel_hdh_title.setLayout(jpanel_hdh_titleLayout);
        jpanel_hdh_titleLayout.setHorizontalGroup(
            jpanel_hdh_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(jpanel_hdh_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_hdh_titleLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jpanel_hdh_titleLayout.setVerticalGroup(
            jpanel_hdh_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
            .addGroup(jpanel_hdh_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_hdh_titleLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 24, Short.MAX_VALUE)))
        );

        jLabel12.setText("Chức năng");

        javax.swing.GroupLayout jpn_hdhLayout = new javax.swing.GroupLayout(jpn_hdh);
        jpn_hdh.setLayout(jpn_hdhLayout);
        jpn_hdhLayout.setHorizontalGroup(
            jpn_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_hdhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanel_chucNang_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(jpn_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_hdhLayout.createSequentialGroup()
                    .addComponent(jpanel_hdh_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jpn_hdhLayout.setVerticalGroup(
            jpn_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_hdhLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanel_chucNang_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jpn_hdhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_hdhLayout.createSequentialGroup()
                    .addComponent(jpanel_hdh_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 544, Short.MAX_VALUE)))
        );

        jpanel_chucNang_mauSac.setBackground(new java.awt.Color(211, 218, 211));

        jlabel_update_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_update_mausacMouseClicked(evt);
            }
        });

        jlabel_add_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_add_mausacMouseClicked(evt);
            }
        });

        jlabel_delete_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabel_delete_mausacMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel_chucNang_mauSacLayout = new javax.swing.GroupLayout(jpanel_chucNang_mauSac);
        jpanel_chucNang_mauSac.setLayout(jpanel_chucNang_mauSacLayout);
        jpanel_chucNang_mauSacLayout.setHorizontalGroup(
            jpanel_chucNang_mauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_chucNang_mauSacLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jlabel_add_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jlabel_update_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jlabel_delete_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jpanel_chucNang_mauSacLayout.setVerticalGroup(
            jpanel_chucNang_mauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_mauSacLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpanel_chucNang_mauSacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_delete_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_update_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel_add_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        table_mausac.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(table_mausac);

        jpanel_mausac_title.setBackground(new java.awt.Color(153, 255, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("MÀU SẮC");

        javax.swing.GroupLayout jpanel_mausac_titleLayout = new javax.swing.GroupLayout(jpanel_mausac_title);
        jpanel_mausac_title.setLayout(jpanel_mausac_titleLayout);
        jpanel_mausac_titleLayout.setHorizontalGroup(
            jpanel_mausac_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(jpanel_mausac_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_mausac_titleLayout.createSequentialGroup()
                    .addContainerGap(471, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addContainerGap(477, Short.MAX_VALUE)))
        );
        jpanel_mausac_titleLayout.setVerticalGroup(
            jpanel_mausac_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
            .addGroup(jpanel_mausac_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_mausac_titleLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel14.setText("Chức năng");

        javax.swing.GroupLayout jpn_mausacLayout = new javax.swing.GroupLayout(jpn_mausac);
        jpn_mausac.setLayout(jpn_mausacLayout);
        jpn_mausacLayout.setHorizontalGroup(
            jpn_mausacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_mausacLayout.createSequentialGroup()
                .addComponent(jpanel_mausac_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpn_mausacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_mausacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel_chucNang_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpn_mausacLayout.setVerticalGroup(
            jpn_mausacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_mausacLayout.createSequentialGroup()
                .addComponent(jpanel_mausac_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanel_chucNang_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btn_mausac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_mausac.setText("MÀU SẮC");
        btn_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mausacActionPerformed(evt);
            }
        });

        btn_ram_rom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ram_rom.setText("RAM-ROM");

        btn_hdh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_hdh.setText("HỆ ĐIỀU HÀNH");

        jpanel_thuoctinh_title.setBackground(new java.awt.Color(153, 255, 153));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("THUỘC TÍNH");

        javax.swing.GroupLayout jpanel_thuoctinh_titleLayout = new javax.swing.GroupLayout(jpanel_thuoctinh_title);
        jpanel_thuoctinh_title.setLayout(jpanel_thuoctinh_titleLayout);
        jpanel_thuoctinh_titleLayout.setHorizontalGroup(
            jpanel_thuoctinh_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_thuoctinh_titleLayout.createSequentialGroup()
                .addGap(463, 463, 463)
                .addComponent(jLabel5)
                .addContainerGap(463, Short.MAX_VALUE))
        );
        jpanel_thuoctinh_titleLayout.setVerticalGroup(
            jpanel_thuoctinh_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_thuoctinh_titleLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpn_thuoctinhLayout = new javax.swing.GroupLayout(jpn_thuoctinh);
        jpn_thuoctinh.setLayout(jpn_thuoctinhLayout);
        jpn_thuoctinhLayout.setHorizontalGroup(
            jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_thuoctinhLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btn_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(btn_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
            .addGroup(jpn_thuoctinhLayout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(btn_ram_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_thuoctinhLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpanel_thuoctinh_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jpn_thuoctinhLayout.setVerticalGroup(
            jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_thuoctinhLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(btn_ram_rom, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(jpn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_thuoctinhLayout.createSequentialGroup()
                    .addComponent(jpanel_thuoctinh_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 545, Short.MAX_VALUE)))
        );

        jpanel_chucNang_dt.setBackground(new java.awt.Color(211, 218, 211));

        javax.swing.GroupLayout jpanel_chucNang_dtLayout = new javax.swing.GroupLayout(jpanel_chucNang_dt);
        jpanel_chucNang_dt.setLayout(jpanel_chucNang_dtLayout);
        jpanel_chucNang_dtLayout.setHorizontalGroup(
            jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jlabel_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jpanel_chucNang_dtLayout.setVerticalGroup(
            jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanel_chucNang_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlabel_add_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlabel_delete_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel_chucNang_dtLayout.createSequentialGroup()
                        .addComponent(jlabel_update_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(24, Short.MAX_VALUE))
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

        jPanel7.setBackground(new java.awt.Color(153, 255, 153));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("ĐIỆN THOẠI");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(457, 457, 457)
                .addComponent(jLabel7)
                .addContainerGap(483, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26))
        );

        jpanel_timkiem_dt.setBackground(new java.awt.Color(211, 218, 211));

        javax.swing.GroupLayout jpanel_timkiem_dtLayout = new javax.swing.GroupLayout(jpanel_timkiem_dt);
        jpanel_timkiem_dt.setLayout(jpanel_timkiem_dtLayout);
        jpanel_timkiem_dtLayout.setHorizontalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_timkiem_dtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabel_look_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jpanel_timkiem_dtLayout.setVerticalGroup(
            jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_timkiem_dtLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanel_timkiem_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlabel_look_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_find_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jLabel13.setText("Chức năng");

        jLabel10.setText("Tìm kiếm");

        javax.swing.GroupLayout jpn_dtLayout = new javax.swing.GroupLayout(jpn_dt);
        jpn_dt.setLayout(jpn_dtLayout);
        jpn_dtLayout.setHorizontalGroup(
            jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_dtLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpn_dtLayout.createSequentialGroup()
                        .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpn_dtLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpn_dtLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpn_dtLayout.setVerticalGroup(
            jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_dtLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpanel_chucNang_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanel_timkiem_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jpn_dtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpn_dtLayout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 545, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1235, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpanel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1035, Short.MAX_VALUE)))
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
                    .addComponent(jpn_hdh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 205, Short.MAX_VALUE)
                    .addComponent(jpn_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 205, Short.MAX_VALUE)
                    .addComponent(jpn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 199, Short.MAX_VALUE)
                    .addComponent(jpn_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jpn_hdh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_mausac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_thuoctinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpn_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jlabel_add_hdhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_hdhMouseClicked
        AddHeDieuHanhJFrame addHDHJFrame = new AddHeDieuHanhJFrame(this);;
        addHDHJFrame.setVisible(true);
        addHDHJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_hdhMouseClicked

    private void jlabel_update_hdhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_hdhMouseClicked
        int vitriRow = table_hdh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hệ điều hành để update", "Error", 0);
            return;
        }
        String maHDH = table_hdh.getValueAt(vitriRow, 0).toString();
        String tenHDH = table_hdh.getValueAt(vitriRow, 1).toString();
        EditHeDieuHanhJFrame editHDHJFrame = new EditHeDieuHanhJFrame(maHDH, tenHDH, this);
        editHDHJFrame.setVisible(true);
        editHDHJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_hdhMouseClicked

    private void jlabel_delete_hdhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_hdhMouseClicked
        int vitriRow = table_hdh.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn hệ điều hành để xóa", "Error", 0);
            return;
        }
        String maHDH = table_hdh.getValueAt(vitriRow, 0).toString();
        new HeDieuHanhDAO().deleteHDH(maHDH);
        addDataTableHeDieuHanh();
        func.centerTable(table_hdh);
    }//GEN-LAST:event_jlabel_delete_hdhMouseClicked

    private void jlabel_lookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_lookMouseClicked
        String text = jtf_find.getText().trim();
        DefaultTableModel model = (DefaultTableModel) table_nv.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_nv.setRowSorter(sorter);

        if (text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }

    }//GEN-LAST:event_jlabel_lookMouseClicked

    private void btn_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mausacActionPerformed

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

    private void jlabel_delete_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_delete_mausacMouseClicked
        int vitriRow = table_mausac.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn màu sắc để xóa", "Error", 0);
            return;
        }
        String maMau = table_mausac.getValueAt(vitriRow, 0).toString();
        new MauSacDAO().deleteMS(maMau);
        addDataTableMauSac();
        func.centerTable(table_mausac);
    }//GEN-LAST:event_jlabel_delete_mausacMouseClicked

    private void jlabel_add_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_add_mausacMouseClicked
        AddMauSacJFrame addMSJFrame = new AddMauSacJFrame(this);;
        addMSJFrame.setVisible(true);
        addMSJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_add_mausacMouseClicked

    private void jlabel_update_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabel_update_mausacMouseClicked
        int vitriRow = table_mausac.getSelectedRow();
        if (vitriRow == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn màu sắc để update", "Error", 0);
            return;
        }
        String maMau = table_mausac.getValueAt(vitriRow, 0).toString();
        String tenMau = table_mausac.getValueAt(vitriRow, 1).toString();
        EditMauSacJFrame editMSJFrame = new EditMauSacJFrame(maMau, tenMau, this);
        editMSJFrame.setVisible(true);
        editMSJFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jlabel_update_mausacMouseClicked

    public JTable getTableNhanVien() {
        return table_nv;
    }

    public JTable getTableNhaCungCap() {
        return table_ncc;
    }

    public JTable getTableHeDieuHanh() {
        return table_hdh;
    }

    public JTable getTableMauSac() {
        return table_mausac;
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

    public void addDataTableHeDieuHanh() {
        ArrayList<HeDieuHanhDTO> listHDH = new HeDieuHanhDAO().listHDH();
        String[] colNames = {"Mã hệ điều hành", "Tên hệ điều hành"};
        Object[][] rows = new Object[listHDH.size()][colNames.length];
        for (int i = 0; i < listHDH.size(); i++) {
            rows[i][0] = listHDH.get(i).getMaHDH();
            rows[i][1] = listHDH.get(i).getTenHDH();

        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_hdh.setModel(model);
    }

    public void addDataTableMauSac() {
        ArrayList<MauSacDTO> listMS = new MauSacDAO().listMS();
        String[] colNames = {"Mã màu", "Tên màu"};
        Object[][] rows = new Object[listMS.size()][colNames.length];
        for (int i = 0; i < listMS.size(); i++) {
            rows[i][0] = listMS.get(i).getMaMau();
            rows[i][1] = listMS.get(i).getTenMau();

        }
        DefaultTableModel model = new DefaultTableModel(rows, colNames);
        table_mausac.setModel(model);
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
    private javax.swing.JButton btn_mausac;
    private javax.swing.JButton btn_ncc;
    private javax.swing.JButton btn_nv;
    private javax.swing.JButton btn_ram_rom;
    private javax.swing.JButton btn_thuoctinh;
    private javax.swing.JLabel img_store;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlabel_add_dt;
    private javax.swing.JLabel jlabel_add_hdh;
    private javax.swing.JLabel jlabel_add_mausac;
    private javax.swing.JLabel jlabel_add_ncc;
    private javax.swing.JLabel jlabel_add_nv;
    private javax.swing.JLabel jlabel_delete_dt;
    private javax.swing.JLabel jlabel_delete_hdh;
    private javax.swing.JLabel jlabel_delete_mausac;
    private javax.swing.JLabel jlabel_delete_ncc;
    private javax.swing.JLabel jlabel_delete_nv;
    private javax.swing.JLabel jlabel_look;
    private javax.swing.JLabel jlabel_look_dt;
    private javax.swing.JLabel jlabel_look_ncc;
    private javax.swing.JLabel jlabel_update_dt;
    private javax.swing.JLabel jlabel_update_hdh;
    private javax.swing.JLabel jlabel_update_mausac;
    private javax.swing.JLabel jlabel_update_ncc;
    private javax.swing.JLabel jlabel_update_nv;
    private javax.swing.JPanel jpanel_chucNang_dt;
    private javax.swing.JPanel jpanel_chucNang_hdh;
    private javax.swing.JPanel jpanel_chucNang_mauSac;
    private javax.swing.JPanel jpanel_chucNang_ncc;
    private javax.swing.JPanel jpanel_chucNang_nv;
    private javax.swing.JPanel jpanel_hdh_title;
    private javax.swing.JPanel jpanel_mausac_title;
    private javax.swing.JPanel jpanel_menu;
    private javax.swing.JPanel jpanel_menu_bottom;
    private javax.swing.JPanel jpanel_menu_top;
    private javax.swing.JPanel jpanel_ncc_title;
    private javax.swing.JPanel jpanel_nv_title;
    private javax.swing.JPanel jpanel_thuoctinh_title;
    private javax.swing.JPanel jpanel_timkiem_dt;
    private javax.swing.JPanel jpanel_timkiem_ncc;
    private javax.swing.JPanel jpanel_timkiem_nv;
    private javax.swing.JPanel jpn_dt;
    private javax.swing.JPanel jpn_hdh;
    private javax.swing.JPanel jpn_mausac;
    private javax.swing.JPanel jpn_ncc;
    private javax.swing.JPanel jpn_nv;
    private javax.swing.JPanel jpn_thuoctinh;
    private javax.swing.JTextField jtf_find;
    private javax.swing.JTextField jtf_find_dt;
    private javax.swing.JTextField jtf_find_ncc;
    private javax.swing.JTable table_dt;
    private javax.swing.JTable table_hdh;
    private javax.swing.JTable table_mausac;
    private javax.swing.JTable table_ncc;
    private javax.swing.JTable table_nv;
    // End of variables declaration//GEN-END:variables
}
