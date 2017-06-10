package others;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.UserController;
import Model.UserModel;
import View.Home_page;
import View.allakfeen_Signup_PremiumUser;

public class PremiumUser extends UserController {

	public PremiumUser() {
		// TODO Auto-generated constructor stub
	}

	public void signup( String uname,String password,String email,String type,String CreditCard) throws Exception
	{
		UserController userr=new UserController();
		//System.out.println(email);
if(userr.verifycreditcardController(CreditCard)!=-1){
		UserModel user=new UserModel();
		user.addNewUser(  uname,password,email,type,CreditCard);
		
		Home_page home=new Home_page();
	
		
		home.setVisible(true);
}
else{
	JOptionPane.showMessageDialog(null, " CreditCard Is Not Valid");
}
		
	}
}
