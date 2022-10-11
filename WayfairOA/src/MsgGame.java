/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/5-09:25
 */
public class MsgGame {
    /*
        There are N people, numbered from 0 to N-1, playing a game. The K-th person is assigned the letter S[K].
        At the beginning the oth person sends a message, consisting of a single letter S[0], to the A[O]-th person.
        When the K-th person receives the message, they append their letter S[K] to the message and forward it to A[K].
        The game ends when the oth person receives the message. Find the final message.
        You can assume that A contains every integer from 0 to N-1 exactly once.
        Write a function: def solution(S, A) that given a string S and an array of
        integers A, both of length N, returns a string denoting the final message received by the Oth person.
     */
    public String solution(String S, int[] A) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(true) {
            sb.append(S.charAt(i));
            int K = A[i];
            if(K == 0) break; // 0th person receives msg ==> stop
            sb.append(S.charAt(K));
            i = A[K];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MsgGame msgGame = new MsgGame();
        String S1 = "cdeo";
        int[] A1 = new int[]{3,2,0,1};
        System.out.println(msgGame.solution(S1, A1)); // code

        String S2 = "cdeenetpi";
        int[] A2 = new int[]{5,2,0,1,6,4,8,3,7};
        System.out.println(msgGame.solution(S2, A2)); // centipede

        String S3 = "bytdag";
        int[] A3 = new int[]{4,3,0,1,2,5};
        System.out.println(msgGame.solution(S3, A3)); // bat
    }
}
