package main

import "slices"

func FindDuplicates(sample []int, seen []int, duplicates []int, index int) []int {
	// Base case
	if index >= len(sample) {
		return duplicates
	}

	value := sample[index]

	// If value was seen before and not already added to duplicates, add it
	if slices.Contains(seen, value) {
		if !slices.Contains(duplicates, value) {
			duplicates = append(duplicates, value)
		}
	} else {
		// First time seeing this value
		seen = append(seen, value)
	}

	// Recurse
	return FindDuplicates(sample, seen, duplicates, index+1)
}
