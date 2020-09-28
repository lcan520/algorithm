//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 514 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

/**
 * x 的平方根:sqrtx:69
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-27 17:39:54
 */
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if(x == 1) {
                return 1;
            }
            int min = 0;
            int max = x;
            while(max-min>1)
            {
                int m = (max+min)/2;
                if(x/m<m) {
                    max = m;
                } else {
                    min = m;
                }
            }
            return min;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}