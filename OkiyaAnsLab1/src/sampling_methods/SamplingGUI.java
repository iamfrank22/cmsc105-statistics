package sampling_methods;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SamplingGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SamplingGUI frame = new SamplingGUI();
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
	public SamplingGUI() {
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
		
		JLabel lblNewLabel = new JLabel("BASIC SAMPLING METHODS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(130, 40, 510, 50);
		panel.add(lblNewLabel);
		
		JButton random_btn = new JButton("SIMPLE RANDOM");
		random_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RandomDType().setVisible(true);
				new SamplingGUI().setVisible(false);
			}
		});
		random_btn.setBackground(new Color(30, 144, 255));
		random_btn.setForeground(new Color(255, 255, 255));
		random_btn.setFont(new Font("Arial", Font.BOLD, 20));
		random_btn.setBounds(248, 132, 250, 35);
		panel.add(random_btn);
		
		JButton systematic_btn = new JButton("SYSTEMATIC");
		systematic_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SystematicDType().setVisible(true);
				new SamplingGUI().setVisible(false);
			}
		});
		systematic_btn.setForeground(new Color(255, 255, 255));
		systematic_btn.setBackground(new Color(30, 144, 255));
		systematic_btn.setFont(new Font("Arial", Font.BOLD, 20));
		systematic_btn.setBounds(248, 205, 250, 35);
		panel.add(systematic_btn);
		
		JButton stratified_btn = new JButton("STRATIFIED");
		stratified_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StratifiedDType().setVisible(true);
				new SamplingGUI().setVisible(false);
			}
		});
		stratified_btn.setBackground(new Color(30, 144, 255));
		stratified_btn.setForeground(new Color(255, 255, 255));
		stratified_btn.setFont(new Font("Arial", Font.BOLD, 20));
		stratified_btn.setBounds(248, 281, 250, 35);
		panel.add(stratified_btn);
		
		JButton quit_btn = new JButton("QUIT");
		quit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		quit_btn.setForeground(new Color(255, 255, 255));
		quit_btn.setBackground(new Color(30, 144, 255));
		quit_btn.setFont(new Font("Arial", Font.BOLD, 20));
		quit_btn.setBounds(248, 360, 250, 35);
		panel.add(quit_btn);
	}
}
