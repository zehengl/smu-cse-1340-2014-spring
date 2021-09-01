import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IceCreamShop extends JFrame implements ActionListener {

	private JPanel input;
	private JButton submit;
	private JPanel output;
	private JPanel sectionPanel;

	public IceCreamShop() {
		input = new InputPanel();
		output = new OutputPanel();
		submit = new JButton("Submit Order");
		sectionPanel = new JPanel();
		sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
		sectionPanel.add(input);
		sectionPanel.add(submit);
		sectionPanel.add(output);
		this.add(sectionPanel);
		submit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submit) {
			String message = ((InputPanel) input).getSummary();
			((OutputPanel) output).setMessage("" + message);
		}
	}

}
