package by.frutreal.service;

import by.frutreal.bean.Author;
import by.frutreal.bean.Book;
import by.frutreal.repositories.BookRepository;

import java.util.Scanner;

public class BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public void printAll() {
        for (Book book : bookRepository.findAll()) {
            System.out.println(book.toString());
        }
    }

    public boolean hasBooks() {
        return bookRepository.count() > 0;
    }

    public void addBook() {
        Scanner in = new Scanner(System.in);
        Author author = authorService.getAuthor();

        System.out.print("Введите название книги: ");
        String nameBook = in.next();
        System.out.print("Введите год: ");
        int yearBook = in.nextInt();
        bookRepository.create(nameBook, author, yearBook);
    }

    public void deleteBook() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите id удаляемого элемента: ");
        int idRemove = in.nextInt();
        try {
            bookRepository.deleteById(idRemove);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printById() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите id выводимого элемента: ");
        int id = in.nextInt();
        Book book = bookRepository.findById(id);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Книга с id " + id + " не найдена.");
        }
    }
}
