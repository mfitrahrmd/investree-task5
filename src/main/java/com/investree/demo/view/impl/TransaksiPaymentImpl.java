package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class TransaksiPaymentImpl implements TransaksiService {
    private final String STATUS_LUNAS = "lunas";
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
        Integer rowAffected = transaksiRepository.updateStatusById(STATUS_LUNAS, transaksi.getId());

        Optional<Transaksi> t = transaksiRepository.findById(transaksi.getId());

        return Map.of(
                "transaksi", t.get()
        );
    }

    public Map list(Integer page, Integer size, String status) {
        Pageable pageable = size == null || size < 1 ? null : Pageable.ofSize(size).withPage(page == null ? 0 : page); // check size for each page, list all data if it less than 1
        status = status == null ? "" : status;

        Page<Transaksi> transaksiPage = transaksiRepository.findAllByStatusContainsWithPagination(status, pageable);

        return Map.of(
                "transaksiPage", transaksiPage
        );
    }
}
