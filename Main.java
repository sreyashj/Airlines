//importing necessary libraries
package airline;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
    	

          //variables i shall use in this class
    		Scanner console = new Scanner (System.in);
    	    int option = 0;
    	    String travel_from ="";
    	    String travel_to ="";
    	    String departure_date ="";
    	    String returning_date = "";
    	    String flight_number = "";
    	    String passport_number = "";
    	    String full_name="";
    	    String booking_number="";
    	    int flight_number_booking;
    	    int payment_method;
    		
    		//welcoming message
    		System.out.println("--------------------------------------------");
    		System.out.println("Welcome to Air Nepal Booking System");
    		System.out.println("--------------------------------------------");
    		System.out.println("");
    		
    		//while loop to look through the menu until an option is chosen
    		 while (option!=-1) {
    			   System.out.println("Please choose an option you would like to proceed with from the list below:");
    			   
    			   //menu of what users can do on my system
    		       System.out.println("[1] Search Flights");
    		       System.out.println("[2] View Flight Information");
    			   System.out.println("[3] Make Booking"); 
    			   System.out.println("[4] Cancel Booking");
    			   System.out.println("[5] Change Booking");
    			   System.out.println("If you would like to exit type (-1):");
    			  
    			   //assigning a variable to input
    			   option = console.nextInt();
    			   console.nextLine();
    			   
    			   //switch option to check option selection
    			   switch (option){
    			   
    			   case 1:
    				   //we created an object then passed required data though it
    				   System.out.println("Please enter bording location:");
    				   travel_from = console.nextLine();
    				   System.out.println("Please enter destination location:");
    				   travel_to = console.nextLine();
    				   System.out.println("Please enter departure date:");
    				   departure_date = console.nextLine();
    				   System.out.println("Please enter return date:");
    				   returning_date = console.nextLine();
    					
    				   /* Update_Cirriculum update;
    					 update = new Update_Cirriculum(cirriculum_path);
    					 System.out.println(update); */
    				   
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
