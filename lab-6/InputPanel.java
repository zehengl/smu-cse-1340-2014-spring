import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputPanel extends JPanel {
	private JPanel scoops;
	private JPanel flavors;
	private ImageIcon logo;
	private JPanel toppings;
	private JPanel holders;
	private JPanel sectionPanel;

	public InputPanel() {
		scoops = new ScoopsPanel();
		flavors = new FlavorsPanel();
		holders = new HolderPanel();
		toppings = new ToppingPanel();
		logo = new ImageIcon("ice_cream.jpg");

		this.sectionPanel = new JPanel();
		sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.X_AXIS));

		sectionPanel.add(scoops);
		sectionPanel.add(flavors);
		sectionPanel.add(new JLabel(logo));
		sectionPanel.add(toppings);
		sectionPanel.add(holders);
		this.add(sectionPanel);

	}

	public double getTotal() {
		return ((ScoopsPanel) scoops).getSubtotal() + ((ToppingPanel) toppings).getSubtotal()
				+ ((HolderPanel) holders).getSubtotal() + ((FlavorsPanel) flavors).getSubTotal();
	}

	public String getSummary() {
		String result = "";
		double total = getTotal();
		result += "You ordered " + ((ScoopsPanel) scoops).getRecipe() + " scoop(s) of:\n";
		result += ((FlavorsPanel) flavors).getRecipe() + "\nwith:\n";
		result += ((ToppingPanel) toppings).getRecipe() + "\nin a ";
		result += ((HolderPanel) holders).getRecipe() + "\n";
		result += "Your total is $" + total;

		return result;
	}

}
