package by.fruitreal.service;

import by.fruitreal.bean.Company;
import by.fruitreal.repositories.CompanyRepository;

import java.util.Scanner;

public class CompanyService {

    private final CompanyRepository companyRepository;

    Scanner in = new Scanner(System.in);

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompany() {
        System.out.print("Input organization form: ");
        String organizationForm = in.next();
        System.out.print("Input company name: ");
        String name = in.next();

        Company company = companyRepository.findByOFAndName(organizationForm, name);
        if (company == null) {
            companyRepository.create(organizationForm, name);
        }
        return company;
    }

    /*
    Обновляем поле organizationForm по id, после чего добавляем в таблицу COMPANY_TABLE
     */
    public void updateCompanyOFbyID() {
        System.out.print("Input ID company: ");
        int id = in.nextInt();
        System.out.print("Input company organization form: ");
        String organizationForm = in.next();

        Company company = companyRepository.updateOrganizationFormById(id, organizationForm);
        companyRepository.addCOMPANY_TABLE(company);
    }

    /*
    Обновляем поле name по id, после чего добавляем в таблицу COMPANY_TABLE
    */
    public void updateCompanyNameById() {
        System.out.print("Input ID company: ");
        int id = in.nextInt();
        System.out.print("Input company name: ");
        String name = in.next();

        Company company = companyRepository.updateNameById(id, name);
        companyRepository.addCOMPANY_TABLE(company);
    }
}
