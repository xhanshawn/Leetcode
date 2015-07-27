package algorithms;

import java.util.HashMap;
import java.util.Map;

public class A166_FractionToRecurringDecimal {
	
	public static void main(String[] args) {
		
		A166_FractionToRecurringDecimal a166 = new A166_FractionToRecurringDecimal();
		System.out.println(a166.fractionToDecimal(2, 3));
		System.out.println(a166.fractionToDecimal(1, 3));
		System.out.println(a166.fractionToDecimal(1, 5));
		System.out.println(a166.fractionToDecimal(2, 1));
		System.out.println(a166.fractionToDecimal(-50, 8));
		System.out.println(a166.fractionToDecimal(7, -12));
		System.out.println(a166.fractionToDecimal(1, Integer.MIN_VALUE));
		if(a166.fractionToDecimal(-1, Integer.MIN_VALUE).equals("0.0000000004656612873077392578125")) System.out.println("perfect");
		
	}
	
	public String fractionToDecimal(int numerator, int denominator) {
        String result = (numerator > 0 && denominator < 0 || denominator > 0 && numerator < 0 ) ? "-" : "" ;
        long num = numerator;
        long denom = denominator;
        result += String.valueOf(Math.abs(num/denom));
        Map<Long, Integer> rems = new HashMap<Long, Integer>();
        long rem = num % denom * 10;
        if(rem == 0) return result;
        result += ".";
        while(rem != 0 && !rems.containsKey(rem)) {
            rems.put(rem, result.length());
            result += Math.abs(rem / denom);
            rem = rem % denom * 10;
        }
        if(rem == 0) return result;
        result = result.substring(0, rems.get(rem)) + "(" + result.substring(rems.get(rem)) + ")";
        return result;
    }
}
