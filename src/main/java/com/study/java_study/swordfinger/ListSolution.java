package com.study.java_study.swordfinger;

import com.study.java_study.swordfinger.entity.ListNode;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rudy
 * @date 2022/6/15 0:42
 */
@Component
public class ListSolution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode();
        ListNode tail = head.next;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }


        return head.next.next;
    }

    public String minRemoveToMakeValid(String s) {
        int left = 0;
        int right = 0;

        Deque deque = new ArrayDeque<Character>();
        for (Character currentChar : s.toCharArray()) {
            if (currentChar == '(') {
                deque.add(currentChar);
            }

            if (currentChar == ')') {
                deque.add(currentChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character currentChar : s.toCharArray()) {
            if (currentChar != '(' && currentChar != ')') {
                sb.append(currentChar);
            }

            if (currentChar == '(' || currentChar == ')') {
                if (currentChar == '(' && (left - right) < deque.size() - 1) {
                    left++;
                    sb.append(currentChar);
                }
                if (currentChar == ')' && right < left) {
                    right++;
                    sb.append(currentChar);
                }
                deque.removeFirst();
            }
        }

        if (left == right) {
            return sb.toString();
        }
        return "";

    }

    /**
     * 节点插入
     */
    public void append(ListNode head, int value) {
        appendWithoutDummy(head, value);
        appendWithDummy(head, value);
    }

    public void delete(ListNode head, int value) {
        deleteWithoutDummy(head, value);
        deleteWithDummy(head, value);
    }

    private ListNode deleteWithDummy(ListNode head, int value) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }

        return dummy.next;

    }

    private ListNode deleteWithoutDummy(ListNode head, int value) {
        if (head == null) {
            return null;
        }

        if (head.val == value) {
            return head.next;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

    private ListNode appendWithoutDummy(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = newNode;
        return head;
    }

    private ListNode appendWithDummy(ListNode head, int value) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode newNode = new ListNode(value);
        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return dummy.next;

    }

}
