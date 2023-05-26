/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controllers.KeHoachBaoTriController;
import Models.KeHoachBaoTri;
import Models.NghiepVuBaoTriTaiSan;
import Models.NhiemVuBaoTri;
import Models.TaiSanBaoTri;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinh
 */
public class ChiTietKeHoachBaoTriView extends javax.swing.JFrame {

    private KeHoachBaoTriController keHoachBaoTriController;
    private KeHoachBaoTri keHoachBaoTri;
    private List<NhiemVuBaoTri> nhiemVuBaoTriList;
    private List<TaiSanBaoTri> taiSanBaoTrisList;
    private DefaultTableModel nhiemVuBaoTriTableModel;
    private DefaultTableModel taiSanBaoTriTableModel;
    private boolean addKeHoachBaoTri;

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

    public DefaultTableModel getNhiemVuBaoTriTableModel() {
        return nhiemVuBaoTriTableModel;
    }

    public DefaultTableModel getTaiSanBaoTriTableModel() {
        return taiSanBaoTriTableModel;
    }

    public boolean isAddKeHoachBaoTri() {
        return addKeHoachBaoTri;
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

    public void setNhiemVuBaoTriTableModel(DefaultTableModel nhiemVuBaoTriTableModel) {
        this.nhiemVuBaoTriTableModel = nhiemVuBaoTriTableModel;
    }

    public void setTaiSanBaoTriTableModel(DefaultTableModel taiSanBaoTriTableModel) {
        this.taiSanBaoTriTableModel = taiSanBaoTriTableModel;
    }

    public void setAddKeHoachBaoTri(boolean addKeHoachBaoTri) {
        this.addKeHoachBaoTri = addKeHoachBaoTri;
    }
    
    public ChiTietKeHoachBaoTriView() {
        initComponents();
        
    }
    
    public ChiTietKeHoachBaoTriView(KeHoachBaoTriController keHoachBaoTriController, KeHoachBaoTri keHoachBaoTri) {
        initComponents();
        
        this.keHoachBaoTriController = keHoachBaoTriController;
        this.keHoachBaoTriController.setChiTietKeHoachBaoTriView(this);
        this.keHoachBaoTri = keHoachBaoTri;
        this.addKeHoachBaoTri = false;
        
        KhoiTaoDuLieuChoUpdateKeHoach();
    }
    
    public ChiTietKeHoachBaoTriView(KeHoachBaoTriController keHoachBaoTriController, boolean addKeHoachBaoTri) {
        initComponents();
        
        this.keHoachBaoTriController = keHoachBaoTriController;
        this.keHoachBaoTriController.setChiTietKeHoachBaoTriView(this);
        this.addKeHoachBaoTri = addKeHoachBaoTri;
        
        KhoiTaoDuLieuChoAddKeHoach();
    }
    
    private void KhoiTaoDuLieuChoUpdateKeHoach() {
        // Khởi các thông tin của 2 bảng nhiemvubaotri và taisanbaotri
        this.nhiemVuBaoTriTableModel = new DefaultTableModel();
        nhiemVuBaoTriTableModel.addColumn("STT");
        nhiemVuBaoTriTableModel.addColumn("Tên nhiệm vụ");
        nhiemVuBaoTriTableModel.addColumn("Chi tiết nhiệm vụ");
        nhiemVuBaoTriTableModel.addColumn("Chi Phí");
        nhiemVuBaoTriTableModel.addColumn("ID");
        
        this.taiSanBaoTriTableModel = new DefaultTableModel();
        taiSanBaoTriTableModel.addColumn("STT");
        taiSanBaoTriTableModel.addColumn("Tên tài sản");
        taiSanBaoTriTableModel.addColumn("Phòng máy");
        taiSanBaoTriTableModel.addColumn("Số lượng");
        taiSanBaoTriTableModel.addColumn("Yêu cầu bảo trì");
        taiSanBaoTriTableModel.addColumn("iD");
        
        Btn_AddKeHoachBaoTri.setVisible(true);
        
        hienThiThongTinChung();
        hienThiNhiemVuBaoTri();
        hienThiTaiSanBaoTri();
    }
    
    private void KhoiTaoDuLieuChoAddKeHoach() {
        // Khởi các thông tin của 2 bảng nhiemvubaotri và taisanbaotri
        this.nhiemVuBaoTriTableModel = new DefaultTableModel();
        nhiemVuBaoTriTableModel.addColumn("STT");
        nhiemVuBaoTriTableModel.addColumn("Tên nhiệm vụ");
        nhiemVuBaoTriTableModel.addColumn("Chi tiết nhiệm vụ");
        nhiemVuBaoTriTableModel.addColumn("Chi Phí");
        nhiemVuBaoTriTableModel.addColumn("ID");
        
        this.taiSanBaoTriTableModel = new DefaultTableModel();
        taiSanBaoTriTableModel.addColumn("STT");
        taiSanBaoTriTableModel.addColumn("Tên tài sản");
        taiSanBaoTriTableModel.addColumn("Phòng máy");
        taiSanBaoTriTableModel.addColumn("Số lượng");
        taiSanBaoTriTableModel.addColumn("Yêu cầu bảo trì");
        taiSanBaoTriTableModel.addColumn("iD");
        
        Btn_XacNhanThucThi.setVisible(false);
        Btn_XuatExcel.setVisible(false);
        
    }

    public void hienThiThongTinChung() {
        IDKeHoachContainer.setText(keHoachBaoTri.getiD());
        NgayKetThucContainer.setText(keHoachBaoTri.getThoiGianKetThuc().toString());
        NgayBatDauContainer.setText(keHoachBaoTri.getThoiGianBatDau().toString());
        GhiChuContainer.setText(keHoachBaoTri.getGhiChu());
    }
    
    public void hienThiNhiemVuBaoTri() {
        nhiemVuBaoTriList = (ArrayList<NhiemVuBaoTri>)keHoachBaoTriController.hienThiNhiemVuBaoTri(keHoachBaoTri.getiD());
        
        nhiemVuBaoTriTableModel.setNumRows(0);
        for(int i=0; i<nhiemVuBaoTriList.size(); i++) {
            Object[] duLieuHienThi = {i+1, nhiemVuBaoTriList.get(i).getTenNhiemVu(), nhiemVuBaoTriList.get(i).getChiTietNhiemVu(), nhiemVuBaoTriList.get(i).getChiPhi(), nhiemVuBaoTriList.get(i).getiD()};
            nhiemVuBaoTriTableModel.addRow(duLieuHienThi);
        }
        
        NhiemVuBaoTriContainer.setModel(nhiemVuBaoTriTableModel);   
        
        NhiemVuBaoTriContainer.getColumnModel().getColumn(0).setMaxWidth(50);
    }
    
    public void hienThiTaiSanBaoTri() {
        NhiemVuBaoTriContainer.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = NhiemVuBaoTriContainer.getSelectedRow();
                Object iDNhiemVuBaoTri = NhiemVuBaoTriContainer.getValueAt(selectedRow, 4);
                
                ArrayList<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSansList = (ArrayList<NghiepVuBaoTriTaiSan>)keHoachBaoTriController.hienThiTaiSanBaoTris(iDNhiemVuBaoTri.toString().trim());

                taiSanBaoTriTableModel.setRowCount(0);
                for(int i=0; i<nghiepVuBaoTriTaiSansList.size(); i++) {

                    String tenTaiSan = nghiepVuBaoTriTaiSansList.get(i).getTaiSan().getTenTaiSan();
                    String tenPhongMay = nghiepVuBaoTriTaiSansList.get(i).getPhongMay().getTenPhong();
                    int soLuong = nghiepVuBaoTriTaiSansList.get(i).getTaiSanBaoTri().getSoLuong();
                    String yeuCauBaoTri = nghiepVuBaoTriTaiSansList.get(i).getTaiSanBaoTri().getYeuCauBaoTri();
                    String iDTaiSanBaoTri = nghiepVuBaoTriTaiSansList.get(i).getTaiSanBaoTri().getiD();

                    Object[] duLieuHienThi = {i+1, tenTaiSan, tenPhongMay, soLuong, yeuCauBaoTri, iDTaiSanBaoTri};
                    taiSanBaoTriTableModel.addRow(duLieuHienThi);
                }
                TaiSanBaoTriContainer.setModel(taiSanBaoTriTableModel);  

                TaiSanBaoTriContainer.getColumnModel().getColumn(0).setMaxWidth(50);
            }
        });
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
        jPanel3 = new javax.swing.JPanel();
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
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Btn_XuatExcel = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        Btn_Exit = new javax.swing.JButton();
        Btn_AddKeHoachBaoTri = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin chi tiết kế hoạch");

        jLabel4.setText("ID kế hoạch:");

        IDKeHoachContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IDKeHoachContainer.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDKeHoachContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IDKeHoachContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel6.setText("Thời gian bắt đầu:");

        NgayBatDauContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NgayBatDauContainer.setText("jLabel3");

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
        GhiChuContainer.setText("jLabel13");

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
        NgayKetThucContainer.setText("jLabel3");

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
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jButton4.setText("Thêm");

        jButton5.setText("Sửa");

        jButton6.setText("Xóa");

        Btn_XuatExcel.setText("Xuất file Excel");

        jButton8.setText("Thêm");

        jButton9.setText("Sửa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Xóa");

        Btn_Exit.setText("Thoát");
        Btn_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThoatCuaSoMouseClicked(evt);
            }
        });

        Btn_AddKeHoachBaoTri.setText("Thêm kế hoạch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(419, 419, 419)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_XacNhanThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(Btn_AddKeHoachBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_AddKeHoachBaoTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Btn_XacNhanThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void Btn_SuaThongTinChiTietKeHoachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_SuaThongTinChiTietKeHoachMouseClicked
        if(addKeHoachBaoTri) {
            Them_SuaThongTinChungKeHoachBaoTriView them_SuaThongTinChungKeHoachBaoTriView = new Them_SuaThongTinChungKeHoachBaoTriView(keHoachBaoTriController, true);
            them_SuaThongTinChungKeHoachBaoTriView.setVisible(true);
        } else {
            Them_SuaThongTinChungKeHoachBaoTriView them_SuaThongTinChungKeHoachBaoTriView = new Them_SuaThongTinChungKeHoachBaoTriView(keHoachBaoTriController, keHoachBaoTri);
            them_SuaThongTinChungKeHoachBaoTriView.setVisible(true);
        }
    }//GEN-LAST:event_Btn_SuaThongTinChiTietKeHoachMouseClicked

    private void ThoatCuaSoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThoatCuaSoMouseClicked
        this.dispose();
        keHoachBaoTriController.hienThiKeHoachBaoTriView();
        keHoachBaoTriController.getQuanLyBaoTriTaiSanView().HienThiTatCaKeHoach();
    }//GEN-LAST:event_ThoatCuaSoMouseClicked

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
    private javax.swing.JLabel GhiChuContainer;
    private javax.swing.JLabel IDKeHoachContainer;
    private javax.swing.JLabel NgayBatDauContainer;
    private javax.swing.JLabel NgayKetThucContainer;
    private javax.swing.JTable NhiemVuBaoTriContainer;
    private javax.swing.JTable TaiSanBaoTriContainer;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
