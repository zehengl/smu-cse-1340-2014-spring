import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToppingPanel extends JPanel {
	// components
	private JLabel title;
	private JCheckBox[] checkboxes;
	private ArrayList<String> toppings;
	private JPanel sectionPanel;
	private String recipe;
	// price for each toppings
	private double price = .5;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ToppingPanel() {
		recipe = "";
		// add topping
		toppings = new ArrayList<String>();
		toppings.add("Nuts");
		toppings.add("Cheeries");
		toppings.add("Chocolate Syrup");
		toppings.add("Sprinkles");
		toppings.add("Gummy Bears");
		toppings.add("M&Ms");
		toppings.add("Oreos");

		// initialization

		this.sectionPanel = new JPanel();
		sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
		title = new JLabel("Toppings");
		sectionPanel.add(title);
		checkboxes = new JCheckBox[toppings.size()];
		for (int i = 0; i < toppings.size(); i++) {
			checkboxes[i] = new JCheckBox(toppings.get(i));
			sectionPanel.add(checkboxes[i]);
		}
		this.add(sectionPanel);
	}

	public double getSubtotal() {
		int selected = 0;
		recipe = "";
		for (int i = 0; i < toppings.size(); i++) {
			if (checkboxes[i].isSelected()) {
				selected++;
				recipe += toppings.get(i) + ", ";
			}
		}
		recipe = recipe.replaceAll(", $", "");
		return price * selected;
	}

	public String getRecipe() {
		return recipe;
	}

}
