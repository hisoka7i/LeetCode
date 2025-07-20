class LongestCommanSubSeq {
	//brute force 
	public int BruteForce(String r, String s){
		int m = r.length();
		int n = s.length();
		int answer = helperFunction_bruteForce(r, s,m,n);
}
	public int helperFunction_bruteForce(String r, String s, int m, int n){
	//exit strategy
	if(m == 0 || n == 0){
		return 0;
	}

	if(r.charAt(m-1) == s.charAt(n-1)){
		return 1 + helperFunction_bruteForce(r,s,m-1,n-1);
	}else{
	return Math.max(helperFunction_bruteForce(r,s,m-1,n), helperFunction_bruteForce(r,s,m,n-1));
}
	//time complexity is 2^n;

}

	public int memo_helperFunction(String r, String s, int[][] memo, int m, int n){
		if(m == 0 || n == 0){ return 0;}
		if(memo[m][n] !=  -1)return memo[m][n];
		
		if(r.charAt(m-1) == s.charAt(n-1)){return memo[m][n] = 1 + memo_helperFunction(r,s,memo,m-1,n-1);}
		else{
		return memo[m][n] = Math.max(memo_helperFunction(r,s,memo,m-1,n), memo_helperFunction(r,s,memo,m,n-1));
}
		
}
}
