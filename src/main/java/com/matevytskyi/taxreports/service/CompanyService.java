package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CompanyService {
    Company create(Company company);

    void deleteById(long id);

    Company update(Company company);

    Optional<Company> getById(long id);

    Page<Company> findAll(Pageable pageable);

    Optional<Company> getByCompanyByName(String companyName);
}
