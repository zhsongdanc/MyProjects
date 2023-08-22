package com.demussong.lc.hot100;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/8 10:38
 */
public class H1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
