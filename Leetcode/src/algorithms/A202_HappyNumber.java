package algorithms;

import java.util.HashSet;

public class A202_HappyNumber {
	public static void main(String[] args) {
		A202_HappyNumber a202 = new A202_HappyNumber();
		if(a202.isHappy(99)) System.out.println("ok");
		else System.out.println("Fuck");
	}
	
	public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        int num = n;
        int sum = 0;
        while(sum != 1){
            if(set.contains(num)) return false;
            set.add(num);
            while(num != 0) {
                sum += (num % 10) * (num % 10);
                num /= 10;
            }
            if(sum == 1) return true;
            num = sum;
            sum = 0;
        }    
        
        return false;
    }
}
