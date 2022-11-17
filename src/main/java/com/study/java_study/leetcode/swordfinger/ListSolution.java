package com.study.java_study.leetcode.swordfinger;

import com.study.java_study.leetcode.swordfinger.entity.ListNode;
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
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode head = new ListNode();
        ListNode tail = head.next;

        while(list1!=null && list2!= null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1=list1.next;
            }else{
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }

        if(list1!=null){
            tail.next = list1;
        }

        if(list2!=null){
            tail.next = list2;
        }


        return head.next.next;
    }

    public String minRemoveToMakeValid(String s) {
        int left =0;
        int right=0;

        Deque deque = new ArrayDeque<Character>();
        for(Character currentChar:s.toCharArray()){
            if(currentChar=='('){
                deque.add(currentChar);
            }

            if(currentChar==')' ){
                deque.add(currentChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character currentChar:s.toCharArray()){
            if(currentChar!='(' && currentChar !=')'){
                sb.append(currentChar);
            }

            if(currentChar=='(' || currentChar==')'){
                if(currentChar=='(' && (left-right)<deque.size()-1 ){
                    left++;
                    sb.append(currentChar);
                }
                if(currentChar==')' && right<left){
                    right++;
                    sb.append(currentChar);
                }
                deque.removeFirst();
            }
        }

        if(left==right){
            return sb.toString();
        }
        return "";

    }
}
