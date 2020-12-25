package com.srping.data.structure;

import com.srping.data.structure.entity.Demo;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表


@SpringBootTest
public class TwoSumDemoTests {

    @Test
    void contextLoads() {

        int[] nums = {2, 7, 11, 15};
        int target = 22;
//        int[] ints = twoSum(nums, target);
        int[] ints = twoSum2(nums, target);
        for (int element : ints) {
            System.out.println(element);
        }
    }

    /**
     * 暴力算法
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * 暴力算法
     */
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> integerMap = new ConcurrentHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int differenceNumber = target - nums[i];

            if (integerMap.containsKey(differenceNumber)) {
                return new int[]{integerMap.get(differenceNumber), i};
            }
            integerMap.put(nums[i], i);
        }
        return null;
    }
}


