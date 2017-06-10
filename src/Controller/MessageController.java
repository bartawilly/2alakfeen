package Controller;
import java.util.ArrayList;

import Model.MessageModel;


public class MessageController {
private ArrayList arr=new ArrayList();
MessageModel MM=new MessageModel();
	public MessageController() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList getArr() {
		return arr;
	}
	public void setArr(ArrayList arr) {
		this.arr = arr;
	}
	public MessageController(ArrayList arr) {
		this.arr = arr;
	}
	public void 	SendMessageController(int ID_sender,String emailReciever,String text) throws Exception{
		MM.SendMessageModel(ID_sender, emailReciever, text);
	}
}
