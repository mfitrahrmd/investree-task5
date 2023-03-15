package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("v1/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @PostMapping
    public ResponseEntity<Map> save(@Valid @RequestBody SaveTransaksiReq transaksi) {
        Transaksi savedTransaksi = (Transaksi) transaksiService.save(transaksi.toTransaksi()).get("transaksi");

        return ResponseEntity.ok().body(Map.of(
                "data", SaveTransaksiRes.to(savedTransaksi),
                "status", "sukses",
                "code", HttpStatus.OK.value()
        ));
    }
}

