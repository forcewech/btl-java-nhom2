/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controllers.KeHoachBaoTriController;
import Interfaces.ErrorNormal;
import Interfaces.NotifyNormal;
import Models.KeHoachBaoTri;
import Models.NghiepVuBaoTriTaiSan;
import Models.NhiemVuBaoTri;
import Models.TaiSanBaoTri;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinh
 */
public class ChiTietKeHoachBaoTriView extends javax.swing.JFrame {

    private KeHoachBaoTriController keHoachBaoTriController;
    private KeHoachBaoTri keHoachBaoTri;
    private NhiemVuBaoTri nhiemVuBaoTriCurrentChoice;
    private TaiSanBaoTri taiSanBaoTriCurrentChoice;
    private List<NhiemVuBaoTri> nhiemVuBaoTriList;
    private List<TaiSanBaoTri> taiSanBaoTrisList;
    private List<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSanList;
    private boolean isAddKeHoachBaoTri;
    DefaultTableModel defaultTableNhiemVuBaoTri;
    DefaultTableModel defaultTableTaiSanBaoTri;
    private ListSelectionListener NhiemVuBaoTriSelectedRowListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = NhiemVuBaoTriContainer.getSelectedRow();

                String iDNhiemVuBaoTri = NhiemVuBaoTriContainer.getValueAt(selectedRow, 4).toString().trim();
                String tenNhiemVu = NhiemVuBaoTriContainer.getValueAt(selectedRow, 1).toString().trim();
                String chiTietNhiemVu = NhiemVuBaoTriContainer.getValueAt(selectedRow, 2).toString().trim();
                int chiPhi = Integer.parseInt(NhiemVuBaoTriContainer.getValueAt(selectedRow, 3).toString().trim());
                
                nhiemVuBaoTriCurrentChoice = new NhiemVuBaoTri(iDNhiemVuBaoTri, keHoachBaoTri.getiD(), tenNhiemVu, chiTietNhiemVu, "", chiPhi);
                
                hienThiTaiSanBaoTriforAll();
            }
        }
    };
    private ListSelectionListener TaiSanBaoTriSelectedRowListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = TaiSanBaoTriContainer.getSelectedRow();

                String iDTaiSanBaoTri = TaiSanBaoTriContainer.getValueAt(selectedRow, 5).toString().trim();
                String iDTaiSanPhongMay = TaiSanBaoTriContainer.getValueAt(selectedRow, 6).toString().trim();
                int soLuong = Integer.parseInt(TaiSanBaoTriContainer.getValueAt(selectedRow, 3).toString().trim());
                String yeuCauBaoTri = TaiSanBaoTriContainer.getValueAt(selectedRow, 4).toString();
                
                taiSanBaoTriCurrentChoice = new TaiSanBaoTri(iDTaiSanBaoTri, nhiemVuBaoTriCurrentChoice.getiD(), iDTaiSanPhongMay, soLuong, yeuCauBaoTri);
            }
        }
    };
    
    private void addNhiemVuBaoTriSelectedRowListener() {
        NhiemVuBaoTriContainer.getSelectionModel().addListSelectionListener(NhiemVuBaoTriSelectedRowListener);
    }
    
    private void removeNhiemVuBaoTriSelectedRowListener() {
        ListSelectionModel selectionModel = NhiemVuBaoTriContainer.getSelectionModel();
        selectionModel.removeListSelectionListener(NhiemVuBaoTriSelectedRowListener);
    }
    
    private void addTaiSanBaoTriSelectedRowListener() {
        TaiSanBaoTriContainer.getSelectionModel().addListSelectionListener(TaiSanBaoTriSelectedRowListener);   
    }
    
    private void removeTaiSanBaoTriSelectedRowListener() {
        ListSelectionModel selectionModel = TaiSanBaoTriContainer.getSelectionModel();
        selectionModel.removeListSelectionListener(TaiSanBaoTriSelectedRowListener);
    }

    public KeHoachBaoTriController getKeHoachBaoTriController() {
        return keHoachBaoTriController;
    }

    public KeHoachBaoTri getKeHoachBaoTri() {
        return keHoachBaoTri;
    }

    public List<NhiemVuBaoTri> getNhiemVuBaoTriList() {
        return nhiemVuBaoTriList;
    }

    public List<TaiSanBaoTri> getTaiSanBaoTrisList() {
        return taiSanBaoTrisList;
    }

    public void setKeHoachBaoTriController(KeHoachBaoTriController keHoachBaoTriController) {
        this.keHoachBaoTriController = keHoachBaoTriController;
    }

    public void setKeHoachBaoTri(KeHoachBaoTri keHoachBaoTri) {
        this.keHoachBaoTri = keHoachBaoTri;
    }

    public void setNhiemVuBaoTriList(List<NhiemVuBaoTri> nhiemVuBaoTriList) {
        this.nhiemVuBaoTriList = nhiemVuBaoTriList;
    }

    public void setTaiSanBaoTrisList(List<TaiSanBaoTri> taiSanBaoTrisList) {
        this.taiSanBaoTrisList = taiSanBaoTrisList;
    }
    
    public ChiTietKeHoachBaoTriView() {
        initComponents();
        
    }
    
    // Khi muốn update kế hoạch bảo trì
    public ChiTietKeHoachBaoTriView(KeHoachBaoTriController keHoachBaoTriController, KeHoachBaoTri keHoachBaoTri) {
        initComponents();
        
        this.keHoachBaoTriController = keHoachBaoTriController;
        this.keHoachBaoTriController.setChiTietKeHoachBaoTriView(this);
        this.keHoachBaoTri = keHoachBaoTri;
        this.isAddKeHoachBaoTri = false;
        
        KhoiTaoDuLieuChoUpdateKeHoach();
    }
    
    // Khi muốn add kế hoạch bảo trì
    public ChiTietKeHoachBaoTriView(KeHoachBaoTriController keHoachBaoTriController) {
        initComponents();
        
        this.keHoachBaoTriController = keHoachBaoTriController;
        this.keHoachBaoTriController.setChiTietKeHoachBaoTriView(this);
        this.isAddKeHoachBaoTri = true;
        
        KhoiTaoDuLieuChoAddKeHoach();
    }
    
    private void KhoiTaoDuLieuChoUpdateKeHoach() {
        hienThiThongTinChung();
        
        nhiemVuBaoTriList = (ArrayList<NhiemVuBaoTri>)keHoachBaoTriController.hienThiNhiemVuBaoTri(keHoachBaoTri.getiD());
        
        defaultTableNhiemVuBaoTri = new DefaultTableModel();
        defaultTableTaiSanBaoTri = new DefaultTableModel();
        
        setUIForUpdateKeHoach();
        hienThiNhiemVuBaoTriforUpDate();
    }
    
    private void KhoiTaoDuLieuChoAddKeHoach() {
        nhiemVuBaoTriList = new ArrayList<>();
        defaultTableNhiemVuBaoTri = new DefaultTableModel();
        defaultTableTaiSanBaoTri = new DefaultTableModel();
        setUIForAddKeHoach();
        
    }
    
    private void setUIForUpdateKeHoach() {
        Btn_AddKeHoachBaoTri.setVisible(false);
        setUIforTable();
    }
    
    private void setUIForAddKeHoach() {
        Btn_delete.setVisible(false);
        Btn_XacNhanThucThi.setVisible(false);
        Btn_XuatExcel.setVisible(false);
        Panel_IDKeHoach.setVisible(false);
        setUIforTable();
    }
    
    private void setUIforTable() {
        defaultTableNhiemVuBaoTri.addColumn("STT");
        defaultTableNhiemVuBaoTri.addColumn("Tên nhiệm vụ");
        defaultTableNhiemVuBaoTri.addColumn("Chi tiết nhiệm vụ");
        defaultTableNhiemVuBaoTri.addColumn("Chi Phí");
        defaultTableNhiemVuBaoTri.addColumn("ID");
        NhiemVuBaoTriContainer.setModel(defaultTableNhiemVuBaoTri);
        
        defaultTableTaiSanBaoTri.addColumn("STT");
        defaultTableTaiSanBaoTri.addColumn("Tên tài sản");
        defaultTableTaiSanBaoTri.addColumn("Phòng máy");
        defaultTableTaiSanBaoTri.addColumn("Số lượng");
        defaultTableTaiSanBaoTri.addColumn("Yêu cầu bảo trì");
        defaultTableTaiSanBaoTri.addColumn("iD");
        defaultTableTaiSanBaoTri.addColumn("iD tài sản phòng máy");
        TaiSanBaoTriContainer.setModel(defaultTableTaiSanBaoTri);
    }

    public void hienThiThongTinChung() {
        IDKeHoachContainer.setText(keHoachBaoTri.getiD());
        NgayKetThucContainer.setText(keHoachBaoTri.getThoiGianKetThuc().toString());
        NgayBatDauContainer.setText(keHoachBaoTri.getThoiGianBatDau().toString());
        GhiChuContainer.setText(keHoachBaoTri.getGhiChu());
    }
    
    public void hienThiNhiemVuBaoTriforUpDate() {
        nhiemVuBaoTriList = (ArrayList<NhiemVuBaoTri>)keHoachBaoTriController.hienThiNhiemVuBaoTri(keHoachBaoTri.getiD());
        hienThiNhiemVuBaoTri();
    }
    
    public void hienThiNhiemVuBaoTriforAdd() {
        hienThiNhiemVuBaoTri();
    }
    
    private void hienThiNhiemVuBaoTri() {
        
        removeNhiemVuBaoTriSelectedRowListener();
        defaultTableNhiemVuBaoTri.setRowCount(0);
        for(int i=0; i<nhiemVuBaoTriList.size(); i++) {
            Object[] duLieuHienThi = {i+1, nhiemVuBaoTriList.get(i).getTenNhiemVu(), nhiemVuBaoTriList.get(i).getChiTietNhiemVu(), nhiemVuBaoTriList.get(i).getChiPhi(), nhiemVuBaoTriList.get(i).getiD()};
            defaultTableNhiemVuBaoTri.addRow(duLieuHienThi);
        }
        
        NhiemVuBaoTriContainer.setModel(defaultTableNhiemVuBaoTri); 
        addNhiemVuBaoTriSelectedRowListener();
        NhiemVuBaoTriContainer.getColumnModel().getColumn(0).setMaxWidth(50);
    }
    
    private void hienThiTaiSanBaoTriforAll() {
        if(isAddKeHoachBaoTri) {
            hienThiTaiSanBaoTriByAddKeHoachBaoTri();
        } else {
            hienThiNhiemVuBaoTriByUpDateKeHoachBaoTri();
        }
    }
    
    public void hienThiNhiemVuBaoTriByUpDateKeHoachBaoTri() {
        nghiepVuBaoTriTaiSanList = (ArrayList<NghiepVuBaoTriTaiSan>)keHoachBaoTriController.hienThiTaiSanBaoTris(nhiemVuBaoTriCurrentChoice.getiD());
        hienThiTaiSanBaoTri();
    }
    
    public void hienThiTaiSanBaoTriByAddKeHoachBaoTri() {
        hienThiTaiSanBaoTri();
    }
    
    private void hienThiTaiSanBaoTri() {
        
            removeTaiSanBaoTriSelectedRowListener();
            defaultTableTaiSanBaoTri.setRowCount(0);
            
            for(int i=0; i<nghiepVuBaoTriTaiSanList.size(); i++) {

                String tenTaiSan = nghiepVuBaoTriTaiSanList.get(i).getTaiSan().getTenTaiSan();
                String tenPhongMay = nghiepVuBaoTriTaiSanList.get(i).getPhongMay().getTenPhong();
                int soLuong = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getSoLuong();
                String yeuCauBaoTri = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getYeuCauBaoTri();
                String iDTaiSanBaoTri = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getiD();
                String iDTaiSanPhongMay = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getiDTaiSanPhongMay();

                Object[] duLieuHienThi = {i+1, tenTaiSan, tenPhongMay, soLuong, yeuCauBaoTri, iDTaiSanBaoTri, iDTaiSanPhongMay};
                defaultTableTaiSanBaoTri.addRow(duLieuHienThi);
            }
            
            TaiSanBaoTriContainer.setModel(defaultTableTaiSanBaoTri);
            addTaiSanBaoTriSelectedRowListener();
            
            TaiSanBaoTriContainer.getColumnModel().getColumn(0).setMaxWidth(50);
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
        jLabel2 = new javax.swing.JLabel();
        Panel_IDKeHoach = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        IDKeHoachContainer = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        NgayBatDauContainer = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        GhiChuContainer = new javax.swing.JLabel();
        Btn_SuaThongTinChiTietKeHoach = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NgayKetThucContainer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NhiemVuBaoTriContainer = new javax.swing.JTable();
        Btn_XacNhanThucThi = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TaiSanBaoTriContainer = new javax.swing.JTable();
        Btn_addNhiemVuBaoTri = new javax.swing.JButton();
        Btn_XuatExcel = new javax.swing.JButton();
        Btn_addTaiSanBaoTri = new javax.swing.JButton();
        Btn_Exit = new javax.swing.JButton();
        Btn_AddKeHoachBaoTri = new javax.swing.JButton();
        Btn_updateNhiemVuBaoTri = new javax.swing.JButton();
        Btn_udpateTaiSanBaoTri = new javax.swing.JButton();
        Btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin chi tiết kế hoạch");

        jLabel4.setText("ID kế hoạch:");

        IDKeHoachContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout Panel_IDKeHoachLayout = new javax.swing.GroupLayout(Panel_IDKeHoach);
        Panel_IDKeHoach.setLayout(Panel_IDKeHoachLayout);
        Panel_IDKeHoachLayout.setHorizontalGroup(
            Panel_IDKeHoachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_IDKeHoachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDKeHoachContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        Panel_IDKeHoachLayout.setVerticalGroup(
            Panel_IDKeHoachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_IDKeHoachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_IDKeHoachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IDKeHoachContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel6.setText("Thời gian bắt đầu:");

        NgayBatDauContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NgayBatDauContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NgayBatDauContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel12.setText("Ghi chú:");

        GhiChuContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GhiChuContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addGap(378, 378, 378))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GhiChuContainer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        Btn_SuaThongTinChiTietKeHoach.setText("Sửa thông tin chung");
        Btn_SuaThongTinChiTietKeHoach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_SuaThongTinChiTietKeHoachMouseClicked(evt);
            }
        });

        jLabel1.setText("Thời gian kết thúc:");

        NgayKetThucContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NgayKetThucContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NgayKetThucContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Panel_IDKeHoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(Btn_SuaThongTinChiTietKeHoach)
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Panel_IDKeHoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Btn_SuaThongTinChiTietKeHoach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NhiemVuBaoTriContainer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(NhiemVuBaoTriContainer);

        Btn_XacNhanThucThi.setText("Xác nhận thực thi");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nhiệm vụ bảo trì");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tài sản cần bảo trì");

        TaiSanBaoTriContainer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TaiSanBaoTriContainer);

        Btn_addNhiemVuBaoTri.setText("Thêm");
        Btn_addNhiemVuBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_addNhiemVuBaoTriMouseClicked(evt);
            }
        });

        Btn_XuatExcel.setText("Xuất file Excel");

        Btn_addTaiSanBaoTri.setText("Thêm");
        Btn_addTaiSanBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_addTaiSanBaoTriMouseClicked(evt);
            }
        });

        Btn_Exit.setText("Thoát");
        Btn_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThoatCuaSoMouseClicked(evt);
            }
        });

        Btn_AddKeHoachBaoTri.setText("Thêm kế hoạch");

        Btn_updateNhiemVuBaoTri.setText("Cập nhật");
        Btn_updateNhiemVuBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_updateNhiemVuBaoTriMouseClicked(evt);
            }
        });

        Btn_udpateTaiSanBaoTri.setText("Cập nhật");
        Btn_udpateTaiSanBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_udpateTaiSanBaoTriMouseClicked(evt);
            }
        });

        Btn_delete.setText("Hủy kế hoạch");
        Btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_deleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(407, 407, 407)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(Btn_XuatExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_addNhiemVuBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_updateNhiemVuBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_XacNhanThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(Btn_AddKeHoachBaoTri)
                        .addGap(29, 29, 29)
                        .addComponent(Btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_addTaiSanBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_udpateTaiSanBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_addNhiemVuBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_addTaiSanBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_udpateTaiSanBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_updateNhiemVuBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_XacNhanThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_AddKeHoachBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_SuaThongTinChiTietKeHoachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_SuaThongTinChiTietKeHoachMouseClicked
        if(isAddKeHoachBaoTri) {
            Them_SuaThongTinChungKeHoachBaoTriView them_SuaThongTinChungKeHoachBaoTriView = new Them_SuaThongTinChungKeHoachBaoTriView(keHoachBaoTriController);
            them_SuaThongTinChungKeHoachBaoTriView.setVisible(true);
        } else {
            Them_SuaThongTinChungKeHoachBaoTriView them_SuaThongTinChungKeHoachBaoTriView = new Them_SuaThongTinChungKeHoachBaoTriView(keHoachBaoTriController, keHoachBaoTri);
            them_SuaThongTinChungKeHoachBaoTriView.setVisible(true);
        }
    }//GEN-LAST:event_Btn_SuaThongTinChiTietKeHoachMouseClicked

    private void ThoatCuaSoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThoatCuaSoMouseClicked
        this.dispose();
        navigateToTatCaKeHoachBaoTri();
    }//GEN-LAST:event_ThoatCuaSoMouseClicked

    private void Btn_updateNhiemVuBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_updateNhiemVuBaoTriMouseClicked
        if(isAddKeHoachBaoTri) {
            if(nhiemVuBaoTriCurrentChoice == null) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                Add_UpdateNhiemVuBaoTriView add_UpdateNhiemVuBaoTriView = new Add_UpdateNhiemVuBaoTriView(keHoachBaoTriController, nhiemVuBaoTriCurrentChoice, true);
                add_UpdateNhiemVuBaoTriView.setVisible(true);
            }
        } else {
            if(nhiemVuBaoTriCurrentChoice ==  null) {
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                Add_UpdateNhiemVuBaoTriView add_UpdateNhiemVuBaoTriView = new Add_UpdateNhiemVuBaoTriView(keHoachBaoTriController, nhiemVuBaoTriCurrentChoice, false);
                add_UpdateNhiemVuBaoTriView.setVisible(true);
            }
        }
    }//GEN-LAST:event_Btn_updateNhiemVuBaoTriMouseClicked

    private void Btn_udpateTaiSanBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_udpateTaiSanBaoTriMouseClicked
        if(isAddKeHoachBaoTri) {
            
        } else {
            Add_UpdateTaiSanBaoTri add_UpdateTaiSanBaoTri = new Add_UpdateTaiSanBaoTri(keHoachBaoTriController, taiSanBaoTriCurrentChoice, false);
            add_UpdateTaiSanBaoTri.setVisible(true);
        }
    }//GEN-LAST:event_Btn_udpateTaiSanBaoTriMouseClicked

    private void Btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_deleteMouseClicked
        keHoachBaoTriController.deleteKeHoachBaoTri(keHoachBaoTri);
        NotifyNormal notifyNormal = new NotifyNormal("Đã xóa kế hoạch bảo trì");
        notifyNormal.showNotify();
        this.dispose();
        navigateToTatCaKeHoachBaoTri();
    }//GEN-LAST:event_Btn_deleteMouseClicked

    private void Btn_addNhiemVuBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_addNhiemVuBaoTriMouseClicked
        if(isAddKeHoachBaoTri) {
            if(keHoachBaoTri != null) {
                Add_UpdateNhiemVuBaoTriView add_UpdateNhiemVuBaoTriView = new Add_UpdateNhiemVuBaoTriView(keHoachBaoTriController, keHoachBaoTri, true);
                add_UpdateNhiemVuBaoTriView.setVisible(true);
            } else {
                NotifyNormal notifyNormal = new NotifyNormal("bạn chưa sửa thông tin chung cho kế hoạch. Hãy làm điều này trước");
                notifyNormal.showNotify();
            }
        } else {
            Add_UpdateNhiemVuBaoTriView add_UpdateNhiemVuBaoTriView = new Add_UpdateNhiemVuBaoTriView(keHoachBaoTriController, keHoachBaoTri, false);
            add_UpdateNhiemVuBaoTriView.setVisible(true);
        }
    }//GEN-LAST:event_Btn_addNhiemVuBaoTriMouseClicked

    private void Btn_addTaiSanBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_addTaiSanBaoTriMouseClicked
        if(isAddKeHoachBaoTri) {
            
        } else {
            if(nhiemVuBaoTriCurrentChoice != null) {
                Add_UpdateTaiSanBaoTri add_UpdateTaiSanBaoTri = new Add_UpdateTaiSanBaoTri(keHoachBaoTriController, nhiemVuBaoTriCurrentChoice, false);
                add_UpdateTaiSanBaoTri.setVisible(true);
            } else {
                ErrorNormal errorNormal = new ErrorNormal("Bạn chưa chọn nhiệm vụ bảo trì");
                errorNormal.HienThiThongBaoLoi();
            }
        }
    }//GEN-LAST:event_Btn_addTaiSanBaoTriMouseClicked

    private void navigateToTatCaKeHoachBaoTri() {
        keHoachBaoTriController.hienThiKeHoachBaoTriView();
        keHoachBaoTriController.getQuanLyBaoTriTaiSanView().HienThiTatCaKeHoach();
    }
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
            java.util.logging.Logger.getLogger(ChiTietKeHoachBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietKeHoachBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietKeHoachBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietKeHoachBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietKeHoachBaoTriView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AddKeHoachBaoTri;
    private javax.swing.JButton Btn_Exit;
    private javax.swing.JButton Btn_SuaThongTinChiTietKeHoach;
    private javax.swing.JButton Btn_XacNhanThucThi;
    private javax.swing.JButton Btn_XuatExcel;
    private javax.swing.JButton Btn_addNhiemVuBaoTri;
    private javax.swing.JButton Btn_addTaiSanBaoTri;
    private javax.swing.JButton Btn_delete;
    private javax.swing.JButton Btn_udpateTaiSanBaoTri;
    private javax.swing.JButton Btn_updateNhiemVuBaoTri;
    private javax.swing.JLabel GhiChuContainer;
    private javax.swing.JLabel IDKeHoachContainer;
    private javax.swing.JLabel NgayBatDauContainer;
    private javax.swing.JLabel NgayKetThucContainer;
    private javax.swing.JTable NhiemVuBaoTriContainer;
    private javax.swing.JPanel Panel_IDKeHoach;
    private javax.swing.JTable TaiSanBaoTriContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
