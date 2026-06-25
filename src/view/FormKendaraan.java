/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import config.Koneksi;
public class FormKendaraan extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormKendaraan
     */
    public FormKendaraan() {
        initComponents();
        muatComboPelanggan(); // Memanggil daftar pelanggan ke combo box
        tampilkanData();      // Menampilkan isi tabel kendaraan
        membersihkanForm();
    }

    // Fungsi untuk mengosongkan form input kendaraan
    private void membersihkanForm() {
        try {
            txtNoPolisi.setText("");
            txtMerk.setText("");
            txtTipe.setText("");
            cmbPelanggan.setSelectedIndex(0);
        } catch (Exception e) {}
    }

    // Fungsi mengambil ID Pelanggan dari MySQL ke dalam JComboBox
    private void muatComboPelanggan() {
        try {
            cmbPelanggan.removeAllItems();
            cmbPelanggan.addItem("- Pilih ID Pelanggan -");
            
            String sql = "SELECT id_pelanggan, nama_pelanggan FROM tb_pelanggan";
            Connection conn = Koneksi.configDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                // Menampilkan format: "1 - Farisan" di dalam combo box
                cmbPelanggan.addItem(rs.getString("id_pelanggan") + " - " + rs.getString("nama_pelanggan"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data pelanggan ke Combo Box: " + e.getMessage());
        }
    }

    // Fungsi menampilkan data dari tb_kendaraan ke JTable
    private void tampilkanData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No. Polisi");
        model.addColumn("ID Pelanggan");
        model.addColumn("Merk Kendaraan");
        model.addColumn("Tipe Kendaraan");
        
        try {
            String sql = "SELECT * FROM tb_kendaraan";
            Connection conn = Koneksi.configDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("no_polisi"),
                    rs.getString("id_pelanggan"),
                    rs.getString("merk_kendaraan"),
                    rs.getString("tipe_kendaraan")
                });
            }
            // Sesuaikan nama variabel JTable Anda (misal: tblKendaraan atau nama default jTable1)
            // Silakan ganti "jTable1" di bawah jika nama tabelnya berbeda
            tblKendaraan.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat tabel kendaraan: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbPelanggan = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtNoPolisi = new javax.swing.JTextField();
        txtMerk = new javax.swing.JTextField();
        txtTipe = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKendaraan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PENGELOLAAN DATA KENDARAAN");

        jLabel2.setText("No Polisi");

        jLabel3.setText("ID Pelanggan");

        jLabel4.setText("Merk");

        cmbPelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPelangganActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipe");

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

        tblKendaraan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKendaraan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKendaraanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKendaraan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMerk)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 61, Short.MAX_VALUE))
                                    .addComponent(txtTipe)
                                    .addComponent(txtNoPolisi)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNoPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPelangganActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // Validasi inputan combo box
        if (cmbPelanggan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Silakan pilih pelanggan terlebih dahulu!");
            return;
        }

        try {
            // Mengambil ID Pelanggan saja dari teks combo box "1 - Farisan"
            String[] itemTerpilih = cmbPelanggan.getSelectedItem().toString().split(" - ");
            String id_pelanggan = itemTerpilih[0];

            String sql = "INSERT INTO tb_kendaraan (no_polisi, id_pelanggan, merk_kendaraan, tipe_kendaraan) VALUES (?, ?, ?, ?)";
            Connection conn = Koneksi.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            // SEKARANG SUDAH SESUAI DENGAN VARIABEL BARU ANDA:
            pst.setString(1, txtNoPolisi.getText()); 
            pst.setString(2, id_pelanggan);
            pst.setString(3, txtMerk.getText()); 
            pst.setString(4, txtTipe.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Kendaraan Berhasil Ditambahkan!");
            tampilkanData();
            membersihkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data kendaraan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(txtNoPolisi.getText().equals("") || cmbPelanggan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Pilih data kendaraan dari tabel yang ingin diedit!");
            return;
        }
        try {
            // Mengambil ID Pelanggan dari teks combo box "1 - Farisan"
            String[] itemTerpilih = cmbPelanggan.getSelectedItem().toString().split(" - ");
            String id_pelanggan = itemTerpilih[0];

            // Query mengubah data berdasarkan no_polisi
            String sql = "UPDATE tb_kendaraan SET id_pelanggan=?, merk_kendaraan=?, tipe_kendaraan=? WHERE no_polisi=?";
            Connection conn = Koneksi.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, id_pelanggan);
            pst.setString(2, txtMerk.getText());
            pst.setString(3, txtTipe.getText());
            pst.setString(4, txtNoPolisi.getText()); // Primary Key sebagai acuan WHERE
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Kendaraan Berhasil Diperbarui");
            tampilkanData();
            membersihkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = tblKendaraan.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris kendaraan di tabel terlebih dahulu!");
            return;
        }
        
        int jawab = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus kendaraan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION) {
            String no_polisi = tblKendaraan.getValueAt(row, 0).toString();
            try {
                String sql = "DELETE FROM tb_kendaraan WHERE no_polisi = ?";
                Connection conn = Koneksi.configDB();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, no_polisi);
                pst.execute();
                
                JOptionPane.showMessageDialog(this, "Data Kendaraan Berhasil Dihapus");
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

    private void tblKendaraanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKendaraanMouseClicked
        int row = tblKendaraan.getSelectedRow();
        txtNoPolisi.setText(tblKendaraan.getValueAt(row, 0).toString());
        String id_pelanggan = tblKendaraan.getValueAt(row, 1).toString();
        
        // Loop untuk mencocokkan Combo Box berdasarkan ID Pelanggan di tabel
        for (int i = 0; i < cmbPelanggan.getItemCount(); i++) {
            if (cmbPelanggan.getItemAt(i).toString().startsWith(id_pelanggan + " - ")) {
                cmbPelanggan.setSelectedIndex(i);
                break;
            }
        }
        txtMerk.setText(tblKendaraan.getValueAt(row, 2).toString());
        txtTipe.setText(tblKendaraan.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblKendaraanMouseClicked

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
            java.util.logging.Logger.getLogger(FormKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKendaraan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKendaraan;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtNoPolisi;
    private javax.swing.JTextField txtTipe;
    // End of variables declaration//GEN-END:variables
}
