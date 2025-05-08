package InflearnLecture;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point>{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o){
		if(this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}


public class CoordinateSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Point[] point = new Point[N];
		
		for (int i = 0; i < N; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			point[i] = new Point(x, y);
		}
		Arrays.sort(point);
		
		for (int i = 0; i < N; ++i) {
			System.out.printf("%d %d\n",point[i].x, point[i].y); 
		}
		
	}

}
