package org.linda.kpi;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class XmlFileGenerator {

	public XmlFileGenerator() {
	}
	
	public void generate(String path,String content) {
		FileWriter fw;
		try {
			fw = new FileWriter(path);
			fw.write(content, 0, content.length());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
