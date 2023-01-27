package com.study.java_study.list;

import com.study.java_study.swordfinger.entity.ListNode;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Problem_19 {

    @Test
    public void testSpiralOrder() {
        ListNode res = removeNthFromEnd(new ListNode(1), 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }

        if (n == len) {
            return head.next;
        }

        current = head;
        int step = len - n - 1;
        while (current.next != null && step != 0) {
            current = current.next;
            step--;
        }

        if (current.next.next == null) {
            current.next = null;
        } else {
            ListNode next = current.next.next;
            current.next = next;
        }

        return head;

    }

}
