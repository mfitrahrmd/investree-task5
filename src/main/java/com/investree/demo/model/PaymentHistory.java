package com.investree.demo.model;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"transaksi"})
@Getter
@Setter
@Entity
@Table(name = "payment_history")
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_transaksi", nullable = false)
    private Transaksi transaksi;

    @Column(name = "pembayaran_ke")
    private Integer pembayaranKe;

    @Column(name = "jumlah")
    private Double jumlah;

    @Column(name = "bukti_pembayaran")
    private String buktiPembayaran;
}