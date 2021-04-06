//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1256 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;

/**
 * 爬楼梯:climbing-stairs:70
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-28 09:41:27
 */
public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n-1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}