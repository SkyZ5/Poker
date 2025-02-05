import java.util.*;

public class CardClassifyUtility {
    // Direction
    // Ace,King,Queen,Jack,10,9,8,7,6,5,4,3,2
    // 14,13,12,11,10,9,8,7,6,5,4,3,2
    // 12,11,10,9,8,7,6,5,4,3,2,1,0
    private int[] labelAmounts; // example: [0, 1, 3, 1, 0, 0, 0...]
    private int[] hand;
    private String type;

    public CardClassifyUtility(int[] hand) {
        this.hand = hand;
        labelAmounts = new int[13];
        for (int i = 0; i < labelAmounts.length; i++) {
            labelAmounts[i] = 0;
        }
        addLabelAmounts();
    }
    private void addLabelAmounts() {
        for(int i = 0; i < hand.length; i++){
            labelAmounts[(hand[i] - 2)] = labelAmounts[(hand[i] - 2)] + 1;
        }
    }
    public String classify(){
        ArrayList<Integer> labelsCopy = new ArrayList<>();
        for (int i = 0; i < labelAmounts.length; i ++) {
            labelsCopy.add(labelAmounts[i]);
        }
        if (labelsCopy.contains(5)) {
            type =  "5KIND";
        }
        else if (labelsCopy.contains(4)) {
            type =  "4KIND";
        }
        else if (labelsCopy.contains(3) && labelsCopy.contains(2)) {
            type =  "FULLHOUSE";
        }
        else if (labelsCopy.contains(3)) {
            type =  "3KIND";
        }
        else if (Collections.frequency(labelsCopy, 2) == 2) { // if 2 appears 2
            type =  "2PAIR";
        }
        else if (labelsCopy.contains(2))
            type =  "1PAIR";
        else {
            type =  "HIGHCARD";
        }
        return type;
    }
    public int getMostFrequent() {
        int largest = 0;
        for (int i = 0; i < labelAmounts.length; i++) {
            if (labelAmounts[i] > largest && i != 9) {
                largest = labelAmounts[i];
            }
        }
        return largest;
    }
    public void wildJacks() {
        boolean cardChanged = false;
        for (int i = labelAmounts.length - 1; i >= 0; i--) {
            if (i != 9 && labelAmounts[i] == getMostFrequent() && !cardChanged) {
                labelAmounts[i] += labelAmounts[9]; // + number of jacks
                labelAmounts[9] = 0;
                cardChanged = true;
            }
        }
    }
}
