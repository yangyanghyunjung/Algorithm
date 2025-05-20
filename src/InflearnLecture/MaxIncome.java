package InflearnLecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
	int fee, day;
	
	Lecture(int fee, int day){
		
		this.fee = fee;
		this.day = day;
	}

	@Override
	public int compareTo(Lecture o) {
		return o.day - this.day;
	}
}

public class MaxIncome {
	public int solution(ArrayList<Lecture> list) {
		Collections.sort(list);
		int result = 0;
		PriorityQueue<Lecture> pQ = new PriorityQueue<>(Collections.reverseOrder());
		
		pQ.offer(list.get(0));
		while(!pQ.isEmpty()) {
			Lecture tmp = pQ.poll();
			
//			if(tmp.day == )
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		MaxIncome T = new MaxIncome();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		ArrayList<Lecture> list = new ArrayList<>();
		for(int i = 0; i < N; ++i) {
			int M = sc.nextInt();
			int D= sc.nextInt();
			list.add(new Lecture(M, D));
			max = Math.max(max, D);
		}
		
		System.out.println(T.solution(list));
	}

}
