class Solution {
    public void sortColors(int[] nums) {
        int start = 0 ;
        int mid = 0 ;
        int end = nums.length-1;
        
        while(mid<= end) {
            switch(nums[mid]) {

                case 0:
                swap(nums , start , mid) ;
                start++;
                mid++;
                break;

                case 1:
                mid++;
                break;

                case 2:
                swap(nums , mid , end);
                end--;
                break;
                
            }

        }
    }
    public void swap(int[] arr , int pos1 , int pos2) {
                int temp = arr[pos1];
                arr[pos1] = arr[pos2];
                arr[pos2] = temp;
            }
}
  

/*
Why mid <= end and not mid < end?
Suppose there is one unknown element left.
Example:
0 0 1 2
      ^
     mid
      ^
     end
Here
mid = end
There is still one element that hasn't been processed.
If you write:
while (mid < end)
then when mid == end, the loop stops.
That last element is never checked, which can give the wrong answer.
*/

/*
Why we are doing mid<= end ( mid only not start ) and switch (nums[mid]) and not start

This is the main idea of the Dutch National Flag algorithm. Once you understand the role of each pointer, it becomes very easy.
The role of each pointer
start = 0;
mid = 0;
end = n - 1;
They have different jobs.

start
0 ..... start-1
Everything before start is already confirmed to be 0.
So start points to the first position where the next 0 should be placed.
It is not searching.

end
end+1 ..... n-1
Everything after end is already confirmed to be 2.
So end points to the first position where the next 2 should be placed.
It is not searching.

mid
mid ..... end
This is the unknown region.
Only mid moves through the array and checks every unknown element.
*/