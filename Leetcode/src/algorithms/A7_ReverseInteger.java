package algorithms;

public class A7_ReverseInteger {
	public static void main (String[] args) {
		
		System.out.println("" + Integer.MAX_VALUE);
		System.out.println("" + Integer.MIN_VALUE);
		A7_ReverseInteger a7 = new A7_ReverseInteger();
		System.out.println("" + a7.reverse(10));
		System.out.println("" + a7.reverse(-111111119));
		System.out.println("" + a7.reverse(111111119));
		System.out.println("" +(-9 * 10+ (-111111119 %10)));
		System.out.println("" + (-111111119 /10));
		System.out.println("" + a7.reverse(-2147483412));
	}
	
	
	// my idea is to reserve one digit for avoiding overflow
	// but the input is integer
	// this reservation is useless
	public int reverse(int x) {
        boolean neg = (x < 0) ? true : false;
        int result = 0;
        int p = 0;
        while (x!=0 && p< 9) {
            result = result * 10 + (x%10);
            x = x/10;
            p++;
        }
        if(result > Integer.MAX_VALUE/10) return 0;
        if(x == 0) return result;
        if(x < 8 && !neg) return result*10 + x;
        if(x < 9 && neg) return result*10 + x;
        return 0;
    }
	
	
	//much easier solution and concise
	public int reverse_solution(int x) {
		int result = 0;
		while(x != 0){
			if(Math.abs(result) > Integer.MAX_VALUE/10) return  0;
			result = result * 10 + x %10;
			x /= 10;
		}
		
		return result;
	}
}
