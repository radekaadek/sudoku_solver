import javax.swing.JButton;

public class CheckButton extends JButton {
    // Checks if the solution is valid
    public CheckButton(SudokuPanel panel) {
        setText("Check");
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int[] board = panel.getBoard();
                SudokuSolver solver = new SudokuSolver(board);
                if (solver.checkSolution()) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Correct!");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Incorrect!");
                }
            }
        });
    }
}
