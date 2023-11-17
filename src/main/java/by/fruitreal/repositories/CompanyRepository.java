package by.fruitreal.repositories;

import by.fruitreal.bean.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private static List<Company> COMPANY_TABLE = new ArrayList<>();

    public Company create(String organizationForm, String name) {
        Company company = new Company(organizationForm, name);
        COMPANY_TABLE.add(company);
        return company;
    }

    public void addCOMPANY_TABLE(Company company) {
        COMPANY_TABLE.add(company);
    }

    public Company findById(int id) {
        for (Company company: COMPANY_TABLE) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }

    public Company deleteById(int id) {
        Company company = findById(id);
        if (company == null) {
            throw new RuntimeException("The company id: "+id+" was not found");
        }
        COMPANY_TABLE.remove(company);
        return company;
    }

    public Company findByOFAndName(String organizationForm, String name) {
        for (Company company: COMPANY_TABLE) {
            if (company.getOrganizationForm().equals(organizationForm) && company.getName().equals(name)) {
                return company;
            }
        }
        return null;
    }

    public Company updateOrganizationFormById(int id, String organizationForm) {
        Company company = deleteById(id);
        company.setOrganizationForm(organizationForm);
        return company;
    }

    public Company updateNameById(int id, String name) {
        Company company = deleteById(id);
        company.setName(name);
        return company;
    }
}
