package com.investree.demo.controller;

import com.investree.demo.model.Dosen;
import com.investree.demo.view.DosenInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/dosen")
public class DosenController {
    @Autowired
    public DosenInterface serviceDosen;

    @PostMapping("")
    public ResponseEntity<Dosen> save(@RequestBody Dosen objModel
    )  {
        Dosen save = serviceDosen.insert(objModel);
        return new ResponseEntity<Dosen>(save, HttpStatus.OK);// response
    }
}
