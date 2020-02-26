package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            setPlayersAdvantagesAndWhetherEitherWon(player1, player2);
            player1.addPoint();
        } else {
            setPlayersAdvantagesAndWhetherEitherWon(player2, player1);
            player2.addPoint();
        }
    }

    public String getScore() {
        Player temporaryPlayer = getWinnerOrNull();
        if (temporaryPlayer != null) {
            return "Win for " + temporaryPlayer.getName();
        }
        temporaryPlayer = getPlayerWithAdvantageOrNull();
        if (temporaryPlayer != null) {
            return "Advantage " + temporaryPlayer.getName();
        }
        if (reachedDeuce()) {
            return "Deuce";
        }
        if (gameIsTied()) {
            return player1.getPointsAsString() + "-All";
        }
        return player1.getPointsAsString() + "-" + player2.getPointsAsString();
    }

    private boolean gameIsTied() {
        return player1.getPointsAsString().equals(player2.getPointsAsString());
    }

    private boolean reachedDeuce() {
        if (!gameIsTied()) {
            return false;
        }
        return player1.hasMaxScore();
    }

    private Player getWinnerOrNull() {
        if (player1.hasWon()) {
            return player1;
        }
        if (player2.hasWon()) {
            return player2;
        }
        return null;
    }

    private Player getPlayerWithAdvantageOrNull() {
        if (player1.hasAdvantage()) {
            return player1;
        }
        if (player2.hasAdvantage()) {
            return player2;
        }
        return null;
    }

    private void setPlayersAdvantagesAndWhetherEitherWon(Player playerWhoPointed, Player otherPlayer) {
        if (playerWhoPointed.hasMaxScore()) {
            if (playerWhoPointed.hasAdvantage() || !otherPlayer.hasMaxScore()) {
                playerWhoPointed.setToHaveWonTheGame();
            }
            if (otherPlayer.hasAdvantage()) {
                otherPlayer.setToNotHaveAdvantage();
            } else {
                playerWhoPointed.setToHaveAdvantage();
            }
        }
    }

}