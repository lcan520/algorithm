//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1192 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

/**
 * 回文数:palindrome-number:9
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-08-24 17:53:01
 */
public class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        TimeInterval timer = DateUtil.timer();
        boolean result = solution.isPalindrome(312213);
        long interval = timer.interval();
        System.out.println("interval = " + interval);
        System.out.println("result = " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int reNum = 0;
            while(x > reNum){
                reNum = reNum * 10 + x % 10;
                x /= 10;
            }
            return x == reNum || x == reNum / 10;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
