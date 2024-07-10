/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tkalfajr;

import Connect.Koneksi;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class D_DataSiswa extends javax.swing.JFrame {
    int xx, xy ;
    Connection conn = new Koneksi().connect();
    
     Object[] row = {"NIP", "Nama", "Tanggal Lahir", "Agama", "Alamat", "Jenis Kelamin"};
    DefaultTableModel tabmode = new DefaultTableModel(null, row);

    
    protected void DataParaSiswa() {
        refresh();
        jtabelsiswa.setModel(tabmode);
        String query = "select * from tb_siswa";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                String a = rs.getString("NIP");
                String b = rs.getString("Nama_Siswa");
                String c = rs.getString("Tanggal_Lahir");
                String d = rs.getString("Agama");
                String e = rs.getString("Alamat");
                String f = rs.getString("Jenis_Kelamin");
                
                String[] data = {a, b, c, d, e, f};
                tabmode.addRow(data);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    protected void simpan() {
        String query = "insert into tb_siswa (NIP,Nama_Siswa,Tanggal_Lahir,Agama,Alamat,Jenis_Kelamin) values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tnip.getText());
            pst.setString(2,tnama.getText());
            pst.setString(3,ttgl.getText());
            pst.setString(4,tagama.getText());
            pst.setString(5,talamat.getText());
            if (tlaki.isSelected()){
                pst.setString(6,tlaki.getText());
            }
            else if (tperempuan.isSelected()){
                pst.setString(6,tperempuan.getText());
            }

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been saved");
            DataParaSiswa();
        } catch (SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
            
        } 
         
    }
    
    protected void edit() {
        try {
            String query = "update tb_siswa set Nip=?, Nama_Siswa=?, Tanggal_Lahir=?,"
                    + " Agama=?, Alamat=?, Jenis_Kelamin=? where Nip=?";
            

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tnip.getText());
            pst.setString(2,tnama.getText());
            pst.setString(3,ttgl.getText());
            pst.setString(4,tagama.getText());
           pst.setString(5,talamat.getText());
            if (tlaki.isSelected()){
                pst.setString(6,tlaki.getText());
            }
            else if (tperempuan.isSelected()){
                pst.setString(6,tperempuan.getText());
                
            }
             pst.setString(7,tnip.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been update");
            DataParaSiswa();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    protected void delete() {
        int choice = JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete ?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (choice == 0) {
            try {
                String query = "delete from tb_siswa where Nip=" + tnip.getText();
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data has been delete");
            } catch (Exception e) {
            }
            
        }
        DataParaSiswa();
    }
    
    protected void refresh() {
        int row = tabmode.getRowCount();
        for(int i = 0; i < row; i++) {
            tabmode.removeRow(0);
        }
    }
    
    protected void tekantabel() {
        try {
            int row = jtabelsiswa.getSelectedRow();
            tnip.setText((String) jtabelsiswa.getModel().getValueAt(row, 0));
            tnama.setText((String) jtabelsiswa.getModel().getValueAt(row, 1));
            ttgl.setText((String) jtabelsiswa.getModel().getValueAt(row, 2));
            tagama.setText((String) jtabelsiswa.getModel().getValueAt(row, 3));
            talamat.setText((String) jtabelsiswa.getModel().getValueAt(row, 4));
            if (jtabelsiswa.getModel().getValueAt(row, 5).equals("Laki-Laki")){
                btgrup.setSelected(tlaki.getModel(), true);
               
            } else {
                btgrup.setSelected(tperempuan.getModel(), true);
            }
        } catch (Exception e) {
}
}
    
    /**
     * Creates new form B_Beranda
     */
    public D_DataSiswa() {
         initComponents();
        DataParaSiswa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btkembali = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btkeluar = new javax.swing.JButton();
        btdataguru = new javax.swing.JButton();
        btdatakelas = new javax.swing.JButton();
        btdatamapel = new javax.swing.JButton();
        btdatajadwal = new javax.swing.JButton();
        btdatanilai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ttgl = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tnip = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tnama = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tperempuan = new javax.swing.JRadioButton();
        tlaki = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        tagama = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        talamat = new javax.swing.JTextField();
        btsimpan = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabelsiswa = new javax.swing.JTable();
        btcetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(103, 242, 209));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(103, 242, 209));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jPanel4.setBackground(new java.awt.Color(103, 242, 209));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        btkembali.setBackground(new java.awt.Color(232, 236, 241));
        btkembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_home_20px.png"))); // NOI18N
        btkembali.setText("Beranda");
        btkembali.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btkembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkembaliActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo atk.png"))); // NOI18N

        btkeluar.setBackground(new java.awt.Color(232, 236, 241));
        btkeluar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_export_20px.png"))); // NOI18N
        btkeluar.setText("Keluar");
        btkeluar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btkeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkeluarActionPerformed(evt);
            }
        });

        btdataguru.setBackground(new java.awt.Color(232, 236, 241));
        btdataguru.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btdataguru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_coach_20px.png"))); // NOI18N
        btdataguru.setText("Data Guru");
        btdataguru.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btdataguru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdataguru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdataguruActionPerformed(evt);
            }
        });

        btdatakelas.setBackground(new java.awt.Color(232, 236, 241));
        btdatakelas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btdatakelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_classroom_20px.png"))); // NOI18N
        btdatakelas.setText("Data Kelas");
        btdatakelas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btdatakelas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdatakelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdatakelasActionPerformed(evt);
            }
        });

        btdatamapel.setBackground(new java.awt.Color(232, 236, 241));
        btdatamapel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btdatamapel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Books_18px.png"))); // NOI18N
        btdatamapel.setText("Data Mapel");
        btdatamapel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btdatamapel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdatamapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdatamapelActionPerformed(evt);
            }
        });

        btdatajadwal.setBackground(new java.awt.Color(232, 236, 241));
        btdatajadwal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btdatajadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_planner_19px.png"))); // NOI18N
        btdatajadwal.setText("Data Jadwal");
        btdatajadwal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btdatajadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdatajadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdatajadwalActionPerformed(evt);
            }
        });

        btdatanilai.setBackground(new java.awt.Color(232, 236, 241));
        btdatanilai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btdatanilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_scorecard_19px.png"))); // NOI18N
        btdatanilai.setText("Data Nilai");
        btdatanilai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btdatanilai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdatanilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdatanilaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(23, 23, 23))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btdatakelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdataguru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdatanilai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdatajadwal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(btdatamapel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(btdataguru)
                .addGap(18, 18, 18)
                .addComponent(btdatakelas)
                .addGap(18, 18, 18)
                .addComponent(btdatamapel)
                .addGap(18, 18, 18)
                .addComponent(btdatajadwal)
                .addGap(18, 18, 18)
                .addComponent(btdatanilai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btkembali)
                .addGap(18, 18, 18)
                .addComponent(btkeluar)
                .addGap(43, 43, 43))
        );

        jPanel1.setBackground(new java.awt.Color(197, 239, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_cancel_24px.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_minimize_window_24px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("FORM DATA MURID");
        jLabel4.setFocusTraversalPolicyProvider(true);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("NIS");

        ttgl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        ttgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttglActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Jenis Kelamin");

        tnip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnipActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("Nama Murid");

        tnama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("Tanggal Lahir");

        btgrup.add(tperempuan);
        tperempuan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tperempuan.setLabel("Perempuan");
        tperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tperempuanActionPerformed(evt);
            }
        });

        btgrup.add(tlaki);
        tlaki.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tlaki.setText("Laki-Laki");
        tlaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlakiActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Agama");

        tagama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tagama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagamaActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setText("Alamat");

        talamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        talamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                talamatActionPerformed(evt);
            }
        });

        btsimpan.setBackground(new java.awt.Color(204, 204, 204));
        btsimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });

        btedit.setBackground(new java.awt.Color(204, 204, 204));
        btedit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btedit.setText("Edit");
        btedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditActionPerformed(evt);
            }
        });

        bthapus.setBackground(new java.awt.Color(204, 204, 204));
        bthapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        jtabelsiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jtabelsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelsiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabelsiswa);

        btcetak.setBackground(new java.awt.Color(204, 204, 204));
        btcetak.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btcetak.setText("Cetak");
        btcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(btcetak, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tnip, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(tnama)
                                    .addGap(4, 4, 4))
                                .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel17))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tagama, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(tlaki)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tperempuan)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btsimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btedit)
                                .addGap(18, 18, 18)
                                .addComponent(bthapus)
                                .addGap(19, 19, 19)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btsimpan)
                        .addComponent(btedit)
                        .addComponent(bthapus))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(tlaki)
                            .addComponent(tperempuan))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(tagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(talamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btcetak)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(804, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx=  evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void ttglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttglActionPerformed

    private void tnipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnipActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void tperempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tperempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tperempuanActionPerformed

    private void tlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tlakiActionPerformed

    private void tagamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tagamaActionPerformed

    private void talamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_talamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_talamatActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        edit();
    }//GEN-LAST:event_bteditActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        delete();
    }//GEN-LAST:event_bthapusActionPerformed

    private void jtabelsiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelsiswaMouseClicked
        tekantabel();
    }//GEN-LAST:event_jtabelsiswaMouseClicked

    private void btkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkembaliActionPerformed
        new B_Beranda().setVisible(true);
        dispose();
    }//GEN-LAST:event_btkembaliActionPerformed

    private void btkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkeluarActionPerformed
        new A_LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_btkeluarActionPerformed

    private void btdataguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdataguruActionPerformed
        new C_DataGuru().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdataguruActionPerformed

    private void btdatakelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatakelasActionPerformed
        new E_DataKelas().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatakelasActionPerformed

    private void btdatamapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatamapelActionPerformed
        new F_DataMapel().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatamapelActionPerformed

    private void btdatajadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatajadwalActionPerformed
        new G_DataJadwal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatajadwalActionPerformed

    private void btdatanilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatanilaiActionPerformed
        new H_DataNilai().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatanilaiActionPerformed

    private void btcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcetakActionPerformed
        try {
         JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("D_DataSiswa.jasper"), null, Koneksi.connect());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }
    }//GEN-LAST:event_btcetakActionPerformed

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
            java.util.logging.Logger.getLogger(D_DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(D_DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(D_DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(D_DataSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new D_DataSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcetak;
    private javax.swing.JButton btdataguru;
    private javax.swing.JButton btdatajadwal;
    private javax.swing.JButton btdatakelas;
    private javax.swing.JButton btdatamapel;
    private javax.swing.JButton btdatanilai;
    private javax.swing.JButton btedit;
    private javax.swing.ButtonGroup btgrup;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btkeluar;
    private javax.swing.JButton btkembali;
    private javax.swing.JButton btsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabelsiswa;
    private javax.swing.JTextField tagama;
    private javax.swing.JTextField talamat;
    private javax.swing.JRadioButton tlaki;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tnip;
    private javax.swing.JRadioButton tperempuan;
    private javax.swing.JTextField ttgl;
    // End of variables declaration//GEN-END:variables
}
