import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import com.google.api.services.youtube.YouTube;

public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	public static HashMap<String, String> main(String arg) {
		// TODO Auto-generated method stub
		System.out.println("Enter a query:");
		Scanner reader = new Scanner(System.in);
		HashMap<String, String> ans = new HashMap<String, String>();
		HashMap<String, String> ans1 = new HashMap<String, String>();
		HashMap<String, String> ans2 = new HashMap<String, String>();
		HashMap<String, String> ans3 = new HashMap<String, String>();
		HashMap<String, String> ans4 = new HashMap<String, String>();
		
		String query = arg.toUpperCase();
		int[] x = Classify.main(query);
		if(x[0]==1){
			String[] cities = new String[3];
			cities[0] = new Classify().test_1(query)[0];
			cities[1] = new Classify().test_1(query)[1];
			cities[2] = new CommonFunctions().getDate(query);
			try {
				ans1 = main.main(cities);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(x[1]==1){
			System.out.println("yoyoyoyoyoyoyoyo");
			ans2 = Youtube.main.main(query);
		}
		if(x[2]==1){
			String language = GlobalConstants.lang;
			String modified_query="";
			int i=0;
			String[] qbreak = query.split(" ");
			for(i=0;i<qbreak.length-1;i++) {
				qbreak[i] = qbreak[i].substring(0, 1) + qbreak[i].substring(1).toLowerCase();
				modified_query += qbreak[i]+"_";
			}
			i = qbreak.length-1;
			modified_query += qbreak[i].substring(0, 1) + qbreak[i].substring(1).toLowerCase();
			String pageURL = "http://" + language + ".wikipedia.org/wiki/" + modified_query;
			ans3.put(pageURL, "Wikipedia : " + modified_query);
		}
		if(x[3]==1){
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
			query = query.replaceAll("%", "%25");
			for(Entry<CharSequence, CharSequence> entry : hmap.entrySet()){
				query = query.replace(entry.getKey(), entry.getValue());
			}
			String url = "https://www.wolframalpha.com/input/?i=" + query;
			ans4.put(url, "Wolframalpha Computation");
		}
		for (HashMap.Entry<String, String> entry : ans1.entrySet())  ans.put(entry.getKey(), entry.getValue());
		for (HashMap.Entry<String, String> entry : ans2.entrySet())  ans.put(entry.getKey(), entry.getValue());
		for (HashMap.Entry<String, String> entry : ans3.entrySet())  ans.put(entry.getKey(), entry.getValue());
		for (HashMap.Entry<String, String> entry : ans4.entrySet())  ans.put(entry.getKey(), entry.getValue());
		return ans;
	}

}
