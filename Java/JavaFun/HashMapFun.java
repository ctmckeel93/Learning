import java.util.HashMap;
import java.util.Set;



public class HashMapFun {
    public static void main(String[] args){
        System.out.println("Testing the Hash map");
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Nowhere Generation", "We are the nowhere generation! We are the kids that noone wants. We are a credible threat to the rules you set...");
        trackList.put("Numbers", "They have the power! But we have the numbers now. It's all just a constant illlusion of control...");
        trackList.put("Sudden Urge", "I get a sudden urge, to watch this whole town burn. Light up the whole damn sky, like the fourth of July...");

        String lyrics = trackList.get("Numbers");
        System.out.println(lyrics);
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println( key + ": " + trackList.get(key));
        }
    }
    

}