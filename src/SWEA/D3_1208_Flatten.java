package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class D3_1208_Flatten {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[100];
			for(int i = 0; i < 100; ++i) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; ++i) {
				int max = Arrays.stream(arr).max().getAsInt();
				int min = Arrays.stream(arr).min().getAsInt();
				
			}
		}
		
	}
}
