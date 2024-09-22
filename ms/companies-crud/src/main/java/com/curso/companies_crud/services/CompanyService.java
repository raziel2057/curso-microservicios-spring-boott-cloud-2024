package com.curso.companies_crud.services;

import com.curso.companies_crud.entities.Company;

public interface CompanyService {
    Company readByName(String name);
    Company create(Company company);
    Company update(Company company, String name);
    void delete(String name);
}
