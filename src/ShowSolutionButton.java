import javax.swing.JButton;

public class ShowSolutionButton extends JButton {
    // Shows the solution to the puzzle
    public ShowSolutionButton(SudokuPanel panel) {
        setText("Show Solution");
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int[] board = panel.getBoard();
                SudokuSolver solver = new SudokuSolver(board);
                int[] solution = solver.solve();
                if (solution == null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "No solution found!");
                } else {
                    panel.setBoard(solution);
                }
            }
        });
    }
}
