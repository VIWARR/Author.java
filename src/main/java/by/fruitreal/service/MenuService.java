package by.fruitreal.service;

import by.fruitreal.repositories.CompanyRepository;
import by.fruitreal.repositories.ProductRepository;

import java.util.Scanner;

public class MenuService {
    public void launch() {
        int operation = 1;
        ProductService productService = new ProductService(new ProductRepository(), new CompanyService(new CompanyRepository(), new ProductRepository()));

        while (operation != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""
                    Menu:
                    1 - output of all products;
                    2 - adding a product;
                    3 - removing a product by ID;
                    4 - product output by ID;
                    5 - removing a company;
                    6 - update price by ID
                    0 - exit; \n 
                    """);
            System.out.print("Input the operation: ");
            operation = in.nextInt();

            switch (operation) {
                case 1:
                    productService.printAll();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    productService.deleteProduct();
                    break;
                case 4:
                    productService.printById();
                    break;
                case 5:
                    productService.deleteCascadeCompany();
                    break;
                case 6:
                    productService.updateProductPriceById();
            }
        }

    }
}
