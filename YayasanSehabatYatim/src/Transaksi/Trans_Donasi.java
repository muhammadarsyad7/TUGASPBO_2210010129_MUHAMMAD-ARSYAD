/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

/**
 *
 * @author USER
 */
public class Trans_Donasi {
    
    String Nominal, Status;
    int JumNom,KonStatus,Barang, JumBar;
    
    public Trans_Donasi(){}
    public Trans_Donasi(String Nom){
        this.Nominal = Nom;
    }
    public Trans_Donasi(String Nom, String kondisi){
        this.Nominal = Nom;
        this.Status = kondisi;
    }
    public Trans_Donasi(String Nom,String kondisi, int Bar){
        this.Nominal = Nom;
        this.Status = kondisi;
        this.Barang = Bar;
    }
    
    
    public void inputNominal(String Nom){
        this.Nominal = Nom;
    }
    
    public int AmbilJumNom(){
        this.JumNom = 0;
        if(this.Nominal.equals("I")){
            this.JumNom = 2500000;
        }else if(this.Nominal.equals("II")){
            this.JumNom = 5000000;
        }else if(this.Nominal.equals("III")){
            this.JumNom = 7500000;
        }else{this.JumNom = 8000000;}
        
        return this.JumNom;
    }
    
    public void inputStatus(String kondisi){
        this.Status = kondisi;
    }
    
    public String getStatus(){
        return this.Status;
    }
    
    public int ambilKonStatus(){
        this.KonStatus = 0;
        if(this.Status.equals("Terkirim")){
            this.KonStatus = 500000;
        }else{this.KonStatus = 100000;}
        
        return this.KonStatus;
    }
    
    public void inputBarang(int Bar){
        this.Barang = Bar;
    }
    
    public int ambilJumBar(){
        this.JumBar = 0;
        if(this.Barang==0){
            this.JumBar = 0;
        }else if(this.Barang>=1 && this.Barang<=50){
            this.JumBar = 10000000;
        }else if(this.Barang>=51 && this.Barang<=100){
            this.JumBar = 100000000;
        }else{this.JumBar = 15000000;}
        
        return this.JumBar;
    }
    public int TransaksiTotal(){
        return AmbilJumNom()+ ambilKonStatus()+ ambilJumBar();
    }
}
