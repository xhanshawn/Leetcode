package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class A146_LRUCache {
	public static void main(String[] args) {
		LRUCache c = new LRUCache(3);
		c.set(1,1);
		c.set(2,2);
		c.set(3,3);
		System.out.println(c.get(1));
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
	
	
	
	
	//accepted solution tried many times
	//a former version not passed because of TLE
	static class LRUCache {
		class Record{
			int key;
			int value;
			int time;
			Record(int key, int value, int time){
				this.key = key;
				this.value = value;
				this.time = time;
			}
		}
		int capacity;
		int t = 0;
		Queue<Record> q;
		Map<Integer, Record> map = new HashMap<Integer, Record>();
		
		public LRUCache(int capacity) {
			this.capacity = capacity;
			Comparator<Record> com = new Comparator<Record>(){

				@Override
				public int compare(Record o1, Record o2) {
					// TODO Auto-generated method stub
					return o1.time - o2.time;
				}
			}; 
			q = new PriorityQueue<Record> (capacity, com);
	    }
	    
	    public int get(int key) {
	    	
	    	if(map.containsKey(key)) {
	    		q.remove(map.get(key));
	    		map.get(key).time = ++t;
	    		q.add(map.get(key));
	    		return map.get(key).value;
	    	}
	    	return -1;
	    }
	    
	    public void set(int key, int value) {
	        if(map.containsKey(key)){
	        	q.remove(map.get(key));
	        	map.remove(key);
	        } else {
	        	if(map.size() >= capacity) {
	        		Record head = q.poll();
	        		map.remove(head.key);
	        	}
	        }
	        Record record = new Record(key, value, ++t);
        	q.add(record);
        	map.put(key, record);
	    }
	}
	
	
	// so called linkedhashmap solution not accepted cause linkedhashmap is not permited
	public class LRUCache2 {

	    private Map<Integer, Integer> map;

	    public LRUCache2(int capacity) {
	        map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
	            protected boolean removeEldestEntry(Map.Entry eldest) {
	                return size() > capacity;
	            }
	        };
	    }

	    public int get(int key) {
	        return map.getOrDefault(key, -1);
	    }

	    public void set(int key, int value) {
	        map.put(key,value);
	    }
	}
}
