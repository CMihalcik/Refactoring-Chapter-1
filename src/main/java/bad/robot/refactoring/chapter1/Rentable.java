package bad.robot.refactoring.chapter1;

/**
 * A rentable item, must have a title and
 */
public interface Rentable {

    public String getTitle();

    public double calculateAmoutStrategy(int daysRented);

    public int calculateFrequentRenterPointsStrategy();

}
