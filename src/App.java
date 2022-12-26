import javax.swing.JFrame;

public class App {
    public static void main(String args[]) throws Exception {
        // A program that lets the user enter a sudoku puzzle
        // It can check if the solution is correct and show the solution
        
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SudokuPanel sudokuPanel = new SudokuPanel(9);

        // Add the SudokuPanel to the JFrame
        frame.getContentPane().add(sudokuPanel);

        frame.setSize(750, 750);
        frame.setVisible(true);
    }
}
