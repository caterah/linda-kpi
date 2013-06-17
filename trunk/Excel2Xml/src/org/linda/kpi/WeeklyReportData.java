package org.linda.kpi;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.linda.kpi.data.KpiData;

public class WeeklyReportData {
	private static final String REPORT = "D:\\";

	private ArrayList<KpiData> datas;
	
	@SuppressWarnings("deprecation")
	public void reportWeeklyReport(String report,StringBuilder sb) {
		XSSFWorkbook xwb;
		try{
            xwb = new XSSFWorkbook(report);
            XSSFSheet sheet = xwb.getSheetAt(0);
            int total=sheet.getPhysicalNumberOfRows();
            KpiData data;
            datas=new ArrayList<KpiData>();
            for (int i=13;i<total;i++) {
                if (sheet.getRow(i)!=null) {
                    data=new KpiData(sheet.getRow(i));
                    datas.add(data);
                    sb.append(data.toXml());
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
	}
}
