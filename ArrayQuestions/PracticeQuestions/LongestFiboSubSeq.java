public class LongestFiboSubSeq {

//I went on a completely wrong tangent
 public int lenLongestFibSubseq(int[] arr) {
	int n = arr.length;
        int[] febo = new int[arr[n-1]];
	febo[0] = 0;
	febo[1] = 1;
	List<Integer> sample = Arrays.asList(arr);
	int count = 0;
	for(int i = 2; i <= arr[n-1]; i++){
		febo[i] = febo[i-1] + febo[i-2];
		if(sample.contains(febo[i-2])){
			febo[i-2] = -1;
		}
		count++;
		if(febo[i] > arr[n-1]){break;}
	}
	//now we need
	int max_length = Integer.MIN_VALUE;
	int count = 0; 
	for(int i = 0; i< count; i++){
		if(arr[i] == -1 && arr[i+1] == -1){
		count++;
		max_length = Math.max(count, max_length); 
		}else{count = 0;}
	}
	return max_length == Integer.MIN_VAUE ? 0 : max_length;
    }
	int max_count = Integer.MIN_VALUE;
	public int lenLongestFibSubSeq(int[] arr){
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<n ; i++){
			map.put(arr[i] , i);
		}
		Set<Integer> memo = new HashSet<>();
		while(n > 0){
			helper_function(arr, n-1, map, memo, 0);
			n--;
		}
		
		return max_length;
	}
	public void helper_function(int[] arr, int index, Map<Integer, Integer> map, Set<Integer> memo, int count){
		if(index == 0 || memo.contains(Integer.valueOf(arr[index])return;
		int temp_index = index - 1;
		while(temp_index > 0){
			if(map.contains(arr[index]-arr[temp_index])){
				//this means that all the 3 values are present in the array
				if(!memo.contains(Integet.valueOf(arr[index]){count++;}
				if(!memo.contains(Integer.valueOf(arr[temp_index]){count++;}
				if(!memo.contains(Integer.valueOf(arr[index]-arr[temp_index]){count++;}
				max_count = Math.max(max_count, count);
				helper_function(arr, map.get(arr[temp_index]), map, memo, count);
			}
			temp_index--;
		}
		
	}

	public int lenLongestFibSubseq(int[] arr){
	int n = arr.length;
	Set<Integer> values = new HashSet<>();
	for(int num: arr){values.add(num)};
	
	for(int i = 0; i < n - 1; i++){
		for(int j = i + 1; j < n; j++){
			int a = arr[i];
			int b = arr[j]; 
			count = 2;
			
			while(set.contains(a + b)){
			 int c = a + b;
			 a = b;
			 b = c;
			 count++;
			}
if (count >= 3) {
                    maxCount = Math.max(maxCount, count);
                }
		}
	return maxCount;
	}

}

}
