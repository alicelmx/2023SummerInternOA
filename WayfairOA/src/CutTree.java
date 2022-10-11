import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/5-10:44
 */
public class CutTree {
    /*
        Brute force solution
        Jimmy owns a garden in which he has planted N trees in a row. After a few years, the trees have grown up and now they have different heights.
        Jimmy pays much attention to the aesthetics of his garden. He finds his trees aesthetically pleasing if they alternately increase and decrease in height (…, shorter, taller, shorter, taller, …).
        Note that two adjacent trees cannot have equal heights. It may turn out that some trees have to be cut out, in order to keep the remaining trees aesthetically pleasing.
        However, there is a legal restriction that allows a gardener to cut out at most one tree in his possession.
        In how many ways can Jimmy cut out exactly one tree, so that the remaining ones are aesthetically pleasing?
     */
    public int solution(int[] A) {
        int count = 0;

        ArrayList<Integer> arrList = new ArrayList<>();
        for(int a : A)
            arrList.add(a);

        if(checkAesthetical(arrList)) return count;

        for(int i=0;i<A.length;i++) {
            arrList.remove(i);
            if(checkAesthetical(arrList)) count ++;
            arrList.add(i, A[i]);
        }

        return count == 0 ? -1 : count;
    }

    private boolean checkAesthetical(ArrayList<Integer> arr) {
        boolean res = true;
        for(int i=1;i<arr.size()-1;i++) {
            if(arr.get(i)>arr.get(i-1) && arr.get(i)>arr.get(i+1) ||
                    arr.get(i)<arr.get(i-1) && arr.get(i)<arr.get(i+1))
                continue;
            else res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        CutTree cutTree = new CutTree();

        int[] A1 = new int[]{3, 4, 5, 3, 7};
        System.out.println(cutTree.solution(A1)); // 3

        int[] A2 = new int[]{1, 2, 3, 4};
        System.out.println(cutTree.solution(A2)); // -1

        int[] A3 = new int[]{1, 3, 1, 2};
        System.out.println(cutTree.solution(A3)); // 0
    }
}
