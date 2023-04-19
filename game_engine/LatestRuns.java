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

public class LatestRuns extends JPanel {
	
	private JFrame frame;
	private DefaultListModel latestrunsData;
	private JList listElement;
	private JLabel label;
	
	LatestRuns() {
		setLayout(new BorderLayout());
		latestrunsData = new DefaultListModel();
		listElement = new JList(latestrunsData);
		add(listElement);
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		
		label = new JLabel("LATEST RUNS");
		label.setFont(new Font(null, Font.BOLD, 15));
		label.setForeground(Color.yellow);
		label.setBackground(Color.black);
		label.setOpaque(true);
		panel.add(label);
		
		JPanel mainPanel = new JPanel(new GridLayout(2, 1));
		mainPanel.add(listElement);
		mainPanel.add(panel);
		add(label, BorderLayout.NORTH); 
		
		frame = new JFrame("Latest Runs");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(300, 350);
		frame.setBackground(Color.black);
		
		frame.add(this);
		frame.setLocation(950, 350);
		
		frame.setVisible(true);
		}
}