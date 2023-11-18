package by.fruitreal.service;

import by.fruitreal.bean.Company;
import by.fruitreal.bean.Product;
import by.fruitreal.repositories.CompanyRepository;
import by.fruitreal.repositories.ProductRepository;

import java.util.Scanner;

public class ProductService {

    private final ProductRepository productRepository;

    private final CompanyService companyService;

    public ProductService(ProductRepository productRepository, CompanyService companyService) {
        this.productRepository = productRepository;
        this.companyService = companyService;
    }

    public void printAll() {
        if (productRepository.hasProduct()) {
            System.out.println("PRODUCT:");
            for (Product product: productRepository.findAll()) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Product list is empty");
    }

    public void addProduct() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the name of the product: ");
        String name = in.next();
        System.out.print("Input the price of the product: ");
        int price = in.nextInt();
        Company company = companyService.getCompany();

        productRepository.create(name, price, company);
    }

    public void deleteProduct() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the ID of delete product: ");
        int id = in.nextInt();
        Product product = productRepository.deleteById(id);
        System.out.println("Product: "+ product.toString()+"was deleted");
    }

    public void printById() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input the ID of the product: ");
        int id = in.nextInt();
        Product product = productRepository.findById(id);

        if (product == null) {
            System.out.println("Product not found");
        } else {
            System.out.println(product.toString());
        }
    }

    public void deleteCascadeCompany() {
        companyService.deleteCascadeCompany();
    }

}
