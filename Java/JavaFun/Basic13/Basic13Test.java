public class Basic13Test {

    public static int[] testArray = {11,342,33,14,-5};
    public static double[] testArray2 = {11,342,33,14,-5};
    public static void main(String[] args) {
        System.out.println("Testing the Basic 13 class");
        Basic13 test = new Basic13();
        test.printNums();
        test.oddNums();
        test.printSum();
        test.iterate(testArray);
        test.max(testArray);
        test.average(testArray);
        test.oddArray();
        test.valuesGreaterThan(testArray, 20);
        // test.nthPower(testArray2,2);
        // test.noNegatives(testArray);
        test.quickMafs(testArray);
        test.shift(testArray2);
    }
}