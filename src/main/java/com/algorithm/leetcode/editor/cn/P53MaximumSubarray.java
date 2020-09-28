//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2375 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

/**
 * 最大子序和:maximum-subarray:53
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-03 09:59:22
 */
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        TimeInterval timer = DateUtil.timer();
        int[] nums = {-100, 1,-1,1, -100};
        solution.maxSubArray(nums);
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int sum = 0;
            for (int num : nums) {
                if (sum > 0) {
                    sum += num;
                } else {
                    sum = num;
                }
                res = Math.max(res, sum);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}