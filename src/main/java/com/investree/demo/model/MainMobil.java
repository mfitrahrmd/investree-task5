package com.investree.demo.model;

public class MainMobil {
    public static Mobil objMobil = new Mobil();
        public static void main(String[] args){
        Mobil  mobilFerari = new Mobil("Sport", 4, 200.0);
        Mobil  mobilJeep = new Mobil("Offroad", 6, 150.0);
        System.out.println("mobilFerari");
        System.out.println("roda :"+mobilFerari.getRoda());
        System.out.println("type :"+mobilFerari.getType());
        System.out.println("kecepatan :"+mobilFerari.getKecepatan());
        System.out.println("mobilJeep");
        System.out.println("roda :"+mobilJeep.getRoda());
        System.out.println("type :"+mobilJeep.getType());
        System.out.println("kecepatan :"+mobilJeep.getKecepatan());

        objMobil.setRoda(4);
        System.out.println("isi method roda :" + objMobil.getRoda());
    }

}