import java.util.HashMap;

public class EfficientTeams {
    public int solution(int[] arr) {
        int n = arr.length;
        if(n % 2 != 0) return -1;


        int sumOfSkill = 0;
        for (int i : arr) {
            sumOfSkill += i;
        }
        int sumOfEachPair = sumOfSkill / n * 2;

        int efficient = 1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            if(!hm.keySet().contains(i))  {
                hm.put(sumOfEachPair-i, 1);
            } else {
                efficient *= i;
                hm.put(i, hm.get(i) - 1);
                if(hm.get(i) == 0) {
                    hm.remove(i);
                }
            }
        }

        return hm.size() != 0 ? -1 : efficient;


    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 2};
        System.out.println(solution(arr));
    }
}