package sorting

func insertionSort(unsortedArray []int) []int {
	for i := 1; i < len(unsortedArray); i++ {
		currentvalue := unsortedArray[i]
		j := i - 1
		for j >= 0 && unsortedArray[j] > currentvalue {
			unsortedArray[j+1] = unsortedArray[j]
			j--
		}
		unsortedArray[j+1] = currentvalue
	}
	return unsortedArray
}
