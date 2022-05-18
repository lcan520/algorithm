//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
// Related Topics 数学 字符串 👍 521 👎 0


package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.List;

public class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        TimeInterval timer = DateUtil.timer();
        System.out.println(solution.convertToTitle(52));
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            char[] chars = new char[7];
            char[] result ;
            int p = 6;
            while (columnNumber > 0) {
                chars[p] = (char) ((columnNumber-1) % 26 + 'A');
                columnNumber = (columnNumber - 1) / 26;
                p--;
            }
            int s = 6 - p;
            result = new char[s];
            for (int i = 0; i < s; i++) {
                result[i] = chars[++p];
            }
            return new String(result);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}   

 