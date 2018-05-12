package sampling_methods;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RandomDType extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomDType frame = new RandomDType();
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
	public RandomDType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIMPLE RANDOM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(180, 40, 400, 50);
		panel.add(lblNewLabel);
		
		JButton num_btn = new JButton("NUMERICAL");
		num_btn.setBackground(new Color(30, 144, 255));
		num_btn.setFont(new Font("Arial", Font.BOLD, 20));
		num_btn.setForeground(new Color(255, 255, 255));
		num_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		num_btn.setBounds(255, 149, 255, 44);
		panel.add(num_btn);
		
		JButton char_btn = new JButton("CHARACTER");
		char_btn.setBackground(new Color(30, 144, 255));
		char_btn.setFont(new Font("Arial", Font.BOLD, 20));
		char_btn.setForeground(new Color(255, 255, 255));
		char_btn.setBounds(255, 268, 255, 44);
		panel.add(char_btn);
	}

}
