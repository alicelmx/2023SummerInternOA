package org.example;

/**
 * @author limingxia
 * @Description TODO
 * @date 2022/11/2-10:58
 */
public class EatCandy {
    public int solution(int[] candy) {
        int n = candy.length;
        if(n == 1) return 0;

        int first = 0, last = n-1;
        int fs = 0, ls = 0;
        int res = 0;

        while(first <= last) {
            if(fs > ls) {
                ls += candy[last--];
            } else {
                fs += candy[first++];
            }
            if(fs == ls) {
                res = first + n - last - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        EatCandy eatCandy = new EatCandy();

        int[] candy = {7,3,20,5,15,1,11,8,10};
        System.out.println(eatCandy.solution(candy));  // 7

        int[] candy1 = {2,1,4,2,4,1};
        System.out.println(eatCandy.solution(candy1)); // 6

        int[] candy2 = {1,2,4,8,16};
        System.out.println(eatCandy.solution(candy2)); // 0

        int[] candy3 = {10,20,10};
        System.out.println(eatCandy.solution(candy3)); // 2
    }
}
