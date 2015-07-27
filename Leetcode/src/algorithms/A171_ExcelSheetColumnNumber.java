package algorithms;

public class A171_ExcelSheetColumnNumber {
	
	public static void main(String[] args) {
		A168_ExcelSheetColumnTitle a168 = new A168_ExcelSheetColumnTitle();
		A171_ExcelSheetColumnNumber a171 = new A171_ExcelSheetColumnNumber();
		for(int i = 0; i < 1111111; i++) {
			int ii = a171.titleToNumber(a168.convertToTitle(i));
			if( i != ii) System.out.println(i + "     "  + ii);
		}
		
		System.out.println("yes");
	}
	
	public int titleToNumber(String s) {
        if(s.length() == 0) return 0;
        int result = 0;
        for(int i = s.length() - 1; i >=0; i--){
            char ch = s.charAt(i);
            result +=  (int) (ch - 'A' + 1) * Math.pow(26,s.length() - 1 - i);
        }
        
        return result;
    }    
}
