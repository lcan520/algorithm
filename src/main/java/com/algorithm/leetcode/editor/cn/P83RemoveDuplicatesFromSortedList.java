//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 424 👎 0

package com.algorithm.leetcode.editor.cn;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

/**
 * 删除排序链表中的重复元素:remove-duplicates-from-sorted-list:83
 *
 * @author lcan
 * @email lcan520@126.com
 * @date 2020-11-09 09:30:26
 */
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        TimeInterval timer = DateUtil.timer();
        // TODO 代码调用solution.<method>
        long interval = timer.interval() / 1000L;
        System.out.println("interval = " + interval);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null) {
                return head;
            }
            ListNode cur=head;
            while(cur!=null && cur.next!=null){
                if(cur.val==cur.next.val){
                    cur.next=cur.next.next;
                }else{
                    cur=cur.next;
                }
            }
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}