package ohtu;

public class Player {

    private int points;
    private String name;
    private boolean advantage;
    private boolean won;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.advantage = false;
        this.won = false;
    }

    public String getName() {
        return this.name;
    }

    public String getPointsAsString() {
        return ScoringSystem.convertIntPointsToStringScore(this.points);
    }

    public void addPoint() {
        this.points++;
    }

    public boolean hasWon() {
        return this.won;
    }

    public boolean hasAdvantage() {
        return this.advantage;
    }

    public void setToHaveAdvantage() {
        this.advantage = true;
    }

    public void setToNotHaveAdvantage() {
        this.advantage = false;
    }

    public void setToHaveWonTheGame() {
        this.won = true;
    }

    public boolean hasMaxScore() {
        return getPointsAsString().equals(ScoringSystem.getMaxScoreAsString());
    }
}