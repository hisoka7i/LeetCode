package easy

func removeDuplicates(nums []int) int {
	//need to remove duplicates from the array which means
	count := 0
	for i := 1; i < len(nums); i++ {
		if nums[count] != nums[i] {
			nums[count+1] = nums[i]
			count++
		}
	}
	return count
}
