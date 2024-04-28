package com.springpractice.companies.repositories;

import com.springpractice.companies.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>
{
}
