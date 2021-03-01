package a1;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PhdTest {
    // Test case for constructor 1
    @Test
    void testConstructor1() {
        Phd feb77= new Phd("James", 1977, 2);

        assertEquals("James", feb77.name());
        assertEquals("2/1977", feb77.date());
        assertEquals(null, feb77.advisor1());
        assertEquals(null, feb77.advisor2());
        assertEquals(0, feb77.nAdvisees());

        Phd jun10= new Phd("", 1810, 6);
        Phd jul09= new Phd("Gries", 800, 7);
        Phd jul09_1= new Phd("Gries", 1809, 27);
        Phd jul09_2= new Phd("Gries", 520, 20);
        Phd jul09_3= new Phd("Gries", 1809, 0);

        assertThrows(AssertionError.class, () -> { jun10.name(); });// test case when n has at least
                                                                    // 1 char

        assertThrows(AssertionError.class, () -> { jul09.date(); }); // test case when year < 1000
        assertThrows(AssertionError.class, () -> { jul09_1.date(); }); // test case when month > 12
        assertThrows(AssertionError.class, () -> { jul09_2.date(); }); // test case when month > 12
                                                                       // and year <1000
        assertThrows(AssertionError.class, () -> { jul09_3.date(); }); // test case when month < 1

    }

    // Test case for constructor 2
    @Test
    void testConstructor2() {
        Phd jun10= new Phd("David", 1810, 6);
        Phd jul09= new Phd("Gries", 1809, 7);
        Phd may04= new Phd("Brian", 1904, 5, jun10, jul09);
        Phd feb77= new Phd("James", 1977, 2, jun10, null);
        Phd aug80= new Phd("Han", 1980, 8, feb77, null);
        Phd jan81= new Phd("Tom", 1981, 1, aug80, may04);
        Phd mar82= new Phd("Jerry", 1982, 3, jan81, aug80);
        Phd mar83= new Phd("Django", 1983, 3, jun10, null);

        assertEquals("Brian", may04.name());
        assertEquals("5/1904", may04.date());
        assertEquals(jun10, may04.advisor1());
        assertEquals(jul09, may04.advisor2());
        assertEquals(0, may04.nAdvisees());

        assertEquals("James", feb77.name());
        assertEquals("2/1977", feb77.date());

        assertEquals("Han", aug80.name());
        assertEquals("8/1980", aug80.date());

        aug80.setAdvisor1(feb77);
        feb77.setAdvisor1(jun10);
        may04.setAdvisor1(jun10);
        jan81.setAdvisor1(aug80);
        jan81.setAdvisor2(may04);
        mar82.setAdvisor1(jan81);
        mar82.setAdvisor2(aug80);
        mar83.setAdvisor1(jun10);

        assertEquals(feb77, aug80.advisor1());
        assertEquals(null, feb77.advisor2());

        assertEquals(1, jan81.nAdvisees());
        assertEquals(1, feb77.nAdvisees());
        assertEquals(2, aug80.nAdvisees());
        assertEquals(3, jun10.nAdvisees());

        assertEquals(true, mar82.areSibs(jan81));

    }

    // Test cases for gotBefore

    @Test

    void test_gotBefore() {

        // Created new Phd object
        Phd feb88= new Phd("Ann", 1988, 2, null, null);
        Phd aug88= new Phd("Jen", 1988, 8, null, null);
        Phd jul98= new Phd("Ben", 1998, 7, null, null);
        Phd sep88= new Phd("Jim", 1988, 9, null, null);
        Phd jul88= new Phd("Kim", 1988, 7, null, null);
        Phd jul87= new Phd("John", 1987, 7, null, null);
        Phd jul87_2= new Phd("John", 1987, 7, null, null);

        // test for the case two people awarded in the same year but different months:
        assertEquals(true, feb88.gotBefore(aug88)); // feb88's month before aug88's
        assertEquals(false, sep88.gotBefore(jul88)); // sep88's month before jul88's
        // test for the case two people awarded in the different years:
        assertEquals(true, jul87.gotBefore(jul88)); // jul87's year before jul88's
        // test for the case two people awarded in the same year and same month:
        assertEquals(false, jul87.gotBefore(jul87_2));
        // test for the case two people awarded in the different year and different month:
        assertEquals(true, jul87.gotBefore(aug88));
        assertEquals(true, jul87.gotBefore(feb88));
        assertEquals(false, aug88.gotBefore(jul87));
        assertEquals(false, feb88.gotBefore(jul87));

        // test for the case two people awarded in the different year and same month:
        assertEquals(true, jul87.gotBefore(jul98));
        assertEquals(false, jul98.gotBefore(jul87));

        // test for the case two people awarded in the different year and different month:
        assertEquals(false, aug88.gotBefore(jul87));
        assertEquals(false, feb88.gotBefore(jul87));

    }

    // Test cases for areSibs

    @Test

    void test_areSibs() {

        Phd may50= new Phd("Brian", 1950, 5, null, null);
        Phd jul98= new Phd("Ben", 1998, 7, null, null);
        Phd sep88= new Phd("Jim", 1988, 9, null, null);
        Phd jul88= new Phd("Kim", 1988, 7, null, null);
        Phd jul87= new Phd("John", 1987, 7, null, null);
        Phd jul87_2= new Phd("John", 1987, 7, null, null);
        Phd jul86= new Phd("Jon", 1987, 7, null, null);

        // neither A nor B has an advisor:
        Phd feb88= new Phd("Ann", 1988, 2, null, null);
        Phd aug88= new Phd("Jen", 1988, 8, null, null);

        assertEquals(false, feb88.areSibs(aug88));

        // A and B are the same object and they have the same non-null first advisor:
        Phd feb88_2= new Phd("Eric", 1988, 2, jul86, null);
        Phd feb88_21= feb88_2;

        assertEquals(false, feb88_21.areSibs(feb88_2));

        // A and B are different objects but they have the same first advisor:

        Phd feb88_3= new Phd("Jam", 1988, 2, feb88, null);
        Phd aug88_3= new Phd("Krim", 1988, 8, feb88, null);

        feb88_3.setAdvisor1(feb88);
        aug88_3.setAdvisor1(feb88);
        assertEquals(true, feb88_3.areSibs(aug88_3));

        // A and B are different objects but they have the same second advisor:
        Phd feb88_4= new Phd("Pin", 1988, 2, may50, feb88);
        Phd aug88_4= new Phd("Hen", 1988, 8, jul86, feb88);

        feb88_4.setAdvisor2(feb88);
        aug88_4.setAdvisor2(feb88);
        assertEquals(true, feb88_4.areSibs(aug88_4));

        // A and B are different objects but the first advisor of one is the second advisor of the
        // other:
        Phd feb88_5= new Phd("Shin", 1988, 2, jul86, null);
        Phd aug88_5= new Phd("Fen", 1988, 8, may50, jul86);

        feb88_5.setAdvisor1(jul86);
        aug88_5.setAdvisor2(jul86);
        assertEquals(true, feb88_5.areSibs(aug88_5));

        // A and B are different objects but they have the different first advisors:

        Phd feb88_6= new Phd("Tim", 1988, 2, feb88, null);
        Phd aug88_6= new Phd("Cam", 1988, 8, jul86, null);

        feb88_6.setAdvisor1(feb88);
        aug88_6.setAdvisor1(jul86);
        assertEquals(false, feb88_6.areSibs(aug88_6));

        // A and B are different objects but they have the different second advisors:

        Phd feb88_7= new Phd("Pin", 1988, 2, jul87, feb88);
        Phd aug88_7= new Phd("Hen", 1988, 8, may50, jul86);
        feb88_7.setAdvisor2(feb88);
        aug88_7.setAdvisor2(jul86);
        assertEquals(false, feb88_7.areSibs(aug88_7));
    }

    // Test case for the date of this person:
    @Test
    public void test_assert_statement() {
        Phd feb88= new Phd(null, 999, 2, null, null);
        Phd feb88_2= new Phd("", 1988, -1, null, null);
        Phd feb88_3= new Phd("", 1988, 14, null, null);
        Phd feb88_4= new Phd("", 500, 15, null, null);

        assertThrows(AssertionError.class, () -> { feb88.date(); });
        assertThrows(AssertionError.class, () -> { feb88_2.date(); });
        assertThrows(AssertionError.class, () -> { feb88_3.date(); });
        assertThrows(AssertionError.class, () -> { feb88_4.date(); });
    }

    // Test case for name of this person:

    @Test
    public void more_assert_tests() {
        Phd feb88= new Phd(null, 1988, 2, null, null);
        Phd feb88_2= new Phd("", 1988, 2, null, null);

        assertThrows(AssertionError.class, () -> { feb88.name(); });
        assertThrows(AssertionError.class, () -> { feb88_2.name(); });
    }

    // Testing the case for setAdvisor2(Phd p):
    @Test
    public void t3() {
        Phd jun10= new Phd("David", 1810, 6);
        Phd jul09= new Phd("Gries", 1809, 7);
        Phd may04= new Phd("Brian", 1904, 5, jun10, jul09);
        Phd may50= new Phd("Brian", 1950, 5, null, may04);
        Phd may04_2= new Phd("Brian", 1904, 5, jun10, jun10);
        Phd may04_3= new Phd("Brian", 1904, 5, jun10, null);

        // test case when the person doesn't have the first advisor but we want to
        // set a second advisor to the person:
        assertThrows(AssertionError.class, () -> { may50.setAdvisor2(may04); });

        // test case when the person's first advisor is the same as the second advisor:
        assertThrows(AssertionError.class, () -> { may04_2.setAdvisor2(jun10); });

        // test case when p is null:
        assertThrows(AssertionError.class, () -> { may04_3.setAdvisor2(null); });

    }

    // Testing the case for setAdvisor1(Phd p):
    @Test
    public void t4() {
        Phd may04= new Phd("Brian", 1904, 5, null, null);

        // test case when p is null:
        assertThrows(AssertionError.class, () -> { may04.setAdvisor1(null); });
    }

}
