package Wikipedia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import edu.jhu.nlp.wikipedia.PageCallbackHandler;
import edu.jhu.nlp.wikipedia.WikiPage;
import edu.jhu.nlp.wikipedia.WikiXMLParser;
import edu.jhu.nlp.wikipedia.WikiXMLParserFactory;


public class Try1 {
	
	static int i=0;
	static HashMap<String, ArrayList<Integer> > hmap = new HashMap<String, ArrayList<Integer> >();
	public static void main(String[] args) throws IOException   {
		// TODO Auto-generated method stub
	 


			Wikipedia.Search.main("");
			//final Indexer i = new Indexer("/home/dejucoder/WikiParser/wiki.index");
		
		/* 
		System.out.println("here boy");
		  WikiXMLParser wxsp = WikiXMLParserFactory.getSAXParser("/home/maulik/WikiParser/mrwiki-20160601-pages-meta-history.xml.bz2");
		  try {
			  
	            wxsp.setPageCallback(new PageCallbackHandler() {

	            				
	            				
	                           @Override
							public void process(WikiPage page) {
	                        	   
	                        	   String[] title = page.getTitle().split(" ");
	                        	   if(page.getTitle().indexOf(':') == -1) {
	                        		   for(int i=0;i<title.length;i++){
		                        		   if(!hmap.containsKey(title[i])){
		                        			   ArrayList<Integer> budapest = new ArrayList<Integer>();
		                        			   budapest.add(Integer.parseInt(page.getID()));
		                        			   hmap.put(title[i] , budapest);
		                        		   }
		                        		   else hmap.get(title[i]).add(Integer.parseInt(page.getID()));
		                        	   }
	                        	   }
	                        	   
	                        	   
	                        	   }
	            });
	                
	           wxsp.parse();
	           //i.close();
	           
	           Properties properties = new Properties();

	           for (HashMap.Entry<String, ArrayList<Integer> > entry : hmap.entrySet()) {
	        	   String listString = "";

	        	   for (int s : entry.getValue())
	        	   {
	        	       listString += String.valueOf(s) + "\t";
	        	   }
	               properties.put(entry.getKey(), listString);
	           }

	           properties.store(new FileOutputStream("data.properties"), null);

	           
	           System.out.println("done");
	        }catch(Exception e) {
	                e.printStackTrace();
	        }
*/
	}

}
