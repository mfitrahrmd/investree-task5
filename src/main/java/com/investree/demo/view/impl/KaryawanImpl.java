package com.investree.demo.view.impl;

import com.investree.demo.model.Karyawan;
import com.investree.demo.repository.KaryawanRepository;
import com.investree.demo.view.KaryawanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Service
@Component
public class KaryawanImpl implements KaryawanInterface {

    @Autowired
    public KaryawanRepository karyawanRepository;

    @Override
    public Map insert(Karyawan obj) {
        Map map = new HashMap();
        try {
            Karyawan save = karyawanRepository.save(obj);
            map.put("data", save);
            map.put("code", "200");
            map.put("status", "success");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }

    }

    @Override
    public Map update(Karyawan obj) {
        Map map = new HashMap();
        try {
            Karyawan update = karyawanRepository.getbyID(obj.getId());
            update.setAlamat(obj.getAlamat());
            Karyawan doSave = karyawanRepository.save(update);
            map.put("data", doSave);
            map.put("code", "200");
            map.put("status", "success");
        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }
        return null;
    }

    @Override
    public Map delete(Long obj) {
        Map map = new HashMap();
        try {
            Karyawan getData = karyawanRepository.getbyID(obj);
            karyawanRepository.delete(getData);
            map.put("data", "success");
            map.put("code", "200");
            map.put("status", "success");
            return map;
        } catch (Exception e) {
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }

    }
}
