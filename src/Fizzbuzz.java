/**
 * Created by test on 3/3/17.
 */

import java.util.*;

public class Fizzbuzz {

    public List<String> fizzBuzz(int n) {

        List result = new ArrayList();

        for(int i = 1; i <= n; i++){
            if(i%3 == 0 && i%5 == 0){
                result.add("FizzBuzz");
            }else if(i%3 == 0){
                result.add("Fizz");
            }else if(i%5 == 0){
                result.add("Buzz");
            }
            else{
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
}
