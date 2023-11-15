package by.frutreal.repositories;

import by.frutreal.bean.Author;
import by.frutreal.bean.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static final List<Book> BOOK_TABLE = new ArrayList<>();

    public Book create(String name, Author author, int year) {
        Book book = new Book(name, author, year);
        BOOK_TABLE.add(book);
        return book;
    }

    public Book findById(int id) {
        for (Book book : BOOK_TABLE) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    public void deleteById(int id) {
        Book book = findById(id);
        if (book == null) throw new RuntimeException("Книги с id=" + id + " нет в библиотеке.");
        BOOK_TABLE.remove(book);
    }

    public int count() {
        return BOOK_TABLE.size();
    }

    public List<Book> findAll() {
        return new ArrayList<>(BOOK_TABLE);
    }
}
