//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 878 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
        TimeInterval timer = DateUtil.timer();
        ListNode head = new P203RemoveLinkedListElements().new ListNode(1);
        ListNode head1 = new P203RemoveLinkedListElements().new ListNode(2);
        head.next = head1;
        //ListNode head2 = new P203RemoveLinkedListElements().new ListNode(7);
        //head1.next = head2;
        //ListNode head3 = new P203RemoveLinkedListElements().new ListNode(7);
        //head2.next = head3;

        System.out.println(solution.removeElements(head, 1));
        long interval = timer.interval();
        System.out.println("interval = " + interval + "ms");
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            if (temp.val == val) {
                if (pre != null) {
                    pre.next = temp.next;
                } else {
                    head = temp.next;
                }
            } else {
                pre = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}   

 