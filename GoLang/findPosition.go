package main

func findPosition(arr []int, index int, target int) int {
	if index == len(arr)-1 {
		return -1
	}
	if target == arr[index] {
		return index
	}
	return findPosition(arr, index+1, target)
}
