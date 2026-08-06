class Solution {
    public boolean validPalindrome(String s) {
        char[] z = s.toCharArray();
        int i = 0 , j = z.length-1;
        while(i<j) {
            if(z[i]!= z[j]) {
                return palindrome(z , i+1 , j) || palindrome(z , i , j-1);
            }
            i++;
            j--;
        }
        return true;
        
    }
    public boolean palindrome(char[] a , int l , int r) {
        while(l<r) {
            if(a[l] != a[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

/* 
https://chatgpt.com/s/t_6a74667db4f48191a41635728a7d1b2b 
https://chatgpt.com/s/t_6a7466b3b4208191a4d28e12025e42c1 */