//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。 
//
// 例 1： 
//
// 
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释: 
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
// 
//
// 例 2： 
//
// 
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释: 
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
// 
//
// 注意： 
//
// 
// m 和 n 的范围在 [1, 30000] 之间。 
// k 的范围在 [1, m * n] 之间。 
// 
//
// Related Topics 二分查找 👍 195 👎 0


package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

public class P668KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        Solution solution = new P668KthSmallestNumberInMultiplicationTable().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        System.out.println(1.0/2.0*2.0);
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int left = 1, right = m * n;
            while (left < right) {
                int x = left + (right - left) / 2;
                int count = x / n * n;
                for (int i = x / n + 1; i <= m; ++i) {
                    count += x / i;
                }
                if (count >= k) {
                    right = x;
                } else {
                    left = x + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}   

 