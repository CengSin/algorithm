package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/5
 */

class LeetCode_999_Solution {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    return route(board, i, j, 0, -1) + route(board, i, j, 0, 1) + route(board, i, j, -1, 0) + route(board, i, j, 1, 0);
                }
            }
        }
        return 0;
    }

    private int route(char[][] board, int i, int j, int upOrDown, int leftOrRight) {
        int cnt = 0;

        while (i > 0 && j > 0 && i < board.length && j < board[i].length && board[i][j] != 'B') {
            if (board[i][j] == 'p') {
                cnt ++;
            }

            i += upOrDown;
            j += leftOrRight;
        }

        return cnt;
    }
}

public class LeetCode_999_AvailableCaptures4Rook {

    public static void main(String[] args) {
        LeetCode_999_Solution solution = new LeetCode_999_Solution();
        System.out.println(solution.numRookCaptures(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }

}
