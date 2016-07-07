import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;


public class Flight {
	
	String city1,city2;
	String date;
	String code1,code2;

	public Flight(String city1, String city2, String date) {
		this.code1 = getCode(city1);
		this.code2 = getCode(city2);
		this.city1 = city1;
		this.city2 = city2;
		Date datum = new Date(date);
		String day = String.valueOf(datum.getDay());
		String month = String.valueOf(datum.getMonth()+1);
		String year = String.valueOf(datum.getYear());
		if(datum.getDay() < 10) day = "0" + day;
		if(datum.getMonth() < 10) month = "0" + month;
		this.date = year + month + day;
	}
	
	private String getCode(String city) {
		FileInputStream fstream=null;
		try {
			fstream = new FileInputStream("/home/maulik/workspace/Transactional Queries/src/airport_city_codes");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				int i=0;
				for(i = strLine.length()-1;i>=0;i--){
					if(strLine.charAt(i) == ' ') break;
				}
				if(strLine.substring(0, i).equals(city)) return strLine.substring(i+1, strLine.length());
			}
		} catch (IOException e) {
			System.out.println("what just happened...");
		}

		//Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("file cannot be closed..");
		}
		return null;
	}

	public void openConnection() {
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
		// TODO Auto-generated method stub
		String url = "http://www.goibibo.com/#flight-searchresult/%23air-" + code1 + "-" + code2 + "-" + date + "--1-0-0-E";
		if(code1==null || code2==null) return  "UNAVAILABLE";
		return url;
	}

}
