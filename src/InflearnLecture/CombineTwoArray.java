package InflearnLecture;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class CombineTwoArray {
	public int[] solution(int na, int nb, int[] a, int[] b) {
		int[] result = new int[na + nb];
		int resultIdx = 0;;
		
		int i = 0, j = 0;
		while (i < na || j < nb) {
			if (j == nb || i < na && a[i] <= b[j]) {
				result[resultIdx++] = a[i++];
			} 
			if (i == na || j < nb && a[i] > b[j]){
				result[resultIdx++] = b[j++];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		CombineTwoArray T = new CombineTwoArray();
		Scanner sc = new Scanner(System.in);
		int na = sc.nextInt();
		int[] a = new int[na];
		for (int i = 0; i < na; ++i) {
			a[i] = sc.nextInt();
		}
		int nb = sc.nextInt();
		int[] b = new int[nb];
		for (int i = 0; i < nb; ++i) {
			b[i] = sc.nextInt();
		}
		for (int i : T.solution(na, nb, a, b)) {
			System.out.print(String.format("%d ", i));
		}
	}

}
