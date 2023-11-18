package by.fruitreal.bean;

import by.fruitreal.util.IdCounterUtil;

import java.util.Objects;

public class Product {

    private int id;

    private String name;

    private int price;

    private Company company;

    public Product() {
    }

    public Product(String name, int price, Company company) {
        this.id = IdCounterUtil.getId();
        this.name = name;
        this.price = price;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(company, product.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "ID: "+id+ " - " +name + ": $" +price + " | " + company.toString();
    }
}
