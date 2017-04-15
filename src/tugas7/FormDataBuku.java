/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas7;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        

/**
 *
 * @author Yunia Fransiska
 */
public class FormDataBuku extends javax.swing.JFrame {
     private DefaultTableModel model;
     private Connection con = koneksi.getConnection();
     private Statement stt;
     private ResultSet rss;
     public int id=0, count=0;
        
    /**
     * Creates new form koneksi
     */
     private int baris;
private boolean cek=true;
    public FormDataBuku() {
        initComponents();
       
    }
    
    public void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("ID BUKU");
        model.addColumn("JUDUL");
        model.addColumn("PENULIS");
        model.addColumn("HARGA");
        
        jTable2.setModel(model);
    }

    private void TampilData(){
        try{
            String sql = "SELECT * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
                     while(rss.next()){
                         Object[] o = new Object[4];
                         o[0] = rss.getString("id");
                         o[1] = rss.getString("judul");
                         o[2] = rss.getString("penulis");
                         o[3] = rss.getInt("harga");
                         model.addRow(o);
                     }
        }catch(SQLException e){
        System.out.println(e.getMessage());;
    }
    }
    
    public boolean UbahData(String id, String judul, String penulis, String harga){
    try {
        String sql = "update buku set judul='"+judul+"',penulis ='"+penulis+"', harga='"+harga+"' where id="+id+";";
        stt = con.createStatement();
        stt.executeUpdate(sql);
        return true;
    }    catch(SQLException e){
        System.out.println(e.getMessage());
        return false;
    }
    }
    
    public boolean HapusData(String id){
        try{
            String sql = "delete from buku where id="+id+";";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        } catch(SQLException e){
            System.out.println(e.getMessage());;
            return false;
        }
    }
    
    private void TambahData(String judul, String penulis, String harga){
        try {
            String sql = "INSERT INTO buku VALUES (NULL, '"+judul+"','"+penulis+"', "+harga+")";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{judul, penulis, harga});
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
           }
   
        private void validasidata(String judul, String penulis, String harga) {//disini adalah sisi validasi dimana setiap data judul dan penulis yang masuk di huruf kecilkan
        try{
            String sql ="SELECT *FROM buku";//kita menampilkan dulu buku kemudian
            stt = con.createStatement();//variabel menampung dari sql yang udah ditentukan
            ResultSet rss = stt.executeQuery(sql);//variable penampung eksekusi pada sql
            while(rss.next()){
                Object[] o = new Object[2];//membuat objek baru
                o[0]=rss.getString("judul").toLowerCase();//disini adalah sisi dimana objek yang baru di masukkan dengan huruf kecil
                o[1]=rss.getString("penulis").toLowerCase();//disini adalah sisi objek dimana mendapati tulisan dengan masukkan dibandingkan dengan sql yang sudah di huruf kecilkan
                
                if(o[0].equals(judul.toLowerCase())&&o[1].equals(penulis.toLowerCase())){
                    JOptionPane.showMessageDialog(null,"DATA TELAH ADA");//untuk membandingkan dan mencegah data duplikat dimana judul dan pengarang yang sama berada di database yang sama maka jika nama pengarang dan judul yang sama maka akan muncul pemberitahuan bahwa data telah ada 
                    cek=false;//dan nilai cek berubah menjadi false
                    break;                    
                }
            }
            if(cek==true){
                TambahData(judul,penulis, harga);//ketika nilai cek masih bernilai benar maka akan lari ke method tambah data dimana data akan tersimpan
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }//jadi sebelum menyimpan data ada method validasi ini dimana gunanya mengecek dulu apakah sudah ada judul dan pengarang yang sama jika suddah ada maka data tidak bisa tersimpan tapi jika tidak ada buku yang kondisinya nama dan pengarang sama maka data akan tersimpan
    }
    private void caridata(String judul,String penulis){//disini saya membuat method untuk mencari judul dimana akan menampilkan data berdasarkan judul yang sama 
         try{
            //apa yang diketikkan pda field cari akan di lowercase kan 
            String sql ="SELECT *FROM buku where "+judul+" LIKE '%"+penulis+"%'";
            stt = con.createStatement();
            ResultSet rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o =new Object[4];
                o[0]=rss.getInt("id");
                o[1]=rss.getString("JUDUL").toLowerCase();//dari sisi judul pun juga akan mengecilkan huruf yang ada sehingga akan membandingkan sesama huruf kecil dan akan tetep ketemu biarpun beda kecilnya berbeda
                o[2]=rss.getString("PENULIS").toLowerCase();
                o[3]=rss.getInt("HARGA");
                model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtjudul = new javax.swing.JTextField();
        combopenulis = new javax.swing.JComboBox<>();
        txtharga = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        combocari = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setText("FORM DATA BUKU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setText("Judul");

        jLabel3.setText("Penulis");

        jLabel4.setText("Harga");

        combopenulis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tere Liye", "W.S. Rendra", "Felix Slauw", "Asma Nadia", "Dewi Lestari" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combopenulis, 0, 241, Short.MAX_VALUE)
                            .addComponent(txtharga))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combopenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToggleButton1.setText("simpan");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("ubah");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("hapus");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("keluar");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "judul", "penulis", "harga"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("Search :");

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });

        combocari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul", "penulis", "harga" }));
        combocari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocariActionPerformed(evt);
            }
        });

        jLabel6.setText("by:");

        cari.setText("SEARCH");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cari))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jToggleButton1)
                                .addGap(10, 10, 10)
                                .addComponent(jToggleButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combocari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combocari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
       if(txtjudul.getText().equals("")||txtharga.getText().equals("")){
         JOptionPane.showMessageDialog(null,"DATA BELUM LENGKAP","Danger!!",JOptionPane.INFORMATION_MESSAGE);
         txtjudul.requestFocus();//apabila field harga dan judul kosong maka akan muncul pemberitahuan bahwa masih ada data yang kosong.
     }
        String judul = txtjudul.getText();
      String penulis = combopenulis.getSelectedItem().toString();
      String harga = txtharga.getText();
     
      validasidata(judul,penulis,harga);
      
      InitTable();
      TampilData();
      txtjudul.setText("");
      combopenulis.getSelectedItem();
      txtharga.setText("");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void combocariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocariActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_combocariActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
        
        txtjudul.setText(jTable2.getValueAt(baris, 1).toString());
        combopenulis.setSelectedItem(jTable2.getValueAt(baris, 2).toString());
        txtharga.setText(jTable2.getValueAt(baris, 3).toString());
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
        String id= jTable2.getValueAt(baris, 0).toString();
        String judul = txtjudul.getText();
        String penulis = combopenulis.getSelectedItem().toString();
        String harga = txtharga.getText();
        if (UbahData(id, judul, penulis, harga))
            JOptionPane.showMessageDialog(null, "berhasil ubah data");
        else
            JOptionPane.showMessageDialog(null, "gagal ubah data");
        InitTable(); TampilData();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
        String id = jTable2.getValueAt(baris, 0).toString();
        if(HapusData(id))
           JOptionPane.showMessageDialog(null, "berhasil Hapus data");
        else
            JOptionPane.showMessageDialog(null, "gagal Hapus Data");
        InitTable(); TampilData();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
         if(cari.getText().equals("")){
            //pada button cari saat field dari cari masih kosong maka akan ada peringatan bahwa tombol cari masih kosong
             JOptionPane.showMessageDialog(null,"MAU CARI APA ?","WARNING!!",JOptionPane.INFORMATION_MESSAGE);
         }
        else{
            model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
      caridata(combocari.getSelectedItem().toString(),cari.getText().toLowerCase());
        }
    }//GEN-LAST:event_cariActionPerformed

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
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cari;
    private javax.swing.JComboBox<String> combocari;
    private javax.swing.JComboBox<String> combopenulis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjudul;
    // End of variables declaration//GEN-END:variables
}
