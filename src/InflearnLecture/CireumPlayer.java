package InflearnLecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person>{
	int ht, wt;
	
	Person(int ht, int wt){
		this.ht = ht;
		this.wt = wt;
	}
	@Override
	public int compareTo(Person o) {
		return o.ht - ht; // 오름차순
	}
}


public class CireumPlayer {

	public static int solution(ArrayList<Person> list, int N) {
		int result = 0;
//		list.sort((a, b) -> Integer.compare(b.ht, a.ht)); // Comparator
		Collections.sort(list);

		int max = 0;
		for(int i = 0; i < N; ++i) {
			if(list.get(i).wt > max) {
				result++;
				max = list.get(i).wt; 
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Person> list = new ArrayList<>();
		
		for(int i = 0; i < N; ++i) {
			list.add(new Person(sc.nextInt(), sc.nextInt()));
		}
		System.out.println(solution(list, N));
	}

}
