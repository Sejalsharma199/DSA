class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length-3 ; i++) {
            //skip duplicate i
            if(i> 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for(int j = i+1 ; j<nums.length-2 ; j++) {
                if(j>i+1 && nums[j]== nums[j-1]) {
                    continue;
                }
                int l = j+1;
                int r = nums.length-1;
                while(l<r) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l],nums[r]));

                        while(l<r && nums[l]== nums[l+1]) {
                            l++;
                        }
                        while(l<r && nums[r]== nums[r-1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                    else if(sum<target) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}

/*
Suppose after finding a triplet
nums = [-2, 0, 0, 0, 2, 2]

Current pointers:

Index : 0 1 2 3 4 5
Value :-2 0 0 0 2 2
       ↑ ↑       ↑
       i l       r

We found

-2 + 0 + 2 = 0

and added

[-2,0,2]
Step 1: Skip duplicate left values
while(l < r && nums[l] == nums[l + 1])
    l++;

Let's dry run.

Initially

l = 1

Compare

nums[1] = 0
nums[2] = 0

Same

Move

l = 2

Again

nums[2] = 0
nums[3] = 0

Same

Move

l = 3

Now

nums[3] = 0
nums[4] = 2

Different

Stop.

Notice something?

l is still pointing to the last duplicate (index 3).

It has not moved to the next new value yet.

Step 2: Skip duplicate right values

Similarly

r = 5

Compare

nums[5]=2
nums[4]=2

Same

Move

r = 4

Now

nums[4]=2
nums[3]=0

Different

Stop.

Again,

r is still on the last duplicate (index 4).

Step 3: Now do
l++;
r--;

Now

l = 4
r = 3

So both pointers move past the duplicates to continue searching.*/