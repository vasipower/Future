package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OccurenceOfStringInASentence {


    public static void main(String[] args) {

    	
        String s1 = "Bread butter and bread BreAd";
       String s=s1.toLowerCase();
        
        String a[] = s.split(" ");
        Map<String, Integer> words = new HashMap<String, Integer>();
        for (String str : a) {
            if (words.containsKey(str)) {
                words.put(str, 1 + words.get(str));
            } else {
                words.put(str, 1);
            }
        }
        System.out.println(words);
    }
}