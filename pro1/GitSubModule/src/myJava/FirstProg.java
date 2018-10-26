package myJava;

public class FirstProg {

	public static void main(String[] args) {
		
		String vdate = "18-08-2012";
		String str[] = vdate.split("-");
		//int day = Integer.parseInt(str[0]);
		//int month = Integer.parseInt(str[1]);
		int year = Integer.parseInt(str[2]);
		System.out.println("year is : "+ year);
		
		for (String string : str) {
			
		}
		
	}

}
