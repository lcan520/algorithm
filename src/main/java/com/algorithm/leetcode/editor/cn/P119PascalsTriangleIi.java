//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 👍 386 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        TimeInterval timer = DateUtil.timer();
        List<Integer> row = solution.getRow(4);
        System.out.println(Arrays.toString(row.toArray()));
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(pre.get(j - 1) + pre.get(j));
            }
            temp.add(1);
            pre = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 