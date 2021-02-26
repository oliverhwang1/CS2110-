import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Group members:
 * ko334 Kingsley Odae
 * bh572 Bingjie Huang
 */
/** Recitation 03: Practice with exceptions. */

/* This problem set contains five problems, outlined below. When you or your
 * group has completed them, submit this file to the CMS for recitation 03.
 *
 * The purpose of this problem set is for you to practice with exception handling.
 * As long as this is a good attempt, with most things right, you get 100%.
 * Please do this with one or two other people if possible. You learn when you
 * discuss with others.
 *
 *    For an in-person recitation, work as best as you can with 1 or 2 other people.
 *    For an online recitation, do try to work with one or two other students, sharing
 *    screens, chatting, communicating whichever way you feel is most suitable for you.
 *
 * If you have a question, ask the TA or the people around you or other students in
 * your zoom meeting.
 *
 * Go ahead! Discuss things with others.
 *
 * Complete and submit before the end of the recitation, if at all possible!
 *
 * Some of these questions are mechanical, asking for a definition or something like that.
 * Some ask you to write code or execute a method call. In that case, it’s best to do it in
 * Eclipse or JShell to check your work. You can look at notes or a book, get on the internet
 * and read the exception-handling webpage, watch the videos, google something, whatever.
 *
 *
 *
 * 1. Describe part of the Throwable Hierarchy (see below).
 * Throwable
 *  Exception
 *      RuntimeException
 *  Error
 *
 *
 * 2. Complete method min, given below. It doesn't throw the IllegalArgumentException
 * it is supposed to throw, according to the specification. Fix that.
 *
 * 3. In Method main, there is a commented-out call on method min.
 * Uncomment it and put the call in a try-statement that catches an IllegalArgumentException;
 * if an IllegalArgumentException is thrown, it should print "Caught an IllegalArgumentException".
 * Naturally, method main should continue to execute after that.
 *
 * 4. Fix procedure printProduct so that if a NumberFormatException is thrown
 * by a call on parseInt, the number 1 is used. There are two such calls, so
 * two try-statements will be needed.
 *
 * 5. Fix procedure printProduct so that if the user types the characters  DONE ,
 * the method terminates (executes a return statement).
 *
 * ================================
 * Here's Question 1.
 * We use indentation to describe subclass hierarchy. For example, this:
 *
 *      Animal
 *         Dog
 *           Collie
 *         Cat
 *
 * indicates that classes Dog and Cat are subclasses of class Animal and
 * class Collie is a subclass of Dog.
 *
 * Below, write part of the hierarchy of Throwable objects.
 * It should include classes Throwable, Error, Exception, and at least two
 * subclasses of Error and two subclasses of Exception. You can do more but
 * you don't have to.
 *
 *
 *Throwable
 *  Exception
 *      RuntimeException
 *  Error
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class E {

    public static void main(String[] args) throws IOException {
        int[] b= { 5, 3, 8, 2, 6 };
        System.out.println(min(b, 1, 3));
        System.out.println(min(b, 1, 1));
        try {
            System.out.println(min(b, 1, 0));
        } catch (IllegalArgumentException exception) {
            System.out.println("Caught an IllegalArgumentException");
        }
        printProduct();
    }

    /** Return the minimum value in c[m..n]. <br>
     * Throw an IllegalArgumentException with message "min of 0 values doesn't exist" <br>
     * if c[m..n] is empty.<br>
     * Precondition: c is not null. */
    public static int min(int[] c, int m, int n) {
        /* Note: array segment c[m..n] is empty if the number of values in it is 0.
         * The number of values in it is  n+1 - m.
         * For example, we write c[m..m+1] for the segment consisting of c[m] and c[m+1],
         * c[m..m] for the segment consisting of one element, c[m], and c[m..m-1] for the
         * empty segment. */

        // Throw an IllegalArgumentException with message "min of 0 values doesn't exist"
        // if c[m..n] is empty. Put your code here:
        if (m > n) { throw new IllegalArgumentException("min of 0 values doesn't exist"); }
        int min= c[m];
        for (int k= m + 1; k <= n; k= k + 1) {
            if (c[k] < min) min= c[k];
        }
        return min;
    }

    /* 4. Fix procedure printProduct so that if a NumberFormatException is thrown
    	 * by a call on parseInt, the number 1 is used. There are two such calls, so
    	 * two try-statements will be needed.
    	 *
    	 * 5. Fix procedure printProduct so that if the user types the characters  DONE ,
    	 * the method terminates (executes a return statement).
    	 */

    /** Do this over and over, until the user types DONE instead of a first integer: <br>
     * Read two integers from the keyboard and print their product. <br>
     * If the reader types anything but an integer, use the integer 1. */
    public static void printProduct() throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter a number: ");
            String s= "";
            // Read a line from the keyboard, trim it, and store the result in s;
            s= reader.readLine().trim();
            if (s.equals("DONE")) { return; }

            int a;
            try {
                a= Integer.parseInt(s);
            } catch (NumberFormatException exception2) {
                a= 1;
            }

            System.out.println("Enter another number: ");

            // Read a line from the keyboard and store it in s;
            s= reader.readLine().trim();

            int b;
            try {
                b= Integer.parseInt(s);
            } catch (NumberFormatException exception3) {
                b= 1;
            }

            System.out.println("Product: " + a * b);
        }
    }

}