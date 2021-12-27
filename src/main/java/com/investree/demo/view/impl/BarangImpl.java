package com.investree.demo.view.impl;

import com.investree.demo.model.Barang;
import com.investree.demo.model.BarangDetail;
import com.investree.demo.model.Supplier;
import com.investree.demo.repository.BarangDetailRepo;
import com.investree.demo.repository.BarangRepo;
import com.investree.demo.repository.SupplierRepo;
import com.investree.demo.view.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class BarangImpl implements BarangService{

    @Autowired
    public BarangRepo repo;
    @Autowired
    public SupplierRepo repoSupp;
    @Autowired
    public BarangDetailRepo repoDetailBarang;

    @Override
    public Map  getAll() {
        List<Barang> list = new ArrayList<Barang>();
        Map map = new HashMap();
        try {

            list = repo.getList();
            map.put("data", list);
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map findByNama(String nama, Integer page, Integer size) {

        Map map = new HashMap();
        try {
            Pageable show_data = PageRequest.of(page, size);
            Page<Barang> list = repo.findByNama(nama, show_data);

            map.put("data", list);
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;// eror
        }
    }

    @Override
    public Page<Barang> findByNamaLike(String nama, Pageable pageable) {
        return null;
    }



    @Override
    public Map insert(Barang barang , Long idsupplier) {
        Map map = new HashMap();
        try {
            Supplier supp = repoSupp.getbyID(idsupplier);
            barang.setSupplier(supp);
            BarangDetail detailbarang = repoDetailBarang.save(barang.getDetail());
            Barang obj = repo.save(barang);

            detailbarang.setDetailBarang(obj);
            repoDetailBarang.save(detailbarang);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map update(Barang barang, Long idsupplier) {
        Map map = new HashMap();
        try {
            Supplier supp = repoSupp.getbyID(idsupplier);

            Barang obj = repo.getByID(barang.getId());

            if(obj == null ){
                map.put("statusCode", "404");
                map.put("statusMessage", "Data id tidak ditemukan");
                return map;
            }

            obj.setNama(barang.getNama());
            obj.setHarga(barang.getHarga());
            obj.setSatuan(barang.getSatuan());
            obj.setStok(barang.getStok());
            obj.setSupplier(supp);
            repo.save(obj);

            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Update Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map delete(Long idbarang) {
        Map map = new HashMap();
        try {

            Barang obj = repo.getByID(idbarang);
            if(obj == null){
                map.put("statusCode", "404");
                map.put("statusMessage", "data id tidak ditemuakan");
                return map;
            }

            repo.deleteById(obj.getId());
            map.put("statusCode", "200");
            map.put("statusMessage", "Delete Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }
}
