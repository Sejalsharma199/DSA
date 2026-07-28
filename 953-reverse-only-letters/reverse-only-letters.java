class Solution {
    public String reverseOnlyLetters(String s) {
        //since strings are immutable so we can't do s.charAt(i) = s.charAt(j)
        char[] c = s.toCharArray() ;
        int l = 0 , r = c.length-1;
        while(l<r) {
            if(!Character.isLetter(c[l])) {
                    l++;
            }
            else if(!Character.isLetter(c[r])) {
                r--;
            }
            else {
                char temp = c[l];
                c[l] = c[r];
                c[r] = temp;
                l++;
                r--;
            }
            
        }
        //After modifying c, you need to convert it back into a String.
        //It should be:
        return new String(c);
    }
}