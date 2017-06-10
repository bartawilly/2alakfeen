package Model;

import Database.Database;

public class TasteModel {
	public String taste=null;
	public String type=null;
	@Override
	public String toString() {
		return "TasteModel [taste=" + taste + ", type=" + type + "]";
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	Database db=new Database();
	public TasteModel() {
		// TODO Auto-generated constructor stub
	}
	public void addTasteModel(String taste,String type,String var,int or ) throws Exception{
		db.readDataBase();
		db.addTasteDB(taste, type, var, or);
	}
	public void searchTasteModel(String var,int or ) throws Exception{
		db.readDataBase();
		db. SearchTasteDB(var, or);
	}
}
