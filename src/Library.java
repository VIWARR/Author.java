import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> lib = new ArrayList<Book>();

    Library(){};

    public void addBook(Book book) {
        lib.add(book);
    }

    public ArrayList getLib() {
        return lib;
    }

    public Book getBookInd(int index) {
        return lib.get(index);
    }

    public void removeBook(int index) {
        lib.remove(index);
        System.out.println("Book deleted");
    }
}