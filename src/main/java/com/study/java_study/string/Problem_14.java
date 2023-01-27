package com.study.java_study.string;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Problem_14 {

    @Test
    public void testSpiralOrder() {
        String[] strs = {"ab", "a"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < strs[0].length(); col++) {
            char currentChar = strs[0].charAt(col);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() > col) {
                    if (strs[i].charAt(col) != currentChar) {
                        return sb.toString();
                    }
                } else {
                    return sb.toString();
                }
            }
            sb.append(currentChar);
        }

        Arrays.sort(strs);

        return sb.toString();
    }
}
