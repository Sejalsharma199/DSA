class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length-1;
        int maxarea = 0;
        while(left<right) {
            int currarea = Math.min(height[left], height[right]) * (right-left); //kyunki water store will depend on minimum height na
            maxarea = Math.max(maxarea , currarea);

            if(height[left]<height[right]) { 
                left++; //since choti height chahiye he nai so we will move forward to see next height ise badi
            }
            else {
                right--; //similarly agr right side height choti h toh left me shift honge to see use badi koi height
            }
        }
        return maxarea;
    }
}