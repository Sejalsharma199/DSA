class Solution {
    public void reverseString(char[] s) {
      int l = 0 , r = s.length-1;
      while(l<r) {
        swap( s , l , r);
        l++;
        r--;
      }
      
    }
    public void swap(char[] a , int i , int j ) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}