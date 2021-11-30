//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 549 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

/**
 * 实现 strStr():implement-strstr:28
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-01 14:07:38
 */
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        TimeInterval timer = DateUtil.timer();
        int i = solution.strStr("mississippi", "issip");
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval + "\nresult:" + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) {
                return 0;
            }
            if ("".equals(haystack)) {
                return -1;
            }

            // 构造 中的dp矩阵
            int m = needle.length();
            // 各个状态(行)遇到下一个字符(列)跳转到哪个状态
            int[][] dp = new int[m][256];
            // 影子状态
            int x = 0;
            dp[0][needle.charAt(0)] = 1;
            for (int i = 1; i < m; i++) {
                //假设下个字符不匹配，此时要回去看影子状态，从而得知跳转到哪个状态
                System.arraycopy(dp[x], 0, dp[i], 0, 256);
                // 只有pat上i的字符匹配，跳转到下个状态
                dp[i][needle.charAt(i)] = i + 1;
                // 更新影子状态
                x = dp[x][needle.charAt(i)];
            }
            // 构造dp完成后，开始search
            // 初始状态为0
            int s = 0;
            for (int i = 0; i < haystack.length(); i++) {
                s = dp[s][haystack.charAt(i)];
                if (s == m) {
                    return i - m + 1;
                }
            }

            // 匹配失败，返回-1
            return -1;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}