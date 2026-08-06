class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] c = new char[word1.length() + word2.length()];
        int i = 0 , j = 0 ,k=0;
        while(i<word1.length() && j<word2.length()) {
            c[k] = word1.charAt(i);
            i++;
            k++;
            c[k] = word2.charAt(j);
            k++;
            j++;
           }

    //print remaining characters also if one string get finish early
           while(i<word1.length()) {
            c[k] = word1.charAt(i);
            i++;
            k++;
           }

           while(j<word2.length()){
            c[k] = word2.charAt(j);
            j++;
            k++;
           }

           return new String(c);
    }
}

/* 
String s = "";
        int i = 0 , j = 0 ;
        while(i<word1.length() && j<word2.length()) {
            s += word1.charAt(i);
            i++;
            s+= word2.charAt(j);
            j++;
        }
            while(i<word1.length()) {
                s += word1.charAt(i);
                i++;
            }
            
                while(j<word2.length()) {
                    s+= word2.charAt(j);
                    j++;
                }
                return s;
            
        }
        
    }*/