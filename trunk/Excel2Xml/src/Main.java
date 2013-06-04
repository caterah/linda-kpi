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
	    // 检测代码  
	    try {  
	        WeeklyReportData er = new WeeklyReportData();  
	        // 读取excel2007  
	        er.reportWeeklyReport("招聘KPI分析表-SH.xlsx",sb);  
	        er.reportWeeklyReport("招聘KPI分析表-NJ.xlsx",sb);  
	        er.reportWeeklyReport("招聘KPI分析表-HZ.xlsx",sb);  
	    } catch (Exception ex) {  
	        ex.printStackTrace();
	    }  
	    sb.append("</recruitments>");
        System.out.println(sb.toString());
	    Long endTime = System.currentTimeMillis();  
	    System.out.println("用时：" + sdf.format(new Date(endTime - startTime)));
	}
}