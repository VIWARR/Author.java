package by.frutreal.util;

public final class BookValidateUtil {

    public static final int MAX_LEN = 300;
    public static final int MIN_LEN = 2;

    private BookValidateUtil() {
    }

    public static boolean isNameValid(String name) {
        return (MIN_LEN <= name.length() && name.length() <= MAX_LEN);
    }
}
