import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;


public class CommonFunctions {

	public CommonFunctions() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDate(String text){
		String[] query = text.split(" ");
		for(String s : query){
			Date date = new Date(s);
			if(date.time!=null) return s;
		}
		return null;
	}
	
	public void openConnection(String url) {
		System.out.println(url);
		// TODO Auto-generated method stub
		if(Desktop.isDesktopSupported())
		{
		  try {
			Desktop.getDesktop().browse(new URI(url));
		  } catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		}
	}
	
	public String getCity2(String text) {
		
		FileInputStream fstream=null;
		try {
			System.out.println(new File(".").getAbsolutePath());
			fstream = new FileInputStream("/home/maulik/cities.txt");
		} catch (FileNotFoundException e) {
			//System.out.println("file not found ..");
			System.out.println(new File(".").getAbsolutePath());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				if(strLine.equals(text)) return text;
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
		
		fstream=null;
		try {
			fstream = new FileInputStream("/home/maulik/Transactional Queries/src/city_codes");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		br = new BufferedReader(new InputStreamReader(fstream));
		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				String[] str = strLine.split(" ");
				String combined = "";
				for(int i=0;i<str.length-1;i++) combined += str[i];
				if(combined.equals(text.replaceAll("\\s+",""))) return str[0];
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
		
		fstream=null;
		try {
			fstream = new FileInputStream("/home/maulik/Transactional Queries/src/states_capitals");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		br = new BufferedReader(new InputStreamReader(fstream));

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null) {
				String[] str = strLine.split(" ");
				String combined = "";
				for(int i=0;i<str.length-1;i++) combined += str[i];
				if(combined.equals(text.replaceAll("\\s+",""))) return str[str.length-1];
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
	
	public String getCity(String text){
		
		FileInputStream fstream=null;
		try {
			fstream = new FileInputStream("/home/maulik/Transactional Queries/src/city_codes");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				String[] splited = strLine.split("\\s+");
				int l = splited.length;
				for(int i=0;i<l-1;i++) if(splited[i].equals(text)) return text;
				String combined = "";
				for(int i=0;i<l-1;i++) combined += splited[i];
				if(combined.equals(text.replaceAll("\\s+",""))) return splited[0];
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
		
		FileInputStream fstream2=null;
		try {
			fstream2 = new FileInputStream("/home/maulik/Transactional Queries/src/states_capitals");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));

		String strLine2;

		//Read File Line By Line
		try {
			while ((strLine2 = br2.readLine()) != null)   {
				String[] splited2 = strLine2.split("\\s+");
				int l2 = splited2.length;
				String combined2 = "";
				for(int i=0;i<l2-1;i++) combined2 += splited2[i];
				if(combined2.equals(text.replaceAll("\\s+",""))) return splited2[l2-1];
			}
			
		} catch (IOException e) {
			System.out.println("what just happened2...");
		}

		//Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("file cannot be closed2.");
		}
		
		return null;
	}
	
	public String getCode2(String text){
		FileInputStream fstream=null;
		try {
			fstream = new FileInputStream("/home/maulik/Transactional Queries/src/city_codes");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				String[] splited = strLine.split("\\s+");
				int l = splited.length;
				for(int i=0;i<l-1;i++) if(splited[i].equals(text)) return splited[l-1];
				String combined = "";
				for(int i=0;i<l-1;i++) combined += splited[i];
				if(combined.equals(text.replaceAll("\\s+",""))) return splited[l-1];
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
		
		fstream=null;
		try {
			fstream = new FileInputStream("/home/maulik/Transactional Queries/src/states_capitals");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		br = new BufferedReader(new InputStreamReader(fstream));

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				String[] splited = strLine.split("\\s+");
				int l = splited.length;
				String combined = "";
				for(int i=0;i<l-1;i++) combined += splited[i];
				if(combined.equals(text.replaceAll("\\s+",""))) return getCode2(splited[l-1]);
			}
			
		} catch (IOException e) {
			System.out.println("what just happened2...");
		}

		//Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("file cannot be closed2.");
		}
		
		return null;
	}
	
	public String getCode(String text){
		FileInputStream fstream=null;
		try {
			fstream = new FileInputStream("/home/maulik/Transactional Queries/src/city_codes");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				String[] splited = strLine.split("\\s+");
				int l = splited.length;
				for(int i=0;i<l-1;i++) if(splited[i].equals(text)) return splited[l-1];
				String combined = "";
				for(int i=0;i<l-1;i++) combined += splited[i];
				if(combined.equals(text.replaceAll("\\s+",""))) return splited[l-1];
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
		
		FileInputStream fstream2=null;
		try {
			fstream2 = new FileInputStream("/home/maulik/Transactional Queries/src/states_capitals");
		} catch (FileNotFoundException e) {
			System.out.println("file not found ..");
		}
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));

		String strLine2;

		//Read File Line By Line
		try {
			while ((strLine2 = br2.readLine()) != null)   {
				String[] splited2 = strLine2.split("\\s+");
				int l2 = splited2.length;
				String combined2 = "";
				for(int i=0;i<l2-1;i++) combined2 += splited2[i];
				if(combined2.equals(text.replaceAll("\\s+",""))) {
					System.out.println(splited2[l2-1]);
					return getCode(splited2[l2-1]);
				}
			}
			
		} catch (IOException e) {
			System.out.println("what just happened2...");
		}

		//Close the input stream
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("file cannot be closed2.");
		}
		
		return null;
	}

}
