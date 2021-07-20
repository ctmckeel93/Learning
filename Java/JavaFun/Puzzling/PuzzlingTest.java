import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzlingTest {

    Random rng = new Random();
    public static void main(String[] args){
        Puzzling test = new Puzzling();
        // Testing integer array
        System.out.println("Testing integer array puzzle");
        ArrayList<Integer> test1 = test.greaterThan10();
        System.out.println(test1);

        // Testing name array 
        System.out.println("Testing name array");
        ArrayList<String> test2 = test.namesLongerThan5();
        System.out.println(test2);

        // Testing alphabet Shuffle
        System.out.println("Testing alphabet shuffle");
        test.alphaShuffle();

        int random = test.randomNums();
        System.out.println("Random number: " + random);

        test.randomNumsArray();
        test.minMaxDisplay();

        System.out.println("Randomstring: " + test.randomString());
        String[] test4 = test.randomStringArray();
        for (String word : test4) {
            System.out.println(word);
        }


    }
}