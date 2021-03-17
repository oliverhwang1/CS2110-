package linklist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CListTest {

    @Test
    void testConstructor() {
        CList<Integer> c= new CList<>();
        assertEquals("[]", c.toString());
        assertEquals("[]", c.toStringR());
        assertEquals(0, c.size());
    }

    @Test
    public void testPrependAndToStringR() {
        CList<String> cl= new CList<>();
        cl.prepend("CS2110");
        assertEquals("[CS2110]", cl.toString());
        assertEquals("[CS2110]", cl.toStringR());
        assertEquals(1, cl.size());
        CList<String> c2= new CList<>();
        c2.prepend("CS5780");
        assertEquals("[CS5780]", c2.toString());
        assertEquals("[CS5780]", c2.toStringR());
        assertEquals(1, c2.size());
        CList<String> c3= new CList<>();

        c3.prepend("2");
        c3.prepend("3");
        assertEquals("[3, 2]", c3.toString());
        assertEquals("[2, 3]", c3.toStringR());
        assertEquals(2, c3.size());
        c3.prepend("4");
        assertEquals("[4, 3, 2]", c3.toString());
        assertEquals("[2, 3, 4]", c3.toStringR());
        assertEquals(3, c3.size());
        c3.changeHeadToNext();
        assertEquals("[3, 2, 4]", c3.toString());
        c3.append("8");
        assertEquals("[3, 2, 4, 8]", c3.toString());

        CList<String> c4= new CList<>();
        c4.append("3");
        assertEquals("[3]", c4.toString());
        c4.append("4");
        assertEquals("[3, 4]", c4.toString());
        c4.append("5");
        assertEquals("[3, 4, 5]", c4.toString());
        c4.append("6");
        assertEquals("[3, 4, 5, 6]", c4.toString());
        c4.append("7");
        assertEquals("[3, 4, 5, 6, 7]", c4.toString());
        c4.changeHeadToNext();
        assertEquals("[4, 5, 6, 7, 3]", c4.toString());
        c4.append("10");
        assertEquals("[4, 5, 6, 7, 3, 10]", c4.toString());
    }
}
