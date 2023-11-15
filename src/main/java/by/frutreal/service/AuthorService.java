package by.frutreal.service;

import by.frutreal.bean.Author;
import by.frutreal.repositories.AuthorRepository;

import java.util.Scanner;

public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя автора: ");
        String name = in.next();
        System.out.print("Введите фамилию автора: ");
        String surname = in.next();

        Author author = authorRepository.findByNameAndSurname(name, surname);
        if (author == null) {
            author = authorRepository.create(name, surname);
        }

        return author;
    }
}
