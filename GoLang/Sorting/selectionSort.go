package sorting

func selectionSort(unsortedArray []int) []int {
	for i := 0; i < len(unsortedArray)-1; i++ {
		minimumIndex := i
		for j := i + 1; j < len(unsortedArray); j++ {
			if unsortedArray[j] < unsortedArray[minimumIndex] {
				minimumIndex = j
			}
		}
		unsortedArray[i], unsortedArray[minimumIndex] = unsortedArray[minimumIndex], unsortedArray[i]
	}
	return unsortedArray
}
