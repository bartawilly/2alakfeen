package Model;

import java.sql.SQLException;

import Database.Database;

public class BrandModel {
Database db=new Database();
	public BrandModel() {
		// TODO Auto-generated constructor stub
	}
	public void addBrandModel(String name,String tip,String place_name, int owner_id) throws Exception
	{
		db.readDataBase();
		db.addBrandDB(name, tip, place_name, owner_id);
	}
	public void UpdateBrandModel(String oldname,String newname,String tip,int user_id) throws Exception
	{	db.readDataBase();
	db.UpdateBrandDB(oldname, newname, tip,user_id);
		
	}
	public void SearchBrandModel(String name) throws Exception 
	{db.readDataBase();
		db.SearchBrandDB(name);
	}
	public void deleteBrandModel(String name,int user_id) throws Exception 
	{
		db.readDataBase();
		db.deleteBrandDB(name,user_id);
		
	}
	public void followBrandModel(String name,int user_id) throws Exception 
	{
		db.readDataBase();
		db.followBrandDB(name, user_id);
		
	}
	
}
