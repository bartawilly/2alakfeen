package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.TasteController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Taste extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taste window = new Taste();
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
	public Taste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Taste ");
		setBounds(100, 100, 433, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAddTaste = new JLabel("Taste");
		lblAddTaste.setBounds(3, 11, 66, 14);
		getContentPane().add(lblAddTaste);
		
		textField = new JTextField();
		textField.setBounds(81, 33, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 83, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 129, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Taste");
		lblNewLabel.setBounds(3, 36, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(3, 86, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name/Email");
		lblNewLabel_2.setBounds(3, 132, 164, 14);
		getContentPane().add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("To User");
		rdbtnNewRadioButton.setBounds(93, 7, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("To Place");
		rdbtnNewRadioButton_1.setBounds(216, 7, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("To Brand");
		rdbtnNewRadioButton_2.setBounds(330, 7, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TasteController TC=new TasteController();
				if(rdbtnNewRadioButton.isSelected()&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false){
					try {
						TC.addTasteController(textField.getText(), textField_1.getText(),textField_2.getText() , 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton_1.isSelected()&&rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false){
					try {
						TC.addTasteController(textField.getText(), textField_1.getText(),textField_2.getText() , 2);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton_2.isSelected()&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton.isSelected()==false){
					try {
						TC.addTasteController(textField.getText(), textField_1.getText(),textField_2.getText() , 3);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, " ERROR IN YOUR CHOICE !!!! ");
				}
				
			}
		});
		btnNewButton.setBounds(32, 160, 89, 23);
		getContentPane().add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(294, 33, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name/Email");
		lblNewLabel_3.setBounds(215, 36, 69, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TasteController TC=new TasteController();
				if(rdbtnNewRadioButton.isSelected()&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false){
					try {
						TC.searchTasteController(textField_3.getText(), 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton_1.isSelected()&&rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false){
					try {
						TC.searchTasteController(textField_3.getText(), 2);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton_2.isSelected()&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton.isSelected()==false){
					try {
						TC.searchTasteController(textField_3.getText(), 3);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, " ERROR IN YOUR CHOICE !!!! ");
				}
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(254, 66, 89, 23);
		getContentPane().add(btnNewButton_1);
	}
}
