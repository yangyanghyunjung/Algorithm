package InflearnLecture;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParentheses {
	public String solution(char[] arr) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (char c : arr) {
			if(c == ')' && stack.size() > 0) {
				while(stack.pop() != '(');
			} else {
				stack.push(c);
			}
		}
		for (int i = 0; i < stack.size(); ++i) {
			result.append(stack.get(i));
		}
		
		return result.toString();
	}
	public static void main(String[] args) {
		RemoveParentheses T = new RemoveParentheses();
		Scanner sc  = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		
		System.out.print(T.solution(arr));
	}

}
