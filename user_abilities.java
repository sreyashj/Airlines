package airline;

import java.io.IOException;
import java.sql.Date;

public interface user_abilities {
	void search_flights(String boarding_location, String destination_location, Date departure_date, Date return_date) throws IOException;
	void view_flights(int flight_number) throws IOException;
	void make_booking(int flight_number, String payment_method) throws IOException;
	//void cancel_booking(int booking_number, String passport_number) throws IOException;
	void change_booking(String booking_id) throws IOException;
}
