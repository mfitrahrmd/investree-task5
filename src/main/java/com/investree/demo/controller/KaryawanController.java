package com.investree.demo.controller;

import com.investree.demo.model.Karyawan;
import com.investree.demo.repository.KaryawanRepository;
import com.investree.demo.view.KaryawanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanController {
    @Autowired
    public KaryawanInterface serviceKaryawan;

    @Autowired // 1 apa seharusnya disini
    public KaryawanRepository karyawanRepository;

    @PostMapping("")
    public ResponseEntity<Map> save(@RequestBody Karyawan objModel
    ) {
        Map save = serviceKaryawan.insert(objModel);
        return new ResponseEntity<Map>(save, HttpStatus.OK);// response
    }

    @PutMapping("")// 2 hanya ingin update alamat, apa yang perlu ditambahkan
    public ResponseEntity<Map> update(@RequestBody Karyawan objModel
    ) {
        Map update = serviceKaryawan.update(objModel);
        return new ResponseEntity<Map>(update, HttpStatus.OK);// response
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id
    ) {
        Map update = serviceKaryawan.delete(id);
        return new ResponseEntity<Map>(update, HttpStatus.OK);// response
    }

    @GetMapping("/list")
// 3 jika ingin filter by nama dan NIK, bagian code mana yang perlu ditambahkan ? gunakan JPA  untuk query
    public ResponseEntity<Map> getListData(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) String nik) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Karyawan> list = null;
        if (nama != null && nik != null) {
            karyawanRepository.getbyNamaAndNIK(nama,nik, show_data);
        } else
        if (nama != null) {
            karyawanRepository.getbyNama(nama, show_data);
        } else {
            karyawanRepository.getAllData(show_data);
        }
        Map map = new HashMap();
        map.put("data", list);
        map.put("code", "200");
        map.put("status", "success");
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
    }
}
