/*
 Reverse Words in a String II

Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array

Update (2017-10-16):
We have updated the function signature to accept a character array, so please reset to the default code definition by clicking on the reload button above the code editor. Also, Run Code is now available!  
 */
public class ReverseWordsinAStringII {

    public static void reverseWords(char[] str) {
        
        int i=0;
        for(int j=0;j<str.length;j++){
            if(str[j] == ' '){
               reverseWord(str,i, j-1);
                i=j+1;
            }
        }
        reverseWord(str, i,str.length-1);
        
        reverseWord(str, 0 , str.length-1);
    }
    
    public static void reverseWord(char[] str,int i,int j){
    while(i<j){
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
        i++;
        j--;
    }
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		reverseWords(s.toCharArray());
		System.out.println(s);
	}

}
