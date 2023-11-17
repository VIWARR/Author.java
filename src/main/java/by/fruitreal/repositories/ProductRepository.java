package by.fruitreal.repositories;

import by.fruitreal.bean.*;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static final List<Product> PRODUCT_TABLE = new ArrayList<>();

    public Product create(String name, int price, Company company) {
        Product product = new Product(name, price, company);
        addPRODUCT_TABLE(product);
        return product;
    }

    public void addPRODUCT_TABLE(Product product) {
        PRODUCT_TABLE.add(product);
    }

    public Product findById(int id) {
        for (Product product: PRODUCT_TABLE) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product deleteById(int id) {
        Product product = findById(id);
        if (product == null) {
            throw new RuntimeException("The product id: "+id+" was not found");
        }
        PRODUCT_TABLE.remove(product);
        return product;
    }

    public Product updateNameById(int id, String name) {
        Product product = deleteById(id);
        product.setName(name);
        return product;
    }

    public Product updatePriceById(int id, int price) {
        Product product = deleteById(id);
        product.setPrice(price);
        return product;
    }

    public Product updateCompanyById(int id, Company company) {
        Product product = deleteById(id);
        product.setCompany(company);
        return product;
    }
}
