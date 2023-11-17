package by.fruitreal.util;

import by.fruitreal.bean.Product;

public final class ProductIsNull {

    private ProductIsNull() {
    }

    public static void errorIfProductIsNull(Product product) {
        if (product == null) {
            throw new RuntimeException("The product id\"+id+\"was not found");
        }
    }
}
