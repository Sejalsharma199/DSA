class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int officer = 0;
        int cm = 1;
        int uniquenum  = 1;
        while(cm<n) {
            //skip 
            if(nums[cm] == nums[cm-1]) {
            cm++;
            continue;
            }
        
        nums[officer +1] = nums[cm];
        officer++;
        uniquenum++;
        cm++;
        }
    
        return uniquenum;
    }
}