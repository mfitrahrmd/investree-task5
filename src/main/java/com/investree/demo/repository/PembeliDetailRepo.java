package com.investree.demo.repository;
import com.investree.demo.model.PembeliDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PembeliDetailRepo extends PagingAndSortingRepository<PembeliDetail, Long> {

}
