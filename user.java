package airline;

import java.io.IOException;

//we decided to use an interface as java does not support multiple inheritance
public class user extends db_connection implements user_abilities {

	String fullname;
	
	//constructor
	public user(String Name) {
		super();
		this.fullname = Name;
		
	}

	@Override
	public void search_flights(String boarding_location, String destination_location, String departure_date,
			String return_date) throws IOException {
		// this function will search for flights from database

	}

	@Override
	public void view_flights(int flight_number, String passport_number) throws IOException {
		// this function allows users to view a specific flight

	}

	@Override
	public void make_booking(String full_name, int flight_number, String payment_method) throws IOException {
		// this allows users to make a booking

	}

	@Override
	public void cancel_booking(int booking_number, String passport_number) throws IOException {
		// this allows a user to cancel a booking

	}

	@Override
	public void change_booking(String student_id) throws IOException {
		// this allows the changing of a booking

	}

}