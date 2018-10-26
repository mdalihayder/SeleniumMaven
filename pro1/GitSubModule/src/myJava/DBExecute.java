package myJava;

import java.util.List;
import myJava.DataBaseValidation;

public class DBExecute {
	
	static Object strID;
	static Object strName;
	static Object strEmail;

	public static void main(String[] args) {
		
		DataBaseValidation ObjDB= new DataBaseValidation();
		
		ObjDB.CreateDBConnection();
		
		List<Object> DBData = ObjDB.GetDBData();
		strID = DBData.get(0);
		strName=DBData.get(1);
		strEmail=DBData.get(2);
		
		System.out.println(strID);
		System.out.println(strName);
		System.out.println(strEmail);
	
		ObjDB.CloseDBConnection();
	}
}
