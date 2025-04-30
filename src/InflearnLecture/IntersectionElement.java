package InflearnLecture;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class IntersectionElement {
	public List<Integer> solution(int na, int mb, int[] a, int[] b){
		List<Integer> result = new ArrayList<>();
		
/*		오름차순 sort
		Arrays.sort(a);
*/		
		// sort (Insertion)
		for (int i = 1; i < na; ++i) {
			int j = i - 1;
			int key = a[i];
			while(j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
		for (int i = 1; i < mb; ++i) {
			int j = i - 1;
			int key = b[i];
			while(j >= 0 && b[j] > key) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = key;
		}
		// TwoPointer 공통 원소
		int i = 0, j = 0;
		while (i < na && j < mb) {
			if (a[i] == b[j]) {
				result.add(a[i]);
				i++; j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		IntersectionElement T = new IntersectionElement();
		Scanner sc = new Scanner(System.in);
		int na = sc.nextInt();
		int[] a = new int[na];
		for (int i = 0; i < na; ++i) {
			a[i] = sc.nextInt();
		}
		int mb = sc.nextInt();
		int[] b = new int[mb];
		for (int i = 0; i < mb; ++i) {
			b[i] = sc.nextInt();
		}
		for(int i : T.solution(na, mb, a, b)) {
			System.out.print(String.format("%d ", i));
		}
	}

}
