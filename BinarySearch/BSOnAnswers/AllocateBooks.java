//This is a extremely important question
//Try to understand this any how

import java.util.ArrayList;
import java.util.Collections;

public class AllocateBooks{
    public static void main(String[] args){

    }

    //Every student should be minimum 1 book
    //1 book to one student
    //allocation in contiguous manner
    //Maximum number of pages assigned to a student is minimum

    //Solution //
    //1. find the maximum in the array, this will become the maximum that a student can hold, //
        // with this logic we can assign atleast one book to one student, //
        // if the number of books and number of students are same then this will simple allote one book to one student
        // else if students are less we have the assign the remaining number of pages to the students //
        //Example if number of student is 1 then, max pages is sum of all the books pages, if number of student is similar tu the array size the max of array will become max number of pages//
        //This range will become our low and high

    
        //Based on the number of students we can implement binary search using the above logic //

        public static int findPages(ArrayList<Integer> arr,int n, int m){
            if (m>n)
                return -1;
            int low = Collections.max(arr);
            int high = arr.stream().mapToInt(Integer::intValue).sum();

            while(low<=high){
                int mid = low + (high-low)/2;
                int students = countStudent(arr, mid);
                if(students>m){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return low;
        }
        //This is the function using which we will check how many students will get the books
        public static int countStudent(ArrayList<Integer> arr,int pages){
            int n = arr.size();
            int students = 1;
            long pagesStudent = 0;
            for(int i=0;i<n;i++){
                if(pagesStudent + arr.get(i)<= pages){
                    //adding pages to current student
                    pagesStudent += arr.get(i);
                }else{
                    students++;
                    pagesStudent = arr.get(i);
                }
            }
            return students;
        }
    
}