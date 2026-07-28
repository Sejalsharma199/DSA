class Solution {
    public int[] sortArrayByParity(int[] nums) {
        //read point and write pointer
        int l = 0 ;
        int r = nums.length-1;
        while(l<r) {
            //even h toh whi rehndo sai jgh hai
            if(nums[l] %2 == 0 ) {
                l++;
            }
            else if(nums[r] % 2 == 0){
                swap(nums , l , r);
                l++;
                r--;
            }
            //odd hai sai jgh h whi rehndo aage mt lao
            else {
                r--;
            }
        }
        return nums;
    }
    public void swap(int[] arr , int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}