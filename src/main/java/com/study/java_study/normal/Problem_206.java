package com.study.java_study.normal;

import com.study.java_study.swordfinger.entity.ListNode;
import lombok.var;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Problem_206 {

    @Test
    public void testSpiralOrder() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        var res = reverseList(head);
        System.out.println(res);
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode currentNext = head.next;
        head.next = null;

        while (currentNext != null) {
            ListNode currentNextNext = currentNext.next;
            currentNext.next = head;
            head = currentNext;
            currentNext = currentNextNext;
        }

        return head;

    }
}
