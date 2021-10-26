package classwork.Day4;

import java.util.Scanner;

public class Calender {

	public static void main(String[] args) {
		String array[] = {"Sun","Mon","Tue","Wed","Thus","Fri","Sat"};
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter month:");
		int month=scanner.nextInt();
		System.out.println("Enter date");
		int date=scanner.nextInt();
		System.out.println("Enter year");
		int year=scanner.nextInt();
		int result = dayOfWeek(month,date,year);
		System.out.println(array[result]);
		scanner.close();	
	}
	public static int dayOfWeek(int month, int date, int year) {
		
		int y0 = year - (14 - month) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (date + x + 31 * m0 / 12) % 7;
		return d0;
	}
}
