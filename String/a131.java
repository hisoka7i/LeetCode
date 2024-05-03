package String;
// import java.util.*; 
// This was a brute force
// public class a131 {
// 	static List<List<String>> res = new ArrayList<>();
//
// 	public static void main(String[] args) {
// 		String str = "bb";
// 		List<String> first = new ArrayList<>();
// 		for(int i=0;i<str.length();i++) {
// 			first.add(str.substring(i,i+1));
// 		}
// 		//System.out.println(first);
// 		res.add(first);
// 		int n = str.length();
// 		for(int i=0;i<n-1;i++){
// 			for(int j=i+1;j<n;j++){
// 				if(str.substring(i,j).length()!=1){
// 				subStringPalindrome(str.substring(i,j),str.substring(j));}
// 			}
// 		}
// 		if(palindrome(str)){
// 			List<String> temp = new ArrayList<>();
// 			temp.add(str);
// 			res.add(temp);
// 		}
// 		System.out.println(res);
// 	}
// 	static public boolean subStringPalindrome(String str1,String str2){
// 		if(palindrome(str1)&&palindrome(str2)){
// 		List<String> list = new ArrayList<>();
// 		list.add(str1);
// 		list.add(str2);
// 		res.add(list);
// 		return true;
// 	}
// 		return false;
// 	}
// 	static public boolean palindrome(String str){
// 		int n = str.length();
// 		for(int i=0;i<n/2;i++){
// 			if(str.charAt(i)!=str.charAt(n-i-1)){
// 				System.out.println("Not a palindrome");
// 				return false;
// 			}
// 		}
// 		return true;
// 	}
//
// }

import java.util.ArrayList;
import java.util.List;

class Solution {
  List<List<String>> result = new ArrayList<>();
	//we need to use DFS here
	public List<List<String>> partition(String s) {
		dfs(s,0,new ArrayList<>());
		return result;
	}
	public void dfs(String s, int start,List<String> lst){
		if(s.length()==start){
			result.add(new ArrayList<>(lst));
			return;
		}
		for(int i=start;i<s.length();i++){
			if(isPalindrome(s, start, i)){
				//agr plaindrome hoga toh next character add kr dege
				lst.add(s.substring(start,i+1));
				dfs(s,i+1,lst);
				//next line is for backtracking
				lst.remove(lst.size()-1);
			}
		}
	}
	boolean isPalindrome(String s,int start, int end){
		while(start<end){
			if(s.charAt(start)!=s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
