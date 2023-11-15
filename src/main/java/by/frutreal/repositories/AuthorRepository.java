package by.frutreal.repositories;

import by.frutreal.bean.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private static final List<Author> AUTHOR_TABLE = new ArrayList<>();

    public Author create(String name, String surname) {
        Author author = new Author(name, surname);
        AUTHOR_TABLE.add(author);
        return author;
    }

    public Author findById(int id) {
        for (Author author : AUTHOR_TABLE) {
            if (author.getId() == id) return author;
        }
        return null;
    }

    public void deleteById(int id) {
        Author author = findById(id);
        if (author == null) throw new RuntimeException("Автора с id=" + id + " нет в библиотеке.");
        AUTHOR_TABLE.remove(author);
    }

    public Author findByNameAndSurname(String name, String surname) {
        for (Author author : AUTHOR_TABLE) {
            if (author.getName().equals(name) && author.getSurname().equals(surname)) return author;
        }
        return null;
    }
}
