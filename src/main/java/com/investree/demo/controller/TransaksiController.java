package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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

    // Request validation handler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationException(MethodArgumentNotValidException e) {
        var errors = new HashMap<String, Object>();

        e.getBindingResult().getAllErrors().forEach(objectError -> {
            var fieldName = ((FieldError) objectError).getField();
            var errorMessage = objectError.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}

