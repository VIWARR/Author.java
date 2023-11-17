package by.fruitreal.repositories;

import by.fruitreal.bean.*;
import by.fruitreal.util.ProductIsNull;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static final List<Product> PRODUCT_TABLE = new ArrayList<>();

    public Product create(String name, int price, Company company) {
        Product product = new Product(name, price, company);
        PRODUCT_TABLE.add(product);
        return product;
    }

    public Product findById(int id) {
        for (Product product: PRODUCT_TABLE) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        Product product = findById(id);
        ProductIsNull.errorIfProductIsNull(product);
        PRODUCT_TABLE.remove(product);
    }

    public void updateById(int id, String name, int price, Company company) {
        Product product = findById(id);
        deleteById(id);
        product.setName(name);
        product.setPrice(price);
        product.setCompany(company);
        PRODUCT_TABLE.add(product);
    }
}
