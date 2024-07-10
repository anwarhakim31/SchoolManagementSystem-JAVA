/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
    private static Connection con;
    public static Connection connect() {
       try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("KONEKSI BERHASIL");
}
       catch (ClassNotFoundException e) {
    System.out.println("KONEKSI GAGAL" +e) ;
}
       String url = "jdbc:mysql://localhost:3306/tk_alfajr";
       try {
    con = DriverManager.getConnection(url, "root", "");
    System.out.println("KONEKSI DATABASE BERHASIL");
} catch (SQLException e) {
    System.out.println("GAGAL KONEKSI DATABASE" +e);
}
return con;
}
}
