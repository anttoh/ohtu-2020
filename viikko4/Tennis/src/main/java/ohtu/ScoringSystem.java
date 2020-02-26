package ohtu;

public class ScoringSystem {

    private final static String[] SCORES = { "Love", "Fifteen", "Thirty", "Forty" };

    public static String getMaxScoreAsString() {
        return SCORES[SCORES.length - 1];
    }

    public static String convertIntPointsToStringScore(int points) {
        if (points > 3) {
            points = 3;
        }
        return SCORES[points];
    }
}