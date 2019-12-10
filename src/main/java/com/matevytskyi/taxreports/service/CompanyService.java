package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Company;

import java.util.Optional;

public interface CompanyService extends CrudService<Company> {

    Optional<Company> getByCompanyByName(String companyName);
}
