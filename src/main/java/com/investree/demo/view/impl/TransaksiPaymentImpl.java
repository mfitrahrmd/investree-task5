package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransaksiPaymentImpl implements TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;

    @Override
    public Map save(Transaksi transaksi) {
        Transaksi t = transaksiRepository.save(transaksi);

        return Map.of(
                "transaksi", t
        );
    }

    @Override
    public Map updateStatus(Transaksi transaksi) {
        return null;
        // TODO : implement me
    }

    public Map list(Integer page, Integer size, String status) {
        return null;
        // TODO : implement me
    }
}
