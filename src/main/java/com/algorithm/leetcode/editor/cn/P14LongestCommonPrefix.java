//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1231 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * 最长公共前缀:longest-common-prefix:14
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-08-25 09:34:10
 */
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        TimeInterval timer = DateUtil.timer();
        String result = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println("result = " + result);
        long interval = timer.interval() / 1000;
        System.out.println("interval = " + interval);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.length() == 0) {
                        return prefix;
                    }
                }
            }
            return prefix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
