package bad.robot.refactoring.chapter1;

import bad.robot.refactoring.chapter1.rentables.RegularMovie;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chrismihalcik
 * Date: 5/8/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerTest {

    /**
     * Basic exercise of statement method. Requires creation of Movies, Rentals and Customers
     */
    @Test
    public void testStatement() {

        // Set up domain instances
        //Movie aMovie = new Movie("A Regular Movie", Movie.REGULAR);
        Movie aMovie = new RegularMovie("A Regular Movie");
        Rental aRental = new Rental(aMovie, 2);
        Customer customer = new Customer("A Customer");

        // Wire up additional state
        customer.addRental(aRental);

        // Execute Statement
        String statementResult = customer.statement();

        // log it
        String expecedResult = "Rental record for A Customer\n" +
                "\tA Regular Movie\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        junit.framework.Assert.assertEquals(expecedResult, statementResult);

    }
}
