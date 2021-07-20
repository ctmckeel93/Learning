public class StringManipulatorTest {

    public static void main(String[] args) {
        char letter = 'o';
        StringManipulator manipulator = new StringManipulator();
        System.out.println("Testing Trim and Concat, should return HelloWorld");
        String str = manipulator.trimAndConcat("   Hello   ", "   World   ");
        System.out.println(str);

        System.out.println("Testing IndexOrNull, should return variable letter or null");
        Integer test1 = manipulator.getIndexOrNull("Coding", letter);
        Integer test2 = manipulator.getIndexOrNull("Hello World", letter);
        Integer test3 = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);

        System.out.println("Testing concatSubstring class, should return eworld");
        String word  = manipulator.concatSubstring("Hello", 1,2, "world");
        System.out.println(word);
        
    }
}