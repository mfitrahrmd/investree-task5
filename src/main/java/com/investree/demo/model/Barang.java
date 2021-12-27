package com.investree.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "barang")
@Where(clause = "deleted_date is null")
public class Barang extends AbstractDate implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @Column(name = "stok", nullable = false, length = 11)
    private int stok;

    @Column(name = "satuan", nullable = false, length = 45)
    private String satuan;

    @Column(name = "harga",length = 11)
    private int harga;

    @JsonIgnore
    @ManyToOne(targetEntity = Supplier.class, cascade = CascadeType.ALL)
    private Supplier supplier;

    @OneToMany(mappedBy = "barang")
    private List<Transaksi> transaksi;

    @OneToOne(mappedBy = "detailBarang")
    private BarangDetail detail;


}

