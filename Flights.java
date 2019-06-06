package airline;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Flights extends db_connection{

	private static ResultSet all_flights;
	private static Boolean answer = false;
	
	
	//saves on access time to database and avoids DDOS when multiple users need to access flight
	public static Boolean preload_flights() { 
		all_flights = db_connection.flights_request("SELECT * FROM flights_available", "All_Flights");
		 if(all_flights != null) {
			 answer = true;
		 }else {
			 answer = false;
		 }
		return answer;
	}
	
	public static void view_all_flights() {
		try {
			while (all_flights.next())
			  {
			    int id = all_flights.getInt("id");
			    String operator = all_flights.getString("airline_operator");
			    Date departure_date = all_flights.getDate("departure_date");
			    Date arrival_date = all_flights.getDate("arrival_date");
			    String depart_location = all_flights.getString("departure_location");
			    String arrival_location = all_flights.getString("arrival_location");
			    
			    // print the results
			    System.out.format("%s, %s, %s, %s, %s, %s\n", id, operator, departure_date, arrival_date, depart_location, arrival_location);
			  }
		} catch (SQLException e) {
			System.out.println("we could not display flight, could be a db issue try restarting Wamp Server!");
			e.printStackTrace();
		}
	}
	
	
	public void search_flights(String boarding_location, String destination_location, Date departure_date0,
			Date return_date) throws IOException {
			ResultSet search_results;
			search_results = db_connection.flights_request("SELECT * FROM flights_available WHERE departure_date="+departure_date0+" AND arrival_date="+return_date+" AND departure_location="+boarding_location+" AND arrival_location="+destination_location, "Search");
			
			try {
				if(search_results == null) {
					System.out.println("Sorry we could not find flights matching search criteria");
				}
				
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("Flight ID | Airline | Departure Date | Return Date | Departure Location | Arrival Location");
				System.out.println("------------------------------------------------------------------------------------------");
				while (search_results.next())
				  {
				    int id = search_results.getInt("id");
				    String operator = search_results.getString("airline_operator");
				    Date departure_date = search_results.getDate("departure_date");
				    Date arrival_date = search_results.getDate("arrival_date");
				    String depart_location = search_results.getString("departure_location");
				    String arrival_location = search_results.getString("arrival_location");
				    
				    // print the results
				    System.out.format("%s, %s, %s, %s, %s, %s\n", id, operator, departure_date, arrival_date, depart_location, arrival_location);
				  }
			} catch (SQLException e) {
				System.out.println("we could not display flight, could be a db issue try restarting Wamp Server!");
				e.printStackTrace();
			}
	}

	public static void view_flight(int flight_number) throws IOException {
		ResultSet search_flight;
		search_flight = db_connection.flights_request("SELECT * FROM flights_available WHERE id="+flight_number, "Search");
		
		try {
			if(search_flight == null) {
				System.out.println("Sorry we could not find a flight matching the flight id entered!");
			}
			
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("Flight ID | Airline | Departure Date | Return Date | Departure Location | Arrival Location");
			System.out.println("------------------------------------------------------------------------------------------");
			
			while (search_flight.next())
			  {
			    int id = search_flight.getInt("id");
			    String operator = search_flight.getString("airline_operator");
			    Date departure_date = search_flight.getDate("departure_date");
			    Date arrival_date = search_flight.getDate("arrival_date");
			    String depart_location = search_flight.getString("departure_location");
			    String arrival_location = search_flight.getString("arrival_location");
			    
			    // print the results
			    System.out.println(id+"          "+ operator+"  "+ departure_date+"        "+ arrival_date+"       "+ depart_location+"          "+ arrival_location);
			  }
		} catch (SQLException e) {
			System.out.println("we could not display flight, could be a db issue try restarting Wamp Server!");
			e.printStackTrace();
		}
	}

	
}
