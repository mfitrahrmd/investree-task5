package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepo extends JpaRepository<Transaksi, Long> {
    @Query("select c from Transaksi c")
    public List<Transaksi> getList();
}
