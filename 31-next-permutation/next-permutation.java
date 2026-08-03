class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>= 0 && nums[i]>= nums[i+1]) {
            i--;
        }
        //step 2 : if pivot exists , find next greater element ( we'll traverse now j also from right side )
            if(i>= 0 ) {
            int j = nums.length-1;
            //the first we will get from traversing right to left will be the shortest one ( cuz after pivot no are in decreasing order)
            while(nums[j]<= nums[i]) {
                j--;
            }
             swap(nums , i , j);
            //Reverse the Suffix => now to make it smallest so reverse whole array after pivot
            }
            reverse(nums , i+1 , nums.length-1);
        }
    

    public void swap(int[] arr , int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // We need a real reverse method also
    public void reverse(int[] arr , int left , int right) {
        while(left<right) {
            swap(arr , left , right);
            left++;
            right--;
        }
    }
    
}

//Note - 
/*
if (i >= 0) {
    ...
    swap(nums, i, j);

    reverse(nums, i + 1, nums.length - 1);
}

Suppose the input is:
[3,2,1]

There is no pivot.
Then:
i = -1
The if block won't execute.
But the problem expects:
[1,2,3]
So reverse() must be outside the if block.



while(nums[j] <= nums[i]) {
    j--;
    reverse(nums, i, j);   // ❌ Wrong
}

reverse() should not be here.
This loop's only job is to find j.

It should be:

while(nums[j] <= nums[i]) {
    j--;
}

After the loop ends, swap the pivot with j.

reverse(nums, i, j);   // Actually this should be swap() */