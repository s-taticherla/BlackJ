public class GameResult {
    private boolean comp_won;

    public GameResult(int compSum, int playerSum) {
        if(compSum > playerSum) {
            comp_won = true;
        }else if(playerSum > compSum) {
            comp_won = false;
        }else if(playerSum == compSum) {
            comp_won = true;
        }
    }

    public boolean getResult() {
        return comp_won;
    }
}
