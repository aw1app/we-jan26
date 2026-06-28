import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest2 {
    Calculator calc = null;

    @BeforeAll
    static void myBeforeAll() {
        System.out.println(" INSIDE myBeforeAll. This method will run before starting any of the test case  in this class  ");
    }

    @AfterAll
    static void myAfterAll() {
        System.out.println(" INSIDE myAfterAll. This method will run after all test cases have been run  ");
    }

    @BeforeEach
    void myBeforeEach() {
        System.out.println(" INSIDE myBeforeEach. This method will run before each test case in this class  ");
        calc = new Calculator();
    }

    @AfterEach
    void myAfterEach() {
        System.out.println(" INSIDE myAfterEach. This method will run after each test case in this class  ");
        calc = null;
    }

    // Req No 1 (Calculator must have the add functionality) test case
    @Test
    void testAdd1(){
        System.out.println(" INSIDE testAdd1");
        int actualResult = calc.add(2,3);
        int expectedResult = 5;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    void testAdd2(){
        System.out.println(" INSIDE testAdd2");
        int actualResult = calc.add(-2,-3);
        int expectedResult = -5;

        assertEquals( expectedResult, actualResult);
    }

    // Req No 2 (Calculator must have the divide functionality) test case
    @Test
    void testDivide1(){
        System.out.println(" INSIDE testDivide1");
        int actualResult = calc.divide(2,3);
        int expectedResult = 0;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    void testDivide2(){
        System.out.println(" INSIDE testDivide2");
        int actualResult = calc.divide(0,2);
        int expectedResult = 0;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    void testDivide3(){
        System.out.println(" INSIDE testDivide3");
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(2,0);
        });
    }

}
