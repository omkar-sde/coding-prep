package org.neetcode150.arraysAndHashing;

import java.util.*;

public class ValidSudoku_36 {

    /*
        Problem Statement: Prefilled char matrix with ‘1-9 and ’.’. No duplicates in a row and col and 3x3 matrix
        Intuition: Hashset to store values in each row, col and box. Box index calc (i/3)*3+(j/3)
        Time Complexity: O(m^2)
        Space Complexity: O(m^2)
     */
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Set<Integer>[] row = new HashSet[len];
        Set<Integer>[] col = new HashSet[len];
        Set<Integer>[] box = new HashSet[len];

        for (int i = 0; i < len; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if (board[i][j] == '.') continue;

                int num = Integer.parseInt(String.valueOf(board[i][j]));

                // Step 1: Check row for duplicates
                if (row[i].contains(num)) return false;
                row[i].add(num);

                // Step 2: Check column for duplicates
                if (col[j].contains(num)) return false;
                col[j].add(num);

                // Step 3: Check 3x3 box for duplicates
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (box[boxIndex].contains(num)) return false;
                box[boxIndex].add(num);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku_36 obj = new ValidSudoku_36();

        char[][] validBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidBoard = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Valid board: " + obj.isValidSudoku(validBoard)); // Expected: true
        System.out.println("Invalid board: " + obj.isValidSudoku(invalidBoard)); // Expected: false
    }
}
