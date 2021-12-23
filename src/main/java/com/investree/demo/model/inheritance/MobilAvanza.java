package com.investree.demo.model.inheritance;

public class MobilAvanza extends Mobil {
    public  String deskripsi;
    public  String type;

    public MobilAvanza(){};

    public MobilAvanza(String deskripsi, String type) {
        super("type dari induk", 4, 100.0);
        this.deskripsi = deskripsi;
        this.type = type;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String typeMobil(String typeMobil) {
        return typeMobil;
    }

    public static int typeMobil(int jumlahRoda) {
        return jumlahRoda;
    }

    @Override
    public void doMelaju(Double kecepatan) {
        super.doMelaju(kecepatan);
        System.out.println("Kecepatan anak :"+kecepatan);
    }

    public void superVariabel(String type) {
        System.out.println("Type Mobil dari Anak " + type);
        System.out.println("Type Mobil dari induk " + super.type);
    }



        public static void main(String[] args){
            MobilAvanza obj = new MobilAvanza("Deksripsi Mobil Avanza", "Type Avanza");
            System.out.println("Deksripsi :"+obj.getDeskripsi());
            System.out.println("Type :"+obj.getType());
            System.out.println("Kecepatan :"+obj.getKecepatan());
            System.out.println("Rode :"+obj.getRoda());


        }

}
