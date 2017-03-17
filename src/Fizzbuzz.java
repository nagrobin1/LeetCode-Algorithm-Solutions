/**
 * Created by test on 3/3/17.
 * "Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number
 * and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”."
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
