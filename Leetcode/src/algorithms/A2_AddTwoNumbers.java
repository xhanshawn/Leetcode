package algorithms;
import data.ListNode;


public class A2_AddTwoNumbers {
	
	public static void main (String[] args){
		
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(1);
		
		A2_AddTwoNumbers atn = new A2_AddTwoNumbers();
		ListNode result = atn.addTwoNumbers(l1, l2);
		
		while(result != null){
			
			System.out.println(result.val);
			result = result.next;
		}
		

	}
	
	
	//my own first accepted version
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        
        if(l1 == null && l2 != null) return l2;
        if(l2 == null && l1 != null) return l1;
        
        l2.val += l1.val;
        
        if(l2.val > 9) {
            l2.val -= 10;
            carry = 1;
        }
        
        ListNode result_list = l2;
        
        while (l1.next != null || l2.next != null){
            
            int current_1 = 0;
            if(l1.next != null) {
                
                current_1 = l1.next.val;
                l1 = l1.next;
            }
            
            if(l2.next != null) {

                l2.next.val += current_1 + carry;
                
                if(l2.next.val>9) {
                    l2.next.val -= 10;
                    carry = 1;
                
                }else {
                    carry = 0;
                }
                

            }else{
                
                int result  = current_1 + carry;
                
                if(result>9) {
                    
                    result = result - 10;
                    carry = 1;
                }else {
                    carry = 0;
                }
                ListNode new_node = new ListNode(result);
                
                l2.next = new_node;

            }
            
            l2 = l2.next;
        }
        
        if(l2.next == null && l1.next == null && carry == 1) {
            
            ListNode new_node = new ListNode(1);
            
            l2.next = new_node;
           
        } 
        return result_list;
    }
	
}
