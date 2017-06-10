package View;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.UserController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sign_in extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	public static int ID=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_in window = new Sign_in();
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
	public Sign_in() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("2allak feen Sign In");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 422);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 98, 208, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 179, 208, 29);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		
		lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(45, 99, 72, 22);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(45, 184, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		
		
		
		
		btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserController user=new UserController();
			String email=textField.getText();
					String password=textField_1.getText();
				try {
					//System.out.println(ID);
					ID=user.Logoin(email, password);
					//System.out.println(ID);
					if(ID!=-1){
						dispose();
						Home_page home=new Home_page();
						home.setVisible(true);
						}
						else{
							
							JOptionPane.showMessageDialog(null, " please Sign Up first ");
							
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("rsz_2426153591_check_mark_11_xxl_answer_1_xlarge.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(141, 249, 163, 50);
		getContentPane().add(btnNewButton);
	}

}
