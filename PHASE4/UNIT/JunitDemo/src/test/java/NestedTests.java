import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedTests {

    static Calculator calc = null;

    @BeforeAll
    static void myBeforeAll() {
        System.out.println(" INSIDE myBeforeAll. This method will run before any test case in this class  ");
        calc = new Calculator();
    }

    @AfterAll
    static void myAfterAll() {
        System.out.println(" INSIDE myAfterAll. This method will run after ALL test cases have been run in this class  ");
        calc = null;
    }


    // Req No 1 (Calculator must have the add functionality) test case
    @Nested
    class GroupA {
        @Test
        void testAdd1() {
            System.out.println(" INSIDE testAdd1");
            int actualResult = calc.add(2, 3);
            int expectedResult = 5;

            assertEquals(expectedResult, actualResult);
        }

        @Test
        void testAdd2() {
            System.out.println(" INSIDE testAdd2");
            int actualResult = calc.add(-2, -3);
            int expectedResult = -5;

            assertEquals(expectedResult, actualResult);
        }
    }


    @Nested
    class GroupB {
        @Test
        void testAdd3() {
            System.out.println(" INSIDE testAdd3");
            int actualResult = calc.add(2, 3);
            int expectedResult = 5;

            assertEquals(expectedResult, actualResult);
        }

        @Test
        void testAdd4() {
            System.out.println(" INSIDE testAdd4");
            int actualResult = calc.add(-2, -3);
            int expectedResult = -5;

            assertEquals(expectedResult, actualResult);
        }
    }

    @Test
    void testAdd5() {
        System.out.println(" INSIDE testAdd5");
        int actualResult = calc.add(-2, -3);
        int expectedResult = -5;

        assertEquals(expectedResult, actualResult);
    }

}
