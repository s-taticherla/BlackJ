public class Game {
    public static void main(String[] args) {
    Deck deck = new Deck();
    Card ranCard = deck.randCard();
    Player p1 = new Player();
    p1.addCard(ranCard);
    }
}
