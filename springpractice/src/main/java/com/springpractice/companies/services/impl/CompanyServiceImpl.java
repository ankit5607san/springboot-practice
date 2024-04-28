package com.springpractice.companies.services.impl;

import com.springpractice.companies.models.Company;
import com.springpractice.companies.repositories.CompanyRepository;
import com.springpractice.companies.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService
{
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll()
    {
        return companyRepository.findAll();
    }

    @Override
    public void create(Company company)
    {
        companyRepository.save(company);
    }

    @Override
    public Optional<Company> getById(long id)
    {
        return companyRepository.findById(id);
    }

    @Override
    public boolean deleteById(long id)
    {
        if (companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);

            return true;
        }

        return false;
    }

    @Override
    public boolean update(long companyId, Company company)
    {
        if (companyRepository.existsById(companyId))
        {
            company.setId(companyId);

            companyRepository.save(company);

            return true;
        }

        return false;
    }
}
