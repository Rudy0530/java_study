package com.study.java_study.leetcode.swordfinger;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author rudy
 * @date 2022/6/9 7:40
 */
@Component
public class Solution {

    /**
     * 剑指 Offer II 014. 字符串中的变位词
     * https://leetcode.cn/problems/MPnaiL/
     * <p>
     * 反思：
     * 对于字符串子串的变位符。我的思路是滑动到特定区域后，将区域内的字符串进行排序，然后比较
     * 这样做比较麻烦，因为判断变位符时，无需对待比较的子串进行排序
     * 参与比较的核心是出现的字符以及字符出现的个数。
     */
    public boolean checkInclusion_014(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        // 窗口数据初始化
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
            arr2[s2.charAt(i - s1.length()) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(arr1, arr2);
    }

    public List<Integer> findAnagrams_15(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return Collections.emptyList();
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        List<Integer> res = new ArrayList<>();
        // 窗口数据初始化
        for (int i = 0; i < p.length(); i++) {
            arr1[p.charAt(i) - 'a']++;
            arr2[s.charAt(i) - 'a']++;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (Arrays.equals(arr1, arr2)) {
                res.add(i - p.length());
            }
            arr2[s.charAt(i - p.length()) - 'a']--;
            arr2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arr1, arr2)) {
            res.add(s.length() - p.length());
        }
        return res;


    }

}
