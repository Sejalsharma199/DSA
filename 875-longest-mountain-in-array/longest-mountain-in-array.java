class Solution {
    public int longestMountain(int[] arr) {
        boolean peak = false;
        boolean valley = false;
        int i = 0 ;
        int j = arr.length-1;
        int res = 0 ;
        while(i<j) { 
           if(arr[i]<arr[i+1]) { //first we have to climb only
            int start = i ;
            while(i<j && arr[i]<arr[i+1]) {
                peak = true;
                i++;
            }
            while(i<j && arr[i]>arr[i+1]) {
                valley = true;
                i++;
            }
            if(peak == true && valley == true){
                res = Math.max(res , i-start+1);
            }
            peak = false; //reset the value for starting new mountain 
            valley = false;
           } 
           else {
            i++; //agr increasing nai h toh first find jha increasing hoga
           }
        }
        return res;
    }
}

/* 

 Why i - start + 1?
Suppose the mountain is:
1 2 3 4 3 2 1
Indices:
0 1 2 3 4 5 6
When the mountain starts:
start = 0;
After climbing and descending, i reaches:
i = 6;
The mountain length is:
Last index - First index + 1
= 6 - 0 + 1
= 7
That's why we write:
res = Math.max(res, i - start + 1);


2. Why two while loops?
A mountain has two phases:
Increasing
      /\
     /  \
    /    \
Decreasing
First while → Climb up
while(i < j && arr[i] < arr[i+1]) {
    peak = true;
    i++;
}
This loop keeps moving as long as the numbers are increasing.
Example:
1 2 3 4
It stops at the peak (4).

Second while → Climb down
while(i < j && arr[i] > arr[i+1]) {
    valley = true;
    i++;
}
Now it moves while the numbers are decreasing.
Example:
4 3 2 1
This reaches the end of the mountain.

3. Why the if after the two whiles?
if(peak == true && valley == true)
This checks whether we found a valid mountain.
A valid mountain must have:
✅ At least one increasing step.
✅ At least one decreasing step.

Only then do we calculate its length.
Example 1
1 2 3 4 3 2
Increasing ✔
Decreasing ✔
Valid mountain.
Example 2
1 2 3 4
Increasing ✔
Decreasing ✖
Not a mountain.
Example 3
5 4 3 2
Increasing ✖
Decreasing ✔
Not a mountain. */