/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengawas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class koneksi {
    
    private String databaseName = "dbyayasan";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/"+databaseName;
    public static Connection koneksiDB;
    
    public koneksi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi,username,password);
            System.out.println("Database Terkoneksi");
        } catch (Exception e){
            System.err.println(e.toString());
        }
    }
    
    public void Simpandonatur(String paramKd_Donatur, String paramNama, String paramAlamat, String paramTelpon,
            String paramNominal,String paramStatus,int paramBarang,int paramTransTotal){
        
        try {
            String SQL = "INSERT INTO donatur(Kd_Donatur, Nama, Alamat, Telpon, Nominal, Status, Barang, TransaksiTotal)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramKd_Donatur);
            perintah.setString(2, paramNama);
            perintah.setString(3, paramAlamat);
            perintah.setString(4, paramTelpon);
            perintah.setString(5, paramNominal);
            perintah.setString(6, paramStatus);
            perintah.setInt(7, paramBarang);
            perintah.setInt(8, paramTransTotal);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diSimpan");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Ubahdonatur(String paramKd_Donatur, String paramNama, String paramAlamat, String paramTelpon,
            String paramNominal,String paramStatus,int paramBarang,int paramTransTotal){
        
        try {
            String SQL = "UPDATE donatur SET Nama=?, Alamat=?, Telpon=?, Nominal=?," 
                    + "Status=?, Barang=?, TransaksiTotal=? WHERE Kd_Donatur=?";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramNama);
            perintah.setString(2, paramAlamat);
            perintah.setString(3, paramTelpon);
            perintah.setString(4, paramNominal);
            perintah.setString(5, paramStatus);
            perintah.setInt(6, paramBarang);
            perintah.setInt(7, paramTransTotal);
            perintah.setString(8, paramKd_Donatur);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diUbah");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }  
    
    public void Hapusdonatur(String paramKd_Donatur){
        try{
            String SQL = "DELETE FROM donatur WHERE Kd_Donatur=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramKd_Donatur);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diHapus");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void Caridonatur(String paramKd_Donatur){
       try{
           String SQL = "SELECT * FROM donatur WHERE Kd_Donatur=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1, paramKd_Donatur);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("Kd_Donatur : "+data.getString("Kd_Donatur"));
               System.out.println("Nama : "+data.getString("Nama"));
               System.out.println("Alamat : "+data.getString("Alamat"));
               System.out.println("Telpon : "+data.getString("Telpon"));
               System.out.println("Nominal : "+data.getString("Nominal"));
               System.out.println("Status : "+data.getString("Status"));
               System.out.println("Barang : "+data.getInt("Barang"));
               System.out.println("TransaksiTotal : "+data.getInt("TransaksiTotal"));
           }
       } catch (Exception e){
            System.err.println(e.getMessage());
        }
    } 
    
    public void Datadonatur(){
        try{
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM donatur ORDER BY Kd_Donatur ASC");
            while(baris.next()){
            System.out.println(baris.getString("Kd_Donatur")+" | "+
                                baris.getString("Nama")+" | "+
                                baris.getString("Alamat")+" | "+
                                baris.getString("Telpon")+" | "+
                                baris.getString("Nominal")+" | "+
                                baris.getString("Status")+" | "+
                                baris.getInt("Barang")+" | "+
                                baris.getInt("TransaksiTotal")); 
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
     public void Simpantransdonasi(int paramKd_Transaksi, String paramNominal,String paramStatus,int paramBarang,int paramTransTotal){
        
        try {
            String SQL = "INSERT INTO trans_donasi(Kd_Transaksi, Nominal, Status, Barang, TransaksiTotal)"
                    + "VALUES(?,?,?,?,?)";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramKd_Transaksi);
            perintah.setString(2, paramNominal);
            perintah.setString(3, paramStatus);
            perintah.setInt(4, paramBarang);
            perintah.setInt(5, paramTransTotal);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diSimpan");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Ubahtransdonasi(int paramKd_Transaksi,String paramNominal,String paramStatus,int paramBarang,int paramTransTotal){
        
        try {
            String SQL = "UPDATE trans_donasi SET Nominal=?," 
                    + "Status=?, Barang=?, TransaksiTotal=? WHERE Kd_Transaksi=?";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramNominal);
            perintah.setString(2, paramStatus);
            perintah.setInt(3, paramBarang);
            perintah.setInt(4, paramTransTotal);
            perintah.setInt(5, paramKd_Transaksi);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diUbah");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }  
    
    public void Hapustransdonasi(int paramKd_Transaksi){
        try{
            String SQL = "DELETE FROM trans_donasi WHERE Kd_Transaksi=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramKd_Transaksi);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diHapus");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
     public void Caritransdonasi(int paramKd_Transaksi){
       try{
           String SQL = "SELECT * FROM trans_donasi WHERE Kd_Transaksi=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramKd_Transaksi);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("Kd_Donatur : "+data.getInt("Kd_Transaksi"));
               System.out.println("Nominal : "+data.getString("Nominal"));
               System.out.println("Status : "+data.getString("Status"));
               System.out.println("Barang : "+data.getInt("Barang"));
               System.out.println("TransaksiTotal : "+data.getInt("TransaksiTotal"));
           }
       } catch (Exception e){
            System.err.println(e.getMessage());
        }
    } 
    
    public void Datatransdonasi(){
        try{
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM trans_donasi ORDER BY Kd_Transaksi ASC");
            while(baris.next()){
            System.out.println(baris.getInt("Kd_Transaksi")+" | "+
                                baris.getString("Nominal")+" | "+
                                baris.getString("Status")+" | "+
                                baris.getInt("Barang")+" | "+
                                baris.getInt("TransaksiTotal")); 
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void Simpanbank(int paramId_Bank, String paramNama_Bank, int paramNo_Rekening,String paramNama){
        
        try {
            String SQL = "INSERT INTO bank(Id_Bank, Nama_Bank, No_Rekening, Nama)"
                    + "VALUES(?,?,?,?)";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId_Bank);
            perintah.setString(2, paramNama_Bank);
            perintah.setInt(3, paramNo_Rekening);
            perintah.setString(4, paramNama);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diSimpan");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Ubahbank(int paramId_Bank, String paramNama_Bank, int paramNo_Rekening,String paramNama){
        
        try {
            String SQL = "UPDATE bank SET Nama_Bank=?," 
                    + "No_Rekening=?, Nama=? WHERE Id_Bank=?";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramNama_Bank);
            perintah.setInt(2, paramNo_Rekening);
            perintah.setString(3, paramNama);
            perintah.setInt(4, paramId_Bank);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diUbah");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }  
    
    public void Hapusbank(int paramId_Bank){
        try{
            String SQL = "DELETE FROM bank WHERE Id_Bank=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId_Bank);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diHapus");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void Caribank(int paramId_Bank){
       try{
           String SQL = "SELECT * FROM bank WHERE Id_Bank=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramId_Bank);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("Id_Bank : "+data.getInt("Id_Bank"));
               System.out.println("Nama_Bank : "+data.getString("Nama_Bank"));
               System.out.println("No_rekening : "+data.getInt("No_Rekening"));
               System.out.println("Nama : "+data.getString("Nama"));
           }
       } catch (Exception e){
            System.err.println(e.getMessage());
        }
    } 
    
    public void Databank(){
        try{
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM bank ORDER BY Id_Bank ASC");
            while(baris.next()){
            System.out.println(baris.getInt("Id_Bank")+" | "+
                                baris.getString("Nama_Bank")+" | "+
                                baris.getInt("No_Rekening")+" | "+
                                baris.getString("Nama")); 
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void Simpankonfirmasidonasi(int paramId_Konfirmasi, String paramNama, int paramNo_Rekening,String paramNama_Bank){
        
        try {
            String SQL = "INSERT INTO konfirmasi_donasi(Id_Konfirmasi, Nama, No_Rekening, Nama_Bank)"
                    + "VALUES(?,?,?,?)";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId_Konfirmasi);
            perintah.setString(2, paramNama);
            perintah.setInt(3, paramNo_Rekening);
            perintah.setString(4, paramNama_Bank);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diSimpan");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Ubahkonfirmasidonasi(int paramId_Konfirmasi, String paramNama, int paramNo_Rekening,String paramNama_Bank){
        
        try {
            String SQL = "UPDATE konfirmasi_donasi SET Nama=?," 
                    + "No_Rekening=?, Nama_Bank=? WHERE Id_Konfirmasi=?";
        
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramNama);
            perintah.setInt(2, paramNo_Rekening);
            perintah.setString(3, paramNama_Bank);
            perintah.setInt(4, paramId_Konfirmasi);
            perintah.executeUpdate();
                System.out.println("Data Berhasil diUbah");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }  
    
    public void Hapuskonfirmasidonasi(int paramId_Konfirmasi){
        try{
            String SQL = "DELETE FROM konfirmasi_donasi WHERE Id_Konfirmasi=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId_Konfirmasi);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diHapus");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void Carikonfirmasidonasi(int paramId_Konfirmasi){
       try{
           String SQL = "SELECT * FROM konfirmasi_donasi WHERE Id_Konfirmasi=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramId_Konfirmasi);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("Id_Konfirmasi : "+data.getInt("Id_Konfirmasi"));
               System.out.println("Nama : "+data.getString("Nama"));
               System.out.println("No_rekening : "+data.getInt("No_Rekening"));
               System.out.println("Nama_Bank : "+data.getString("Nama_Bank"));
           }
       } catch (Exception e){
            System.err.println(e.getMessage());
        }
    } 
    
    public void Datakonfirmasidonasi(){
        try{
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM konfirmasi_donasi ORDER BY Id_Konfirmasi ASC");
            while(baris.next()){
            System.out.println(baris.getInt("Id_Konfirmasi")+" | "+
                                baris.getString("Nama")+" | "+
                                baris.getInt("No_Rekening")+" | "+
                                baris.getString("Nama_Bank")); 
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}
