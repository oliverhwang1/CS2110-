package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PhdTest {

    @Test
    void testConstructor1() {
        Phd Phd1= new Phd("James", 1977, 2);

        assertEquals("James", Phd1.name());
        assertEquals("2/1977", Phd1.date());
        assertEquals(null, Phd1.advisor1());
        assertEquals(null, Phd1.advisor2());
        assertEquals(0, Phd1.nAdvisees());

    }

    Phd Phd2= new Phd("David", 2010, 6);
    Phd Phd3= new Phd("Gries", 2009, 7);

    @Test
    void testConstructor2() {
        Phd test= new Phd("Brian", 2004, 5, Phd2, Phd3);

        assertEquals("Brian", test.name());
        assertEquals("5/2004", test.date());
        assertEquals(Phd2, test.advisor1());
        assertEquals(Phd3, test.advisor2());
        assertEquals(0, test.nAdvisees());

    }

}
