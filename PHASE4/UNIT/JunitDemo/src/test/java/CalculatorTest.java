import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    // Req No 1 (Calculator must have the add functionality) test case
    @Test
    void testAdd1(){
        Calculator calc = new Calculator();

        int actualResult = calc.add(2,3);
        int expectedResult = 5;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    void testAdd2(){
        Calculator calc = new Calculator();

        int actualResult = calc.add(-2,-3);
        int expectedResult = -5;

        assertEquals( expectedResult, actualResult);
    }

    // Req No 2 (Calculator must have the divide functionality) test case
    @Test
    void testDivide1(){
        Calculator calc = new Calculator();

        int actualResult = calc.divide(2,3);
        int expectedResult = 0;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    void testDivide2(){
        Calculator calc = new Calculator();

        int actualResult = calc.divide(0,2);
        int expectedResult = 0;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    void testDivide3(){
        Calculator calc = new Calculator();

//        int actualResult = calc.divide(2,0);
//        int expectedResult = 0;
//
//        assertEquals( expectedResult, actualResult);

        assertThrows(ArithmeticException.class, () -> {
            calc.divide(2,0);
        });
    }

}
