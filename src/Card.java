import java.util.Arrays;

public class Card {
    private int[] hand;
    private String highestHand;
    private int bidValue;
    private CardClassifyUtility cardClassifyUtility = null;

    public Card(String[] hand, int bidValue){
        this.bidValue = bidValue;
        TranslationUtility trans = new TranslationUtility();
        this.hand = trans.toNumbers(hand);
        cardClassifyUtility = new CardClassifyUtility(this.hand);
        highestHand = cardClassifyUtility.classify();
    }

    public String getHighestHand() {
        return highestHand;
    }

    public String toString(){
        return "\nHand: " + Arrays.toString(hand) + " Highest Hand: " + highestHand;

    }
    public int[] getHand(){
        return hand;
    }

    public int getBidValue() {
        return bidValue;
    }

    public void makeJackWild() {
        cardClassifyUtility.wildJacks();
        highestHand = cardClassifyUtility.classify();
        for(int i = 0; i < 5; i ++){
            if(hand[i] == 11){
                hand[i] = 1;
            }
        }
    }
}
