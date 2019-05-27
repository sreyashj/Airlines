package airline;

import java.io.IOException;

public interface user_abilities {
	String search_flights(String boarding_location, String destination_location, String departure_date, String return_date) throws IOException;
	void view_flights(int flight_number, String passport_number) throws IOException;
	void make_booking(String full_name, int flight_number, String payment_method) throws IOException;
	void cancel_booking(int booking_number, String passport_number) throws IOException;
	
	//this one needs some adjustments on the parameters, we need to identify the data that users can change in their bookings
	void change_booking(String booking_id) throws IOException;
}
