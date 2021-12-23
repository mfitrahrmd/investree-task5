package com.investree.demo.model;

public class GarbaceCollectorClass {
    //Method ini akan ditampilkan jika Garbage Collection bekerja
    public void finalize(){
        System.out.println("Objek Yang Tidak Terpakai Sudah Dibersihkan:");
    }

    public static void main(String[] args){
        Runtime RT = Runtime.getRuntime();
        System.out.println("Jumlah Memori Awal: "+RT.totalMemory());

        GarbaceCollectorClass objek1 = new GarbaceCollectorClass(); //Block Satu
        GarbaceCollectorClass objek2 = new GarbaceCollectorClass(); //Block Dua
        GarbaceCollectorClass objek3 = objek1; //Objek3 Mengembalikan Nilai Objek1
        objek1 = null;
        objek2 = null;
        System.out.println("Jumlah Memori Yeng Tersedia Sebelum di GC: "+RT.freeMemory());
        System.gc();
        System.out.println("===========================================");
        System.out.println("Jumlah Memori Yeng Tersedia Setelah di GC: "+RT.freeMemory());
    }
}

