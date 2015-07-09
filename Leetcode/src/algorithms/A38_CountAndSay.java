package algorithms;

public class A38_CountAndSay {
	public static void main (String[] args) {
		A38_CountAndSay a38 = new A38_CountAndSay();
		System.out.println(a38.countAndSay(1));
		System.out.println(a38.countAndSay(2));
		System.out.println(a38.countAndSay(3));
		System.out.println(a38.countAndSay(4));
	}
	public String countAndSay(int n) {
        String num = "1";
        for(int i = 1; i < n; i++) {
            String temp = "";
            int j = 0;
            while(j<num.length()){
                int count = 1;
                char ch = num.charAt(j);
                j++;
                while (j<num.length() 
                && num.charAt(j) != ' '&&
                ch == num.charAt(j)) {
                	count++;
                	j++;
                }
                if(count != 0) temp += count + "" + ch;
            }
            num = temp;
        }
        return num;
    }
}
