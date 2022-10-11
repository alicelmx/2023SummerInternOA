/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/10-20:02
 */
public class DeleteBanana {
    public int solution(String S) {
        int[] letter = new int[26];

        for(char c : S.toCharArray()) {
            letter[c-'A']++;
        }
        int ACount = letter[0], BCount = letter['B'-'A'], NCount = letter['N'-'A'];

        return Math.min(Math.min(ACount/3, BCount), NCount/2);
    }
    public static void main(String[] args) {
        DeleteBanana deleteBanana = new DeleteBanana();
        String s1 = "NAABXXAN"; // XX 1
        System.out.println(deleteBanana.solution(s1));

        String s2 = "NAANAAXNABABYNNBZ"; // XBYNZ 2
        System.out.println(deleteBanana.solution(s2));

        String s3 = "QABAAAWOBL"; // 0
        System.out.println(deleteBanana.solution(s3));

    }
}
