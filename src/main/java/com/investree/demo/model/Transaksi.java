package com.investree.demo.model;


import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"peminjam", "meminjam", "paymentHistories"})
@Getter
@Setter
@Entity
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_peminjam", nullable = false)
    private User peminjam;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_meminjam", nullable = false)
    private User meminjam;

    @Column(name = "tenor")
    private Integer tenor;

    @Column(name = "total_pinjaman")
    private Double totalPinjaman;

    @Column(name = "bunga_persen")
    private Double bungaPersen;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "transaksi")
    private Set<PaymentHistory> paymentHistories = new LinkedHashSet<>();
}