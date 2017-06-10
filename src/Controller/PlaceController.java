package Controller;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.PlaceModel;

public class PlaceController {

	public PlaceController() {
		// TODO Auto-generated constructor stub
	}
	public void	SearchController (String name ) throws Exception {
	PlaceModel p=new PlaceModel();
		p.SearchModel ( name );
		
	}
	public void addNewPlaceControler(String name,String description) throws Exception {
		PlaceModel p=new PlaceModel();
		p.addNewPlace(name,description);
	}
	public void 	rateAPlaceControler (String Name,Double rate ) throws Exception {
		PlaceModel p=new PlaceModel();
		p.rateAPlace ( Name, rate );
	}
	public void 	checkInAtAPlaceController (String name ) {
		PlaceModel p=new PlaceModel();
		p.checkInAtAPlace (name );
	}
}
