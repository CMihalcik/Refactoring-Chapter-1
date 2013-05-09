package bad.robot.refactoring.chapter1.rentables;

import bad.robot.refactoring.chapter1.Movie;

public class ChildrensMovie extends Movie {

    public final static double BASE_RATE = 1.5;
    public final static int BASE_RATE_DAYS = 3;
    public final static double EXTRA_DAY_RATE = 1.5;
    public final static int FREQUENT_RENTER_POINTS = 1;

    public ChildrensMovie(String title) {
        super(title);
    }

    public double calculateAmoutStrategy(int daysRented) {

        double amount = BASE_RATE;

        if (daysRented > BASE_RATE)
            amount += (daysRented - BASE_RATE_DAYS) * EXTRA_DAY_RATE;

        return amount;
    }

    public int calculateFrequentRenterPointsStrategy() {
        return FREQUENT_RENTER_POINTS;
    }

}
