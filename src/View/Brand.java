package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.BrandController;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Brand extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	BrandController BC=new BrandController();
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brand window = new Brand();
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
	public Brand() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Brand ");
		setBounds(100, 100, 430, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	
	textField = new JTextField();
	textField.setText("");
	textField.setBounds(91, 11, 86, 20);
	getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(91, 42, 86, 20);
	getContentPane().add(textField_1);
	textField_1.setColumns(10);
	
	JButton btnNewButton = new JButton("Add Brand");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int owner_id=Sign_in.ID;
			
				try {
					BC.addBrandController(textField.getText(), textField_2.getText(), textField_1.getText(), owner_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			
			
		}
	});
	btnNewButton.setBounds(39, 102, 106, 23);
	getContentPane().add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Place Name");
	lblNewLabel.setBounds(10, 45, 71, 14);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Tip");
	lblNewLabel_1.setBounds(10, 70, 46, 14);
	getContentPane().add(lblNewLabel_1);
	
	textField_2 = new JTextField();
	textField_2.setBounds(91, 73, 86, 20);
	getContentPane().add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblBrandName = new JLabel("Brand Name");
	lblBrandName.setBounds(10, 14, 71, 14);
	getContentPane().add(lblBrandName);
	
	textField_3 = new JTextField();
	textField_3.setBounds(294, 42, 86, 20);
	getContentPane().add(textField_3);
	textField_3.setColumns(10);
	
	textField_4 = new JTextField();
	textField_4.setBounds(294, 67, 86, 20);
	getContentPane().add(textField_4);
	textField_4.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("New Brand Name");
	lblNewLabel_2.setBounds(201, 45, 84, 14);
	getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Tip");
	lblNewLabel_3.setBounds(201, 70, 46, 14);
	getContentPane().add(lblNewLabel_3);
	
	JButton btnNewButton_1 = new JButton("Update Brand");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			int user_id=Sign_in.ID;
			
			
			try {
				BC.UpdateBrandCOntroller(textField_7.getText(), textField_3.getText(), textField_4.getText(),user_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	btnNewButton_1.setBounds(252, 102, 106, 23);
	getContentPane().add(btnNewButton_1);
	
	textField_5 = new JTextField();
	textField_5.setBounds(138, 163, 86, 20);
	getContentPane().add(textField_5);
	textField_5.setColumns(10);
	
	JButton btnNewButton_2 = new JButton("Search");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				BC.SearchBrandController(textField_5.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnNewButton_2.setBounds(250, 162, 89, 23);
	getContentPane().add(btnNewButton_2);
	
	JLabel lblNewLabel_4 = new JLabel("Brand Name");
	lblNewLabel_4.setBounds(57, 166, 71, 14);
	getContentPane().add(lblNewLabel_4);
	
	textField_6 = new JTextField();
	textField_6.setBounds(138, 194, 86, 20);
	getContentPane().add(textField_6);
	textField_6.setColumns(10);
	
	JLabel lblBrandName_1 = new JLabel("Brand Name");
	lblBrandName_1.setBounds(57, 197, 66, 14);
	getContentPane().add(lblBrandName_1);
	
	JButton btnDelete = new JButton("Delete");
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int user_id=Sign_in.ID;
			try {
				BC.deleteBrandController(textField_6.getText(),user_id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnDelete.setBounds(250, 196, 89, 23);
	getContentPane().add(btnDelete);
	
	textField_7 = new JTextField();
	textField_7.setBounds(294, 11, 86, 20);
	getContentPane().add(textField_7);
	textField_7.setColumns(10);
	
	JLabel lblNewBrandName = new JLabel("Old Brand Name");
	lblNewBrandName.setBounds(201, 14, 84, 14);
	getContentPane().add(lblNewBrandName);
	}
}
