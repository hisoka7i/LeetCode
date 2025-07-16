class FiboDP {
  public int fib(int n) {
        int[] memo = new int[n];
	Arrays.fill(memo, -1);
	int answer = helperFunction(n, memo);
	return answer;
    }
  public int helperFunction(int n, int[] memo){
	if(n < 2){return n;}
	if(memo[n] != -1){return memo[n];}

	memo[n] = helperFunction(n - 1, memo) + helperFunction(n - 2, memo);
	return mem[n];
}

	public int fiboUsingTabulation(int n){

		int[] dp = new int[n+1];
		int answer = 0;
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i<=n; i++){
			dp[i] = dp[i-1] + dp[i-2];
}	
	return dp[n];
}

}
