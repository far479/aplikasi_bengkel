package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection mysqlconfig;
    public static Connection configDB() throws SQLException {
        try {
            // Menghubungkan ke database 'aplikasi_bengkel' di XAMPP Anda
            String url = "jdbc:mysql://localhost:3306/aplikasi_bengkel"; 
            String user = "root"; 
            String pass = ""; 
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);            
        } catch (Exception e) {
            System.err.println("Koneksi ke database gagal: " + e.getMessage()); 
        }
        return mysqlconfig;
    }
}