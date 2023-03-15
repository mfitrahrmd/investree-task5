package com.investree.demo.repository;

import com.investree.demo.model.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    @Transactional
    @Modifying
    @Query("update Transaksi t set t.status = :status where t.id = :id")
    int updateStatusById(@Param("status") String status, @Param("id") Long id);


    @Query("select t from Transaksi t where t.status like concat('%', :status, '%')")
    Page<Transaksi> findAllByStatusContainsWithPagination(@Param("status") String status, Pageable pageable);

}