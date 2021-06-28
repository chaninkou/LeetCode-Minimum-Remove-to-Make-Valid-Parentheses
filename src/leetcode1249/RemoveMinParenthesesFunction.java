package leetcode1249;

import java.util.Stack;

public class RemoveMinParenthesesFunction {
  
    // Use * to remove using regular expression
    public String minRemoveToMakeValid2(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '('){
                stack.push(i);
            } else if (sb.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(), '*');
        }
        
        // REPLACED * with empty
        return sb.toString().replaceAll("\\*", "");
    }
    
    // Check right to left method without using stack
    public String minRemoveToMakeValid3(String s) {
        StringBuilder sb = new StringBuilder();

        int numOfDeletion = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                numOfDeletion++;
            } else if (s.charAt(i) == ')'){
            	// If 0, don't add anything
                if(numOfDeletion == 0){
                    continue;
                } else {
                    numOfDeletion--;
                }
            }
            
            sb.append(s.charAt(i));
        }
        
        StringBuilder result = new StringBuilder();

        for(int i = sb.length() - 1; i >= 0; i--){
        	// numOfDeletion will be the number need to be deleted
            if(sb.charAt(i) == '(' && numOfDeletion > 0){
                numOfDeletion--;
                continue;
            }
            result.append(sb.charAt(i));
        }
        
        // reverse after then we did add from right to left
        return result.reverse().toString();
    }
    
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '('){
                stack.push(i + 1);
            } else if (sb.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() >= 0){
                    stack.pop();
                } else {
                    stack.push(-(i + 1));
                }
            }
        }
        
        StringBuilder result = new StringBuilder();

        for(int i = 0, j = 0; i < sb.length(); i++){
            if(j >= stack.size() || i != Math.abs(stack.elementAt(j)) - 1){
                result.append(sb.charAt(i));
            } else {
                j++;
            }
        }
        
        return result.toString();
    }
}
