import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedTestsDemo {
    Calculator calc = null;

    @BeforeEach
    void myBeforeEach() {
        System.out.println(" INSIDE myBeforeEach. This method will run before each test case in this class  ");
        calc = new Calculator();
    }

    // Req No 1 (Calculator must have the add functionality) test case
    @Test
    void testAdd1(){
        System.out.println(" INSIDE testAdd1");
        int actualResult = calc.add(2,3);
        int expectedResult = 5;

        assertEquals( expectedResult, actualResult);
    }

    
    @RepeatedTest(5)
    void testAdd2(){
        System.out.println(" INSIDE testAdd2");
        int actualResult = calc.add(-2,-3);
        int expectedResult = -5;

        assertEquals( expectedResult, actualResult);
    }

}
