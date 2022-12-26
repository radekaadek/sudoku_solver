public class SudokuSolver {

    private int[] grid;
    private int size;

    public SudokuSolver(int[] grid) {
        this.grid = grid;
        this.size = (int) Math.sqrt(grid.length);
    }

    public boolean checkSolution() {
        // Check if the solution is correct
        
        // Check for any 0's in the grid
        if (findFirstEmptyCell(grid) != -1) {
            return false;
        }

        for (int position = 0; position < grid.length; position++) {
            int row = position / size;
            int column = position % size;
            int digit = grid[position];
            // Set the digit to 0 so that it doesn't interfere with the check
            grid[position] = 0;

            // Check if the digit is valid in the row, column, and box
            if (!couldBeValid(row, column, digit)) {
                grid[position] = digit;
                return false;
            }

            // Set the digit back to its original value
            grid[position] = digit;
        }
        return true;

    }

    public int[] solve() {
        return solveGuess(grid);
    }

    private int[] solveGuess(int[] grid) {
        // Solve the sudoku puzzle using a backtracking algorithm
        // Return the solved grid, or null if the puzzle is unsolvable

        int position = findFirstEmptyCell(grid);
        if (position == -1) {
            return grid;
        }

        int row = position / size;
        int column = position % size;

        for (int digit = 1; digit <= size; digit++) {
            if (couldBeValid(row, column, digit)) {
                grid[position] = digit;
                int[] solvedGrid = solveGuess(grid);
                if (solvedGrid != null) {
                    return solvedGrid;
                }
            }
        }
        grid[position] = 0;
        return null;
    }

    // Checks if the digit is already in the row, column, box
    private boolean containsRow(int row, int digit) {

        for (int column = 0; column < size; column++) {
            if (grid[row * size + column] == digit) {
                return true;
            }
        }
        return false;
    }

    private boolean containsColumn(int column, int digit) {

        for (int row = 0; row < size; row++) {
            if (grid[row * size + column] == digit) {
                return true;
            }
        }
        return false;
    }

    private boolean containsBox(int row, int column, int digit) {

        int boxSize = (int) Math.sqrt(size);
        int boxRow = row - row % boxSize;
        int boxColumn = column - column % boxSize;

        for (int i = boxRow; i < boxRow + boxSize; i++) {
            for (int j = boxColumn; j < boxColumn + boxSize; j++) {
                if (grid[i * size + j] == digit) {
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if the digit is valid in the specified row, column, and box
    private boolean couldBeValid(int row, int column, int digit) {
        return !containsRow(row, digit) &&
        !containsColumn(column, digit) &&
        !containsBox(row, column, digit);
    }

    private int findFirstEmptyCell(int[] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}