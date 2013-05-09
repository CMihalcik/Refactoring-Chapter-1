package bad.robot.refactoring.chapter1;

public class Rental {

    private Rentable rentable;
    private int daysRented;

    public Rental(Rentable movie, int daysRented) {
        this.rentable = movie;
        this.daysRented = daysRented;
    }

    public String getTitle() {
        return rentable.getTitle();
    }

    public double calculateAmout() {
        return rentable.calculateAmoutStrategy(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return rentable.calculateFrequentRenterPointsStrategy();
    }

}
