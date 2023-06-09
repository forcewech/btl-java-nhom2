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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thinh
 */
public class Add_UpdateNhiemVuBaoTriView extends javax.swing.JFrame {

    private KeHoachBaoTriController keHoachBaoTriController;
    private NhiemVuBaoTri nhiemVuBaoTri;
    private boolean isAddKeHoachBaoTri;
    private KeHoachBaoTri keHoachBaoTri;

    public KeHoachBaoTri getKeHoachBaoTri() {
        return keHoachBaoTri;
    }

    public void setKeHoachBaoTri(KeHoachBaoTri keHoachBaoTri) {
        this.keHoachBaoTri = keHoachBaoTri;
    }
    
    public Add_UpdateNhiemVuBaoTriView() {
        initComponents();
        
    }
    
    public Add_UpdateNhiemVuBaoTriView(KeHoachBaoTriController keHoachBaoTriController, NhiemVuBaoTri nhiemVuBaoTri, boolean isAddKeHoachBaoTri) {
        initComponents();
        
        this.keHoachBaoTriController = keHoachBaoTriController;
        this.nhiemVuBaoTri = nhiemVuBaoTri;
        this.isAddKeHoachBaoTri = isAddKeHoachBaoTri;
        initDataForUpdate();
        UIForUpdate();
    }
    
    public Add_UpdateNhiemVuBaoTriView(KeHoachBaoTriController keHoachBaoTriController, KeHoachBaoTri keHoachBaoTri, boolean isAddKeHoachBaoTri) {
        initComponents();
        
        this.keHoachBaoTriController = keHoachBaoTriController;
        this.keHoachBaoTri = keHoachBaoTri;
        this.isAddKeHoachBaoTri = isAddKeHoachBaoTri;
        UIForAdd();
    }
    
    private void initDataForUpdate() {
        TF_tenNhiemVu.setText(nhiemVuBaoTri.getTenNhiemVu());
        TF_chiTietNhiemVu.setText(nhiemVuBaoTri.getChiTietNhiemVu());
        TF_ChiPhi.setText(nhiemVuBaoTri.getChiPhi() + "");
    }
    
    private void UIForUpdate() {
        Btn_add.setVisible(false);
    }
    
    private void UIForAdd() {
        Btn_update.setVisible(false);
        Btn_delete.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TF_tenNhiemVu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TF_chiTietNhiemVu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TF_ChiPhi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Btn_update = new javax.swing.JButton();
        Btn_add = new javax.swing.JButton();
        Btn_delete = new javax.swing.JButton();
        Btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nhiệm vụ bảo trì");

        jLabel2.setText("Tên nhiệm vụ: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(TF_tenNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_tenNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Chi tiết nhiệm vụ:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(TF_chiTietNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_chiTietNhiemVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Chi phí:");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(TF_ChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_ChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Btn_update.setText("Cập nhật");
        Btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_updateMouseClicked(evt);
            }
        });

        Btn_add.setText("Thêm");
        Btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_addMouseClicked(evt);
            }
        });

        Btn_delete.setText("Xóa");
        Btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_deleteMouseClicked(evt);
            }
        });

        Btn_exit.setText("Thoát");
        Btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(341, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_Btn_exitMouseClicked

    private void Btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_updateMouseClicked
        if(isAddKeHoachBaoTri) {
            try {
                updateNhiemVuBaoTriByAddKeHoachBaoTri();
                this.dispose();
                keHoachBaoTriController.getChiTietKeHoachBaoTriView().hienThiNhiemVuBaoTriforAdd();
            } catch(NumberFormatException ex) {
                ErrorNormal errorNormal = new ErrorNormal(ex.getMessage());
                errorNormal.HienThiThongBaoLoi();
            }
        } else {
            try {
                updateNhiemVuBaoTriByUpdateKeHoachBaoTri();
                this.dispose();
                keHoachBaoTriController.getChiTietKeHoachBaoTriView().hienThiNhiemVuBaoTriforUpDate();
            } catch(NumberFormatException ex) {
                ErrorNormal errorNormal = new ErrorNormal(ex.getMessage());
                errorNormal.HienThiThongBaoLoi();
            }
        }
    }//GEN-LAST:event_Btn_updateMouseClicked

    private void updateNhiemVuBaoTriByAddKeHoachBaoTri() {
        String tenNhiemVu = TF_tenNhiemVu.getText().trim();
        String chiTietNhiemVu = TF_chiTietNhiemVu.getText().trim();
        int chiPhi = Integer.parseInt(TF_ChiPhi.getText().trim());

        nhiemVuBaoTri.setTenNhiemVu(tenNhiemVu);
        nhiemVuBaoTri.setChiTietNhiemVu(chiTietNhiemVu);
        nhiemVuBaoTri.setChiPhi(chiPhi);

        ArrayList<NhiemVuBaoTri> nhiemVubaoTriList = (ArrayList<NhiemVuBaoTri>) keHoachBaoTriController.getChiTietKeHoachBaoTriView().getNhiemVuBaoTriList();

        for(int i=0; i<nhiemVubaoTriList.size(); i++) {
            if(nhiemVubaoTriList.get(i).getiD().equals(nhiemVuBaoTri.getiD())) {
                nhiemVubaoTriList.set(i, nhiemVuBaoTri);
            }
        }
    }
    
    private void updateNhiemVuBaoTriByUpdateKeHoachBaoTri() {
        String tenNhiemVu = TF_tenNhiemVu.getText().trim();
        String chiTietNhiemVu = TF_chiTietNhiemVu.getText().trim();
        int chiPhi = Integer.parseInt(TF_ChiPhi.getText().trim());

        nhiemVuBaoTri.setTenNhiemVu(tenNhiemVu);
        nhiemVuBaoTri.setChiTietNhiemVu(chiTietNhiemVu);
        nhiemVuBaoTri.setChiPhi(chiPhi);

        keHoachBaoTriController.updateNhiemVuBaoTri(nhiemVuBaoTri);
    }
    
    
    private void Btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_deleteMouseClicked
        if(isAddKeHoachBaoTri) {
            deleteNhiemVuBaoTriByAddKeHoachBaoTri();
            this.dispose();
            keHoachBaoTriController.getChiTietKeHoachBaoTriView().hienThiNhiemVuBaoTriforAdd();
        } else {
            keHoachBaoTriController.deleteNhiemVuBaoTri(nhiemVuBaoTri);
            this.dispose();
            keHoachBaoTriController.getChiTietKeHoachBaoTriView().hienThiNhiemVuBaoTriforUpDate();
        }
    }//GEN-LAST:event_Btn_deleteMouseClicked

    private void deleteNhiemVuBaoTriByAddKeHoachBaoTri() {
        
        HashMap<NhiemVuBaoTri, List<NghiepVuBaoTriTaiSan>> taiSanBaoTriLinkNghiepVuBaoTri = keHoachBaoTriController.getChiTietKeHoachBaoTriView().getNhiemVuBaoTriLinkNghiepVuBaoTriList();
        ArrayList<NhiemVuBaoTri> nhiemVuBaoTrisList = (ArrayList<NhiemVuBaoTri>)keHoachBaoTriController.getChiTietKeHoachBaoTriView().getNhiemVuBaoTriList();
        
        for(int i=0; i<nhiemVuBaoTrisList.size(); i++) {
            if(nhiemVuBaoTri.getiD().equals(nhiemVuBaoTrisList.get(i).getiD())) {
                nhiemVuBaoTrisList.remove(i);
                break;
            }
        }
        
        for (Map.Entry<NhiemVuBaoTri, List<NghiepVuBaoTriTaiSan>> entry : taiSanBaoTriLinkNghiepVuBaoTri.entrySet()) {
            NhiemVuBaoTri nhiemVuBaotriFromTaiSanBaoTriLinkNghiepVuBaoTriList = entry.getKey();
            if(nhiemVuBaotriFromTaiSanBaoTriLinkNghiepVuBaoTriList.getiD().equals(nhiemVuBaoTri.getiD())) {
                taiSanBaoTriLinkNghiepVuBaoTri.remove(entry.getKey());
            }
        }
        
    }
    
    
    private void Btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_addMouseClicked
        if(isAddKeHoachBaoTri) {
            try {
                addNhiemVuBaoTriByAddKeHoachBaoTri();
                this.dispose();
                keHoachBaoTriController.getChiTietKeHoachBaoTriView().hienThiNhiemVuBaoTriforAdd();
            } catch(NumberFormatException ex) {
                ErrorNormal errorNormal = new ErrorNormal(ex.getMessage());
                errorNormal.HienThiThongBaoLoi();
            }
        } else {
            try {
                addNhiemVuBaoTriByUpdateKeHoachBaoTri();
                this.dispose();
                keHoachBaoTriController.getChiTietKeHoachBaoTriView().hienThiNhiemVuBaoTriforUpDate();
            } catch(NumberFormatException ex) {
                ErrorNormal errorNormal = new ErrorNormal(ex.getMessage());
                errorNormal.HienThiThongBaoLoi();
            }
        }
    }//GEN-LAST:event_Btn_addMouseClicked

    private void addNhiemVuBaoTriByAddKeHoachBaoTri() {
        NhiemVuBaoTri nhiemVuBaoTri = new NhiemVuBaoTri();
        String tenNhiemVu = TF_tenNhiemVu.getText().trim();
        String chiTietNhiemVu = TF_chiTietNhiemVu.getText().trim();
        int chiPhi = Integer.parseInt(TF_ChiPhi.getText().trim());

        nhiemVuBaoTri.setiD(keHoachBaoTriController.randomIDWith6Char());
        nhiemVuBaoTri.setiDKeHoachBaoTri(keHoachBaoTri.getiD());
        nhiemVuBaoTri.setTenNhiemVu(tenNhiemVu);
        nhiemVuBaoTri.setChiTietNhiemVu(chiTietNhiemVu);
        nhiemVuBaoTri.setChiPhi(chiPhi);

        keHoachBaoTriController.getChiTietKeHoachBaoTriView().getNhiemVuBaoTriList().add(nhiemVuBaoTri);
        keHoachBaoTriController.getChiTietKeHoachBaoTriView().getNhiemVuBaoTriLinkNghiepVuBaoTriList().put(nhiemVuBaoTri, new ArrayList<NghiepVuBaoTriTaiSan>());
    }
    
    private void addNhiemVuBaoTriByUpdateKeHoachBaoTri() throws NumberFormatException {
        NhiemVuBaoTri nhiemVuBaoTri = new NhiemVuBaoTri();
        String tenNhiemVu = TF_tenNhiemVu.getText().trim();
        String chiTietNhiemVu = TF_chiTietNhiemVu.getText().trim();
        int chiPhi = Integer.parseInt(TF_ChiPhi.getText().trim());

        nhiemVuBaoTri.setiD(keHoachBaoTriController.randomIDWith6Char());
        nhiemVuBaoTri.setiDKeHoachBaoTri(keHoachBaoTri.getiD());
        nhiemVuBaoTri.setTenNhiemVu(tenNhiemVu);
        nhiemVuBaoTri.setChiTietNhiemVu(chiTietNhiemVu);
        nhiemVuBaoTri.setChiPhi(chiPhi);

        keHoachBaoTriController.addNhiemVuBaoTri(nhiemVuBaoTri);
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
            java.util.logging.Logger.getLogger(Add_UpdateNhiemVuBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_UpdateNhiemVuBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_UpdateNhiemVuBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_UpdateNhiemVuBaoTriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_UpdateNhiemVuBaoTriView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_add;
    private javax.swing.JButton Btn_delete;
    private javax.swing.JButton Btn_exit;
    private javax.swing.JButton Btn_update;
    private javax.swing.JTextField TF_ChiPhi;
    private javax.swing.JTextField TF_chiTietNhiemVu;
    private javax.swing.JTextField TF_tenNhiemVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
