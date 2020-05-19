package leetcode1249;

public class Main {
	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		
		System.out.println("Input: " + s);
		
		RemoveMinParenthesesFunction solution = new RemoveMinParenthesesFunction();
		
		System.out.println("Solution: " + solution.minRemoveToMakeValid(s));
	}
}
