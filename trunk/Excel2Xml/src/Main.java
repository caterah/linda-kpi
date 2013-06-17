import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.linda.kpi.GuiHome;
import org.linda.kpi.WeeklyReportData;

public class Main {

	public static void main(String[] args) {
		GuiHome gui = new GuiHome();
		gui.setVisible(true);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");
		TimeZone t = sdf.getTimeZone();
		t.setRawOffset(0);
		sdf.setTimeZone(t);
		Long startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder(
				"<?xml version=\"1.0\" encoding=\"utf-8\"?><recruitments>");
		try {
			WeeklyReportData er = new WeeklyReportData();
			er.reportWeeklyReport("D:\\招聘KPI分析表.xlsx",sb);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		sb.append("</recruitments>");
		
		FileWriter fw;
		try {
			fw = new FileWriter("D:\\recruitments.xml");
			String s = sb.toString();
			fw.write(s, 0, s.length());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Long endTime = System.currentTimeMillis();
		System.out.println("用时:" + sdf.format(new Date(endTime - startTime)));
	}
}