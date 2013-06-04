package org.linda.kpi;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.linda.kpi.data.KpiData;

public class WeeklyReportData {
	private static final String REPORT = "D:\\workspace\\kpi\\Excel2Xml\\bin\\data\\";

	@SuppressWarnings("deprecation")
	public void reportWeeklyReport(String report,StringBuilder sb) {
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb;
		try{
            xwb = new XSSFWorkbook(REPORT+report);
            // 读取第一章表格内容
            XSSFSheet sheet = xwb.getSheetAt(0);
            // 定义 row、cell
            int total=sheet.getPhysicalNumberOfRows();
            KpiData data;
            for (int i=16;i<total;i++) {
                if (sheet.getRow(i)!=null) {
                    data=new KpiData(sheet.getRow(i));
                    sb.append(data.toXml());
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
	}
}
