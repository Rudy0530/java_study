package com.study.java_study.normal;

import lombok.var;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Problem_724 {

    @Test
    public void testSpiralOrder() {
        int a[] = {-1,-1,-1,-1,0,1};
        var res = pivotIndex(a);
        System.out.println(res);
    }


    public int pivotIndex(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int[] rightSum = new int[nums.length];

        rightSum[nums.length - 1] = 0;
        rightSum[nums.length - 2] = nums[nums.length - 1];

        for (int i = nums.length - 3; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        if (rightSum[0] == 0) {
            return 0;
        }


        int[] leftSum = new int[nums.length];
        leftSum[0] = 0;
        leftSum[1] = nums[0];
        if(leftSum[1]==rightSum[1]){
            return 1;
        }
        for (int i = 2; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;

    }
}
