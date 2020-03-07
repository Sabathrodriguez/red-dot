/**
2 * @author sabathrodriguez
 * @date October 12, 2018
 */


package redCounter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RedCounter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedCounter frame = new RedCounter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RedCounter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = createLeGridPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = creatingLeLabels(panel);
		
		clickingLeButtonToChangeColor(panel, lblNewLabel_1);
	}

	
	/**
	 * This created a JPanel of type grid, that is all
	 * @return
	 */
	private JPanel createLeGridPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		return panel;
	}

	
	/**
	 * This simply created a label, all you have to to is all the panel it will be attaching itself to
	 * @param panel
	 * @return
	 */
	private JLabel creatingLeLabels(JPanel panel) {
		JLabel lblNewLabel = new JLabel("Sabaths GUI");
		lblNewLabel.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 15));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBorder(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Red Counter: 00");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		return lblNewLabel_1;
	}

	
	/**
	 * This creates a button and changes its color whenever it is clicked, just add the label you would like to change the color from
	 * @param panel
	 * @param lblNewLabel_1
	 */
	private void clickingLeButtonToChangeColor(JPanel panel, JLabel lblNewLabel_1) {
		Random rand = new Random();
		
		JButton btnClickMe = new JButton("Click Me");
		btnClickMe.setBorderPainted(false);
		btnClickMe.setForeground(Color.WHITE);
		btnClickMe.setOpaque(true);
		btnClickMe.setBackground(Color.BLUE);
		btnClickMe.addActionListener(new ActionListener() {
			int counter = 0;
			public void actionPerformed(ActionEvent e) {
				int num = rand.nextInt(5) + 1;
				if (num == 1) {
					btnClickMe.setBackground(Color.ORANGE);
				} else if (num == 2) {
					btnClickMe.setBackground(Color.GREEN);
				} else if (num == 3) {
					btnClickMe.setBackground(Color.BLUE);
				} else if (num == 4) {
					btnClickMe.setBackground(Color.MAGENTA);
				} else {
					btnClickMe.setBackground(Color.RED);
					lblNewLabel_1.setText(String.format("Red Counter: %02d", ++counter));
					
				}
			}
		});
		btnClickMe.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panel.add(btnClickMe);
	}

}
