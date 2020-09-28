//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 483 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

/**
 * 二进制求和:add-binary:67
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-27 14:49:53
 */
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        String result = solution.addBinary("110010", "10111");
        System.out.println(result);
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if(a == null || a.length() == 0) {
                return b;
            }
            if(b == null || b.length() == 0) {
                return a;
            }

            StringBuilder stb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;

            int c = 0;  // 进位
            while(i >= 0 || j >= 0) {
                if (i >= 0) {
                    c += a.charAt(i--) - '0';
                }

                if (j >= 0) {
                    c += b.charAt(j--) - '0';
                }
                stb.append(c % 2);
                c >>= 1;
            }

            String res = stb.reverse().toString();
            return c > 0 ? '1' + res : res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}