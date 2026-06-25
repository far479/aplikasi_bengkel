package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import config.Koneksi;

public class FormService extends javax.swing.JInternalFrame { // baris 18

    // Update isi konstruktor utama di bawah ini:
    public FormService() {
        initComponents();
        muatComboKendaraan(); // Fungsi mengambil no polisi
        tampilkanData();      // Fungsi mengambil data tabel
        membersihkanForm();   // Fungsi menyetel ulang form
    }
    
private void membersihkanForm() {
        cmbNoPolisi.setSelectedIndex(0);
        jdTanggal.setDate(null);
        txtKeluhan.setText("");
        txtBiaya.setText("");
        cmbStatus.setSelectedIndex(0);
        cmbNoPolisi.requestFocus();
    }

    private void muatComboKendaraan() {
        try {
            cmbNoPolisi.removeAllItems();
            cmbNoPolisi.addItem("- Pilih No Polisi -");
            String sql = "SELECT no_polisi, merk_kendaraan FROM tb_kendaraan";
            Connection conn = Koneksi.configDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                cmbNoPolisi.addItem(rs.getString("no_polisi") + " - " + rs.getString("merk_kendaraan"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat combo kendaraan: " + e.getMessage());
        }
    }

    private void tampilkanData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Service");
        model.addColumn("No Polisi");
        model.addColumn("Tanggal Service");
        model.addColumn("Keluhan");
        model.addColumn("Biaya");
        model.addColumn("Status");
        try {
            String sql = "SELECT * FROM tb_service";
            Connection conn = Koneksi.configDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_service"),
                    rs.getString("no_polisi"),
                    rs.getString("tanggal_service"),
                    rs.getString("keluhan"),
                    rs.getString("biaya"),
                    rs.getString("status_service")
                });
            }
            tblService.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data service: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        cmbNoPolisi = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdTanggal = new com.toedter.calendar.JDateChooser();
        txtKeluhan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBiaya = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("PENGELOLAAN DATA SERVICE");

        cmbNoPolisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("No Polisi");

        jLabel3.setText("Tanggal Service");

        txtKeluhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeluhanActionPerformed(evt);
            }
        });

        jLabel4.setText("Keluhan");

        jLabel5.setText("Biaya");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Status --", "Proses", "Selesai", " " }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        jLabel6.setText("Status");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblService.setModel(new javax.swing.table.DefaultTableModel(
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
        tblService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblService);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKeluhan, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNoPolisi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBiaya))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNoPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jdTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtKeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(cmbNoPolisi.getSelectedIndex() == 0 || jdTanggal.getDate() == null || txtBiaya.getText().equals("")) {
         JOptionPane.showMessageDialog(this, "No Polisi, Tanggal, dan Biaya wajib diisi!");
         return;
     }
     try {
         String[] itemTerpilih = cmbNoPolisi.getSelectedItem().toString().split(" - ");
         String no_polisi = itemTerpilih[0];

         SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
         String tanggal = String.valueOf(fm.format(jdTanggal.getDate()));

         String sql = "INSERT INTO tb_service (no_polisi, tanggal_service, keluhan, biaya, status_service) VALUES (?, ?, ?, ?, ?)";
         Connection conn = Koneksi.configDB();
         PreparedStatement pst = conn.prepareStatement(sql);
         pst.setString(1, no_polisi);
         pst.setString(2, tanggal);
         pst.setString(3, txtKeluhan.getText());
         pst.setString(4, txtBiaya.getText());
         pst.setString(5, cmbStatus.getSelectedItem().toString());

         pst.execute();
         JOptionPane.showMessageDialog(null, "Data Service Berhasil Disimpan!");
         tampilkanData();
         membersihkanForm();
     } catch (Exception e) {
         JOptionPane.showMessageDialog(this, "Gagal Simpan: " + e.getMessage());
     }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblService.getSelectedRow();
     if (row == -1) {
         JOptionPane.showMessageDialog(this, "Pilih data service dari tabel yang ingin diedit!");
         return;
     }
     try {
         String id_service = tblService.getValueAt(row, 0).toString();
         String[] itemTerpilih = cmbNoPolisi.getSelectedItem().toString().split(" - ");
         String no_polisi = itemTerpilih[0];

         SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
         String tanggal = String.valueOf(fm.format(jdTanggal.getDate()));

         String sql = "UPDATE tb_service SET no_polisi=?, tanggal_service=?, keluhan=?, biaya=?, status_service=? WHERE id_service=?";
         Connection conn = Koneksi.configDB();
         PreparedStatement pst = conn.prepareStatement(sql);
         pst.setString(1, no_polisi);
         pst.setString(2, tanggal);
         pst.setString(3, txtKeluhan.getText());
         pst.setString(4, txtBiaya.getText());
         pst.setString(5, cmbStatus.getSelectedItem().toString());
         pst.setString(6, id_service);

         pst.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data Service Berhasil Diperbarui!");
         tampilkanData();
         membersihkanForm();
     } catch (Exception e) {
         JOptionPane.showMessageDialog(this, "Gagal Update: " + e.getMessage());
     }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = tblService.getSelectedRow();
     if (row == -1) {
         JOptionPane.showMessageDialog(this, "Pilih data service pada tabel terlebih dahulu!");
         return;
     }
     int jawab = JOptionPane.showConfirmDialog(this, "Hapus data transaksi service ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
     if(jawab == JOptionPane.YES_OPTION) {
         String id_service = tblService.getValueAt(row, 0).toString();
         try {
             String sql = "DELETE FROM tb_service WHERE id_service = ?";
             Connection conn = Koneksi.configDB();
             PreparedStatement pst = conn.prepareStatement(sql);
             pst.setString(1, id_service);
             pst.execute();

             JOptionPane.showMessageDialog(this, "Data Service Berhasil Dihapus!");
             tampilkanData();
             membersihkanForm();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Gagal Hapus: " + e.getMessage());
         }
     }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        membersihkanForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiceMouseClicked
        try {
         int row = tblService.getSelectedRow();
         String no_polisi = tblService.getValueAt(row, 1).toString();

         for (int i = 0; i < cmbNoPolisi.getItemCount(); i++) {
             if (cmbNoPolisi.getItemAt(i).toString().startsWith(no_polisi)) {
                 cmbNoPolisi.setSelectedIndex(i);
                 break;
             }
         }

         java.util.Date tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(tblService.getValueAt(row, 2).toString());
         jdTanggal.setDate(tanggal);

         txtKeluhan.setText(tblService.getValueAt(row, 3).toString());
         txtBiaya.setText(tblService.getValueAt(row, 4).toString());
         cmbStatus.setSelectedItem(tblService.getValueAt(row, 5).toString());
     } catch (Exception e) {
         System.out.println("Error klik tabel: " + e.getMessage());
     }
    }//GEN-LAST:event_tblServiceMouseClicked

    private void txtKeluhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeluhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeluhanActionPerformed

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
            java.util.logging.Logger.getLogger(FormService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbNoPolisi;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdTanggal;
    private javax.swing.JTable tblService;
    private javax.swing.JTextField txtBiaya;
    private javax.swing.JTextField txtKeluhan;
    // End of variables declaration//GEN-END:variables
}
