package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, List<Number>> lineItems = calculateStatementLineItems();
        for (Map.Entry<String, List<Number>> entry : lineItems.entrySet()) {
            result += "\t" + entry.getKey() + "\t" + String.valueOf(entry.getValue().get(0)) + "\n";
        }

        // Calc and display summary
        List<Number> aggegates = calculateStatementAggregates(lineItems);
        result += "Amount owed is " + String.valueOf(aggegates.get(0)) + "\n";
        result += "You earned " + String.valueOf(aggegates.get(1)) + " frequent renter points";

        return result;
    }

    /**
     * Calculate rental cost and frequent renter points.
     *
     * Might create a LineItem class to encapsulate this data
     *
     * @return Returns a map of Rentable.title to a List containing the rental cost followed
     * by frequent rental ponts.
     */
    public Map<String, List<Number>> calculateStatementLineItems() {
        Map<String, List<Number>> lineItems = new HashMap<String, List<Number>>();

        for (Rental rental: rentals) {

            List<Number> costAndPoints = new ArrayList<Number>();
            costAndPoints.add(rental.calculateAmout());
            costAndPoints.add(rental.calculateFrequentRenterPoints());

            lineItems.put(rental.getTitle(), costAndPoints);
        }

        return lineItems;
    }

    /**
     * Calculate the totals for rental cost and frequent renter points.
     *
     * Again, a StatementSummery class might hold these values.
     *
     * @return a duple, total cost followed by total renter points
     */
    public List<Number> calculateStatementAggregates(Map<String, List<Number>> lineItems) {

        ArrayList<Number> aggregates = new ArrayList<Number>();
        double cost = 0;
        int points = 0;

        for(List<Number> values : lineItems.values()) {
            cost += (Double)values.get(0);
            points += (Integer)values.get(1);
        }

        aggregates.add(cost);
        aggregates.add(points);

        return aggregates;
    }


}
