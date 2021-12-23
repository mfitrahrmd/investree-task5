package com.investree.demo.model.inheritance;
//Class
public class Mobil {
    //Variabel
    public String type;
    public int roda;
    public Double kecepatan;
    //Method VOID
    public  void doMelaju(Double kecepatan){
        System.out.println("Kecepatan Induk : "+kecepatan);
    }

    //Construktor
    public Mobil(){};


    public Mobil(String type, int roda, Double kecepatan) {
        this.type = type;
        this.roda = roda;
        this.kecepatan = kecepatan;
    }



    public void doKlakson(){
        System.out.println("klakson");
    }

    public void doBelok(String arah){
        System.out.println("Belok ke arah "+arah);
    }

    //Return Method
    public double hitungKecepatan(Double kecepatan, int waktuDetik){
        return  kecepatan/waktuDetik;
    }

    //Setter and Getter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoda() {
        return roda;
    }

    public void setRoda(int roda) {
        this.roda = roda;
    }

    public Double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(Double kecepatan) {
        this.kecepatan = kecepatan;
    }
}
