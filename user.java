package airline;

import java.io.IOException;
import java.sql.Date;

//we decided to use an interface as java does not support multiple inheritance
public class user extends Flights implements user_abilities{

private String fullname, passport_number, password;
Bookings new_booking;
	
	//constructor
	public user(String Name, String Passport, String Password) {
		super();
		this.fullname = Name;
		this.passport_number = Passport;
		this.password = Password;
		user.settup_system();
	}
	
	public static void settup_system() {
	    Boolean flights_loaded = Flights.preload_flights();
	    if(flights_loaded=false) {
	    	System.out.println("*We are experiancing problems preloading flights, you may experiance unussual delays");
	    }
	}
	

	@Override
	public void search_flights(String boarding_location, String destination_location, Date departure_date,
			Date return_date) throws IOException {
		        Flights.search_flights(departure_date, return_date, boarding_location, destination_location);
	}

	@Override
	public void view_flights(int flight_number) throws IOException {
		Flights.view_flight(flight_number);
	}

	@Override
	public void make_booking(int flight_number, String payment_method) throws IOException {
	  new_booking = new Bookings(fullname,passport_number, flight_number, payment_method);
		
	}
	
	public void cancel_booking(int booking_id) {
     new_booking.cancel_booking(booking_id);
	}

	@Override
	public void change_booking(String booking_id) throws IOException {
		// TODO Auto-generated method stub
		
	}

	
}
