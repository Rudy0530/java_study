package com.study.java_study.normal;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Problem_54 {

    @Test
    public void testSpiralOrder() {
        int a[][] = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        List<Integer> res = spiralOrder(a);
        System.out.println(res);
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
        int right_hor = matrix.length - 1;
        int right_ver = matrix[0].length - 1;

        while (left_hor < right_hor && left_ver < right_ver) {
            for (int i = left_ver; i < right_ver; i++) {
                res.add(matrix[left_hor][i]);
            }
            for (int i = left_hor; i < right_hor; i++) {
                res.add(matrix[i][right_ver]);
            }
            for (int i = right_ver; i > left_ver; i--) {
                res.add(matrix[right_hor][i]);
            }
            for (int i = right_hor; i > left_hor; i--) {
                res.add(matrix[i][left_ver]);
            }

            left_hor++;
            left_ver++;
            right_hor--;
            right_ver--;
        }

        if (left_hor == right_hor && left_ver == right_ver) {
            res.add(matrix[left_hor][left_ver]);
        }

        if(left_hor==right_hor && left_ver<right_ver){
            for(int i=left_ver;i<=right_ver;i++){
                res.add(matrix[left_hor][i]);
            }
        }

        if(left_ver==right_ver && left_hor<right_hor){
            for(int i=left_hor;i<=right_hor;i++){
                res.add(matrix[i][left_ver]);
            }
        }


        return res;

    }
}
