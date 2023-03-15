package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SaveTransaksiRes {
    private Long id;

    private Long idPeminjam;

    private Long idMeminjam;

    private Integer tenor;

    private Double totalPinjaman;

    private Double bungaPersen;

    private String status;

    public static SaveTransaksiRes to(Transaksi transaksi) {
        return new SaveTransaksiRes(transaksi.getId(),transaksi.getPeminjam().getId(), transaksi.getMeminjam().getId(), transaksi.getTenor(), transaksi.getTotalPinjaman(), transaksi.getBungaPersen(), transaksi.getStatus());
    }
}
