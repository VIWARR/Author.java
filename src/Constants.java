import java.time.LocalDate;

public class Constants {
    static LocalDate now = LocalDate.now();

    public static final int MAXYEAR = now.getYear();
    public static final int MINYEAR = 1600;

    public static final int MAXLEN = 300;
    public static final int MINLEN = 2;
}
