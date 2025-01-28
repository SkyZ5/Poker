public class TranslationUtility {
    public int[] toNumbers(String[] hand) {
        int[] translatedList = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals("Ace")) {
                translatedList[i] = 14;
            } else if (hand[i].equals("King")) {
                translatedList[i] = 13;
            } else if (hand[i].equals("Queen")) {
                translatedList[i] = 12;
            } else if (hand[i].equals("Jack")) {
                translatedList[i] = 11;
            }
            else {
                translatedList[i] = Integer.parseInt(hand[i]);
            }
        }
        return translatedList;
    }


}
