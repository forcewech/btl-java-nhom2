/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Controllers.KeHoachBaoTriController;
import Controllers.ThucThiBaoTriController;
import Interfaces.ErrorNormal;
import Interfaces.Notify;
import Interfaces.NotifyNormal;
import Models.HoanThanhBaoTri;
import Models.KeHoachBaoTri;
import Models.NghiepVuBaoTriTaiSan;
import Models.NghiepVuBaoTriTaiSanDAO;
import Models.NhiemVuBaoTri;
import Models.NhiemVuHoanThanh;
import Models.TaiSanBaoTri;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author thinh
 */
public class ChiTietThucThiBaoTriView extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietThucThiBaoTriView
     */
    
    private ThucThiBaoTriController thucThiBaoTriController;
    private KeHoachBaoTri keHoachDangThucThi;
    private List<NhiemVuBaoTri> nhiemVuBaoTrisList;
    private PanelCoverNhiemVuBaoTri coverPanelAllNhiemVuBaoTri;
    
    public ChiTietThucThiBaoTriView() {
        PanelCoverNhiemVuBaoTri coverPanelAllNhiemVuBaoTri = new PanelCoverNhiemVuBaoTri();
        initComponents();
//        Cover_NhiemVuBaoTri_jScrollpanel.setViewportView(coverPanelAllNhiemVuBaoTri);
//        Cover_NhiemVuBaoTri_jScrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public ChiTietThucThiBaoTriView(ThucThiBaoTriController thucThiBaoTriController, KeHoachBaoTri keHoachDangThucThi) {
        this.thucThiBaoTriController = thucThiBaoTriController;
        this.keHoachDangThucThi = keHoachDangThucThi;
        this.nhiemVuBaoTrisList = thucThiBaoTriController.getNhiemVuBaoTriByiDKeHoachBaoTri(keHoachDangThucThi.getiD());
        
        setUI();
        
        hienThiThongTinChung();
    }
    
    private void setUI() {
        coverPanelAllNhiemVuBaoTri = new PanelCoverNhiemVuBaoTri(nhiemVuBaoTrisList);
        initComponents();
        Cover_NhiemVuBaoTri_jScrollpanel.setViewportView(coverPanelAllNhiemVuBaoTri);
    }
    
    private void hienThiThongTinChung() {
        IDKeHoachContainer.setText(keHoachDangThucThi.getiD());
        NgayKetThucContainer.setText(keHoachDangThucThi.getThoiGianKetThuc().toString());
        NgayBatDauContainer.setText(keHoachDangThucThi.getThoiGianBatDau().toString());
        GhiChuContainer.setText(keHoachDangThucThi.getGhiChu());
    }

    private class PanelCoverNhiemVuBaoTri extends JPanel {
        private List<NhiemVuBaoTri> nhiemVuBaoTrisList;
        public PanelCoverNhiemVuBaoTri(List<NhiemVuBaoTri> nhiemVuBaoTrisList) {
            this.nhiemVuBaoTrisList = nhiemVuBaoTrisList;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setData();
        }
        
        private void setData() {
            for(NhiemVuBaoTri nhiemVuBaoTri : nhiemVuBaoTrisList) {
                ArrayList<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSans = (ArrayList<NghiepVuBaoTriTaiSan>) thucThiBaoTriController.getTSBT_TSPM_PM_TS_NVHTbyiDNhiemVuBaoTri(nhiemVuBaoTri);
                PanelForNhiemVuBaoTri panel = new PanelForNhiemVuBaoTri(thucThiBaoTriController, nhiemVuBaoTri, nghiepVuBaoTriTaiSans);
                panel.setName(nhiemVuBaoTri.getiD());
                add(panel);
            }
        }
        
        public PanelCoverNhiemVuBaoTri() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            PanelForNhiemVuBaoTri panel1 = new PanelForNhiemVuBaoTri(); // Hàm tạo JPanel của bạn
            add(panel1);
            PanelForNhiemVuBaoTri panel2 = new PanelForNhiemVuBaoTri();
            add(panel2);
            PanelForNhiemVuBaoTri panel3 = new PanelForNhiemVuBaoTri();
            add(panel3);
            PanelForNhiemVuBaoTri panel4 = new PanelForNhiemVuBaoTri();
            add(panel4);
            PanelForNhiemVuBaoTri panel5 = new PanelForNhiemVuBaoTri();
            add(panel5);
            
        }
    }
    
    private class PanelForNhiemVuBaoTri extends JPanel{
        private NhiemVuBaoTri nhiemVuBaoTri;
        private List<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSanList;
        private ThucThiBaoTriController thucThiBaoTriController;
        
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        public JTextArea jTextArea1 = new javax.swing.JTextArea();
        JLabel Label_danhGia = new javax.swing.JLabel();
        JCheckBox checkBox_hoanThanh = new javax.swing.JCheckBox();
        JLabel label_tenNhiemVu = new javax.swing.JLabel();
        JLabel jLabel7 = new javax.swing.JLabel();
        JLabel label_ChiTietNhiemVu = new javax.swing.JLabel();
        JLabel jLabel9 = new javax.swing.JLabel();
        JLabel Label_chiPhi = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        public JTable jTable1 = new javax.swing.JTable();
        DefaultTableModel modelTable;
        
        public PanelForNhiemVuBaoTri() {
            setUI();
        }
        
        public PanelForNhiemVuBaoTri(ThucThiBaoTriController thucThiBaoTriController, NhiemVuBaoTri nhiemVuBaoTri, List<NghiepVuBaoTriTaiSan> nghiepVuBaoTriTaiSansList) {
            this.thucThiBaoTriController = thucThiBaoTriController;
            this.nhiemVuBaoTri = nhiemVuBaoTri;
            this.nghiepVuBaoTriTaiSanList = nghiepVuBaoTriTaiSansList;
            
            setUI();
            setDataForNhiemVuBaoTri();
            setDataForTable();
        }
        
        private void setDataForTable() {
            String[] columnsName = {"iD", "Tên phòng", "Tên tài sản", "Số lượng", "Yêu cầu", "Số lượng đã hoàn thành", ""};
            
            int row = nghiepVuBaoTriTaiSanList.size();
            int column = columnsName.length;
            Object[][] rowCount = new Object[row][column];
            
            for(int i=0; i<row; i++) {
                nghiepVuBaoTriTaiSanList = (ArrayList<NghiepVuBaoTriTaiSan>)thucThiBaoTriController.getTSBT_TSPM_PM_TS_NVHTbyiDNhiemVuBaoTri(nhiemVuBaoTri);
                
                String tenTaiSan = nghiepVuBaoTriTaiSanList.get(i).getTaiSan().getTenTaiSan();
                String tenPhongMay = nghiepVuBaoTriTaiSanList.get(i).getPhongMay().getTenPhong();
                int soLuong = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getSoLuong();
                String yeuCauBaoTri = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getYeuCauBaoTri();
                String iDTaiSanBaoTri = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getiD();
                String iDTaiSanPhongMay = nghiepVuBaoTriTaiSanList.get(i).getTaiSanBaoTri().getiDTaiSanPhongMay();

                int soLuongDaHoanThanh = nghiepVuBaoTriTaiSanList.get(i).getNhiemVuHoanThanh().getSoLuongDaHoanThanh();
                
                rowCount[i][0] = iDTaiSanBaoTri;
                rowCount[i][1] = tenPhongMay;
                rowCount[i][2] = tenTaiSan;
                rowCount[i][3] = soLuong;
                rowCount[i][4] = yeuCauBaoTri;
                rowCount[i][5] = soLuongDaHoanThanh;
                rowCount[i][6] = new JProgressBar(soLuongDaHoanThanh, soLuong);
            }
            
            modelTable = new DefaultTableModel(rowCount, columnsName) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if(column == 5) {
                        return true;
                    }
                    return false; // Không cho phép chỉnh sửa giá trị của các ô
                }
            };
            
            jTable1.setModel(modelTable);
            
            setChangeValueSoLuongHoanThanh(modelTable);
            
            setUIForTable();
        }
        
        private void setChangeValueSoLuongHoanThanh(DefaultTableModel modelTable) {
            TableModelListener tableModelListener = new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if(column == 5) {
                        String value = (String) jTable1.getValueAt(row, column);
                        int soLuong = (int)jTable1.getValueAt(row, 3);
                        int soLuongHoanThanh = 0;
                        try {
                            soLuongHoanThanh = Integer.parseInt(value);
                        } catch(Exception ex) {
                            ErrorNormal errorNormal = new ErrorNormal("Bạn nhập sai kiểu dữ liệu");
                            errorNormal.HienThiThongBaoLoi();
                            return;
                        }
                        if(soLuongHoanThanh > soLuong) {
                            ErrorNormal errorNormal = new ErrorNormal("Số lượng hoàn thành không được phép lớn hơn số lượng");
                            errorNormal.HienThiThongBaoLoi();
                        } else {
                            NhiemVuHoanThanh nhiemVuHoanThanh = new NhiemVuHoanThanh();
                            nhiemVuHoanThanh.setiD(jTable1.getValueAt(row, 0).toString());
                            nhiemVuHoanThanh.setSoLuongDaHoanThanh(soLuongHoanThanh);
                            nhiemVuHoanThanh.setDanhGiaNhiemVu("");
                            thucThiBaoTriController.updateSoLuongHoanThanh(nhiemVuHoanThanh);
                            
                            ChiTietThucThiBaoTriView chiTietThucThiBaoTriView = new ChiTietThucThiBaoTriView(thucThiBaoTriController, keHoachDangThucThi);
                            dispose();
                            chiTietThucThiBaoTriView.setVisible(true);
                        }
                    }
                }
            };

            modelTable.addTableModelListener(tableModelListener);
        }
        
        private void setUIForTable() {
            jTable1.getColumnModel().getColumn(6).setCellRenderer(new ProccessBarRenderer());
            jTable1.getColumnModel().getColumn(6).setMinWidth(300);
        }
        
        class ProccessBarRenderer extends JProgressBar implements TableCellRenderer {
            
            public ProccessBarRenderer() {
                setOpaque(true);
            }

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JProgressBar jprocessbar = (JProgressBar) value;
                setForeground(Color.GREEN);
                setMinimum(0);
                setMaximum(jprocessbar.getMaximum());
                setValue(jprocessbar.getMinimum());
                return this;
            }
        }
        
        private void setDataForNhiemVuBaoTri() {
            label_tenNhiemVu.setText(nhiemVuBaoTri.getTenNhiemVu());
            label_ChiTietNhiemVu.setText(nhiemVuBaoTri.getTenNhiemVu());
            Label_chiPhi.setText(nhiemVuBaoTri.getChiPhi() + "");
        }
        
        private void setUI() {
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Label_danhGia = new javax.swing.JLabel();
        checkBox_hoanThanh = new javax.swing.JCheckBox();
        label_tenNhiemVu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_ChiTietNhiemVu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Label_chiPhi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        
        jScrollPane1.setPreferredSize(new Dimension(1000, 200));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setText("Tên nhiệm vụ:");

        jTextArea1.setColumns(20);
        jTextArea1.setText(nhiemVuBaoTri.getDanhGia());
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        Label_danhGia.setText("Đánh giá:");

        jLabel7.setText("Chi tiết nhiệm vụ");

        jLabel9.setText("Chi phí:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout NhiemVuBaoTriContainerLayout = new javax.swing.GroupLayout(this);
        setLayout(NhiemVuBaoTriContainerLayout);
        NhiemVuBaoTriContainerLayout.setHorizontalGroup(
            NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhiemVuBaoTriContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBox_hoanThanh)
                .addGap(28, 28, 28)
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_tenNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_ChiTietNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_chiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_danhGia, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        NhiemVuBaoTriContainerLayout.setVerticalGroup(
            NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_tenNhiemVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(label_ChiTietNhiemVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_chiPhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_danhGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(checkBox_hoanThanh))
                    .addGroup(NhiemVuBaoTriContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NhiemVuBaoTriContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 453, Short.MAX_VALUE))
        );
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NgayKetThucContainer = new javax.swing.JLabel();
        Cover_NhiemVuBaoTri_jScrollpanel = new javax.swing.JScrollPane();
        Btn_confirmHoanThanh = new javax.swing.JButton();
        Btn_Exit = new javax.swing.JButton();

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
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDKeHoachContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NgayBatDauContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NgayBatDauContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
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
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GhiChuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GhiChuContainer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setText("Thời gian kết thúc:");

        NgayKetThucContainer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NgayKetThucContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(81, 391, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_IDKeHoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Btn_confirmHoanThanh.setText("Xác nhận hoàn thành");
        Btn_confirmHoanThanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_confirmHoanThanhMouseClicked(evt);
            }
        });

        Btn_Exit.setText("Thoát");
        Btn_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cover_NhiemVuBaoTri_jScrollpanel)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_confirmHoanThanh)
                .addGap(99, 99, 99)
                .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cover_NhiemVuBaoTri_jScrollpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_confirmHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ExitMouseClicked
        thucThiBaoTriController.getQuanLyBaoTriTaiSanView().setVisible(true);
        this.dispose();
        changeDanhGia();
    }//GEN-LAST:event_Btn_ExitMouseClicked

    private void Btn_confirmHoanThanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_confirmHoanThanhMouseClicked
        HoanThanhBaoTri hoanThanhBaoTri = new HoanThanhBaoTri();
        hoanThanhBaoTri.setiD(keHoachDangThucThi.getiD());
        hoanThanhBaoTri.setDaHoanThanh(true);
        
        NotifyNormal normal = new NotifyNormal("Đã xác nhận thực thi thành công");
        if(thucThiBaoTriController.checkKeHoachBaoTriThucThiDayDu(keHoachDangThucThi)) {
            changeDanhGia();
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn hoàn thành việc thực thi bảo trì?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION) {
                thucThiBaoTriController.hoanThanhBaoTri(hoanThanhBaoTri);
                normal.showNotify();
                this.dispose();
                thucThiBaoTriController.navigateQuanLyBaoTriViewAndUpdateThucThiBaoTriTable();
                thucThiBaoTriController.navigateQuanLyBaoTriViewAndUpdateLichSuBaoTriTable();
            }
        } else {
            String input = JOptionPane.showInputDialog(null, "Bạn chưa hoàn thành đầy đủ thông tin. Bạn phải nhập lý do vì sao:");
            if (input != null) {
                changeDanhGia();
                hoanThanhBaoTri.setLyDoKeThucSom(input);
                thucThiBaoTriController.hoanThanhBaoTri(hoanThanhBaoTri);
                normal.showNotify();
                this.dispose();
                thucThiBaoTriController.navigateQuanLyBaoTriViewAndUpdateThucThiBaoTriTable();
                thucThiBaoTriController.navigateQuanLyBaoTriViewAndUpdateLichSuBaoTriTable();
            }
        }
    }//GEN-LAST:event_Btn_confirmHoanThanhMouseClicked

    
    private void changeDanhGia() {
        Object[] panelCoverNhiemVuBaoTris = coverPanelAllNhiemVuBaoTri.getComponents();
        for(int i=0; i<panelCoverNhiemVuBaoTris.length; i++) {
            PanelForNhiemVuBaoTri panelForNhiemVuBaoTri = (PanelForNhiemVuBaoTri) panelCoverNhiemVuBaoTris[i];
            
            String iD = panelForNhiemVuBaoTri.getName();
            String danhGia = panelForNhiemVuBaoTri.jTextArea1.getText();
            
            NhiemVuBaoTri nhiemVuBaoTri = new NhiemVuBaoTri();
            
            nhiemVuBaoTri.setiD(iD);
            nhiemVuBaoTri.setDanhGia(danhGia);
            thucThiBaoTriController.updateDanhGiaNhiemVuBaoTri(nhiemVuBaoTri);
        }
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
            java.util.logging.Logger.getLogger(ChiTietThucThiBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietThucThiBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietThucThiBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietThucThiBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietThucThiBaoTriView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Exit;
    private javax.swing.JButton Btn_confirmHoanThanh;
    private javax.swing.JScrollPane Cover_NhiemVuBaoTri_jScrollpanel;
    private javax.swing.JLabel GhiChuContainer;
    private javax.swing.JLabel IDKeHoachContainer;
    private javax.swing.JLabel NgayBatDauContainer;
    private javax.swing.JLabel NgayKetThucContainer;
    private javax.swing.JPanel Panel_IDKeHoach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
