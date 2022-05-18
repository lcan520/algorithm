//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2372 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        TimeInterval timer = DateUtil.timer();
        int[] a = {1, 3, 1, -1, 3};
        solution.singleNumber(a);
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];

        for(int i=1;i<nums.length;++i){
            ans^=nums[i];
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 