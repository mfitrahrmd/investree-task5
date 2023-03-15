package com.investree.demo.view;

import com.investree.demo.model.Transaksi;

import java.util.Map;

public interface TransaksiService {
    Map save(Transaksi transaksi);
    Map updateStatus(Transaksi transaksi);
    Map list(Integer page, Integer size, String status);

}
