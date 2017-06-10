package Controller;

import java.sql.SQLException;

import Model.BrandModel;

public class BrandController {
BrandModel BM=new BrandModel();
	public BrandController() {
		// TODO Auto-generated constructor stub
	}
	public void addBrandController(String name,String tip,String place_name, int owner_id) throws Exception
	{
		BM.addBrandModel(name, tip, place_name, owner_id);
	}

	public void UpdateBrandCOntroller(String oldname,String newname,String tip,int user_id) throws Exception
	{
	BM.UpdateBrandModel(oldname, newname, tip,user_id);
	}
	public void SearchBrandController(String name) throws Exception 
	{
		BM.SearchBrandModel(name);
	}
	public void deleteBrandController(String name,int user_id) throws Exception 
	{
		BM.deleteBrandModel(name,user_id);
	}
	public void followBrandController(String name,int user_id) throws Exception 
	{
		BM.followBrandModel(name, user_id);
	}
}
