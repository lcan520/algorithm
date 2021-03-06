//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1812 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 有效的括号:valid-parentheses:20
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-08-25 13:53:39
 */
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        TimeInterval timer = DateUtil.timer();
        boolean valid = solution.isValid("()[]{}");
        long interval = timer.interval() / 1000L;
        System.out.println("valid = " + valid);
        System.out.println("interval = " + interval + "ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            //不需要扩容
            char[] chars = s.toCharArray();
            char[] stack = new char[chars.length];
            if (chars.length % 2 != 0) {
                return false;
            }
            int index = 0;
            for (char aChar : chars) {
                switch (aChar) {
                    case '{':
                        stack[index++] = '}';
                        break;
                    case '[':
                        stack[index++] = ']';
                        break;
                    case '(':
                        stack[index++] = ')';
                        break;
                    default:
                        if (index == 0 || stack[--index] != aChar) {
                            return false;
                        }
                }
            }
            return index == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}