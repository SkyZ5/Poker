import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TranslationUtility tu1 = new TranslationUtility();
        String[] fileArray = getFileData("src/input_file");

        Card[] cards = new Card[fileArray.length];
        for(int i = 0; i < fileArray.length; i ++){
            String input = fileArray[i];
            String[] temp = input.split("\\|");
            String[] card = temp[0].split(",");
            int bidValue = Integer.parseInt(temp[1]);
            cards[i] = new Card(card, bidValue);
        }
        CompareUtility compare = new CompareUtility(cards);
        cards = compare.returnSortedList();
        System.out.println(compare);

        int totalBid = calculateBidValue(cards);
        System.out.println("Total Bid Value: " + totalBid);


        for (int i = 0; i < cards.length; i++) {
            cards[i].makeJackWild();
        }
        compare = new CompareUtility(cards);
        cards = compare.returnSortedList();
        totalBid = calculateBidValue(cards);

        System.out.println("Total Bid Value With Jacks Wild: " + totalBid);

    }

    public static int calculateBidValue(Card[] cards) {
        int totalBid = 0;
        for(int i = 0; i < cards.length; i ++){
            totalBid += cards[cards.length - 1 - i].getBidValue() * (i + 1);
        }
        return totalBid;
    }

    public static String[] getFileData(String fileName) {
        File f = new File("src/input_file");

        String fileData = "";
        String[] fileArray = null;
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                fileData += currentLine + "\n";
            }
            // a String array where every item in the array is a line from the file
            fileArray = fileData.split("\n");
            return fileArray;
        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
        return null;
    }
}