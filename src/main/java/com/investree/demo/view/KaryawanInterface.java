package com.investree.demo.view;


import com.investree.demo.model.Karyawan;

import java.util.Map;

public interface KaryawanInterface {
    public Map insert(Karyawan obj);
    public Map update(Karyawan obj);
    public Map delete(Long obj);
}
