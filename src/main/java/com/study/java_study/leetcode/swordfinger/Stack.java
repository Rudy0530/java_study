package com.study.java_study.leetcode.swordfinger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class Stack {
    public String minRemoveToMakeValid(String s) {
        List<Character> sb = new ArrayList<>();
        int left = 0;
        int right = 0;
        // 从前往后遍历，保证右括号数一定合法
        for (char currentChar : s.toCharArray()) {
            if ('(' == currentChar) {
                left++;
                sb.add(currentChar);
            } else if (')' == currentChar) {
                if (left > right) {
                    sb.add(currentChar);
                    right++;
                }
            } else {
                sb.add(currentChar);
            }
        }

        left = 0;
        right = 0;
        StringBuilder res = new StringBuilder();
        for (int i = sb.size() - 1; i >= 0; i--) {
            if (')' == sb.get(i)) {
                right++;
                res.append(sb.get(i));
            } else if ('(' == sb.get(i)) {
                if (left < right) {
                    res.append(sb.get(i));
                    left++;
                }
            } else {
                res.append(sb.get(i));
            }
        }

        return res.reverse().toString();
    }
}
