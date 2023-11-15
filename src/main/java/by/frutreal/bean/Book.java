package by.frutreal.bean;

import by.frutreal.util.BookValidateUtil;
import by.frutreal.util.DateUtil;
import by.frutreal.util.IdCounterUtil;

import java.util.Objects;

public class Book {

    private int id;

    private String name;

    private Author author;

    private int year;

    public Book() {
    }

    public Book(String name, Author author, int year) {
        this.id = IdCounterUtil.getId();
        if (BookValidateUtil.isNameValid(name)) {
            this.name = name;
        } else throw new RuntimeException("Invalid name format");

        this.author = author;

        if (!DateUtil.isFutureYear(year)) {
            this.year = year;
        } else throw new RuntimeException("Invalid year format");
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, year);
    }

    @Override
    public String toString() {
        return "ID " + id + ". " + name + " | " + author.toString() + " | " + year;
    }
}
