public class SumofConsecutiveNum {

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();) {
            int j = i+1;
            while(j < str.length()) {
                if(str.charAt(i) == str.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            int sum = (j - i) * (str.charAt(i) - '0');
            sb.append(sum);

            i = j;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SumofConsecutiveNum sumofConsecutiveNum = new SumofConsecutiveNum();
        System.out.println(sumofConsecutiveNum.solution("999433")); // 2746
        System.out.println(sumofConsecutiveNum.solution("44488366664")); // 12163244
    }
}
