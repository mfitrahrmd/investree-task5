package com.investree.demo.repository;


import com.investree.demo.model.Barang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface BarangRepo extends PagingAndSortingRepository<Barang, Long> {
    // JPQL ==============================
    @Query("select c from Barang c WHERE c.id = :id")
    public Barang getByID(@Param("id") Long id);

    @Query("select c from Barang c")
    public List<Barang> getList();

    @Query("select c from Barang c WHERE c.nama = :nama")
    Page<Barang> getbyNama(String nama, Pageable pageable);

    Page<Barang> findByNama(String nama, Pageable pageable);

    Page<Barang> findByNamaLike(String nama, Pageable pageable);

}