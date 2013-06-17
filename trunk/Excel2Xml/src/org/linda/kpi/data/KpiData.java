package org.linda.kpi.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;

public class KpiData {
	private static int serialId = 10000;

	public int id;
	public String type;
	public String category;
	public String grade;
	public String group;
	public String name;
	public String location;
	public String requiredNum;
	public String requirement;
	public String education;
	public String experence;
	public String special;
	public String provideResumes;
	public String passedResumes;
	public String interview;
	public String onBoardNum;
	public String onBoardPeople;
	public String startDate;
	public String finishedDate;
	public String monthCost;
	public String owner;
	public String source;
	
	public String[] onboardPeoples;
	
	private boolean invalidate;
	
	private static Map<String, String> jobMap = new HashMap<String, String>();

	public KpiData(XSSFRow row) {
		try {
			int i=0;
			i++;
			if (row.getCell(i)!=null) {
				type = row.getCell(i).getRichStringCellValue().toString();
				if (!type.equals("全职")&&!type.equals("实习")&&!type.equals("兼职")) {
					invalidate=true;
					return;
				}
			}else {
				invalidate=true;
				return;
			}
			i++;
			category = row.getCell(i).getRichStringCellValue().toString();
			i++;
			grade = row.getCell(i).getRichStringCellValue().toString();
			i++;
			group = row.getCell(i).getRichStringCellValue().toString();
			i++;
			name = row.getCell(i).getRichStringCellValue().toString();
			i++;
			location = row.getCell(i).getRichStringCellValue().toString();
			i++;
			requiredNum = row.getCell(i).getRawValue();
			i++;
			requirement = row.getCell(i).getRichStringCellValue().toString();
			i++;
			education = row.getCell(i).getRichStringCellValue().toString();
			i++;
			experence = row.getCell(i).getRawValue();
			if (Integer.parseInt(experence)>20) {
				experence="0";
			}
			i++;
			special = row.getCell(i).getRichStringCellValue().toString();
			i++;
			provideResumes = row.getCell(i).getRawValue();
			i++;
			passedResumes = row.getCell(i).getRawValue();
			i++;
			interview = row.getCell(i).getRawValue();
			i++;
			onBoardNum = row.getCell(i).getRawValue();
			i++;
			onBoardPeople = row.getCell(i).getRichStringCellValue().toString();
			if (onBoardPeople.equals("无")||onBoardPeople.equals("")) {
				invalidate=true;
				return;
			}
			
			onboardPeoples=DataUtil.onboardPeople(onBoardPeople);
			
			i++;
			try {
				Date d=row.getCell(i).getDateCellValue();
				startDate = String.valueOf(d.getYear()+1900)+"-"+String.valueOf(d.getMonth()+1)+"-"+String.valueOf(d.getDate());
			}catch(Exception e) {
				startDate=row.getCell(i).getRichStringCellValue().toString();
			}
			i++;
			try {
				Date d=row.getCell(i).getDateCellValue();
				finishedDate = String.valueOf(d.getYear()+1900)+"-"+String.valueOf(d.getMonth()+1)+"-"+String.valueOf(d.getDate());
			}catch(Exception e) {
				finishedDate=row.getCell(i).getRichStringCellValue().toString();
			}
			i++;
			monthCost = row.getCell(i).getRawValue();
			i++;
			owner = row.getCell(i).getRichStringCellValue().toString();
			id = ++serialId;
			i++;
			source=row.getCell(i).getRichStringCellValue().toString();
			
			invalidate=false;
			
			jobMap.put(name, name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void traceJobs() {
		Iterator<Map.Entry<String,String>> it=jobMap.entrySet().iterator();
		Entry<String, String> entry;
		while(it.hasNext()) {
			entry=it.next();
			System.out.println("<job description=\""+entry.getValue()+"\" value=\"3\"/>");
		}
	}
	
	public String toXml() {
		if (id == 0)
			return "";
		if (invalidate)
			return "";
		int i,size=onboardPeoples.length;
		if (size==0) {
			return "";
		}
		if (size==1) {
			return toSingleXml(0);
		}
		StringBuilder sb=new StringBuilder("");
		for(i=0;i<size;i++) {
			sb.append(toSingleXml(i));
			if (i!=size-1) {
				id = ++serialId;
			}
		}
		return sb.toString();
	}
	
	private String toSingleXml(int index) {
		StringBuilder sb = new StringBuilder("<recruitment>");

		sb.append("<id>\n");
		sb.append(id);
		sb.append("\n</id>\n");

		sb.append("<name>\n");
		sb.append(type);
		sb.append(":");
		sb.append(name);
		sb.append("\n</name>\n");
		
		sb.append("<job>");
		sb.append(name);
		sb.append("</job>");

		sb.append("<requiredTime>");
		sb.append(0);
		sb.append("</requiredTime>");

		sb.append("<startDate>");
		sb.append(startDate);
		sb.append("</startDate>");

		sb.append("<finishedDate>");
		sb.append(finishedDate);
		sb.append("</finishedDate>");

		sb.append("<months>");
		sb.append(Float.valueOf(monthCost)/onboardPeoples.length);
		sb.append("</months>");

		sb.append("<group>");
		sb.append(group.toLowerCase());
		sb.append("</group>");

		sb.append("<location>");
		sb.append(location.toLowerCase());
		sb.append("</location>");

		sb.append("<resume_provide>");
		sb.append(Math.ceil(Integer.valueOf(provideResumes)/onboardPeoples.length));
		sb.append("</resume_provide>");

		sb.append("<resume_passsed>");
		sb.append(Math.ceil(Integer.valueOf(passedResumes)/onboardPeoples.length));
		sb.append("</resume_passsed>");

		sb.append("<interview>");
		sb.append(Math.ceil(Integer.valueOf(interview)/onboardPeoples.length));
		sb.append("</interview>");

		sb.append("<education>");
		sb.append(DataUtil.parseEducation(education));
		sb.append("</education>");

		sb.append("<special>");
		sb.append(special);
		sb.append("</special>");
		
		sb.append("<requirement>");
		sb.append(requirement);
		sb.append("</requirement>");

		String cat=DataUtil.getCategory(category);
		if (type.equals("实习"))
			cat="intern";
		sb.append("<tech select=\"");
		sb.append(cat);
		sb.append("\">");
		sb.append("</tech>");

		sb.append("<offer>");
		sb.append(Math.ceil(Integer.valueOf(onBoardNum)/onboardPeoples.length));
		sb.append("</offer>");
		
		sb.append("<onBoardPeople>");
		sb.append(onBoardPeople);
		sb.append("</onBoardPeople>");
		
		sb.append("<onBoardNum>");
		sb.append(Math.ceil(Integer.valueOf(onBoardNum)/onboardPeoples.length));
		sb.append("</onBoardNum>");

		sb.append("<exp>");
		sb.append(experence);
		sb.append("</exp>");

		sb.append("<grade>");
		sb.append(12);
		sb.append("</grade>");

		sb.append("<category>");
		sb.append(category);
		sb.append("</category>");
		
		sb.append("<owner>");
		sb.append(owner);
		sb.append("</owner>");

		sb.append("</recruitment>");

		return sb.toString();
	}
}
