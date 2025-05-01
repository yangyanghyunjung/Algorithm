package InflearnLecture;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
	public String solution(char[] arr1, char[] arr2) {
		int[] alphabet = new int[128]; // ASCII ÀüÃ¼
		
		for (char c : arr1) {
			alphabet[c]++;
		}
		for (char c : arr2) {
			alphabet[c]--;
		}
		for (int i : alphabet) {
			if(i != 0) {
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
