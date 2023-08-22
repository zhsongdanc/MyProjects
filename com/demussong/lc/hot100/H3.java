package com.demussong.lc.hot100;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/8 11:07
 */
public class H3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        // 左闭，右闭
        int left = 0, right = 0;
        int max = 1;
        while (right < s.length()) {

            // 每次先判断，再加入
            while (map.getOrDefault(s.charAt(right), 0) > 0) {
                int leftVal = map.get(s.charAt(left));
                map.put(s.charAt(left), leftVal - 1);
                left ++;
            }
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
