package InflearnLecture;

import java.util.Scanner;
import java.util.Stack;

public class RightParentheses {
	public String solution(char[] arr) {
		String result = "YES";
		Stack<Character> stack = new Stack<>();
		
		for(char c : arr) {
			if(c == '(') {
				stack.push(c);
			} else {
				if(stack.isEmpty()) {
					return "NO";
				}
				stack.pop();
			}
		}
		if(stack.size() != 0) {
			return "NO";
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		RightParentheses T = new RightParentheses();
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		System.out.print(T.solution(arr));
	}

}
