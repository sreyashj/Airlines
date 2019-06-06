//import necessary libraries
package airline;
import java.sql.*;

public class db_connection {

    static String myDriver = "org.gjt.mm.mysql.Driver";
    static String myUrl = "jdbc:mysql://localhost/nepal_airlines";
   
	
    //Querying Flights from DB
    public static ResultSet flights_request(String query, String type) {
		ResultSet flights_available = null;
    	if(type=="All_Flights") {
    		System.out.println("");
    	}
    	try{
    		 Class.forName(myDriver);
    		 Connection conn = DriverManager.getConnection(myUrl, "root", "");
        	 Statement st = conn.createStatement();
    	     flights_available = st.executeQuery(query);
    	} catch (Exception e){
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		}    
    	
    	return flights_available;
    }
    
    
    //Inserting Bookings to DB
    public static int bookings_request_insert(String query, String type) {
		int bookings = 0;
  
    	try{
    		 Class.forName(myDriver);
    		 Connection conn = DriverManager.getConnection(myUrl, "root", "");
        	 Statement st = conn.createStatement();
    	     bookings = st.executeUpdate(query);
    	} catch (Exception e){
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		}    
    	
    	if(bookings==1 && type=="Make_Booking") {
    		System.out.println("Your booking was successful");
    	}else if(bookings==1 && type=="Cancel_Booking"){
    		System.out.println("Your booking has been cancelled");
    	}
    	else{
    		System.out.println("Please verify your boooking information we could not make the booking");
    	}
        System.out.println("");
    	
    	return bookings;
    }
    
	public db_connection() {
		 try
		    {
			 Class.forName(myDriver);
			 Connection conn = DriverManager.getConnection(myUrl, "root", "");
				
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM users";

		      // create the java statement
		      Statement st = conn.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String firstName = rs.getString("first_name");
		        String lastName = rs.getString("last_name");
		        Date dateCreated = rs.getDate("date_created");
		        boolean isAdmin = rs.getBoolean("is_admin");
		        int numPoints = rs.getInt("num_points");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  }
	
	public static void search_flights(Date departure_date0, Date arrival_date0, String departure_location0, String arrival_location0) {
		 try
		    {
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      String query = "SELECT * FROM flights_available";
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      System.out.println("We found the following results for your flight search:");
		      System.out.println("");
		      
		      while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String operator = rs.getString("airline_operator");
		        Date departure_date = rs.getDate("departure_date");
		        Date arrival_date = rs.getDate("arrival_date");
		        String depart_location = rs.getString("departure_location");
		        String arrival_location = rs.getString("arrival_location");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, operator, departure_date, arrival_date, depart_location, arrival_location);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  }

	public static void flight_info(int flight_id) {
		 try
		    {
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/nepal_airlines";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      String query = "SELECT * FROM flights_available WHERE id = "+flight_id;
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      System.out.println("We found the following results for your flight search:");
		      System.out.println("");
		      
		      while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String operator = rs.getString("airline_operator");
		        Date departure_date = rs.getDate("departure_date");
		        Date arrival_date = rs.getDate("arrival_date");
		        String depart_location = rs.getString("departure_location");
		        String arrival_location = rs.getString("arrival_location");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, operator, departure_date, arrival_date, depart_location, arrival_location);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  }
	
	
	public static void view_booking(int booking_id) {
		 try
		    {
			 Class.forName(myDriver);
			 Connection conn = DriverManager.getConnection(myUrl, "root", "");
				
		      String query = "SELECT * FROM bookings WHERE id = "+booking_id;
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      System.out.println("We found the following results for your booking search:");
		      System.out.println("");
		      
		      while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String full_name = rs.getString("full_name");
		        int flight_id = rs.getInt("flight_id");
		        String payment_token = rs.getString("payment_token");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s,\n", id, full_name, flight_id, payment_token);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  }
	
	public static void cancel_booking(int booking_id, String passport) {
		 try
		    {
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      String query = "UPDATE bookings set booking_status = cancelled where id = "+booking_id+" AND passport_number = "+passport;
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      System.out.println("We have successfully cancelled booking number "+booking_id+" for user with passport number "+passport);
		      System.out.println("");
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("We failed to cancel your flight booking!");
		      System.err.println(e.getMessage());
		    }
		  }

	public static void make_booking(int booking_id) {
		 try
		    {
			 Class.forName(myDriver);
			 Connection conn = DriverManager.getConnection(myUrl, "root", "");
				
		      String query = "SELECT * FROM bookings WHERE id = "+booking_id;
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      System.out.println("We found the following results for your booking search:");
		      System.out.println("");
		      
		      while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String full_name = rs.getString("full_name");
		        int flight_id = rs.getInt("flight_id");
		        String payment_token = rs.getString("payment_token");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s,\n", id, full_name, flight_id, payment_token);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		  }
	
}
