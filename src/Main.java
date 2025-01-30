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
            System.out.println(Arrays.toString(fileArray));
        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }


        for(int i = 0; i < fileArray.length; i ++){
            String input = fileArray[i];
            String[] temp = input.split("\\|");
            String[] cardsUnconverted = temp[0].split(",");
            int[] cardsConverted = tu1.toNumbers(cardsUnconverted);
            int bidValue = Integer.parseInt(temp[1]);

            CardClassifyUtility classify = new CardClassifyUtility(cardsConverted);
            System.out.println(classify.classify());



        }
    }
}