package Controller;
import javax.swing.JOptionPane;

import Model.CheckInModel;
import Model.PlaceModel;
import Model.UserModel;

public class CheckInController {
	private CheckInModel checkk=new CheckInModel();
	
	public CheckInController() {
		// TODO Auto-generated constructor stub
	}
	public void SaveCheckin(String Text,PlaceModel place,UserModel user)
	{
		
		checkk.SaveCheckin(Text, place, user);
		
	}
	public void GetCheckin(String name)
	{
		checkk.GetCheckin(name);
	}
	public void UpdateCheckin(String name,String Text)
	{
		checkk.UpdateCheckin(name, Text);
	}
	
	public void showcheckinsController() throws Exception 
	{
		CheckInModel Ch=new CheckInModel();
		Ch.showcheckinsModel();
	}
}
