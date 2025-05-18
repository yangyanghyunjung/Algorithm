package InflearnLecture;

import java.util.ArrayList;
import java.util.Scanner;

class Person{
	int ht, wt;
	
	Person(int ht, int wt){
		this.ht = ht;
		this.wt = wt;
	}
}


public class CireumPlayer {

	public static int solution(ArrayList<Person> list, int N) {
		int result = N;
		list.sort((a, b) -> Integer.compare(b.ht, a.ht));

		int i = 0;
		while(true) {
			if(list.get(i).wt > list.get(i + 1).wt) {
				list.remove(i + 1);
				result--;
			} else {
				i++;
			}
			
			if(i == list.size() - 1) {
				break;
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
