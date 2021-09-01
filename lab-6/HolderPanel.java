import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HolderPanel extends JPanel {
	private JLabel title;
	private JRadioButton[] radiobuttons;
	private ArrayList<String> holders;
	private JPanel sectionPanel;

	// price for each scoop
	private ArrayList<Double> prices;
	private String recipe;

	public HolderPanel() {
		// set scoops
		holders = new ArrayList<String>();
		prices = new ArrayList<Double>();
		holders.add("Bowl");
		prices.add(1.0);
		holders.add("Cone");
		prices.add(1.5);

		// initialization

		this.sectionPanel = new JPanel();
		sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
		title = new JLabel("Bowl or Cone");
		sectionPanel.add(title);
		ButtonGroup bg = new ButtonGroup();
		radiobuttons = new JRadioButton[holders.size()];
		for (int i = 0; i < holders.size(); i++) {
			radiobuttons[i] = new JRadioButton(holders.get(i));
			sectionPanel.add(radiobuttons[i]);
			bg.add(radiobuttons[i]);
		}
		this.add(sectionPanel);
		radiobuttons[0].setSelected(true);
	}

	public double getSubtotal() {
		for (int i = 0; i < holders.size(); i++) {
			if (radiobuttons[i].isSelected()) {
				return prices.get(i);
			}
		}
		return 0;
	}

	public String getRecipe() {
		for (int i = 0; i < holders.size(); i++) {
			if (radiobuttons[i].isSelected()) {
				recipe = holders.get(i);
			}
		}
		return recipe;
	}
}
