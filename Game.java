public class Game {
    private static boolean player_won = false;
    private static boolean computer_won = false;

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card ranCard = null;
        Player player = new Player(deck);
        Player computer = new Player(deck);
        while (player_won == false && computer_won == false) {
            if(player.getMove() == true) {
                ranCard = deck.randCard();
                player.addCard(ranCard);
            }
            if(computer.autoGetMove(computer.getSum(), player.getSum())) {
                ranCard = deck.randCard();
                computer.addCard(ranCard);
            }

        }
    }
}
