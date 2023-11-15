package by.frutreal.service;

import by.frutreal.repositories.AuthorRepository;
import by.frutreal.repositories.BookRepository;

import java.util.Scanner;

public class MenuService {

    public void launch() {
        int operation = 1;
        BookService bookService = new BookService(new BookRepository(), new AuthorService(new AuthorRepository()));

        while (operation != 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("""
                    Меню:
                    1 - вывод всех книг;
                    2 - добавление книги;
                    3 - удаление книги по id;
                    4 - вывод книги по id;
                    0 - выход; \n
                    """);
            System.out.print("Введите операцию: ");
            operation = in.nextInt();

            switch (operation) {
                case 1:
                    if (!bookService.hasBooks()) {
                        System.out.println("Библиотека пуста.");
                        continue;
                    }
                    bookService.printAll();
                    break;
                case 2:
                    bookService.addBook();
                    break;
                case 3:
                    bookService.deleteBook();
                    break;
                case 4:
                    bookService.printById();
                    break;
            }
        }
    }
}
