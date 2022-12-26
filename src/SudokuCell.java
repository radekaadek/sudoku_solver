import javax.swing.BorderFactory;
import javax.swing.JTextField;

// The SudokuCell class is a JTextField that contains a single cell of a Sudoku puzzle.
// It contains a single character, which is either a digit or a space.
// It is editable, and only allows digits and spaces to be entered.
public class SudokuCell extends JTextField {
    
    public SudokuCell(int boardSize) {
        setPreferredSize(new java.awt.Dimension(50, 50));
        setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 24));
        setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK));
        setDigit(0);
        // prevent the user from entering anything if the cell isn't empty
        // and prevent the user from entering anything other than a digit
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                e.consume();
                if (e.getKeyChar() == '\b') {
                    setDigit(0);
                } else if ('1' <= e.getKeyChar() && e.getKeyChar() <= '9' && getDigit() == 0) {
                    setDigit(e.getKeyChar() - '0');
                }
            }
        });
    }


    // The setDigit() method sets the text of the cell to the specified digit.
    // If the digit is 0, the cell is set to empty.

    public void setDigit(int digit) {
        if (digit == 0) {
            setText(" ");
        } else if (digit >= 1 && digit <= 9) {
            setText(Integer.toString(digit));
        } else {
            throw new IllegalArgumentException("Digit must be between 1 and 9");
        }
    }


    // The getDigit() method returns the digit in the cell.
    // If the cell is empty, it returns 0.
    public int getDigit() {
        if (getText().equals(" ")) {
            return 0;
        } else {
            return Integer.parseInt(getText());
        }
    }

}
