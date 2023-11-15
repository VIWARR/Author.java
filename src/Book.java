public class Book {
    private String name;
    private Author author;
    private int year;

    public Book() {};

    private boolean isCorrect(int num) {
        return (Constants.MINYEAR <= num && num <= Constants.MAXYEAR);
    }
    private boolean isCorrect(String str) {
        return (Constants.MINLEN <= str.length() && str.length() <= Constants.MAXLEN);
    }

    public void setBook(String name, Author author, int year) {
        if (isCorrect(name)) {
            this.name = name;
        } else throw new RuntimeException("Invalid name format");

        this.author = author;

        if (isCorrect(year)) {
            this.year = year;
        } else throw new RuntimeException("Invalid year format");
    }

    public String getBook() {
        String str = name + " | " + author.getAuthor() + " | " + year;
        return str;
    }
}
