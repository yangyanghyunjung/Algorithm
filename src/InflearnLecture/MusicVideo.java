package InflearnLecture;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {
	public static int solution(int N, int M, int[] arr) {
		int result = 0;
		int lt = Arrays.stream(arr).max().getAsInt(); // max()�� Optional<Integer> ��ȯ
		int rt = Arrays.stream(arr).sum();
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			// ���� (mid <= sum) �ΰ�?
			int cnt = 1; // ������ �Ѱ��� �ʿ��ϴϱ�
			int sum = 0;
			
			for(int i = 0; i < N; ++i) {
				sum += arr[i];
				if(sum > mid) {
					cnt++; // �������� �� �ٹ��� �ʿ�
					sum = arr[i]; // sum = 0; i-- �� �ʿ� ����
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
