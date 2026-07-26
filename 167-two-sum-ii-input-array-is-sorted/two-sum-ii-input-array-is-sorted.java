class Solution {
    //two pointer
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0 , j = n-1;
        while(i<j) {
            int sum = numbers[i] + numbers[j];
            if(sum==target) {
                return new int[]{i+1,j+1} ;//return array //i+1 ,j+1 to return correct indices
            }
            else if(sum<target) {
                i++;
            }
            else {
                j--;
            }
        }
        return new int[]{-1,-1}; //what if no pair exist you are returning res as[0,0] which was misleading and look like a valid answer so return [-1,-1]
    }
    }
    
}
