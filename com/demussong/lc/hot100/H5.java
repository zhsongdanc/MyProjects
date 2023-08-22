package com.demussong.lc.hot100;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/8 11:30
 */
public class H5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int center = -1,max = -1;
        for (int i = 0; i < s.length(); i++) {
            int tmp = help(s, i);
            if (tmp > max) {
                max = tmp;
                center = i;
            }
        }

        return s.substring(center - max, center + max +1);

    }

    public int help(String s, int i) {
        int max = 0;
        for(int k = 1;i - k >= 0 && i + k < s.length();k++) {
            if (s.charAt(i -k) == s.charAt(i + k)){
                max = Math.max(max, k);
            }else {
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("bbbaa"));
    }

    public static String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);

    }


}
