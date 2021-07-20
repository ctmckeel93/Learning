import java.util.ArrayList;


public class ExceptionList {
    
    public void Display(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(String.format("%s was successfully casted", castedValue));
            }
            catch (ClassCastException e) {
                String error = String.format("%s could not be converted to Integer", myList.get(i));
                System.out.println(error);
            }
        }
    }
}