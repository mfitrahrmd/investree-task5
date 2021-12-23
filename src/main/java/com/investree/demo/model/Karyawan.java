package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "karyawan")
public class Karyawan implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama", nullable = true, length = 45)
    private String nama;
    @Column(name = "nik", length = 16)
    private String nik;
    @Column(name = "jabatan", length = 50)
    private String jabatan;
    @Column(name = "hp", length = 16)
    private String hp;
    @Column(name = "alamat", columnDefinition="TEXT")
    private String alamat;
}
