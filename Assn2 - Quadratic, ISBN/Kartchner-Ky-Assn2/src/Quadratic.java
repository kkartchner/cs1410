import java.util.Scanner;

/**
 * Prompts the user to enter the three coefficients for the quadratic formula (a, b, and c), then computes
 * the corresponding roots (solutions to ax^2 + bx + c = 0).
 *
 * @author Ky Kartchner
 * @version 1.0
 */ 
public class Quadratic {
    /**
     *  @param args Command line arguments for the program
     */
    public static void main(String[] args){
        System.out.print("Enter a, b, c: ");                        // Prompt user and get numbers for a, b, and c
        Scanner input = new Scanner(System.in);

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double discriminant = b*b - 4*a*c;                          // Find the discriminant

        double root1 = (-b + Math.sqrt(discriminant)) / (2*a);      // Find the roots
        double root2 = (-b - Math.sqrt(discriminant))/ (2*a);

        if (discriminant > 0) {                                     // Print "two roots" (if discriminant is positive)
            System.out.println("There are two roots for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + root1);
            System.out.println("r2 = " + root2);
        } else if (discriminant == 0) {                             // Print "one root" (if discriminant is 0)
            System.out.println("There is one root for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + root1);
        } else {                                                    // Print "no roots" (if discriminant is negative)
            System.out.println("There are no roots for the quadratic equation with these coefficients.");
            System.out.println();
        }
    }
}
