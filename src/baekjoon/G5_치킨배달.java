package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

class chi_Dot{
	int r, c;
	
	public chi_Dot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class G5_치킨배달 {
	static int N;
	static int M;
	
	static int[][] map;
	static ArrayList<chi_Dot> storeList;
	static ArrayList<chi_Dot> houseList;
	static int minDist = Integer.MAX_VALUE;
	
	
	public static int getMinDist(ArrayList<chi_Dot> selected) {
		int sum = 0;
		
		for(chi_Dot h : houseList) {
			int hr = h.r;
			int hc = h.c;
			
			int min = Integer.MAX_VALUE;
			for(chi_Dot s : selected) {
				int sr = s.r;
				int sc = s.c;
				
				min = Math.min(min, (Math.abs(hr - sr) + Math.abs(hc - sc)));
			}
			sum += min;
		}
		
		return sum;
	}
	public static void DfsFindStore(int L, int s, ArrayList<chi_Dot> selected) {
		if(L == M) {
			int sum = 0;
				
			sum = getMinDist(selected);
				
			minDist = Math.min(minDist, sum);
			return;
		}
		
		for(int i = s; i < storeList.size(); ++i) {
			chi_Dot d = storeList.get(i);
			int r = d.r;
			int c = d.c;
			
			selected.add(new chi_Dot(r, c));
			DfsFindStore(L + 1, i + 1, selected);
			selected.remove(selected.size() - 1);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		
		
		
		storeList = new ArrayList<>();
		houseList = new ArrayList<>();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				int val = sc.nextInt();
				map[i][j] = val;
				if(val == 2) storeList.add(new chi_Dot(i, j));
				else if(val == 1) houseList.add(new chi_Dot(i, j));
			}
		}
		
		DfsFindStore(0, 0, new ArrayList<chi_Dot>());
		
		System.out.println(minDist);
		
	}

}
