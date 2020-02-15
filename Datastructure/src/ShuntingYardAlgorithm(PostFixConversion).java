
import java.util.*;
import java.lang.*;
import java.io.*;

class ShuntingYard
{

    static Stack<Character>stack = new Stack<>();
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		String s ="((a+b)*(c+d))/e";
		System.out.println(postFix(s));
		
	}
	public static String postFix(String s){
	    String res= "";
	    for(int i=0;i<s.length();i++){
	        if(s.charAt(i)>='a' && s.charAt(i)<='z'){
	            res+=s.charAt(i);
	        }else if(s.charAt(i) == '('){
	            stack.push('(');
	        }else if(s.charAt(i) == ')'){
	            while(!stack.isEmpty()&&stack.peek() != '('){
	                res+=stack.pop();
	            }
	            stack.pop();
	        }else{
	            if(!stack.isEmpty() && precedence(s.charAt(i))>precedence(stack.peek())){
	                stack.push(s.charAt(i));
	            }else{
	                while(!stack.isEmpty() && precedence(s.charAt(i))<precedence(stack.peek())){
	                    res+=stack.pop();
	                }
	                stack.push(s.charAt(i));
	            }
	        }
	    }
	    while(!stack.isEmpty()){
	        res+=stack.pop();
	    }
	    return res;
	}
	public static int precedence(char a){
	    if(a == '+' || a == '-')return 1;
	    if(a == '*' || a == '/')return 2;
	    if(a == '^')return 3;
	    return -1;
	}
}
