package Tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.exception.CustomerHandlingException;

import utils.ShopValidationRules;
import utils.ShopValidationRules.*;

public class ShopManagement {

	public static void main(String[] args) {

		try(Scanner sc=new Scanner(System.in)){
			ArrayList<Customer> customerlist=new ArrayList<>();
			boolean exit =false;
			while(!exit) {
				System.out.println("0.exit,1.sign up,2.sign in,3.change Pass,4.unsubscribe customer,5.display all customer");
				System.out.println("Choose an option ");
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("fname,lname,email,password,regamount,date,newplan");
						Customer validcustomer=ShopValidationRules.validateAllInput(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),
			sc.next(),customerlist);
						customerlist.add(validcustomer);
						break;
					case 2: 
						System.out.println("Enter email and password");
						validcustomer=ShopValidationRules.customerlogin(sc.next(),sc.next(),customerlist);
				
						System.out.println("Log in suceefully");
						break;
					case 3:
						System.out.println("Enter details for changing password");

						System.out.println("Enter email | old password |new password");
						validcustomer=ShopValidationRules.customerlogin(sc.next(),sc.next(),customerlist);
						
						validcustomer.setPassword(sc.next());
			            System.out.println("Password change Sucessfully...");
						break;
						
					case 4:
						System.out.println("Unsubcribe customer..");
						System.out.println("Enter the id to remove...");
						customerlist.remove(sc.nextInt());
						System.out.println("Customer Unsubcribed....");
				break;
				
					case 5:
						System.out.println("Display all customer...");
						for(Customer c: customerlist)
							 System.out.println(c);
						      break;
					
					case 0:
						exit=true;
						break;
						default:
							System.out.println("Enter the valid Choice");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
//shubham suryawanshi ss@gmail.com ss8007 2000 2023-02-15 gold
//
//somesh prem som@gmail.com som7890 1000 2023-03-12 silver
