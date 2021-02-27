package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PhdTest {

    // Test for assert using assert throws

    @Test
    void testConstructor1() {
        Phd feb77= new Phd("James", 1977, 2);

        assertEquals("James", feb77.name());
        assertEquals("2/1977", feb77.date());
        assertEquals(null, feb77.advisor1());
        assertEquals(null, feb77.advisor2());
        assertEquals(0, feb77.nAdvisees());

    }

    Phd Phd2= new Phd("David", 2010, 6);
    Phd Phd3= new Phd("Gries", 2009, 7);

    @Test
    void testConstructor2() {
        Phd may04= new Phd("Brian", 2004, 5, Phd2, Phd3);

        assertEquals("Brian", may04.name());
        assertEquals("5/2004", may04.date());
        assertEquals(Phd2, may04.advisor1());
        assertEquals(Phd3, may04.advisor2());
        assertEquals(0, may04.nAdvisees());

        Phd feb77= new Phd("James", 1977, 2, null, null);
        Phd aug80= new Phd("Han", 1980, 8, feb77, null);

        assertEquals("James", feb77.name());
        assertEquals("2/1977", feb77.date());

        assertEquals("Han", aug80.name());
        assertEquals("8/1980", aug80.date());

        aug80.setAdvisor1(feb77);
        assertEquals(feb77, aug80.advisor1());
        assertEquals(null, feb77.advisor2());

        assertEquals(1, feb77.nAdvisees());

        Phd jan81= new Phd("Tom", 1981, 1, aug80, may04);
        Phd mar82= new Phd("Jerry", 1982, 3, jan81, null);
        jan81.setAdvisor1(aug80);
        jan81.setAdvisor2(may04);
        mar82.setAdvisor1(jan81);
        assertEquals(true, mar82.areSibs(jan81));

    }

}
