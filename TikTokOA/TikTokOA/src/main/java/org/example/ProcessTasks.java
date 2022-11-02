package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author limingxia
 * @Description TODO
 * @date 2022/11/2-14:47
 */
public class ProcessTasks {
    public static int solution(int[][] tasks) {
        int res = 0;

        int n = tasks.length;
        boolean[] visited = new boolean[100000];
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=tasks[i][0];j<=tasks[i][1];j++) {
                if(visited[j]) count++;
            }
            for(int j=tasks[i][1];j>=tasks[i][0] && count<tasks[i][2];j--) {
                if(!visited[j]) {
                    visited[j] = true;
                    ++count;
                    ++res;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[][] tasks = new int[][]{{2,5,3},{5,6,2},{1,3,2}};
        System.out.println(solution(tasks)); // 4
    }

}
