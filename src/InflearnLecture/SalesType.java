package InflearnLecture;

import java.util.HashMap;
import java.util.Scanner;

public class SalesType {

	 public void solution(int N, int k, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < k; ++i) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		sb.append(map.size()).append(" ");
		
		int LT = 0;
		for(int RT = k; RT < N; ++RT) {
			int ltVal = arr[LT];
			int rtVal = arr[RT];
			map.put(rtVal, map.getOrDefault(rtVal, 0) + 1);
			map.put(ltVal, map.get(ltVal) - 1);
			if(map.get(ltVal) == 0) {
				map.remove(ltVal);
			}
			LT++;
			sb.append(map.size()).append(" ");
		}
		System.out.print(sb.toString());
	 }
			
	public static void main(String[] args) {
		SalesType T = new SalesType();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}
		T.solution(N, k, arr);
	}
}
