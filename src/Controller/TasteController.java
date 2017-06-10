package Controller;

import Model.TasteModel;

public class TasteController {
TasteModel TM=new TasteModel();
	public TasteController() {
		// TODO Auto-generated constructor stub
	}
	public void addTasteController(String taste,String type,String var,int or ) throws Exception{
		
		TM.addTasteModel(taste, type, var, or);
	}
	public void searchTasteController(String var,int or ) throws Exception{
		
		TM. searchTasteModel(var, or);
	}


}
