package InflearnLecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LRU {

	public static List<Integer> solution(int size, int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < arr.length; ++i) {
			if(list.contains(arr[i])) {
				// chache hit
				list.remove(list.indexOf(arr[i]));
				list.add(arr[i]);
			} else {
				// chache miss
				list.add(arr[i]);
				if(list.size() > size) {
					list.remove(0);
				}
			}
		}
		
		return list;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		List<Integer> list = solution(size, arr);
		for(int i = size - 1; i >= 0; --i) {
			System.out.printf("%d ", list.get(i));
		}
	}

}
