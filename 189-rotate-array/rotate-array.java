class Solution {
    public void rotate(int[] nums, int k) {
        k = k %nums.length;
    
        reverse(nums , 0 , nums.length-1 );
        reverse(nums , 0 , k-1);
        reverse(nums , k , nums.length-1);
    }
    public void reverse(int[] arr , int l , int r) {
        while(l<r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}

/*
https://chatgpt.com/s/t_6a746d946ca081919e878b8c5e0375e2
https://chatgpt.com/s/t_6a7471026be08191a05f03b811a51139
https://chatgpt.com/s/t_6a74711997a081918f4d3f9254f80ba4
https://chatgpt.com/s/t_6a74713c7a2c8191aaff4466b4bc6b5a
https://chatgpt.com/s/t_6a747155f304819191d587cbf8f461ec */