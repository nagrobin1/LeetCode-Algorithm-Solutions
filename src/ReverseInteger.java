// Number 7
import java.util.Stack;

/**
 * Created by test on 2/12/17.
 */

public class ReverseInteger {

    public int reverse(int x) {

        Boolean pos ;

        if(Math.signum(x) == 1.0){
            pos = true;
        }else{
            pos = false;
            x = x * -1;
        }

        Stack storage = new Stack();

        int remainder;

        while(x > 0){

            remainder = x % 10;

            storage.push(Integer.toString(remainder));

            x = x/10;

        }

        double power = 0.0;
        String result = "" ;

        while(storage.empty() == false){
            String val = (String) storage.pop();
            result = result+val;
        }

        int res = Integer.parseInt(result);

        if(res > Integer.MAX_VALUE){
            return 0;
        }

        if(pos == true){
            return res;
        }
        else{
            return res;
        }


    }
}
