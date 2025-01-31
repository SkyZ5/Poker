import java.util.ArrayList;
import java.util.Arrays;

public class CompareUtility {
    private ArrayList<Card> fiveOfAKind = new ArrayList<Card>();
    private ArrayList<Card> fourOfAKind = new ArrayList<Card>();
    private ArrayList<Card> fullHouse = new ArrayList<Card>();
    public ArrayList<Card> threeOfAKind = new ArrayList<Card>();
    private ArrayList<Card> twoPair = new ArrayList<Card>();
    private ArrayList<Card> onePair = new ArrayList<Card>();
    private ArrayList<Card> highestCard = new ArrayList<Card>();

    public CompareUtility(Card[] cards){
        for(int i = 0; i < cards.length; i ++){
            if(cards[i].getHighestHand().equals("5KIND")){
                fiveOfAKind.add(cards[i]);
            }
            else if(cards[i].getHighestHand().equals("4KIND")){
                fourOfAKind.add(cards[i]);
            }
            else if(cards[i].getHighestHand().equals("FULLHOUSE")){
                fullHouse.add(cards[i]);
            }
            else if(cards[i].getHighestHand().equals("3KIND")){
                threeOfAKind.add(cards[i]);
            }
            else if(cards[i].getHighestHand().equals("2PAIR")){
                twoPair.add(cards[i]);
            }
            else if(cards[i].getHighestHand().equals("1PAIR")){
                onePair.add(cards[i]);
            }
            else {
                highestCard.add(cards[i]);
            }
        }
    }

    public ArrayList<Card> compareIndividualValue(ArrayList<Card> cards){
        ArrayList<Card> returnCards = new ArrayList<Card>();
        int[] temp = new int[cards.size()];
        for(int i = 0; i < cards.size() ; i++){
            int sum = 0;
            for(int n = 0; n < (cards.get(i)).getHand().length; n++) {
                sum += (int) ((cards.get(i)).getHand()[n] * Math.pow(14,4 - n));
            }
            temp[i] = sum;
        }
        System.out.println(Arrays.toString(temp));
        int[] tempClone = temp.clone();
        Arrays.sort(tempClone);
        System.out.println(Arrays.toString(tempClone));

    }


    private int greater(int[] hand1, int[] hand2){
        for(int i = 0; i < 5; i ++){
            if (hand1[i] > hand2[i]){
                return 1;
            }
            else if(hand1[i] < hand2[i]){
                return 2;
            }
        }
        return 0;
    }
}
