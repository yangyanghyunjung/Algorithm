package InflearnLecture;

import java.util.HashMap;
import java.util.Scanner;

public class FindAllAnagram {
	public int solution(char[] S, char[] T) {
		HashMap<Character, Integer> Tmap = new HashMap<>();
		HashMap<Character, Integer> Smap = new HashMap<>();
		for (char c : T) {
			Tmap.put(c, Tmap.getOrDefault(c, 0) + 1);
		}
		for(int i = 0; i < T.length - 1; ++i) {
			Smap.put(S[i], Smap.getOrDefault(S[i], 0) + 1);
		}
		
		int left = 0, cnt = 0;
		for (int right = T.length - 1; right < S.length; ++right) {
			char rightVal = S[right];
			char lefttVal = S[left];
			
			Smap.put(rightVal, Smap.getOrDefault(rightVal, 0) + 1);
			if(Smap.equals(Tmap)) {
				cnt++;
			}
			Smap.put(lefttVal, Smap.get(lefttVal) - 1);
			if(Smap.get(lefttVal) == 0) {
				Smap.remove(lefttVal);
			}
			left++;
			
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		FindAllAnagram main = new FindAllAnagram();
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();
		char[] T = sc.next().toCharArray();
		System.out.print(main.solution(S, T));

	}

}
