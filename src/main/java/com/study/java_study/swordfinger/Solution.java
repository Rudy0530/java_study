package com.study.java_study.swordfinger;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class Solution {

    @Test
    public void testDecodeString() {
        checkDistances("aa", new int[]{
                1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        int a = 0;

    }

    public boolean checkDistances(String s, int[] distance) {

        // 遍历字母，如果distance的值为0，则说明第一次遇到字母，记录下标记。如果不为0 ，则记录是否不是标准字符串，不是则直接返回false
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            curr.add(0);
        }

        //a的ascii是97
        Set<Character> set = new HashSet<>();

        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (set.contains(sArray[i])) {
                curr.set(sArray[i] - 'a', i - curr.get(sArray[i] - 'a') - 1);
                if(curr.get(sArray[i] - 'a')!= distance[sArray[i] - 'a']){
                    return false;
                }
            } else {
                set.add(sArray[i]);
                curr.set(sArray[i] - 'a', i);

            }
        }

        return true;
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 1 && matrix[0].length == 1) {
            res.add(matrix[0][0]);
            return res;
        }

        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                res.add(matrix[0][i]);
            }
            return res;
        }

        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }

        int left_hor = 0;
        int left_ver = 0;
        int right_hor = matrix[0].length - 1;
        int right_ver = matrix.length - 1;

        while (left_hor <= right_hor && left_ver <= right_ver) {
            if (left_hor == right_hor && left_ver == right_ver) {
                res.add(matrix[left_ver][left_hor]);
            }
            for (int i = left_hor; i < right_hor; i++) {
                res.add(matrix[left_ver][i]);
            }
            for (int i = left_ver; i < right_ver; i++) {
                res.add(matrix[i][right_hor]);
            }
            for (int i = right_hor; i > left_hor; i--) {
                res.add(matrix[right_ver][i]);
            }

            for (int i = right_ver; i > left_ver; i--) {
                res.add(matrix[i][left_hor]);
            }
            left_hor++;
            left_ver++;
            right_hor--;
            right_ver--;
        }


        return res;

    }

}
