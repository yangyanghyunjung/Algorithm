package InflearnLecture;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
	public String solution(char[] arr1, char[] arr2) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : arr1) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (char c : arr2) {
			if(!map.containsKey(c) || map.getOrDefault(c, 0) == 0) {
				return "NO";
			}
			map.put(c, map.get(c) - 1);
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
