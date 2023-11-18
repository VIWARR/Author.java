package by.fruitreal.util;

public class IdCounterUtil {

    private static int COUNTER = 0;

    public static int getId() {
        return COUNTER++;
    }
}
