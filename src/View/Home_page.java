package View;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.BrandController;
import Controller.CheckInController;
import Controller.PlaceController;
import Controller.UserController;
import others.NormalUser;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
public class Home_page extends JFrame {


	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page window = new Home_page();
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
	public Home_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Home Page ");
		setBounds(100, 100, 598, 533);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(200, 25, 166, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserController u=new UserController();
				try {
					u.Searchcon(textField.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(421, 24, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlaceController p=new PlaceController();
				double x= Double.parseDouble(textField_1.getText());
				try {
					p.rateAPlaceControler(textField_2.getText(),x );
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(421, 72, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(329, 73, 53, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 73, 166, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(285, 76, 46, 14);
	getContentPane().add(lblRate);
		
		JLabel lblPlace = new JLabel("Place");
		lblPlace.setBounds(9, 76, 46, 14);
		getContentPane().add(lblPlace);
		
		JButton btnNewButton_2 = new JButton("Check-in");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int user_id=Sign_in.ID;
				UserController user=new UserController();
				try {
					user.CheckInController(textField_3.getText(), textField_11.getText(),user_id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(468, 116, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 117, 98, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPlace_1 = new JLabel("Place Name");
		lblPlace_1.setBounds(9, 120, 71, 14);
		getContentPane().add(lblPlace_1);
		
		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ID_sender=Sign_in.ID;
				UserController user=new  UserController();
				try {
					user.SendFriendRequest(ID_sender,textField_4.getText() );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(346, 166, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 167, 171, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUserEmail = new JLabel("User E-mail");
		lblUserEmail.setBounds(10, 170, 71, 14);
		getContentPane().add(lblUserEmail);
		
		textField_5 = new JTextField();
		textField_5.setBounds(118, 212, 140, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlaceController p=new PlaceController();
				try {
					p.addNewPlaceControler(textField_5.getText(),textField_6.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(442, 211, 89, 23);
		getContentPane().add(btnNewButton_4);
		
		JLabel lblNewPlaceName = new JLabel("New Place Name");
		lblNewPlaceName.setBounds(10, 215, 89, 14);
		getContentPane().add(lblNewPlaceName);
		
		textField_6 = new JTextField();
		textField_6.setBounds(346, 212, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblUserEmail_1 = new JLabel("User E-mail");
		lblUserEmail_1.setBounds(88, 28, 86, 14);
		getContentPane().add(lblUserEmail_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaceController p=new PlaceController();
				try {
					p.SearchController(textField_7.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(421, 256, 89, 23);
		getContentPane().add(btnSearch);
		
		textField_7 = new JTextField();
		textField_7.setBounds(179, 257, 203, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPlaceName = new JLabel("Place Name");
		lblPlaceName.setBounds(53, 260, 89, 14);
		getContentPane().add(lblPlaceName);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(268, 215, 63, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int ID=Sign_in.ID;
				UserController user=new  UserController();
				try {
					user.UpdateUserController(textField_8.getText(), textField_9.getText(),ID);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_5.setBounds(421, 306, 89, 23);
		getContentPane().add(btnNewButton_5);
		
		textField_8 = new JTextField();
		textField_8.setBounds(118, 307, 86, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(299, 307, 86, 20);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewName = new JLabel("New Name");
		lblNewName.setBounds(23, 310, 74, 14);
		getContentPane().add(lblNewName);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(214, 310, 75, 14);
		getContentPane().add(lblNewPassword);
		
		textField_10 = new JTextField();
		textField_10.setBounds(131, 350, 251, 20);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("Upgrade");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ID=Sign_in.ID;
				NormalUser user=new  NormalUser();
				
					try {
						user.upgrade(textField_10.getText(),ID);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton_6.setBounds(421, 349, 89, 23);
		getContentPane().add(btnNewButton_6);
		
		JLabel lblCreditcardNo = new JLabel("CreditCard no.");
		lblCreditcardNo.setBounds(23, 353, 98, 14);
		getContentPane().add(lblCreditcardNo);
		
		textField_11 = new JTextField();
		textField_11.setBounds(315, 117, 86, 20);
		getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblFeeling = new JLabel("Feeling");
		lblFeeling.setBounds(256, 120, 46, 14);
		getContentPane().add(lblFeeling);
		
		JButton btnTaste = new JButton("Taste");
		btnTaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Taste t=new Taste();
		
				t.setVisible(true);
			}
		});
		btnTaste.setBounds(23, 423, 89, 23);
		getContentPane().add(btnTaste);
		
		JButton btnNewButton_7 = new JButton("Brand");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Brand b=new Brand();
		
				b.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(140, 423, 89, 23);
		getContentPane().add(btnNewButton_7);
		
		JButton btnGetOnlineUsers = new JButton("Get Online Users");
		btnGetOnlineUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Online o=new Online();
		
				o.setVisible(true);
			}
		});
		btnGetOnlineUsers.setBounds(268, 423, 133, 23);
		getContentPane().add(btnGetOnlineUsers);
		
		textField_12 = new JTextField();
		textField_12.setBounds(131, 381, 86, 20);
		getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblBrandName = new JLabel("Brand Name");
		lblBrandName.setBounds(33, 384, 66, 14);
		getContentPane().add(lblBrandName);
		
		JButton btnFollow = new JButton("Follow");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int user_id=Sign_in.ID;
				BrandController BC=new BrandController();
				try {
					BC.followBrandController(textField_12.getText(), user_id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnFollow.setBounds(239, 381, 89, 23);
		getContentPane().add(btnFollow);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AllakFeen a=new AllakFeen();
				a.setVisible(true);
			}
		});
		btnSignOut.setBounds(23, 460, 89, 23);
		getContentPane().add(btnSignOut);
		
		JButton btnNewButton_8 = new JButton("Message");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Message m=new Message();
				m.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(421, 423, 89, 23);
		getContentPane().add(btnNewButton_8);
		
		JButton btnCheckinPosts = new JButton("Checkin Posts");
		btnCheckinPosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*dispose();
				checkins c=new checkins();
				c.setVisible(true);*/
				CheckInController ch=new CheckInController();
				try {
				//	ch.showcheckinsController();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnCheckinPosts.setBounds(421, 389, 110, 23);
		getContentPane().add(btnCheckinPosts);
	}
}
