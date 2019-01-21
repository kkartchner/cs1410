import java.util.Scanner;

/**
 * Prompts the user for the number of lines and then generates and prints a pyramid of numbers with the number of lines
 * entered.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Pyramid1 {
    /**
     *  @param args Command line arguments for the program
     */
    public static void main(String args[]){
        System.out.print("Enter the number of lines: ");            // Prompt user for input
        Scanner input = new Scanner(System.in);

        long lineCount = input.nextLong();                              // Store value received
        long leftMargin = calculateBottomLineLength(lineCount);         // Set starting left margin

        String output = "1";
        System.out.printf("%" + leftMargin + "s" + "%s\n", " ", output);

        for (long i = 2; i <= lineCount; i++) {        // Do for lines 2 through lineCount:
            String number = "" + i;
            output = number + " " + output + " " + number;        // Set output (i.e. 2 1 2)

            leftMargin -= (number.length() + 1);       // Move margin to left by length of current number amount plus 1

            System.out.printf("%" + leftMargin + "s" + "%s\n", " ", output);  // Print output with leftMargin before it
        }
    }

    /**
     * Used for determining the total number of characters that the base of the pyramid has.
     *  @param lastNumber The lastNumber that the program prints.
     */
    public static long calculateBottomLineLength(long lastNumber){
        String bottomLine = "";
        while (lastNumber > 0) {
            bottomLine += lastNumber + " ";
            lastNumber--;
        }

        return (long) bottomLine.length();
    }
}
