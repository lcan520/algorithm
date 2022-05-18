//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 179 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

public class POneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new POneAwayLcci().new Solution();
        TimeInterval timer = DateUtil.timer();
        System.out.println(solution.oneEditAway("teacher","bleacher"));
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) return false;
        if (n > m) return oneEditAway(second, first);
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            char c1 = first.charAt(i), c2 = second.charAt(j);
            if (c1 == c2) {
                i++; j++;
            } else {
                if (n == m) {
                    i++;
                }
                j++;
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 