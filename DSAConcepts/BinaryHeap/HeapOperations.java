package BinaryHeap;

public class HeapOperations {
    private int count;
    private int[] array;
    private int capacity;

    /*
     * for index i, parent is (i-1)/2
    */
    public int parent(int i){
        if(i <= 0 || i >= this.count){
            return -1;
        }
        return (i-1)/2;
    }

    /*
     * for index i, left child is 2*i + 1
    */
    public int leftChild(int i){
        if(i <= 0 || i >= this.count){
            return -1;
        }
        int left = (2 * i + 1);
        return left;
    }

    /*
     * for index i, right child is 2*i + 2
    */
    public int rightChild(int i){
        if(i <= 0 || i >= this.count){
            return -1;
        }
        int right = (2 * i  + 2);
        return right;
    }

    /*
     * In heapifying process, if we move from top to bottom, while rearranging
     * to keep the max heap alive, 
     * This is called percolate down
    */
    public void percolateDown(int i){
        int left, right, temp, max; 
        left = leftChild(i);
        right = rightChild(i);

        //we need to see if, element at left is greater then element at right
        if(left != -1 && this.array[left]>this.array[right]){
            max = left;
        }else{
            max = i;
        }
        //we need to see if, right element is greater than max
        if(right != -1 && this.array[right]>this.array[max]){
            max = right;
        }

        //we will check if, max is right or left -> this means that max heap is not valid
        if(max != i){
            //we will need to swap max with the parent
            //so that higher element will come on the top
            temp = this.array[max];
            this.array[max] = this.array[i];
            this.array[i] = temp;

            //we need to repeatedly do this process
            percolateDown(max);
        }
    }

    /*
     * Deleting an element from a heap
     * You swap the top element with the last element
    */
    public int deleteMax(){
        if(this.count == 0)return -1;
        int data = this.array[0];
        this.array[0] = this.array[this.count-1];
        //here we are decreasing the size of heap
        this.count--;
        //we need to heapify, from the top
        percolateDown(0);
        return data;
    }

    /*
     * Insert an element.
     * Add the element in last place, then heapify from the bottom to top
    */
    public void insertData(int data){
        if(this.count == this.capacity){
            //if heap size is already filled then we need to increase the size of heap
            resizeHeap();
        }
        int i = this.count - 1;
        //this will do heapifying process
        while(i >= 0 && data >= this.array[(i-1)/2]){
            this.array[i] = this.array[(i-1)/2];
            i = (i-1)/2;
        }
        this.array[i] = data;
    }

    private void resizeHeap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeHeap'");
    }

    /*
     * A function to check if an array is min/max heap or not
    */
    public static boolean isMinMaxHeap(int[] sample){
        boolean is_max = true;
        if(sample[0] < sample[1]){
            is_max = false;
            //means max heap
        }
        //for every index we will check if statisfy the equation or not
        for(int i=0;i<sample.length;i++){
            if(!checkForCondition(sample, i, is_max)){
                return false;
            } 
        }
        return true;
    }

    private static boolean checkForCondition(int[] sample, int i, boolean is_max) {
        // TODO Auto-generated method stub
        if((2*i + 1) >= sample.length){
            return true;
        }
        
        if(is_max){
            if(sample[i] < sample[2*i + 1]){
                return false;
            }
            if((2*i + 2) >= sample.length){
                return true;
            }
            if(sample[i] < sample[2*i + 2]){
                return false;
            }
        }else{
            if(sample[i] > sample[2*i + 1]){
                return false;
            }
            if((2*i + 2) >= sample.length){
                return true;
            }
            if(sample[i] > sample[2*i + 2]){
                return false;
            }
        }
        return true;
    }

    /*
     * Converting min heap to max heap, 
    */
    public void convertMinHeapToMaxHeap() {
        // Start from the last non-leaf node and heapify each node.
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
}
