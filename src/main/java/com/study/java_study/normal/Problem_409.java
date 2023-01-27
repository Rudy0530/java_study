package com.study.java_study.normal;

import com.study.java_study.swordfinger.entity.ListNode;
import lombok.var;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Problem_409 {

    @Test
    public void testSpiralOrder() {
        var res = longestPalindrome("abcde");
        System.out.println(res);
    }

    public int longestPalindrome(String s) {
        int[] charNumber = new int[52];

        for (char currentChar : s.toCharArray()) {
            charNumber[currentChar - 'a']++;
        }

        int longestOddNumber = 0;
        int res = 0;
        for (Integer count : charNumber) {
            if (count % 2 == 0) {
                res += count;
            } else {
                longestOddNumber = longestOddNumber > count ? longestOddNumber : count;
            }
        }

        return res + longestOddNumber;

    }
}
