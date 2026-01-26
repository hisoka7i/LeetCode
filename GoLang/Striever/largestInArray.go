package main

import "fmt"
func largestNumber(nums []int) int {
    max_value := nums[0]
	for _, value := range nums{
		if value > max_value {
			max_value = value;
		}
	}
	return max_value;
}

func main(){
	fmt.Println(largestNumber([]int{2,23,33,3}))
}