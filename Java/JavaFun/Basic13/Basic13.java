import java.util.ArrayList;
import java.util.Arrays;

public class Basic13 {

    // Print all numbers 1-255
    public static void printNums() {
        System.out.println("Printing numbers 1-255");
        for (int i = 0; i <= 255; i++){
            System.out.println(i);
        }
        System.out.println("******************");
    }

    // Print all odd numbers 1-255
    public static void oddNums() {
        System.out.println("Printing all odd numbers between 1 and 255");
        for (int i = 0; i <= 255; i++){
            if (i % 2 != 0){

                System.out.println(i);
            }
            else {
                continue;
            }
        }
        System.out.println("******************");
    }

    // Print the sum of all numbers 0-255
    public static void printSum() {
        System.out.println("Adding up the total sum");
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum += i;
            System.out.println(sum);
        }
        System.out.println("******************");
    }

    // Iterate through an array
    public static void iterate(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("******************");
    }

    // Find the max value in an array of integers
    public static int max(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Max is: " + max);
        System.out.println("******************");
        return max;
    }

    // Find the average of the sum of all values in an array of integers
    public static int average(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int avg = max/arr.length;
        System.out.println("Average is: " + avg);
        System.out.println("******************");
        return avg;
    }

    // create and return an array of all odd numbers bewtween 1 and 255
    public static ArrayList oddArray (){
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0){
                arr.add(i);
            }
        }
        System.out.println("New array: " + arr);
        System.out.println("******************");
        return arr;
    }

    // Given an array, print all values greater than a dynamic integer
    public static int valuesGreaterThan (int[] nums, int num){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > num){
                count++;
            }
        }
        System.out.println(String.format("There are %o values greater than %o", count,num));
        System.out.println("******************");
        return count;
    }

    // Square the values in an array: BONUS: give the option to apply any exponent to all values 
    public static double[] nthPower(double[] nums, int power) {
        for (int i = 0; i < nums.length; i++){
            nums[i] = Math.pow(nums[i], power);
            System.out.println(nums[i]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("******************");
        return nums;
    }

    public static int[] noNegatives(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("******************");
        return nums;
    }

    public static int[] quickMafs(int[] nums){
        int max = max(nums);
        int min = max;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int avg = average(nums);
        int[] result = {min, max, avg};
        System.out.println("Min|Max|Average: " + Arrays.toString(result));
        System.out.println("******************");
        return result;
    }

    public static double[] shift(double[] nums){
        for (int i = 0; i < nums.length-1; i++) {
                nums[i] = nums[i+1];
        }
        nums[nums.length-1] = 0;
        System.out.println(Arrays.toString(nums));
        System.out.println("******************");
        return nums;
    }


}