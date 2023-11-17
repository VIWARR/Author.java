package by.fruitreal.service;

import by.fruitreal.repositories.CompanyRepository;

public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
