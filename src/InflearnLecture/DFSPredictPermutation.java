package InflearnLecture;

import java.util.Scanner;

public class DFSPredictPermutation {
	static int n;
	static int F;
	
	static boolean bFlag = false;
	static int[] combinationArr;
	static int[][] ch_combi;
	
	static boolean[] ch_permu;
	static int[] result;
	
	public static int DfsGetCombination(int n, int r) {
		if(ch_combi[n][r] > 0) {
			return ch_combi[n][r];
		}
		if(n == r || r == 0) {
			return 1;
		}
		return ch_combi[n][r] = DfsGetCombination(n-1, r-1) + DfsGetCombination(n-1, r);
	}
	
	public static void DfsgetPermutation(int L, int sum) {
		if(bFlag) return;
		
		if(L == n) {
			if(F == sum) {
				for(int i = 0; i < n; ++i) {
					System.out.print(result[i] + " ");
				}
				bFlag = true;
			}
			return;
		}
		
		for(int i = 1; i <= n; ++i) {
			if(ch_permu[i] == false) {
				ch_permu[i] = true; 
				result[L] = i; 
				DfsgetPermutation(L + 1, sum + result[L] * combinationArr[L]);
				ch_permu[i] = false; 
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		F = sc.nextInt();
		combinationArr = new int[n];
		ch_permu = new boolean[n + 1];
		result = new int[n];
		
		for(int i = 0; i < n; ++i) {
			if(combinationArr[n-1-i] > 0) {
				combinationArr[i] = combinationArr[n-1-i];
			} else {
				ch_combi = new int[n][i + 1];
				combinationArr[i] = DfsGetCombination(n - 1, i);
			}
		}
		DfsgetPermutation(0, 0);
	}

}
