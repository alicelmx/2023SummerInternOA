public class TicTacToeGame {
    public String solution(String[] moves) {
        int n = moves.length;
        int[] row = new int[n];
        int[] col = new int[n];
        int diagonal1 = 0;
        int diagonal2 = 0;
        int XCount = 0, YCount = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(moves[i].charAt(j) == 'X') {
                    XCount ++;
                    row[i] ++;
                    col[j] ++;
                    if(i == j) diagonal1 ++;
                    if(i+j == n-1) diagonal2 ++;

                    if(row[i]==n || col[j] == n || diagonal1 == n || diagonal2 == n)
                        return "X WIN";
                } else if(moves[i].charAt(j) == 'O') {
                    YCount ++;
                    row[i] --;
                    col[j] --;
                    if(i == j) diagonal1 --;
                    if(i+j == n-1) diagonal2 --;

                    if(row[i]==-n || col[j] == -n || diagonal1 == -n || diagonal2 == -n)
                        return "Y WIN";
                }
            }
        }

        return XCount + YCount == n * n ? "TIE" : "ONGOING";
    }
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();

        System.out.println(ticTacToeGame.solution(new String[]{"XO","X."})); // "X WIN"
        System.out.println(ticTacToeGame.solution(new String[]{"XOX","OXO",".X."})); // "ONGOING"
    }

}
