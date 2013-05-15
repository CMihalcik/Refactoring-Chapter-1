package bad.robot.refactoring.chapter1.statement;

/**
 * Aggregate values for a statement
 */
public class Totals {

    private double amount;
    private int points;

    public Totals(double amount, int points) {
        this.amount = amount;
        this.points = points;
    }

    public double getAmount() {
        return amount;
    }

    public int getPoints() {
        return points;
    }


}
