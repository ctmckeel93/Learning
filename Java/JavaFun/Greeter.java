public class Greeter {

    private String createGreeting(String toBeGreeted){
        return "Greetings, " + toBeGreeted; 
    }

    public String greet() {
        createGreeting("World");
    }

    public String greet(String fname, String lname){
        return createGreeting(fname + " " + lname );
    }
}