package com.nissan.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssetRegister {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String[] computersName = new String[5];
		String brand[] = new String[5];
		Date[] manufactureDate = new Date[5];
		boolean[] isAvailable = new boolean[5];
		int[] quantity = new int[5];

		char choice = 'n';
		int i=0;
		
			try {
				do {
				// take computer Name
				System.out.print(" Enetr Computer  Name : ");
				computersName[i] = validComputerName(input.nextLine());
				//Take brand name
				System.out.print(" Enetr Computer Brand   Name : ");
				 brand[i] = validComputerBrandName(input.nextLine());

				
				System.out.print(" Enter  the Manufacture join date(dd/MM/yyyy): ");
				String mDate=input.nextLine();
				manufactureDate[i]=convertStringToUtilDate(mDate);
				System.out.print(" Enter the avilability of computer in yes or no : ");
				isAvailable[i]=checkAvaibility(input.nextLine());
				System.out.print(" Enetr Quantity : "); 
				quantity[i]=checkValidInteger(input.nextLine());

				
				System.out.print(" Do you wish to continue(y/n) : ");
				choice = input.nextLine().charAt(0);
				
				
				i++;

			}while (choice == 'Y' || choice == 'y'); 
			}
			catch (Exception e) {
				e.printStackTrace();
			} 
			finally {
				displayOutPut(computersName,brand,manufactureDate,isAvailable,quantity);
			}

	}

	
	private static void displayOutPut(String[] computersName, String[] brand, Date[] manufactureDate,
			boolean[] isAvailable, int[] quantity) {
		
		try {
			System.out.println("Press X key to see the customer output");
			try {
				char presKey=input.next().charAt(0);
				if(presKey=='X' || presKey=='x') {
					input.close();
					System.out.printf(String.format("%-20s%20s%20s20s%20s%n","computersName","brandName","manufactureDate","Availablity","quality"));
					System.out.println("----------------------------------------------------------------------------------------------------------");
					for(int j=0;j<computersName.length;j++) {
						System.out.printf(String.format("%-20s%20s%20s%20s%20s%n",computersName[j],brand[j],manufactureDate[j],isAvailable[j],quantity[j]));
						
					}
					
				}
			}
			catch(Exception  e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			System.out.println("Application is existing");
			System.exit(0);
		}
		
		
	}


	private static int checkValidInteger(String number) {
		try {
			int no=Integer.parseInt(number);
			return no;
		}
		catch(Exception e) {

			do {
				System.out.println("Enetr numbers only");
				String temp=input.nextLine();
				int r=checkValidInteger(temp);
				return r;
				
				
			}while(true);
		}
		
	
	}


	private static boolean checkAvaibility(String text) {
		try {
			do {
				if(text.equals("Yes") || text.equals("yes")) {
					return true;
				}
				else if(text.equals("No") || text.equals("no")) {
					return false;
				}
				else {
					System.out.println("Enter correct availibility like Yes/No");
					text=input.nextLine();
				}
				
				
			}while(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	private static Date convertStringToUtilDate(String mDate) throws ParseException {
		//java.util.Date format is dd/mm/yyy--->SimpleDateFormat
		//Parse
		Date utilDate=new SimpleDateFormat("dd/MM/yyyy").parse(mDate);
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		//System.out.println(sqlDate);
		return sqlDate;
		
	}


	// check valid Computer name
	private static String validComputerName(String name) {
			try {
			//creating object for BufferReader 
			BufferedReader brRead=new BufferedReader(new InputStreamReader(System.in));
			
			//creating pattern using regular expression
			Pattern pattern=Pattern.compile("[^A-Za-z ]");
			do {
				//match
				Matcher matcher=pattern.matcher(name);
				boolean finder=matcher.find();
				if(finder) {
					System.out.println("Name must contain only Alphabets. Enter again");
					name=brRead.readLine();
				}else if(name.length()<3) {
					System.out.println("Name should contain minimum chracter. Enter again");
					name=brRead.readLine();
				}
				else if(name.length()>30) {
					System.out.println("Name should contains 30 chracter. Enter again");
					name=brRead.readLine();
				}
				else {
					break;
				}
			}while(true);
			
			return name;
		}
		catch(Exception e) {
			System.out.println("Invalid entry in customer name....");
		}
		return name;
	}
	
	//check Brand Name
	private static String validComputerBrandName(String Brandname) {
		try {
		//creating object for BufferReader 
		BufferedReader brRead=new BufferedReader(new InputStreamReader(System.in));
		
		//creating pattern using regular expression
		Pattern pattern=Pattern.compile("[^A-Za-z ]");
		do {
			//match
			Matcher matcher=pattern.matcher(Brandname);
			boolean finder=matcher.find();
			if(finder) {
				System.out.println("Name must contain only Alphabets. Enter again");
				Brandname=brRead.readLine();
			}
			else if(Brandname.length()>20) {
				System.out.println("Name should contains 30 chracter. Enter again");
				Brandname=brRead.readLine();
			}
			else {
				break;
			}
		}while(true);
		
		//return name;
	}
	catch(Exception e) {
		System.out.println("Invalid entry in customer name....");
	}
	return Brandname;
}



}

