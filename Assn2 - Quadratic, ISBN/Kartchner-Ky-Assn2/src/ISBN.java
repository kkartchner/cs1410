import java.util.Scanner;
import java.util.Stack;

/**
 * Prompts the user to enter the first 9 digits of an ISBN number, calculates the corresponding check sum, and then
 * prints them together as an ISBN-10 number.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class ISBN {
    /**
     *  @param args Command line arguments for the program
     */
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);

       System.out.print(("Enter the first 9 digits of an ISBN: "));
       int firstNine = input.nextInt();          // Set firstNine to equal next integer (omits leading zeros)

       Stack digits = new Stack();               // Create a stack

       while (firstNine > 0){                    // While firstNine is less than or equal to 0:
           int rightMostDigit = firstNine % 10;  //     Find right-most digit (i.e 13601267 % 10 = 7)
           digits.push(rightMostDigit);          //     Add right-most digit to stack
           firstNine /= 10;                      //     Divide firstNine by ten to move one decimal place to the left
       }

       while (digits.size() < 9){                // While the stack size is leas than 9:
           digits.push(0);                 //     Add a 0 to the stack (this adds back omitted leading 0's)
       }

       String fullISBN = "";                     // Create string for storing full ISBN number

       int checkSum = 0;                         // Calculate check sum:
       for (int i = 1; i <= 9; i++){             //     Yields:
           int digit = (int) digits.pop();       //     d1*1 + d2*2 + d3*3 ... + di*i
           fullISBN += digit;
           checkSum += digit * i;
       }
       checkSum %= 11;                           //     Then modulus by 11

       if (checkSum == 10){                      // Add "X" to the fullISBN string if checkSum is 10
           fullISBN += "X";
       } else {                                  // Otherwise just add the checkSum
           fullISBN += checkSum;
       }

       System.out.println("The ISBN-10 number is: " + fullISBN);    // Print final ISBN-10 number
    }
}
