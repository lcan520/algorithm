//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 665 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

/**
 * 搜索插入位置:search-insert-position:35
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-09-02 16:26:45
 */
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int low = 0, mid = 0;
            int high = nums.length-1;
            while (low < high) {
                mid = low + (high - low) / 2;
                if (nums[mid] > target) {
                    high = mid;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return low;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}