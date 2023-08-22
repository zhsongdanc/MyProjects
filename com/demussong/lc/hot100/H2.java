package com.demussong.lc.hot100;

import com.demussong.lc.common.ListNode;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/8 10:43
 */
public class H2 {
    // 超出内存
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode head = new ListNode(0);
        ListNode iterator = head;

        int carry = 0;
        while (list1 != null || list2 != null) {
            int val1 = list1 == null ? 0:list1.val;
            int val2 = list2 == null ? 0:list2.val;
            int sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            iterator.next = new ListNode(sum);
            iterator = iterator.next;


            if (list1 != null) {
                list1 = list1.next;

            }

            if (list2 != null) {
                list2 = list2.next;

            }
        }
        if (carry != 0) {
            iterator.next = new ListNode(1);
        }

        return head.next;
    }


}
