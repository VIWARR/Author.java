package by.frutreal.bean;

import by.frutreal.util.IdCounterUtil;

import java.util.Objects;

public class Author {

    private int id;

    private String name;

    private String surname;

    public Author() {
    }

    public Author(String name, String surname) {
        this.id = IdCounterUtil.getId();
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name) && Objects.equals(surname, author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
