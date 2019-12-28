package io.lc.prep.game;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 *
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 *
 * TicTacToe toe = new TicTacToe(3);
 *
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 *
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 *
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 *
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 *
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 *
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 *
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 */
class LC348DesignTicTacToe {

    int result = 0;
    int n = -1;
    int[] rows = null;
    int[] cols = null;
    int diagonal = 0;
    int antiDiagonal = 0;

    /** Initialize your data structure here. */
    public LC348DesignTicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        //keep toggling the player move
        player = player == 1 ? 1 : -1;

        //Handle the count for the player one
        if(player == 1) {
            rows[row]++;
            cols[col]++;
            // then diagonal condition
            if(row == col) {diagonal++;}

            // for anti-diagonal condition the formula is boardsize - 1(which is due to index) - column
            if(row == n -1 - col) {antiDiagonal++;}

            //finally condition to check if a player is win, is through checking each place for the board-size.
            if(rows[row] == n || cols[col] == n || diagonal == n || antiDiagonal == n) return 1;
            else return 0;
        } else {
            //In case of the player 2 condition just do opposite
            rows[row]--;
            cols[col]--;
            if(row==col){diagonal--;}
            if(row == n -1 - col) {antiDiagonal--;}

            //finally to check the answer, multiply the result with -1 so that can be compared to the board-size
            if(rows[row] * -1 == n || cols[col] * -1 == n || diagonal * -1 == n || antiDiagonal * -1 == n) return 2;
            else return 0;
        }
    }
}