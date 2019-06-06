package airline;

import java.io.IOException;
import java.sql.Date;

public class Bookings extends db_connection implements user_abilities{


private String fullname, passport_number, pay_method;
public int flight_number;
	
	
	//constructor
	public Bookings(String Name, String Passport, int flight_number, String payment_method) {
		super();
		this.fullname = Name;
		this.passport_number = Passport;
		this.flight_number = flight_number;
		this.pay_method = payment_method;
		
		//attempting to create a booking when booking object is instantiated
		try {
			make_booking(flight_number, payment_method);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void search_flights(String boarding_location, String destination_location, Date departure_date,
			Date return_date) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void view_flights(int flight_number) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void make_booking(int flight_number, String payment_method) throws IOException {
		db_connection.bookings_request_insert("INSERT INTO bookings (id, full_name, flight_id, payment_token, booking_status, passport_number) "
		          +"VALUES (null, '"+fullname+"','"+flight_number+"','"+payment_method+"', 'confirmed', '"+passport_number+"')","Make_Booking");
	}


	@Override
	public void change_booking(String booking_id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void cancel_booking(int booking_id) {
		db_connection.bookings_request_insert("UPDATE bookings set booking_status = 'cancelled' WHERE id = 2","Cancel_Booking");
	}



}
