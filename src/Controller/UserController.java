package Controller;
import Model.UserModel;

public class UserController {

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	public void Searchcon(String email) throws Exception 
	{
	UserModel user= new UserModel ();
	user.SearchUM( email);
	}
	public int Logoin(String email,String password) throws Exception
	{
	//System.out.println(email+" "+password);
		
		UserModel user= new UserModel ();
		return user.getUser(email,password);
	}
	public void ForgetPassword(String email) throws Exception
	{
		
		UserModel user=new UserModel();
		if(user.getUser(email)!=-1){
			int x=user.getUser(email);
		//	user.updateUser(x);
		}
		
	}
	public void SendFriendRequest(int ID_sender,String emailReciever) throws Exception
	{UserModel user=new UserModel();
	user.AddFriendModel(ID_sender, emailReciever);
		
		
	}
	public void UpdateUserController(String name,String password,int ID) throws Exception
	{
		UserModel user=new UserModel();
		user.UpdateUserModel(name, password, ID);
		
		
		
		
	}
	public void CheckInController(String name,String text,int ID) throws Exception
	{
		UserModel user=new UserModel();
		user.CheckInModel(name, text, ID);
		
		
		
		
	}
	
	
	
	public void AcceptFriendRequest()
	{
		// lw el user 3aml accept li request galo yt3ml el booleaneen el etneen b true
		
		
	}
	
	/*public void GetCurrentActiveUser()
	{
		
		
	}*/
	public int verifycreditcardController(String CreditCard) throws Exception
	{ UserModel user=new UserModel();
		if(user.verifycreditcardModel(CreditCard)!=-1){
			return 1 ;
		}
		return -1;
		
	}
}
