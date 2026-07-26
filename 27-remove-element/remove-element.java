class Solution {
    public int removeElement(int[] nums, int val) {
       int k = 0;
       for(int i = 0 ; i<= nums.length-1 ; i++){
        if(nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
       }
       return k ;
    }
}

/* 
You're following the correct pattern (while i<j) (similar to Move Zeroes and Remove Duplicates), but for this problem you only need one scanning pointer (i) and one writing pointer (k). There's no need for a second pointer from the end.
*/