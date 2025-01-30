public class CompareUtility {
    public int greater(int[] hand1, int[] hand2){
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
