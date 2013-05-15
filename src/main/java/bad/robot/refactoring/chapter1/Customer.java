package bad.robot.refactoring.chapter1;

import java.util.*;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String statement() {

        // Calculate statement
        Statement statement = new Statement(this.getRentals());

        // Display header
        String result = "Rental record for " + getName() + "\n";

        // Display line items
        for (LineItem lineItem : statement.getLineItems()) {
            result += "\t" + lineItem.getTitle() + "\t" + String.valueOf(lineItem.getAmount()) + "\n";
        }

        // Display summary
        result += "Amount owed is " + String.valueOf(statement.getStatementTotals().getAmount()) + "\n";
        result += "You earned " + String.valueOf(statement.getStatementTotals().getPoints()) + " frequent renter points";

        return result;
    }






}
