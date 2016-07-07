import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;  

public class Date {
	
	int day,month,year,week;
	int dayOfMonth, monthOfYear,curryear, weekOfMonth;
	Calendar time;
	Calendar timenow;
	
	public Date(String raw_date) {
		// TODO Auto-generated constructor stub
		Map m1 = new HashMap<>();
		m1.put("JANUARY","0");
		m1.put("FEBRUARY","1");
		m1.put("MARCH","2");
		m1.put("APRIL","3");
		m1.put("MAY","4");
		m1.put("JUNE","5");
		m1.put("JULY","6");
		m1.put("AUGUST","7");
		m1.put("SEPTEMBER","8");
		m1.put("OCTOBER","9");
		m1.put("NOVEMBER","10");
		m1.put("DECEMBER","11");
		m1.put("JAN","0");
		m1.put("FEB","1");
		m1.put("MAR","2");
		m1.put("APR","3");
		m1.put("MAY","4");
		m1.put("JUN","5");
		m1.put("JUL","6");
		m1.put("AUG","7");
		m1.put("SEP","8");
		m1.put("SEPT","8");
		m1.put("OCT","9");
		m1.put("NOV","10");
		m1.put("DEC","11");
		Calendar calendar = Calendar.getInstance();
		dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		monthOfYear = calendar.get(Calendar.MONTH);
		curryear = calendar.get(Calendar.YEAR);
		weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		timenow = calendar;
		if(raw_date.equals("NEXT_WEEK")){
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 7);
			time = cal;
		}
		else if(raw_date.equals("NEXT_MONTH")){
			Calendar cal = Calendar.getInstance();
		    int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    cal.add(Calendar.DATE, days);
			time = cal;
		}
		else if(raw_date.equals("TODAY")){
			Calendar cal = Calendar.getInstance();
			time = cal;
		}
		else if(raw_date.equals("TOMORROW")){
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			time = cal;
		}
		else if(raw_date.equals("DAY_AFTER_TOMORROW")){
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 2);
			time = cal;
		}
		else if(Pattern.matches("(\\d{1,2}?)-([A-Z]+)", raw_date)){
			Pattern pattern = Pattern.compile("(\\d{1,2}?)-([A-Z]+)");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
			}
			if(!m1.containsKey(x2)){
				System.out.println("Date format not supported");
			}
			time = getTime(x1,m1.get(x2).toString(),String.valueOf(curryear));
		}
		else if(Pattern.matches("(\\d{1,2}?)/([A-Z]+)", raw_date)){
			Pattern pattern = Pattern.compile("(\\d{1,2}?)/([A-Z]+)");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
			}
			if(!m1.containsKey(x2)){
				System.out.println("Date format not supported");
			}
			time = getTime(x1,m1.get(x2).toString(),String.valueOf(curryear));
		}
		else if(Pattern.matches("(\\d{1,2}?) ([A-Z]+)", raw_date)){
			Pattern pattern = Pattern.compile("(\\d{1,2}?) ([A-Z]+)");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
			}
			if(!m1.containsKey(x2)){
				System.out.println("Date format not supported");
			}
			time = getTime(x1,m1.get(x2).toString(),String.valueOf(curryear));
		}
		else if(Pattern.matches("(\\d{1,4}?)-(\\d{1,4})-(\\d{1,4})", raw_date)){
			System.out.println(1);
			Pattern pattern = Pattern.compile("(\\d{1,4}?)-(\\d{1,4})-(\\d{1,4})");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null,x3=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
				x3 = matcher.group(3);
			}
			time = getTime(x1,String.valueOf(Integer.parseInt(x2)-1),x3);
		}
		else if(Pattern.matches("(\\d{1,4}?)/(\\d{1,4})/(\\d{1,4})", raw_date)){
			System.out.println(2);
			Pattern pattern = Pattern.compile("(\\d{1,4}?)/(\\d{1,4})/(\\d{1,4})");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null,x3=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
				x3 = matcher.group(3);
			}
			time = getTime(x1,String.valueOf(Integer.parseInt(x2)-1),x3);
		}
		else if(Pattern.matches("(\\d{1,4}?) (\\d{1,4}) (\\d{1,4})", raw_date)){
			System.out.println(3);
			Pattern pattern = Pattern.compile("(\\d{1,4}?) (\\d{1,4}) (\\d{1,4})");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null,x3=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
				x3 = matcher.group(3);
			}
			time = getTime(x1,String.valueOf(Integer.parseInt(x2)-1),x3);
		}
		else if(Pattern.matches("(\\d{1,4}?)-([A-Z]+)-(\\d{1,4})", raw_date)){
			System.out.println(4);
			Pattern pattern = Pattern.compile("(\\d{1,4}?)-([A-Z]+)-(\\d{1,4})");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null,x3=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
				x3 = matcher.group(3);
			}
			if(!m1.containsKey(x2)){
				System.out.println("Date format not supported");
			}
			time = getTime(x1,m1.get(x2).toString(),x3);
		}
		else if(Pattern.matches("(\\d{1,4}?)/([A-Z]+)/(\\d{1,4})", raw_date)){
			System.out.println(5);
			Pattern pattern = Pattern.compile("(\\d{1,4}?)/([A-Z]+)/(\\d{1,4})");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null,x3=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
				x3 = matcher.group(3);
			}
			if(!m1.containsKey(x2)){
				System.out.println("Date format not supported");
			}
			time = getTime(x1,m1.get(x2).toString(),x3);
		}
		else if(Pattern.matches("(\\d{1,4}?) ([A-Z]+) (\\d{1,4})", raw_date)){
			System.out.println(6);
			Pattern pattern = Pattern.compile("(\\d{1,4}?) ([A-Z]+) (\\d{1,4})");
			Matcher matcher = pattern.matcher(raw_date);
			String x1=null,x2=null,x3=null;
			while(matcher.find()){
				x1 = matcher.group(1);
				x2 = matcher.group(2);
				x3 = matcher.group(3);
			}
			if(!m1.containsKey(x2)){
				System.out.println("Date format not supported");
			}
			time = getTime(x1,m1.get(x2).toString(),x3);
		}
		else{
			time=null;
		}
		
	}

	private Calendar getTime(String x1, String x2, String x3) {
		if(x1.length()==4){
			if(Integer.parseInt(x1) < curryear) {
				System.out.println("Date format not supported");
			}
			if(Integer.parseInt(x2)<monthOfYear && Integer.parseInt(x1) == curryear){
				System.out.println("Date format not supported");
			}
			if(Integer.parseInt(x3)<dayOfMonth  && Integer.parseInt(x2)==monthOfYear && Integer.parseInt(x1)==curryear){
				System.out.println("Date format not supported");
			}
			Calendar cal = Calendar.getInstance();
		    cal.clear();
		    cal.set(Calendar.YEAR, Integer.parseInt(x1));
		    cal.set(Calendar.MONTH, Integer.parseInt(x2));
		    cal.set(Calendar.DATE, Integer.parseInt(x3));
		    
		    return cal;
		}
		else{
			if(x3.length()==2){
				x3 = "20" + x3;
			}
			if(Integer.parseInt(x3) < curryear) {
				System.out.println("Date format not supported");
			}
			if(Integer.parseInt(x2)<monthOfYear && Integer.parseInt(x3) == curryear){
				System.out.println("Date format not supported");
			}
			if(Integer.parseInt(x1)<dayOfMonth  && Integer.parseInt(x2)==monthOfYear && Integer.parseInt(x3)==curryear){
				System.out.println("Date format not supported");
			}
			Calendar cal = Calendar.getInstance();
		    cal.clear();
		    cal.set(Calendar.YEAR, Integer.parseInt(x3));
		    cal.set(Calendar.MONTH, Integer.parseInt(x2));
		    cal.set(Calendar.DATE, Integer.parseInt(x1));
		    return cal;
		}
	}

	public int getWeek() {
		// TODO Auto-generated method stub
		return time.get(Calendar.WEEK_OF_MONTH);
	}

	public int getYear() {
		// TODO Auto-generated method stub
		return time.get(Calendar.YEAR);
	}

	public int getMonth() {
		// TODO Auto-generated method stub
		return time.get(Calendar.MONTH);
	}

	public int getDay() {
		// TODO Auto-generated method stub
		return time.get(Calendar.DAY_OF_MONTH);
	}

}
