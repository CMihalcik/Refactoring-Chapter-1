package bad.robot.refactoring.chapter1.statement;

import bad.robot.refactoring.chapter1.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregate values for a statement
 */
public class Statement {

    private List<LineItem> lineItems;
    private Totals statementTotals;

    public Statement(List<Rental> rentals) {
        this.lineItems = calculateStatementLineItems(rentals);
        this.statementTotals = calculateStatementAggregates(lineItems);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public Totals getStatementTotals() {
        return statementTotals;
    }

    /**
     * Calculate rental cost and frequent renter points.
     *
     * Might create a LineItem class to encapsulate this data
     *
     * @return A map of Rentable.title to a List containing the rental cost followed
     * by frequent rental ponts.
     */
    public List<LineItem> calculateStatementLineItems(List<Rental> rentals) {
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
     * Calculate the statementTotals for rental cost and frequent renter points.
     *
     * Again, a StatementSummary class might hold these values.
     *
     * @return a Totals with statementTotals for cost and points
     */
    private Totals calculateStatementAggregates(List<LineItem> lineItems) {

        double cost = 0;
        int points = 0;

        for(LineItem lineItem : lineItems) {
            cost += lineItem.getAmount();
            points += lineItem.getPoints();
            System.out.println("points: " + points);
        }

        return new Totals(cost, points);
    }


}
