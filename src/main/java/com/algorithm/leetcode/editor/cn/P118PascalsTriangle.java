//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 741 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        TimeInterval timer = DateUtil.timer();
        List<List<Integer>> generate = solution.generate(100);
        System.out.println(Arrays.deepToString(generate.toArray()));
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> pre = new ArrayList();
        pre.add(1);
        result.add(pre);
        for (int i = 1; i < numRows; i++) {
            List<Integer> n = new ArrayList<>(i + 1);
            n.add(1);
            for (int j = 1; j < i; j++) {
                n.add(pre.get(j - 1) + pre.get(j));
            }
            n.add(1);
            result.add(n);
            pre = n;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 