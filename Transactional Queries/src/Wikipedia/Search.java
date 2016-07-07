package Wikipedia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Search {

	public static void main(String arg) {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<Integer>> hmap = new HashMap<String, ArrayList<Integer>>();
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("/home/dejucoder/data.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found..!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int deju=0;
		for (String key : properties.stringPropertyNames()) {
			String val1 = properties.get(key).toString();
			String[] val= val1.split("\t");
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<val.length;i++){
				arr.add(Integer.parseInt(val[i]));
			}
			
			if(arr.size()>1) deju ++;
		   hmap.put(key, arr);
		}
		System.out.println(hmap.size());
		System.out.println(deju);
	}

}
