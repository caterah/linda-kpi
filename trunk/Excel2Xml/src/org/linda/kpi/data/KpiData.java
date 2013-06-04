package org.linda.kpi.data;

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
	public int requiredNum;
	public String requirement;
	public String education;
	public int experence;
	public String special;
	public String language;
	public String systems;
	public String mobile;
	public String tools;
	public int provideResumes;
	public int passedResumes;
	public int interview;
	public int onBoardNum;
	public String onBoardPeople;
	public String startDate;
	public String finishedDate;
	public String monthCost;
	public String owner;
	
	private boolean invalidate;

	public KpiData(XSSFRow row) {
		try {
			int i=0;
			i++;
			if (row.getCell(i)!=null) {
				type = row.getCell(i).getRichStringCellValue().toString();
				if (!type.equals("实习")&&!type.equals("全职")&&!type.equals("兼职")) {
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
			requiredNum = (int) (row.getCell(i).getNumericCellValue());
			i++;
			requirement = row.getCell(i).getRichStringCellValue().toString();
			i++;
			education = row.getCell(i).getRichStringCellValue().toString();
			i++;
			experence = DataUtil.getExp(row.getCell(i).getRawValue());
			i++;
			special = row.getCell(i).getRichStringCellValue().toString();
			i++;
			language = row.getCell(i).getRichStringCellValue().toString();
			i++;
			systems = row.getCell(i).getRichStringCellValue().toString();
			i++;
			mobile = row.getCell(i).getRichStringCellValue().toString();
			i++;
			tools = row.getCell(i).getRichStringCellValue().toString();
			i++;
			provideResumes = (int) row.getCell(i).getNumericCellValue();
			i++;
			passedResumes = (int) row.getCell(i).getNumericCellValue();
			i++;
			interview = (int) row.getCell(i).getNumericCellValue();
			i++;
			onBoardNum = (int) row.getCell(i).getNumericCellValue();
			i++;
			onBoardPeople = row.getCell(i).getRichStringCellValue().toString();
			i++;
			startDate = String.valueOf(row.getCell(i).getRawValue());
			i++;
			finishedDate = String
					.valueOf(row.getCell(i).getRawValue());
			i++;
			monthCost = row.getCell(i).getRawValue();
			i++;
			owner = row.getCell(i).getRichStringCellValue().toString();
			id = ++serialId;
			invalidate=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toXml() {
		if (id == 0)
			return "";
		if (invalidate)
			return "";

		StringBuilder sb = new StringBuilder("<recruitment>");

		sb.append("<id>");
		sb.append(id);
		sb.append("</id>");

		sb.append("<name>");
		sb.append(type);
		sb.append(":");
		sb.append(name);
		sb.append("</name>");

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
		sb.append(monthCost);
		sb.append("</months>");

		sb.append("<group>");
		sb.append(group.toLowerCase());
		sb.append("</group>");

		sb.append("<location>");
		sb.append(location.toLowerCase());
		sb.append("</location>");

		sb.append("<resume_provide>");
		sb.append(provideResumes);
		sb.append("</resume_provide>");

		sb.append("<resume_passsed>");
		sb.append(passedResumes);
		sb.append("</resume_passsed>");

		sb.append("<interview>");
		sb.append(interview);
		sb.append("</interview>");

		sb.append("<education>");
		sb.append(DataUtil.parseEducation(education));
		sb.append("</education>");

		sb.append("<special>");
		sb.append(special);
		sb.append("</special>");

		String cat=DataUtil.getCategory(category);
		if (type.equals("实习"))
			cat="intern";
		sb.append("<tech select=\"");
		sb.append(cat);
		sb.append("\">");
		sb.append("</tech>");

		sb.append("<offer>");
		sb.append(onBoardNum);
		sb.append("</offer>");

		sb.append("<exp>");
		sb.append(experence);
		sb.append("</exp>");

		sb.append("<grade>");
		sb.append(DataUtil.getGrade(grade));
		sb.append("</grade>");

		sb.append("<category>");
		sb.append("senior");
		sb.append("</category>");

		sb.append("</recruitment>");

		return sb.toString();
	}
}
