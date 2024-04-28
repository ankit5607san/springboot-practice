package com.springpractice.companies.controllers;

import com.springpractice.companies.models.Company;
import com.springpractice.companies.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController
{
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll()
    {
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getById(@PathVariable Long companyId)
    {
        Optional<Company> result = companyService.getById(companyId);

        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Company company)
    {
        companyService.create(company);

        return ResponseEntity.ok("created company successfully!@");
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> update(@PathVariable Long companyId, @RequestBody Company company)
    {
        if (companyService.update(companyId, company))
        {
            return ResponseEntity.ok("company [" + companyId + "] updated successfully!@");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> delete(@PathVariable Long companyId)
    {
        if (companyService.deleteById(companyId))
        {
            return ResponseEntity.ok("company [" + companyId + "] deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}
