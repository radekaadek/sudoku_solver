import javax.swing.JPanel;

public class SudokuPanel extends JPanel {
    // The SudokuPanel class is a JPanel that contains a grid of SudokuCells.
    // It contains buttons to:
    // check the solution
    // clear the solution
    // show the solution

    private SudokuCell[] cells;
    private CheckButton checkButton = new CheckButton(this);
    private ClearButton clearButton = new ClearButton(this);
    private ShowSolutionButton showSolutionButton = new ShowSolutionButton(this);

    // The constructor creates a new SudokuPanel with the specified size
    // It adds the SudokuCells to the panel, and adds the buttons to the panel.

    public SudokuPanel(int boardSize) {
        if (!checkLegalSize(boardSize)) {
            throw new IllegalArgumentException
            ("Size must be greater than or equal and a power of 3");
        }

        // add the SudokuCells to the panel
        setLayout(new java.awt.GridLayout(boardSize+1, boardSize));
        cells = new SudokuCell[boardSize*boardSize];
        for (int position = 0; position < boardSize*boardSize; position++) {
                cells[position] = new SudokuCell(boardSize);          
                add(cells[position]);
        }
        
        add(checkButton);
        add(clearButton);
        add(showSolutionButton);
    }

    public int[] getBoard() {
        int[] board = new int[cells.length];
        for (int position = 0; position < cells.length; position++) {
            board[position] = cells[position].getDigit();
        }
        return board;
    }

    public void clear() {
        for (int position = 0; position < cells.length; position++) {
            cells[position].setDigit(0);
        }
    }

    public void setBoard(int[] board) {
        for (int position = 0; position < cells.length; position++) {
            cells[position].setDigit(board[position]);
        }
    }

    private boolean checkLegalSize(int size) {
        if (size < 3) {
            return false;
        }
        // check if size is a power of 3
        while (size % 3 == 0) {
            size /= 3;
        }
        return size == 1;
    }
}
