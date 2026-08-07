class Solution {
    public String firstPalindrome(String[] words) {
        String s = "";
        //visit every word in array first
        for(int i = 0 ; i<words.length ; i++) {
            boolean flag = true;
            int l = 0 , r = words[i].length()-1;
            while(l<r) {
             //   boolean flag = true; no not here flag should belong to current word not current iteration of while loop
                if(words[i].charAt(l)!= words[i].charAt(r) ){
                    //break will exit only current word and go to new i in for loop
                        flag = false;
                        break;
                        
                //    return false;
                }
                l++;
                r--;

            }
            //after while loop finishes now ask if flag is still true, so return words[i]
            if(flag) {
                return words[i];
            }
        }
        //if none of the word is a pallindrome
        return "";
        
    }
}

/* 
class Solution {
    public String firstPalindrome(String[] words) {
        
        for(int i = 0 ; i <words.length ; i++) {
            if(palindrome(words[i])){
                return words[i];
            }
            
        }
        return "";
        
    }
    public boolean palindrome(String s) {
        for(int i = 0 ; i <s.length()/2 ; i++) {
            if(s.charAt(i)!= s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
} */
