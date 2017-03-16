/**
 * Created by test on 3/3/17.
 */
import java.util.*;

public class Anagram {

    public static void main(String [] args){

        System.out.println(isAnagram("sdasd*","sdasd*"));
    }

    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> dict_s = new HashMap<>();
        HashMap<Character, Integer> dict_t = new HashMap<>();

        generateHashMap(dict_s, s);
        generateHashMap(dict_t, t);

        return dict_s.equals(dict_t);
    }

    public static void generateHashMap(HashMap<Character, Integer> hm, String str){

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(hm.containsKey(c)){
                int oldCount = hm.get(c);
                hm.put(c, oldCount + 1);
            }else{
                hm.put(c, 1);
            }
        }

    }
}
