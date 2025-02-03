import java.util.ArrayList;
import java.util.Arrays;

public class CompareUtility {
    private ArrayList<Card> fiveOfAKind = new ArrayList<Card>();
    private ArrayList<Card> fourOfAKind = new ArrayList<Card>();
    private ArrayList<Card> fullHouse = new ArrayList<Card>();
    private ArrayList<Card> threeOfAKind = new ArrayList<Card>();
    private ArrayList<Card> twoPair = new ArrayList<Card>();
    private ArrayList<Card> onePair = new ArrayList<Card>();
    private ArrayList<Card> highestCard = new ArrayList<Card>();
    private Card[] cards;

    public CompareUtility(Card[] cards){
        this.cards = cards;
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
    public Card[] returnSortedList(){
        ArrayList<Card> returnCards = new ArrayList<Card>();
        ArrayList<Card> temp = compareIndividualValue(fiveOfAKind);
        returnCards.addAll(temp);
        temp = compareIndividualValue(fourOfAKind);
        returnCards.addAll(temp);
        temp = compareIndividualValue(fullHouse);
        returnCards.addAll(temp);
        temp = compareIndividualValue(threeOfAKind);
        returnCards.addAll(temp);
        temp = compareIndividualValue(twoPair);
        returnCards.addAll(temp);
        temp = compareIndividualValue(onePair);
        returnCards.addAll(temp);
        temp = compareIndividualValue(highestCard);
        returnCards.addAll(temp);
        Card[] returnArray = new Card[returnCards.size()];
        for(int i = 0; i < returnArray.length; i ++){
            returnArray[i] = returnCards.get(i);
        }
        return returnArray;
    }

    public ArrayList<Card> compareIndividualValue(ArrayList<Card> cards){ // change this
        ArrayList<Card> returnCards = new ArrayList<Card>();
        int[] temp = new int[cards.size()];
        for(int i = 0; i < cards.size() ; i++){
            int sum = 0;
            for(int n = 0; n < (cards.get(i)).getHand().length; n++) {
                sum += (int) ((cards.get(i)).getHand()[n] * Math.pow(14,4 - n));
            }
            temp[i] = sum;
        }
        int[] tempClone = temp.clone();
        Arrays.sort(tempClone);
        ArrayList<Integer> tempCloneTwo = new ArrayList<Integer>();
        for(int i = 0; i < temp.length; i ++){
            tempCloneTwo.add(temp[i]);
        }
        for(int i = cards.size() - 1; i >= 0; i --){
            returnCards.add(cards.get(tempCloneTwo.indexOf(tempClone[i])));
        }
        return returnCards;

    }

    public String toString() {
        return "Number of five of a kind hands: " + fiveOfAKind.size() + "\n" +
                "Number of four of a kind hands: " + fourOfAKind.size() + "\n" +
                "Number of full house hands: " + fullHouse.size() + "\n" +
                "Number of three of a kind hands: " + threeOfAKind.size() + "\n" +
                "Number of two pair hands: " + twoPair.size() + "\n" +
                "Number of one pair hands: " + onePair.size() + "\n" +
                "Number of high card hands: " + highestCard.size() + "\n" +
                "Total Bid Value: NOT SET";
    }
}
