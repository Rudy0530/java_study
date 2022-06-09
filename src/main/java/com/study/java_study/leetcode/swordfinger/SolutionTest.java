package com.study.java_study.leetcode.swordfinger;

import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author rudy
 * @date 2022/6/9 22:31
 */
@SpringBootTest
public class SolutionTest {

    @Resource
    private Solution solution;

    @Test
    public void test15() {
        var res = solution.findAnagrams_15("aa", "bb");
        assertTrue(res.size() == 0);

    }
}
