package algorithms;

public class A191_NumerOf1Bits {
	
	public static void main (String[] args) {
		A191_NumerOf1Bits a191 = new A191_NumerOf1Bits();
		System.out.println(Integer.MAX_VALUE + "");
		System.out.println(a191.hammingWeight(Integer.MIN_VALUE) + "");
	}
	
	//accepted solution
	//key point is n & 1
	public int hammingWeight(int n) {
        int num = 0;
        if(n % 2 == 1) {
            num = 1;
            n = n>>1;
        }
        
        for(int i = 32; i >0; i--) {
            if((n & 1) == 1) {
            	num++;
            }
        	n = n >> 1;

        }
        
        return num;
    }
}
