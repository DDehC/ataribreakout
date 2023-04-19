package game_engine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class HighScoreList extends JPanel {

	private JFrame frame;
	private DefaultListModel highscoreData;
	private JList listElement;
	private JLabel label;
	private Bricks bricks; // Reference to Bricks class
	private JLabel scoreLabel; // Label to display score

	HighScoreList() {
		setLayout(new BorderLayout());
		highscoreData = new DefaultListModel();
		listElement = new JList(highscoreData);
		add(listElement);
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);

		label = new JLabel("HIGH SCORES");
		label.setFont(new Font(null, Font.BOLD, 15));
		label.setForeground(Color.yellow);
		label.setBackground(Color.black);
		label.setOpaque(true);
		panel.add(label);

		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
		mainPanel.add(listElement);
		mainPanel.add(panel);
		add(label, BorderLayout.NORTH);
	}

	public void newScore(String Name, int point) {
		highscoreData.addElement(Name + "- " + point);
		List<String> elementSort = new ArrayList<>();
		for (int i = 0; i < highscoreData.getSize(); i++) {
			elementSort.add((String) highscoreData.getElementAt(i));
		}
		Collections.sort(elementSort, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int tal1 = Integer.parseInt(o1.split("- ")[1]);
				int tal2 = Integer.parseInt(o2.split("- ")[1]);
				return Integer.compare(tal2, tal1);
			}
		});

		highscoreData.removeAllElements();
		for (int i = 0; i < elementSort.size(); i++) {
			highscoreData.addElement(elementSort.get(i));
		}

		if (highscoreData.size() > 10) {
			int indexToRemove = highscoreData.size() - 1;
			highscoreData.remove(indexToRemove);
		}
	}
}
