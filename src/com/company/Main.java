package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	    String a = "aa";
	    String b = "aa";
	    Solution s = new Solution();
	    System.out.println(s.buddyStrings(a,b));
    }
}

class Solution {
    public boolean buddyStrings(String a, String b) {
        if(a.length()!=b.length())
        {
            return false;
        }
        char[] chars_a = a.toCharArray();
        char[] chars_b = b.toCharArray();
        if(a.equals(b))
        {
            for(int i = 0;i<chars_a.length-1;i++)
            {
                for(int j = i+1;j< chars_a.length;j++)
                {
                    if(chars_a[i] == chars_a[j])
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        int unpos = 0;
        for(int i = 0;i<chars_a.length-1;i++)
        {
            if(chars_a[i] != chars_b[i])
            {
                unpos++;
            }
            if(unpos>2)
            {
                return false;
            }
        }
        int start = -1, end = -1;
        String aa = new String();
        String bb = new String();
        boolean flag = false;
        for(int i = 0;i<chars_a.length;i++)
        {
            if(chars_a[i]==chars_b[i])
            {
                if(start==-1)
                {
                    start = i;
                }
                else
                {
                    end = i;
                }
            }
            else
            {
                if(start!=-1)
                {
                    aa += a.substring(0, start);
                    aa += a.substring(end+1);
                    bb += b.substring(0, start);
                    bb += b.substring(end+1);
                    start = -1;
                    end = -1;
                    flag = true;
                    break;
                }
            }
        }
        if(!flag)
        {
            aa = a;
            bb = b;
        }
        chars_a = aa.toCharArray();
        chars_b = bb.toCharArray();
        System.out.println(chars_a);
        System.out.println(chars_b);
        char buf;
        for(int i = 0;i<chars_a.length-1;i++)
        {
            for(int j = i+1; j<chars_a.length; j++)
            {
                buf = chars_a[i];
                chars_a[i] = chars_a[j];
                chars_a[j] = buf;
                String s1 = new String(chars_a);
                if(s1.equals(bb))
                {
                    return true;
                }
                buf = chars_a[i];
                chars_a[i] = chars_a[j];
                chars_a[j] = buf;
            }
        }
        return false;
    }
}
