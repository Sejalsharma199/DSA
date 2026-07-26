class Solution {
    public void moveZeroes(int[] nums) {
        int insertposition = 0 ;
        for(int i = 0 ; i <nums.length ; i++) {
            //first fill all non zero numbers
            if(nums[i] != 0) {
                nums[insertposition] = nums[i];
                insertposition++;
            }
        }
            //then jitni orignal length hai wha tk zeros fill krdo
            while(insertposition<nums.length) { //kyunki it should start inserting 0 na jha last non zero insert kiya tha uske baad se so
                nums[insertposition] = 0 ;
                insertposition++;
            }
        
    }
}