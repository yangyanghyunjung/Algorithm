package InflearnLecture;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {
	public static int solution(int N, int M, int[] arr) {
		int result = 0;
		int lt = Arrays.stream(arr).max().getAsInt(); // max()는 Optional<Integer> 반환
		int rt = Arrays.stream(arr).sum();
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			// 검증 (mid <= sum) 인가?
			int cnt = 1; // 무조건 한개는 필요하니까
			int sum = 0;
			
			for(int i = 0; i < N; ++i) {
				sum += arr[i];
				if(sum > mid) {
					cnt++; // 이제부터 새 앨범이 필요
					sum = arr[i]; // sum = 0; i-- 할 필요 없음
				}
				
			}
			if(cnt <= M) {
				result = mid;
				rt = mid - 1;
			} else {
				lt = mid + 1;
			} 
		}
		
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; ++i) {
			arr[i] = sc.nextInt();
		}
		System.out.print(solution(N, M, arr));
	}

}
