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

    public String statement() {

        // Display header
        String result = "Rental record for " + getName() + "\n";

        // Calc and display line items
        List<LineItem> lineItems = calculateStatementLineItems();
        for (LineItem lineItem : lineItems) {
            result += "\t" + lineItem.getTitle() + "\t" + String.valueOf(lineItem.getAmount()) + "\n";
        }

        // Calc and display summary
        StatementTotals aggregates = calculateStatementAggregates(lineItems);
        result += "Amount owed is " + String.valueOf(aggregates.getAmount()) + "\n";
        result += "You earned " + String.valueOf(aggregates.getPoints()) + " frequent renter points";

        return result;
    }

    /**
     * Calculate rental cost and frequent renter points.
     *
     * Might create a LineItem class to encapsulate this data
     *
     * @return A map of Rentable.title to a List containing the rental cost followed
     * by frequent rental ponts.
     */
    public List<LineItem> calculateStatementLineItems() {
        List<LineItem> lineItems = new ArrayList<LineItem>();

        for (Rental rental: rentals) {
            LineItem lineItem = new LineItem(rental.getTitle(),
                                             rental.calculateAmout(),
                                             rental.calculateFrequentRenterPoints());
            lineItems.add(lineItem);
        }

        return lineItems;
    }

    /**
     * Calculate the totals for rental cost and frequent renter points.
     *
     * Again, a StatementSummary class might hold these values.
     *
     * @return a StatementTotals with totals for cost and points
     */
    public StatementTotals calculateStatementAggregates(List<LineItem> lineItems) {

        double cost = 0;
        int points = 0;

        for(LineItem lineItem : lineItems) {
            cost += lineItem.getAmount();
            points += lineItem.getPoints();
            System.out.println("points: " + points);
        }

        return new StatementTotals(cost, points);
    }


}
