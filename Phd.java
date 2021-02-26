package a1;

/** NetId: ko334, bh572 Time spent: 2 hours, mm minutes. <br>
 * What I thought about this assignment: <br>
 * <br>
 * An instance maintains info about the Phd of a person. */

public class Phd {

    /** Name of the person with a Phd, string length > 0 */
    private String nameOfPerson;

    /** Year Phd was awarded, must be > 1000 */
    private int year;

    /** Month Phd was awarded, In 1..12 with 1 meaning January, etc */
    private int month;

    /** First of the of the Phd candidate, null if unknown */
    private Phd firstAdvisor;

    /** Second advisor of the Phd candidate, null if unknown or only one advisor */
    private Phd secondAdvisor;

    /** Number of Phd advisees of this person */
    private int numberOfAdvisees;

    /** Constructor: an instance for a person with name n, Phd year y, Phd month m. Its advisors are
     * unknown, and it has no advisees. Precondition: n has at least 1 char, y > 1000, and m is in
     * 1..12 */

    public Phd(String n, int y, int m) {
        nameOfPerson= n;
        year= y;
        month= m;
        firstAdvisor= null;
        secondAdvisor= null;
        numberOfAdvisees= 0;

    }

    /** Constructor: a Phd with name n, Phd year y, Phd month m, first advisor a1, and second
     * advisor a2. Precondition: n has at least 1 char, y > 1000, m is in 1..12, a1 and a2 are not
     * null, and a1 and a2 are different. */

    public Phd(String n, int y, int m,
        Phd a1, Phd a2) {

        nameOfPerson= n;
        year= y;
        month= m;
        firstAdvisor= a1;
        secondAdvisor= a2;
        numberOfAdvisees= 0;

    }

    /** the name of this person */
    public String name() {
        assert nameOfPerson != null && nameOfPerson.length() >= 1;
        return nameOfPerson;
    }

    /** the date on which this person got the Phd. In the form "month/year", with no blanks, e.g.
     * "6/2007" */
    public String date() {
        assert year > 1000;
        assert month > 0 && month < 13;

        return month + "/" + year;
    }

    /** the first advisor of this Phd (null if unknown) */
    public Phd advisor1() {
        return firstAdvisor;
    }

    /** the second advisor of this Phd (null if unknown or nonexistent). */
    public Phd advisor2() {
        return secondAdvisor;
    }

    /** the number of Phd advisees of this person. */
    public int nAdvisees() {
        return numberOfAdvisees;
    }

    /** Make p the first advisor of this person. Precondition: the first advisor is unknown and p is
     * not null. */

    public void setAdvisor1(Phd p) {

    }

    /** Make p the second advisor of this person. Precondition: The first advisor (of this person)
     * is known, the second advisor is unknown, p is not null, and p is different from the first
     * advisor. */

    public void setAdvisor2(Phd p) {

    }

    /** "this Phd has no advisees", i.e. true if this Phd has no advisees and false otherwise */

    public boolean hasNoAdvisees() {

        return true;
    }

    /** "p is not null and this person got the Phd before p.” */

    public boolean gotBefore() {

        return true;
    }

    /** "this person and p are intellectual siblings." Precondition: p is not null. */

    public boolean areSibs(Phd p) {

        return true;
    }

}
