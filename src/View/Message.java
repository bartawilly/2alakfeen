package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import Controller.MessageController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Message extends JFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message window = new Message();
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
	public Message() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 432, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(128, 49, 226, 55);
		getContentPane().add(textPane);
		
		JLabel lblYourMessage = new JLabel("Your Message");
		lblYourMessage.setBounds(22, 72, 74, 14);
		getContentPane().add(lblYourMessage);
		
		JLabel lblTo = new JLabel("Reciever Mail");
		lblTo.setBounds(22, 144, 74, 14);
		getContentPane().add(lblTo);
		
		textField = new JTextField();
		textField.setBounds(128, 141, 226, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageController MC=new MessageController ();
				int ID_sender=Sign_in.ID;
				try {
					MC.SendMessageController(ID_sender, textField.getText(), textPane.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSend.setBounds(175, 199, 89, 23);
		getContentPane().add(btnSend);
	}
}
