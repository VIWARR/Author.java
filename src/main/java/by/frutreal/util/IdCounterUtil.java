package by.frutreal.util;

public class IdCounterUtil {

    private static int COUNTER = 0;

    public static int getId() {
        int current = COUNTER;
        COUNTER++;
        return current;
    }
}
