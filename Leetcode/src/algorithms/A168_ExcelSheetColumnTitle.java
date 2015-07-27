package algorithms;

public class A168_ExcelSheetColumnTitle {
	public static void main(String[] args) {
		A168_ExcelSheetColumnTitle a168 = new A168_ExcelSheetColumnTitle();
		for(int i = 0; i < 100 ; i ++) {
			System.out.println(i + "      " + a168.convertToTitle(703));
		}
	}
	
	//easy level problem but not easy ... cause it looks like a radix - 26 problem but it is a trap.
	// it 's not a radix 26 number problem
	public String convertToTitle(int n) {
		if(n == 0) return "";
		String result = "";
		while(n > 0) {
			result = convert(n) + result;
			if(n % 26 == 0) n = (n / 26) - 1;
			else n /= 26;
		}
		
		return result;
    }
	
	private String convert(int n) {
		
		if(n % 26 == 0) return "Z";
		return String.valueOf((char) ('A' + n % 26 - 1));
	}
}
