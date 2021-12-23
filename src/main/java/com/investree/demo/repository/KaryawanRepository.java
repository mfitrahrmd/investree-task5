package com.investree.demo.repository;


import com.investree.demo.model.Karyawan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<Karyawan, Long> {

    @Query("select c from Karyawan c WHERE c.id = :id")
    public Karyawan getbyID(@Param("id") Long id);

    @Query("select c from Karyawan c WHERE c.nama = :nama")// nama class
    Page<Karyawan> getbyNama(String nama, Pageable pageable);

    @Query("select c from Karyawan c")// nama class
    Page<Karyawan> getAllData(Pageable pageable);

    @Query("select c from Karyawan c WHERE c.nama = :nama and c.nik = :nik ")
    Page<Karyawan> getbyNamaAndNIK(String nama,String nik, Pageable pageable);
}