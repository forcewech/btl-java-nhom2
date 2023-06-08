/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controllers.KeHoachBaoTriController;
import Controllers.ThucThiBaoTriController;
import Controllers.LichSuBaoTriController;
import Interfaces.CheckManager;
import Interfaces.CheckRole;
import Models.KeHoachBaoTri;
import Models.NguoiDung;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinh
 */
public class QuanLyBaoTriTaiSanView extends javax.swing.JFrame {

    private List<KeHoachBaoTri> keHoachBaoTrisList;
    private List<KeHoachBaoTri> keHoachDangThucThiList;
    private List<KeHoachBaoTri> keHoachDaHoanThanhList;
    private KeHoachBaoTriController keHoachBaoTriController;
    private ThucThiBaoTriController thucThiBaoTriController;
    private LichSuBaoTriController lichSuBaoTriController;
    private DefaultTableModel modelTableKeHoachBaoTri;
    private DefaultTableModel modelTableThucThiKeHoach;
    private DefaultTableModel modelTableKeHoachDaHoanThanh;
    private NguoiDung nguoiDung;
    private ListSelectionListener listSelectionEventForKeHoachBaoTriTable = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = ThongTinCoBanKeHoachContainer.getSelectedRow();
                Object thoiGianBatDau = ThongTinCoBanKeHoachContainer.getValueAt(selectedRow, 1);
                Object thoiGianKetThuc = ThongTinCoBanKeHoachContainer.getValueAt(selectedRow, 2);
                Object ghiChu = ThongTinCoBanKeHoachContainer.getValueAt(selectedRow, 3);
                Object trangThai = ThongTinCoBanKeHoachContainer.getValueAt(selectedRow, 4);
                Object anhXacNhan = ThongTinCoBanKeHoachContainer.getValueAt(selectedRow, 5);
                Object iD = ThongTinCoBanKeHoachContainer.getValueAt(selectedRow, 6);
                
                KeHoachBaoTri keHoachBaoTri = new KeHoachBaoTri(iD.toString().trim(), (LocalDate)thoiGianBatDau, (LocalDate)thoiGianKetThuc, ghiChu.toString().trim(), trangThai.toString().equals("Đã được xác nhận") ? true : false , anhXacNhan.toString().trim());
                
                keHoachBaoTriController.anKeHoachBaoTriView();
                
                ChiTietKeHoachBaoTriView chiTietKeHoachBaoTriView = new ChiTietKeHoachBaoTriView(keHoachBaoTriController, keHoachBaoTri);
                keHoachBaoTriController.setChiTietKeHoachBaoTriView(chiTietKeHoachBaoTriView);
                chiTietKeHoachBaoTriView.setVisible(true);
            }
        }
    };
    private ListSelectionListener listSelectionEventForKeHoachDangThucThiTable = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = KeHoachDangThucThiTable.getSelectedRow();
                Object thoiGianBatDau = KeHoachDangThucThiTable.getValueAt(selectedRow, 1);
                Object thoiGianKetThuc = KeHoachDangThucThiTable.getValueAt(selectedRow, 2);
                Object ghiChu = KeHoachDangThucThiTable.getValueAt(selectedRow, 3);
                Object trangThai = KeHoachDangThucThiTable.getValueAt(selectedRow, 4);
                Object anhXacNhan = KeHoachDangThucThiTable.getValueAt(selectedRow, 5);
                Object iD = KeHoachDangThucThiTable.getValueAt(selectedRow, 6);
                
                KeHoachBaoTri keHoachDangThucThi = new KeHoachBaoTri(iD.toString().trim(), (LocalDate)thoiGianBatDau, (LocalDate)thoiGianKetThuc, ghiChu.toString().trim(), trangThai.toString().equals("Đã được xác nhận") ? true : false , anhXacNhan.toString());
                
                thucThiBaoTriController.getQuanLyBaoTriTaiSanView().setVisible(false);
                
                ChiTietThucThiBaoTriView chiTietThucThiBaoTriView = new ChiTietThucThiBaoTriView(thucThiBaoTriController, keHoachDangThucThi);
                chiTietThucThiBaoTriView.setVisible(true);
            }
        }
    };
    private ListSelectionListener listSelectionEventForKeHoachDaHoanThanhTable = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = KeHoachDaHoanThanhTable.getSelectedRow();
                Object thoiGianBatDau = KeHoachDaHoanThanhTable.getValueAt(selectedRow, 1);
                Object thoiGianKetThuc = KeHoachDaHoanThanhTable.getValueAt(selectedRow, 2);
                Object ghiChu = KeHoachDaHoanThanhTable.getValueAt(selectedRow, 3);
                Object trangThai = KeHoachDaHoanThanhTable.getValueAt(selectedRow, 4);
                Object anhXacNhan = KeHoachDaHoanThanhTable.getValueAt(selectedRow, 5);
                Object iD = KeHoachDaHoanThanhTable.getValueAt(selectedRow, 6);
                
                KeHoachBaoTri keHoachDangThucThi = new KeHoachBaoTri(iD.toString().trim(), (LocalDate)thoiGianBatDau, (LocalDate)thoiGianKetThuc, ghiChu.toString().trim(), trangThai.toString().equals("Đã được xác nhận") ? true : false , anhXacNhan.toString());
                
                lichSuBaoTriController.getQuanLyBaoTriTaiSanView().setVisible(false);
                
                LichSuBaoTriView lichSuBaoTriView = new LichSuBaoTriView(lichSuBaoTriController, keHoachDangThucThi);
                lichSuBaoTriView.setVisible(true);
            }
        }
    };
    
    public QuanLyBaoTriTaiSanView() {
        initComponents();   
        nguoiDung = new NguoiDung("user1", "Nguyễn Văn Thịnh", "thinh156", "1234", "thinhpk26@gmail.com", "Manager");
        CheckManager CheckManager = new CheckManager();
        keHoachBaoTriController = new KeHoachBaoTriController(this, this.nguoiDung, CheckManager);
        thucThiBaoTriController = new ThucThiBaoTriController(this, nguoiDung);
        lichSuBaoTriController = new LichSuBaoTriController(this, nguoiDung);
        hienThiUI();
        setInitData();
    }
    
    public QuanLyBaoTriTaiSanView(TrangChuAdmin trangChuAdmin, NguoiDung nguoiDung, CheckRole checkRole) {
        this.nguoiDung = nguoiDung;
        NameUserContainer.setText(nguoiDung.getHoTen());
        keHoachBaoTriController = new KeHoachBaoTriController(this, this.nguoiDung, checkRole);
        keHoachBaoTriController.setTrangChuAdminView(trangChuAdmin);
        thucThiBaoTriController = new ThucThiBaoTriController(this, this.nguoiDung);
        lichSuBaoTriController = new LichSuBaoTriController(this, this.nguoiDung);
        hienThiUI();
        setInitData();
    }
    
    private void hienThiUI() {     
        CoverContentContainer.setSelectedIndex(0);
        Btn_KeHoachBaoTri.setBackground(new Color(242, 242, 242));
        Btn_ThucThiBaoTri.setBackground(Color.WHITE);
        Btn_XemLichSu.setBackground(Color.WHITE);
        setUIInitForKeHoachBaoTriTable();
        setUIInitForKeHoachDangThucThiTable();
        setUIInitForKeHoachDaHoanThanhTable();
    }
    
    private void setUIInitForKeHoachBaoTriTable() {
        modelTableKeHoachBaoTri = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modelTableKeHoachBaoTri.addColumn("STT");
        modelTableKeHoachBaoTri.addColumn("Thời gian bắt đầu");
        modelTableKeHoachBaoTri.addColumn("Thoi gian kết thúc");
        modelTableKeHoachBaoTri.addColumn("Ghi chú");
        modelTableKeHoachBaoTri.addColumn("Trạng thái");
        modelTableKeHoachBaoTri.addColumn("Ảnh xác nhận");
        modelTableKeHoachBaoTri.addColumn("ID");
    }
    
    private void setInitData() {
        showTatCaKeHoachByDataSQL();
        showTatCaKeHoachDangThucThibySQL();
        showAllKeHoachDaHoanThanhbySQL();
    }
    
    public void showTatCaKeHoachByDataSQL() {
        keHoachBaoTrisList = (ArrayList<KeHoachBaoTri>)keHoachBaoTriController.hienThiTatCaKeHoachBaoTri();
        showforTatCaKeHoachTable();
    }
    
    private void showforTatCaKeHoachTable() {
        removeHienThiChiTietKeHoachEvent();
        modelTableKeHoachBaoTri.setRowCount(0);
        for(int i=0; i<keHoachBaoTrisList.size(); i++) {
            Object[] duLieuHienThi = {i+1, keHoachBaoTrisList.get(i).getThoiGianBatDau(), keHoachBaoTrisList.get(i).getThoiGianKetThuc(), keHoachBaoTrisList.get(i).getGhiChu(), keHoachBaoTrisList.get(i).getTrangThai() ? "Đã được xác nhận": "Chưa được xác nhận", keHoachBaoTrisList.get(i).getAnhXacNhan(), keHoachBaoTrisList.get(i).getiD()};
            modelTableKeHoachBaoTri.addRow(duLieuHienThi);
        }
        
        ThongTinCoBanKeHoachContainer.setModel(modelTableKeHoachBaoTri); 
        addHienThiChiTietKeHoachEvent();
        
        setStyleForKeHoachBaoTriTable();
    }
    
    private void addHienThiChiTietKeHoachEvent() {
        ThongTinCoBanKeHoachContainer.getSelectionModel().addListSelectionListener(listSelectionEventForKeHoachBaoTriTable);
    }
    
    private void removeHienThiChiTietKeHoachEvent() {
        ListSelectionModel selectionModel = ThongTinCoBanKeHoachContainer.getSelectionModel();
        selectionModel.removeListSelectionListener(listSelectionEventForKeHoachBaoTriTable);
    }
    
    private void setStyleForKeHoachBaoTriTable() {
        ThongTinCoBanKeHoachContainer.getColumnModel().getColumn(0).setMaxWidth(50);
        ThongTinCoBanKeHoachContainer.getColumnModel().getColumn(5).setMaxWidth(0);
        ThongTinCoBanKeHoachContainer.getColumnModel().getColumn(6).setMaxWidth(0);
        ThongTinCoBanKeHoachContainer.getColumnModel().getColumn(4).setMaxWidth(0);
    }
    
    // Thực thi kế hoạch bảo trì
    private void setUIInitForKeHoachDangThucThiTable() {
        modelTableThucThiKeHoach = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modelTableThucThiKeHoach.addColumn("STT");
        modelTableThucThiKeHoach.addColumn("Thời gian bắt đầu");
        modelTableThucThiKeHoach.addColumn("Thoi gian kết thúc");
        modelTableThucThiKeHoach.addColumn("Ghi chú");
        modelTableThucThiKeHoach.addColumn("Trạng thái");
        modelTableThucThiKeHoach.addColumn("Ảnh xác nhận");
        modelTableThucThiKeHoach.addColumn("ID");
    }
    
    public void showTatCaKeHoachDangThucThibySQL() {
        keHoachDangThucThiList = (ArrayList<KeHoachBaoTri>)thucThiBaoTriController.getKeHoachDangThucThi();
        setTatCaKeHoachDangThucThiForTable();
    }
    
    private void setTatCaKeHoachDangThucThiForTable() {
        removeChoiceRowInKeHoachDangThucThiTableEvent();
        modelTableThucThiKeHoach.setRowCount(0);
        
        for(int i=0; i<keHoachDangThucThiList.size(); i++) {
            Object stt = (i+1) + "";
            Object thoiGianBatDau = keHoachDangThucThiList.get(i).getThoiGianBatDau();
            Object thoiGianKetThuc = keHoachDangThucThiList.get(i).getThoiGianKetThuc();
            Object ghiChu = keHoachDangThucThiList.get(i).getGhiChu();
            Object trangThai = keHoachDangThucThiList.get(i).getTrangThai() ? "Đã được xác nhận": "Chưa được xác nhận";
            Object anhXacNhan = keHoachDangThucThiList.get(i).getAnhXacNhan();
            Object iD = keHoachDangThucThiList.get(i).getiD();
            Object[] duLieuHienThi = {stt, thoiGianBatDau, thoiGianKetThuc, ghiChu, trangThai, anhXacNhan, iD};
            modelTableThucThiKeHoach.addRow(duLieuHienThi);
        }
        
        KeHoachDangThucThiTable.setModel(modelTableThucThiKeHoach); 
        
        addChoiceRowInKeHoachDangThucThiTableEvent();
        
        setStyleForKeHoachDaThucThiTable();
    }
    
    private void addChoiceRowInKeHoachDangThucThiTableEvent() {
        KeHoachDangThucThiTable.getSelectionModel().addListSelectionListener(listSelectionEventForKeHoachDangThucThiTable);
    }
    
    private void removeChoiceRowInKeHoachDangThucThiTableEvent() {
        ListSelectionModel selectionModel = KeHoachDangThucThiTable.getSelectionModel();
        selectionModel.removeListSelectionListener(listSelectionEventForKeHoachDangThucThiTable);
    }
    
    private void setStyleForKeHoachDaThucThiTable() {
        KeHoachDangThucThiTable.getColumnModel().getColumn(0).setMaxWidth(50);
        KeHoachDangThucThiTable.getColumnModel().getColumn(5).setMaxWidth(0);
        KeHoachDangThucThiTable.getColumnModel().getColumn(6).setMaxWidth(0);
        KeHoachDangThucThiTable.getColumnModel().getColumn(4).setMaxWidth(0);
    }
    
    // Kế hoạch bảo trì đã hoàn thành
    private void setUIInitForKeHoachDaHoanThanhTable() {
        modelTableKeHoachDaHoanThanh = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        modelTableKeHoachDaHoanThanh.addColumn("STT");
        modelTableKeHoachDaHoanThanh.addColumn("Thời gian bắt đầu");
        modelTableKeHoachDaHoanThanh.addColumn("Thoi gian kết thúc");
        modelTableKeHoachDaHoanThanh.addColumn("Ghi chú");
        modelTableKeHoachDaHoanThanh.addColumn("Trạng thái");
        modelTableKeHoachDaHoanThanh.addColumn("Ảnh xác nhận");
        modelTableKeHoachDaHoanThanh.addColumn("ID");
    }
    
    public void showAllKeHoachDaHoanThanhbySQL() {
        keHoachDaHoanThanhList = (ArrayList<KeHoachBaoTri>)lichSuBaoTriController.getKeHoachBaoTriDaHoanThanh();
        setTatCaKeHoachDaHoanThanhForTable();
    }
    
    private void setTatCaKeHoachDaHoanThanhForTable() {
        removeChoiceRowInKeHoachDaHoanThanhTableEvent();
        modelTableKeHoachDaHoanThanh.setRowCount(0);
        
        for(int i=0; i<keHoachDaHoanThanhList.size(); i++) {
            Object stt = (i+1) + "";
            Object thoiGianBatDau = keHoachDaHoanThanhList.get(i).getThoiGianBatDau();
            Object thoiGianKetThuc = keHoachDaHoanThanhList.get(i).getThoiGianKetThuc();
            Object ghiChu = keHoachDaHoanThanhList.get(i).getGhiChu();
            Object trangThai = keHoachDaHoanThanhList.get(i).getTrangThai() ? "Đã được xác nhận": "Chưa được xác nhận";
            Object anhXacNhan = keHoachDaHoanThanhList.get(i).getAnhXacNhan();
            Object iD = keHoachDaHoanThanhList.get(i).getiD();
            Object[] duLieuHienThi = {stt, thoiGianBatDau, thoiGianKetThuc, ghiChu, trangThai, anhXacNhan, iD};
            modelTableKeHoachDaHoanThanh.addRow(duLieuHienThi);
        }
        
        KeHoachDaHoanThanhTable.setModel(modelTableKeHoachDaHoanThanh); 
        
        addChoiceRowInKeHoachDaHoanThanhTableEvent();
        
        setStyleForKeHoachDaHoanThanhTable();
    }
    
    private void addChoiceRowInKeHoachDaHoanThanhTableEvent() {
        KeHoachDaHoanThanhTable.getSelectionModel().addListSelectionListener(listSelectionEventForKeHoachDaHoanThanhTable);
    }
    
    private void removeChoiceRowInKeHoachDaHoanThanhTableEvent() {
        ListSelectionModel selectionModel = KeHoachDaHoanThanhTable.getSelectionModel();
        selectionModel.removeListSelectionListener(listSelectionEventForKeHoachDaHoanThanhTable);
    }
    
    private void setStyleForKeHoachDaHoanThanhTable() {
        KeHoachDaHoanThanhTable.getColumnModel().getColumn(0).setMaxWidth(50);
        KeHoachDaHoanThanhTable.getColumnModel().getColumn(5).setMaxWidth(0);
        KeHoachDaHoanThanhTable.getColumnModel().getColumn(6).setMaxWidth(0);
        KeHoachDaHoanThanhTable.getColumnModel().getColumn(4).setMaxWidth(0);
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Navbar = new javax.swing.JPanel();
        Btn_KeHoachBaoTri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Btn_ThucThiBaoTri = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Btn_XemLichSu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ContentContainer = new javax.swing.JPanel();
        InformationWindowContainer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        UsernameContainer = new javax.swing.JPanel();
        IconUsernameController = new javax.swing.JLabel();
        NameUserContainer = new javax.swing.JLabel();
        MainContentContainer = new javax.swing.JPanel();
        CoverContentContainer = new javax.swing.JTabbedPane();
        KeHoachBaoTriContentContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ThongTinCoBanKeHoachContainer = new javax.swing.JTable();
        Btn_addKeHoachBaoTri = new javax.swing.JButton();
        XemLichSuContentContainer = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        KeHoachDaHoanThanhTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        ThucThiBaoTriContentContainer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        KeHoachDangThucThiTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        Btn_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 718));

        Panel_Navbar.setBackground(new java.awt.Color(255, 255, 255));

        Btn_KeHoachBaoTri.setBackground(new java.awt.Color(255, 255, 255));
        Btn_KeHoachBaoTri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        Btn_KeHoachBaoTri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_KeHoachBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_KeHoachBaoTriMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kế hoạch bảo trì");

        javax.swing.GroupLayout Btn_KeHoachBaoTriLayout = new javax.swing.GroupLayout(Btn_KeHoachBaoTri);
        Btn_KeHoachBaoTri.setLayout(Btn_KeHoachBaoTriLayout);
        Btn_KeHoachBaoTriLayout.setHorizontalGroup(
            Btn_KeHoachBaoTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_KeHoachBaoTriLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );
        Btn_KeHoachBaoTriLayout.setVerticalGroup(
            Btn_KeHoachBaoTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_KeHoachBaoTriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        Btn_ThucThiBaoTri.setBackground(new java.awt.Color(255, 255, 255));
        Btn_ThucThiBaoTri.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 242, 242), 1, true));
        Btn_ThucThiBaoTri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_ThucThiBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ThucThiBaoTriMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thực thi kế hoạch");

        javax.swing.GroupLayout Btn_ThucThiBaoTriLayout = new javax.swing.GroupLayout(Btn_ThucThiBaoTri);
        Btn_ThucThiBaoTri.setLayout(Btn_ThucThiBaoTriLayout);
        Btn_ThucThiBaoTriLayout.setHorizontalGroup(
            Btn_ThucThiBaoTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_ThucThiBaoTriLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        Btn_ThucThiBaoTriLayout.setVerticalGroup(
            Btn_ThucThiBaoTriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_ThucThiBaoTriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        Btn_XemLichSu.setBackground(new java.awt.Color(255, 255, 255));
        Btn_XemLichSu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        Btn_XemLichSu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_XemLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_XemLichSuMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Xem lịch sử");

        javax.swing.GroupLayout Btn_XemLichSuLayout = new javax.swing.GroupLayout(Btn_XemLichSu);
        Btn_XemLichSu.setLayout(Btn_XemLichSuLayout);
        Btn_XemLichSuLayout.setHorizontalGroup(
            Btn_XemLichSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_XemLichSuLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );
        Btn_XemLichSuLayout.setVerticalGroup(
            Btn_XemLichSuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Btn_XemLichSuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\btl-java-nhom2\\src\\main\\java\\icons\\d7311b47ce21107f4930.jpg")); // NOI18N

        javax.swing.GroupLayout Panel_NavbarLayout = new javax.swing.GroupLayout(Panel_Navbar);
        Panel_Navbar.setLayout(Panel_NavbarLayout);
        Panel_NavbarLayout.setHorizontalGroup(
            Panel_NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_NavbarLayout.createSequentialGroup()
                .addGroup(Panel_NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addGroup(Panel_NavbarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_XemLichSu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_ThucThiBaoTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_KeHoachBaoTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        Panel_NavbarLayout.setVerticalGroup(
            Panel_NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_NavbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(63, 63, 63)
                .addComponent(Btn_KeHoachBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Btn_ThucThiBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Btn_XemLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quản lý bảo trì tài sản");

        UsernameContainer.setBackground(new java.awt.Color(255, 255, 255));
        UsernameContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        IconUsernameController.setText("Admin:");

        NameUserContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NameUserContainer.setForeground(new java.awt.Color(204, 51, 0));
        NameUserContainer.setText("Name User");

        javax.swing.GroupLayout UsernameContainerLayout = new javax.swing.GroupLayout(UsernameContainer);
        UsernameContainer.setLayout(UsernameContainerLayout);
        UsernameContainerLayout.setHorizontalGroup(
            UsernameContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernameContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IconUsernameController, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NameUserContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        UsernameContainerLayout.setVerticalGroup(
            UsernameContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernameContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsernameContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IconUsernameController, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NameUserContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout InformationWindowContainerLayout = new javax.swing.GroupLayout(InformationWindowContainer);
        InformationWindowContainer.setLayout(InformationWindowContainerLayout);
        InformationWindowContainerLayout.setHorizontalGroup(
            InformationWindowContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationWindowContainerLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        InformationWindowContainerLayout.setVerticalGroup(
            InformationWindowContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformationWindowContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InformationWindowContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UsernameContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11))
        );

        MainContentContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        KeHoachBaoTriContentContainer.setPreferredSize(new java.awt.Dimension(1300, 800));

        ThongTinCoBanKeHoachContainer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ThongTinCoBanKeHoachContainer);

        Btn_addKeHoachBaoTri.setText("Thêm");
        Btn_addKeHoachBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_addKeHoachBaoTriMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout KeHoachBaoTriContentContainerLayout = new javax.swing.GroupLayout(KeHoachBaoTriContentContainer);
        KeHoachBaoTriContentContainer.setLayout(KeHoachBaoTriContentContainerLayout);
        KeHoachBaoTriContentContainerLayout.setHorizontalGroup(
            KeHoachBaoTriContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(KeHoachBaoTriContentContainerLayout.createSequentialGroup()
                .addComponent(Btn_addKeHoachBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        KeHoachBaoTriContentContainerLayout.setVerticalGroup(
            KeHoachBaoTriContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KeHoachBaoTriContentContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_addKeHoachBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CoverContentContainer.addTab("tab1", KeHoachBaoTriContentContainer);

        KeHoachDaHoanThanhTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(KeHoachDaHoanThanhTable);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lịch sử bảo trì");

        javax.swing.GroupLayout XemLichSuContentContainerLayout = new javax.swing.GroupLayout(XemLichSuContentContainer);
        XemLichSuContentContainer.setLayout(XemLichSuContentContainerLayout);
        XemLichSuContentContainerLayout.setHorizontalGroup(
            XemLichSuContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XemLichSuContentContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, XemLichSuContentContainerLayout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(343, 343, 343))
        );
        XemLichSuContentContainerLayout.setVerticalGroup(
            XemLichSuContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XemLichSuContentContainerLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        CoverContentContainer.addTab("tab3", XemLichSuContentContainer);

        KeHoachDangThucThiTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(KeHoachDangThucThiTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Các bảo trì đang thực hiện");

        javax.swing.GroupLayout ThucThiBaoTriContentContainerLayout = new javax.swing.GroupLayout(ThucThiBaoTriContentContainer);
        ThucThiBaoTriContentContainer.setLayout(ThucThiBaoTriContentContainerLayout);
        ThucThiBaoTriContentContainerLayout.setHorizontalGroup(
            ThucThiBaoTriContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThucThiBaoTriContentContainerLayout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );
        ThucThiBaoTriContentContainerLayout.setVerticalGroup(
            ThucThiBaoTriContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThucThiBaoTriContentContainerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        CoverContentContainer.addTab("tab2", ThucThiBaoTriContentContainer);

        MainContentContainer.add(CoverContentContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -40, 1000, 690));

        Btn_Cancel.setText("Thoát");
        Btn_Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_CancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ContentContainerLayout = new javax.swing.GroupLayout(ContentContainer);
        ContentContainer.setLayout(ContentContainerLayout);
        ContentContainerLayout.setHorizontalGroup(
            ContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainContentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ContentContainerLayout.createSequentialGroup()
                        .addComponent(InformationWindowContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContentContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        ContentContainerLayout.setVerticalGroup(
            ContentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InformationWindowContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainContentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ContentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Hiển thị dữ liệu của các chức năng chính.
    private void Btn_KeHoachBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_KeHoachBaoTriMouseClicked
        CoverContentContainer.setSelectedIndex(0);
        Btn_KeHoachBaoTri.setBackground(new Color(242, 242, 242));
        Btn_ThucThiBaoTri.setBackground(Color.WHITE);
        Btn_XemLichSu.setBackground(Color.WHITE);
    }//GEN-LAST:event_Btn_KeHoachBaoTriMouseClicked

    private void Btn_ThucThiBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ThucThiBaoTriMouseClicked
        CoverContentContainer.setSelectedIndex(2);
        Btn_ThucThiBaoTri.setBackground(new Color(242, 242, 242));
        Btn_KeHoachBaoTri.setBackground(Color.WHITE);
        Btn_XemLichSu.setBackground(Color.WHITE);
    }//GEN-LAST:event_Btn_ThucThiBaoTriMouseClicked

    private void Btn_XemLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_XemLichSuMouseClicked
        CoverContentContainer.setSelectedIndex(1);
        Btn_XemLichSu.setBackground(new Color(242, 242, 242));
        Btn_ThucThiBaoTri.setBackground(Color.WHITE);
        Btn_KeHoachBaoTri.setBackground(Color.WHITE);
    }//GEN-LAST:event_Btn_XemLichSuMouseClicked

    private void Btn_addKeHoachBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_addKeHoachBaoTriMouseClicked
        ChiTietKeHoachBaoTriView chiTietKeHoachBaoTriView = new ChiTietKeHoachBaoTriView(keHoachBaoTriController);
        keHoachBaoTriController.setChiTietKeHoachBaoTriView(chiTietKeHoachBaoTriView);
        chiTietKeHoachBaoTriView.setVisible(true);
        keHoachBaoTriController.anKeHoachBaoTriView();
    }//GEN-LAST:event_Btn_addKeHoachBaoTriMouseClicked

    private void Btn_CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CancelMouseClicked
        
    }//GEN-LAST:event_Btn_CancelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyBaoTriTaiSanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBaoTriTaiSanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBaoTriTaiSanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBaoTriTaiSanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBaoTriTaiSanView().setVisible(true);
            }
        });
    }

    public void setKeHoachBaoTrisList(List<KeHoachBaoTri> keHoachBaoTrisList) {
        this.keHoachBaoTrisList = keHoachBaoTrisList;
    }

    public void setKeHoachDangThucThiList(List<KeHoachBaoTri> keHoachDangThucThiList) {
        this.keHoachDangThucThiList = keHoachDangThucThiList;
    }

    public List<KeHoachBaoTri> getKeHoachBaoTrisList() {
        return keHoachBaoTrisList;
    }

    public List<KeHoachBaoTri> getKeHoachDangThucThiList() {
        return keHoachDangThucThiList;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cancel;
    private javax.swing.JPanel Btn_KeHoachBaoTri;
    private javax.swing.JPanel Btn_ThucThiBaoTri;
    private javax.swing.JPanel Btn_XemLichSu;
    private javax.swing.JButton Btn_addKeHoachBaoTri;
    private javax.swing.JPanel ContentContainer;
    private javax.swing.JTabbedPane CoverContentContainer;
    private javax.swing.JLabel IconUsernameController;
    private javax.swing.JPanel InformationWindowContainer;
    private javax.swing.JPanel KeHoachBaoTriContentContainer;
    private javax.swing.JTable KeHoachDaHoanThanhTable;
    private javax.swing.JTable KeHoachDangThucThiTable;
    private javax.swing.JPanel MainContentContainer;
    private javax.swing.JLabel NameUserContainer;
    private javax.swing.JPanel Panel_Navbar;
    private javax.swing.JTable ThongTinCoBanKeHoachContainer;
    private javax.swing.JPanel ThucThiBaoTriContentContainer;
    private javax.swing.JPanel UsernameContainer;
    private javax.swing.JPanel XemLichSuContentContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
