package utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class fileReader {
public String content = null,line;
	
	public String readfile(String fileName) throws Exception {
		//D:\\Eclipse_Workspace\\fadrdemoSerenity\\src\\test\\resources\\Tokens\\
		FileReader f_read = new FileReader("src/test/resources/Tokens/"+fileName);
		BufferedReader b_read = new BufferedReader(f_read);
		 while ((line = b_read.readLine()) != null) {
			 content += line;
		 }
		 b_read.close();
		 f_read.close();
		 content = content.replaceAll("null", "");
		return content;
	}
}
