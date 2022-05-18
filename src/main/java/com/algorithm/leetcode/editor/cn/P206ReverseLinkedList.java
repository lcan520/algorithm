//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2482 👎 0


package com.algorithm.leetcode.editor.cn;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.LinkedList;

public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        TimeInterval timer = DateUtil.timer();
        ListNode reverse = new P206ReverseLinkedList().new ListNode(1);
        ListNode reverse1 = new P206ReverseLinkedList().new ListNode(2);
        reverse.next = reverse1;
        ListNode reverse2 = new P206ReverseLinkedList().new ListNode(3);
        reverse1.next = reverse2;
        ListNode reverse3 = new P206ReverseLinkedList().new ListNode(4);
        reverse2.next = reverse3;
        ListNode reverse4 = new P206ReverseLinkedList().new ListNode(5);
        reverse3.next = reverse4;
        solution.reverseList(reverse);
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}   

 