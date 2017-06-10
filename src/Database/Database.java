package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.CheckInModel;
import Model.PlaceModel;
import Model.TasteModel;
import Model.UserModel;

public class Database {
	 public Connection connect = null;
	 public Statement statement = null;
	 public PreparedStatement preparedStatement = null;
	 public ResultSet resultSet = null;
	 
//**********************connect database**********************************************************	 
	 public void readDataBase() throws Exception 
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		 connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/2alakfeen", "root","");
		 statement = connect.createStatement();
	 }

	 
//**********************user model functions*******************************************************	 
     public void addUser( String uname,String password,String email,String type,String CreditCard) throws SQLException
		 {
    	 
    	 preparedStatement = connect.prepareStatement("insert into user values ( default, ?, ?, ?, ?, ?)");
    	 preparedStatement.setString(1, uname);
    	 preparedStatement.setString(2, password);
    	 preparedStatement.setString(3, type);
		 preparedStatement.setString(4, email);
		 
		 preparedStatement.setString(5, CreditCard);
	     preparedStatement.executeUpdate();
		 }
	 public int searchUser(String mail, String passWord) throws Exception
	 { 
		 
		 resultSet = statement.executeQuery("select ID  from user where email= '"+mail+"' AND password = '"+passWord+"'");
		 int userNum = -1;
		 while (resultSet.next()) {
			
			  userNum=resultSet.getInt("ID");
		 }
		
		 return userNum;
	 }
	 public UserModel searchuserobj(String email) throws SQLException
     { UserModel u= new UserModel();
    	 resultSet = statement.executeQuery("select ID,uname,email,type from user where email= '"+email+"'");
		 int placeNum = -1;
		 while (resultSet.next()) {
			  
			
			u.setUname(resultSet.getString("uname"));
			 u.setType(resultSet.getString("type"));
			 
		 
		 }
		 return u;
     }
	 public int searchUserin(String mail) throws SQLException
	 { 
		 
		 resultSet = statement.executeQuery("select ID  from user where email= '"+mail+"'");
		 int userNum = -1;
		 while (resultSet.next()) {
			  userNum=resultSet.getInt("ID");
		 }
		 return userNum;
	 }
	 
	 
//*********************place model functions*******************************************************
     public void addPlace(String name,String desc) throws SQLException
	 {
		    preparedStatement = connect.prepareStatement("insert into places values ( default,?,default,?,default)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, desc);
	        preparedStatement.executeUpdate();
	 }
     public PlaceModel searchplace(String name) throws SQLException
     { PlaceModel p= new PlaceModel();
    	 resultSet = statement.executeQuery("select ID ,name,checkInNO,description ,rate from places where name= '"+name+"'");
		// int placeNum = -1;
		 while (resultSet.next()) {
			  p.setID(resultSet.getInt("ID"));
			 p.setName(resultSet.getString("name"));
		  p.setNumberofcheckins(resultSet.getInt("checkInNO"));
			 p.setRate(resultSet.getDouble("rate"));
			 p.setDescription(resultSet.getString("description"));
		 }
		 return p;
     }
     
     
     public int searchplaceIN(String name) throws SQLException
     { 
    	 resultSet = statement.executeQuery("select ID  from places where name= '"+name+"'");
		int placeNum = -1;
		 while (resultSet.next()) {
			 placeNum =resultSet.getInt("ID");
			 
		 }
		 return  placeNum;
     }
     public void 	rateAPlaceDB (String name,Double rate ) throws SQLException {
    	 
    	 preparedStatement = connect.prepareStatement("update places set rate='"+rate+"' where name = '"+name+"'");
    	
    	 
    	 preparedStatement.executeUpdate();
         
       
    
 	}
 public void 	AddFriendDB (int ID_sender,String emailReciever) throws SQLException {
	 int ID_reciever=searchUserin(emailReciever);
    	
	  preparedStatement = connect.prepareStatement("insert into friends values ( default,?,?,default)");
		preparedStatement.setInt(1, ID_sender);
		preparedStatement.setInt(2, ID_reciever);
      preparedStatement.executeUpdate();
         
       
    
 	}
 public void 	UpdateUserDB (String name,String password ,int ID ) throws SQLException {
	 
	 preparedStatement = connect.prepareStatement("update user set uname ='"+name+"' where ID = '"+ID+"'");
	
	 
	 preparedStatement.executeUpdate();
     
 preparedStatement = connect.prepareStatement("update user set password ='"+password+"' where ID = '"+ID+"'");
	
	 
	 preparedStatement.executeUpdate();

	}
public void 	UpgradeUserDB (String creditcard ,int ID ) throws SQLException {
	 
	 preparedStatement = connect.prepareStatement("update user set creditcard ='"+creditcard+"' where ID = '"+ID+"'");
	
	 
	 preparedStatement.executeUpdate();
     
 

	}
public void CheckInDB(String name,String text,int user_id) throws SQLException{
	
	
	int place_id=searchplaceIN(name);
	
	
	
	  preparedStatement = connect.prepareStatement("insert into checkins_posts values ( default,?,?,?)");
			preparedStatement.setInt(1, place_id);
			preparedStatement.setInt(2, user_id);
			preparedStatement.setString(3, text);
	      preparedStatement.executeUpdate();
	      
	      
	      
	      resultSet = statement.executeQuery("select checkInNO  from places where ID= '"+place_id+"'");
			int checkNO = -1;
			 while (resultSet.next()) {
				 checkNO =resultSet.getInt("checkInNO");
				 
			 }
			 checkNO++;
			 preparedStatement = connect.prepareStatement("update places set checkInNO ='"+checkNO+"' where ID = '"+place_id+"'");
				
			 
			 preparedStatement.executeUpdate();
}
public void addBrandDB(String name,String tip,String place_name, int owner_id) throws SQLException
{
	 resultSet = statement.executeQuery("select creditcard  from user where ID= '"+owner_id+"'");
		String CC = null;
		 while (resultSet.next()) {
			 CC =resultSet.getString("creditcard");
			 
		 }
	if(CC!=null){
	int found =searchplaceIN( place_name);
	if(found!=-1){
	    preparedStatement = connect.prepareStatement("insert into brand values ( default,?,?,?,?)");
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, owner_id);
		preparedStatement.setInt(3, found);
		preparedStatement.setString(4, tip);
       preparedStatement.executeUpdate();
}
	else{
		JOptionPane.showMessageDialog(null, " No Place with this name");
	}
	}
	else{
		JOptionPane.showMessageDialog(null, " You are not a permium user");
	}
	}


public int SearchbrandIN(String name) throws SQLException 
{
	 resultSet = statement.executeQuery("select ID  from brand where name= '"+name+"'");
		int brandNum = -1;
		 while (resultSet.next()) {
			 brandNum =resultSet.getInt("ID");
			 
		 }
		 return  brandNum;
	
}
public void UpdateBrandDB(String oldname,String newname,String tip,int user_id) throws SQLException 
{

	resultSet = statement.executeQuery("select ownerID  from brand where name= '"+oldname+"'");
	 int onID = -1;
	 while (resultSet.next()) {
		 onID =resultSet.getInt("ownerID");
		 
	 }
	 if(user_id==onID){
		 
		 if(SearchbrandIN( oldname)!=-1){
	 preparedStatement = connect.prepareStatement("update brand set name ='"+newname+"' where name = '"+oldname+"'");
	 preparedStatement.executeUpdate();
	 preparedStatement = connect.prepareStatement("update brand set text ='"+tip+"' where name = '"+newname+"'");
	 
	 preparedStatement.executeUpdate();
		 
	 }
	 else{
		 JOptionPane.showMessageDialog(null, " No brand with this name");
	 }
	 }
	 else {JOptionPane.showMessageDialog(null, "You aren't the owner of this brand");}
}
public void SearchBrandDB(String name) throws SQLException 
{
	if(SearchbrandIN( name)!=-1){
	 resultSet = statement.executeQuery("select ID ,name,ownerID,placeID ,text from brand where name= '"+name+"'");
	String brandname = null;
	String tip = null;
	int  oid=0;
	int pid = 0;
	 while (resultSet.next()) {
		 
		 brandname=(resultSet.getString("name"));
		 oid=(resultSet.getInt("ownerID"));
		 pid=(resultSet.getInt("placeID"));
		 tip=(resultSet.getString("text"));
	 }
	 PlaceModel p= new PlaceModel();
	 resultSet = statement.executeQuery("select ID ,name,checkInNO,description ,rate from places where ID= '"+pid+"'");
	
	 while (resultSet.next()) {
		  p.setID(resultSet.getInt("ID"));
		 p.setName(resultSet.getString("name"));
	  p.setNumberofcheckins(resultSet.getInt("checkInNO"));
		 p.setRate(resultSet.getDouble("rate"));
		 p.setDescription(resultSet.getString("description"));
	 }
	 
		JOptionPane.showMessageDialog(null,"Brand Name:"+brandname+"  Brand Tip:"+tip+"   Place name: "+p.name+" rate: "+p.rate+"no of checkin: "+ p.numberofcheckins+" Description: "+p.description);
	
}
	else{
		JOptionPane.showMessageDialog(null, " No brand with this name");
	}
}
public void deleteBrandDB(String name,int user_id) throws SQLException 
{  if(SearchbrandIN( name)!=-1){
	resultSet = statement.executeQuery("select ownerID  from brand where name= '"+name+"'");
	 int onID = -1;
	 while (resultSet.next()) {
		 onID =resultSet.getInt("ownerID");
		 
	 }
	if(user_id==onID){
	
	 preparedStatement = connect.prepareStatement("delete from brand  where name = '"+name+"'");
	 preparedStatement.executeUpdate();
	}
	else{
		JOptionPane.showMessageDialog(null, "You aren't the owner of this brand");
	}
}
	else{
		JOptionPane.showMessageDialog(null, " No brand with this name");
	}
}
public void followBrandDB(String name,int user_id) throws SQLException 
{
	if(SearchbrandIN( name)!=-1){
		resultSet = statement.executeQuery("select ID  from brand where name= '"+name+"'");
		 int ID = -1;
		 while (resultSet.next()) {
			 ID =resultSet.getInt("ID");
			 
		 }
		 preparedStatement = connect.prepareStatement("insert into brandfollowers values ( default,?,?)");
			preparedStatement.setInt(1, ID);
			preparedStatement.setInt(2, user_id);
			
	       preparedStatement.executeUpdate();
		 
	}
	else{
		JOptionPane.showMessageDialog(null, " No brand with this name");
	}
}

public void addTasteDB(String taste,String type,String var,int or ) throws SQLException 
{
	
	if(or==1){
		if(searchUserin(var)!=-1){
		
		 preparedStatement = connect.prepareStatement("insert into tastetouser values ( default,?,?,?)");
			preparedStatement.setString(1, taste);
			preparedStatement.setString(2, type);
			
			preparedStatement.setInt(3, searchUserin(var));
	 
			preparedStatement.executeUpdate();
		}
		else{
			JOptionPane.showMessageDialog(null, " No user with this email");
		}
	}
	else if(or==2){
		
		if(searchplaceIN(var)!=-1){
			
			 preparedStatement = connect.prepareStatement("insert into tastetoplace values ( default,?,?,?)");
				preparedStatement.setString(1, taste);
				preparedStatement.setString(2, type);
				
				preparedStatement.setInt(3,searchplaceIN(var));
		 
				preparedStatement.executeUpdate();
			}
			else{
				JOptionPane.showMessageDialog(null, " No place with this name");
			}
	}
else if(or==3){
	if(SearchbrandIN(var)!=-1){
		
		 preparedStatement = connect.prepareStatement("insert into tastetobrand values ( default,?,?,?)");
			preparedStatement.setString(1, taste);
			preparedStatement.setString(2, type);
			
			preparedStatement.setInt(3,SearchbrandIN(var));
	 
			preparedStatement.executeUpdate();
		}
		else{
			JOptionPane.showMessageDialog(null, " No brand with this name");
		}
	}
	
}

public TasteModel SearchTasteuserIN(int id) throws SQLException 
{
	 resultSet = statement.executeQuery("select taste , type  from tastetouser where userID= '"+id+"'");
	TasteModel T=new TasteModel();
		 while (resultSet.next()) {
		T.setTaste(resultSet.getString("taste"));
		T.setType(resultSet.getString("type"));
			 
		 }
		 return  T;
	
}
public TasteModel SearchTasteplaceIN(int id) throws SQLException 
{
	 resultSet = statement.executeQuery("select taste , type  from tastetoplace where placeID= '"+id+"'");
	TasteModel T=new TasteModel();
		 while (resultSet.next()) {
		T.setTaste(resultSet.getString("taste"));
		T.setType(resultSet.getString("type"));
			 
		 }
		 return  T;
	
}
public TasteModel SearchTastebrandIN(int id) throws SQLException 
{
	 resultSet = statement.executeQuery("select taste , type  from tastetobrand where brandID= '"+id+"'");
	TasteModel T=new TasteModel();
		 while (resultSet.next()) {
		T.setTaste(resultSet.getString("taste"));
		T.setType(resultSet.getString("type"));
			 
		 }
		 return  T;
	
}
public void SearchTasteDB(String var,int or ) throws SQLException 
{
	if(or==1){
		if(searchUserin(var)!=-1){
			
			TasteModel T= new TasteModel();
			T=SearchTasteuserIN(searchUserin(var));
			if(T.getTaste()==null&&T.getType()==null){
				JOptionPane.showMessageDialog(null, " NO Taste To This User");
			}
			else{
				JOptionPane.showMessageDialog(null," Taste: "+T.taste+" Type: "+T.type);
			}
			
			}
			else{
				JOptionPane.showMessageDialog(null, " No user with this email");
			}
		
	}
	else if(or==2){

		if(searchplaceIN(var)!=-1){
			
			TasteModel T= new TasteModel();
			T=SearchTasteplaceIN(searchplaceIN(var));
			if(T.getTaste()==null&&T.getType()==null){
				JOptionPane.showMessageDialog(null, " NO Taste To This Place");
			}
			else{
				JOptionPane.showMessageDialog(null," Taste: "+T.taste+" Type: "+T.type);
			}
			
			}
			else{
				JOptionPane.showMessageDialog(null, " No place with this name");
			}
		
	}
	else if(or==3){
		if(SearchbrandIN(var)!=-1){
			TasteModel T= new TasteModel();
			T=SearchTastebrandIN(SearchbrandIN(var));
			if(T.getTaste()==null&&T.getType()==null){
				JOptionPane.showMessageDialog(null, " NO Taste To This Brand");
			}
			else{
				JOptionPane.showMessageDialog(null," Taste: "+T.taste+" Type: "+T.type);
			}
		
			}
			else{
				JOptionPane.showMessageDialog(null, " No brand with this name");
			}
	}
}
public void 	SendMessageDB (int ID_sender,String emailReciever,String text) throws SQLException {
	 int ID_reciever=searchUserin(emailReciever);
   	if(ID_reciever!=-1){
	  preparedStatement = connect.prepareStatement("insert into message values ( default,?,?,?)");
		preparedStatement.setInt(1, ID_sender);
		preparedStatement.setInt(2, ID_reciever);
		preparedStatement.setString(3, text);
     preparedStatement.executeUpdate();
     JOptionPane.showMessageDialog(null, " Message Sent");
     
   	}
   	else{
   		JOptionPane.showMessageDialog(null, " No User with this Email");
   	}
      
   
	}

public int searchUserinCC(String creditcard) throws SQLException
{ 
	 
	 resultSet = statement.executeQuery("select ID  from user where creditcard= '"+creditcard+"'");
	 int userNum = -1;
	 while (resultSet.next()) {
		  userNum=resultSet.getInt("ID");
	 }
	 return userNum;
}
public int searchCreditcardin(String creditcard) throws SQLException
{ 
	 
	 resultSet = statement.executeQuery("select ID  from bank where creditcard= '"+creditcard+"'");
	 int Num = -1;
	 while (resultSet.next()) {
		  Num=resultSet.getInt("ID");
	 }
	 return Num;
}
public String searchuserbyID(int id) throws SQLException
{ 
	 
	 resultSet = statement.executeQuery("select uname  from user where ID= '"+id+"'");
	 String name = "";
	 while (resultSet.next()) {
		  name=resultSet.getString("uname");
	 }
	 return name;
}
public String searchplacebyID(int id) throws SQLException
{ 
	 
	 resultSet = statement.executeQuery("select name  from places where ID= '"+id+"'");
	 String namee = "";
	 while (resultSet.next()) {
		  namee=resultSet.getString("name");
	 }
	 return namee;
}
public void showcheckins() throws SQLException
{ 
	 ArrayList <CheckInModel> ch = new ArrayList<CheckInModel>();
	 resultSet = statement.executeQuery("select ID ,pid,uid,text from checkins_posts" );
	 
			 while (resultSet.next()) {
				 CheckInModel check=new CheckInModel();
				 check.setPlaceName(searchplacebyID(resultSet.getInt("pid")));
				
				check.setUserName(searchuserbyID(resultSet.getInt("uid")));
				 check.setText(resultSet.getString("text"));
				 
				ch.add(check);
			 }
			 JOptionPane.showMessageDialog(null, ch.toString());
}
}


