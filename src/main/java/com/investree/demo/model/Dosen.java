package com.investree.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dosen")
public class Dosen {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nama;
}
