import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
		StringBuilder sb = new StringBuilder(
				"<?xml version=\"1.0\" encoding=\"utf-8\"?><recruitments>");
		// ������
		try {
			WeeklyReportData er = new WeeklyReportData();
			// ��ȡexcel2007
			er.reportWeeklyReport("��ƸKPI������-SH.xlsx", sb);
			er.reportWeeklyReport("��ƸKPI������-NJ.xlsx", sb);
			er.reportWeeklyReport("��ƸKPI������-HZ.xlsx", sb);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		sb.append("</recruitments>");

		FileWriter fw;
		try {
			fw = new FileWriter("D:\\workspace\\kpi\\Excel2Xml\\bin\\datarecruitments.xml");
			String s = sb.toString();
			fw.write(s, 0, s.length());
			fw.flush();
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream("D:\\workspace\\kpi\\Excel2Xml\\bin\\datarecruitments.xml"),"UTF-8");
			osw.write(s, 0, s.length());
			osw.flush();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream("hello3.txt")), true);
			pw.println(s);
			osw.close();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Long endTime = System.currentTimeMillis();
		System.out.println("��ʱ��" + sdf.format(new Date(endTime - startTime)));
	}
}