package algorithms;

public class A43_MultiplyStrings {
	
	public static void main(String[] args) {
		A43_MultiplyStrings a43 = new A43_MultiplyStrings();
		System.out.println(a43.multiply("999", "0"));
		System.out.println(a43.multiply("" + Integer.MAX_VALUE, "" + 2));

	}
	
	//accepted solution
	public String multiply(String num1, String num2) {
        int l1 = num1.length(); 
        int l2 = num2.length();
        int[] pdt = new int[l1 + l2 - 1];
        for(int i = l2 - 1; i >= 0; i--) {
            for(int j = l1 - 1; j >= 0; j--) {
                pdt[i + j] += (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
            }
        }
        int carry = 0;
        boolean not_zero = false;
        StringBuilder sb = new StringBuilder();
        for(int i = pdt.length - 1; i >= 0; i--){
            pdt[i] += carry;
            carry = pdt[i] / 10;
            pdt[i] = pdt[i] % 10;
        }
        if(carry > 0) {
        	sb.append("" + carry);
        	not_zero = true;
        }
        for(int i = 0; i < pdt.length; i++) {
        	if(pdt[i] == 0 && !not_zero) continue;
        	not_zero = true;
        	sb.append(String.valueOf(pdt[i]));
        }
        if(!not_zero && pdt[pdt.length - 1] == 0) return "0";
        return sb.toString();
    }
}
