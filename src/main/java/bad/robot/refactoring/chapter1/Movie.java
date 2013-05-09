package bad.robot.refactoring.chapter1;

public abstract class Movie implements Rentable {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
