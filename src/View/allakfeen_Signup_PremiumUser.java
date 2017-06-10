package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import others.PremiumUser;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class allakfeen_Signup_PremiumUser extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JButton btnNewButton;

//	private JFrame frmallakFeenSignup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allakfeen_Signup_PremiumUser window = new allakfeen_Signup_PremiumUser();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public allakfeen_Signup_PremiumUser() {
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setTitle("2allak feen Signup Premium User");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 422);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(191, 66, 208, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 106, 208, 29);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 191, 206, 29);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 151, 208, 29);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(45, 70, 94, 17);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(45, 111, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(45, 192, 86, 23);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(45, 149, 72, 22);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Credit Card no.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(45, 226, 138, 32);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(191, 230, 208, 29);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.setIcon(new ImageIcon("rsz_2426153591_check_mark_11_xxl_answer_1_xlarge.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(146, 295, 163, 50);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String name= textField.getText();
			String password= textField_1.getText();
			String email= textField_3.getText();
			String type= textField_2.getText();
			String creditcard=textField_4.getText();
			PremiumUser user = new PremiumUser();
			try {
				
				user.signup(name, password, email, type,creditcard );
				dispose();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
	}
}
