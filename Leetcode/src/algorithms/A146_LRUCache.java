package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A146_LRUCache {
	public static void main(String[] args) {
		LRUCache c = new LRUCache(3);
		c.set(1,1);
		c.set(2,2);
		c.set(3,3);
		c.set(4,4);
		System.out.println(c.get(4));
		System.out.println(c.get(3));
		System.out.println(c.get(2));
		System.out.println(c.get(1));
		c.set(5,5);
		System.out.println(c.get(1));
		System.out.println(c.get(2));
		System.out.println(c.get(3));
		System.out.println(c.get(4));
		System.out.println(c.get(5));
	}
	
	
	
	
	
	static class LRUCache {
		
		private Map<Integer, int[]> map = new HashMap<Integer, int[]>();
	    private List<List<int[]>> list = new ArrayList<List<int[]>>();
	    
	    private int capacity;
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	    	//contain 
	        if(map.keySet().contains(key)) {
	            //forward 1 level
	            forward(key);            
	            return list.get(map.get(key)[0]).get(map.get(key)[1])[1];
	        }
	        //not contain return  -1
	        else return -1;
	    }
	    
	    public void set(int key, int value) {
	    	List<int[]> last = null;
//            System.out.println(list.size() + "   s");
        	if(list.size() > 0) last = list.get(list.size() - 1);
        	else last = new ArrayList<int[]>();
	        
        	if(!map.keySet().contains(key)) {
            	//remove last or not remove
	            if(map.size() >= capacity && capacity > 0) {
	            		int p = last.get(0)[0];
	            		map.remove(p);
		                last.remove(0);
	            } 
	            
	        } else {
	        	//remove former
	        	int[] pos = map.get(key);
	        	list.get(pos[0]).remove(pos[1]);
	        }
//            System.out.println(list.size() + "   s");
        	//add
        	last.add(new int[] {key, value});
            if(list.size() == 0) list.add(last);
            map.put(key, new int[] {list.size() - 1, last.size() - 1});
	    }
	    
	    private void forward(int key) {
	    	int[] pos = map.get(key);
	    	int[] pair = list.get(pos[0]).get(pos[1]);
	    	list.get(pos[0]).remove(pos[1]);
	    	if(list.get(pos[0]).isEmpty()) list.remove(pos[0]);
	        if(pos[0] > 0) {
	            list.get(pos[0] - 1).add(pair);
	            map.put(key, new int[] {pos[0] - 1, list.get(pos[0] - 1).size() - 1});
	        }else {
	        	List<int[]> fst = new ArrayList<int[]> ();
	        	fst.add(pair);
	        	list.add(0, fst);
	            map.put(key, new int[] {0, list.get(0).size() - 1});
	        }
	    }
		
//		private Map<Integer, int[]> map = new HashMap<Integer, int[]>();
//	    private List<List<int[]>> list = new ArrayList<List<int[]>>();
//	    
//	    private int capacity;
//	    private int last_num;
//	    public LRUCache(int capacity) {
//	        this.capacity = capacity;
//	        last_num = -1;
//	    }
//	    
//	    public int get(int key) {
//	    	//contain 
//	        if(map.keySet().contains(key)) {
//	            return forward(key);      
//	        }
//	        //not contain return  -1
//	        else return -1;
//	    }
//	    
//	    public void set(int key, int value) {
//	        if(!map.keySet().contains(key)) {
//	            if(map.size() >= capacity && capacity != 0) {
//	            	remove(list.get(last_num).get(0)[0]);
//	            }
//	            
//	        } else remove(key);
//	        if(last_num > -1) list.get(last_num).add(new int[] {key, value});
//            else {
//            	List<int[]> last = new ArrayList<int[]>();
//            	last.add(new int[] {key, value});
//            	list.add(last);
//            	last_num ++;
//            }
//            map.put(key, new int[]{last_num, list.get(last_num).size() - 1});
//	    }
//	    
//	    private int forward(int key) {
//	    	int p = map.get(key)[0];
//	    	int i = map.get(key)[1];
//
//        		if(list.get(p).get(i)[0] == key) {
//        			int[] pair = list.get(p).get(i);
//        			if(p > 0) {
//        	            list.get(p - 1).add(pair);
//        	            map.replace(key, new int[]{p - 1, list.get(p-1).size() - 1});
//        	            list.get(p).remove(i);
//        	        }
//        			else {
//        				List<int[]> first = new ArrayList<int[]>();
//        				first.add(pair);
//        				list.add(0, first);
//        				map.replace(key, new int[]{0, first.size() - 1});
//        	            list.get(1).remove(i);
//        			}
//    	            return pair[1];
//        		}
//	    	return -1;
//	    }
//	    private boolean remove(int key) {
//	    	int p = map.get(key)[0];
//	    	int i = map.get(key)[1];
//    		if(list.get(p).size() == 1) {
//    			list.remove(p);
//        		last_num --;
//	            return true;
//    		}
//    		
//
//        		if(list.get(p).get(i)[0] == key) {
//        	            list.get(p).remove(i);
//                		map.remove(key);
//        	            return true;
//        		}
//	    	return false;
//	    }
	}
}
