package bad.robot.refactoring.chapter1.rentables;

/**
 * A rentable item, must have a title.
 */
public interface Rentable {

    public String getTitle();

    public double calculateAmoutStrategy(int daysRented);

    public int calculateFrequentRenterPointsStrategy();

}
