public class Game {
    private static boolean player_won = false;
    private static boolean computer_won = false;

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card ranCard = deck.randCard();
        Player p1 = new Player();
        Player computer = new Player();
        p1.addCard(ranCard);
        ranCard = deck.randCard();
        p1.addCard(ranCard);
        ranCard = deck.randCard();
        computer.addCard(ranCard);
        ranCard = deck.randCard();
        computer.addCard(ranCard);
        while (player_won == false && computer_won == false) {
            
        }
    }
}
