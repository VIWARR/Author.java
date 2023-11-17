package by.fruitreal.bean;

import by.fruitreal.util.IdCounterUtil;

import java.util.Objects;

public class Company {

    private int id;

    private String organizationForm;

    private String name;

    public Company() {
    }

    public Company(String organizationForm, String name) {
        this.id = IdCounterUtil.getId();
        this.organizationForm = organizationForm;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganizationForm() {
        return organizationForm;
    }

    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(organizationForm, company.organizationForm) && Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organizationForm, name);
    }

    @Override
    public String toString() {
        return organizationForm + " " + name;
    }
}
