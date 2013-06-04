package org.linda.kpi.data;

public class DataUtil {
	public static int parseEducation(String edu) {
		edu=edu.trim();
		if(edu.startsWith("����"))
			return 1;
		if (edu.startsWith("��ר"))
			return 0;
		if (edu.startsWith("˶ʿ"))
			return 2;
		if (edu.startsWith("��ʿ"))
			return 3;
		return 1;
	}
	
	public static String parseSpecial(String special) {
		if (special.startsWith("��"))
			return null;
		return null;
	}
	
	public static String getCategory(String category) {
		switch(category)
		{
		case "����":
			return "quality";
		case "�о�":
			return "research";
		case "����":
			return "develop";
		case "���":
			return "design";
		case "��Ʒ":
			return"product";
		case "�г�Ӫ��":
			return "marketing";
		case "�ͷ�":
			return "service";
		case "��Ӫ��GA��":
			return "operation";
		case "����":
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
