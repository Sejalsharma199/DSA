class Solution {
    public int removeDuplicates(int[] nums) {
         int j = 1; //since 0th index will be unique only
        for(int i = 1 ; i<nums.length ; i++) {
            if(nums[i] != nums[j-1]) {
                nums[j] = nums[i];
                j++;
            }
           /* else{
                continue;
            } */ //this is uneccesary becus when if cond is false , loop automatically goes to next iteration
        }
        return j ;
    }
}

/* Why nums[j - 1]?
Suppose:
nums = [1,1,2,2,3]
Initially:
j = 1
i = 1
nums[1] = 1
nums[j-1] = nums[0] = 1
Same → skip
i = 2
nums[2] = 2
nums[j-1] = nums[0] = 1
Different → store:
nums[1] = 2;
j++;
Now the array becomes:
[1,2,2,2,3]
The first j elements are always the unique elements. */
