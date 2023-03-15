package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SaveTransaksiReq {
    @NotNull
    private Long idPeminjam;

    @NotNull
    private Long idMeminjam;

    @NotNull
    private Integer tenor;

    @NotNull
    private Double totalPinjaman;

    @NotNull
    private Double bungaPersen;

    @NotNull
    private String status;

    public Transaksi toTransaksi() {
        return new Transaksi(null, new User(this.idPeminjam), new User(this.idMeminjam), this.tenor, this.totalPinjaman, this.bungaPersen, this.status, null);
    }
}
