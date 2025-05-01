package InflearnLecture;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
	public String solution(char[] arr1, char[] arr2) {
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < arr1.length; ++i) {
			map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
			map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
		}
		
		for (char key : map1.keySet()) {
			if (map1.get(key) != map2.get(key)) {
				return "NO";
			}
		}
		
		return "YES";
	}
	
	public static void main(String[] args) {
		Anagram T = new Anagram();
		Scanner sc = new Scanner(System.in);
		char[] arr1 = sc.next().toCharArray();
		char[] arr2 = sc.next().toCharArray();
		if (arr1.length != arr2.length) {
			System.out.print("NO");
		} else {
			System.out.print(T.solution(arr1, arr2));
		}
		
	}

}
