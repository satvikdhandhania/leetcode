/*
Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh". 
*/
public class reverseAString {
	public static String reverseString(String s) {
		char[] str = s.toCharArray();
		int len = s.length()-1;
		int i=0;
		char c;
		while(i<len){
			c = str[i];
			str[i] = str[len];
			str[len] = c;
			i++;
			len--;
		}
		return String.valueOf(str);
	}
	public static void main(String[] args){
		System.out.println(reverseString("hello"));
	}
}
