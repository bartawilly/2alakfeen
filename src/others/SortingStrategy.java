package others;
import java.util.ArrayList;

import Model.CheckInModel;


public class SortingStrategy {
private ArrayList<CheckInModel> checkins=new ArrayList();
	public SortingStrategy(ArrayList<CheckInModel> checkins) {
	super();
	this.checkins = checkins;
}
	public ArrayList<CheckInModel> getCheckins() {
	return checkins;
}
public void setCheckins(ArrayList<CheckInModel> checkins) {
	this.checkins = checkins;
}
	public SortingStrategy() {
		// TODO Auto-generated constructor stub
	}

}
