package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Place for your code.
 */
public class SudokuSolver {

    ArrayList<Integer>[][] sudoku_board = new ArrayList[9][9];

    /**
     * @return names of the authors and their student IDs (1 per line).
     */
    public String authors() {
        // TODO write it;
        return "NAMES OF THE AUTHORS AND THEIR STUDENT IDs (1 PER LINE):\n Sitao Lu 58055154\n Hanlin Liu 56540131";
    }

    /**
     * stored sudoku into arraylist
     * blank space initialized with 1-9 as potential answer
     *
     * @param board the 2d int array representing the Sudoku board. Zeros indicate unfilled cells.
     */

    public void initialize(int[][] board) {
        ArrayList<Integer> cloneable_array = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++) {
            cloneable_array.add(i);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    sudoku_board[i][j] = new ArrayList<Integer>();
                    sudoku_board[i][j].add(board[i][j]);
                } else {
                    sudoku_board[i][j] = (ArrayList<Integer>) cloneable_array.clone();
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku_board[i][j].size() == 1) {
                    sudoku_board = update_pb(i, j, sudoku_board[i][j].get(0), sudoku_board);
                }
            }
        }
    }

    /**
     * @param row
     * @param col
     * @param key
     */
    public ArrayList<Integer>[][] update_pb(int row, int col, Integer key, ArrayList<Integer>[][] sudoku_board) {
        for (int i = 0; i < 8; i++) {
            if (i != row && sudoku_board[i][col].contains(key)) {
                sudoku_board[i][col].remove(sudoku_board[i][col].indexOf(key));
            }
        }
        for (int j = 0; j < 8; j++) {
            if (j != col && sudoku_board[row][j].contains(key)) {
                sudoku_board[row][j].remove(sudoku_board[row][j].indexOf(key));
            }
        }
        for (int i = 3 * (row / 3); i < 3 * (row / 3) + 3; i++) {
            for (int j = 3 * (col / 3); j < 3 * (col / 3) + 3; j++) {
                if (j != col && i != row && sudoku_board[i][j].contains(key)) {
                    sudoku_board[i][j].remove(sudoku_board[i][j].indexOf(key));
                }
            }
        }
        return sudoku_board;
    }

    public TreeMap addToDoArc() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map.put(Integer.toString(i) + Integer.toString(j), sudoku_board[i][j].size());
            }
        }
        sorted_map.putAll(map);
        return sorted_map;
    }

    /**
     * Performs constraint satisfaction on the given Sudoku board using Arc Consistency and Domain Splitting.
     *
     * @param board the 2d int array representing the Sudoku board. Zeros indicate unfilled cells.
     * @return the solved Sudoku board
     */
    public int[][] solve(int[][] board) {
        // TODO write it;
        initialize(board);
        //System.out.println("\n" + SudokuUtil.formatBoard_AL(sudoku_board));
        TreeMap map = addToDoArc();
        while(!map.lastEntry().getValue().equals(1)&& map.firstEntry().getValue().equals(1)){

        }
        return null;
    }


}

