package com.investree.demo.repository;

import com.investree.demo.model.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepo  extends PagingAndSortingRepository<Supplier, Long> {

    @Query("select c from Supplier c")
    public List<Supplier> getList();

    @Query("select c from Supplier c WHERE c.id = :id")
    public Supplier getbyID(@Param("id") Long id);

}
