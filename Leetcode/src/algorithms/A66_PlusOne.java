package algorithms;

public class A66_PlusOne {
	
	//key point is to handle if the most significant digit has carry out 1;
	// int array is not easy to insert a value;
	public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        int cin = 1;
        while(p>=0) {
            if(digits[p] + cin == 10) {
                digits[p] = 0;
                cin = 1;
            } else {
                digits[p] = digits[p] + cin;
                cin = 0;
            }
            p--;
        }
        
        if(cin == 0) return digits;
        else {
            int [] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
    }
}
