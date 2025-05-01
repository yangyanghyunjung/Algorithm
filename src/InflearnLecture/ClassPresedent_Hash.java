package InflearnLecture;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresedent_Hash {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		Character result = ' ';
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : sc.next().toCharArray()) {
			int cnt = map.getOrDefault(c, 0);
			map.put(c, cnt + 1);
			if(max < cnt+ 1) {
				max = cnt + 1;
				result = c;
			}
		}
		System.out.print(result);

	}

}
