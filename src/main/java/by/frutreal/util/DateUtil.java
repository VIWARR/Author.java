package by.frutreal.util;

import java.time.LocalDate;

public final class DateUtil {

    private DateUtil() {
    }

    public static boolean isFutureYear(int year) {
        return LocalDate.now().getYear() < year;
    }
}
