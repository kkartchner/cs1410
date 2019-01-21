import java.util.LinkedList;
import java.util.Scanner;

/**
 * Prompts the user for the number of lines and then generates and prints a pyramid of numbers with the number of lines
 * entered.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Pyramid2 {
    /**
     * @param args Command line arguments for the program
     */
    public static void main(String args[]) {
        System.out.print("Enter the number of lines: ");                          // Prompt user for input
        Scanner input = new Scanner(System.in);

        int lineCount = input.nextInt();                                          // Store value received

        int numberWidth = ("" + (long) Math.pow(2, lineCount - 1)).length() + 1;  // Set numberWidth to length of
        //    highest number

        int bottomNumberCount = 1 + 2 * (lineCount - 1);                          // Find the quantity of numbers that
        //    will be on the bottom line

        LinkedList<String> leftSideNumbers = new LinkedList<>();                  // List for left half of numbers
        LinkedList<String> rightSideNumbers = new LinkedList<>();                 // List for  right half of numbers

        long leftMargin = ((bottomNumberCount - 1) / 2) * numberWidth + 1;        // Left margin spacing

        for (int i = 0; i < lineCount; i++) {                                // Do for each line:
            String middleNumber = "" + (long) Math.pow(2, i);                     //    Find middle number

            System.out.printf("%" + leftMargin + "s", " ");                       //    Print left margin
            for (String left : leftSideNumbers){                                  //    Print all left side numbers
                System.out.printf("%" + numberWidth + "s", "" + left);
            }

            System.out.printf("%" + numberWidth + "s", "" + middleNumber);        //    Print middle number

            for (String right : rightSideNumbers){                                //    Print all right side numbers
                System.out.printf("%" + numberWidth + "s", "" + right);
            }

            System.out.print("\n");                                               //    Print a new line
            leftMargin -= numberWidth;                                            //    Move margin to left by number-
            //      width amount

            leftSideNumbers.add(middleNumber);                       //   Add middleNumber to end of left side list
            rightSideNumbers.addFirst(middleNumber);                 //     and to beginning of right side number list
        }
    }
}
