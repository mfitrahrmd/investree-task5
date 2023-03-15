package com.investree.demo.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"userDetails", "transaksiPeminjam", "transaksiMeminjam"})
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetails;

    @OneToMany(mappedBy = "peminjam")
    private Set<Transaksi> transaksiPeminjam = new LinkedHashSet<>();

    @OneToMany(mappedBy = "meminjam")
    private Set<Transaksi> transaksiMeminjam = new LinkedHashSet<>();

    public User(Long id) {
        this.id = id;
    }
}