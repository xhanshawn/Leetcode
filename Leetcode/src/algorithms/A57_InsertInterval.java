package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.Interval;

public class A57_InsertInterval {
	
	public static void main (String[] args) {
		A57_InsertInterval a57 = new A57_InsertInterval();
		List<Interval> intervals = new ArrayList<Interval>();
//		intervals.add(new Interval(1,5));
//		intervals.add(new Interval(6,8));
//		List<Interval> result = a57.insert(intervals, new Interval(2,3));
		
//		intervals.add(new Interval(1,3));
//		intervals.add(new Interval(6,7));
//		intervals.add(new Interval(10,12));
//		List<Interval> result = a57.insert(intervals, new Interval(6,9));
		
//		intervals.add(new Interval(6,9));
//		List<Interval> result = a57.insert(intervals, new Interval(7,8));
		
		intervals.add(new Interval(1,5));
		intervals.add(new Interval(6,8));
		List<Interval> result = a57.insert(intervals, new Interval(0,9));
//		
//		intervals.add(new Interval(1,3));
//		intervals.add(new Interval(6,7));
//		intervals.add(new Interval(10,12));
//		List<Interval> result = a57.insert(intervals, new Interval(5,8));
		
//		intervals.add(new Interval(2,5));
//		intervals.add(new Interval(6,7));
////		intervals.add(new Interval(8,9));
//		List<Interval> result = a57.insert(intervals, new Interval(0,10));
		
		
		for(Interval i : result) {
			System.out.println("[" + i.start + " " + i.end + "]");
		}


	}
	
	//accepted solution, not concise but O(logn) performance cause binary search
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		
		if(intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int p = binarySearch(0, intervals.size() - 1, intervals, newInterval);
// 		System.out.println(p + " ");
		
		List<Interval> result = new ArrayList<Interval> ();
		result.addAll(intervals.subList(0, p));
		if(intervals.get(p).start > newInterval.end ){
			result.add(newInterval);
			p--;
		} else if (intervals.get(p).end < newInterval.start) {
			result.add(intervals.get(p));
			result.add(newInterval);
		}
		else {
			newInterval.start = Math.min(intervals.get(p).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(p).end, newInterval.end);
			result.add(newInterval);
		}
		p++;
		while(p < intervals.size()) {
			if(intervals.get(p).start <= newInterval.end && result.size() > 0) {
				int larger = Math.max(intervals.get(p).end, newInterval.end);
				result.get(result.size() - 1).end = larger;
				newInterval.end = larger;
			} else result.add(intervals.get(p));
			p++;
		}
		return result;
    }
	private int binarySearch(int b, int e, List<Interval> intervals, Interval interval) {
		if(b >= e) return b;
		int m = (b + e)/2;
		Interval center = intervals.get(m);
		if(center.end < interval.start) return binarySearch(m+1, e, intervals, interval);
		else
//			if(center.start > interval.end)
			return binarySearch(b, m, intervals, interval);
//		else return m;
	}
	
	
	private List<Interval> bs(int b,int e, List<Interval> intervals, Interval newInterval) {
		if(newInterval == null)	return intervals;

		if(b == e) {
			intervals.add(b, newInterval);
			return intervals;
		}
        
		int m = (b+e)/2;
		Interval center = intervals.get(m);
		//right half
		if(center.end < newInterval.start) return bs(m+1, e, intervals, newInterval);
		//left half
		else if(center.start > newInterval.end) return bs(b, m, intervals, newInterval);
		else {
			//left is contained
			if(center.end >= newInterval.start && center.end < newInterval.end) {
				int i = m + 1;
				while(i < intervals.size() && intervals.get(i).start < newInterval.end) i++;
				if(i >= intervals.size() || intervals.get(i).start > newInterval.end) i--;
				List<Interval> result = new ArrayList<Interval> ();
				result.addAll(intervals.subList(0, m));
				result.add(new Interval(center.start, Math.max(intervals.get(i).end, newInterval.end)));
				result.addAll(intervals.subList(i + 1, intervals.size()));
				
				return result;
			}
			//right is contained
			else if (newInterval.end >= center.start && newInterval.start < center.start){
				int i = m - 1;
				while(i > 0 && intervals.get(i).end > newInterval.start) i--;
				if(i <= 0 || intervals.get(i).end < newInterval.start ) i++;
				List<Interval> result = new ArrayList<Interval> ();
				result.addAll(intervals.subList(0, i));
				result.add(new Interval(Math.min(intervals.get(i).start, newInterval.start), center.end));
				result.addAll(intervals.subList(m + 1, intervals.size()));
				
				return result;
			}
			//neither
			else if (center.start > newInterval.start && center.end < newInterval.end) {
				int i = m;
				while(i>0 && intervals.get(i).end > newInterval.start) i--;
				if(i <= 0 || intervals.get(i).end < newInterval.start) i++;
				int j = m;
				while(j<intervals.size() && intervals.get(j).start < newInterval.end) j++;
				if(j >= intervals.size() || intervals.get(j).start > newInterval.end) j--;
				List<Interval> result = new ArrayList<Interval> ();
				result.addAll(intervals.subList(0, i));
				result.add(new Interval(Math.min(intervals.get(i).start, newInterval.start),
						Math.max(intervals.get(j).end, newInterval.end)));
				result.addAll(intervals.subList(j + 1, intervals.size()));
				
				return result;
			}
		}
		
		return intervals;
	}
	
	public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        HashMap<Integer, Boolean> record = new HashMap<Integer, Boolean>();
        int max = 0;
        final boolean LEFT = true;
        final boolean RIGHT = false;
        record.put(newInterval.start, LEFT);
        record.put(newInterval.end, RIGHT);
        max = Math.max(newInterval.start, newInterval.end);
        for(int i=0; i<intervals.size(); i++) {
            int left = intervals.get(i).start;
            int right = intervals.get(i).end;
            if(record.get(left) != null && record.get(left) == RIGHT) record.remove(left);
            else record.put(left, LEFT);
            if(record.get(right) != null && record.get(right) == LEFT) record.remove(right);
            else record.put(right, RIGHT);
            if(left > max) max = left;
            if(right > max) max = right;
        }
        
		System.out.println("ok" + max);

        List<Interval> result = new ArrayList<Interval>();
        int i = 0;
        while(i <= max) {
    		System.out.println("" + i);

            if(record.get(i) == null) {
            	i++;
            	continue;
            	
            }
            int start = i;

            while(i <= max && (record.get(i) == null || record.get(i) == LEFT)) i++;
            int end = i;
            while(i <= max && (record.get(i) == null || record.get(i) == RIGHT)) {
                end = i;
                i++;
            }
            result.add(new Interval(start, end));
        }
        
        return result;
    }
}	
