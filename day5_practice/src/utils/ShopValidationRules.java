package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.core.Plan;
import com.app.exception.CustomerHandlingException;

public class ShopValidationRules {
	public static Customer validateAllInput(String fname, String lname, String email, String password, double regamount, String dob,
			String plan,ArrayList<Customer> e) throws CustomerHandlingException {
		
		Plan newplan=parseAndValidatePlan(plan);
	
		Plan nplan= checkForPlan(newplan,regamount);
		checkForDuplicate(email,e);
	LocalDate date=checkForDate(dob);
				return new Customer(fname,lname,email,password,regamount,date,newplan);
		
	}
		
	public static Plan parseAndValidatePlan(String  planname) throws IllegalArgumentException{
		return Plan.valueOf(planname.toUpperCase());
		
	}
	public static void checkForDuplicate(String email,List<Customer> cust) throws CustomerHandlingException{

		Customer newcust=new Customer(email);
		if(cust.contains(newcust)) {
			throw new CustomerHandlingException("Duplicate Email Found...");
			
		}
		System.out.println("No duplicate Email found");
}
	public static Plan checkForPlan(Plan plan1,double regamount) throws CustomerHandlingException{
		
		
	double price=plan1.getPlancost();
	
	
	if(regamount!=price)
		 throw new CustomerHandlingException("Enter valid Plan...");
		return plan1;
	}
	/*public static Plan parseAndValidate(String planname,double regamount) throws CustomerHandlingException{
		Plan plan1=
		
		
		return null;
		
	}
	*/
	
	
	
	
	public static LocalDate checkForDate(String dob) throws CustomerHandlingException{
		
		LocalDate date= LocalDate.parse(dob);
		LocalDate datenow=LocalDate.now();
		
		Period per=  Period.between(date,datenow);
		System.out.println(per.getYears());

		if(per.getYears()>21)
			
		throw new CustomerHandlingException("Enter valid age...");
		return date;
	}
		//add static method customer login
	public static	Customer customerlogin(String email,String pass,ArrayList<Customer> custlist) throws CustomerHandlingException{
		int index=custlist.indexOf(new Customer(email));
		
		if(index==-1)
	              throw new CustomerHandlingException("You Entered Invalid email...");
		
		Customer validcustomer=custlist.get(index);
		if(!validcustomer.getPassword().equals(pass))
			throw new CustomerHandlingException("You have entered wrong password...");
		
		return validcustomer;
		
		
	}
	
}