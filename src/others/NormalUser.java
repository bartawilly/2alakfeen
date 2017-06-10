package others;

import java.sql.SQLException;

import Controller.UserController;
import Model.UserModel;

public class NormalUser extends UserController {

	public NormalUser() {
		// TODO Auto-generated constructor stub
	}
	public void upgrade(String creditcard ,int ID) throws Exception
	{UserModel user=new UserModel();
	
		//user.updateUser(user.getUser(email));
		user.UpgradeUserModel(creditcard, ID);
		
	}
	
	public void signup( String uname,String password,String email,String type,String CreditCard) throws Exception
	{
//System.out.println(email);
		UserModel user=new UserModel();
		user.addNewUser(  uname,password,email,type,null);
		
	}
	
	

}
