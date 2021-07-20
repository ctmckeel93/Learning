public class StringManipulator {
    public String trimAndConcat(String str1, String str2){
        str1 = str1.trim();
        str2 = str2.trim();
        return(str1 + str2);
    }

    public Integer getIndexOrNull(String str, char c){
        if (str.indexOf(c) == -1){
            return null;
        }
        return str.indexOf(c);
    }

    public String concatSubstring(String str1, Integer start, Integer end, String str2){
        return str1.substring(start,end) + str2;
    }
}