import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OutputPanel extends JPanel {

	private JTextArea output;

	public OutputPanel() {
		this.output = new JTextArea(450, 300);
		this.output.setEditable(true);
		this.setLayout(new BorderLayout());
		this.add(output, BorderLayout.CENTER);
	}

	public void setMessage(String s) {
		output.setText(s);
	}

}
