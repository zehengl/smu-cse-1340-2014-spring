import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlavorsPanel extends JPanel {
	private JLabel title;
	private JCheckBox[] checkboxes;
	private ArrayList<String> flavors;
	private JPanel sectionPanel;
	private String recipe;
	// price for each flavor
	private double price = .6;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FlavorsPanel() {
		recipe = "";
		// add topping
		flavors = new ArrayList<String>();
		flavors.add("Vanilla");
		flavors.add("Chocolate");
		flavors.add("Strawberry");
		flavors.add("Mango");

		// initialization

		this.sectionPanel = new JPanel();
		sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
		title = new JLabel("Flavors");
		sectionPanel.add(title);
		checkboxes = new JCheckBox[flavors.size()];
		for (int i = 0; i < flavors.size(); i++) {
			checkboxes[i] = new JCheckBox(flavors.get(i));
			sectionPanel.add(checkboxes[i]);
		}
		this.add(sectionPanel);
	}

	public double getSubTotal() {
		int selected = 0;
		recipe = "";
		for (int i = 0; i < flavors.size(); i++) {
			if (checkboxes[i].isSelected()) {
				selected++;
				recipe += flavors.get(i) + ", ";
			}
		}
		recipe = recipe.replaceAll(", $", "");
		return price * selected;
	}

	public String getRecipe() {
		return recipe;
	}

}
