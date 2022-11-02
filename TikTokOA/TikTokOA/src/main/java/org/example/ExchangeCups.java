package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author limingxia
 * @Description TODO
 * @date 2022/11/2-11:29
 */
public class ExchangeCups {
    public static void main(String[] args) {
        List<Long> labels = new ArrayList<>(Arrays.asList(
                3L,1L,2L,5L,4L
        ));
        System.out.println(solution(labels.size(), labels));

    }

    private static int solution(int n, List<Long> labels) {
        // 本应该的位置
        List<Long> right = new ArrayList<>(labels);
        Collections.sort(right);

        int res = 0;
        for(int i=0;i<n;i++) {
            if(!labels.get(i).equals(right.get(i))) {
                res ++;
                Collections.swap(labels, i, labels.indexOf(right.get(i)));
            }
        }
        return res;
    }
}
