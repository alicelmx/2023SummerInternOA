import java.util.ArrayList;

/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/10-20:02
 */
public class SmallestIntegerSameN {
    public int solution(Integer num) {
        String str = num.toString();
        int n = str.length();

        StringBuilder trailZeroList = new StringBuilder();
        StringBuilder headNineList = new StringBuilder();

        // 1. 从右往左找到第一个可以被减少的数字 注意1
        int reducableIdx = n - 1;
        while(reducableIdx >= 0) {
            if(str.charAt(reducableIdx) != '0') break;
            trailZeroList.append(str.charAt(reducableIdx)); // 00
            reducableIdx --;
        }

        int reducableNum = str.charAt(reducableIdx) -'0' - 1;

        // 2. 找到reducableNum左边可以被增加的数字
        int increasableIdx = reducableIdx - 1;
        while(increasableIdx >= 0) {
            if(str.charAt(increasableIdx) != '9') break;
            headNineList.append(str.charAt(increasableIdx)); // 99
            increasableIdx --;
        }

        StringBuilder sb = new StringBuilder();

        // 处理1 10 1000的case
        if(increasableIdx < 0) sb.append("1");
        else {
            int increasableNum = str.charAt(increasableIdx) - '0' + 1;
            sb.append(str, 0, increasableIdx).append(increasableNum);
        }

        // increasableIdx后面的数字需要生序排列
        return Integer.valueOf(sb.toString() + trailZeroList.toString() + reducableNum + headNineList.toString());
    }
    public static void main(String[] args) {
        SmallestIntegerSameN smallestIntegerSameN = new SmallestIntegerSameN();
        System.out.println(smallestIntegerSameN.solution(28)); //37
        System.out.println(smallestIntegerSameN.solution(734)); // 743
        System.out.println(smallestIntegerSameN.solution(1990)); // 2089
        System.out.println(smallestIntegerSameN.solution(1000));// 10000
    }
}
