package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "pembeli")
public class Pembeli implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @Column(name = "hp",  length = 15)
    private String hp;

    @Column(name = "jk",  length = 15)
    private String jk;

    @Column(name = "alamat", columnDefinition="TEXT")
    private String alamat;

    @OneToOne(mappedBy = "pembeli")
    private PembeliDetail pembelidetail;

    @OneToMany(mappedBy = "pembeli")
    private List<Transaksi> transaksi;


}
