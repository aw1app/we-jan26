import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConditionalTestsDemo {
    Calculator calc = null;

    @BeforeEach
    void myBeforeEach() {
        System.out.println(" INSIDE myBeforeEach. This method will run before each test case in this class  ");
        calc = new Calculator();
    }

    // Req No 1 (Calculator must have the add functionality) test case
    @Test
    @EnabledOnOs({ OS.WINDOWS })
    void testAdd1(){
        System.out.println(" INSIDE testAdd1");
        int actualResult = calc.add(2,3);
        int expectedResult = 5;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    @EnabledOnOs({ OS.LINUX })
    void testAdd2(){
        System.out.println(" INSIDE testAdd2");
        int actualResult = calc.add(-2,-3);
        int expectedResult = -5;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_21)
    void testAdd3(){
        System.out.println(" INSIDE testAdd3 when JRE is min 21");
        int actualResult = calc.add(2,3);
        int expectedResult = 5;

        assertEquals( expectedResult, actualResult);
    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_17)
    void testAdd4(){
        System.out.println(" INSIDE testAdd4 when JRE is max 17");
        int actualResult = calc.add(2,3);
        int expectedResult = 5;

        assertEquals( expectedResult, actualResult);
    }

}
