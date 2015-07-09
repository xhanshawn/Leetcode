package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class A207_CourseSchedule {
    int[] topo;
    ArrayList<Integer> finish = new ArrayList<Integer> ();
    int t;
	public static void main(String[] args) {
		A207_CourseSchedule a207 = new A207_CourseSchedule();
//		int[][] pre = {{0,1}, {1,2}, {3,4}, {2,3}};
//		int[][] pre = {{2,1}, {3,2}, {4,3}, {5,4}, {6,3},{7,6}, {7,4},{6,4}};
		int[][] pre = {{1,0}};
//		int[][] pre = {{1,0}, {0,1}};

//		int[][] pre = {{1,0}, {2,0}, {0,1}};

//		int[][] pre = {{2,1}, {3,2},{6,3}, {6,2}, {4,2}, {5,2},{4,2},{7,1}};
		if(a207.canFinish(8, pre)) System.out.println("ok");
		else System.out.println("fuck");
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int edges = 0;
        if((edges = prerequisites.length) == 0) return true;
        
        HashSet<Integer>[] sets = new HashSet[numCourses];
        for(int i=0; i < edges; i++) {
            int[] pair = prerequisites[i];
            if(sets[pair[1]] == null) sets[pair[1]] = new HashSet<Integer>();
            sets[pair[1]].add(pair[0]);
        }
        topo = new int[numCourses];
        t = 0;
        for(int i=0; i < numCourses; i++) {
        	if(topo[i] == 0){
//        		if(!
        		dfs(i,sets);
//        		) return false;
        	}
        }
        int max = 0;
        for(int i =0; i<topo.length; i++) {
        	if(topo[i] > max) max = topo[i];
        }
        return max == numCourses;
	}
	
	private boolean dfs(int i, HashSet<Integer>[] sets){
		t = t+1;
//		if(topo[i] > 0 && topo[i] < t) return false;
		
		topo[i] = -1;
		if(sets[i] != null) {
			for(int e : sets[i]) {
				if(topo[e] == 0) {
//					if(!
							dfs(e, sets);
//							) return false;
				}
			}
		}
		finish.add(i);
		topo[i] = t + 1;
		return true;
	}
	
	public boolean canFinishB(int numCourses, int[][] prerequisites) {
		
        int edges = 0;
        if((edges = prerequisites.length) == 0) return false;
        
        HashSet<Integer>[] sets = new HashSet[numCourses];
        for(int i=0; i < edges; i++) {
            int[] pair = prerequisites[i];
            if(sets[pair[1]] == null) sets[pair[1]] = new HashSet<Integer>();
            sets[pair[1]].add(pair[0]);
        }
        Queue<Integer> que = new LinkedList<Integer>();
        int taken = 0;
		topo = new int[numCourses];
        for(int i = 0; i< numCourses ; i++) {
        	if(sets[i] == null) continue; 
        	if(topo[i] == 0) {
        		que.add(i);
//        		topo[i] = (0 - tree) * numCourses + 1;
        	}
        	
        	while(!que.isEmpty()){
        		int current = que.poll();

        		if(sets[current] != null){
            	
        			for(int e : sets[current]){
        				if(topo[e] == 0) { 
//        					topo[e] = topo[current] + 1;
        					taken++;
        					que.add(e);
        				}
        			}
        		}
        	}
        	
        }
        return  taken == numCourses;
    }
}
