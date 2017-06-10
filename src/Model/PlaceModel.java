package Model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Database.Database;

public class PlaceModel {
	public  int ID;
public  String name;
public  Double rate;
public  int numberofcheckins;
public String description;
private Database db=new Database();

//***************setters and getters and constructors*****************************************************************

	public PlaceModel() {
		// TODO Auto-generated constructor stub
		ID=0;
		name="";
		rate=0.0;
		numberofcheckins=0;
		description="";
	}
	public PlaceModel(int iD, String name, Double rate, int numberofcheckins,
			String description) {
	
		this.ID = iD;
		this.name = name;
		this.rate = rate;
		this.numberofcheckins = numberofcheckins;
		this.description = description;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public int getNumberofcheckins() {
		return numberofcheckins;
	}
	public void setNumberofcheckins(int numberofcheckins) {
		this.numberofcheckins = numberofcheckins;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PlaceModel [ID=" + ID + ", name=" + name + ", rate=" + rate + ", numberofcheckins=" + numberofcheckins
				+ ", description=" + description + "]";
	}
	
//********added a new place in database***********************************************************	
	public void addNewPlace(String name,String description) throws Exception {
	
		db.readDataBase();
		db.addPlace( name,description);
		
	}
	
	public void 	rateAPlace (String name,Double rate ) throws Exception {
		db.readDataBase();
		if(db.searchplaceIN(name)!=-1){
			db.rateAPlaceDB(name, rate);
		}
		else{
			JOptionPane.showMessageDialog(null, " No Place with this name");
		}
	}
	
	public int found(String name)
	{  boolean found=false;
		// search fe el database b el name w 3'yar found 5leha true lw l2ah 
		if(found){
			return 1;
		}
		else{
			return -1;
		}
	}
	public void	SearchModel (String name ) throws Exception {
		db.readDataBase();
		PlaceModel p=new PlaceModel();
		p=db.searchplace( name);
		
		//3aby el 7agat eli fe el data base eli l2eto fe el object
		if(db.searchplaceIN(name)!=-1){
			
			JOptionPane.showMessageDialog(null," name: "+p.name+" rate: "+p.rate+"no of checkin: "+ p.numberofcheckins+" Description: "+p.description);

			
		}
		else{
			JOptionPane.showMessageDialog(null, " No Place with this name");
		}
	}
	
	
	public void 	checkInAtAPlace (String name ) {
		if(found(name)==1){
			//update  database zwed el nomber of checkin b 1
		}
		else{
			JOptionPane.showMessageDialog(null, " No Place with this name");
		}
	}

	
}
