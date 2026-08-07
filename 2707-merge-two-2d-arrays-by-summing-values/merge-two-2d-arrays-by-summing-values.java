class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0 , j = 0;
        while(i< nums1.length && j<nums2.length) {
            // same id
            if(nums1[i][0] == nums2[j][0]) {
                list.add(new int[] {
                    // id is at [i][0] , and values at index [i][1] & [j][1]
                    nums1[i][0] , nums1[i][1]+ nums2[j][1]
                });
                i++;
                j++;
            }

            //nums1 id is smaller
            // means we have to first add nums1[i] as it is since it is different
            else if(nums1[i][0] < nums2[j][0]) {
                list.add(new int[] {
                    nums1[i][0], nums1[i][1]
                });
                i++;
            }
            //nums2 id is smaller so we have to add nums2[j] as it is since it is different
            else {
                list.add(new int[] {
                    nums2[j][0] , nums2[j][1]
                });
                j++;
            }
        }
        //if length kisi ek ki khtm ho gyi and we stopped comparing so add remaining elements
        while(i<nums1.length) {
            list.add(new int[]{
                nums1[i][0] , nums1[i][1]
            });
            i++;
        }
        
        //remaining rows of nums[2]
        while(j<nums2.length) {
            list.add(new int[]{
                nums2[j][0] , nums2[j][1]
            });
            j++;
        }
        //convert arraylist to int[]
        int[][] ans = new int[list.size()][2];
        for(int k = 0 ; k<list.size() ; k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}

/* 
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> List = new ArrayList<>(); //since list will be like [1,2]
        int i = 0 , j = 0;
        while(i<nums1.length && j<nums2.length) {
            // comparing id's
            if(nums1[i][0] == nums2[j][0]) {
                int id = nums1[i][0];
                int value = nums1[i][1]+ nums2[j][1];
                // now add thi one row to the list
                List.add(new int[]{id , value});
                i++;
                j++;
            }
            //since it is arranged in ascending order (it will never find it in nums2)
            else if(nums1[i][0]< nums2[j][0]) {
                List.add(nums1[i]);
                i++;
            }
            else {
                List.add(nums2[j]);
                j++;
            }
        }
        //if nums1 still has rows
        while(i<nums1.length) {
            List.add(nums1[i]);
            i++;
        }
        //if nums2 still has rows
        while(j<nums2.length) {
            List.add(nums2[j]);
            j++;
        }
        int[][] ans = new int[List.size()][2];
        for(int k = 0 ; k<List.size() ; k++) {
            ans[k] = List.get(k);
        }
        return ans;
    }
} */
