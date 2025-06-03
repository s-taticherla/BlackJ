import java.util.ArrayList;

public class Computer {
    private ArrayList<Card> computer_hand = new ArrayList<>();

    public void add(Card e) {
        computer_hand.add(e);
    }

    public Card access(int i) {
        return computer_hand.get(i);
    }

    public int sum() {
        int sum = 0;
        for(int i = 0; i < computer_hand.size(); i++) {
            sum += computer_hand.get(i).getNum();
        }
        return sum;
    }
}
