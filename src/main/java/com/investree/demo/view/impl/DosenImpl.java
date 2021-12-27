package com.investree.demo.view.impl;

import com.investree.demo.model.Dosen;
import com.investree.demo.view.DosenInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DosenImpl implements DosenInterface {
    @Override
    public Dosen insert(Dosen obj) {
        return null;
    }
}
