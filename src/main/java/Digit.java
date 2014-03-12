import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public enum Digit {
    ZERO(   " _ " +
            "| |" +
            "|_|", 0),

    ONE(    "   " +
            "  |" +
            "  |", 1),

    TWO(    " __" +
            " _|" +
            " |_", 2),

    THREE(  " _ " +
            " _|" +
            " _|", 3),

    FOUR(   "   " +
            "|_|" +
            "  |", 4),

    FIVE(   " __" +
            " |_" +
            " _|", 5),

    SIX(    " __" +
            " |_" +
            " |_|", 6),

    SEVEN(  "__" +
            "  |" +
            "  |", 7),

    EIGHT(  " _ " +
            "|_|" +
            "|_|", 8),

    NINE(   " _ " +
            "|_|" +
            " _|", 9);

    private String aDigit;
    private int digit;

    private Digit(String digit, int aByte) {
        this.aDigit = digit;
        this.digit = aByte;
    }

    public int get() {
        return this.digit;
    }

    public static Digit digitFor(final String digit) {
        return Iterables.find(Lists.newArrayList(values()), new Predicate<Digit>() {
            @Override
            public boolean apply(Digit aDigit) {
                return aDigit.aDigit.equals(digit);
            }
        });
    }
}