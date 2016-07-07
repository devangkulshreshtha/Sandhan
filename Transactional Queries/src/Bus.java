import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Bus {
	
	String city1,city2;
	String date;
	String code1,code2;

	public Bus(String city1, String city2, String date) {
		// TODO Auto-generated constructor stub
		this.city1 = city1;
		this.city2 = city2;
		Date datum = new Date(date);
		String day = String.valueOf(datum.getDay());
		String month = String.valueOf(datum.getMonth()+1);
		String year = String.valueOf(datum.getYear());
		if(datum.getDay() < 10) day = "0" + day;
		if(datum.getMonth() < 10) month = "0" + month;
		this.date = year + "-" + month + "-" + day;
	}

	public void openConnection() {
		// TODO Auto-generated method stub
		if(Desktop.isDesktopSupported())
		{
		  String url = getUrl();
		  System.out.println(url);
		  try {
			Desktop.getDesktop().browse(new URI(url));
		  } catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		}
	}

	public String getUrl() {
		
		String source = city1.substring(0, 1) + city1.substring(1).toLowerCase();
		String dest = city2.substring(0, 1) + city2.substring(1).toLowerCase();
		String url = "https://paytm.com/bus-tickets/search/" + source + "/" + dest + "/" + date;
		
		return url;
	}

}
