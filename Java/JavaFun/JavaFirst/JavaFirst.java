public class JavaFirst {
    public static String name = "Corey";
    public static int age = 27;
    public static String home = "Smithfield, VA";
    public static void main(String[] args) {
        System.out.println("Hello World");
        printDetails();
    }

    public static void printDetails(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(home);
    }

}