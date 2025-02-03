import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TranslationUtility tu1 = new TranslationUtility();


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
        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }

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
        int totalBid = 0;
        System.out.println(cards.length);
        System.out.println(Arrays.toString(cards));
        for(int i = 0; i < cards.length; i ++){
            totalBid += cards[cards.length - 1 - i].getBidValue() * (i + 1);
        }
        System.out.println(totalBid);

    }
}