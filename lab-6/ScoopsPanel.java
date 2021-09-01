import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ScoopsPanel extends JPanel {
	private JLabel title;
	private JRadioButton[] radiobuttons;
	private ArrayList<String> scoops;
	private JPanel sectionPanel;
	private String recipe;
	// price for each scoop
	private double price = 1.0;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ScoopsPanel() {
		// set scoops
		scoops = new ArrayList<String>();
		scoops.add("One");
		scoops.add("Two");
		scoops.add("Three");

		// initialization

		this.sectionPanel = new JPanel();
		sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
		title = new JLabel("Scoops");
		sectionPanel.add(title);
		ButtonGroup bg = new ButtonGroup();
		radiobuttons = new JRadioButton[scoops.size()];
		for (int i = 0; i < scoops.size(); i++) {
			radiobuttons[i] = new JRadioButton(scoops.get(i));
			sectionPanel.add(radiobuttons[i]);
			bg.add(radiobuttons[i]);
		}
		this.add(sectionPanel);

		radiobuttons[0].setSelected(true);

	}

	public double getSubtotal() {
		int selected = 0;
		recipe = "";
		for (int i = 0; i < scoops.size(); i++) {
			if (radiobuttons[i].isSelected()) {
				selected = i;
				recipe = scoops.get(i);
			}
		}
		return price * (selected + 1);
	}

	public String getRecipe() {
		return recipe;
	}
}
