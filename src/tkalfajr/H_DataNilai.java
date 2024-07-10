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
public class H_DataNilai extends javax.swing.JFrame {
    int xx, xy ;
    Connection conn = new Koneksi().connect();
    
     Object[] row = {"NIS", "Nama Siswa", "Kode Mapel", "Nama Mapel", "Absen", "Grade"};
    DefaultTableModel tabmode = new DefaultTableModel(null, row);
    
    
    protected void DataNilai() {
        refresh();
        jtabelnilai.setModel(tabmode);
        String query = "select * from tb_nilai";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                String a = rs.getString("NIS");
                String b = rs.getString("Nama_Siswa");
                String c = rs.getString("Kode_Mapel");
                String d = rs.getString("Nama_Mapel");
                String e = rs.getString("Absen");
                String f = rs.getString("Grade");
                
                String[] data = {a, b, c, d, e, f};
                tabmode.addRow(data);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
     protected void simpan() {
        String query = "insert into tb_nilai (NIS,Nama_Siswa,Kode_Mapel,Nama_Mapel,Absen,Grade) values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tnis.getText());
            pst.setString(2,tnamasiswa.getText());
            pst.setString(3,tkodemapel.getText());
            pst.setString(4,tnamamapel.getText());
            pst.setString(5,tabsen.getText());
            pst.setString(6,tgrade.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been saved");
            DataNilai();
        } catch (SQLException  e) {
            JOptionPane.showMessageDialog(null, e);
            
        } 
         
    }
     
     
    protected void edit() {
        try {
            String query = "update tb_nilai set NIS=?, Nama_Siswa=?, Kode_Mapel=?," 
                    + " Nama_Mapel=?, Absen=?, Grade=? where NIS=?";
            

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tnis.getText());
            pst.setString(2,tnamasiswa.getText());
            pst.setString(3,tkodemapel.getText());
            pst.setString(4,tnamamapel.getText());
            pst.setString(5,tabsen.getText());
            pst.setString(6,tgrade.getText());
            
             pst.setString(7,tnis.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data has been update");
            DataNilai();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    
    protected void delete() {
        int choice = JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete ?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (choice == 0) {
            try {
                String query = "delete from tb_nilai where NIS=" + tnis.getText();
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data has been delete");
            } catch (Exception e) {
            }
            
        }
        DataNilai();
    }
    
    
    
    
    protected void refresh() {
        int row = tabmode.getRowCount();
        for(int i = 0; i < row; i++) {
            tabmode.removeRow(0);
        }
    }
    
    
    protected void tekantabel() {
        try {
            int row = jtabelnilai.getSelectedRow();
            tnis.setText((String) jtabelnilai.getModel().getValueAt(row, 0));
            tnamasiswa.setText((String) jtabelnilai.getModel().getValueAt(row, 1));
            tkodemapel.setText((String) jtabelnilai.getModel().getValueAt(row, 2));
            tnamamapel.setText((String) jtabelnilai.getModel().getValueAt(row, 3));
            tabsen.setText((String) jtabelnilai.getModel().getValueAt(row, 4));
            tgrade.setText((String) jtabelnilai.getModel().getValueAt(row, 5));
            
        } catch (Exception e) {
}
}

    /**
     * Creates new form B_Beranda
     */
    public H_DataNilai() {
        initComponents();
        DataNilai();
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
        btdatajadwal = new javax.swing.JButton();
        btkembali = new javax.swing.JButton();
        btdataguru = new javax.swing.JButton();
        btkeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tnamasiswa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tnis = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btsimpan = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabelnilai = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tkodemapel = new javax.swing.JTextField();
        tnamamapel = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tabsen = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tgrade = new javax.swing.JTextField();

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btdatasiswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btdatakelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btdatamapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btdatajadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btdataguru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btkeluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(btdataguru)
                .addGap(18, 18, 18)
                .addComponent(btdatasiswa)
                .addGap(18, 18, 18)
                .addComponent(btdatakelas)
                .addGap(18, 18, 18)
                .addComponent(btdatamapel)
                .addGap(18, 18, 18)
                .addComponent(btdatajadwal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btkembali)
                .addGap(18, 18, 18)
                .addComponent(btkeluar)
                .addGap(46, 46, 46))
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
        jLabel4.setText("FORM DATA NILAI");
        jLabel4.setFocusTraversalPolicyProvider(true);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Nama Siswa");

        tnamasiswa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnamasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamasiswaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("No");

        tnis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnisActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("Kode Mapel");

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

        jtabelnilai.setModel(new javax.swing.table.DefaultTableModel(
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
        jtabelnilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelnilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabelnilai);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton11.setText("Cetak");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Nama Mapel");

        tkodemapel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tkodemapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkodemapelActionPerformed(evt);
            }
        });

        tnamamapel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tnamamapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamamapelActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Absen");

        tabsen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tabsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabsenActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setText("Grade");

        tgrade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        tgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgradeActionPerformed(evt);
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
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tnamasiswa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tkodemapel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                                .addComponent(tabsen, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel22)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel5)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tgrade, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                                    .addComponent(tnamamapel))))
                                        .addGap(60, 60, 60))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(131, 131, 131)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(btsimpan)
                        .addGap(32, 32, 32)
                        .addComponent(btedit)
                        .addGap(28, 28, 28)
                        .addComponent(bthapus)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(tabsen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnamasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22)
                    .addComponent(tgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tnamamapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tkodemapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsimpan)
                    .addComponent(btedit)
                    .addComponent(bthapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addContainerGap(41, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 804, 553);

        setSize(new java.awt.Dimension(804, 553));
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

    private void tnamasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamasiswaActionPerformed

    private void tnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnisActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        edit();
    }//GEN-LAST:event_bteditActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        delete();
    }//GEN-LAST:event_bthapusActionPerformed

    private void tnamamapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamamapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamamapelActionPerformed

    private void tabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabsenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabsenActionPerformed

    private void tgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgradeActionPerformed

    private void tkodemapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkodemapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkodemapelActionPerformed

    private void jtabelnilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelnilaiMouseClicked
        tekantabel();
    }//GEN-LAST:event_jtabelnilaiMouseClicked

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

    private void btdatajadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdatajadwalActionPerformed
        new G_DataJadwal().setVisible(true);
        dispose();
    }//GEN-LAST:event_btdatajadwalActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       try {
         JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("H_DataNilai.jasper"), null, Koneksi.connect());
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
            java.util.logging.Logger.getLogger(H_DataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(H_DataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(H_DataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(H_DataNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new H_DataNilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdataguru;
    private javax.swing.JButton btdatajadwal;
    private javax.swing.JButton btdatakelas;
    private javax.swing.JButton btdatamapel;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabelnilai;
    private javax.swing.JTextField tabsen;
    private javax.swing.JTextField tgrade;
    private javax.swing.JTextField tkodemapel;
    private javax.swing.JTextField tnamamapel;
    private javax.swing.JTextField tnamasiswa;
    private javax.swing.JTextField tnis;
    // End of variables declaration//GEN-END:variables
}
