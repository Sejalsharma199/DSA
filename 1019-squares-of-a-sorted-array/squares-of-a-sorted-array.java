class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0 , j = nums.length-1 , k = nums.length-1;
        int[] arr = new int[nums.length];
        while(i<=j){
            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];
            if(a<b) {
                arr[k] = b;
                j--;
            }
            else {
                arr[k] = a;
                i++;
            }
           k--;
        }
        return arr;
    }
}

/* 
3. You're writing at the wrong index ❌
You write:
arr[j] = ...
This is not how this problem works.
The largest square should be placed at the end of the answer array.
So you need another pointer:
int k = nums.length - 1;
After placing an element:
k--;

4. Wrong pointer movement ❌
Currently you do:
i++;
j--;
every iteration.
That is incorrect.

If
a > b
then:
put a in the answer
move only i++

Otherwise:
put b
move only j--
Only one pointer should move in each iteration. */