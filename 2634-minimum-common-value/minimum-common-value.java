class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0 ; int j = 0 ;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] == nums2[j]) {
                return nums1[i];
            }
            // since nums1[i] chota hai toh ye kabhi toh bn he nai payega nums[2] ke next ke side bhi so it is better to move i
            else if(nums1[i] < nums2[j]) {
                i++; 
            }
            else {
                j++;
            }
        }
        return -1;
    }
}