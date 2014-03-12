import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Test
public class DigitTest {
    public void zero(){
        String zero = " _ " +
                      "| |" +
                      "|_|";

        assertThat(Digit.digitFor(zero), is(Digit.ZERO));
        assertThat(Digit.digitFor(zero).get(), is(0));
    }

    public void one(){
        String one = "   " +
                     "  |" +
                     "  |";

        assertThat(Digit.digitFor(one), is(Digit.ONE));
        assertThat(Digit.digitFor(one).get(), is(1));
    }

    public void two(){
        String one = " __" +
                     " _|" +
                     " |_";

        assertThat(Digit.digitFor(one), is(Digit.TWO));
        assertThat(Digit.digitFor(one).get(), is(2));
    }

    public void three(){
        String three =  " _ " +
                        " _|" +
                        " _|";

        assertThat(Digit.digitFor(three), is(Digit.THREE));
        assertThat(Digit.digitFor(three).get(), is(3));
    }

    public void readerTest() {
        String line1 = " __    _ ";
        String line2 = " _|  | _|";
        String line3 = " |_  | _|";

        Digit digits[] = new Digit[9];

        for (int i = 0; i < 3; i++) {
            digits[i] = Digit.digitFor(
                    line1.substring(i * 3, (i * 3) + 3) +
                            line2.substring(i * 3, (i * 3) + 3) +
                            line3.substring(i * 3, (i * 3) + 3)
            );
        }

        System.out.println(digits[0] == Digit.TWO);
        System.out.println(digits[1] == Digit.ONE);
        System.out.println(digits[2] == Digit.THREE);
    }
}
