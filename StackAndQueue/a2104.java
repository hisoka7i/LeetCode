package StackAndQueue;

import java.util.Stack;

public class a2104 {
        public static void main(String[] args) {
            int[] nums = {1,2,3};
            subArrayRanges(nums);
        }

        //dry run this code to understand
        //very very important question
        public static long subArrayRanges(int[] A) {
        int n = A.length, j, k;
        long res = 0;
        
        Stack<Integer> s = new Stack<>();

        //This is for sum of minimums
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        int sum = 0;

        s.clear();
        //This is for sum of maximums
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                sum += (long)A[j] * (i - j) * (j - k);
                res += (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }
}
