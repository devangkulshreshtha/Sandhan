import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.api.GoogleAPI;
import com.google.api.client.http.HttpTransport;
import com.google.api.translate.Translate;
import com.google.common.collect.Multiset.Entry;
import com.gtranslate.Language;
import com.gtranslate.Translator;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "My First Servlet", urlPatterns = { "/FirstServlet" , "/FirstServlet.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="pankaj")})
public class QueryManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START="<html><body>";
	public static final String HTML_END="</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();
		String html = get_search_page();
		out.println(html);
		//out.println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Insert title here</title></head><body><br> <form  name=\"myform\" action=\"\" method=\"post\">  Enter query here :<br>  <input type=\"text\" name=\"query\"><br>  <INPUT type=\"submit\" name=\"Submit\" value=\"Sandhan 2.0 Search\"></form>  </body></html>");
	}

	private String get_search_page() {
		// TODO Auto-generated method stub
		String content="";
		try {
			content = new Scanner(new File("/home/maulik/workspace/Transactional Queries/src/searchengine")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(content + "to");
		return content;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String query = request.getParameter("query");
		System.out.println("hmm" + "yo");
		String translated = transliterate(query);
		try {
			sendGet(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, String> ans = MainClass.main(query);
		System.out.println("woohooo");
		PrintWriter out = response.getWriter();
		//out.println(HTML_START + "<h2>Query results</h2><br/><h3>Results=</h3>"+HTML_END);
		String html = get_results_page();
		//String html = HTML_START + "<h2>Query results</h2><br/><h3>Results=</h3>";
		int i=0;
		for (HashMap.Entry<String, String> entry : ans.entrySet()){
			i++;
			html += "<li><a href=\""+entry.getKey() + "\">" + entry.getValue() + "</a></li>";
			//html += "<br/>" + String.valueOf(i) + ".) " + "<a href=\"" + entry.getKey() + "\">" + entry.getValue()+"</a>";
		}
		
		html += "</ol></div</body></html>";
		out.println(html);
	}

	private String get_results_page() {
		// TODO Auto-generated method stub
		String content="";
		try {
			content = new Scanner(new File("/home/maulik/workspace/Transactional Queries/src/results")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(content + "to");
		return content;
	}
	
	public static String transliterate(String input) throws IOException {
		
		return null;
	}
	
	private void sendGet(String input) throws Exception {

		

	}

}