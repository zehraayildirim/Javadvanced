package javadevelopment;

public class J05Enum02 {

	public static void main(String[] args) {
		//constants are static because of that we can access the constants by Enum name
		J04Enum01 enm = J04Enum01.JANUARY;
		System.out.println(enm);
		
		J04Enum01 months = J04Enum01.JANUARY;
		
		switch(months) {
			case JANUARY:
				System.out.println("Do sth if the month is January");
				break;
			case FEBRUARY:
				System.out.println("Do sth if the month is February");
				break;
			case MARCH:
				System.out.println("Do sth if the month is March");
				break;
			case APRIL:
				System.out.println("Do sth if the month is April");
				break;
			case MAY:
				System.out.println("Do sth if the month is May");
				break;
			case JUNE:
				System.out.println("Do sth if the month is June");
				break;
			case JULY:
				System.out.println("Do sth if the month is July");
				break;
			case AUGUST:
				System.out.println("Do sth if the month is August");
				break;
			case SEPTEMBER:
				System.out.println("Do sth if the month is September");
				break;
			case NOVEMBER:
				System.out.println("Do sth if the month is November");
				break;
			case OCTOBER:
				System.out.println("Do sth if the month is October");
				break;
			case DECEMBER:
				System.out.println("Do sth if the month is December");
				break;
			default:
				break;
		}
	}
}
