import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //sort first two pointer works on sorted array
        Arrays.sort(nums);

        for(int i = 0 ; i<nums.length-2 ; i++) { //n-2 cuz we nee two value more when it will reach n-2
          
           //skip dublicates first since we don't need duplicates
        if(i>0 && nums[i]== nums[i-1]) {
            continue;  //skip it
        }
            //now it will be like two sum only
            int l = i+1;
            int r = nums.length-1;

            while(l<r) {
                int sum = nums[i] +nums[l] +nums[r];

                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l] , nums[r]));
                

                //skip duplicates in l and r also
                while(l<r && nums[l]== nums[l+1]) {
                    l++;
                }
                while(l<r && nums[r] == nums[r-1]) {
                    r--;
                }
                l++;
                r--;
            }
            else if(sum<0 ) {
                l++;
            }
            else {
                r--;
            }
        }
  
        }

       return res; 

    }
}

/* 
Step 1: Fix one element
The for loop fixes one element.
Suppose:
i = 1
So,
nums[i] = -1
Now we need two more numbers to make the sum 0.

Step 2: Why l = i + 1?
We have already chosen the element at index i.
The next two numbers must come after it, otherwise we would reuse the same elements or generate duplicate combinations.
So we start
l = i + 1;
which is
i = 1
l = 2
r = 5
-4  -1  -1   0   1   2
     i    l           r
Now check
-1 + (-1) + 2 = 0
Triplet found! */

/*
Let's use an example.
nums = [-4, -1, -1, 0, 1, 2]
For i
Suppose you're at:
Index: 0   1   2   3   4   5
Value:-4  -1  -1   0   1   2
          ↑
          i = 1
You process all triplets starting with the first -1.
Later, the for loop does i++.
Now:
Index: 0   1   2   3   4   5
Value:-4  -1  -1   0   1   2
              ↑
              i = 2
Now ask yourself:
Has the previous -1 already been processed?
✅ Yes.
So if you process this -1 again, you'll produce the same triplets.
That's why we check:
nums[i] == nums[i - 1]
We are asking:
"Has this value already been processed as the first element?"
If yes, skip it.
Why not compare with i + 1?
Imagine this:
Index: 0   1   2   3
Value:-1  -1   0   1
      ↑
      i = 0
If you compare with the next value:
if (nums[i] == nums[i + 1])
    continue;
Then you'll skip the first -1, which is wrong!
You would never process -1 at all.
Instead, we want:
✅ Process the first occurrence.
❌ Skip the second, third, ... occurrences.
That's exactly what comparing with the previous element achieves.
Compare with l
For l, the situation is different.
When you've already found a triplet:
-1   0   0   0   2
     ↑
     l
You're not deciding whether to process l.
You've already processed it.
Now you're simply trying to jump over the duplicates ahead.
That's why you compare with l + 1.
The difference in one sentence
i: "Has this value already been processed before?" → compare with previous (i - 1).
l: "Am I about to move onto another identical value?" → compare with next (l + 1).
r: "Am I about to move onto another identical value?" → compare with previous (r - 1).
So although both i and l move to the right, their purpose is different:
i is deciding whether to start processing a value.
l is already done processing and is skipping duplicates before moving forward.
That difference is why the comparisons are different. */

/* 
Why don't we close the if immediately after res.add()?
Because everything below should happen only when sum == 0.
Think of the if block like this:
"If I found a valid triplet, what all should I do?"
The answer is:
✅ Add the triplet.
✅ Skip duplicate values of l.
✅ Skip duplicate values of r.
✅ Move both pointers.
All four steps belong to the same situation (sum == 0), so they are kept inside the same {} block.
    */

/*
Suppose after sorting we have:
nums = [-2, 0, 0, 0, 2, 2]

You fixed:

i = -2

So

l = 0
r = 2

Current pointers:

-2   0   0   0   2   2
 ↑   ↑           ↑
 i   l           r

Sum:

-2 + 0 + 2 = 0

You found one triplet:

[-2, 0, 2]

You add it to the answer.

Now what happens if you DON'T skip duplicates?

Suppose you only do:

l++;
r--;

Now:

-2   0   0   0   2   2
 ↑       ↑   ↑
 i       l   r

Now:

-2 + 0 + 2 = 0

Again!

You will again add

[-2,0,2]

Now your answer becomes

[
 [-2,0,2],
 [-2,0,2]
]

Duplicate! ❌

Again

l++;
r--;

Now

-2   0   0   0   2   2
 ↑           ↑
 i           l
         r

Again

-2 + 0 + 2 = 0

Again duplicate.

That's why we skip duplicates.

After finding one valid triplet:

while(l < r && nums[l] == nums[l + 1]) {
    l++;
}

means

Skip all repeated values on the left.

Similarly

while(l < r && nums[r] == nums[r - 1]) {
    r--;
}

means

Skip all repeated values on the right.

Then finally

l++;
r--;

moves to the next different numbers. */
