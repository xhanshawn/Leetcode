package algorithms;

public class A6_ZigZagConversion {
	public static void main(String[] args) {
		A6_ZigZagConversion a6 = new A6_ZigZagConversion();
		System.out.println(a6.convert("PAYPALISHIRING", 3));
		System.out.println(a6.convert("PAYPALISHIRING", 4));
//		System.out.println(a6.convert("ABCD", 2));
	}
	
	//key point is to understand this problem... zigzag.
	public String convert(String s, int numRows) {
        String[]  result = new String[numRows];
        if(numRows == 1) return s;
        int offset = numRows - 2;
        for(int i = 0; i < numRows; i++ ) {
            StringBuilder sb = new StringBuilder();
        	
            for(int j=i; j< s.length(); j += offset + numRows) {
        		sb.append(s.charAt(j));
        		int right = j + 2 * (numRows - i - 1);
        		if(i < numRows - 1 && i>0 && right > 0 && right < s.length()) sb.append(s.charAt(right));
            }
            result[i] = sb.toString();
    		System.out.println(result[i]);

        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++) {
        	sb.append(result[i]);
        }
        return sb.toString();
    }
}
