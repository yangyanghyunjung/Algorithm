package SWEA;

import java.util.HashMap;
import java.util.Scanner;

public class D2_1204_최빈수구하기 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			String[] str = sc.nextLine().split(" ");
			HashMap<Integer, Integer> map = new HashMap<>();
			int modeCnt = 0;
			int mode = 0;
			
			for (int i = 0; i < str.length; ++i) {
				int key = Integer.parseInt(str[i]);
				int nextVal = map.getOrDefault(key, 0) + 1;
				map.put(key, nextVal);
				if (nextVal == modeCnt && key > mode) {
					mode = key;
				} else if (nextVal > modeCnt) {
					modeCnt = nextVal;
					mode = key;
				}
			}
			System.out.printf("#%d ", N);
			System.out.println(mode);
			
		}
	}
}
