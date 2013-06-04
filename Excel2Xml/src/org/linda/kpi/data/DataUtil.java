package org.linda.kpi.data;

public class DataUtil {
	public static int parseEducation(String edu) {
		edu=edu.trim();
		if(edu.startsWith("本科"))
			return 1;
		if (edu.startsWith("大专"))
			return 0;
		if (edu.startsWith("硕士"))
			return 2;
		if (edu.startsWith("博士"))
			return 3;
		return 1;
	}
	
	public static String parseSpecial(String special) {
		if (special.startsWith("无"))
			return null;
		return null;
	}
	
	public static String getCategory(String category) {
		switch(category)
		{
		case "测试":
			return "quality";
		case "研究":
			return "research";
		case "开发":
			return "develop";
		case "设计":
			return "design";
		case "产品":
			return"product";
		case "市场营销":
			return "marketing";
		case "客服":
			return "service";
		case "运营（GA）":
			return "operation";
		case "管理":
			return "manager";
		default:
				return "develop";
		}
	}
	
	public static int getExp(String exp)
	{
		int expYear=0;
		try {
			expYear=Integer.parseInt(exp);
		}catch(NumberFormatException e) {
			
		}
		return expYear;
	}
	
	public static int getGrade(String grade) {
	    int gradeNum=0;
        try {
            gradeNum=Integer.parseInt(grade);
        }catch(NumberFormatException e) {
            
        }
        return gradeNum;
	}
}
