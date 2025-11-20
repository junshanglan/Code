package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class 两数相加 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        ListNode tmpOne = l1;
        while (tmpOne != null) {
            one.add(tmpOne.val);
            tmpOne = tmpOne.next;
        }
        ListNode tmpTwo = l2;
        while (tmpTwo != null) {
            two.add(tmpTwo.val);
            tmpTwo = tmpTwo.next;
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = one.size() - 1; i >= 0; i--) {
            sb1.append(one.get(i));
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = two.size() - 1; i >= 0; i--) {
            sb2.append(two.get(i));
        }
        Long numOne = Long.valueOf(sb1.toString());
        Long numTwo = Long.valueOf(sb2.toString());
        long result = numOne + numTwo;
        String resultStr = String.valueOf(result);
        ListNode resultNode = new ListNode(resultStr.charAt(0));
        ListNode next = resultNode.next;
        for (int i = 1; i < resultStr.length(); i++) {
            ListNode tmpNode = new ListNode(resultStr.charAt(i));
            next = tmpNode;
            next = next.next;
        }
        return resultNode;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
