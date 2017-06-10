package Model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.Database;

public class UserModel {
private int ID;
private String uname;
private String password;
private String type;
private String email;
private Database db=new Database();

	public UserModel( String uname, String password, String type, String email) {
	
	this.uname = uname;
	this.password = password;
	this.type = type;
	this.email = email;
}
	public UserModel() {
		
		uname="";
		password="";
		type="";
		email="";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

public void addNewUser(  String uname,String password,String email,String type,String CreditCard) throws Exception

{//**************added***********
	db.readDataBase();
	//System.out.println(email);
	//System.out.println(db.searchUserin(email));
	if(db.searchUserin(email)==-1){
	db.addUser(uname, password, email, type, CreditCard);
	}
	else{
		JOptionPane.showMessageDialog(null, " this user is aready here please enter another one");
	}
		//System.out.println(uname+" "+password+" "+type+" "+email+" "+CreditCard);
}
public int getUser(String email) throws Exception
{  
	 int found=-1;
	    db.readDataBase();
		found=db.searchUserin(email) ;
		return found;
}
public int getUser(String email,String Password) throws Exception
{  int found=-1;
    db.readDataBase();
   
	found=db.searchUser(email, Password) ;
	return found;
}
public void deleteUser(String email)
{
	// search fe el database b el email w shelo
	
}


public void AddFriendModel(int ID_sender,String emailReciever) throws Exception
{
	db.readDataBase();
	
	
	if(getUser(emailReciever)!=-1){
		
		db.AddFriendDB(ID_sender, emailReciever);
		JOptionPane.showMessageDialog(null, "Add request sent to : " +emailReciever);
		
		}
		else{
			JOptionPane.showMessageDialog(null, "No user with this email");
		}
}


public void SearchUM(String email) throws Exception
{
	db.readDataBase();
	
	
	UserModel u=new UserModel();
	u=db.searchuserobj(email);
	
	//3aby el 7agat eli fe el data base eli l2eto fe el object
	if(getUser(email)!=-1){
		
		JOptionPane.showMessageDialog(null," name: "+u.uname+" type: "+u.type+"email: "+ email);

		
	}
	else{
		JOptionPane.showMessageDialog(null, " No user with this name");
	}
	
	
}


public void UpdateUserModel(String name,String password,int ID) throws Exception
{
	db.readDataBase();
	db.UpdateUserDB(name, password, ID);
	
	
	
	
}
public void UpgradeUserModel(String creditcard,int ID) throws Exception
{
	db.readDataBase();
	db.UpgradeUserDB(creditcard, ID);

	
	
	
}
public void CheckInModel(String name,String text,int ID) throws Exception
{
	db.readDataBase();
	if(db.searchplaceIN( name)!=-1){
	db.CheckInDB(name, text, ID);
	}
	else{
		JOptionPane.showMessageDialog(null, " No place with this name");
	}
	
	
	
}
public int verifycreditcardModel(String CreditCard) throws Exception
{
	db.readDataBase();
	if(db.searchCreditcardin(CreditCard)!=-1&&db.searchUserinCC(CreditCard)==-1){
		return 1;
	}
	return-1;
	
}


}
