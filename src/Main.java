import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int operation = 1;

        while (operation != 0) {
            Library lib = new Library();

            Scanner in = new Scanner(System.in);
            System.out.print("Введите операцию: ");
            operation = in.nextInt();
            System.out.println();

            switch (operation) {
                case 1:
                    if (!lib.getLib().isEmpty()){
                        for (int i = 0; i < lib.getLib().size(); ++i){
                            System.out.println(lib.getBookInd(i).getBook());
                        }
                    } else System.out.println("Lib isEmpty");
                    break;
                case 2:
                    System.out.print("Введите имя автора: ");
                    String name = in.next();

                    System.out.print("Введите фамилию автора: ");
                    String surname = in.next();

                    Author a1 = new Author();
                    a1.setAuthor(name, surname);

                    System.out.print("Введите название книги: ");
                    String nameBook = in.next();
                    System.out.print("Введите год: ");
                    int yearBook = in.nextInt();

                    Book b1 = new Book();
                    b1.setBook(nameBook, a1, yearBook);

                    lib.addBook(b1);
            }

        }
    }
}