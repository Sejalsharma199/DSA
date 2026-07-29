class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0 ;
        while(i<s.length() && j<t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
            }
            /* if you reached till end of string s length so return true
            if(i == s.length()) {
                return true;
            } */
        }
        // or write it directly
        return i == s.length();
    }
}