package InflearnLecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
	int s, e;
	
	Time(int s, int e){
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Time o) {
		if(e == o.e) {
			return s - o.s;
		}
		return e - o.e;
	}
}

public class MeetingRoomAssignment {

	public int solution(ArrayList<Time> list, int N) {
		int max = Integer.MIN_VALUE;
		int cnt = 1;
		
		int curEnd = list.get(0).e;
			for(int j = 0; j < N; ++j) {
				if(curEnd <= list.get(j).s) {
					cnt++;
					curEnd =  list.get(j).e;
				}
			}
			max =cnt;
		
		return max;
	}
	
	public static void main(String[] args) {
		MeetingRoomAssignment T = new MeetingRoomAssignment();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Time> list = new ArrayList<>();
		
		for(int i = 0; i < N; ++i) {
			list.add(new Time(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list);
		
		System.out.println(T.solution(list, N));
	}
}
