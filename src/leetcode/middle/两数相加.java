package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class 两数相加 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail= null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            int tmp = sum % 10;
            if (head == null) {
                head = tail = new ListNode(tmp);
            }else{
                tail.next = new ListNode(tmp);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = sum /10;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
