package main

import "fmt"

func runFibo(n int){
	i := 0
	for i <= n {
		fmt.Printf("%d ",fibo(i))
		i++
	}
}

func func(n int){
	if(n == 1 || n == 0){
		return 1;
	}
	return fibo(n-2)+fibo(n-1);
}