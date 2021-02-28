package tampilan;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import koneksi.db_config;

public class Bahan extends javax.swing.JFrame {
private Connection conn = new db_config().getConnection();
private DefaultTableModel tabmode;
    
    public Bahan() {
        initComponents();
        aktif();
        kosong();
        datatable();
        showTable();
    }

    protected void aktif(){
        txt_id.requestFocus();
    }
    
    protected void kosong(){
        txt_id.setText("");
        txt_idp.setText("");
        txt_nama.setText("");
        txt_stok.setText("");
        buttonGroup1.clearSelection();
    }
    
    protected void datatable(){
    Object[] Baris ={"ID Bahan","ID Pedagang","Nama Bahan","Stok", "Satuan","Nama Pedagang"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = txt_cari.getText();
        
        try{
            String sql = "select*from vbahan where ID_bahan like '%"+cariitem+"%' or ID_pedagang like '%"+cariitem+"%' or Nama_bahan like '%"+cariitem+"%' or nama like '%"+cariitem+"%'order by ID_bahan asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6)
                });
            }
            data_bahan.setModel(tabmode);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil"+e);
        }
    }
    
    protected void showTable(){
        DefaultTableModel databhn = new DefaultTableModel();
        databhn.addColumn("ID Bahan");
        databhn.addColumn("ID Pedagang");
        databhn.addColumn("Nama Bahan");
        databhn.addColumn("Stok");
        databhn.addColumn("Satuan");
        databhn.addColumn("Nama Pedagang");
        
        try {
        Connection con = new db_config().getConnection();
        Statement st;
            String sql = "SELECT *from vbahan;";
 
        st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                databhn.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                });
            }
            data_bahan.setModel(databhn);
      
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ada kesalahan" + e);
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_bahan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_idp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        txt_stok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rKg = new javax.swing.JRadioButton();
        rG = new javax.swing.JRadioButton();
        rOns = new javax.swing.JRadioButton();
        rLiter = new javax.swing.JRadioButton();
        rMl = new javax.swing.JRadioButton();
        rBuah = new javax.swing.JRadioButton();
        rEkor = new javax.swing.JRadioButton();
        btn_simpan = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        data_bahan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Bahan", "ID Pedagang", "Nama Bahan", "Stok", "Satuan", "Nama Pedagang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        data_bahan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_bahanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data_bahan);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("DAFTAR BAHAN");

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cariKeyPressed(evt);
            }
        });

        btn_cari.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("ID Bahan");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("ID Pedagang");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nama Bahan");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Satuan");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Stok");

        buttonGroup1.add(rKg);
        rKg.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rKg.setText("kg");

        buttonGroup1.add(rG);
        rG.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rG.setText("g");

        buttonGroup1.add(rOns);
        rOns.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rOns.setText("ons");

        buttonGroup1.add(rLiter);
        rLiter.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rLiter.setText("liter");

        buttonGroup1.add(rMl);
        rMl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rMl.setText("ml");

        buttonGroup1.add(rBuah);
        rBuah.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rBuah.setText("buah");

        buttonGroup1.add(rEkor);
        rEkor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rEkor.setText("ekor");

        btn_simpan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btn_simpan.setText("SIMPAN");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_ubah.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btn_ubah.setText("UBAH");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_keluar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btn_keluar.setText("KELUAR");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cari)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txt_idp)
                            .addComponent(jLabel4)
                            .addComponent(txt_nama)
                            .addComponent(txt_stok)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(rKg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rOns)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rLiter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rMl)
                                .addGap(18, 18, 18)
                                .addComponent(rBuah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rEkor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_simpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ubah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_batal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_keluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rKg)
                            .addComponent(rG)
                            .addComponent(jLabel5)
                            .addComponent(rOns)
                            .addComponent(rLiter)
                            .addComponent(rMl)
                            .addComponent(rBuah)
                            .addComponent(rEkor))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_ubah)
                    .addComponent(btn_hapus)
                    .addComponent(btn_batal)
                    .addComponent(btn_keluar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        String satuan = null;
        if(rKg.isSelected()){
            satuan="kg";
        }else if(rG.isSelected()){
            satuan="g";
        }else if(rOns.isSelected()){
            satuan="ons";
        }else if(rLiter.isSelected()){
            satuan="liter";
        }else if(rMl.isSelected()){
            satuan="ml";
        }else if (rBuah.isSelected()){
            satuan="buah";
        }else if (rEkor.isSelected()){
            satuan="ekor";
        }
        
        String sql = "insert into bahan values (?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txt_id.getText());
            stat.setString(2, txt_idp.getText());
            stat.setString(3, txt_nama.getText());
            stat.setString(4, txt_stok.getText());
            stat.setString(5, satuan);
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            kosong();
            txt_id.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal disimpan"+e);
        }
        datatable();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        String satuan=null;
        if(rKg.isSelected()){
            satuan="kg";
        }else if(rG.isSelected()){
            satuan="g";
        }else if(rOns.isSelected()){
            satuan="ons";
        }else if(rLiter.isSelected()){
            satuan="liter";
        }else if(rMl.isSelected()){
            satuan="ml";
        }else if (rBuah.isSelected()){
            satuan="buah";
        }else if (rEkor.isSelected()){
            satuan="ekor";
        }
        
        try{
            String sql = "update bahan set ID_Bahan=?,ID_Pedagang=?,Nama_Bahan=?,Stok=?,Satuan=? where ID_Bahan='"+txt_id.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txt_id.getText());
            stat.setString(2, txt_idp.getText());
            stat.setString(3, txt_nama.getText());
            stat.setString(4, txt_stok.getText());
            stat.setString(5, satuan);
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            kosong();
            txt_id.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal diubah"+e);
        }
        datatable();
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
       int ok = JOptionPane.showConfirmDialog(null, "Hapus Data?","Pesan Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "delete from bahan where ID_bahan ='"+txt_id.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                txt_id.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
            datatable();
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
       kosong();
       datatable();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void data_bahanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_bahanMouseClicked
        int bar = data_bahan.getSelectedRow();
        String a = data_bahan.getValueAt(bar, 0).toString();
        String b = data_bahan.getValueAt(bar, 1).toString();
        String c = data_bahan.getValueAt(bar, 2).toString();
        String d = data_bahan.getValueAt(bar, 3).toString();
        String e = data_bahan.getValueAt(bar, 4).toString();
        
        txt_id.setText(a);
        txt_idp.setText(b);
        txt_nama.setText(c);
        txt_stok.setText(d);
        
        if ("kg".equals(e)){
            rKg.setSelected(true);
        } else if ("g".equals(e)){
            rG.setSelected(true);
        } else if ("ons".equals(e)){
            rOns.setSelected(true);
        } else if ("liter".equals(e)){
            rLiter.setSelected(true);
        } else if ("ml".equals(e)){
            rMl.setSelected(true);
        } else if ("buah".equals(e)){
            rBuah.setSelected(true);
        } else{
            rEkor.setSelected(true);
        }
    }//GEN-LAST:event_data_bahanMouseClicked

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        datatable();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            datatable();
        }
    }//GEN-LAST:event_txt_cariKeyPressed

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
            java.util.logging.Logger.getLogger(Bahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bahan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bahan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable data_bahan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rBuah;
    private javax.swing.JRadioButton rEkor;
    private javax.swing.JRadioButton rG;
    private javax.swing.JRadioButton rKg;
    private javax.swing.JRadioButton rLiter;
    private javax.swing.JRadioButton rMl;
    private javax.swing.JRadioButton rOns;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_idp;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_stok;
    // End of variables declaration//GEN-END:variables
}
