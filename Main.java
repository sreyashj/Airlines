//importing necessary libraries
package airline;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
    	

          //variables we shall use in this class
    		Scanner console = new Scanner (System.in);
    	    int option = 0;
    	    String travel_from ="";
    	    String travel_to ="";
    	    String departure_date ="";
    	    String returning_date = "";
    	    String flight_number = "";
    	    String passport_number = "none_present";
    	    String full_name="none_present";
    	    String booking_number="";
    	    int flight_number_booking;
    	    int payment_method;
    	    user new_user;
    	    
    	    boolean logged_in=false;
    	    
    	    String result;
    		
    		//welcoming message
    		System.out.println("--------------------------------------------");
    		System.out.println("Welcome to Air Nepal Booking System");
    		System.out.println("--------------------------------------------");
    		System.out.println("");
    		
    		//while loop to look through the menu until an option is chosen
    		 while (option!=-1) {
    			 
    			 //verifying users login status
    			 if(full_name != "none" && passport_number != "none_present") {
    				 logged_in=true;
    			 }
    			   System.out.println("Please choose an option you would like to proceed with from the list below:");
    			   if(logged_in==true) {
    				   //menu of what users can do on my system
        		       System.out.println("[1] Search Flights");
        		       System.out.println("[2] View Flight Information");
        			   System.out.println("[3] Make Booking"); 
        			   System.out.println("[4] Cancel Booking");
        			   System.out.println("[5] Change Booking");
        			   System.out.println("[6] Logout, "+full_name);
        			   System.out.println("If you would like to exit type (-1):");
    			   }else {
    				   System.out.println("");
    				   System.out.println("*Please login to use our services");
    				   System.out.println("[0] Login");
    				   System.out.println("If you would like to exit type (-1):");
    			   }
    			  
    			  
    				   option = console.nextInt();
        			   console.nextLine(); 
    
    			   
    			   //switch option to check option selection
    			   switch (option){
    			   
    			   case 0:
    				   //creating the user 
    				   System.out.println("Please enter your full name:");
    				   full_name = console.nextLine();
    				   System.out.println("Please enter passport:");
    				   passport_number = console.nextLine();
    				   System.out.println("Please enter departure date:");
    				   new_user = new user(full_name,passport_number);
    				     
    			   break;
    			   
    			   case 1:
    				   //we created an object then passed required data though it
    				   System.out.println("Please enter bording location:");
    				   travel_from = console.nextLine();
    				   System.out.println("Please enter destination location:");
    				   travel_to = console.nextLine();
    				   System.out.println("Please enter departure date:");
    				   departure_date = console.nextLine();
    				   System.out.println("Please enteSystem.out.println(\"[5] Change Booking\");r return date:");
    				   returning_date = console.nextLine();
    					
    				   new_user = new user("Shrayesh Joshi","EN02735");
    				   try {
    					   result = new_user.search_flights(travel_from, travel_to, departure_date, returning_date);
    					   } catch (IOException e) {
						   // We cannot search our database, data is either missing or invalid
						   e.printStackTrace();
						   }
    				   
    					 System.out.println("");   
    			   break;
    			   
    			   case 2:
    				   //this case allows user to view flight details
    				   System.out.println("Please enter flight number:");
    				   flight_number = console.nextLine();
    				   System.out.println("Please enter passport number:");
    				   passport_number = console.nextLine();
    				   System.out.println("");  
    			   break;
    			   
    			   case 3:
    				   //this case allows users to make a booking for a flight
    				   System.out.println("Please enter full name:");	
    				   full_name = console.next();  
    				   System.out.println("Please enter flight number:");	
    				   flight_number_booking = console.nextInt();
    				   System.out.println("Please select payment method:");	
    				   payment_method = console.nextInt();
    				   System.out.println("");  
    			   break;
    			   
    			   case 4:
    				   //this case allows users to cancel an existing booking
    				   System.out.println("Please enter booking number:");
    				   booking_number = console.next();
    				   System.out.println("Please enter passport number:");
    				   passport_number = console.next();
    				   System.out.println("");  
    			   break;
    			   
    			   case 5:
    				   //this case allows users to change a booking
    				   System.out.println("Please enter your passport number:");
    				   passport_number = console.next();
    				   
    				   //here you should call a class that allows user to see all bookings
    				     
    				   //
    				   System.out.println("Please enter booking number to change details:");
    				   booking_number = console.next();
    				   
    				   System.out.println("");
    			
    			   break;
    			
    		 }
    		        //goodbye message
    		        System.out.println("Thank you for using Nepal Airlines! Have a nice day.");
    		   }
            
    }
}
