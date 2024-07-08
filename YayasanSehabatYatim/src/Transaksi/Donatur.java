/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Donatur extends Trans_Donasi{
    
    String Kd_Donatur, Nama, Alamat, Telpon;
    
    ArrayList<String> KdDonaturs;
    ArrayList<String> Namas;
    ArrayList<String> Alamats;
    ArrayList<String> Telpons;
    
    public Donatur(){
        
        KdDonaturs = new ArrayList<>();
        Namas = new ArrayList<>();
        Alamats = new ArrayList<>();
        Telpons = new ArrayList<>();
    
    }
    
    public Donatur(String kode_D, String nama, String alamat, String telp){
        this.Kd_Donatur = kode_D;
        this.Nama = nama;
        this.Alamat = alamat;
        this.Telpon = telp;
    }
    
    public void isiKODEDONATUR(String kode){
        KdDonaturs.add(kode);
    }
    
    public ArrayList<String> getKodeDonaur(){
        return this.Namas;
    }
    
    public void inputKodeDonatur(String kode){
        this.Kd_Donatur = kode;
    }
    
    public String ambilKodeDonatur(){
        return this.Kd_Donatur;
    }
    
    public void isiNAMA(String Nama){
        Namas.add(Nama);
    }
    
    public ArrayList<String> getnamas(){
        return this.Namas;
    }
    
    public void inputName(String nama){
        this.Nama = nama;
    }
    
    public String ambilName(){
        return this.Nama;
    }
    
    public void isiALAMAT(String Alamat){
        Alamats.add(Alamat);
    }
    
    public ArrayList<String> getalamat(){
        return this.Alamats;
    }
    
    public void inputAlamat(String alamat){
        this.Alamat = alamat;
    }
    
    public String ambilAlamat(){
        return this.Alamat;
    }
    
    public void isiTELPON(String Telpon){
        Telpons.add(Telpon);
    }
    
    public ArrayList<String> gettelpon(){
        return this.Telpons;
    }
    
    public void inputTelp(String telp){
        this.Telpon = telp;
    }
    
    public String ambilTelp(){
        return this.Telpon;
    }
    
}
