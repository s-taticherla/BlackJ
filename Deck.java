import java.util.ArrayList;
import java.util.Random;

public class Deck{
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        String[] symbols =  {"♥", "♦️", "♠", "♣"};
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; i++) {
                deck.add(new Card(symbols[i], number[j]));
            }
        }
    }

    public Card randCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(deck.size());
        Card randomElement = deck.get(randomIndex);
        deck.remove(randomIndex);
        return randomElement;
    }
}
