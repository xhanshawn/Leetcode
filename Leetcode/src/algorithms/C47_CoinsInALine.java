package algorithms;

public class C47_CoinsInALine {
	
	
	/**
	 * dynamic programming solution 
	 * learned from Leetcode clean code solution
	 * 
	 * Ai, Ai+1, .........Aj-1, Aj
	 * 
	 * A is each coin 
	 * P(i, j) max coins can get from Ai to Aj
	 * 
	 * if take Ai, opponent may take Ai+1. Aj,     Pi = Ai + min(P(i+2, j), P(i+1, j-1))
	 * if take Aj, opponent may take Ai, Aj-1,     Pj = Aj + min(P(i+1, j), P(i, j-2))
	 *
	 * So P(i, j) is max(Pi, Pj)
	 */

	final private int MAX_N = 100;
	
	public int maxMoney(int A[], int N) {
		int[][] P = null;
		P[MAX_N][MAX_N] = 0;
		int a, b, c;
		for(int i=0; i<N; i++) {
			for(int m=0, n=i; n<N; m++, n++){
				assert(m<N); assert(n<N);
				
				a = ((m+2 <= N-1) ? P[m+2][n] : 0);
				b = ((m+1 <= N-1 && n-1 >= 0) ? P[m+1][n-1] : 0);
				c = ((n-2 >= 0) ? P[m][n-2] : 0);
				P[m][n] = Math.max(A[m] + Math.min(a,b), A[n] + Math.min(b,c));
			}
		}
		
		//printMoves(P, A, N);
		
		return P[0][N-1];
	}
	
	
	public int getMax(int[] coins) {
		
		return maxEach(0, coins.length-1, coins);
	}
	
	private int maxEach(int b, int e, int[] coins) {
		
		if(b>e) return 0;
		
		return Math.max(coins[b] + Math.min(maxEach(b+2, e, coins), maxEach(b+1, e-1, coins)),
				coins[e] + Math.min(maxEach(b+1, e-1, coins), maxEach(b, e-2, coins)));
	}
	
}
