package com.springpractice.companies.services;

import com.springpractice.companies.models.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService
{
    List<Company> getAll();

    void create(Company company);

    Optional<Company> getById(long id);

    boolean deleteById(long id);

    boolean update(long companyId, Company company);
}
