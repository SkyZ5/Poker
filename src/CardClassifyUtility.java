import java.util.Arrays;

public class CardClassifyUtility {
    // Direction
    // Ace,King,Queen,Jack,10,9,8,7,6,5,4,3,2
    // 14,13,12,11,10,9,8,7,6,5,4,3,2
    // 12,11,10,9,8,7,6,5,4,3,2,1,0
    private int[] labelAmounts;

    public CardClassifyUtility() {
        labelAmounts = new int[13];
        for (int i = 0; i < labelAmounts.length; i++) {
            labelAmounts[i] = 0;
        }
    }





    public void addLabelAmounts(int[] hand) {
        for(int i = 0; i < hand.length; i ++){
            labelAmounts[(hand[i] - 2)]++;
        }
    }

    public String classify(){

        if (Arrays.asList(labelAmounts).contains(5)) {
            return "5KIND";
        }
        else if (Arrays.asList(labelAmounts).contains(4)) {
            return "4KIND";
        }
        else if (Arrays.asList(labelAmounts).contains(3) && Arrays.asList(labelAmounts).contains(2)) {
            return "FULLHOUSE";
        }
        else if (Arrays.asList(labelAmounts).contains(3)) {
            return "3KIND";
        }
        else
    }

}
