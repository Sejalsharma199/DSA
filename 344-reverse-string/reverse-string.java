class Solution {
    public void reverseString(char[] s) {
       int i = 0 , j = s.length-1;
       while(i<j) {
        char temp = s[i]; //temp should be char type na not int since it is char in s so it will get store in char only
        s[i] = s[j];
        s[j] = temp;

        i++;
        j--;
       }
    }
}