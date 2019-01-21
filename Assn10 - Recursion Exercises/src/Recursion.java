/**
 * Demonstrates a series of recursive methods.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class Recursion {
    /**
     * Provided main driver code that calls and demonstrates the recursive methods.
     *
     * @param args Commandline arguments
     */
    public static void main(String[] args) {

        int[] sumMe = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        System.out.printf("Array Sum: %d\n", arraySum(sumMe, 0));

        int[] minMe = { 0, 1, 1, 2, 3, 5, 8, -42, 13, 21, 34, 55, 89 };
        System.out.printf("Array Min: %d\n", arrayMin(minMe, 0));

        String[] amISymmetric =  {
                "You can cage a swallow can't you but you can't swallow a cage can you",
                "I still say cS 1410 is my favorite class"
        };
        for (String test : amISymmetric) {
            String[] words = test.toLowerCase().split(" ");
            System.out.println();
            System.out.println(test);
            System.out.printf("Is word symmetric: %b\n", isWordSymmetric(words, 0, words.length - 1));
        }

        double weights[][] = {
                { 51.18 },
                { 55.90, 131.25 },
                { 69.05, 133.66, 132.82 },
                { 53.43, 139.61, 134.06, 121.63 }
        };
        System.out.println();
        System.out.println("--- Weight Pyramid ---");
        for (int row = 0; row < weights.length; row++) {
            for (int column = 0; column < weights[row].length; column++) {
                double weight = computePyramidWeights(weights, row, column);
                System.out.printf("%.2f ", weight);
            }
            System.out.println();
        }

        char image[][] = {
                {'*','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ','*','*',' ',' '},
                {' ','*',' ',' ','*','*','*',' ',' ',' '},
                {' ','*','*',' ','*',' ','*',' ','*',' '},
                {' ','*','*',' ','*','*','*','*','*','*'},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ','*','*','*',' ',' ','*',' '},
                {' ',' ',' ',' ',' ','*',' ',' ','*',' '}
        };
        int howMany = howManyOrganisms(image);
        System.out.println();
        System.out.println("--- Labeled Organism Image ---");
        for (char[] line : image) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.printf("There are %d organisms in the image.\n", howMany);

    }
    
    /********************************************** Recursive Methods ************************************************/
    /**
     * Recursive method that checks if the given sentence is word symmetric.
     *
     * @param words Array of words (the sentence) to check
     * @param start Index to start at for checking symmetry
     * @param end End to start at for checking symmetry
     * @return True if word is symmetric; False if not
     */
    public static boolean isWordSymmetric(String[] words, int start, int end){
           if (start < end) {
               String word1 = words[start].toLowerCase();
               String word2 = words[end].toLowerCase();

               if (!word1.equals(word2)) {
                   return false;
               } else {
                   isWordSymmetric(words, start + 1, end - 1);
               }
           }

        return true;
    }

    /**
     * Recursive method that calculates the sum of all array elements.
     *
     * @param data Array with numbers to add
     * @param position Position of current number
     * @return Sum of current element value and next element value
     */
    public static long arraySum(int[] data, int position){
        if (data.length == 0 || position >= data.length) {
            return 0;
        }
        return data[position] + arraySum(data, position + 1);
    }

    /**
     * Recursive method that finds the minimum value in the specified array.
     *
     * @param data Array to find the minimum of
     * @param position Current position
     * @return Minimum of current element and next element
     */
    public static int arrayMin(int[] data, int position){
        if (position == data.length - 1){           // If at last position
            return data[position];
        }
        return Math.min(data[position], arrayMin(data, position + 1)); // Return current min
    }

    /**
     * Recursive method that computes the supported weights of each block of a pyramid.
     *
     * @param weights 2D array of weights to be used
     * @param row Row of the element to find
     * @param column Column of the element to find
     * @return The weight supported by the weight at the specified row and column
     */
    public static double computePyramidWeights(double [][] weights, int row, int column){
        boolean indexOutOfBounds = row < 0 || row >= weights.length
                || column < 0 || column >= weights[row].length;

        if (weights.length == 0 || indexOutOfBounds){
            return 0.0;
        }

        double weight = weights[row][column];
        double aboveWeight = computePyramidWeights(weights, row-1, column);

        boolean isSingleColumned = true;
        for (double[] r : weights) {
            if (r.length > 1){
                isSingleColumned = false;
            }
        }

        if (isSingleColumned){
            return weight + aboveWeight;
        }

        double aboveLeftWeight = computePyramidWeights(weights, row-1 , column-1);

        return weight + (aboveLeftWeight / 2.0) + (aboveWeight / 2.0);
    }

    /**
     * Iterates through the specified image and labels organisms that are encountered by calling labelOrganism method.
     *
     * @param image The image (char[][]) to search and label
     * @return The number of organisms found in image
     */
    public static int howManyOrganisms(char[][] image){
        char currentLabel = 'a';

        for (int row = 0; row < image.length; row++) {// Find new organisms}
            for (int column = 0; column < image[row].length; column++){
                if (image[row][column] == '*') {
                    labelOrganism(image, row, column, currentLabel);
                    currentLabel++;
                }
            }
        }
        return currentLabel - 'a';          // Number of letters past 'a' is the number of organisms.
    }

    /**
     * Labels specified image cell and tries to label the cell above, below, to the left, and to the right of it.
     *
     * @param image The image (char[][]) to search and label
     * @param row Row of organism cell
     * @param column Column of organism cell
     * @param label Current label (letter) being used
     */
    public static void labelOrganism(char[][] image, int row, int column, char label){
        boolean indexOutOfBounds = row < 0 || row >= image.length
                || column < 0 || column >= image[row].length;

        if (indexOutOfBounds || image[row][column] != '*'){  // Make sure index is in bounds and contains an asterisk
            return;
        }

        image[row][column] = label;        // Set cell to current label (letter)

        labelOrganism(image, row-1, column, label);    // Check above cell and label if valid
        labelOrganism(image, row+1, column, label);    // Check below cell and label if valid
        labelOrganism(image, row, column-1, label);  // Check left cell and label if valid
        labelOrganism(image, row, column+1,label);   // Check right cell and label if valid
    }
}
