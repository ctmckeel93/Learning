import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Puzzling {

    public ArrayList<Integer> greaterThan10(){
        int[] testArray = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> result =new ArrayList<Integer>();

        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] > 10) {
                result.add(testArray[i]);
            }
        }
        return result;
    }

    public ArrayList<String> namesLongerThan5() {
        String[] names = {"Nancy", "Jinchi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < names.length; i++){
            System.out.println(names[i].length());
            if (names[i].length() > 5){
                result.add(names[i]);
            } 
        }
        return result;
    }

    public String[] alphaShuffle() {
        Random rng = new Random();
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        System.out.println("First: " + alphabet[0]);
        System.out.println("Last: " + alphabet[alphabet.length - 1]);
        Collections.shuffle(Arrays.asList(alphabet));
        System.out.println("Shuffled First: " + alphabet[0]);
        System.out.println("Shuffled Last: " + alphabet[alphabet.length - 1]);
        return alphabet;
    }

    public int randomNums() {
        Random rng = new Random();
        int result = rng.nextInt(100 - 55) + 55;
        
        return result;
    }

    public int[] randomNumsArray(){
        int[] result = new int[10];
        Random rng = new Random();
        for (int i = 0; i < result.length; i++){
            result[i] = randomNums();
            System.out.println(result[i]);
        }
        return result;
    }

    public void minMaxDisplay() {
        int[] array = randomNumsArray();
        Arrays.sort(array);
        System.out.println("Min: " + array[0]);
        System.out.println("Max: " + array[array.length - 1]);
    }

    public String randomString() {
        String[] randomAlpha = alphaShuffle();
        String result = "";
        Random rng = new Random();
        for (int i = 0; i <= 5; i++){
            result = result + randomAlpha[rng.nextInt(randomAlpha.length)];
        }
        return result;
    }

    public String[] randomStringArray() {
        String[] result = new String[10];
        for (int i = 0; i < 10; i++){
            result[i] = randomString();
        }
        return result;
    }
}