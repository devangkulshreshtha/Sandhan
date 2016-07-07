import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;


public class Rail {
	
	String city1,city2;
	String date;
	String code1,code2;

	public Rail(String city1 , String city2 , String date) {
		this.city1 = city1;
		this.city2 = city2;
		this.code1 = new CommonFunctions().getCode2(city1);
		this.code2 = new CommonFunctions().getCode2(city2);
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
		String url = "http://erail.in/?T=" + code1 + "::" + code2;
		if(code1==null || code2==null) return  "UNAVAILABLE";
		return url;
	}

}
