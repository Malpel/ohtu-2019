package ohtu;

public class TennisGame {
    
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;
    private String playerOne;
    private String playerTwo;
    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void wonPoint(String player) {
        if (player == playerOne) {
            scorePlayerOne += 1;
        } else {
            scorePlayerTwo += 1;
        }
    }

    public String gameIsEven() {
        switch (scorePlayerOne) {
            case 0:
                return "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return  "Forty-All";
            default:
                return "Deuce";
        }
    }
    public String advantageOrWin() {
        int advantage = scorePlayerOne - scorePlayerTwo;
        if (advantage == 1) {
            return "Advantage " + playerOne;
        } else if (advantage == -1) {
            return "Advantage " + playerTwo;
        } else if (advantage >= 2) {
            return "Win for " + playerOne;
        }
        return "Win for " + playerTwo;
    }

    public String getScore() {
        if (scorePlayerOne == scorePlayerTwo) {
            return gameIsEven();
        } else if (scorePlayerOne >= 4 || scorePlayerTwo >= 4) {
            return advantageOrWin();
        }
        return scores[scorePlayerOne] + "-" + scores[scorePlayerTwo] ;
    }
}