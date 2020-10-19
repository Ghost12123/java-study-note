package com.blank.study.algorithm;


/**
 * @author wudc
 * @date 2020/10/18 23:42
 */
public class Code19 {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 经典问题：双指针
        ListNode root = new ListNode(0, head), fast = head, slow = root;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }
}
