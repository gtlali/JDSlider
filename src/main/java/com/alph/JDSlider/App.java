package com.alph.JDSlider;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App {
	// label
	static JLabel l;

	public void buildGUI() {
		final JDSlider slider = new JDSlider(0, 600, 1);
		
		slider.setMajorTickSpacing(1000);
		slider.setMinorTickSpacing(100);
		slider.setPaintTicks(true);
		java.util.Hashtable<Integer, JLabel> labelTable = new java.util.Hashtable<Integer, JLabel>();
		labelTable.put(60000, new JLabel("600.00"));
		labelTable.put(55000, new JLabel("550.00"));
		labelTable.put(50000, new JLabel("500.00"));
		labelTable.put(45000, new JLabel("450.00"));
		labelTable.put(40000, new JLabel("400.00"));
		labelTable.put(35000, new JLabel("350.00"));
		labelTable.put(30000, new JLabel("300.00"));
		labelTable.put(25000, new JLabel("250.00"));
		labelTable.put(20000, new JLabel("200.00"));
		labelTable.put(15000, new JLabel("150.00"));
		labelTable.put(10000, new JLabel("100.00"));
		labelTable.put(5000, new JLabel("50.00"));
		labelTable.put(0, new JLabel("0.00"));
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true);

		JFrame f = new JFrame();
		// create label
		l = new JLabel();
		l.setName(slider.getLabelID());
		f.getContentPane().add(slider);

		f.pack();
		f.setLocationRelativeTo(null);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		slider.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent ce) {
				System.out.println(slider.getValue() / 100.0);
				l.setText("value of Slider is =" + slider.getValue() / 100.0);
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new App().buildGUI();
			}
		});
	}
}
