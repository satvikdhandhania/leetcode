/*
First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
*/
public class FirstNonRepeatingCharacter {

	public static int firstUniqChar(String s) {
		for(int i=0;i<s.length();i++){
			boolean flag = true;
			for(int j=0;j<s.length();j++){
				if(i!=j){
					if(s.charAt(i) == s.charAt(j)){
						flag = false;
						break;
					}
				}
			}
			if(flag)
				return i;
		}
		return -1;


	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "loveleetcode";

		System.out.println(firstUniqChar(s));
	}

}
