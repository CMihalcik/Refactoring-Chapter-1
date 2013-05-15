package bad.robot.refactoring.chapter1.statement;

/**
 * A single line item from a statement.
 *
 * Includes a title, amount and points.
 */
public class LineItem {

    private String title;
    private double amount;
    private int points;

    public LineItem(String title, double amount, int points) {
        this.title = title;
        this.amount = amount;
        this.points = points;
    }

    public double getAmount() {
        return amount;
    }

    public int getPoints() {
        return points;
    }

    public String getTitle() {
        return title;
    }
}
