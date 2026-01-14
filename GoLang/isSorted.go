package main

func isSorted(sample []int, index int) bool {
	if index == len(sample)-1 {
		return true
	}
	return sample[index] < sample[index+1] && isSorted(sample, index+1)
}
