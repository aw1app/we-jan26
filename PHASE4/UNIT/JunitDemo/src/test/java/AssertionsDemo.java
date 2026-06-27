import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    @Test
    void test() {

        String str1 = null;
        String str2 = "some value";

        assertNull(str1);

        assertNotNull(str2);
    }

    @Test
    void test2() {

        String[] a1 = {"A", "B"};
        String[] a2 = {"A", "B"};

        //assertEquals(a1,a2);
        assertArrayEquals(a1, a2);
    }

    @Test
    void test3() {
        int a = 4;
        int b = 0;

//        assertEquals(a, b); // FAIL
        assertNotEquals(a, b);

        assertTrue(a > b);
        assertFalse(b > a);
    }

    @Test
    void test4() {
        Calculator calc = new Calculator();

//        assertThrows(ArithmeticException.class, () -> {
//            calc.add(2, 3);
//        });

        
    }
}
