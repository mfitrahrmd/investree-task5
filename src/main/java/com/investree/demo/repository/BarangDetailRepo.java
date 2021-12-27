package com.investree.demo.repository;
import com.investree.demo.model.BarangDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangDetailRepo extends JpaRepository<BarangDetail, Long> {

}
