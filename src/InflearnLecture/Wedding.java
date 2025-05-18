package InflearnLecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class M_Time implements Comparable<M_Time>{
	int t; char flag;
	
	M_Time(int t, char flag){
		this.t = t;
		this.flag = flag;
	}

	@Override
	public int compareTo(M_Time o) {
		if(t == o.t) {
			return flag - o.flag;
		}
		
		return t - o.t;
	}		
		
}

public class Wedding {
	public int solution(ArrayList<M_Time> list, int N) {
		int max = 0;
		int cnt = 0;
		Collections.sort(list);
		
		for(M_Time x : list) {
			if(x.flag == 's') {
				cnt++;
				max = Math.max(max, cnt);
			} else {
				cnt--;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Wedding T = new Wedding();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<M_Time> list = new ArrayList<>();
		
		for(int i = 0; i < N; ++i) {
			list.add(new M_Time(sc.nextInt(), 's'));
			list.add(new M_Time(sc.nextInt(), 'e'));
		}
		
		System.out.println(T.solution(list, N));
		
	}

}
