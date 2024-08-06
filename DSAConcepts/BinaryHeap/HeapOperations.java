package BinaryHeap;

public class HeapOperations {
    private int count;
    private int[] array;

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

    /**/
}
