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





    public String classify(String[] hand) {

    }
}
