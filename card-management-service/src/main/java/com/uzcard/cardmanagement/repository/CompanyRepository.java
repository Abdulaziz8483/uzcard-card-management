package com.uzcard.cardmanagement.repository;

import com.uzcard.cardmanagement.entity.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompanyEntity, String> {

    Page<CompanyEntity> findAll(Pageable pageable);

}
