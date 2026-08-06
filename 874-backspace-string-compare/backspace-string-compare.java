class Solution {
    public boolean backspaceCompare(String s, String t) {
     int i = s.length()-1 , j = t.length()-1 ;
     while(i>=0 ||j>= 0) {
        //get valid index
        i = getvalidindex(s,i);
        j = getvalidindex(t,j);
        
        // if valid characters are left so compare then
        if(i>= 0 && j>= 0) {
            if(s.charAt(i)!= t.charAt(j)) {
            return false;
            } 
        }
        //One String has a Character left , the other doesn't
        else if(i>= 0 || j>=0) {
            return false;
        }
        i--;
        j--;
        
     }
     return true;
}

    public int getvalidindex(String a , int i) {
        int skip = 0;
        while(i>= 0 ) {
        if(a.charAt(i) == '#') {
            skip++;
        }
        else if(skip>0) {
            skip--;
        }
        //if you found a valid character then break
        else {
            break;
        }
        i--;
    }
    return i;
}
}

/* 
First if
if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
    return false;
}
What is it checking?

It checks:

"Do both strings still have a valid character left, and are those characters different?"

Example:

s = "ab#c"
t = "ad#c"

After processing backspaces:

s → "ac"
t → "ac"

Last characters:

c == c ✅

Move left.

Next valid characters:

a == a ✅

Return true.


Second if
if ((i >= 0) != (j >= 0)) {
    return false;
}

This checks something completely different.

It asks:

"Has one string finished while the other still has characters?"

Example:

s = "a"
t = ""

After processing:

i = 0
j = -1

Now the first if doesn't execute because

j >= 0 ❌

But the strings are clearly different!

One still has 'a'.

The other has nothing.

So we need another check.

(i >= 0) != (j >= 0)

becomes

true != false

which is

true

So return false.

Why can't we use only the first if?

Imagine:

s = "a"
t = ""

First if:

if(i >= 0 && j >= 0 ...)

becomes

true && false

So it is false.

Nothing happens.

The loop continues, and your program would incorrectly think the strings are equal.

That's why the second if is necessary.

Easy way to remember
First if

Compare characters

Both characters exist?

YES

↓

Are they equal?
Second if

Compare lengths after backspaces

Did one string finish earlier than the other?
Think of it like this

Suppose after processing backspaces you have:

s = "abc"
t = "ab"

At the last step:

i = 0
j = -1

There is no character to compare.

Instead, you simply know:

One string still has characters, the other doesn't */