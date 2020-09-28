//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 550 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

/**
 * 加一:plus-one:66
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-27 14:10:47
 */
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i] = ++digits[i];
                    return digits;
                }
                digits[i] = 0;

            }
            // 进位
            int[] add = new int[digits.length + 1];
            add[0] = 1;
            return add;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}