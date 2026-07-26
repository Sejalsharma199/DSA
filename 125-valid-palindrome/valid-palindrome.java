class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]" , "");
        int n = s.length();
        
        for(int i = 0 ; i< n/2 ;i++) { //avoid checking i<=n keep i<n don't check middle element uneccesarily na
            
            if(s.charAt(i) != s.charAt(n-1-i)) { //we don't use j here we use i only but keep removing that particular i from it continously
                
                return false;
            }
        }
        
        return true;
    }
}