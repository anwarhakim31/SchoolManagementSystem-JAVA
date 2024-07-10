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
public class G_DataJadwal extends javax.swing.JFrame {
    int xx, xy ;
Connection conn = new Koneksi().connect();
    
     Object[] row = {"NIP", "Kode Mapel", "Nama Mapel", "Nama Guru", "Kode Kelas", "Hari", "Jam"};
    DefaultTableModel tabmode = new DefaultTableModel(null, row);
    
    
    protected void DataJadwal() {
        refresh();
        jtabeljadwal.setModel(tabmode);
        String query = "select * from tb_jadwal";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                String a = rs.getString("NIP");
                String b = rs.getString("Kode_Mapel");
                String c = rs.getString("Nama_Mapel");
                String d = rs.getString("Nama_Guru");
                String e = rs.getString("Kode_Kelas");
                String f = rs.getString("Hari");
                String g = rs.getString("Jam");
                
                String[] data = {a, b, c, d, e, f, g};
                tabmode.addRow(data);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    protected void simpan() {
        String query = "insert into tb_jadwal (NIP,Kode_Mapel,Nama_Mapel,Nama_Guru,Kode_Kelas,Hari,Jam) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tnip.getText());
            pst.setString(2,tkodemapel.getText());
            pst.setString(3,tnamamapel.getText());
            pst.setString(4,tnamaguru.getText());
            pst.setString(5,tkodekelas.getText());
            pst.setString(6,thari.getText());
            pst.setString(7,tjam.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been saved");
            DataJadwal();
        } catch (SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
            
        } 
         
    }
    
    
     protected void edit() {
        try {
            String query = "update tb_jadwal set NIP=?, Kode_Mapel=?, Nama_Mapel=?," 
                    + " Nama_Guru=?, Kode_Kelas=?, Hari=?, Jam=? where NIP=?";
            

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tnip.getText());
            pst.setString(2,tkodemapel.getText());
            pst.setString(3,tnamamapel.getText());
            pst.setString(4,tnamaguru.getText());
            pst.setString(5,tkodekelas.getText());
            pst.setString(6,thari.getText());
            pst.setString(7,tjam.getText());
            
             pst.setString(8,tnip.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been update");
            DataJadwal();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
     
     
    protected void delete() {
        int choice = JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete ?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (choice == 0) {
            try {
                String query = "delete from tb_jadwal where NIP=" + tnip.getText();
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data has been delete");
            } catch (Exception e) {
            }
            
        }
        DataJadwal();
    }
    
    
    
    
    protected void refresh() {
        int row = tabmode.getRowCount();
        for(int i = 0; i < row; i++) {
            tabmode.removeRow(0);
        }
    }
    
    
    protected void tekantabel() {
        try {
            int row = jtabeljadwal.getSelectedRow();
            tnip.setText((String) jtabeljadwal.getModel().getValueAt(row, 0));
            tkodemapel.setText((String) jtabeljadwal.getModel().getValueAt(row, 1));
            tnamamapel.setText((String) jtabeljadwal.getModel().getValueAt(row, 2));
            tnamaguru.setText((String) jtabeljadwal.getModel().getValueAt(row, 3));
            tkodekelas.setText((String) jtabeljadwal.getModel().getValueAt(row, 4));
            thari.setText((String) jtabeljadwal.getModel().getValueAt(row, 5));
            tjam.setText((String) jtabeljadwal.getModel().getValueAt(row, 6));
            
        } catch (Exception e) {
}
}
    /**
     * Creates new form B_Beranda
     */
    public G_DataJadwal() {
        initComponents();
        DataJadwal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btdatasiswa = new javax.swing.JButton();
        btdatakelas = new javax.swing.JButton();
        btdatamapel = new javax.swing.JButton();
        btdatanilai = new javax.swing.JButton();
        btkembali = new javax.swing.JButton();
        btdataguru = new javax.swing.JButton();
        btkeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tkodemapel = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tnip = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btsimpan = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabeljadwal = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tjam = new javax.swing.JTextField();
        tnamamapel = new javax.swing.JTextField();
        tnamaguru = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        thari = new javax.swing.JTextField();
        tkodekelas = new javax.swing.JTextField();

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
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(103, 242, 209));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));

        jPanel4.setBackground(new java.awt.Color(103, 242, 209));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        btdatasiswa.setBackground(new java.awt.Color(232, 236, 241));
        btdatasiswa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btdatasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_classmates_sittings_skin_type_4_20px.png"))); // NOI18N
        btdatasiswa.setText("Data Murid");
        btdatasiswa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btdatasiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btdatasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdatasiswaActionPerformed(evt);
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo atk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btdatasiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdatakelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdatamapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdatanilai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdataguru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(btdataguru)
                .addGap(18, 18, 18)
                .addComponent(btdatasiswa)
                .addGap(18, 18, 18)
                .addComponent(btdatakelas)
                .addGap(18, 18, 18)
                .addComponent(btdatamapel)
                .addGap(18, 18, 18)
                .addComponent(btdatanilai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
        jLabel4.setText("FORM DATA JADWAL");
        jLabel4.setFocusTraversalPolicyProvider(true);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Kode Mata Pelajaran");

        tkodemapel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tkodemapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkodemapelActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("Nama Mata Pelajaran");

        tnip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnipActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("NIP");

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

        jtabeljadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        jtabeljadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabeljadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabeljadwal);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton11.setText("Cetak");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Nama Guru");

        tjam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjamActionPerformed(evt);
            }
        });

        tnamamapel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnamamapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamamapelActionPerformed(evt);
            }
        });

        tnamaguru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnamaguru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaguruActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Kode Kelas");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText("Hari");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setText("Jam");

        thari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        thari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thariActionPerformed(evt);
            }
        });

        tkodekelas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tkodekelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkodekelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(btsimpan)
                        .addGap(27, 27, 27)
                        .addComponent(btedit)
                        .addGap(25, 25, 25)
                        .addComponent(bthapus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(115, 115, 115)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tnamaguru, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tkodemapel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tnip, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tnamamapel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel19))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tkodekelas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(thari, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tjam, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11)
                        .addGap(8, 8, 8)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(tkodekelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tkodemapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(thari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnamamapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(tjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnamaguru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsimpan)
                    .addComponent(btedit)
                    .addComponent(bthapus))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addContainerGap(24, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 816, 534);

        setSize(new java.awt.Dimension(816, 553));
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

    private void btdataguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdataguruActionPerformed
        new C_DataGuru().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdataguruActionPerformed

    private void tkodemapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkodemapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkodemapelActionPerformed

    private void tnipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnipActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        edit();
    }//GEN-LAST:event_bteditActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        delete();
    }//GEN-LAST:event_bthapusActionPerformed

    private void tjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tjamActionPerformed

    private void tnamamapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamamapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamamapelActionPerformed

    private void tnamaguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaguruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaguruActionPerformed

    private void thariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thariActionPerformed

    private void tkodekelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkodekelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkodekelasActionPerformed

    private void jtabeljadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabeljadwalMouseClicked
        tekantabel();
    }//GEN-LAST:event_jtabeljadwalMouseClicked

    private void btkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkembaliActionPerformed
        new B_Beranda().setVisible(true);
        dispose();
    }//GEN-LAST:event_btkembaliActionPerformed

    private void btkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkeluarActionPerformed
        new A_LoginForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_btkeluarActionPerformed

    private void btdatasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatasiswaActionPerformed
        new D_DataSiswa().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatasiswaActionPerformed

    private void btdatakelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatakelasActionPerformed
        new E_DataKelas().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatakelasActionPerformed

    private void btdatamapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatamapelActionPerformed
        new F_DataMapel().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatamapelActionPerformed

    private void btdatanilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatanilaiActionPerformed
        new H_DataNilai().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatanilaiActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
  try {
         JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("G_DataJadwal.jasper"), null, Koneksi.connect());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(G_DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(G_DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(G_DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(G_DataJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new G_DataJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdataguru;
    private javax.swing.JButton btdatakelas;
    private javax.swing.JButton btdatamapel;
    private javax.swing.JButton btdatanilai;
    private javax.swing.JButton btdatasiswa;
    private javax.swing.JButton btedit;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btkeluar;
    private javax.swing.JButton btkembali;
    private javax.swing.JButton btsimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabeljadwal;
    private javax.swing.JTextField thari;
    private javax.swing.JTextField tjam;
    private javax.swing.JTextField tkodekelas;
    private javax.swing.JTextField tkodemapel;
    private javax.swing.JTextField tnamaguru;
    private javax.swing.JTextField tnamamapel;
    private javax.swing.JTextField tnip;
    // End of variables declaration//GEN-END:variables
}
