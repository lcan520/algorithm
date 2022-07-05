//给定一个 无重复元素 的 有序 整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// Related Topics 数组 👍 213 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P228SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new P228SummaryRanges().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return new ArrayList<>(Collections.singletonList(String.valueOf(nums[0])));
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; p1 < nums.length; i++) {
            if (p2 <= nums.length - 1 && nums[i] + 1 == nums[p2] ) {
                p2++;
            } else {
                if (p1 < p2 - 1) {
                    result.add(nums[p1] + "->" + nums[i]);
                } else {
                    result.add(String.valueOf(nums[i]));
                }
                p1 = p2;
                p2++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    
}   

 