import javax.swing.JButton;

public class ClearButton extends JButton {
    // Clears the solution from SudokuPanel.
    public ClearButton(SudokuPanel panel) {
        setText("Clear");
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // Ask the user if they want to clear the solution
                String message = "Are you sure you want to clear the solution?";
                int response = javax.swing.JOptionPane.showConfirmDialog(null, message, "Clear Solution", javax.swing.JOptionPane.YES_NO_OPTION);
                if (response == javax.swing.JOptionPane.YES_OPTION) {
                    panel.clear();
                }
            }
        });
    }
}
