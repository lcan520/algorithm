//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 243 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

/**
 * 最后一个单词的长度:length-of-last-word:58
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-27 11:58:39
 */
public class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        solution.lengthOfLastWord("a");
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            int length = 0;
            if (s == null || s.length() == 0) {
                return 0;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    length++;
                } else if (length != 0) {
                    return length;
                }
            }
            return length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}