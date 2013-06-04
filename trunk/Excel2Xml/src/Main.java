import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.linda.kpi.WeeklyReportData;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");  
	    TimeZone t = sdf.getTimeZone();  
	    t.setRawOffset(0);  
	    sdf.setTimeZone(t);  
	    Long startTime = System.currentTimeMillis();  
	    StringBuilder sb=new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?><recruitments>");
	    // ������  
	    try {  
	        WeeklyReportData er = new WeeklyReportData();  
	        // ��ȡexcel2007  
	        er.reportWeeklyReport("��ƸKPI������-SH.xlsx",sb);  
	        er.reportWeeklyReport("��ƸKPI������-NJ.xlsx",sb);  
	        er.reportWeeklyReport("��ƸKPI������-HZ.xlsx",sb);  
	    } catch (Exception ex) {  
	        ex.printStackTrace();
	    }  
	    sb.append("</recruitments>");
        System.out.println(sb.toString());
	    Long endTime = System.currentTimeMillis();  
	    System.out.println("��ʱ��" + sdf.format(new Date(endTime - startTime)));
	}
}