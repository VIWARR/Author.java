public class Author {
    private int id;
    private String name;
    private String surname;

    Author() {};

    public void setAuthor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getAuthor() {
        String fullAuthor = name + " " + surname;
        return fullAuthor;
    }
}
