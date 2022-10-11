/**
 * @author limingxia
 * @Description TODO
 * @date 2022/10/10-20:02
 */
public class PlayCheck {
    public int solution(String[][] arr) {
        int n = arr.length;
        // locate o
        int row = -1, col = -1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (arr[i][j].equals("o")) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        return DFSHelper(arr, row, col);
    }

    private int DFSHelper(String[][] arr, int row, int col) {
        int n = arr.length;
        if(row<0 || row>n || col<0 || col>n) return 0;

        int max = 0;
        // leftup:i-1, j-1
        if(row-2>=0 && col-2>=0 && arr[row-1][col-1].equals("x") && arr[row-2][col-2].equals(".")) {
            arr[row][col] = ".";
            arr[row-1][col-1] = ".";
            arr[row-2][col-2] = "o";
            max = Math.max(max, 1+ DFSHelper(arr, row-2, col-2));

            arr[row][col] = "o";
            arr[row-1][col-1] = "x";
            arr[row-2][col-2] = ".";
        }

        // leftdown:i+1, j-1
        if(row+2<n && col-2>=0 && arr[row+1][col-1].equals("x") && arr[row+2][col-2].equals(".")) {
            arr[row][col] = ".";
            arr[row+1][col-1] = ".";
            arr[row][col] = "o";
            max = Math.max(max, 1+ DFSHelper(arr, row+2, col-2));

            arr[row][col] = "o";
            arr[row+1][col-1] = "x";
            arr[row][col] = ".";
        }

        // rightup:i-1, j+1
        if(row-2>=0 && col+2<n && arr[row-1][col+1].equals("x") && arr[row-2][col+2].equals(".")) {
            arr[row][col] = ".";
            arr[row-1][col+1] = ".";
            arr[row-2][col+2] = "o";
            max = Math.max(max, 1+ DFSHelper(arr, row-2, col+2));

            arr[row][col] = "o";
            arr[row-1][col+1] = "x";
            arr[row-2][col+2] = ".";
        }

        // rightdown:i+1, j+1
        if(row+2<n && col+2<n && arr[row+1][col+1].equals("x") && arr[row+2][col+2].equals(".")) {
            arr[row][col] = ".";
            arr[row+1][col+1] = ".";
            arr[row+2][col+2] = "o";
            max = Math.max(max, 1+ DFSHelper(arr, row+2, col+2));

            arr[row][col] = "o";
            arr[row+1][col+1] = "x";
            arr[row+2][col+2] = ".";
        }

        return max;
    }





    public static void main(String[] args) {
        PlayCheck playCheck = new PlayCheck();
        String[][] s1 = {
                {".",".","x",".",".","."},
                {".",".",".",".",".","."},
                {".",".",".",".","x","."},
                {".","x",".",".",".","."},
                {".",".","x",".","x","."},
                {".",".",".","o",".","."},
        };
        System.out.println(playCheck.solution(s1)); // 2

        String[][] s2 = {
                {"x",".",".",".","."},
                {".","x",".",".","."},
                {".",".","o",".","."},
                {".",".",".","x","."},
                {".",".",".",".","x"}
        };
        System.out.println(playCheck.solution(s2)); // 0

        // #5x5 board with no movement, expected value = 0
        // A = ['...X.', '.X...', '.O...', '...X.', '.....']
        String[][] s3 = {
                {".",".",".","x","."},
                {".","x",".",".","."},
                {".","o",".",".","."},
                {".",".",".","x","."},
                {".",".",".",".","."}
        };
        System.out.println(playCheck.solution(s3)); // 0

        // B = ['.X...', '.X...', '..O..', '...X.', '.....']
        String[][] s4 = {
                {".","x",".",".","."},
                {".","x",".",".","."},
                {".","","o",".","."},
                {".",".",".","x","."},
                {".",".",".",".","."}
        };
        System.out.println(playCheck.solution(s4)); // 1

        String[][] s5 = {
                {".","x",".",".",".",".","."},
                {".","x",".","x",".",".","."},
                {".","","o",".",".",".","."},
                {".",".",".","x",".",".","."},
                {".",".",".",".",".",".","."},
                {".",".",".",".",".","x","."},
                {".",".",".",".",".",".","."}
        };
        System.out.println(playCheck.solution(s5)); // 2

    }
}
