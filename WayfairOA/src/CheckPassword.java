/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/6-10:24
 */
public class CheckPassword {
    public boolean solution(String S) {
        int N = S.length();
        if(N < 6) return false;

        boolean digit = false, lowLetter = false, upLetter = false, specialChar = false;
        for(int i=0;i<N;i++) {
            if(S.charAt(i)>='A' && S.charAt(i)<='Z') upLetter = true;
            if(S.charAt(i)>='a' && S.charAt(i)<='z') lowLetter = true;
            if(S.charAt(i)>='0' && S.charAt(i)<='9') digit = true;
            if(S.charAt(i) == '!' || S.charAt(i) == '@' || S.charAt(i) == '#' || S.charAt(i) == '$' ||
                    S.charAt(i) == '%' || S.charAt(i) == '^' || S.charAt(i) == '&' || S.charAt(i) == '*' ||
                    S.charAt(i) == '(' ||S.charAt(i) == ')' || S.charAt(i) == '_') specialChar = true;
            if(S.charAt(i) == ' ') return false;
        }

        return digit && lowLetter && upLetter && specialChar;
    }

    public static void main(String[] args) {
        CheckPassword checkPassword = new CheckPassword();

        String S1 = "FooBar123!"; // true
        System.out.println(checkPassword.solution(S1));

        String S2 = "fooBar123!"; // false
        System.out.println(checkPassword.solution(S2));

        String S3 = "FooBar123"; // false
        System.out.println(checkPassword.solution(S3));

        String S4 = "Foo Bar1231"; // false
        System.out.println(checkPassword.solution(S4));

        String S5 = "Fo0*"; // false
        System.out.println(checkPassword.solution(S5));
    }
}
