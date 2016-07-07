import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class main {

	public static HashMap<String, String> main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		HashMap<String, String> ans = new HashMap<String, String>();
		String city1 = args[0] , city2 = args[1] , date = args[2];
		if(date==null) date = "TODAY";
		System.out.println(city1);
		System.out.println(city2);
		System.out.println(date);
		
		Rail rail = new Rail(city1,city2,date);
		String temp = rail.getUrl();
		if(!temp.equals("UNAVAILABLE")) ans.put(temp, city1 + " to " + city2 + " train bookings");
		
		Bus bus = new Bus(city1,city2,date);
		temp = bus.getUrl();
		if(!temp.equals("UNAVAILABLE")) ans.put(temp, city1 + " to " + city2 + " bus bookings");
		
		Flight flight = new Flight(city1,city2,date);
		temp = flight.getUrl();
		if(!temp.equals("UNAVAILABLE")) ans.put(temp, city1 + " to " + city2 + " flight bookings");
		return ans;
	}

}
