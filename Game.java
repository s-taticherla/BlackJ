public class Game {
    Deck deck = new Deck();
    Card ranCard = deck.randCard();
    Player p = new Player();
    p.addCard(ranCard);
}
