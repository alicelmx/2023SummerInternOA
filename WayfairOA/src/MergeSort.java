/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/5-10:15
 */
public class MergeSort {
    /*
        we are given an array a consisting of n distinct integers.
        we would like to sort array A into ascending order using a simple algorithm.
        first we divide it i not one or more slices(a slice is a contigious subarray)
        then we sort each slice after that, we join the sorted slice in the same order.
        write a function solution that returns the maximum number of slices for which the algorithm will return a correctly sorted array.
     */
    public int solution(int[] A) {
        int N = A.length;
        int count = 0;
        int[] leftMax = new int[N];
        int[] rightMin = new int[N];

        leftMax[0] = A[0];
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i]);
        }

        rightMin[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], A[i]);
        }

        // core idea
        for (int i = 0; i < N - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                count++;
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] A1 = new int[]{2, 4, 1, 6, 5, 9, 7};
        System.out.println(mergeSort.solution(A1)); // 3

        int[] A2 = new int[]{5, 4, 3, 2, 6, 1};
        System.out.println(mergeSort.solution(A2)); // 1

        int[] A3 = new int[]{2, 1, 6, 4, 3, 7};
        System.out.println(mergeSort.solution(A3)); // 3
    }
}
