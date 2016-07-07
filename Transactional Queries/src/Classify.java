import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class Classify {

	public static int[] main(String arg) {
		
		arg = arg.toUpperCase();
		String[] query = arg.split(" ");
		// TODO Auto-generated method stub
		int x[] = new int[4];
		
		//Check for 1st class
		
		String cities[] = test_1(arg);
		if(cities[1]!=null) x[0] = 1;
		
		//Check for 2nd class
		
		String[] keywords = {"VIDEO","VIDEOS","AUDIO","AUDIOS"}; //more terms can be added
		int ans=0;
		for(String s : query){
			for(String keyword : keywords){
				if(keyword.equals(s)) x[1]=1;
			}
		}
		
		//Check for 3rd class
		
		String language = GlobalConstants.lang;
		String modified_query="";
		int i=0;
		for(i=0;i<query.length-1;i++) {
			query[i] = query[i].substring(0, 1) + query[i].substring(1).toLowerCase();
			modified_query += query[i]+"_";
		}
		i = query.length-1;
		modified_query += query[i].substring(0, 1) + query[i].substring(1).toLowerCase();
		String pageURL = "https://" + language + ".wikipedia.org/wiki/" + modified_query;
		//System.out.println(pageURL);
		URL url = null;
		try {
			url = new URL(pageURL);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection huc = null;
		try {
			huc = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int responseCode = 0;
		try {
			responseCode = huc.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (responseCode != 404) {
		x[2]=1;
		}
		
		//Check for 4th class
		
		StringBuilder result = new StringBuilder();
		String pageUrl = "http://api.wolframalpha.com/v2/query?appid=W3V6JL-Q2PGHL9HTH&input=" + modify(arg) + "&format=image,plaintext";
		URL url1=null;
	      try {
			url1 = new URL(pageUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("1");
			e.printStackTrace();
		}
	      HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url1.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("2");
			e.printStackTrace();
		}
	      try {
			conn.setRequestMethod("GET");
			conn.setAllowUserInteraction(false);
	        conn.setInstanceFollowRedirects(true);
	        conn.connect();
	        int response = conn.getResponseCode();
	        System.out.println("yoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyo" + response);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block\
			System.out.println("3");
			e.printStackTrace();
		}
	      InputStream is=null;
	      try {
			is = conn.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("3");
			e.printStackTrace();
		}  
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      try {
			while((line = rd.readLine()) != null) {
			    result.append(line);
			    result.append('\r');
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("here boy");
			e.printStackTrace();
		}
	      try {
			rd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("melt it and");
			e.printStackTrace();
		}
		String xml = result.toString();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        InputSource is1;
        try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        is1 = new InputSource(new StringReader(xml));
        Document doc = null;
		try {
			doc = builder.parse(is1);
		} catch (org.xml.sax.SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(doc.getDocumentElement().getAttribute("success").equals("true")) x[3]=1;
		return x;
	}

	private static String modify(String arg) {
		// TODO Auto-generated method stub
		HashMap<CharSequence, CharSequence> hmap = new HashMap<CharSequence, CharSequence>();
		hmap.put(" ", "");
		hmap.put("^", "%5E");
		hmap.put("!", "%21");
		hmap.put("(", "%28");
		hmap.put(")", "%29");
		hmap.put("/", "%2F");
		hmap.put("*", "%2A");
		hmap.put("-", "-");
		hmap.put("+", "%2B");
		CharSequence a = "dcs";
		arg = arg.replaceAll("%", "%25");
		for(Entry<CharSequence, CharSequence> entry : hmap.entrySet()){
			arg = arg.replace(entry.getKey(), entry.getValue());
		}
		return arg;
	}

	public static String[] test_1(String arg) {
		// TODO Auto-generated method stub
		String[] cities=new String[2];
		cities[0]=null;cities[1]=null;
		String[] spl = arg.split(" ");
		int ans=0;
		for(String s : spl) {
			if(s.equals("TO")) ans=1;
			String temp = new CommonFunctions().getCity2(s);
			if(temp!=null){
				if(cities[0]==null) cities[0]=temp;
				else cities[1]=temp;
			}
		}
		if(ans==1) return cities;
		String[] temp = new String[2];
		temp[0]=null;
		temp[1]=null;
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		return temp;
	}

}
