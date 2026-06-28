import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTestDemo {
    static Calculator calc = null;

    @BeforeAll
    static void myBeforeAll() {
        long millis = Instant.now().toEpochMilli();
        System.out.println( millis + " INSIDE myBeforeAll. This method will run before starting any of the test case  in this class  ");
        calc = new Calculator();
    }

    @AfterAll
    static void myAfterAll() {
        System.out.println(" INSIDE myAfterAll. This method will run after all test cases have been run  ");
    }

    // Req No 1 (Calculator must have the add functionality) test case
    @ParameterizedTest
    @CsvSource(
            {
                    "2,3,5",
                    "-2,-3,-5",
                    "0,11,11"
            }
    )
    void testAdd1(int a, int b, int expectedResult) {
        long millis = Instant.now().toEpochMilli();
        System.out.println(millis + " INSIDE testAdd1");
        int actualResult = calc.add(a, b);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @Disabled
    void testAdd2(int a, int b, int expectedResult) {
        long millis = Instant.now().toEpochMilli();
        System.out.println(millis + " INSIDE testAdd2");
        int actualResult = calc.add(a, b);

        assertEquals(expectedResult, actualResult);
    }

}
