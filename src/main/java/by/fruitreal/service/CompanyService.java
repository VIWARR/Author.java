package by.fruitreal.service;

import by.fruitreal.bean.Company;
import by.fruitreal.repositories.CompanyRepository;
import by.fruitreal.repositories.ProductRepository;

import java.util.Scanner;

public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;

    public CompanyService(CompanyRepository companyRepository, ProductRepository productRepository) {
        this.companyRepository = companyRepository;
        this.productRepository = productRepository;
    }

    public Company getCompany() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input organization form: ");
        String organizationForm = in.next();
        System.out.print("Input company name: ");
        String name = in.next();

        Company company = companyRepository.findByOrgFormAndName(organizationForm, name);
        if (company == null) {
            company = companyRepository.create(organizationForm, name);
        }
        return company;
    }

    /*
    Обновляем поле organizationForm класса Company по id, после чего добавляем в таблицу COMPANY_TABLE
     */
    public void updateCompanyOFbyID() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input ID company: ");
        int id = in.nextInt();
        System.out.print("Input company organization form: ");
        String organizationForm = in.next();

        Company company = companyRepository.updateOrganizationFormById(id, organizationForm);
        companyRepository.addCOMPANY_TABLE(company);
    }

    /*
    Обновляем поле name класса Company по id, после чего добавляем в таблицу COMPANY_TABLE
    */
    public void updateCompanyNameById() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input ID company: ");
        int id = in.nextInt();
        System.out.print("Input company name: ");
        String name = in.next();

        Company company = companyRepository.updateNameById(id, name);
        companyRepository.addCOMPANY_TABLE(company);
    }

    /*
    Каскадное удаление Company
     */
    public void deleteCascadeCompany() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input organization form: ");
        String organizationForm = in.next();
        System.out.print("Input name of company: ");
        String name = in.next();

        Company company = companyRepository.deleteByOrgFormAndName(organizationForm, name);
        productRepository.deleteByCompany(company);
    }
}
