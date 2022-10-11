/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/10-20:02
 */
public class ArrToLinkedList {
    public int solution(int[] arr) {
        int idx = 0;
        int count = 0;
        while(idx<arr.length && arr[idx] != -1) {
            count ++;
            idx = arr[idx];
        }

        return ++ count;
    }
    public static void main(String[] args) {
        ArrToLinkedList arrToLinkedList = new ArrToLinkedList();
        int[] arr = {1,4,-1,3,2}; // 4
        System.out.println(arrToLinkedList.solution(arr));
    }
}
