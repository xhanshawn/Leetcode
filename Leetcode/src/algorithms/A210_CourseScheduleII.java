package algorithms;

import java.util.ArrayList;

public class A210_CourseScheduleII {
	
	int[] deg;
	ArrayList<Integer> finished = new ArrayList<Integer>();
	
	public static void main(String[] args) {
//		int[][] pre = new int[][] {{1,0},{2,1}};
		
		int[][] pre = new int[][] {{0,1}};

		A210_CourseScheduleII a210 = new A210_CourseScheduleII();
		
		int[] aft = a210.topoSort(2, pre);
		if(aft.length == 0) System.out.println("fuck");
		else {
			for(int x : aft) {
				System.out.println(x +" ");
			}
		}
	}
	
	
	//accepted solution dfs and topo sort
	public int[] topoSort(int n, int[][] edges){
		ArrayList<Integer>[] maps = new ArrayList[n];
		
		for(int i=0; i<edges.length; i++) {
			if(maps[edges[i][1]] == null) maps[edges[i][1]] = new ArrayList<Integer>();
			maps[edges[i][1]].add(edges[i][0]);
		}
		deg = new int[n];
		for(int i=0; i<n; i++) {
			if(deg[i] == 0) {

				dfs(i, maps);
			}
		}
		int[] result = new int[finished.size()];
		if(finished.size() < n) return new int[] {};
		for(int i=finished.size()-1; i>=0; i--) {
			result[finished.size()-1-i] = finished.get(i);
		}
		
		return result;
	}
	
	private void dfs(int i, ArrayList<Integer>[] maps) {
		System.out.println(i + " ");
		deg[i] = -1;
		if(maps[i] != null) {
			for(int e : maps[i]) {
				if(deg[e] == 0) dfs(e, maps);
				else if(deg[e] == -1) return;
			}
		}
		
		deg[i] = 1;
		finished.add(i);
	}
	
}
