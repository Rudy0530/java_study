package com.study.java_study.leetcode.normal;

import lombok.var;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class Problem_205 {

    @Test
    public void testSpiralOrder() {
        int a[] = {-1, -1, -1, -1, 0, 1};
        var res = isIsomorphic("egg","add");
        System.out.println(res);
    }

    public boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Map<Character, Character> scharMap = new HashMap<>();
        Map<Character, Character> tcharMap = new HashMap<>();
        if (sc.length != tc.length) {
            return false;
        }

        for (int i = 0; i < sc.length; i++) {
            if (!scharMap.containsKey(sc[i]) && !tcharMap.containsKey(tc[i])) {
                scharMap.put(sc[i], tc[i]);
                tcharMap.put(tc[i], sc[i]);
            } else {
                if (sc[i]!= tcharMap.get(tc[i]) || tc[i] != scharMap.get(sc[i])) {
                    return false;
                }

            }

        }

        return true;

    }
}
