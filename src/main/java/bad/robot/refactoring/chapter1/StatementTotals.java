package bad.robot.refactoring.chapter1;

/**
 * Aggregate values for a statement
 */
public class StatementTotals {

    private double amount;
    private int points;

    public StatementTotals(double amount, int points) {
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
