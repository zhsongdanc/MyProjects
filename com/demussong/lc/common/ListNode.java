package com.demussong.lc.common;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/7/8 10:44
 */
public class ListNode {

     public int val;
     public ListNode next;

     ListNode() {
     }

     public ListNode(int val) {
      this.val = val;
     }

     public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
     }
}
