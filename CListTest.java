package linklist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

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
        CList<String> c5= new CList<>();
        for (int i= 2; i < 42; i+= 2) {
            String n= String.valueOf(i);
            c5.append(n);
        }
        assertEquals("[2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40]",
            c5.toString());
        ArrayList<String> number= new ArrayList<>();
        CList<String> c6= new CList<>();
        for (int i= 0; i < c5.size(); i++ ) { number.add(c5.getNode(i).data()); }
        assertEquals("[2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 20, 18, 16, 14, 12, 10, 8, 6, 4]",
            number);
        c4.remove(c4.getNode(1));
        assertEquals("[4, 6, 7, 3, 10]", c4.toString());
        c4.remove(c4.getNode(2));
        assertEquals("[4, 6, 3, 10]", c4.toString());
        c4.remove(c4.getNode(1));
        assertEquals("[4, 3, 10]", c4.toString());

    }
}
